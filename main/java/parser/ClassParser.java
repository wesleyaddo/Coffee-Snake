package parser;

import parserator.ParserConnector;

import java.io.*;
import java.util.logging.Logger;

public class ClassParser {
    private static final Logger LOGGER = Logger.getLogger(ClassParser.class.getName());
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
            System.out.print("class ");


            for (pos = 0; pos <= tokenWords.length-1; pos++) {
                //Add more variable type cases
                if (tokenWords[pos].equals("class") || tokenWords[pos].equals("private")|| tokenWords[pos].equals("protected") ||
                        tokenWords[pos].equals("public")){
                    continue;
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
