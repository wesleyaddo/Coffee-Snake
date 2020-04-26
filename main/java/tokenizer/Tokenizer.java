package tokenizer;

import parserator.ParserConnector;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Tokenizer
{
    private static final Logger LOGGER = Logger.getLogger(Tokenizer.class.getName());

    Token firstToken;
    Token previousToken;

    public Tokenizer()
    {
        firstToken = null;
        previousToken = null;
    }

    public Token getFirstToken() {
        return firstToken;
    }

    public List<String> readFileLineByLine()
    {
        LOGGER.info("Tokenizer is reading in java file lines");
        List<String> javaCode = new ArrayList<>();
        try (BufferedReader javaCodeFileReader = new BufferedReader(new FileReader("javaCode.txt")))
        {
            String sCurrentLine;
            while ((sCurrentLine = javaCodeFileReader.readLine()) != null)
            {
                javaCode.add(sCurrentLine.trim());
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return javaCode;
        //LOGGER.info(javaCode);
    }

    public List<String> convertLineToTokenSentence(String line)
    {
        LOGGER.info("Tokenizer is converting java file lines to Token Sentences");
        if(line.startsWith("for"))
        {
            String[] array = line.split("(?=[{])|(?<=[{])|(?=})|(?<=})");
            for (String element : array)
            {
//                System.out.println(element);
            }
            return Arrays.asList(array);

        } else {
            String[] array = line.split("(?=;)|(?<=;)|(?=[{])|(?<=[{])|(?=})|(?<=})");

            for (String element : array)
            {
//                System.out.println(element);
            }

            return Arrays.asList(array);
        }
    }

    public List<String> assembleTokenSentences(List<String> javaLines)
    {
        LOGGER.info("Tokenizer is assembling Token Sentences");
        List<String> tokenList = new ArrayList<>();
        javaLines.stream().forEach(javaLine ->
        {
            tokenList.addAll(convertLineToTokenSentence(javaLine));
        });

        return tokenList;
    }

    //Added ; might remove
    public String[] convertTokenSentenceToTokenWords(String javaLine){
        LOGGER.info("Tokenizer is converting Token Sentences to Token Words");
        // space | ( | ) | " | , | > | < | = | + if next to a letter or int | - if next to a letter or int
        String[] tokens1 = javaLine.split("\\s+");
        List<String> tokenString = new ArrayList<>();
        for (String token: tokens1)
        {
            String[] array = token.split("(?=[(])|(?<=[(])|(?=[)])|(?<=[)])|" +
                    "(?=,)|(?<=,)|(?=>)|(?<=>)|(?=<)|(?<=<)|(?=[=])|(?<=[=])|(?<=[a-z0-9])(?=[+])|(?<=[+])(?=[a-z0-9])|" +
                    "(?<=[a-z0-9])(?=-)|(?<=-)(?=[a-z0-9])|(?=[*])|(?<=[*])|(?=[;])|(?<=[;])|" +
                    "(?<=[a-z0-9A-Z])(?=[/])|(?<=[/])(?=[a-z0-9A-Z])");

            //|(?<=[a-z0-9])(?=[/])|(?<=[/])(?=[a-z0-9])

            tokenString.addAll(Arrays.asList(array));
        }

//        String[] tokens = javaLine.split("\\s+|(?=[(])|(?<=[(])|(?=[)])|(?<=[)])|(?=\")|(?<=\")|" +
//                "(?=,)|(?<=,)|(?=>)|(?<=>)|(?=<)|(?<=<)|(?=[=])|(?<=[=])|(?<=[a-z0-9])(?=[+])|(?<=[+])(?=[a-z0-9])|" +
//                "(?<=[a-z0-9])(?=-)|(?<=-)(?=[a-z0-9])|(?=[*])|(?<=[*])|(?=[;])|(?<=[;])" );

//        UNCOMMENT THIS TO PRINT
//        for(String element: tokenString)
//        {
//            System.out.println(element);
//        }
        return tokenString.stream().toArray(String[]::new);
    }

    public void buildTokenLinkedList()
    {
        LOGGER.info("Tokenizer is building the token linked list");
        List<String> tokenList = assembleTokenSentences(readFileLineByLine());
        int iterator = 0;

        for(String tokenListItem: tokenList)
        {
            String[] tokenWords = convertTokenSentenceToTokenWords(tokenListItem);
            Token token = new Token();
            token.setTokens(tokenWords);
            token.setType(labelTokenType(tokenWords));
            if(previousToken != null)
            {
                previousToken.setNextToken(token);
                previousToken = token;
            }
            if(iterator == 0){
                firstToken = token;
                previousToken = token;
                iterator++;
            }
        }
    }
    public String labelTokenType(String[] tokens)
    {
        LOGGER.info("Tokenizer is giving each Token a Type");
        List<String> list = Arrays.asList(tokens);
        if(list.contains("//"))
        {
            return "lineComment";
        }
        if(list.contains("/*"))
        {
            return "startBlockComment";
        }
        if(list.contains("*/"))
        {
            return "endBlockComment";
        }
        if(list.contains("public") && list.contains("static") && list.contains("void") && list.contains("main"))
        {
            return "mainMethod";
        }
        if(list.contains("public")||list.contains("private")||list.contains("void")||list.contains("protected")||list.contains("static"))
        {
            return "function";
        }
        if(list.contains("System.out.println") || list.contains("System.out.print"))
        {
            return "print";
        }
        if(list.contains("class")){
            return "class";
        }
        if(list.contains("else") && list.contains("if"))
        {
            return "elseif";
        }
        if(list.contains("if"))
        {
            return "if";
        }
        if(list.contains("else") && !list.contains("if"))
        {
            return "else";
        }

        if(list.contains("for"))
        {
            return "forloop";
        }
        if(list.contains("while"))
        {
            return "whileloop";
        }
        if(list.contains("int") || list.contains("String")  || list.contains("double") || list.contains("char") ||
                list.contains("float") && !list.contains("for") && !list.contains("while") && !list.contains("if") &&
                        !list.contains("else"))
        {
            return "variable";
        }
        if(list.contains("{"))
        {
            return "openCurlyBraces";
        }
        if(list.contains("}"))
        {
            return "closeCurlyBraces";
        }
        if(list.contains(";"))
        {
            return "semi";
        }
        if(list.contains("switch"))
        {
            return "switch";
        }
        if(list.contains("case"))
        {
            return "case";
        }
        if(list.contains("break"))
        {
            return "break";
        }
        if(list.contains("default") || list.contains("default:"))
        {
            return "default";
        }
        if(list.contains(":"))
        {
            return "colon";
        }
        return null;
    }

    public static void main(String[] args) {
        Tokenizer tokenizer = new Tokenizer();
        tokenizer.buildTokenLinkedList();
        Token token = tokenizer.firstToken;

        //UNCOMMENT THIS
//        while(token.nextToken != null)
//        {
//            List<String> tempList = Arrays.asList(token.getTokens());
//            System.out.println(tempList);
//            System.out.println(token.getType());
//            token = token.getNextToken();
//        }

//        tokenizer.convertLineToTokenSentence("for(int i=0;i>10;i++)");
//        tokenizer.convertTokenSentenceToTokenWords("for(int i=0;i<tab;i++)");

//        tokenizer.convertLineToTokenSentence("public static void parse(int tab) {}");
//        tokenizer.convertTokenSentenceToTokenWords("public static void parse(int tab)");

        //System.out.println(tokenizer.labelTokenType(tokenizer.convertTokenSentenceToTokenWords("public void disc(double arg, int tab, char tokenWords)")));
    }
}
