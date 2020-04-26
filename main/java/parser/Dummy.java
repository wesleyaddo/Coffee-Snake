package parser;

public class Dummy {

//throws FileNotFoundException
//
//    {
//        try {
//            PrintStream out = new PrintStream(new FileOutputStream("pythonCode.txt", true));
//            PrintStream console = System.out;
//            System.setOut(out);
//
//
//        }
//        catch(IOException e1) {
//            System.out.println("Error during reading/writing");
//        }


//class WhileLoops
//{
//    public static void main (String[]args){
//    int i = 0;
//    int x = 4;
//
//    while (i == 6) {
//            System.out.println("i = " + i);
//            i++;
//        }
//    }
//}


//class IfStatement {
//    public static void main(String args) {
//        int x = 0;
//        int y = 5;
//        if (x < y) {
//            System.out.println(x + "<" + y);
//        } else {
//            System.out.println(y + "<" + x);
//        }
//    }
//}


//ElseParser not showing
//
//    class FullParserTest {
//        public static void main(String[] args) {
//            int x = 0;
//            int y = 2;
//            if (x < y) {
//                for (int i = 0; i < 3; i++) {
//                    System.out.println(x + "<" + y);
//                }
//            } else if (x > y) {
//                while (x == 4) {
//                    System.out.println(y + "<" + x);
//                }
//            } else {
//                private void Print (String word, int x){
//                    System.out.println(x + " = " + y);
//                }
//            }
//        }
//    }
}


//class ElseIfStatement {
//    public static void main(String args) {
//        int x = 0;
//        int y = 5;
//        if(x < y) {
//            System.out.print(x + "<"+y);
//        }
//        else if (x > y) {
//            System.out.println(y + "<" + x);
//        }
//        else {
//            System.out.println(x + " = " + y);
//        }
//    }
//}


//    Class IfStatement {
//        Public static void main (String args){
//        Int x = (value);
//        Int y = (value);
//        If (x <  y) {
//        System,out,println ( x + “ < “ + y);
//        }
//        Else if {
//        System.out.println( y + “ < “ + x);
//        }
//        Else {
//        System.out.println( x  + “ =  “ + y);




//
//    int i = 1;
//do {
//        System.out.println(i);
//        i++;
//        } while ( i < 11);
//
//
//
//        i = 1
//        while True:
//        print(i,)
//        i+=1
//        if (i > 10):
//        break
//
//
//        i = 1
//        while i < 11:
//        print(i,)
//        i+=1



//        int i = 1;
//        do {
//            System.out.println(i);
//            i++;
//        } while ( i < 11);
//
//
//
//        i = 1
//            while True:
//                print(i,)
//                i+=1
//
//                if (i > 10):
//        break
//
//
//        i = 1
//        while i < 11:
//        print(i,)
//        i+=1

//
//switch (type)
//        {
//        case VARIABLE :
//        System.out.print("Hello 1") ;
//        break ;
//        }















