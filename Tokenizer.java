import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Tokenizer
{
    public static void main(String args[])throws Exception
    {
      try  {
        LinkedList<Token> tokList = new LinkedList<>();
        Scanner userinput = new Scanner(System.in);
        System.out.print("Enter name of file: ");
        String inputstring = userinput.next();
        byte[] stuff = Files.readAllBytes(Paths.get(inputstring));

        String[] testArr;
        
        //Break string down and put each word in test array
        testArr = seperateString(new String(stuff));

        //Create token object
        Token tokTest1 = new Token();
        
        //Set word in test array as token name
        tokTest1.setTokenName(testArr[2]);
        
        //Set token type
        tokTest1.setTokenType("string");
        
        //Print token name and type
        System.out.println(tokTest1.getTokenName());
        System.out.println(tokTest1.getTokenType());
        
        Token tokTest2 = new Token();
        tokTest2.setTokenName(testArr[0]);
        
        //Put token objects in token Linked List
        tokList.push(tokTest2);
        tokList.push(tokTest1);

        //Print token name of token object in Linked List position 1
        System.out.println("Token name in token linked list at position 1: " + tokList.get(1).getTokenName());
    } catch (IOException e){
      System.out.println(e);
 }
    }

    public static String[] seperateString(String fullString)
    {
        String[] arrOfStr = fullString.split(" ", -1);
        
        int i = 0;

        for (String a : arrOfStr){
            System.out.println("Word in string array position " + i + ": " + a);
            i++;
        }

        return arrOfStr;
    }


    static class Token
    {
        String tokenName;
        String tokenType;

        public String getTokenName() {
            return tokenName;
        }

        public void setTokenName(String tokenName) {
            this.tokenName = tokenName;
        }

        public String getTokenType() {
            return tokenType;
        }

        public void setTokenType(String tokenType) {
            this.tokenType = tokenType;
        }
    }
}
