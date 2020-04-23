package parser;

import parserator.ParserConnector;

import java.io.*;
import java.util.logging.Logger;

public class MainMethodParser {
    private static final Logger LOGGER = Logger.getLogger(MainMethodParser.class.getName());
    public static void parse(int tab, String[]tokenWords) throws FileNotFoundException {
        try {
            PrintStream out = new PrintStream(new FileOutputStream("pythonCode.txt", true));
            PrintStream console = System.out;
            System.setOut(out);

            LOGGER.info("Tab count: " + tab);
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