//package parser;
//
//        import parserator.ParserConnector;
//
//        import java.io.FileNotFoundException;
//        import java.io.FileOutputStream;
//        import java.io.IOException;
//        import java.io.PrintStream;
//        import java.util.ArrayList;
//        import java.util.HashMap;
//        import java.util.List;
//        import java.util.logging.Logger;
//        import java.lang.*;
//        import java.util.Collections;
//
//public class SwitchParser {
//    private static final Logger LOGGER = Logger.getLogger(FunctionParser.class.getName());
//    public static void parse(int tab, String[]tokenWords) throws FileNotFoundException {
//        try {
//            PrintStream out = new PrintStream(new FileOutputStream("pythonCode.txt", true));
//            PrintStream console = System.out;
//            //System.setOut(out);
//
//            LOGGER.info("Tab count: " + tab);
//            for (int i = 0; i < tab; i++){
//                System.out.print("\t");
//            }
//
//            int pos1;
//            String switchWord = null;
//            ArrayList<String> caseWords = new ArrayList<String>();
//
//            int n = 0;
//            for (pos1 = 0; pos1 <= tokenWords.length-1; pos1++) {
//                if (tokenWords[pos1].equals("break")) {
//                    n++;
//                }
//            }
//
//            int s = 0;
//
//            HashMap<Integer, ArrayList<String>> maps=new HashMap<Integer, ArrayList<String>>();
//
//            for (int i=0;i<n;i++)
//                maps.put(i,new ArrayList<String>());
//
//            ArrayList<String> temp = new ArrayList<>();
//
//            int parenthesisCount = 0;
//            boolean checker = false;
//            int pos = 0;
//            for (pos = pos; pos <= tokenWords.length-1; pos++) {
//                if (tokenWords[pos].equals("{")) {
//                    parenthesisCount++;
//                    System.out.println(parenthesisCount);
//                }
//
//                if (tokenWords[pos].equals("}")) {
//                    parenthesisCount--;
//                    System.out.println(parenthesisCount);
//                }
//
//                if (tokenWords[pos].equals(":")) {
//                    checker = true;
//                    do {
//                        for (pos = pos; pos <= tokenWords.length-1; pos++) {
//                            temp.add(tokenWords[pos]);
//
//                            if (tokenWords[pos].equals("break")) {
//                                temp.add(tokenWords[pos]);
//                                checker = false;
//                            }
//                        }
//                    }while (checker = true);
//                }
//
//
//
//                if (parenthesisCount != 0) {
//                    System.out.println(checker);
//
//                    if (checker = true) {
////                        if (tokenWords[pos].equals("break")) {
////                            pos++;
////                            maps.put(s, temp);
////                            s++;
////                            temp = new ArrayList<>();
////                        } else
//                        temp.add(tokenWords[pos]);
//                    }
//                    if (checker = false)
//                        System.out.println("nothing");
//
//
//
//
//
//
////                    if (tokenWords[pos].equals("switch")) {
////                        switchWord = tokenWords[pos + 2];
////                    }
////
////                    else if (tokenWords[pos].equals("case")) {
////                        caseWords.add(tokenWords[pos + 1]);
////                    }
////
////                    else if ((tokenWords[pos].equals(";") && maps.get(s).isEmpty())) {
////                        int trash = 1;
////                    }
////
////
//////                    else if (tokenWords[pos].equals("switch") || tokenWords[pos].equals("case") || tokenWords[pos].equals(switchWord)
//////                            || tokenWords[pos].equals("default")) {
//////                        int trash = 1;
//////                    }
////
////                    else if (tokenWords[pos].equals(switchWord) || tokenWords[pos].equals("default")) {
////                        int trash = 1;
////                    }
////
////                    else if (caseWords.contains(tokenWords[pos])) {
////                        pos++;
////                    }
////
////                    else if (tokenWords[pos].equals(":")) {
////                        pos++;
////                    }
////
//////                if (tokenWords[pos].equals("break") && tokenWords[pos--].equals("break")) {
//////                    pos++;
//////                }
////
////                    else if (tokenWords[pos].equals("break")) {
////                        pos++;
////                        maps.put(s, temp);
////                        s++;
////                        temp = new ArrayList<>();
////                    }
////                else
////                    temp.add(tokenWords[pos]);
////                }
//
//
//
//
//                }
//            }
//            System.out.println(maps.get(0));
//            System.out.println(maps.get(1));
//            System.out.println(maps.get(2));
//
//            for (int caseWordCount = 0; caseWordCount <= caseWords.size()-1; caseWordCount++){
//                System.out.println("def " + caseWords.get(caseWordCount) + "(): \n" + '\t' + "return " +
//                        maps.get(caseWordCount));
//            }
//        }
//        catch(IOException e1) {
//            System.out.println("Error during reading/writing");
//        }
//    }
//}








