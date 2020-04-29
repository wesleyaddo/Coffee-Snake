package parser;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.lang.*;
import tokenizer.Token;
import tokenizer.Tokenizer;

public class CaseParser {
    private static final Logger LOGGER = Logger.getLogger(FunctionParser.class.getName());

    Tokenizer tokenizer;
    VariableParser variableParser;
    ForLoopParser forLoopParser;
    SemiColonParser semiColonParser;
    ColonParser colonParser;
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
    DefaultParser defaultParser;

    public static int tab = 0;

    private static final String VARIABLE = "variable";
    private static final String SEMI_COLON = "semi";
    private static final String COLON = "colon";
    private static final String PRINT = "print";
    private static final String OPEN_CURLY_BRACES = "openCurlyBraces";
    private static final String CLOSE_CURLY_BRACES = "closeCurlyBraces";
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
    private static final String CASE = "case";
    private static final String DEFAULT = "default";

    public CaseParser() {
        tokenizer = new Tokenizer();
        variableParser = new VariableParser();
        forLoopParser = new ForLoopParser();
        semiColonParser = new SemiColonParser();
        colonParser = new ColonParser();
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
        switchParser = new SwitchParser();
        defaultParser = new DefaultParser();
    }

    String type;
    int i = 0;

    public void parse(int tab, Token token) throws FileNotFoundException {

        String[] tokenWords = token.getTokens();
        Token token1 = token;

        HashMap<String, ArrayList<Token>> tokenHash = new HashMap<>();

        for (int i = 0; i < tab; i++){
            System.out.print("\t");
        }

        do {
            do {
                String caseValue = new String();
                ArrayList<Token> tokenArrayList = new ArrayList<>();
                if (token1.getType() == "case") {
                    caseValue = token1.getTokens()[1];
                } else {
                    tokenArrayList.add(token1);
                    token1 = token.getNextToken();
                }
                tokenHash.put(caseValue, tokenArrayList);
                tab--;
            } while (token1.getType() == "break");
        } while (token1.getType() == "closeCurlyBraces");
        testParse(tab, tokenHash);
    }


    public void testParse(int tab, Map<String, ArrayList<Token>> map) throws FileNotFoundException {
        try {
            PrintStream out = new PrintStream(new FileOutputStream("pythonCode.txt", true));
            PrintStream console = System.out;
            System.setOut(out);
//            for (int i = 0; i < tab; i++){
//                System.out.print("\t");
//            }
//            tab++;

            type = "case";
            for (String key : map.keySet()) {
                if (i > 0) {
                    System.out.println("elif " + type + " == " + key + ":");
                    tab = tab;
//                    for (int i = 0; i < tab; i++){
//                        System.out.print("\t");
//                    }
                    switchMasterParser(tab, map.get(key));
                }
                else {
                    System.out.println("if " + type + " == " + key + ":");
//                    for (int i = 0; i < tab; i++){
//                        System.out.print("\t");
//                    }
                    //tab = tab+2;
                    switchMasterParser(tab, map.get(key));
                    i++;
                }
            }
        } catch (IOException e1) {
            System.out.println("Error during reading/writing");
        }
    }


    public void switchMasterParser(int tab, ArrayList<Token> tokenArrayList) throws FileNotFoundException {
        for (Token token : tokenArrayList) {
            type = token.getType();

            switch (type) {
                case VARIABLE:
                    variableParser.parse(tab, token.getTokens());
                    break;

                case SEMI_COLON:
                    //tab++;
                    semiColonParser.parse(tab, token.getTokens());
                    break;

                case COLON:
                    //tab++;
                    ColonParser.parse(tab, token.getTokens());
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

//                case CASE:
//                    caseParser.parse(tab, token);
//                    break;

                case DEFAULT:
                    defaultParser.parse(tab, token.getTokens());
                    break;

                default:
                    System.out.print("");
                    break;
            }
            token = token.getNextToken();
        }
    }
}