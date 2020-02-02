import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.io.*; 

  public class AnotherTokenizer
{
  public static void main(String[] args) throws IOException,FileNotFoundException
  {

     FileReader fr = new FileReader("test1.lua");
      BufferedReader br = new BufferedReader(fr);
      StreamTokenizer streamtokenizer = new StreamTokenizer(br);
      List<String> tokens = new ArrayList<String>();

      streamtokenizer.eolIsSignificant(true);
  
      String token = null;
      int i = 0;
      int t;
      while((t = streamtokenizer.nextToken()) != StreamTokenizer.TT_EOF)
      {
      switch (t)
      {
        //end of line
        case StreamTokenizer.TT_EOL: 
                System.out.println(" "); 
                break; 
            //print words    
       case StreamTokenizer.TT_WORD: 
                System.out.print(streamtokenizer.sval + " "); 
                token = streamtokenizer.sval;
                tokens.add(token);
                break;
              //print numbers
        case StreamTokenizer.TT_NUMBER:
               System.out.print(streamtokenizer.nval + " ");
               token = streamtokenizer.sval;
                tokens.add(token);
               break;
            //prints everything inside quotes   
        case '"':
               token = String.valueOf((char)t);
               tokens.add(token);
               System.out.print((char) t);
               System.out.print(streamtokenizer.sval);
               token = streamtokenizer.sval;
                tokens.add(token);
               break;
               //ignores bracket
        case '{':
          streamtokenizer.nextToken();
               break;
               //ignores bracket
         case '}':         
           streamtokenizer.nextToken();
               break;
        default:
                    System.out.print((char) t );
                    token = String.valueOf((char)t);
                    tokens.add(token);
        
      } 


      }
      //prints out the arraylist
      for (int k= 0; k<tokens.size();k++)
      {
        //prints nothing if null
        if (tokens.get(k) == null)
         System.out.print(""); 
       else
       System.out.println(tokens.get(k)); 
        }
      
  }
  
}
