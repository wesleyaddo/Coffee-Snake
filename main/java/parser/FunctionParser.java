package parser;

public class FunctionParser {
    public static void parse(int tab, String[]tokenWords)
    {
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
                    tokenWords[pos].equals("String") || tokenWords[pos].equals("int")){
                System.out.print("");
            } else {
                System.out.print(tokenWords[pos]+ " ");
            }
        }
        System.out.print("):");
    }
}
