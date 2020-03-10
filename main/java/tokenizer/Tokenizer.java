package tokenizer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Tokenizer
{
    Token firstToken;
    Token previousToken;

    public Tokenizer()
    {
        firstToken = null;
        previousToken = null;
    }

    public List<String> readFileLineByLine()
    {
        List<String> javaCode = new ArrayList<>();
        try (BufferedReader javaCodeFileReader = new BufferedReader(new FileReader("javaCode.txt")))
        {
            String sCurrentLine;
            while ((sCurrentLine = javaCodeFileReader.readLine()) != null)
            {
                javaCode.add(sCurrentLine);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return javaCode;
    }

    public List<String> convertLineToTokenSentence(String line)
    {

        if(line.startsWith("for"))
        {
            String[] array = line.split("(?=[{])|(?<=[{])|(?=})|(?<=})");
            for (String element : array) {

                System.out.println(element);
            }
            return Arrays.asList(array);

        }
    else {
            String[] array = line.split("(?=;)|(?<=;)|(?=[{])|(?<=[{])|(?=})|(?<=})");

          //  for (String element : array) {

           //     System.out.println(element);
         //   }

            return Arrays.asList(array);
        }
    }

    public List<String> assembleTokenSentences(List<String> javaLines)
    {
        List<String> tokenList = new ArrayList<>();
        javaLines.stream().forEach(javaLine ->
        {
            tokenList.addAll(convertLineToTokenSentence(javaLine));
        });

        return tokenList;
    }


    public String[] convertTokenSentenceToTokenWords(String javaLine){
        // space | ( | ) | " | , | > | < | = | + if next to a letter or int | - if next to a letter or int
        String[] tokens = javaLine.split("\\s+|(?=[(])|(?<=[(])|(?=[)])|(?<=[)])|(?=\")|(?<=\")|" +
                "(?=,)|(?<=,)|(?=>)|(?<=>)|(?=<)|(?<=<)|(?=[=])|(?<=[=])|(?<=[a-z0-9])(?=[+])|(?<=[+])(?=[a-z0-9])|" +
                "(?<=[a-z0-9])(?=-)|(?<=-)(?=[a-z0-9])|(?=[*])|(?<=[*])" );

       // for(String element: tokens)
      //  {
        //    System.out.println(element);
      //  }
        return tokens;
    }

    public void buildTokenLinkedList()
    {
        List<String> tokenList = assembleTokenSentences(readFileLineByLine());
        int iterator = 0;

        for(String tokenListItem: tokenList)
        {
            String[] tokenWords = convertTokenSentenceToTokenWords(tokenListItem);
            Token token = new Token();
            token.setTokens(tokenWords);
            token.setType(labelTokenType(tokenWords));
            if(iterator == 0){
                firstToken = token;
                previousToken = token;
                iterator++;
            }
            if(previousToken != null)
            {
                previousToken.setNextToken(token);
                previousToken = token;
            }
        }
    }
    public String labelTokenType(String[] tokens)
    {
        List<String> list = Arrays.asList(tokens);
        if(list.contains("public") && list.contains("static") && list.contains("void") && list.contains("main"))
        {
            return "MainMethod";
        }
        if(list.contains("System.out.println") || list.contains("System.out.print"))
        {
            return "Print";
        }
        if(list.contains("class")){
            return "class";
        }
        if(list.contains("if"))
        {
            return "if";
        }
        if(list.contains("else") && list.contains("if"))
        {
            return "elseif";
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
            return "Semi";
        }

        return null;
    }

    public static void main(String[] args) {
        Tokenizer tokenizer = new Tokenizer();
        tokenizer.buildTokenLinkedList();
        Token token = tokenizer.firstToken;
        while(token.nextToken != null)
        {
            List<String> tempList = Arrays.asList(token.getTokens());
            System.out.println(tempList);
            System.out.println(token.getType());
            token = token.getNextToken();
        }
//        tokenizer.convertLineToTokenSentence("for(int i=0;i>10;i++)");
  //      tokenizer.convertTokenSentenceToTokenWords("for(int i=0 ; i-1 ; i--)");
    }
}