//package parser;
//
//        import parserator.ParserConnector;
//
//        import java.io.FileNotFoundException;
//        import java.io.FileOutputStream;
//        import java.io.IOException;
//        import java.io.PrintStream;
//        import java.util.ArrayList;
//        import java.util.HashMap;
//        import java.util.logging.Logger;
//        import java.lang.*;
//        import parser.SwitchMasterParser;
//        import tokenizer.SwitchTokenizer;
//        import tokenizer.Token;
//
//public class SwitchParser {
//    private static final Logger LOGGER = Logger.getLogger(FunctionParser.class.getName());
//    public static void parse(int tab, Token token) throws FileNotFoundException {
//
//        String [] tokenWords = token.getTokens();
//
//        Token token1 = token;
//        HashMap<Token, ArrayList<Token>> tokenHash = new HashMap<>();
//
//        do{
//            do{
//                String caseValue = new String();
//                ArrayList<Token>tokenArrayList = new ArrayList<>();
//                if (token1.getType() == "case") {
//                    caseValue = token1.getTokens()[1];
//                } else {
//                    tokenArrayList.add(token1);
//                    token1 = token.getNextToken();
//                }
//                tokenHash.put(caseValue, tokenArrayList);
//            }while (token1.getType() == "break");
//        }while(token1.getType() == "closeCurlyBraces");
//
//        SwitchMasterParser switchMasterParser = new SwitchMasterParser();
//        SwitchTokenizer switchTokenizer = new SwitchTokenizer();
//        try {
//            PrintStream out = new PrintStream(new FileOutputStream("pythonCode.txt", true));
//            PrintStream console = System.out;
//            //System.setOut(out);
//
//            LOGGER.info("Tab count: " + tab);
//            for (int i = 0; i < tab; i++){
//                System.out.print("\t");
//            }
//
//            int pos1;
//            String switchWord = null;
//            ArrayList<String> caseWords = new ArrayList<String>();
//
//            int n = 0;
//            for (pos1 = 0; pos1 <= tokenWords.length-1; pos1++) {
//                if (tokenWords[pos1].equals("break")) {
//                    n++;
//                }
//            }
//
//            int s = 0;
//
//            HashMap<Integer, ArrayList<String>> maps=new HashMap<Integer, ArrayList<String>>();
//
//            for (int i=0;i<n;i++)
//                maps.put(i,new ArrayList<String>());
//
//            ArrayList<String> temp = new ArrayList<>();
//
//            int parenthesisCount = 0;
//            boolean checker = false;
//            int pos = 0;
//            int colonSkip = 0;
//
//            for (pos = pos; pos < tokenWords.length-1; pos++) {
//                if (tokenWords[pos].equals("{")) {
//                    parenthesisCount++;
//                    //System.out.println(parenthesisCount);
//                }
//
//                if (tokenWords[pos].equals("}")) {
//                    parenthesisCount--;
//                    //System.out.println(parenthesisCount);
//                }
//
//                if (parenthesisCount != 0) {
//                    //System.out.println(checker);
//                    colonSkip = 1;
//
//                    if (tokenWords[pos].equals("switch")) {
//                        switchWord = tokenWords[pos + 2];
//                    }
//
//                    else if (tokenWords[pos].equals("case")) {
//                        caseWords.add(tokenWords[pos + 1]);
//                    }
//
//                    if (tokenWords[pos].equals(":")) {
//                        checker = true;
//                        do {
//                            if (tokenWords[pos].equals("break")) {
//                                maps.put(s, temp);
//                                temp = new ArrayList<>();
//                                s++;
//                                checker = false;
//                            }
//                            else {
//                                if (colonSkip > 0){
//                                    pos++;
//                                    colonSkip--;
//                                }
//                                else {
//                                    temp.add(tokenWords[pos]);
//                                    pos++;
//                                }
//                            }
//                        } while (checker);
//                    }
//                }
//            }
//
//            System.out.println(maps.get(0));
//            System.out.println(maps.get(1));
//            System.out.println(maps.get(2));
//
//            switchMasterParser.acceptToken(maps.get(0).get(0));
//
//            for (int caseWordCount = 0; caseWordCount <= caseWords.size()-1; caseWordCount++){
//                System.out.println("def " + caseWords.get(caseWordCount) + "(): \n" + '\t' + "return " +
//                        maps.get(caseWordCount));
//            }
//        }
//        catch(IOException e1) {
//            System.out.println("Error during reading/writing");
//        }
//    }
//}




//switch (type)
//        {
//        case VARIABLE :
//        int x = 5;
//        if (x > 15);
//        break;
//        case IF :
//        if (x = 2);
//        System.out.println("variable print");
//        break;
//        }
//        System.out.print(xtreme);












































































































