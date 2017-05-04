import java.util.ArrayList;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Tester {

	
	public static void main(String args[]){
		//ArrayList<String> result = new ArrayList<String>();
		
       ParseTree result = Tester.test();
	}
	
	public Tester(){
		
	}
	
	public static ParseTree test(){
		ANTLRInputStream input = new ANTLRInputStream("GET /hello.htm HTTP/1.1\r\nUser-Agent: Mozilla\r\nHost: www.tutorialspoint.com\r\n\r\nhfbsvgkjdrfgk");

        HTTPMessageLexer lexer = new HTTPMessageLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        HTTPMessageParser parser = new HTTPMessageParser(tokens);
        return parser.message(); // begin parsing at rule 'r'
	}
}
