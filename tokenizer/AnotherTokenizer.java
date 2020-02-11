package tokenizer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
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
      int m = 10;
      int n = 20;
      String[][] tokens = new String[m][n];
      streamtokenizer.eolIsSignificant(true);
  
      String token = null;
      // column(array number) position
      int i = 0;
      // row position
      int j = 0;
      int t;
      while((t = streamtokenizer.nextToken()) != StreamTokenizer.TT_EOF)
      {
      switch (t)
      {
        //end of line
        case StreamTokenizer.TT_EOL: 
                System.out.println(" ");
          //moves to next array (column)
                i ++;
          //resets the array position back to 0 (rows)
                j = 0;
                break; 
            //print words    
       case StreamTokenizer.TT_WORD: 
                System.out.print(streamtokenizer.sval + " "); 
                token = streamtokenizer.sval;
                tokens[i][j] = token;
                j++;
                break;
              //print numbers
        case StreamTokenizer.TT_NUMBER:
               System.out.print(streamtokenizer.nval + " ");
               token = String.valueOf(streamtokenizer.nval);
               tokens[i][j] = token;
                j++;
               break;
            //prints everything inside quotes   
        case '"':
               token = String.valueOf((char)t);
               tokens[i][j] = token;
               j++;
               System.out.print((char) t);
               System.out.print(streamtokenizer.sval);
               token = streamtokenizer.sval;
               tokens[i][j] = token;
               j++;
               token = String.valueOf((char)t);
               System.out.print((char) t);
               tokens[i][j] = token;
               j++;
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
                    tokens[i][j] = token;
                    j++;

        
      } 


      }
      //goes down the columns and prints each array in order, does not print nulls
      System.out.println(" ");
      int a, b;
      for ( a = 0; a < m; a++){
        if(tokens[a] != null)
        for(b = 0; b < n; b++){
          if(tokens[a][b] != null)
      System.out.print(tokens[a][b] + " ");
      else
        b++;

  }
        System.out.println(" ");
      
      }
}
  }