//package parser;
//
//import parserator.ParserConnector;
//
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.PrintStream;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Logger;
//
//public class SwitchParser {
//    private static final Logger LOGGER = Logger.getLogger(FunctionParser.class.getName());
//    public static void parse(int tab, String[]tokenWords) throws FileNotFoundException {
//        try {
//            PrintStream out = new PrintStream(new FileOutputStream("pythonCode.txt", true));
//            PrintStream console = System.out;
//            //System.setOut(out);
//
//            LOGGER.info("Tab count: " + tab);
//            for (int i = 0; i < tab; i++){
//                System.out.print("\t");
//            }
//
//            int pos;
//            String switchWord = null;
//            ArrayList <String> caseWord = new ArrayList<String>();
//
//            int n = 0;
//            for (pos = 0; pos <= tokenWords.length-1; pos++) {
//                if (tokenWords[pos].equals("break")) {
//                    n++;
//                }
//            }
//
////            ArrayList<String>[] caseText = new ArrayList[n];
////            for (int i = 0; i < n; i++) {
////                caseText[i] = new ArrayList<String>();
////            }
////            int t = 0;
//
//            int s = 0;
//
//
//
//
//            List<List<String>> generalList = new ArrayList<>();
//            for(int i=0;i<n;i++)
//            {
//                ArrayList<String> myGroup = new ArrayList<>();
//                generalList.add(myGroup);
//            }
//
//            ArrayList<String> temp = new ArrayList<>();
//
//            System.out.println(generalList.size());
//
//            for (pos = 0; pos <= tokenWords.length-1; pos++) {
//
//                if (tokenWords[pos].equals("switch")) {
//                    switchWord = tokenWords[pos+2];
//                }
//
//                if (tokenWords[pos].equals("case")) {
//                    caseWord.add(tokenWords[pos+1]);
//                }
//
//                if (tokenWords[pos].equals("break") ) {
//                    //caseText[0].add(tokenWords[pos]);
//
//                    s++;
//                    generalList.add(s, temp);
//                    temp.clear();
////                    t = 0;
//                }
//
//                System.out.println(tokenWords[pos]);
//                System.out.println(s);
////                caseText[s].add(tokenWords[pos]);
//
//                //caseText[s].add(t, tokenWords[pos]);
//                //t++;
//
//                temp.add(tokenWords[pos]);
//            }
//
//            System.out.println(generalList.get(1));
//
//            for (int caseWordCount = 0; caseWordCount <= caseWord.size()-1; caseWordCount++){
//                System.out.println("def " + caseWord.get(caseWordCount) + "(): \n" + '\t' + "return");
//            }
//
////            for (int i = 0; i < n; i++) {
////                for (int j = 0; j < caseText[i].size(); j++) {
//////                    System.out.println(caseText[i].indexOf(j));
////                   System.out.print(caseText[i].get(j) + " ");
//////                    System.out.println(caseText[0].get(2));
//////                    System.out.println(caseText[2].get(2));
//////                    System.out.println(caseText[0].get(12));
////                }
////            }
//
////            for (int i = 0; i < caseText[1].size(); i++) {
////                System.out.print(caseText[1].get(i) + " ");
////            }
////
////            System.out.print(caseText[1].get(1) + " ");
//        }
//        catch(IOException e1) {
//            System.out.println("Error during reading/writing");
//        }
//    }
//}

















