package parser;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class ForLoopParser {

    public static void parse(int tab, String[]tokenWords)throws FileNotFoundException

    {
        try {
            PrintStream out = new PrintStream(new FileOutputStream("pythonCode.txt", true));
            PrintStream console = System.out;
            System.setOut(out);

            for (int i = 0; i < tab; i++){
                System.out.print("\t");
            }

            int pos;
            String num1 = null;
            String num2 = null;
            String num3 = null;

            for (pos = 1; pos <= tokenWords.length-1; pos++) {
                //System.out.print(tokenWords[pos] + " ");

                if ((tokenWords[pos-1].equals("=")&&(tokenWords[pos+1]).equals(";"))){
                    num1 = tokenWords[pos];
                }

                if ((num1 != null)&&((tokenWords[pos-1].equals("<")&&(tokenWords[pos+1]).equals(";")))){
                    num2 = tokenWords[pos];
                }
            }
            System.out.print("for " + tokenWords[3] + " in range(" + num1 + ", " + num2 + "):");
        }
        catch(IOException e1) {
            System.out.println("Error during reading/writing");
        }
    }
}