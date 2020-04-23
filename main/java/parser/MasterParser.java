package parser;

import tokenizer.Token;
import tokenizer.Tokenizer;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.logging.Logger;

public class MasterParser {
    private static final Logger LOGGER = Logger.getLogger(OpenCurlyBraceParser.class.getName());

    Tokenizer tokenizer;
    VariableParser variableParser;
    ForLoopParser forLoopParser;
    SemiColonParser semiColonParser;
    PrintParser printParser;
    OpenCurlyBraceParser openCurlyBrace;
    CommentParser commentParser;
    MainMethodParser mainMethodParser;
    CloseCurlyBraceParser closeCurlyBrace;
    WhileLoopParser whileLoopParser;
    IfParser ifParser;
    ElseIfParser elseIfParser;
    ElseParser elseParser;
    ClassParser classParser;
    FunctionParser functionParser;
    DoWhileParser doWhileParser;
    SwitchParser switchParser;

    public static int tab = 0;

    private static final String VARIABLE = "variable";
    private static final String SEMI_COLON = "semi";
    private static final String PRINT = "print";
    private static final String OPEN_CURLY_BRACES = "openCurlyBraces";
    private static final String CLOSE_CURLY_BRACES= "closeCurlyBraces";
    private static final String LINE_COMMENT = "lineComment";
    private static final String MAIN_METHOD = "mainMethod";
    private static final String FOR_LOOP = "forloop";
    private static final String WHILE_LOOP = "whileloop";
    private static final String IF = "if";
    private static final String ELSE_IF = "elseif";
    private static final String ELSE = "else";
    private static final String CLASS = "class";
    private static final String FUNCTION = "function";
    private static final String DOWHILE = "dowhile";
    private static final String SWITCH = "switch";

    public MasterParser(){
        tokenizer = new Tokenizer();
        variableParser = new VariableParser();
        forLoopParser = new ForLoopParser();
        semiColonParser = new SemiColonParser();
        printParser = new PrintParser();
        openCurlyBrace = new OpenCurlyBraceParser();
        closeCurlyBrace = new CloseCurlyBraceParser();
        commentParser = new CommentParser();
        mainMethodParser = new MainMethodParser();
        whileLoopParser = new WhileLoopParser();
        ifParser = new IfParser();
        classParser = new ClassParser();
        functionParser = new FunctionParser();
        doWhileParser = new DoWhileParser();

    }

    public void acceptToken(Token firstToken) throws FileNotFoundException {
        LOGGER.info("Taking tokens into parser");
        Token token = firstToken;
        String type;

        do{
            type = token.getType();
            switch (type){
                //if type == VARIABLE
                //variableParser.parse(tab, token.getTokens());
                case VARIABLE:
                    variableParser.parse(tab, token.getTokens());
                    System.out.println("HEllo");
                    break;

                    //else if type == SEMICOLON
                //
                case SEMI_COLON:
                    //tab++;
                    semiColonParser.parse(tab, token.getTokens());
                    break;

                case PRINT:
                    printParser.parse(tab, token.getTokens());
                    break;

                case OPEN_CURLY_BRACES:
                    tab++;
                    openCurlyBrace.parse(tab, token.getTokens());
                    break;

                case CLOSE_CURLY_BRACES:
                    tab--;
                    closeCurlyBrace.parse(tab, token.getTokens());
                    break;

                //Add to type document and tokenizer
                case LINE_COMMENT:
                    commentParser.parse(tab, token.getTokens());
                    break;

                case MAIN_METHOD:
                    mainMethodParser.parse(tab, token.getTokens());
                    break;

                case FOR_LOOP:
                    forLoopParser.parse(tab, token.getTokens());
                    break;

                case WHILE_LOOP:
                    whileLoopParser.parse(tab, token.getTokens());
                    break;

                case IF:
                    ifParser.parse(tab, token.getTokens());
                    break;

                case ELSE_IF:
                    elseIfParser.parse(tab, token.getTokens());
                    break;

                case ELSE:
                    elseParser.parse(tab, token.getTokens());
                    break;

                case CLASS:
                    classParser.parse(tab, token.getTokens());
                    break;

                case FUNCTION:
                    functionParser.parse(tab, token.getTokens());
                    break;

                case DOWHILE:
                    functionParser.parse(tab, token.getTokens());
                    break;

                case SWITCH:
                    switchParser.parse(tab, token.getTokens());
                    break;

                default:
                    System.out.print("");
                    break;
            }
            token = token.getNextToken();
            //LOGGER.info( "Token: " + Arrays.asList(token.getTokens()) + '\n' + "Token type: " + token.getType() + '\n');
        }while(token != null);
    }

