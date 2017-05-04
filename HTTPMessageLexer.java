// Generated from HTTPMessage.g4 by ANTLR 4.6
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HTTPMessageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, HTTPVersion=8, 
		CRLF=9, ATF=10, HTAB=11, COLON=12, LPAREN=13, RPAREN=14, U22T23=15, U25=16, 
		FSLASH=17, U3BT40=18, U5BT60=19, U7BT7E=20, OBSTEXT=21, SP=22, U7F=23, 
		ATUL=24, WTZL=25, V=26, GTZ=27, U7f=28, DCOLON=29, FSTOP=30, ZERO=31, 
		ONE=32, TWO=33, THREE=34, FOUR=35, FIVE=36, SIX=37, SEVEN=38, EIGHT=39, 
		NINE=40, EXCLAIMATION=41, DOLLAR=42, AMPER=43, SQUOTE=44, STAR=45, PLUS=46, 
		COMMA=47, SCOLON=48, EQUALS=49, MINUS=50, METHOD=51;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "HTTPVersion", 
		"CRLF", "ATF", "HTAB", "COLON", "LPAREN", "RPAREN", "U22T23", "U25", "FSLASH", 
		"U3BT40", "U5BT60", "U7BT7E", "OBSTEXT", "SP", "U7F", "ATUL", "WTZL", 
		"V", "GTZ", "U7f", "DCOLON", "FSTOP", "ZERO", "ONE", "TWO", "THREE", "FOUR", 
		"FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "EXCLAIMATION", "DOLLAR", "AMPER", 
		"SQUOTE", "STAR", "PLUS", "COMMA", "SCOLON", "EQUALS", "MINUS", "METHOD"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'?'", "'@'", "'_'", "'~'", "'%'", "'['", "']'", "'HTTP/1.1'", "'\r\n'", 
		null, "'\\u0009'", "':'", "'('", "')'", null, null, "'/'", null, null, 
		null, null, "' '", null, null, null, "'v'", null, null, "'::'", "'.'", 
		"'0'", "'1'", "'2'", "'3'", "'4'", "'5'", "'6'", "'7'", "'8'", "'9'", 
		"'!'", "'$'", "'&'", "'''", "'*'", "'+'", "','", "';'", "'='", "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "HTTPVersion", "CRLF", 
		"ATF", "HTAB", "COLON", "LPAREN", "RPAREN", "U22T23", "U25", "FSLASH", 
		"U3BT40", "U5BT60", "U7BT7E", "OBSTEXT", "SP", "U7F", "ATUL", "WTZL", 
		"V", "GTZ", "U7f", "DCOLON", "FSTOP", "ZERO", "ONE", "TWO", "THREE", "FOUR", 
		"FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "EXCLAIMATION", "DOLLAR", "AMPER", 
		"SQUOTE", "STAR", "PLUS", "COMMA", "SCOLON", "EQUALS", "MINUS", "METHOD"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public HTTPMessageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "HTTPMessage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\65\u00ec\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34"+
		"\3\34\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$"+
		"\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3"+
		"/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64"+
		"\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64"+
		"\5\64\u00eb\n\64\2\2\65\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63"+
		"\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62"+
		"c\63e\64g\65\3\2\13\3\2$%\3\2\'\'\3\2=B\3\2]b\3\2}\u0080\3\2\u0082\u0101"+
		"\3\2cw\3\2y|\3\2I\\\u00ef\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"+
		"\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2"+
		"\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2"+
		"\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]"+
		"\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\3i\3\2"+
		"\2\2\5k\3\2\2\2\7m\3\2\2\2\to\3\2\2\2\13q\3\2\2\2\rs\3\2\2\2\17u\3\2\2"+
		"\2\21w\3\2\2\2\23\u0080\3\2\2\2\25\u0083\3\2\2\2\27\u0085\3\2\2\2\31\u0087"+
		"\3\2\2\2\33\u0089\3\2\2\2\35\u008b\3\2\2\2\37\u008d\3\2\2\2!\u008f\3\2"+
		"\2\2#\u0091\3\2\2\2%\u0093\3\2\2\2\'\u0095\3\2\2\2)\u0097\3\2\2\2+\u0099"+
		"\3\2\2\2-\u009b\3\2\2\2/\u009d\3\2\2\2\61\u009f\3\2\2\2\63\u00a1\3\2\2"+
		"\2\65\u00a3\3\2\2\2\67\u00a5\3\2\2\29\u00a7\3\2\2\2;\u00a9\3\2\2\2=\u00ac"+
		"\3\2\2\2?\u00ae\3\2\2\2A\u00b0\3\2\2\2C\u00b2\3\2\2\2E\u00b4\3\2\2\2G"+
		"\u00b6\3\2\2\2I\u00b8\3\2\2\2K\u00ba\3\2\2\2M\u00bc\3\2\2\2O\u00be\3\2"+
		"\2\2Q\u00c0\3\2\2\2S\u00c2\3\2\2\2U\u00c4\3\2\2\2W\u00c6\3\2\2\2Y\u00c8"+
		"\3\2\2\2[\u00ca\3\2\2\2]\u00cc\3\2\2\2_\u00ce\3\2\2\2a\u00d0\3\2\2\2c"+
		"\u00d2\3\2\2\2e\u00d4\3\2\2\2g\u00ea\3\2\2\2ij\7A\2\2j\4\3\2\2\2kl\7B"+
		"\2\2l\6\3\2\2\2mn\7a\2\2n\b\3\2\2\2op\7\u0080\2\2p\n\3\2\2\2qr\7\'\2\2"+
		"r\f\3\2\2\2st\7]\2\2t\16\3\2\2\2uv\7_\2\2v\20\3\2\2\2wx\7J\2\2xy\7V\2"+
		"\2yz\7V\2\2z{\7R\2\2{|\7\61\2\2|}\7\63\2\2}~\7\60\2\2~\177\7\63\2\2\177"+
		"\22\3\2\2\2\u0080\u0081\7\17\2\2\u0081\u0082\7\f\2\2\u0082\24\3\2\2\2"+
		"\u0083\u0084\4CH\2\u0084\26\3\2\2\2\u0085\u0086\7\13\2\2\u0086\30\3\2"+
		"\2\2\u0087\u0088\7<\2\2\u0088\32\3\2\2\2\u0089\u008a\7*\2\2\u008a\34\3"+
		"\2\2\2\u008b\u008c\7+\2\2\u008c\36\3\2\2\2\u008d\u008e\t\2\2\2\u008e "+
		"\3\2\2\2\u008f\u0090\t\3\2\2\u0090\"\3\2\2\2\u0091\u0092\7\61\2\2\u0092"+
		"$\3\2\2\2\u0093\u0094\t\4\2\2\u0094&\3\2\2\2\u0095\u0096\t\5\2\2\u0096"+
		"(\3\2\2\2\u0097\u0098\t\6\2\2\u0098*\3\2\2\2\u0099\u009a\t\7\2\2\u009a"+
		",\3\2\2\2\u009b\u009c\7\"\2\2\u009c.\3\2\2\2\u009d\u009e\7\u0081\2\2\u009e"+
		"\60\3\2\2\2\u009f\u00a0\t\b\2\2\u00a0\62\3\2\2\2\u00a1\u00a2\t\t\2\2\u00a2"+
		"\64\3\2\2\2\u00a3\u00a4\7x\2\2\u00a4\66\3\2\2\2\u00a5\u00a6\t\n\2\2\u00a6"+
		"8\3\2\2\2\u00a7\u00a8\7\u0081\2\2\u00a8:\3\2\2\2\u00a9\u00aa\7<\2\2\u00aa"+
		"\u00ab\7<\2\2\u00ab<\3\2\2\2\u00ac\u00ad\7\60\2\2\u00ad>\3\2\2\2\u00ae"+
		"\u00af\7\62\2\2\u00af@\3\2\2\2\u00b0\u00b1\7\63\2\2\u00b1B\3\2\2\2\u00b2"+
		"\u00b3\7\64\2\2\u00b3D\3\2\2\2\u00b4\u00b5\7\65\2\2\u00b5F\3\2\2\2\u00b6"+
		"\u00b7\7\66\2\2\u00b7H\3\2\2\2\u00b8\u00b9\7\67\2\2\u00b9J\3\2\2\2\u00ba"+
		"\u00bb\78\2\2\u00bbL\3\2\2\2\u00bc\u00bd\79\2\2\u00bdN\3\2\2\2\u00be\u00bf"+
		"\7:\2\2\u00bfP\3\2\2\2\u00c0\u00c1\7;\2\2\u00c1R\3\2\2\2\u00c2\u00c3\7"+
		"#\2\2\u00c3T\3\2\2\2\u00c4\u00c5\7&\2\2\u00c5V\3\2\2\2\u00c6\u00c7\7("+
		"\2\2\u00c7X\3\2\2\2\u00c8\u00c9\7)\2\2\u00c9Z\3\2\2\2\u00ca\u00cb\7,\2"+
		"\2\u00cb\\\3\2\2\2\u00cc\u00cd\7-\2\2\u00cd^\3\2\2\2\u00ce\u00cf\7.\2"+
		"\2\u00cf`\3\2\2\2\u00d0\u00d1\7=\2\2\u00d1b\3\2\2\2\u00d2\u00d3\7?\2\2"+
		"\u00d3d\3\2\2\2\u00d4\u00d5\7/\2\2\u00d5f\3\2\2\2\u00d6\u00d7\7I\2\2\u00d7"+
		"\u00d8\7G\2\2\u00d8\u00eb\7V\2\2\u00d9\u00da\7R\2\2\u00da\u00db\7Q\2\2"+
		"\u00db\u00dc\7U\2\2\u00dc\u00eb\7V\2\2\u00dd\u00de\7J\2\2\u00de\u00df"+
		"\7G\2\2\u00df\u00e0\7C\2\2\u00e0\u00eb\7F\2\2\u00e1\u00e2\7R\2\2\u00e2"+
		"\u00e3\7W\2\2\u00e3\u00eb\7V\2\2\u00e4\u00e5\7F\2\2\u00e5\u00e6\7G\2\2"+
		"\u00e6\u00e7\7N\2\2\u00e7\u00e8\7G\2\2\u00e8\u00e9\7V\2\2\u00e9\u00eb"+
		"\7G\2\2\u00ea\u00d6\3\2\2\2\u00ea\u00d9\3\2\2\2\u00ea\u00dd\3\2\2\2\u00ea"+
		"\u00e1\3\2\2\2\u00ea\u00e4\3\2\2\2\u00ebh\3\2\2\2\4\2\u00ea\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}