import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.io.*; 

  public class AnotherTokenizer
{
  public static void main(String[] args) throws IOException,FileNotFoundException
  {

     FileReader fr = new FileReader("test1.lua");
      BufferedReader br = new BufferedReader(fr);
      StreamTokenizer streamtokenizer = new StreamTokenizer(br);
      int [] a = new int [99];

      streamtokenizer.eolIsSignificant(true);
  

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
                break;
              //print numbers
        case StreamTokenizer.TT_NUMBER:
               System.out.print(streamtokenizer.nval + " ");
               break;
            //prints everything inside quotes   
        case '\"':
               System.out.print('"' + streamtokenizer.sval + '"');
               break;
               //ignores bracket
        case '{':
          streamtokenizer.nextToken();
               break;
               //ignores bracket
         case '}':         
           streamtokenizer.nextToken();
               break;
        //case :
          //    System.out.println((char) t);
            //  break;
        default:
                    System.out.print((char) t );
       
      } 
      
      }
  }
  
}