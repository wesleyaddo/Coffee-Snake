package parser;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class SemiColonParser {

    public static void parse(int tab, String[]tokenWords)throws FileNotFoundException

    {
        try {
            PrintStream out = new PrintStream(new FileOutputStream("pythonCode.txt", true));
            PrintStream console = System.out;
            System.setOut(out);

//        for (int i = 0; i < tab; i++){
//            System.out.print("\t");
//        }

            System.out.print("\n");
        }
        catch(IOException e1) {
            System.out.println("Error during reading/writing");
        }
    }
}


//public class VariableParser {
//
//    public static void parse(String[]tokenWords){
//        //AnotherTokenizer tokenizer = new AnotherTokenizer();
//        int pos;
//
//        for (pos = 1; pos <= tokenWords.length -2; pos++) {
//            System.out.print(tokenWords[pos] + " ");
//        }
//    }
//}