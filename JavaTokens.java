import java.util.*;

public class JavaTokens
{
  
      private static final  Hashtable<String, String> jtokens = new Hashtable<String, String>(){
 {
  
      put("System.out.println" , "PRINT_STATEMENT");
      put("class", "CLASS_STATEMENT");
      put("public", "PUBLIC_STATEMENT");
      put("static", "STATIC_STATEMENT");
      put("void" , "VOID_STATEMENT");
      put("main", "MAIN_STATEMENT");
      put("(" , "LEFT_PAREN");
      put(")" , "RIGH_PAREN");
      put(" \" " , "QUOTATIONS");
      put("[" , "LEFT_BRACKET");
      put("]" , "RIGHT_BRACKET");
      put("args", "ARGS_STATEMENT");
      put("for" , "FOR_STATEMENT");
      put("while", "WHILE_STATEMENT");
      put("do", "DO_STATMENT");
      put("if", "IF_STATEMENT");
      put("else", "ELSE_STATEMENT");
      put("==" , "EQ_OP");
      put("!=" , "NE_OP");
      put("<", "LT_OP");
      put(">", "GT_OP");
      put(">=", "GE_OP");
      put("<=", "LE_OP");
      put(";", "SEMI_CO");
      put("+", "ADD_OP");
      put("-", "SUB_OP");
      put("*", "MULTI_OP");
      put("/" , "DIV_OP");
      put(":", "COLON");
      put(",", "COMMA");
      put("int" , "VARIABLE");
      put("String", "VARIABLE");
      put("Char" , "VARIABLE");
      put("Doube" , "VARIABLE");
      put("=+", "ASSIGN_OP");
      put("=", "ASSIGN");
      put("//", "COMMENT_LINE");
      put("/*", "COMMENT_START");
      //put("*/"), "COMMENT_END");
      put("a", "ID");
      put("b", "ID");
      put("c", "ID");
      put("d", "ID");
      put("e", "ID");
      put("f", "ID");
      put("g", "ID");
      put("h", "ID");
      put("i", "ID");
      put("j", "ID");
      put("k", "ID");
      put("l", "ID");
      put("m", "ID");
      put("n", "ID");
      put("o", "ID");
      put("p", "ID");
      put("q", "ID");
      put("r", "ID");
      put("s", "ID");
      put("t", "ID");
      put("u", "ID");
      put("v", "ID");
      put("w", "ID");
      put("x", "ID");
      put("y", "ID");
      put("z", "ID");
 }
  };
      
            public static String getToken(String token) {
                return jtokens.get(token);
            }
            //just a tester
              public static void main(String[] args) {
                System.out.println(getToken("class"));
            }
}