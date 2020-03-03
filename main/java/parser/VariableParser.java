package parser;

//import java.util.ArrayList;
//import java.util.List;
//import java.util.ListIterator;
//
//public class VariableParser {
//
//    public static void parse(AnotherTokenizer tokenizer, List<Token> tokenList){
//        //AnotherTokenizer tokenizer = new AnotherTokenizer();
//        int pos;
//
//        for (pos = 1; pos <= tokenizer.getTokenList().size() -2; pos++) {
//            System.out.print(tokenizer.getTokenList().get(pos).getTokenName() + " ");
//        }
//    }
//}




//WITH WORKING VERSION 1
//import java.util.ArrayList;
//        import java.util.List;
//        import java.util.ListIterator;
//
//public class VariableParser {
//
//    public static void parse(AnotherTokenizer tokenizer, List<Token> tokenList){
//        //AnotherTokenizer tokenizer = new AnotherTokenizer();
//        int pos;
////        for (pos = 1; pos <= tokenList.size(); pos++) {
//        String newSentence;
//        for (pos = 1; pos <= tokenizer.getTokenList().size() -2; pos++) {
//            System.out.print(tokenizer.getTokenList().get(pos).getTokenName() + " ");
//            //System.out.println(tokenizer.getTokenList().size());
//        }
//    }
//}





//public class VariableParser {
//    public static void parse(List<String> tokenSentence){
//        int pos;
//        for (pos = 1; pos <= tokenSentence.size(); pos++) {
//            System.out.println(tokenSentence.get(pos));
//        }
//    }
//}










//public class VariableParser {
//    public static void parse(List<String> tokenSentence){
//        System.out.println("working variable parser");
//        System.out.println(tokenSentence);
//
//        String [] keyword = {"for", "if"};
//        String [] variableType = {"int", "double", "float"};
//        String [] mathExpr;
//        String [] parenthesis = {"(", ")"};
//        String [] bracket = {"[", "]"};
//        String [] braces = {"{", "}"};
//        Number num;
//
//        List <String> testString = new ArrayList<>();
//        testString.add("int");
//        testString.add("x");
//        testString.add("=");
//        testString.add("10");
//
//        String evaluator;
//        String lastString = testString.get(testString.size());
//        ListIterator<String> iterator = testString.listIterator();
////        do
////        {
////            switch (evaluator)
////            {
////                //end of line
////                case keyword:
////
////                    break;
////
////
////                default:
////                    System.out.print((char) t );
////                    token = String.valueOf((char)t);
////                    tokens[i][j] = token;
////                    j++;
////            }
////        }while (((String.valueOf(iterator.hasNext())) != lastString));
//
//
//    }
//}


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class VariableParser {

    public static void parse(int tab, String[]tokenWords) throws FileNotFoundException {
        try {
            PrintStream out = new PrintStream(new FileOutputStream("pythonCode.txt", true));
            PrintStream console = System.out;
            System.setOut(out);

            for (int i = 0; i < tab; i++){
                System.out.print("\t");
            }

            int pos;
            for (pos = 1; pos <= tokenWords.length-1; pos++) {
                System.out.print(tokenWords[pos] + " ");
            }
        }
        catch(IOException e1) {
            System.out.println("Error during reading/writing");
        }
    }
}