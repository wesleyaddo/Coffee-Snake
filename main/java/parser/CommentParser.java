package parser;

public class CommentParser {

    public static void parse(String[]tokenWords){
        //AnotherTokenizer tokenizer = new AnotherTokenizer();
        int pos;
        System.out.print("#");
        for (pos = 1; pos <= tokenWords.length-1; pos++) {
            System.out.print(tokenWords[pos]+ " ");
        }
    }
}