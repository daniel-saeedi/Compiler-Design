// Generated from C:/Users/Morteza Nouri/IdeaProjects/PLC-pahse2/src/main/grammar\SimpleLOOP.g4 by ANTLR 4.9.3
package parsers;

     import main.ast.nodes.*;
     import main.ast.nodes.declaration.*;
     import main.ast.nodes.declaration.classDec.*;
     import main.ast.nodes.declaration.classDec.classMembersDec.*;
     import main.ast.nodes.declaration.variableDec.*;
     import main.ast.nodes.expression.*;
     import main.ast.nodes.expression.operators.*;
     import main.ast.nodes.expression.values.*;
     import main.ast.nodes.expression.values.primitive.*;
     import main.ast.nodes.statement.*;
     import main.ast.nodes.statement.set.*;
     import main.ast.types.*;
     import main.ast.types.primitives.*;
     import main.ast.types.set.*;
     import main.ast.types.functionPointer.*;
     import main.ast.types.array.*;
     import java.util.*;
 
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleLOOPLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LINE_BREAK=1, CLASS=2, PUBLIC=3, PRIVATE=4, INITIALIZE=5, NEW=6, SELF=7, 
		RETURN=8, VOID=9, DELETE=10, INCLUDE=11, ADD=12, MERGE=13, PRINT=14, IF=15, 
		ELSE=16, ELSIF=17, PLUS=18, MINUS=19, MULT=20, DIVIDE=21, INC=22, DEC=23, 
		EQUAL=24, GREATER_THAN=25, LESS_THAN=26, ARROW=27, BAR=28, AND=29, OR=30, 
		NOT=31, TIF=32, TELSE=33, TRUE=34, FALSE=35, NULL=36, BEGIN=37, END=38, 
		INT=39, BOOL=40, FPTR=41, SET=42, EACH=43, DO=44, ASSIGN=45, SHARP=46, 
		LPAR=47, RPAR=48, LBRACK=49, RBRACK=50, LBRACE=51, RBRACE=52, COMMA=53, 
		DOT=54, SEMICOLON=55, NEWLINE=56, INT_VALUE=57, IDENTIFIER=58, CLASS_IDENTIFIER=59, 
		COMMENT=60, MLCOMMENT=61, WS=62;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LINE_BREAK", "CLASS", "PUBLIC", "PRIVATE", "INITIALIZE", "NEW", "SELF", 
			"RETURN", "VOID", "DELETE", "INCLUDE", "ADD", "MERGE", "PRINT", "IF", 
			"ELSE", "ELSIF", "PLUS", "MINUS", "MULT", "DIVIDE", "INC", "DEC", "EQUAL", 
			"GREATER_THAN", "LESS_THAN", "ARROW", "BAR", "AND", "OR", "NOT", "TIF", 
			"TELSE", "TRUE", "FALSE", "NULL", "BEGIN", "END", "INT", "BOOL", "FPTR", 
			"SET", "EACH", "DO", "ASSIGN", "SHARP", "LPAR", "RPAR", "LBRACK", "RBRACK", 
			"LBRACE", "RBRACE", "COMMA", "DOT", "SEMICOLON", "NEWLINE", "INT_VALUE", 
			"IDENTIFIER", "CLASS_IDENTIFIER", "COMMENT", "MLCOMMENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'class'", "'public'", "'private'", "'initialize'", "'new'", 
			"'self'", "'return'", "'void'", "'delete'", "'include'", "'add'", "'merge'", 
			"'print'", "'if'", "'else'", "'elsif'", "'+'", "'-'", "'*'", "'/'", "'++'", 
			"'--'", "'=='", "'>'", "'<'", "'->'", "'|'", "'&&'", "'||'", "'!'", "'?'", 
			"':'", "'true'", "'false'", "'null'", "'=begin'", "'=end'", "'int'", 
			"'bool'", "'fptr'", "'Set'", "'each'", "'do'", "'='", "'#'", "'('", "')'", 
			"'['", "']'", "'{'", "'}'", "','", "'.'", "';'", "'\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LINE_BREAK", "CLASS", "PUBLIC", "PRIVATE", "INITIALIZE", "NEW", 
			"SELF", "RETURN", "VOID", "DELETE", "INCLUDE", "ADD", "MERGE", "PRINT", 
			"IF", "ELSE", "ELSIF", "PLUS", "MINUS", "MULT", "DIVIDE", "INC", "DEC", 
			"EQUAL", "GREATER_THAN", "LESS_THAN", "ARROW", "BAR", "AND", "OR", "NOT", 
			"TIF", "TELSE", "TRUE", "FALSE", "NULL", "BEGIN", "END", "INT", "BOOL", 
			"FPTR", "SET", "EACH", "DO", "ASSIGN", "SHARP", "LPAR", "RPAR", "LBRACK", 
			"RBRACK", "LBRACE", "RBRACE", "COMMA", "DOT", "SEMICOLON", "NEWLINE", 
			"INT_VALUE", "IDENTIFIER", "CLASS_IDENTIFIER", "COMMENT", "MLCOMMENT", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public SimpleLOOPLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SimpleLOOP.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2@\u0198\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3!"+
		"\3!\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3"+
		"&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3*\3*"+
		"\3*\3+\3+\3+\3+\3,\3,\3,\3,\3,\3-\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61"+
		"\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\38"+
		"\38\39\39\3:\3:\3:\7:\u0161\n:\f:\16:\u0164\13:\5:\u0166\n:\3;\3;\7;\u016a"+
		"\n;\f;\16;\u016d\13;\3<\3<\7<\u0171\n<\f<\16<\u0174\13<\3=\3=\7=\u0178"+
		"\n=\f=\16=\u017b\13=\3=\3=\3=\3=\3>\3>\3>\3>\3>\3>\3>\3>\7>\u0189\n>\f"+
		">\16>\u018c\13>\3>\3>\3>\3>\3>\3>\3>\3?\3?\3?\3?\4\u0179\u018a\2@\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s"+
		";u<w=y>{?}@\3\2\b\3\2\63;\3\2\62;\4\2aac|\6\2\62;C\\aac|\3\2C\\\5\2\13"+
		"\13\17\17\"\"\2\u019d\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2"+
		"Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3"+
		"\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2"+
		"\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2"+
		"w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\3\177\3\2\2\2\5\u0085\3\2\2"+
		"\2\7\u008b\3\2\2\2\t\u0092\3\2\2\2\13\u009a\3\2\2\2\r\u00a5\3\2\2\2\17"+
		"\u00a9\3\2\2\2\21\u00ae\3\2\2\2\23\u00b5\3\2\2\2\25\u00ba\3\2\2\2\27\u00c1"+
		"\3\2\2\2\31\u00c9\3\2\2\2\33\u00cd\3\2\2\2\35\u00d3\3\2\2\2\37\u00d9\3"+
		"\2\2\2!\u00dc\3\2\2\2#\u00e1\3\2\2\2%\u00e7\3\2\2\2\'\u00e9\3\2\2\2)\u00eb"+
		"\3\2\2\2+\u00ed\3\2\2\2-\u00ef\3\2\2\2/\u00f2\3\2\2\2\61\u00f5\3\2\2\2"+
		"\63\u00f8\3\2\2\2\65\u00fa\3\2\2\2\67\u00fc\3\2\2\29\u00ff\3\2\2\2;\u0101"+
		"\3\2\2\2=\u0104\3\2\2\2?\u0107\3\2\2\2A\u0109\3\2\2\2C\u010b\3\2\2\2E"+
		"\u010d\3\2\2\2G\u0112\3\2\2\2I\u0118\3\2\2\2K\u011d\3\2\2\2M\u0124\3\2"+
		"\2\2O\u0129\3\2\2\2Q\u012d\3\2\2\2S\u0132\3\2\2\2U\u0137\3\2\2\2W\u013b"+
		"\3\2\2\2Y\u0140\3\2\2\2[\u0143\3\2\2\2]\u0145\3\2\2\2_\u0147\3\2\2\2a"+
		"\u0149\3\2\2\2c\u014b\3\2\2\2e\u014d\3\2\2\2g\u014f\3\2\2\2i\u0151\3\2"+
		"\2\2k\u0153\3\2\2\2m\u0155\3\2\2\2o\u0157\3\2\2\2q\u015b\3\2\2\2s\u0165"+
		"\3\2\2\2u\u0167\3\2\2\2w\u016e\3\2\2\2y\u0175\3\2\2\2{\u0180\3\2\2\2}"+
		"\u0194\3\2\2\2\177\u0080\7\61\2\2\u0080\u0081\7\61\2\2\u0081\u0082\7\f"+
		"\2\2\u0082\u0083\3\2\2\2\u0083\u0084\b\2\2\2\u0084\4\3\2\2\2\u0085\u0086"+
		"\7e\2\2\u0086\u0087\7n\2\2\u0087\u0088\7c\2\2\u0088\u0089\7u\2\2\u0089"+
		"\u008a\7u\2\2\u008a\6\3\2\2\2\u008b\u008c\7r\2\2\u008c\u008d\7w\2\2\u008d"+
		"\u008e\7d\2\2\u008e\u008f\7n\2\2\u008f\u0090\7k\2\2\u0090\u0091\7e\2\2"+
		"\u0091\b\3\2\2\2\u0092\u0093\7r\2\2\u0093\u0094\7t\2\2\u0094\u0095\7k"+
		"\2\2\u0095\u0096\7x\2\2\u0096\u0097\7c\2\2\u0097\u0098\7v\2\2\u0098\u0099"+
		"\7g\2\2\u0099\n\3\2\2\2\u009a\u009b\7k\2\2\u009b\u009c\7p\2\2\u009c\u009d"+
		"\7k\2\2\u009d\u009e\7v\2\2\u009e\u009f\7k\2\2\u009f\u00a0\7c\2\2\u00a0"+
		"\u00a1\7n\2\2\u00a1\u00a2\7k\2\2\u00a2\u00a3\7|\2\2\u00a3\u00a4\7g\2\2"+
		"\u00a4\f\3\2\2\2\u00a5\u00a6\7p\2\2\u00a6\u00a7\7g\2\2\u00a7\u00a8\7y"+
		"\2\2\u00a8\16\3\2\2\2\u00a9\u00aa\7u\2\2\u00aa\u00ab\7g\2\2\u00ab\u00ac"+
		"\7n\2\2\u00ac\u00ad\7h\2\2\u00ad\20\3\2\2\2\u00ae\u00af\7t\2\2\u00af\u00b0"+
		"\7g\2\2\u00b0\u00b1\7v\2\2\u00b1\u00b2\7w\2\2\u00b2\u00b3\7t\2\2\u00b3"+
		"\u00b4\7p\2\2\u00b4\22\3\2\2\2\u00b5\u00b6\7x\2\2\u00b6\u00b7\7q\2\2\u00b7"+
		"\u00b8\7k\2\2\u00b8\u00b9\7f\2\2\u00b9\24\3\2\2\2\u00ba\u00bb\7f\2\2\u00bb"+
		"\u00bc\7g\2\2\u00bc\u00bd\7n\2\2\u00bd\u00be\7g\2\2\u00be\u00bf\7v\2\2"+
		"\u00bf\u00c0\7g\2\2\u00c0\26\3\2\2\2\u00c1\u00c2\7k\2\2\u00c2\u00c3\7"+
		"p\2\2\u00c3\u00c4\7e\2\2\u00c4\u00c5\7n\2\2\u00c5\u00c6\7w\2\2\u00c6\u00c7"+
		"\7f\2\2\u00c7\u00c8\7g\2\2\u00c8\30\3\2\2\2\u00c9\u00ca\7c\2\2\u00ca\u00cb"+
		"\7f\2\2\u00cb\u00cc\7f\2\2\u00cc\32\3\2\2\2\u00cd\u00ce\7o\2\2\u00ce\u00cf"+
		"\7g\2\2\u00cf\u00d0\7t\2\2\u00d0\u00d1\7i\2\2\u00d1\u00d2\7g\2\2\u00d2"+
		"\34\3\2\2\2\u00d3\u00d4\7r\2\2\u00d4\u00d5\7t\2\2\u00d5\u00d6\7k\2\2\u00d6"+
		"\u00d7\7p\2\2\u00d7\u00d8\7v\2\2\u00d8\36\3\2\2\2\u00d9\u00da\7k\2\2\u00da"+
		"\u00db\7h\2\2\u00db \3\2\2\2\u00dc\u00dd\7g\2\2\u00dd\u00de\7n\2\2\u00de"+
		"\u00df\7u\2\2\u00df\u00e0\7g\2\2\u00e0\"\3\2\2\2\u00e1\u00e2\7g\2\2\u00e2"+
		"\u00e3\7n\2\2\u00e3\u00e4\7u\2\2\u00e4\u00e5\7k\2\2\u00e5\u00e6\7h\2\2"+
		"\u00e6$\3\2\2\2\u00e7\u00e8\7-\2\2\u00e8&\3\2\2\2\u00e9\u00ea\7/\2\2\u00ea"+
		"(\3\2\2\2\u00eb\u00ec\7,\2\2\u00ec*\3\2\2\2\u00ed\u00ee\7\61\2\2\u00ee"+
		",\3\2\2\2\u00ef\u00f0\7-\2\2\u00f0\u00f1\7-\2\2\u00f1.\3\2\2\2\u00f2\u00f3"+
		"\7/\2\2\u00f3\u00f4\7/\2\2\u00f4\60\3\2\2\2\u00f5\u00f6\7?\2\2\u00f6\u00f7"+
		"\7?\2\2\u00f7\62\3\2\2\2\u00f8\u00f9\7@\2\2\u00f9\64\3\2\2\2\u00fa\u00fb"+
		"\7>\2\2\u00fb\66\3\2\2\2\u00fc\u00fd\7/\2\2\u00fd\u00fe\7@\2\2\u00fe8"+
		"\3\2\2\2\u00ff\u0100\7~\2\2\u0100:\3\2\2\2\u0101\u0102\7(\2\2\u0102\u0103"+
		"\7(\2\2\u0103<\3\2\2\2\u0104\u0105\7~\2\2\u0105\u0106\7~\2\2\u0106>\3"+
		"\2\2\2\u0107\u0108\7#\2\2\u0108@\3\2\2\2\u0109\u010a\7A\2\2\u010aB\3\2"+
		"\2\2\u010b\u010c\7<\2\2\u010cD\3\2\2\2\u010d\u010e\7v\2\2\u010e\u010f"+
		"\7t\2\2\u010f\u0110\7w\2\2\u0110\u0111\7g\2\2\u0111F\3\2\2\2\u0112\u0113"+
		"\7h\2\2\u0113\u0114\7c\2\2\u0114\u0115\7n\2\2\u0115\u0116\7u\2\2\u0116"+
		"\u0117\7g\2\2\u0117H\3\2\2\2\u0118\u0119\7p\2\2\u0119\u011a\7w\2\2\u011a"+
		"\u011b\7n\2\2\u011b\u011c\7n\2\2\u011cJ\3\2\2\2\u011d\u011e\7?\2\2\u011e"+
		"\u011f\7d\2\2\u011f\u0120\7g\2\2\u0120\u0121\7i\2\2\u0121\u0122\7k\2\2"+
		"\u0122\u0123\7p\2\2\u0123L\3\2\2\2\u0124\u0125\7?\2\2\u0125\u0126\7g\2"+
		"\2\u0126\u0127\7p\2\2\u0127\u0128\7f\2\2\u0128N\3\2\2\2\u0129\u012a\7"+
		"k\2\2\u012a\u012b\7p\2\2\u012b\u012c\7v\2\2\u012cP\3\2\2\2\u012d\u012e"+
		"\7d\2\2\u012e\u012f\7q\2\2\u012f\u0130\7q\2\2\u0130\u0131\7n\2\2\u0131"+
		"R\3\2\2\2\u0132\u0133\7h\2\2\u0133\u0134\7r\2\2\u0134\u0135\7v\2\2\u0135"+
		"\u0136\7t\2\2\u0136T\3\2\2\2\u0137\u0138\7U\2\2\u0138\u0139\7g\2\2\u0139"+
		"\u013a\7v\2\2\u013aV\3\2\2\2\u013b\u013c\7g\2\2\u013c\u013d\7c\2\2\u013d"+
		"\u013e\7e\2\2\u013e\u013f\7j\2\2\u013fX\3\2\2\2\u0140\u0141\7f\2\2\u0141"+
		"\u0142\7q\2\2\u0142Z\3\2\2\2\u0143\u0144\7?\2\2\u0144\\\3\2\2\2\u0145"+
		"\u0146\7%\2\2\u0146^\3\2\2\2\u0147\u0148\7*\2\2\u0148`\3\2\2\2\u0149\u014a"+
		"\7+\2\2\u014ab\3\2\2\2\u014b\u014c\7]\2\2\u014cd\3\2\2\2\u014d\u014e\7"+
		"_\2\2\u014ef\3\2\2\2\u014f\u0150\7}\2\2\u0150h\3\2\2\2\u0151\u0152\7\177"+
		"\2\2\u0152j\3\2\2\2\u0153\u0154\7.\2\2\u0154l\3\2\2\2\u0155\u0156\7\60"+
		"\2\2\u0156n\3\2\2\2\u0157\u0158\7=\2\2\u0158\u0159\3\2\2\2\u0159\u015a"+
		"\b8\2\2\u015ap\3\2\2\2\u015b\u015c\7\f\2\2\u015cr\3\2\2\2\u015d\u0166"+
		"\7\62\2\2\u015e\u0162\t\2\2\2\u015f\u0161\t\3\2\2\u0160\u015f\3\2\2\2"+
		"\u0161\u0164\3\2\2\2\u0162\u0160\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0166"+
		"\3\2\2\2\u0164\u0162\3\2\2\2\u0165\u015d\3\2\2\2\u0165\u015e\3\2\2\2\u0166"+
		"t\3\2\2\2\u0167\u016b\t\4\2\2\u0168\u016a\t\5\2\2\u0169\u0168\3\2\2\2"+
		"\u016a\u016d\3\2\2\2\u016b\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016cv\3"+
		"\2\2\2\u016d\u016b\3\2\2\2\u016e\u0172\t\6\2\2\u016f\u0171\t\5\2\2\u0170"+
		"\u016f\3\2\2\2\u0171\u0174\3\2\2\2\u0172\u0170\3\2\2\2\u0172\u0173\3\2"+
		"\2\2\u0173x\3\2\2\2\u0174\u0172\3\2\2\2\u0175\u0179\7%\2\2\u0176\u0178"+
		"\13\2\2\2\u0177\u0176\3\2\2\2\u0178\u017b\3\2\2\2\u0179\u017a\3\2\2\2"+
		"\u0179\u0177\3\2\2\2\u017a\u017c\3\2\2\2\u017b\u0179\3\2\2\2\u017c\u017d"+
		"\7\f\2\2\u017d\u017e\3\2\2\2\u017e\u017f\b=\2\2\u017fz\3\2\2\2\u0180\u0181"+
		"\7?\2\2\u0181\u0182\7d\2\2\u0182\u0183\7g\2\2\u0183\u0184\7i\2\2\u0184"+
		"\u0185\7k\2\2\u0185\u0186\7p\2\2\u0186\u018a\3\2\2\2\u0187\u0189\13\2"+
		"\2\2\u0188\u0187\3\2\2\2\u0189\u018c\3\2\2\2\u018a\u018b\3\2\2\2\u018a"+
		"\u0188\3\2\2\2\u018b\u018d\3\2\2\2\u018c\u018a\3\2\2\2\u018d\u018e\7?"+
		"\2\2\u018e\u018f\7g\2\2\u018f\u0190\7p\2\2\u0190\u0191\7f\2\2\u0191\u0192"+
		"\3\2\2\2\u0192\u0193\b>\2\2\u0193|\3\2\2\2\u0194\u0195\t\7\2\2\u0195\u0196"+
		"\3\2\2\2\u0196\u0197\b?\2\2\u0197~\3\2\2\2\t\2\u0162\u0165\u016b\u0172"+
		"\u0179\u018a\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}