//package parser;
//
//import parserator.ParserConnector;
//
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.PrintStream;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Logger;
//import java.lang.*;
//import java.util.Collections;
//
//public class SwitchParser {
//    private static final Logger LOGGER = Logger.getLogger(FunctionParser.class.getName());
//    public static void parse(int tab, String[]tokenWords) throws FileNotFoundException {
//        try {
//            PrintStream out = new PrintStream(new FileOutputStream("pythonCode.txt", true));
//            PrintStream console = System.out;
//            //System.setOut(out);
//
//            LOGGER.info("Tab count: " + tab);
//            for (int i = 0; i < tab; i++){
//                System.out.print("\t");
//            }
//
//            int pos;
//            String switchWord = null;
//            ArrayList <String> caseWord = new ArrayList<String>();
//
//            int n = 0;
//            for (pos = 0; pos <= tokenWords.length-1; pos++) {
//                if (tokenWords[pos].equals("break")) {
//                    n++;
//                }
//            }
//
//            int s = 0;
//
//            ArrayList<ArrayList<String>> generalList = new ArrayList<>();
//            for(int i=0;i<n;i++)
//            {
//                ArrayList<String> myGroup = new ArrayList<>();
//                generalList.add(myGroup);
//            }
//
//            ArrayList<String> temp = new ArrayList<>();
//
//            for (pos = 0; pos <= tokenWords.length-1; pos++) {
//
//                if (tokenWords[pos].equals("switch")) {
//                    switchWord = tokenWords[pos+2];
//                }
//
//                if (tokenWords[pos].equals("case")) {
//                    caseWord.add(tokenWords[pos+1]);
//                }
//
//                if (tokenWords[pos].equals("break") ) {
//
//                    //Collections.copy(generalList.get(s), temp);
//                    ArrayList<String> newList = new ArrayList<>();
//                    newList = temp;
//                    generalList.set(s, generalList.addAll(temp));
//                    s++;
//                    temp.clear();
//                }
//
//                generalList.set(s, generalList.set(0).add(tokenWords[pos]));
//
////                System.out.println(tokenWords[pos]);
////                System.out.println(s);
//
//                temp.add(tokenWords[pos]);
//                System.out.println(generalList.size());
//            }
//
//            System.out.println(generalList.get(0));
//            System.out.println(generalList.get(1));
//            System.out.println(generalList.get(2));
//
//
//
//            for (int caseWordCount = 0; caseWordCount <= caseWord.size()-1; caseWordCount++){
//                System.out.println("def " + caseWord.get(caseWordCount) + "(): \n" + '\t' + "return");
//            }
//        }
//        catch(IOException e1) {
//            System.out.println("Error during reading/writing");
//        }
//    }
//}























//package parser;
//
//import parserator.ParserConnector;
//
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.PrintStream;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.logging.Logger;
//import java.lang.*;
//import java.util.Collections;
//
//public class SwitchParser {
//    private static final Logger LOGGER = Logger.getLogger(FunctionParser.class.getName());
//    public static void parse(int tab, String[]tokenWords) throws FileNotFoundException {
//        try {
//            PrintStream out = new PrintStream(new FileOutputStream("pythonCode.txt", true));
//            PrintStream console = System.out;
//            //System.setOut(out);
//
//            LOGGER.info("Tab count: " + tab);
//            for (int i = 0; i < tab; i++){
//                System.out.print("\t");
//            }
//
//            int pos;
//            String switchWord = null;
//            ArrayList <String> caseWords = new ArrayList<String>();
//
//            int n = 0;
//            for (pos = 0; pos <= tokenWords.length-1; pos++) {
//                if (tokenWords[pos].equals("break")) {
//                    n++;
//                }
//            }
//
//            int s = 0;
//
//            HashMap<Integer, ArrayList<String>> maps=new HashMap<Integer, ArrayList<String>>();
//
//            for (int i=0;i<n;i++)
//                maps.put(i,new ArrayList<String>());
//
//            ArrayList<String> temp = new ArrayList<>();
//
//            int parenthesisCount = 0;
//
//            for (pos = 0; pos <= tokenWords.length-1; pos++) {
//                boolean checker;
//                if (tokenWords[pos].equals("{")) {
//                    parenthesisCount++;
//                    System.out.println(parenthesisCount);
//                }
//
//                if (tokenWords[pos].equals("}")) {
//                    parenthesisCount--;
//                    System.out.println(parenthesisCount);
//                }
//
//                if (parenthesisCount != 0) {
//                    if (tokenWords[pos].equals("switch")) {
//                        switchWord = tokenWords[pos + 2];
//                    }
//
//                    else if (tokenWords[pos].equals("case")) {
//                        caseWords.add(tokenWords[pos + 1]);
//                    }
//
//                    else if ((tokenWords[pos].equals(";") && maps.get(s).isEmpty())) {
//                        int trash = 1;
//                    }
//
//
////                    else if (tokenWords[pos].equals("switch") || tokenWords[pos].equals("case") || tokenWords[pos].equals(switchWord)
////                            || tokenWords[pos].equals("default")) {
////                        int trash = 1;
////                    }
//
//                    else if (tokenWords[pos].equals(switchWord) || tokenWords[pos].equals("default")) {
//                        int trash = 1;
//                    }
//
//                    else if (caseWords.contains(tokenWords[pos])) {
//                        pos++;
//                    }
//
//                    else if (tokenWords[pos].equals(":")) {
//                        pos++;
//                    }
//
////                if (tokenWords[pos].equals("break") && tokenWords[pos--].equals("break")) {
////                    pos++;
////                }
//
//                    else if (tokenWords[pos].equals("break")) {
//                        pos++;
//                        maps.put(s, temp);
//                        s++;
//                        temp = new ArrayList<>();
//                    }
//                else
//                    temp.add(tokenWords[pos]);
//                }
//
//
//
//
//
//            }
//            System.out.println(maps.get(0));
//            System.out.println(maps.get(1));
//            System.out.println(maps.get(2));
//
//            for (int caseWordCount = 0; caseWordCount <= caseWords.size()-1; caseWordCount++){
//                System.out.println("def " + caseWords.get(caseWordCount) + "(): \n" + '\t' + "return " +
//                        maps.get(caseWordCount));
//            }
//        }
//        catch(IOException e1) {
//            System.out.println("Error during reading/writing");
//        }
//    }
//}



















