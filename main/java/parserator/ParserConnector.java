package parserator;

import parser.MasterParser;
import tokenizer.Token;
import tokenizer.Tokenizer;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class ParserConnector {
    public void workflowImplementor() throws FileNotFoundException {
        Tokenizer tokenizer = new Tokenizer();
        tokenizer.buildTokenLinkedList();
        Token token = tokenizer.getFirstToken();

        MasterParser masterParser = new MasterParser();
        PrintStream out = new PrintStream(new FileOutputStream("pythonCode.txt"));
       // out.close();
        masterParser.acceptToken(token);
    }

    public static void main(String[] args) throws FileNotFoundException {
        ParserConnector parserConnector = new ParserConnector();
        parserConnector.workflowImplementor();
    }
}