package parser;

public class ForLoopParser {

    public static void parse(String[]tokenWords){
        //AnotherTokenizer tokenizer = new AnotherTokenizer();
        int pos;
        String num1 = null;
        String num2 = null;
        String num3 = null;

        for (pos = 1; pos <= tokenWords.length-1; pos++) {
            //System.out.print(tokenWords[pos] + " ");

            if ((tokenWords[pos-1] == "=")&&(tokenWords[pos+1]) == ";"){
                num1 = tokenWords[pos];
            }

            if ((num1 != null)&&(tokenWords[pos-1] == "<")&&(tokenWords[pos+1] == ";")){
                num2 = tokenWords[pos];
            }
        }
        System.out.println("for " + tokenWords[3] + " in range(" + num1 + ", " + num2 + ")");
    }
}