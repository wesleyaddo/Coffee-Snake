package parser;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class IfParser {

    public static void parse(int tab, String[]tokenWords) throws FileNotFoundException

    {
        try {
            PrintStream out = new PrintStream(new FileOutputStream("pythonCode.txt", true));
            PrintStream console = System.out;
            System.setOut(out);

            for (int i = 0; i < tab; i++){
                System.out.print("\t");
            }

            int pos;
            System.out.print("if ");

            for (pos = 2; pos <= tokenWords.length-2; pos++) {
                //Add more variable type cases
                if ((tokenWords[pos] == "int") || (tokenWords[pos] == "double")){
                    //System.out.print("");
                } else {
                    System.out.print(tokenWords[pos]+ " ");
                }
            }
            System.out.print(":");
        }
        catch(IOException e1) {
            System.out.println("Error during reading/writing");
        }
    }
}