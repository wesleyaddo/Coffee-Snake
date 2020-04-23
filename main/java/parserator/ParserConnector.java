package parserator;

import parser.MainMethodParser;
import parser.MasterParser;
import tokenizer.Token;
import tokenizer.Tokenizer;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class ParserConnector {
    private static final Logger LOGGER = Logger.getLogger(ParserConnector.class.getName());
    public void workflowImplementor() throws FileNotFoundException {
        Tokenizer tokenizer = new Tokenizer();
        LOGGER.info("Tokenizer is building the token linked list");
        tokenizer.buildTokenLinkedList();

        Token token = tokenizer.getFirstToken();
        LOGGER.info("The token is" + Arrays.asList(token.getTokens()));
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