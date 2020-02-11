package parser;

public class PrintParser {

    public static void parse(String[]tokenWords){
        //AnotherTokenizer tokenizer = new AnotherTokenizer();
        int pos;

        System.out.print("print");

        for (pos = 1; pos <= tokenWords.length-1; pos++) {
            System.out.print(tokenWords[pos]);
        }
        //System.out.print("\n");

    }
}