package parser;

import java.io.*;

public class MainMethodParser {

    public static void parse(int tab, String[]tokenWords) throws FileNotFoundException {
        try {
            PrintStream out = new PrintStream(new FileOutputStream("pythonCode.txt", true));
            PrintStream console = System.out;
            System.setOut(out);

            for (int i = 0; i < tab; i++){
                System.out.print("\t");
            }

            System.out.print("def main():");
        }
        catch(IOException e1) {
            System.out.println("Error during reading/writing");
        }
    }
}