//package parser;
//
//        import parserator.ParserConnector;
//
//        import java.io.FileNotFoundException;
//        import java.io.FileOutputStream;
//        import java.io.IOException;
//        import java.io.PrintStream;
//        import java.util.ArrayList;
//        import java.util.HashMap;
//        import java.util.Map;
//        import java.util.logging.Logger;
//        import java.lang.*;
////import parser.SwitchMasterParser;
//        import tokenizer.SwitchTokenizer;
//        import tokenizer.Token;
//        import tokenizer.Tokenizer;
//
//public class SwitchParser {
//    private static final Logger LOGGER = Logger.getLogger(FunctionParser.class.getName());
//
//    Tokenizer tokenizer;
//    VariableParser variableParser;
//    ForLoopParser forLoopParser;
//    SemiColonParser semiColonParser;
//    PrintParser printParser;
//    OpenCurlyBraceParser openCurlyBrace;
//    CommentParser commentParser;
//    MainMethodParser mainMethodParser;
//    CloseCurlyBraceParser closeCurlyBrace;
//    WhileLoopParser whileLoopParser;
//    IfParser ifParser;
//    ElseIfParser elseIfParser;
//    ElseParser elseParser;
//    ClassParser classParser;
//    FunctionParser functionParser;
//    DoWhileParser doWhileParser;
//    SwitchParser switchParser;
//    //SwitchMasterParser switchMasterParser;
//
//    public static int tab = 0;
//
//    private static final String VARIABLE = "variable";
//    private static final String SEMI_COLON = "semi";
//    private static final String PRINT = "print";
//    private static final String OPEN_CURLY_BRACES = "openCurlyBraces";
//    private static final String CLOSE_CURLY_BRACES= "closeCurlyBraces";
//    private static final String LINE_COMMENT = "lineComment";
//    private static final String MAIN_METHOD = "mainMethod";
//    private static final String FOR_LOOP = "forloop";
//    private static final String WHILE_LOOP = "whileloop";
//    private static final String IF = "if";
//    private static final String ELSE_IF = "elseif";
//    private static final String ELSE = "else";
//    private static final String CLASS = "class";
//    private static final String FUNCTION = "function";
//    private static final String DOWHILE = "dowhile";
//    private static final String SWITCH = "switch";
//
//    public SwitchParser(){
//        tokenizer = new Tokenizer();
//        variableParser = new VariableParser();
//        forLoopParser = new ForLoopParser();
//        semiColonParser = new SemiColonParser();
//        printParser = new PrintParser();
//        openCurlyBrace = new OpenCurlyBraceParser();
//        closeCurlyBrace = new CloseCurlyBraceParser();
//        commentParser = new CommentParser();
//        mainMethodParser = new MainMethodParser();
//        whileLoopParser = new WhileLoopParser();
//        ifParser = new IfParser();
//        classParser = new ClassParser();
//        functionParser = new FunctionParser();
//        doWhileParser = new DoWhileParser();
//        //switchMasterParser = new SwitchMasterParser();
//    }
//    String type;
//
//    public static void parse(int tab, Token token) throws FileNotFoundException {
//
//        String[] tokenWords = token.getTokens();
//
//        Token token1 = token;
//        HashMap<String, ArrayList<Token>> tokenHash = new HashMap<>();
//
//        do {
//            do {
//                String caseValue = new String();
//                ArrayList<Token> tokenArrayList = new ArrayList<>();
//                if (token1.getType() == "case") {
//                    caseValue = token1.getTokens()[1];
//                } else {
//                    tokenArrayList.add(token1);
//                    token1 = token.getNextToken();
//                }
//                tokenHash.put(caseValue, tokenArrayList);
//            } while (token1.getType() == "break");
//        } while (token1.getType() == "closeCurlyBraces");
//        System.out.println(tokenHash.get("VARIABLE"));
//    }
//
//
//    public void testParse() throws FileNotFoundException {
//        Map<String, ArrayList<Token>> map = new HashMap<>();
//
//
//        /// Key: one value //Exec
//        /// Key: two || Value //ArrayList [Exec1, Exec2, Exec3]
//
//        for (String key : map.keySet())
//        {
//            //PrintintoPythonFile("if" + type + " == " + key);
//            System.out.println("if" + type + " == " + key);
//            switchMasterParser(map.get(key));
//        }
//    }
//
//    public void switchMasterParser (ArrayList <Token> tokenArrayList) throws FileNotFoundException {
//        for (Token token : tokenArrayList) {
//            type = token.getType();
//
//            switch (type) {
//                case VARIABLE:
//                    variableParser.parse(tab, token.getTokens());
//                    System.out.println("HEllo");
//                    break;
//
//                case SEMI_COLON:
//                    //tab++;
//                    semiColonParser.parse(tab, token.getTokens());
//                    break;
//
//                case PRINT:
//                    printParser.parse(tab, token.getTokens());
//                    break;
//
//                case OPEN_CURLY_BRACES:
//                    tab++;
//                    openCurlyBrace.parse(tab, token.getTokens());
//                    break;
//
//                case CLOSE_CURLY_BRACES:
//                    tab--;
//                    closeCurlyBrace.parse(tab, token.getTokens());
//                    break;
//
//                //Add to type document and tokenizer
//                case LINE_COMMENT:
//                    commentParser.parse(tab, token.getTokens());
//                    break;
//
//                case MAIN_METHOD:
//                    mainMethodParser.parse(tab, token.getTokens());
//                    break;
//
//                case FOR_LOOP:
//                    forLoopParser.parse(tab, token.getTokens());
//                    break;
//
//                case WHILE_LOOP:
//                    whileLoopParser.parse(tab, token.getTokens());
//                    break;
//
//                case IF:
//                    ifParser.parse(tab, token.getTokens());
//                    break;
//
//                case ELSE_IF:
//                    elseIfParser.parse(tab, token.getTokens());
//                    break;
//
//                case ELSE:
//                    elseParser.parse(tab, token.getTokens());
//                    break;
//
//                case CLASS:
//                    classParser.parse(tab, token.getTokens());
//                    break;
//
//                case FUNCTION:
//                    functionParser.parse(tab, token.getTokens());
//                    break;
//
//                case DOWHILE:
//                    functionParser.parse(tab, token.getTokens());
//                    break;
//
////                case SWITCH:
////                    switchParser.parse(tab, token.getTokens());
////                    break;
//
//                default:
//                    System.out.print("");
//                    break;
//            }
//            token = token.getNextToken();
//        }
//    }
//
//    public static void main(String[] args) throws FileNotFoundException {
//        SwitchParser switchParser = new SwitchParser();
//        Token token = new Token();
//        token.setTokens(new String[]{"switch", "(", "HelloSwitch", ")", "{",
//                "case", "VARIABLE", ":",
//                "int", "x", "=", "5", ";",
//                "break", ";",
//
//                "case", "IF", ":",
//                "if", "x", ">", "5", ";",
//                "break", ";",
//
//                "default", ":",
//                "sout(Final Ans)", ";",
//                "break", ";", "}"
//        });
//
//        System.out.println("hi");
//        switchParser.parse(tab, token);
//
//    }
//}


