    public void tokenIterator(Token token) throws FileNotFoundException {
        while(token.getNextToken() != null){
            acceptToken(token);
            token = token.getNextToken();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Token token = new Token();
        Token token1 = new Token();
        Token token2 = new Token();
        Token token3 = new Token();
        Token token4 = new Token();
        Token token5 = new Token();
        Token token6 = new Token();
        Token token22 = new Token();

        //SINCE THERE ARE TWO NEW LINES IF THERE IS A SEMI AND CLOSE BRACE,
        //HOW ABOUT EVERYONE ELSE PRINTS THEIR OWN FRICKIN NEW LINE?

        //main method conversion
        token.setTokens(new String[] {"public", "static", "void", "main"});
        token.setType(MAIN_METHOD);

        //forLOOP
        token.setTokens(new String[]{"for", "(" ,"int" , "i" , "=" , "0", ";", "i" , "<" , "5", ";", "i", "++" ,")"});
        token.setType(FOR_LOOP);
        token1.setTokens(new String[]{"{"});
        token1.setType(OPEN_CURLY_BRACES);
        token2.setTokens(new String[]{";"});
        token2.setType(SEMI_COLON);

        //print
        token3.setTokens(new String[]{"System.out.println" , "(", "\"Hello, World!\"", ")"});
        token3.setType(PRINT);
        token4.setTokens(new String[]{";"});
        token4.setType(SEMI_COLON);
        token5.setTokens(new String[]{"}"});
        token5.setType(CLOSE_CURLY_BRACES);
        token6.setTokens(new String[]{"//", "This", "is", "a", "comment"});
        token6.setType(LINE_COMMENT);
//
//        //Open Curly Braces
//        token.setTokens(new String[]{"{"});
//        token.setType(OPEN_CURLY_BRACES);
//
//        token.setTokens(new String[]{"{"});
//        token.setType(OPEN_CURLY_BRACES);
//
//        //Line Comment
//        token.setTokens(new String[]{"//", "This", "is", "a", "comment"});
//        token.setType(LINE_COMMENT);
//
//        //Variable Comment
//        token.setTokens(new String[]{"int", "i", "=", "5"});
//        token.setType(VARIABLE);
//
//        token.setTokens(new String[]{";"});
//        token.setType(SEMI_COLON);
//

//        token.setTokens(new String[]{"if","(","double","x","=","0",")"});
//        token.setType(IF);
//
//        token.setTokens(new String[]{"while","(","x","<","0",")"});
//        token.setType(WHILE_LOOP);
//
//        token.setTokens(new String[]{"else", "if", "(", "x", ">", "0", ")"});
//        token.setType(ELSE_IF);
//
//        token.setTokens(new String[]{"else", "{"});
//        token.setType(ELSE);
//
//        token.setTokens(new String[]{"class", "Tokenizeration"});
//        token.setType(CLASS);
//
        token.setTokens(new String[]{"public", "void", "disc", "(", "double", "arg1", ",", "int", "arg2", ",", "char", "arg3", ")"});
        token.setType(FUNCTION);
        token.setTokens(new String[]{"switch", "(", "HelloSwitch", ")", "{", "\n",
                "case", "1", ":", "\n",
                "\t", "sout('Hello 1')", ";", "\n",
                "\t", "break", ";", "\n\n",

                "case", "2", ":", "\n",
                "\t", "sout('Hello 2')", ";", "\n",
                "\t", "break", ";", "\n\n",

                "default", ":", "\n",
                "\t", "sout(Final Ans)", ";", "\n",
                "\t", "break", ";", "\n\n",
        });
        token.setType(SWITCH);

        MasterParser masterParser = new MasterParser();
        masterParser.acceptToken(token);
//        masterParser.acceptToken(token1);
//        masterParser.acceptToken(token2);
//        masterParser.acceptToken(token3);
//        masterParser.acceptToken(token4);
//        masterParser.acceptToken(token5);
//        masterParser.acceptToken(token6);
//        masterParser.acceptToken(token1);
    }

}










