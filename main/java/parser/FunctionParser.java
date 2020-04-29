package parser;

import parserator.ParserConnector;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Logger;

//public class FunctionParser {
//    private static final Logger LOGGER = Logger.getLogger(FunctionParser.class.getName());
//    public static void parse(int tab, String[]tokenWords)
//    {
//        LOGGER.info("Tab count: " + tab);
//        for (int i = 0; i < tab; i++){
//            System.out.print("\t");
//        }
//
//        int pos;
//        System.out.print("def ");
//
//        for (pos = 0; pos <= tokenWords.length-2; pos++) {
//            //Add more variable type cases
//            if (tokenWords[pos].equals("class") || tokenWords[pos].equals("double")|| tokenWords[pos].equals("char") ||
//                    tokenWords[pos].equals("public") || tokenWords[pos].equals("private") ||tokenWords[pos].equals("protected") ||
//                    tokenWords[pos].equals("void") || tokenWords[pos].equals("static") ||
//                    tokenWords[pos].equals("String") || tokenWords[pos].equals("int")){
//                System.out.print("");
//            } else {
//                System.out.print(tokenWords[pos]+ " ");
//            }
//        }
//        System.out.print("):");
//    }
//}





public class FunctionParser {
    private static final Logger LOGGER = Logger.getLogger(FunctionParser.class.getName());
    public static void parse(int tab, String[]tokenWords) throws FileNotFoundException {
        try {
            PrintStream out = new PrintStream(new FileOutputStream("pythonCode.txt", true));
            PrintStream console = System.out;
            System.setOut(out);

            LOGGER.info("Tab count: " + tab);
            for (int i = 0; i < tab; i++){
                System.out.print("\t");
            }

            int pos;
            System.out.print("def ");

            for (pos = 0; pos <= tokenWords.length-2; pos++) {
                //Add more variable type cases
                if (tokenWords[pos].equals("class") || tokenWords[pos].equals("double")|| tokenWords[pos].equals("char") ||
                        tokenWords[pos].equals("public") || tokenWords[pos].equals("private") ||tokenWords[pos].equals("protected") ||
                        tokenWords[pos].equals("void") || tokenWords[pos].equals("static") ||
                        tokenWords[pos].equals("String") || tokenWords[pos].equals("int") || tokenWords[pos].equals("case")){
                    System.out.print("");
                } else {
                    System.out.print(tokenWords[pos]+ " ");
                }
            }
            System.out.print("):");
        }
        catch(IOException e1) {
            System.out.println("Error during reading/writing");
        }
    }
}