//        SwitchMasterParser switchMasterParser = new SwitchMasterParser();
//        SwitchTokenizer switchTokenizer = new SwitchTokenizer();
//        try {
//            PrintStream out = new PrintStream(new FileOutputStream("pythonCode.txt", true));
//            PrintStream console = System.out;
//            //System.setOut(out);
//
//            LOGGER.info("Tab count: " + tab);
//            for (int i = 0; i < tab; i++){
//                System.out.print("\t");
//            }
//
//            int pos1;
//            String switchWord = null;
//            ArrayList<String> caseWords = new ArrayList<String>();
//
//            int n = 0;
//            for (pos1 = 0; pos1 <= tokenWords.length-1; pos1++) {
//                if (tokenWords[pos1].equals("break")) {
//                    n++;
//                }
//            }
//
//            int s = 0;
//
//            HashMap<Integer, ArrayList<String>> maps=new HashMap<Integer, ArrayList<String>>();
//
//            for (int i=0;i<n;i++)
//                maps.put(i,new ArrayList<String>());
//
//            ArrayList<String> temp = new ArrayList<>();
//
//            int parenthesisCount = 0;
//            boolean checker = false;
//            int pos = 0;
//            int colonSkip = 0;
//
//            for (pos = pos; pos < tokenWords.length-1; pos++) {
//                if (tokenWords[pos].equals("{")) {
//                    parenthesisCount++;
//                    //System.out.println(parenthesisCount);
//                }
//
//                if (tokenWords[pos].equals("}")) {
//                    parenthesisCount--;
//                    //System.out.println(parenthesisCount);
//                }
//
//                if (parenthesisCount != 0) {
//                    //System.out.println(checker);
//                    colonSkip = 1;
//
//                    if (tokenWords[pos].equals("switch")) {
//                        switchWord = tokenWords[pos + 2];
//                    }
//
//                    else if (tokenWords[pos].equals("case")) {
//                        caseWords.add(tokenWords[pos + 1]);
//                    }
//
//                    if (tokenWords[pos].equals(":")) {
//                        checker = true;
//                        do {
//                            if (tokenWords[pos].equals("break")) {
//                                maps.put(s, temp);
//                                temp = new ArrayList<>();
//                                s++;
//                                checker = false;
//                            }
//                            else {
//                                if (colonSkip > 0){
//                                    pos++;
//                                    colonSkip--;
//                                }
//                                else {
//                                    temp.add(tokenWords[pos]);
//                                    pos++;
//                                }
//                            }
//                        } while (checker);
//                    }
//                }
//            }
//
//            System.out.println(maps.get(0));
//            System.out.println(maps.get(1));
//            System.out.println(maps.get(2));
//
//            //switchMasterParser.acceptToken(maps.get(0).get(0));
//
//            for (int caseWordCount = 0; caseWordCount <= caseWords.size()-1; caseWordCount++){
//                System.out.println("def " + caseWords.get(caseWordCount) + "(): \n" + '\t' + "return " +
//                        maps.get(caseWordCount));
//            }
//        }
//        catch(IOException e1) {
//            System.out.println("Error during reading/writing");
//        }
//    }
//}








