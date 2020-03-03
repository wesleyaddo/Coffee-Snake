package parser;

import tokenizer.Token;
import tokenizer.Tokenizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MasterParser {
    Tokenizer tokenizer;
    VariableParser variableParser;
    ForLoopParser forLoopParser;
    SemiColonParser semiColonParser;
    PrintParser printParser;
    OpenCurlyBracket openCurlyBracket;
    CommentParser commentParser;
    MainMethodParser mainMethodParser;

    private static final String VARIABLE = "variable";
    private static final String SEMI_COLON = "semi";
    private static final String PRINT = "print";
    private static final String OPEN_CURLY_BRACES = "openCurlyBraces";
    private static final String LINE_COMMENT = "lineComment";
    private static final String MAIN_METHOD = "mainMethod";
    private static final String FOR_LOOP= "forloop";

    public MasterParser(){
        tokenizer = new Tokenizer();
        variableParser = new VariableParser();
        forLoopParser = new ForLoopParser();
        semiColonParser = new SemiColonParser();
        printParser = new PrintParser();
        openCurlyBracket = new OpenCurlyBracket();
        commentParser = new CommentParser();
        mainMethodParser = new MainMethodParser();
    }

    public void acceptToken(Token firstToken){
        Token token = firstToken;
        String type;

        do{
            type = token.getType();
            switch (type){
                case VARIABLE :
                    variableParser.parse(token.getTokens());
                    break;

                case SEMI_COLON:
                    semiColonParser.parse(token.getTokens());
                    break;

                case PRINT:
                    printParser.parse(token.getTokens());
                    break;

                case OPEN_CURLY_BRACES:
                    openCurlyBracket.parse(token.getTokens());
                    break;

                //Add to type document and tokenizer
                case LINE_COMMENT:
                    commentParser.parse(token.getTokens());
                    break;

                case MAIN_METHOD:
                    mainMethodParser.parse(token.getTokens());
                    break;

                case FOR_LOOP:
                    forLoopParser.parse(token.getTokens());
                    break;

                default:
                    System.out.print("");
                    break;
            }
            token = token.getNextToken();
        }while(token != null);
    }


    public static void main(String[] args) {
        Token token = new Token();
        Token token1 = new Token();
        //main method conversion
        token.setTokens(new String[] {"public", "static", "void", "main"});
        token.setType(MAIN_METHOD);

        //forLOOP
        token.setTokens(new String[]{"for", "(" ,"int" , "i" , "=" , "0", ";", "i" , "<" , "5", ";", "i++" ,")", "}"});
        token.setType(FOR_LOOP);

        //print
        token1.setTokens(new String[]{"System.out.println" , "(", "\"Hello, World!\"", ")", ";"});
        token1.setType(PRINT);

        //Open Curley Braces
        token.setTokens(new String[]{"{"});
        token.setType(OPEN_CURLY_BRACES);

        //Line Comment
        token.setTokens(new String[]{"//", "This", "is", "a", "comment"});
        token.setType(LINE_COMMENT);

        //Variable Comment
        token.setTokens(new String[]{"int", "i", "=", "5"});
        token.setType(VARIABLE);

        MasterParser masterParser = new MasterParser();
        masterParser.acceptToken(token);
        //masterParser.acceptToken(token1);
    }

}










