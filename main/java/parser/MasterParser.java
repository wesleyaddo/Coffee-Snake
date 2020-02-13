package main.java.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MasterParser {

    VariableParser variableParser;
    ForLoopParser forLoopParser;
    SemiColonParser semiColonParser;
    PrintParser printParser;
    OpenCurlyBracket openCurlyBracket;
    CommentParser commentParser;

    public MasterParser(){

        variableParser = new VariableParser();
        forLoopParser = new ForLoopParser();
        semiColonParser = new SemiColonParser();
        printParser = new PrintParser();
        openCurlyBracket = new OpenCurlyBracket();
        commentParser = new CommentParser();
    }

    public void showArray(String[]array){
        System.out.println(Arrays.toString(array));
    }

    public void showArraylistArrays(List<String[]> strings){
        for(String[] string : strings) {
            showArray(string);
        }
    }

    public String[] getArrayfromArraylist(int i, List<String[]> strings){
        String[] array = strings.get(i);
        return array;
    }

    public String getFirstWord(String[]array){
        return array[0];
    }

    public void addToPythonString(String converted){
        //converted.appe
    }

    public void acceptToken(:wq){

        int i = 0;
        String type;

        for (i=0; i <= tokenList.size()-1; i++){
            type = getFirstWord(getArrayfromArraylist(i, tokenList));
            switch (type){
                case ("int") :
                    variableParser.parse(getArrayfromArraylist(i, tokenList));
                    break;

                case ";":
                    semiColonParser.parse(getArrayfromArraylist(i, tokenList));
                    break;

                case "System.out.print":
                    printParser.parse(getArrayfromArraylist(i, tokenList));
                    break;

                case "{":
                    openCurlyBracket.parse(getArrayfromArraylist(i, tokenList));
                    break;

                case "//":
                    commentParser.parse(getArrayfromArraylist(i, tokenList));
                    break;

                case "for":
                    forLoopParser.parse(getArrayfromArraylist(i, tokenList));
                    break;

                default:
                    System.out.print("");
                    break;
            }
        }
    }


    public static void main(String[] args) {
        MasterParser masterParser = new MasterParser();
        List<String[]> tokenList = new ArrayList<>();


//        String[] token1 = {"for", "(", "int", "x", "=", "0", ";", "x", "<", "3", ";", "x", "+", "+", ")"};
//        String[] token2 = {"{"};
//        String[] token3 = {"int", "i", "=", "4", "+", "x"};
//        String[] token4 = {";"};
//        String[] token5 = {"System.out.print", "('Hello World')"};
//        String[] token6 = {";"};
//        String[] token7 = {"}"};
//        tokenList.add(token1);
//        tokenList.add(token2);
//        tokenList.add(token3);
//        tokenList.add(token4);
//        tokenList.add(token5);
//        tokenList.add(token6);
//        tokenList.add(token7);


        String[] token1 = {"for", "(", "int", "x", "=", "0", ";", "x", "<", "3", ";", "i", "+", "=", "2", ")"};
        String[] tokenComment = {"//", "Initialize and print"};
        String[] tokenA = {"int", "i", "=", "4", "+",  "x"};
        String[] tokenB = {";"};
        String[] tokenC = {"{"};
        String[] tokenD = {"System.out.print", "(", "'Hello World'", ")"};
        String[] tokenE = {";"};
        String[] tokenF = {"}"};

        tokenList.add(tokenComment);
        tokenList.add(tokenA);
        tokenList.add(tokenB);
        tokenList.add(token1);
        tokenList.add(tokenC);
        tokenList.add(tokenD);
        tokenList.add(tokenE);
        tokenList.add(tokenF);

        masterParser.acceptToken(tokenList);
    }
}




























//import language.LanguageKeywords;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class MasterParser {
//
//    public MasterParser(AnotherTokenizer tokenizer) {
//        //tokenTest = token;
//        tokenizerTest = tokenizer;
//        variableParser = new VariableParser();
//        forLoopParser = new ForLoopParser();
//        languageKeywords = new LanguageKeywords();
//    }
//    LanguageKeywords languageKeywords;
//    VariableParser variableParser;
//    ForLoopParser forLoopParser;
//    Token tokenTest;
//    AnotherTokenizer tokenizerTest;
//
//    public MasterParser(AnotherTokenizer tokenizer, List<Token> tokenList) {
//        //tokenTest = token;
//        tokenizerTest = new AnotherTokenizer();
//        variableParser = new VariableParser();
//        forLoopParser = new ForLoopParser();
//    }
//
//
//    public void acceptToken() {
//
//        //tokenizer.getFirstToken();
//        List<String> tempSent = new ArrayList<>();
//        tempSent.add("int x = 10");
//        tempSent.add("x");
//        tempSent.add("=");
//        tempSent.add("10");
//        tempSent.add(";");
////        token.setTokenSentence(tempSent);
//        int i = 0;
//
//        tokenizerTest.addTokenSentenceToList(tempSent);
//
//
//        System.out.println(tokenizerTest.getTokenList().isEmpty());
//
//
//        tokenizerTest.getTokenList().get(0).setTokenType("int");
//        tokenizerTest.getTokenList().get(1).setTokenType("");
//        tokenizerTest.getTokenList().get(2).setTokenType("");
//        tokenizerTest.getTokenList().get(3).setTokenType("");
//        tokenizerTest.getTokenList().get(4).setTokenType("");
//
//        System.out.println(tokenizerTest.getTokenList().get(0).getTokenType());
//
//        //tokenTest = tokenTest.nextToken;
//
//        do {
//            //System.out.println(tokenizerTest.getTokenList().get(0).getTokenType());
//            String type = tokenizerTest.getTokenList().get(0).getTokenType();
//            //System.out.println(languageKeywords.isKeyword(String.valueOf(type)));
//            //switch
//            if (!languageKeywords.isKeyword(type)) {
//                System.out.println(languageKeywords.isKeyword(type));
////                switch (keyword) {
//                //                  case "int":
//                variableParser.parse(tokenizerTest, tokenizerTest.getTokenList());
//                //            }
//            } else if (languageKeywords.isDelimiter(type)) {
//                forLoopParser.parse(tokenTest.getTokenSentence());
//            } else if (languageKeywords.isMethodCall(type)) {
//
//            } else if (languageKeywords.isSpaceDelimiter(type)) {
//
//            }
//
//            //tempSent = tempSent;
//            i++;
//        } while (i != tokenizerTest.getTokenList().size());
//
//    }
//}