//                    if (checker = true) {
//                        if (tokenWords[pos].equals("break")) {
//                            pos++;
//                            maps.put(s, temp);
//                            s++;
//                            temp = new ArrayList<>();
//                        } else
//                        temp.add(tokenWords[pos]);
//                    }
//                    if (checker = false)
//                        System.out.println("nothing");






//                    if (tokenWords[pos].equals("switch")) {
//                        switchWord = tokenWords[pos + 2];
//                    }
//
//                    else if (tokenWords[pos].equals("case")) {
//                        caseWords.add(tokenWords[pos + 1]);
//                    }
//
//                    else if ((tokenWords[pos].equals(";") && maps.get(s).isEmpty())) {
//                        int trash = 1;
//                    }
//
//
////                    else if (tokenWords[pos].equals("switch") || tokenWords[pos].equals("case") || tokenWords[pos].equals(switchWord)
////                            || tokenWords[pos].equals("default")) {
////                        int trash = 1;
////                    }
//
//                    else if (tokenWords[pos].equals(switchWord) || tokenWords[pos].equals("default")) {
//                        int trash = 1;
//                    }
//
//                    else if (caseWords.contains(tokenWords[pos])) {
//                        pos++;
//                    }
//
//                    else if (tokenWords[pos].equals(":")) {
//                        pos++;
//                    }
//
////                if (tokenWords[pos].equals("break") && tokenWords[pos--].equals("break")) {
////                    pos++;
////                }
//
//                    else if (tokenWords[pos].equals("break")) {
//                        pos++;
//                        maps.put(s, temp);
//                        s++;
//                        temp = new ArrayList<>();
//                    }
//                else
//                    temp.add(tokenWords[pos]);
//                }




//                }
//            }