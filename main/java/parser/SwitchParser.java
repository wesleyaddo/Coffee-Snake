package parser;

import parserator.ParserConnector;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.logging.Logger;

public class SwitchParser {
    private static final Logger LOGGER = Logger.getLogger(FunctionParser.class.getName());
    public static void parse(int tab, String[]tokenWords) throws FileNotFoundException {
        try {
            PrintStream out = new PrintStream(new FileOutputStream("pythonCode.txt", true));
            PrintStream console = System.out;
            //System.setOut(out);

            LOGGER.info("Tab count: " + tab);
            for (int i = 0; i < tab; i++){
                System.out.print("\t");
            }

            int pos;
            String switchWord = null;
            ArrayList <String> caseWord = new ArrayList<String>();

            int n = 0;
            for (pos = 0; pos <= tokenWords.length-1; pos++) {
                if (tokenWords[pos].equals("break")) {
                    n++;
                }
            }

            ArrayList<String>[] caseText = new ArrayList[n+1];
            for (int i = 0; i < n; i++) {
                caseText[i] = new ArrayList<String>();
            }

            int s = 0;
            int t = 0;
            for (pos = 0; pos <= tokenWords.length-1; pos++) {

                if (tokenWords[pos].equals("switch")) {
                    switchWord = tokenWords[pos+2];
                }

                if (tokenWords[pos].equals("case")) {
                    caseWord.add(tokenWords[pos+1]);
                }

                if (tokenWords[pos].equals("break") ) {
                    //caseText[0].add(tokenWords[pos]);

                    s++;
                    t = 0;
                }

                System.out.println(tokenWords[pos]);
                System.out.println(s);
                caseText[s].add(tokenWords[pos]);

                //caseText[s].add(t, tokenWords[pos]);
                //t++;
            }


            for (int caseWordCount = 0; caseWordCount <= caseWord.size()-1; caseWordCount++){
                System.out.println("def " + caseWord.get(caseWordCount) + "(): \n" + '\t' + "return");
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < caseText[i].size(); j++) {
//                    System.out.println(caseText[i].indexOf(j));
//                    System.out.print(caseText[i].get(j) + " ");
//                    System.out.println(caseText[0].get(2));
//                    System.out.println(caseText[2].get(2));
//                    System.out.println(caseText[0].get(12));
                }
            }

//            for (int i = 0; i < caseText[1].size(); i++) {
//                System.out.print(caseText[1].get(i) + " ");
//            }
//
//            System.out.print(caseText[1].get(1) + " ");
        }
        catch(IOException e1) {
            System.out.println("Error during reading/writing");
        }
    }
}