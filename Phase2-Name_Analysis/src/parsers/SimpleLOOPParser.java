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
 
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleLOOPParser extends Parser {
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
	public static final int
		RULE_simpleLOOP = 0, RULE_program = 1, RULE_constructor = 2, RULE_classDeclaration = 3, 
		RULE_field_decleration = 4, RULE_method = 5, RULE_methodBody = 6, RULE_methodArgsDec = 7, 
		RULE_argDec = 8, RULE_methodArgs = 9, RULE_body = 10, RULE_blockStatement = 11, 
		RULE_singleStatement = 12, RULE_addStatement = 13, RULE_mergeStatement = 14, 
		RULE_deleteStatement = 15, RULE_varDecStatement = 16, RULE_ifStatement = 17, 
		RULE_elsifStatement = 18, RULE_condition = 19, RULE_elseStatement = 20, 
		RULE_printStatement = 21, RULE_methodCallStmt = 22, RULE_returnStatement = 23, 
		RULE_assignmentStatement = 24, RULE_loopStatement = 25, RULE_expression = 26, 
		RULE_ternaryExpression = 27, RULE_orExpression = 28, RULE_andExpression = 29, 
		RULE_equalityExpression = 30, RULE_relationalExpression = 31, RULE_additiveExpression = 32, 
		RULE_multiplicativeExpression = 33, RULE_preUnaryExpression = 34, RULE_postUnaryExpression = 35, 
		RULE_accessExpression = 36, RULE_otherExpression = 37, RULE_setNew = 38, 
		RULE_value = 39, RULE_boolValue = 40, RULE_class_identifier = 41, RULE_identifier = 42, 
		RULE_type = 43, RULE_array_type = 44, RULE_fptr_type = 45, RULE_typesWithComma = 46, 
		RULE_set_type = 47;
	private static String[] makeRuleNames() {
		return new String[] {
			"simpleLOOP", "program", "constructor", "classDeclaration", "field_decleration", 
			"method", "methodBody", "methodArgsDec", "argDec", "methodArgs", "body", 
			"blockStatement", "singleStatement", "addStatement", "mergeStatement", 
			"deleteStatement", "varDecStatement", "ifStatement", "elsifStatement", 
			"condition", "elseStatement", "printStatement", "methodCallStmt", "returnStatement", 
			"assignmentStatement", "loopStatement", "expression", "ternaryExpression", 
			"orExpression", "andExpression", "equalityExpression", "relationalExpression", 
			"additiveExpression", "multiplicativeExpression", "preUnaryExpression", 
			"postUnaryExpression", "accessExpression", "otherExpression", "setNew", 
			"value", "boolValue", "class_identifier", "identifier", "type", "array_type", 
			"fptr_type", "typesWithComma", "set_type"
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

	@Override
	public String getGrammarFileName() { return "SimpleLOOP.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimpleLOOPParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SimpleLOOPContext extends ParserRuleContext {
		public Program simpleLOOPProgram;
		public ProgramContext p;
		public TerminalNode EOF() { return getToken(SimpleLOOPParser.EOF, 0); }
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(SimpleLOOPParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SimpleLOOPParser.NEWLINE, i);
		}
		public SimpleLOOPContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleLOOP; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterSimpleLOOP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitSimpleLOOP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitSimpleLOOP(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleLOOPContext simpleLOOP() throws RecognitionException {
		SimpleLOOPContext _localctx = new SimpleLOOPContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_simpleLOOP);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(96);
					match(NEWLINE);
					}
					} 
				}
				setState(101);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(102);
			((SimpleLOOPContext)_localctx).p = program();
			((SimpleLOOPContext)_localctx).simpleLOOPProgram =  ((SimpleLOOPContext)_localctx).p.programRet;
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(104);
				match(NEWLINE);
				}
				}
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(110);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramContext extends ParserRuleContext {
		public Program programRet;
		public VarDecStatementContext v;
		public ClassDeclarationContext c;
		public List<VarDecStatementContext> varDecStatement() {
			return getRuleContexts(VarDecStatementContext.class);
		}
		public VarDecStatementContext varDecStatement(int i) {
			return getRuleContext(VarDecStatementContext.class,i);
		}
		public List<ClassDeclarationContext> classDeclaration() {
			return getRuleContexts(ClassDeclarationContext.class);
		}
		public ClassDeclarationContext classDeclaration(int i) {
			return getRuleContext(ClassDeclarationContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(SimpleLOOPParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SimpleLOOPParser.NEWLINE, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_program);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			((ProgramContext)_localctx).programRet =  new Program();
			     int line = 1;
			     _localctx.programRet.setLine(line);
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << FPTR) | (1L << SET) | (1L << CLASS_IDENTIFIER))) != 0)) {
				{
				{
				setState(113);
				((ProgramContext)_localctx).v = varDecStatement();
				setState(115); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(114);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(117); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );

				        for (VariableDeclaration varDec: ((ProgramContext)_localctx).v.varDecStmtRet)
				            _localctx.programRet.addGlobalVariable(varDec);
				    
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS) {
				{
				{
				setState(126);
				((ProgramContext)_localctx).c = classDeclaration();
				setState(128); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(127);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(130); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				_localctx.programRet.addClass(((ProgramContext)_localctx).c.classDeclarationRet);
				}
				}
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructorContext extends ParserRuleContext {
		public ConstructorDeclaration constructorDeclarationRet;
		public Token init;
		public MethodArgsDecContext mArgs;
		public MethodBodyContext m;
		public TerminalNode PUBLIC() { return getToken(SimpleLOOPParser.PUBLIC, 0); }
		public TerminalNode INITIALIZE() { return getToken(SimpleLOOPParser.INITIALIZE, 0); }
		public MethodArgsDecContext methodArgsDec() {
			return getRuleContext(MethodArgsDecContext.class,0);
		}
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(SimpleLOOPParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SimpleLOOPParser.NEWLINE, i);
		}
		public ConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitConstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitConstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorContext constructor() throws RecognitionException {
		ConstructorContext _localctx = new ConstructorContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_constructor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(PUBLIC);
			setState(140);
			((ConstructorContext)_localctx).init = match(INITIALIZE);
			setState(141);
			((ConstructorContext)_localctx).mArgs = methodArgsDec();
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(142);
				match(NEWLINE);
				}
				}
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(148);
			((ConstructorContext)_localctx).m = methodBody();

			        ((ConstructorContext)_localctx).constructorDeclarationRet =  new ConstructorDeclaration();
			        _localctx.constructorDeclarationRet.setLine(((ConstructorContext)_localctx).init.getLine());
			        _localctx.constructorDeclarationRet.setBody(((ConstructorContext)_localctx).m.methodBodyRet);
			        _localctx.constructorDeclarationRet.setLocalVars(((ConstructorContext)_localctx).m.localVars);
			        _localctx.constructorDeclarationRet.setArgs(((ConstructorContext)_localctx).mArgs.args);
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclarationContext extends ParserRuleContext {
		public ClassDeclaration classDeclarationRet;
		public Token line;
		public Class_identifierContext c;
		public Class_identifierContext cid2;
		public TerminalNode CLASS() { return getToken(SimpleLOOPParser.CLASS, 0); }
		public List<Class_identifierContext> class_identifier() {
			return getRuleContexts(Class_identifierContext.class);
		}
		public Class_identifierContext class_identifier(int i) {
			return getRuleContext(Class_identifierContext.class,i);
		}
		public TerminalNode LESS_THAN() { return getToken(SimpleLOOPParser.LESS_THAN, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(SimpleLOOPParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SimpleLOOPParser.NEWLINE, i);
		}
		public TerminalNode LBRACE() { return getToken(SimpleLOOPParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SimpleLOOPParser.RBRACE, 0); }
		public List<Field_declerationContext> field_decleration() {
			return getRuleContexts(Field_declerationContext.class);
		}
		public Field_declerationContext field_decleration(int i) {
			return getRuleContext(Field_declerationContext.class,i);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitClassDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitClassDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			((ClassDeclarationContext)_localctx).line = match(CLASS);
			setState(152);
			((ClassDeclarationContext)_localctx).c = class_identifier();
			((ClassDeclarationContext)_localctx).classDeclarationRet =  new ClassDeclaration(((ClassDeclarationContext)_localctx).c.class_id);
			                       _localctx.classDeclarationRet.setLine(((ClassDeclarationContext)_localctx).line.getLine());
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LESS_THAN) {
				{
				setState(154);
				match(LESS_THAN);
				setState(155);
				((ClassDeclarationContext)_localctx).cid2 = class_identifier();
				 _localctx.classDeclarationRet.setParentClassName(((ClassDeclarationContext)_localctx).cid2.class_id); 
				}
			}

			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(160);
				match(NEWLINE);
				}
				}
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(185);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				{
				setState(166);
				match(LBRACE);
				setState(168); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(167);
					match(NEWLINE);
					}
					}
					setState(170); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(178); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(172);
					field_decleration(_localctx.classDeclarationRet);
					setState(174); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(173);
						match(NEWLINE);
						}
						}
						setState(176); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					}
					}
					setState(180); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==PUBLIC || _la==PRIVATE );
				setState(182);
				match(RBRACE);
				}
				}
				break;
			case PUBLIC:
			case PRIVATE:
				{
				{
				setState(184);
				field_decleration(_localctx.classDeclarationRet);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Field_declerationContext extends ParserRuleContext {
		public ClassDeclaration classDecl;
		public Token accessType;
		public VarDecStatementContext v;
		public MethodContext m;
		public ConstructorContext c;
		public ConstructorContext constructor() {
			return getRuleContext(ConstructorContext.class,0);
		}
		public TerminalNode PUBLIC() { return getToken(SimpleLOOPParser.PUBLIC, 0); }
		public TerminalNode PRIVATE() { return getToken(SimpleLOOPParser.PRIVATE, 0); }
		public VarDecStatementContext varDecStatement() {
			return getRuleContext(VarDecStatementContext.class,0);
		}
		public MethodContext method() {
			return getRuleContext(MethodContext.class,0);
		}
		public Field_declerationContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Field_declerationContext(ParserRuleContext parent, int invokingState, ClassDeclaration classDecl) {
			super(parent, invokingState);
			this.classDecl = classDecl;
		}
		@Override public int getRuleIndex() { return RULE_field_decleration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterField_decleration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitField_decleration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitField_decleration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Field_declerationContext field_decleration(ClassDeclaration classDecl) throws RecognitionException {
		Field_declerationContext _localctx = new Field_declerationContext(_ctx, getState(), classDecl);
		enterRule(_localctx, 8, RULE_field_decleration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(199);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				{
				setState(187);
				((Field_declerationContext)_localctx).accessType = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PUBLIC || _la==PRIVATE) ) {
					((Field_declerationContext)_localctx).accessType = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(194);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(188);
					((Field_declerationContext)_localctx).v = varDecStatement();

					            FieldDeclaration fd = new FieldDeclaration(((Field_declerationContext)_localctx).v.singleVarDeclRet, (((Field_declerationContext)_localctx).accessType!=null?((Field_declerationContext)_localctx).accessType.getText():null) == "private" ? true : false);
					            fd.setLine(((Field_declerationContext)_localctx).accessType.getLine());
					            _localctx.classDecl.addField(fd);
					        
					}
					break;
				case 2:
					{
					setState(191);
					((Field_declerationContext)_localctx).m = method();

					            MethodDeclaration newMethod = new MethodDeclaration(((Field_declerationContext)_localctx).m.id,((Field_declerationContext)_localctx).m.returnType, (((Field_declerationContext)_localctx).accessType!=null?((Field_declerationContext)_localctx).accessType.getText():null) == "private" ? true : false);
					            newMethod.setArgs(((Field_declerationContext)_localctx).m.args);
					            newMethod.setBody(((Field_declerationContext)_localctx).m.mBody);
					            newMethod.setLocalVars(((Field_declerationContext)_localctx).m.localVars);
					            newMethod.setLine(((Field_declerationContext)_localctx).accessType.getLine());
					            _localctx.classDecl.addMethod(newMethod);
					        
					}
					break;
				}
				}
				}
				break;
			case 2:
				{
				setState(196);
				((Field_declerationContext)_localctx).c = constructor();

				         _localctx.classDecl.setConstructor(((Field_declerationContext)_localctx).c.constructorDeclarationRet);
				     
				}
				break;
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodContext extends ParserRuleContext {
		public MethodDeclaration methodRet;
		public Identifier id;
		public Type returnType;
		public ArrayList<VariableDeclaration> args;
		public ArrayList<Statement> mBody;
		public ArrayList<VariableDeclaration> localVars;
		public TypeContext t;
		public IdentifierContext id_;
		public MethodArgsDecContext mArgs;
		public MethodBodyContext mBody_;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public MethodArgsDecContext methodArgsDec() {
			return getRuleContext(MethodArgsDecContext.class,0);
		}
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(SimpleLOOPParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SimpleLOOPParser.NEWLINE, i);
		}
		public TerminalNode VOID() { return getToken(SimpleLOOPParser.VOID, 0); }
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_method);
		int _la;
		try {
			setState(225);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case FPTR:
			case SET:
			case CLASS_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(201);
				((MethodContext)_localctx).t = type();
				}
				setState(202);
				((MethodContext)_localctx).id_ = identifier();
				setState(203);
				((MethodContext)_localctx).mArgs = methodArgsDec();
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(204);
					match(NEWLINE);
					}
					}
					setState(209);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(210);
				((MethodContext)_localctx).mBody_ = methodBody();

				        ((MethodContext)_localctx).id =  ((MethodContext)_localctx).id_.id;
				        ((MethodContext)_localctx).args =  ((MethodContext)_localctx).mArgs.args;
				        ((MethodContext)_localctx).mBody =  ((MethodContext)_localctx).mBody_.methodBodyRet;
				        ((MethodContext)_localctx).returnType =  ((MethodContext)_localctx).t.typeRet;
				        ((MethodContext)_localctx).localVars =  ((MethodContext)_localctx).mBody_.localVars;
				     
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(213);
				match(VOID);
				}
				setState(214);
				((MethodContext)_localctx).id_ = identifier();
				setState(215);
				((MethodContext)_localctx).mArgs = methodArgsDec();
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(216);
					match(NEWLINE);
					}
					}
					setState(221);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(222);
				((MethodContext)_localctx).mBody_ = methodBody();

				              ((MethodContext)_localctx).id =  ((MethodContext)_localctx).id_.id;
				              ((MethodContext)_localctx).args =  ((MethodContext)_localctx).mArgs.args;
				              ((MethodContext)_localctx).mBody =  ((MethodContext)_localctx).mBody_.methodBodyRet;
				              ((MethodContext)_localctx).returnType =  new VoidType();
				              ((MethodContext)_localctx).localVars =  ((MethodContext)_localctx).mBody_.localVars;
				           
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodBodyContext extends ParserRuleContext {
		public ArrayList<Statement> methodBodyRet;
		public ArrayList<VariableDeclaration> localVars;
		public VarDecStatementContext v;
		public SingleStatementContext s;
		public TerminalNode LBRACE() { return getToken(SimpleLOOPParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SimpleLOOPParser.RBRACE, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(SimpleLOOPParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SimpleLOOPParser.NEWLINE, i);
		}
		public List<VarDecStatementContext> varDecStatement() {
			return getRuleContexts(VarDecStatementContext.class);
		}
		public VarDecStatementContext varDecStatement(int i) {
			return getRuleContext(VarDecStatementContext.class,i);
		}
		public List<SingleStatementContext> singleStatement() {
			return getRuleContexts(SingleStatementContext.class);
		}
		public SingleStatementContext singleStatement(int i) {
			return getRuleContext(SingleStatementContext.class,i);
		}
		public MethodBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterMethodBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitMethodBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitMethodBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodBodyContext methodBody() throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_methodBody);
		int _la;
		try {
			int _alt;
			setState(267);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				((MethodBodyContext)_localctx).methodBodyRet =  new ArrayList<Statement>();
				    ((MethodBodyContext)_localctx).localVars =  new ArrayList<VariableDeclaration>();
				{
				setState(228);
				match(LBRACE);
				setState(230); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(229);
					match(NEWLINE);
					}
					}
					setState(232); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(243);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(234);
						((MethodBodyContext)_localctx).v = varDecStatement();
						_localctx.localVars.addAll(((MethodBodyContext)_localctx).v.varDecStmtRet);
						setState(237); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(236);
							match(NEWLINE);
							}
							}
							setState(239); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NEWLINE );
						}
						} 
					}
					setState(245);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				}
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SELF) | (1L << RETURN) | (1L << PRINT) | (1L << IF) | (1L << MINUS) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << SET) | (1L << LPAR) | (1L << INT_VALUE) | (1L << IDENTIFIER) | (1L << CLASS_IDENTIFIER))) != 0)) {
					{
					{
					setState(246);
					((MethodBodyContext)_localctx).s = singleStatement();
					_localctx.methodBodyRet.add(((MethodBodyContext)_localctx).s.singleStmntRet);
					setState(249); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(248);
						match(NEWLINE);
						}
						}
						setState(251); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					}
					}
					setState(257);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(258);
				match(RBRACE);
				}
				}
				break;
			case SELF:
			case RETURN:
			case PRINT:
			case IF:
			case MINUS:
			case NOT:
			case TRUE:
			case FALSE:
			case INT:
			case BOOL:
			case FPTR:
			case SET:
			case LPAR:
			case INT_VALUE:
			case IDENTIFIER:
			case CLASS_IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(265);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					{
					setState(259);
					((MethodBodyContext)_localctx).v = varDecStatement();
					((MethodBodyContext)_localctx).localVars =  ((MethodBodyContext)_localctx).v.varDecStmtRet;
					}
					}
					break;
				case 2:
					{
					{
					setState(262);
					((MethodBodyContext)_localctx).s = singleStatement();
					_localctx.methodBodyRet.add(((MethodBodyContext)_localctx).s.singleStmntRet);
					}
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodArgsDecContext extends ParserRuleContext {
		public ArrayList<VariableDeclaration> args;
		public Token line;
		public ArgDecContext arg;
		public TerminalNode RPAR() { return getToken(SimpleLOOPParser.RPAR, 0); }
		public TerminalNode LPAR() { return getToken(SimpleLOOPParser.LPAR, 0); }
		public List<ArgDecContext> argDec() {
			return getRuleContexts(ArgDecContext.class);
		}
		public ArgDecContext argDec(int i) {
			return getRuleContext(ArgDecContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleLOOPParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleLOOPParser.COMMA, i);
		}
		public List<TerminalNode> ASSIGN() { return getTokens(SimpleLOOPParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(SimpleLOOPParser.ASSIGN, i);
		}
		public List<OrExpressionContext> orExpression() {
			return getRuleContexts(OrExpressionContext.class);
		}
		public OrExpressionContext orExpression(int i) {
			return getRuleContext(OrExpressionContext.class,i);
		}
		public MethodArgsDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodArgsDec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterMethodArgsDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitMethodArgsDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitMethodArgsDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodArgsDecContext methodArgsDec() throws RecognitionException {
		MethodArgsDecContext _localctx = new MethodArgsDecContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_methodArgsDec);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			((MethodArgsDecContext)_localctx).args =  new ArrayList<VariableDeclaration>();
			setState(270);
			((MethodArgsDecContext)_localctx).line = match(LPAR);
			setState(297);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << FPTR) | (1L << SET) | (1L << CLASS_IDENTIFIER))) != 0)) {
				{
				setState(271);
				((MethodArgsDecContext)_localctx).arg = argDec(((MethodArgsDecContext)_localctx).line.getLine());
				_localctx.args.add(((MethodArgsDecContext)_localctx).arg.arg);
				setState(284);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ASSIGN:
					{
					{
					setState(273);
					match(ASSIGN);
					setState(274);
					orExpression();
					}
					}
					break;
				case RPAR:
				case COMMA:
					{
					setState(281);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(275);
							match(COMMA);
							setState(276);
							((MethodArgsDecContext)_localctx).arg = argDec(((MethodArgsDecContext)_localctx).line.getLine());
							_localctx.args.add(((MethodArgsDecContext)_localctx).arg.arg);
							}
							} 
						}
						setState(283);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(294);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(286);
					match(COMMA);
					setState(287);
					((MethodArgsDecContext)_localctx).arg = argDec(((MethodArgsDecContext)_localctx).line.getLine());
					_localctx.args.add(((MethodArgsDecContext)_localctx).arg.arg);
					setState(289);
					match(ASSIGN);
					setState(290);
					orExpression();
					}
					}
					setState(296);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(299);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgDecContext extends ParserRuleContext {
		public int line;
		public VariableDeclaration arg;
		public TypeContext t;
		public IdentifierContext id;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ArgDecContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ArgDecContext(ParserRuleContext parent, int invokingState, int line) {
			super(parent, invokingState);
			this.line = line;
		}
		@Override public int getRuleIndex() { return RULE_argDec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterArgDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitArgDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitArgDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgDecContext argDec(int line) throws RecognitionException {
		ArgDecContext _localctx = new ArgDecContext(_ctx, getState(), line);
		enterRule(_localctx, 16, RULE_argDec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			((ArgDecContext)_localctx).t = type();
			setState(302);
			((ArgDecContext)_localctx).id = identifier();
			((ArgDecContext)_localctx).arg =  new VariableDeclaration(((ArgDecContext)_localctx).id.id,((ArgDecContext)_localctx).t.typeRet); _localctx.arg.setLine(_localctx.line);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodArgsContext extends ParserRuleContext {
		public ArrayList<Expression> methodArgsRet;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleLOOPParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleLOOPParser.COMMA, i);
		}
		public MethodArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterMethodArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitMethodArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitMethodArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodArgsContext methodArgs() throws RecognitionException {
		MethodArgsContext _localctx = new MethodArgsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_methodArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((MethodArgsContext)_localctx).methodArgsRet =  new ArrayList<Expression>();
			setState(317);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SELF) | (1L << MINUS) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << SET) | (1L << LPAR) | (1L << INT_VALUE) | (1L << IDENTIFIER) | (1L << CLASS_IDENTIFIER))) != 0)) {
				{
				setState(306);
				((MethodArgsContext)_localctx).e1 = expression();
				_localctx.methodArgsRet.add(((MethodArgsContext)_localctx).e1.expressionRet);
				setState(314);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(308);
					match(COMMA);
					setState(309);
					((MethodArgsContext)_localctx).e2 = expression();
					_localctx.methodArgsRet.add(((MethodArgsContext)_localctx).e2.expressionRet);
					}
					}
					setState(316);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BodyContext extends ParserRuleContext {
		public Statement bodyRet;
		public BlockStatementContext b;
		public SingleStatementContext s;
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public SingleStatementContext singleStatement() {
			return getRuleContext(SingleStatementContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(SimpleLOOPParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SimpleLOOPParser.NEWLINE, i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(319);
				((BodyContext)_localctx).b = blockStatement();

				        ((BodyContext)_localctx).bodyRet =  ((BodyContext)_localctx).b.blockStatementRet;
				     
				}
				break;
			case NEWLINE:
				{
				{
				setState(323); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(322);
					match(NEWLINE);
					}
					}
					setState(325); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(327);
				((BodyContext)_localctx).s = singleStatement();
				((BodyContext)_localctx).bodyRet =  ((BodyContext)_localctx).s.singleStmntRet;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockStatementContext extends ParserRuleContext {
		public BlockStmt blockStatementRet;
		public ArrayList<Statement> stmts;
		public Token l;
		public SingleStatementContext s;
		public TerminalNode RBRACE() { return getToken(SimpleLOOPParser.RBRACE, 0); }
		public TerminalNode LBRACE() { return getToken(SimpleLOOPParser.LBRACE, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(SimpleLOOPParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SimpleLOOPParser.NEWLINE, i);
		}
		public List<SingleStatementContext> singleStatement() {
			return getRuleContexts(SingleStatementContext.class);
		}
		public SingleStatementContext singleStatement(int i) {
			return getRuleContext(SingleStatementContext.class,i);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitBlockStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_blockStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((BlockStatementContext)_localctx).stmts =  new ArrayList<Statement>();
			setState(333);
			((BlockStatementContext)_localctx).l = match(LBRACE);
			setState(335); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(334);
				match(NEWLINE);
				}
				}
				setState(337); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(348);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SELF) | (1L << RETURN) | (1L << PRINT) | (1L << IF) | (1L << MINUS) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << SET) | (1L << LPAR) | (1L << INT_VALUE) | (1L << IDENTIFIER) | (1L << CLASS_IDENTIFIER))) != 0)) {
				{
				{
				setState(339);
				((BlockStatementContext)_localctx).s = singleStatement();
				_localctx.stmts.add(((BlockStatementContext)_localctx).s.singleStmntRet);
				setState(342); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(341);
					match(NEWLINE);
					}
					}
					setState(344); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				}
				setState(350);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(351);
			match(RBRACE);

			        ((BlockStatementContext)_localctx).blockStatementRet =  new BlockStmt(_localctx.stmts);
			        _localctx.blockStatementRet.setLine(((BlockStatementContext)_localctx).l.getLine());
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleStatementContext extends ParserRuleContext {
		public Statement singleStmntRet;
		public IfStatementContext i;
		public PrintStatementContext pr;
		public MethodCallStmtContext mCall;
		public ReturnStatementContext r;
		public AssignmentStatementContext as;
		public LoopStatementContext l;
		public AddStatementContext addS;
		public MergeStatementContext m;
		public DeleteStatementContext d;
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public MethodCallStmtContext methodCallStmt() {
			return getRuleContext(MethodCallStmtContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public AssignmentStatementContext assignmentStatement() {
			return getRuleContext(AssignmentStatementContext.class,0);
		}
		public LoopStatementContext loopStatement() {
			return getRuleContext(LoopStatementContext.class,0);
		}
		public AddStatementContext addStatement() {
			return getRuleContext(AddStatementContext.class,0);
		}
		public MergeStatementContext mergeStatement() {
			return getRuleContext(MergeStatementContext.class,0);
		}
		public DeleteStatementContext deleteStatement() {
			return getRuleContext(DeleteStatementContext.class,0);
		}
		public SingleStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterSingleStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitSingleStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitSingleStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleStatementContext singleStatement() throws RecognitionException {
		SingleStatementContext _localctx = new SingleStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_singleStatement);
		try {
			setState(381);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(354);
				((SingleStatementContext)_localctx).i = ifStatement();

				        ((SingleStatementContext)_localctx).singleStmntRet =  ((SingleStatementContext)_localctx).i.ifStatementRet;
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(357);
				((SingleStatementContext)_localctx).pr = printStatement();

				        ((SingleStatementContext)_localctx).singleStmntRet =  ((SingleStatementContext)_localctx).pr.printStatementRet;
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(360);
				((SingleStatementContext)_localctx).mCall = methodCallStmt();

				        ((SingleStatementContext)_localctx).singleStmntRet =  ((SingleStatementContext)_localctx).mCall.methodCallStmtRet;
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(363);
				((SingleStatementContext)_localctx).r = returnStatement();

				        ((SingleStatementContext)_localctx).singleStmntRet =  ((SingleStatementContext)_localctx).r.returnStatementRet;
				    
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(366);
				((SingleStatementContext)_localctx).as = assignmentStatement();

				        ((SingleStatementContext)_localctx).singleStmntRet =  ((SingleStatementContext)_localctx).as.assignmentStatementRet;
				    
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(369);
				((SingleStatementContext)_localctx).l = loopStatement();

				        ((SingleStatementContext)_localctx).singleStmntRet =  ((SingleStatementContext)_localctx).l.loopStatementRet;
				    
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(372);
				((SingleStatementContext)_localctx).addS = addStatement();

				        ((SingleStatementContext)_localctx).singleStmntRet =  ((SingleStatementContext)_localctx).addS.addStatementRet;
				    
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(375);
				((SingleStatementContext)_localctx).m = mergeStatement();

				        ((SingleStatementContext)_localctx).singleStmntRet =  ((SingleStatementContext)_localctx).m.mergeStatementRet;
				    
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(378);
				((SingleStatementContext)_localctx).d = deleteStatement();

				        ((SingleStatementContext)_localctx).singleStmntRet =  ((SingleStatementContext)_localctx).d.deleteStatementRet;
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddStatementContext extends ParserRuleContext {
		public Statement addStatementRet;
		public ExpressionContext lv;
		public Token add;
		public OrExpressionContext rv;
		public TerminalNode DOT() { return getToken(SimpleLOOPParser.DOT, 0); }
		public TerminalNode LPAR() { return getToken(SimpleLOOPParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(SimpleLOOPParser.RPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ADD() { return getToken(SimpleLOOPParser.ADD, 0); }
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public AddStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterAddStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitAddStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitAddStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddStatementContext addStatement() throws RecognitionException {
		AddStatementContext _localctx = new AddStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_addStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			((AddStatementContext)_localctx).lv = expression();
			setState(384);
			match(DOT);
			setState(385);
			((AddStatementContext)_localctx).add = match(ADD);
			setState(386);
			match(LPAR);
			setState(387);
			((AddStatementContext)_localctx).rv = orExpression();
			setState(388);
			match(RPAR);

			        ((AddStatementContext)_localctx).addStatementRet =  new SetAdd(((AddStatementContext)_localctx).lv.expressionRet,((AddStatementContext)_localctx).rv.orExpressionRet);
			        _localctx.addStatementRet.setLine(((AddStatementContext)_localctx).add.getLine());
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MergeStatementContext extends ParserRuleContext {
		public Statement mergeStatementRet;
		public ExpressionContext lv;
		public Token merge;
		public OrExpressionContext rv;
		public TerminalNode DOT() { return getToken(SimpleLOOPParser.DOT, 0); }
		public TerminalNode LPAR() { return getToken(SimpleLOOPParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(SimpleLOOPParser.RPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode MERGE() { return getToken(SimpleLOOPParser.MERGE, 0); }
		public List<OrExpressionContext> orExpression() {
			return getRuleContexts(OrExpressionContext.class);
		}
		public OrExpressionContext orExpression(int i) {
			return getRuleContext(OrExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleLOOPParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleLOOPParser.COMMA, i);
		}
		public MergeStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mergeStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterMergeStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitMergeStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitMergeStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MergeStatementContext mergeStatement() throws RecognitionException {
		MergeStatementContext _localctx = new MergeStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_mergeStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
			((MergeStatementContext)_localctx).lv = expression();
			setState(392);
			match(DOT);
			setState(393);
			((MergeStatementContext)_localctx).merge = match(MERGE);
			setState(394);
			match(LPAR);
			setState(395);
			((MergeStatementContext)_localctx).rv = orExpression();
			setState(400);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(396);
				match(COMMA);
				setState(397);
				orExpression();
				}
				}
				setState(402);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(403);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeleteStatementContext extends ParserRuleContext {
		public Statement deleteStatementRet;
		public ExpressionContext lv;
		public Token delete;
		public OrExpressionContext rv;
		public TerminalNode DOT() { return getToken(SimpleLOOPParser.DOT, 0); }
		public TerminalNode LPAR() { return getToken(SimpleLOOPParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(SimpleLOOPParser.RPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DELETE() { return getToken(SimpleLOOPParser.DELETE, 0); }
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public DeleteStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterDeleteStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitDeleteStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitDeleteStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeleteStatementContext deleteStatement() throws RecognitionException {
		DeleteStatementContext _localctx = new DeleteStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_deleteStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(405);
			((DeleteStatementContext)_localctx).lv = expression();
			setState(406);
			match(DOT);
			setState(407);
			((DeleteStatementContext)_localctx).delete = match(DELETE);
			setState(408);
			match(LPAR);
			setState(409);
			((DeleteStatementContext)_localctx).rv = orExpression();
			setState(410);
			match(RPAR);

			        ((DeleteStatementContext)_localctx).deleteStatementRet =  new SetDelete(((DeleteStatementContext)_localctx).lv.expressionRet,((DeleteStatementContext)_localctx).rv.orExpressionRet);
			        _localctx.deleteStatementRet.setLine(((DeleteStatementContext)_localctx).delete.getLine());
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDecStatementContext extends ParserRuleContext {
		public ArrayList<VariableDeclaration> varDecStmtRet;
		public VariableDeclaration singleVarDeclRet;
		public TypeContext t;
		public IdentifierContext id;
		public IdentifierContext id2;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleLOOPParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleLOOPParser.COMMA, i);
		}
		public VarDecStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterVarDecStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitVarDecStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitVarDecStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDecStatementContext varDecStatement() throws RecognitionException {
		VarDecStatementContext _localctx = new VarDecStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_varDecStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((VarDecStatementContext)_localctx).varDecStmtRet =   new ArrayList<VariableDeclaration>();
			setState(414);
			((VarDecStatementContext)_localctx).t = type();
			setState(415);
			((VarDecStatementContext)_localctx).id = identifier();

			          VariableDeclaration newVar = new VariableDeclaration(((VarDecStatementContext)_localctx).id.id,((VarDecStatementContext)_localctx).t.typeRet);
			          newVar.setLine(((VarDecStatementContext)_localctx).id.line);
			          _localctx.varDecStmtRet.add(newVar);

			          ((VarDecStatementContext)_localctx).singleVarDeclRet =  newVar;
			     
			setState(423);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(417);
				match(COMMA);
				setState(418);
				((VarDecStatementContext)_localctx).id2 = identifier();

				        VariableDeclaration newVar2 = new VariableDeclaration(((VarDecStatementContext)_localctx).id2.id,((VarDecStatementContext)_localctx).t.typeRet);
				        newVar2.setLine(((VarDecStatementContext)_localctx).id2.line);
				        _localctx.varDecStmtRet.add(newVar2);
				     
				}
				}
				setState(425);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public ConditionalStmt ifStatementRet;
		public ArrayList<ElsifStmt> elifStmts;
		public Token ifKeyword;
		public ConditionContext cond;
		public BodyContext bRet;
		public ElsifStatementContext elif;
		public ElseStatementContext els;
		public TerminalNode IF() { return getToken(SimpleLOOPParser.IF, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public List<ElsifStatementContext> elsifStatement() {
			return getRuleContexts(ElsifStatementContext.class);
		}
		public ElsifStatementContext elsifStatement(int i) {
			return getRuleContext(ElsifStatementContext.class,i);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_ifStatement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(426);
			((IfStatementContext)_localctx).ifKeyword = match(IF);
			setState(427);
			((IfStatementContext)_localctx).cond = condition();
			setState(428);
			((IfStatementContext)_localctx).bRet = body();

			        ((IfStatementContext)_localctx).ifStatementRet =  new ConditionalStmt(((IfStatementContext)_localctx).cond.conditionRet,((IfStatementContext)_localctx).bRet.bodyRet);
			        _localctx.ifStatementRet.setLine((((IfStatementContext)_localctx).ifKeyword!=null?((IfStatementContext)_localctx).ifKeyword.getLine():0));
			    
			((IfStatementContext)_localctx).elifStmts =  new ArrayList<ElsifStmt>();
			setState(436);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(431);
					((IfStatementContext)_localctx).elif = elsifStatement();
					_localctx.elifStmts.add(((IfStatementContext)_localctx).elif.elsifStatementRet);
					}
					} 
				}
				setState(438);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			}
			setState(442);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				{
				setState(439);
				((IfStatementContext)_localctx).els = elseStatement();

				        _localctx.ifStatementRet.setElseBody(((IfStatementContext)_localctx).els.bodyRet);
				    
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElsifStatementContext extends ParserRuleContext {
		public ElsifStmt elsifStatementRet;
		public Token elif;
		public ConditionContext cond;
		public BodyContext b;
		public TerminalNode ELSIF() { return getToken(SimpleLOOPParser.ELSIF, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(SimpleLOOPParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SimpleLOOPParser.NEWLINE, i);
		}
		public ElsifStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elsifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterElsifStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitElsifStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitElsifStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElsifStatementContext elsifStatement() throws RecognitionException {
		ElsifStatementContext _localctx = new ElsifStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_elsifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(447);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(444);
				match(NEWLINE);
				}
				}
				setState(449);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(450);
			((ElsifStatementContext)_localctx).elif = match(ELSIF);
			setState(451);
			((ElsifStatementContext)_localctx).cond = condition();
			setState(452);
			((ElsifStatementContext)_localctx).b = body();

			        ((ElsifStatementContext)_localctx).elsifStatementRet =  new ElsifStmt(((ElsifStatementContext)_localctx).cond.conditionRet,((ElsifStatementContext)_localctx).b.bodyRet);
			        _localctx.elsifStatementRet.setLine((((ElsifStatementContext)_localctx).elif!=null?((ElsifStatementContext)_localctx).elif.getLine():0));
			     
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public Expression conditionRet;
		public ExpressionContext e;
		public TerminalNode LPAR() { return getToken(SimpleLOOPParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(SimpleLOOPParser.RPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_condition);
		try {
			setState(463);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(455);
				match(LPAR);
				setState(456);
				((ConditionContext)_localctx).e = expression();
				((ConditionContext)_localctx).conditionRet =  ((ConditionContext)_localctx).e.expressionRet;
				setState(458);
				match(RPAR);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(460);
				((ConditionContext)_localctx).e = expression();
				((ConditionContext)_localctx).conditionRet =  ((ConditionContext)_localctx).e.expressionRet;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseStatementContext extends ParserRuleContext {
		public Statement bodyRet;
		public int line;
		public Token el;
		public BodyContext b;
		public TerminalNode ELSE() { return getToken(SimpleLOOPParser.ELSE, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(SimpleLOOPParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SimpleLOOPParser.NEWLINE, i);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_elseStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(468);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(465);
				match(NEWLINE);
				}
				}
				setState(470);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(471);
			((ElseStatementContext)_localctx).el = match(ELSE);
			setState(472);
			((ElseStatementContext)_localctx).b = body();

			        ((ElseStatementContext)_localctx).line =  ((ElseStatementContext)_localctx).el.getLine();
			        ((ElseStatementContext)_localctx).bodyRet =  ((ElseStatementContext)_localctx).b.bodyRet;
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintStatementContext extends ParserRuleContext {
		public PrintStmt printStatementRet;
		public Token print;
		public ExpressionContext e;
		public TerminalNode LPAR() { return getToken(SimpleLOOPParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(SimpleLOOPParser.RPAR, 0); }
		public TerminalNode PRINT() { return getToken(SimpleLOOPParser.PRINT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterPrintStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitPrintStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitPrintStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintStatementContext printStatement() throws RecognitionException {
		PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_printStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(475);
			((PrintStatementContext)_localctx).print = match(PRINT);
			setState(476);
			match(LPAR);
			setState(477);
			((PrintStatementContext)_localctx).e = expression();
			setState(478);
			match(RPAR);

			        ((PrintStatementContext)_localctx).printStatementRet =  new PrintStmt(((PrintStatementContext)_localctx).e.expressionRet);
			        _localctx.printStatementRet.setLine((((PrintStatementContext)_localctx).print!=null?((PrintStatementContext)_localctx).print.getLine():0));
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodCallStmtContext extends ParserRuleContext {
		public MethodCallStmt methodCallStmtRet;
		public AccessExpressionContext ae;
		public Token lpar;
		public MethodArgsContext mArgs;
		public AccessExpressionContext accessExpression() {
			return getRuleContext(AccessExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(SimpleLOOPParser.RPAR, 0); }
		public TerminalNode LPAR() { return getToken(SimpleLOOPParser.LPAR, 0); }
		public MethodArgsContext methodArgs() {
			return getRuleContext(MethodArgsContext.class,0);
		}
		public MethodCallStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCallStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterMethodCallStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitMethodCallStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitMethodCallStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodCallStmtContext methodCallStmt() throws RecognitionException {
		MethodCallStmtContext _localctx = new MethodCallStmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_methodCallStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(481);
			((MethodCallStmtContext)_localctx).ae = accessExpression();
			{
			setState(482);
			((MethodCallStmtContext)_localctx).lpar = match(LPAR);
			setState(483);
			((MethodCallStmtContext)_localctx).mArgs = methodArgs();
			setState(484);
			match(RPAR);
			}

			        MethodCall methodCall = new MethodCall(((MethodCallStmtContext)_localctx).ae.accessExpressionRet, ((MethodCallStmtContext)_localctx).mArgs.methodArgsRet);
			        methodCall.setLine(((MethodCallStmtContext)_localctx).lpar.getLine());
			        ((MethodCallStmtContext)_localctx).methodCallStmtRet =  new MethodCallStmt(methodCall);
			        _localctx.methodCallStmtRet.setLine(((MethodCallStmtContext)_localctx).lpar.getLine());
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatementContext extends ParserRuleContext {
		public ReturnStmt returnStatementRet;
		public Token r;
		public ExpressionContext exp;
		public TerminalNode RETURN() { return getToken(SimpleLOOPParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ReturnStatementContext)_localctx).returnStatementRet =  new ReturnStmt();
			setState(489);
			((ReturnStatementContext)_localctx).r = match(RETURN);
			_localctx.returnStatementRet.setLine(((ReturnStatementContext)_localctx).r.getLine());
			setState(494);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SELF) | (1L << MINUS) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << SET) | (1L << LPAR) | (1L << INT_VALUE) | (1L << IDENTIFIER) | (1L << CLASS_IDENTIFIER))) != 0)) {
				{
				setState(491);
				((ReturnStatementContext)_localctx).exp = expression();
				_localctx.returnStatementRet.setReturnedExpr(((ReturnStatementContext)_localctx).exp.expressionRet);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentStatementContext extends ParserRuleContext {
		public AssignmentStmt assignmentStatementRet;
		public OrExpressionContext oe;
		public Token a;
		public ExpressionContext e;
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(SimpleLOOPParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterAssignmentStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitAssignmentStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitAssignmentStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentStatementContext assignmentStatement() throws RecognitionException {
		AssignmentStatementContext _localctx = new AssignmentStatementContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_assignmentStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(496);
			((AssignmentStatementContext)_localctx).oe = orExpression();
			setState(497);
			((AssignmentStatementContext)_localctx).a = match(ASSIGN);
			setState(498);
			((AssignmentStatementContext)_localctx).e = expression();

			        ((AssignmentStatementContext)_localctx).assignmentStatementRet =  new AssignmentStmt(((AssignmentStatementContext)_localctx).oe.orExpressionRet,((AssignmentStatementContext)_localctx).e.expressionRet);
			        _localctx.assignmentStatementRet.setLine(((AssignmentStatementContext)_localctx).a.getLine());
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoopStatementContext extends ParserRuleContext {
		public EachStmt loopStatementRet;
		public AccessExpressionContext ae;
		public Token each;
		public IdentifierContext var;
		public BodyContext b;
		public TerminalNode DOT() { return getToken(SimpleLOOPParser.DOT, 0); }
		public TerminalNode DO() { return getToken(SimpleLOOPParser.DO, 0); }
		public List<TerminalNode> BAR() { return getTokens(SimpleLOOPParser.BAR); }
		public TerminalNode BAR(int i) {
			return getToken(SimpleLOOPParser.BAR, i);
		}
		public AccessExpressionContext accessExpression() {
			return getRuleContext(AccessExpressionContext.class,0);
		}
		public TerminalNode EACH() { return getToken(SimpleLOOPParser.EACH, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public LoopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterLoopStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitLoopStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitLoopStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopStatementContext loopStatement() throws RecognitionException {
		LoopStatementContext _localctx = new LoopStatementContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_loopStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(501);
			((LoopStatementContext)_localctx).ae = accessExpression();
			setState(502);
			match(DOT);
			setState(503);
			((LoopStatementContext)_localctx).each = match(EACH);
			setState(504);
			match(DO);
			setState(505);
			match(BAR);
			setState(506);
			((LoopStatementContext)_localctx).var = identifier();
			setState(507);
			match(BAR);
			setState(508);
			((LoopStatementContext)_localctx).b = body();

			        ((LoopStatementContext)_localctx).loopStatementRet =  new EachStmt(((LoopStatementContext)_localctx).var.id,((LoopStatementContext)_localctx).ae.accessExpressionRet);
			        _localctx.loopStatementRet.setLine(((LoopStatementContext)_localctx).each.getLine());
			        _localctx.loopStatementRet.setBody(((LoopStatementContext)_localctx).b.bodyRet);
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Expression expressionRet;
		public TernaryExpressionContext oe1;
		public Token a;
		public ExpressionContext e;
		public Token inc;
		public OrExpressionContext oe2;
		public TernaryExpressionContext ternaryExpression() {
			return getRuleContext(TernaryExpressionContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SimpleLOOPParser.DOT, 0); }
		public TerminalNode LPAR() { return getToken(SimpleLOOPParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(SimpleLOOPParser.RPAR, 0); }
		public TerminalNode ASSIGN() { return getToken(SimpleLOOPParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode INCLUDE() { return getToken(SimpleLOOPParser.INCLUDE, 0); }
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(511);
			((ExpressionContext)_localctx).oe1 = ternaryExpression();
			 ((ExpressionContext)_localctx).expressionRet =  ((ExpressionContext)_localctx).oe1.ternaryExpressionRet; 
			setState(517);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(513);
				((ExpressionContext)_localctx).a = match(ASSIGN);
				setState(514);
				((ExpressionContext)_localctx).e = expression();

				        BinaryOperator op = BinaryOperator.assign;
				        ((ExpressionContext)_localctx).expressionRet =  new BinaryExpression(((ExpressionContext)_localctx).oe1.ternaryExpressionRet, ((ExpressionContext)_localctx).e.expressionRet, op);
				        _localctx.expressionRet.setLine(((ExpressionContext)_localctx).a.getLine());
				    
				}
			}

			setState(526);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				{
				setState(519);
				match(DOT);
				setState(520);
				((ExpressionContext)_localctx).inc = match(INCLUDE);
				setState(521);
				match(LPAR);
				setState(522);
				((ExpressionContext)_localctx).oe2 = orExpression();
				setState(523);
				match(RPAR);

				        ((ExpressionContext)_localctx).expressionRet =  new SetInclude(_localctx.expressionRet, ((ExpressionContext)_localctx).oe2.orExpressionRet);
				        _localctx.expressionRet.setLine(((ExpressionContext)_localctx).inc.getLine());
				    
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TernaryExpressionContext extends ParserRuleContext {
		public Expression ternaryExpressionRet;
		public OrExpressionContext oe;
		public Token t1;
		public TernaryExpressionContext trueExp;
		public Token t2;
		public TernaryExpressionContext falseExp;
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public TerminalNode TIF() { return getToken(SimpleLOOPParser.TIF, 0); }
		public List<TernaryExpressionContext> ternaryExpression() {
			return getRuleContexts(TernaryExpressionContext.class);
		}
		public TernaryExpressionContext ternaryExpression(int i) {
			return getRuleContext(TernaryExpressionContext.class,i);
		}
		public TerminalNode TELSE() { return getToken(SimpleLOOPParser.TELSE, 0); }
		public TernaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ternaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterTernaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitTernaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitTernaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TernaryExpressionContext ternaryExpression() throws RecognitionException {
		TernaryExpressionContext _localctx = new TernaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_ternaryExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(528);
			((TernaryExpressionContext)_localctx).oe = orExpression();
			 ((TernaryExpressionContext)_localctx).ternaryExpressionRet =  ((TernaryExpressionContext)_localctx).oe.orExpressionRet;
			setState(536);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIF) {
				{
				setState(530);
				((TernaryExpressionContext)_localctx).t1 = match(TIF);
				setState(531);
				((TernaryExpressionContext)_localctx).trueExp = ternaryExpression();
				setState(532);
				((TernaryExpressionContext)_localctx).t2 = match(TELSE);
				setState(533);
				((TernaryExpressionContext)_localctx).falseExp = ternaryExpression();

				        TernaryOperator op = TernaryOperator.ternary;
				        ((TernaryExpressionContext)_localctx).ternaryExpressionRet =  new TernaryExpression(((TernaryExpressionContext)_localctx).oe.orExpressionRet, ((TernaryExpressionContext)_localctx).trueExp.ternaryExpressionRet, ((TernaryExpressionContext)_localctx).falseExp.ternaryExpressionRet);
				        _localctx.ternaryExpressionRet.setLine(((TernaryExpressionContext)_localctx).t1.getLine());
				    
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrExpressionContext extends ParserRuleContext {
		public Expression orExpressionRet;
		public AndExpressionContext ael;
		public Token o;
		public AndExpressionContext aer;
		public List<AndExpressionContext> andExpression() {
			return getRuleContexts(AndExpressionContext.class);
		}
		public AndExpressionContext andExpression(int i) {
			return getRuleContext(AndExpressionContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(SimpleLOOPParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(SimpleLOOPParser.OR, i);
		}
		public OrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrExpressionContext orExpression() throws RecognitionException {
		OrExpressionContext _localctx = new OrExpressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_orExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(538);
			((OrExpressionContext)_localctx).ael = andExpression();
			 ((OrExpressionContext)_localctx).orExpressionRet =  ((OrExpressionContext)_localctx).ael.andExpressionRet; 
			setState(546);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(540);
				((OrExpressionContext)_localctx).o = match(OR);
				setState(541);
				((OrExpressionContext)_localctx).aer = andExpression();

				        BinaryOperator op = BinaryOperator.or;
				        ((OrExpressionContext)_localctx).orExpressionRet =  new BinaryExpression(_localctx.orExpressionRet, ((OrExpressionContext)_localctx).aer.andExpressionRet, op);
				        _localctx.orExpressionRet.setLine(((OrExpressionContext)_localctx).o.getLine());
				    
				}
				}
				setState(548);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AndExpressionContext extends ParserRuleContext {
		public Expression andExpressionRet;
		public EqualityExpressionContext eel;
		public Token a;
		public EqualityExpressionContext ee2;
		public List<EqualityExpressionContext> equalityExpression() {
			return getRuleContexts(EqualityExpressionContext.class);
		}
		public EqualityExpressionContext equalityExpression(int i) {
			return getRuleContext(EqualityExpressionContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(SimpleLOOPParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(SimpleLOOPParser.AND, i);
		}
		public AndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExpressionContext andExpression() throws RecognitionException {
		AndExpressionContext _localctx = new AndExpressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_andExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(549);
			((AndExpressionContext)_localctx).eel = equalityExpression();
			 ((AndExpressionContext)_localctx).andExpressionRet =  ((AndExpressionContext)_localctx).eel.equalityExpressionRet; 
			setState(557);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(551);
				((AndExpressionContext)_localctx).a = match(AND);
				setState(552);
				((AndExpressionContext)_localctx).ee2 = equalityExpression();

				            BinaryOperator op = BinaryOperator.and;
				            ((AndExpressionContext)_localctx).andExpressionRet =  new BinaryExpression(_localctx.andExpressionRet, ((AndExpressionContext)_localctx).ee2.equalityExpressionRet, op);
				            _localctx.andExpressionRet.setLine(((AndExpressionContext)_localctx).a.getLine());
				        
				}
				}
				setState(559);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqualityExpressionContext extends ParserRuleContext {
		public Expression equalityExpressionRet;
		public BinaryOperator op;
		public int line;
		public RelationalExpressionContext rel;
		public Token eq;
		public RelationalExpressionContext rer;
		public List<RelationalExpressionContext> relationalExpression() {
			return getRuleContexts(RelationalExpressionContext.class);
		}
		public RelationalExpressionContext relationalExpression(int i) {
			return getRuleContext(RelationalExpressionContext.class,i);
		}
		public List<TerminalNode> EQUAL() { return getTokens(SimpleLOOPParser.EQUAL); }
		public TerminalNode EQUAL(int i) {
			return getToken(SimpleLOOPParser.EQUAL, i);
		}
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitEqualityExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitEqualityExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_equalityExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(560);
			((EqualityExpressionContext)_localctx).rel = relationalExpression();
			 ((EqualityExpressionContext)_localctx).equalityExpressionRet =  ((EqualityExpressionContext)_localctx).rel.relationalExpressionRet; 
			setState(569);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EQUAL) {
				{
				{
				setState(562);
				((EqualityExpressionContext)_localctx).eq = match(EQUAL);

				        ((EqualityExpressionContext)_localctx).op =  BinaryOperator.eq;
				        ((EqualityExpressionContext)_localctx).line =  ((EqualityExpressionContext)_localctx).eq.getLine();
				    
				setState(564);
				((EqualityExpressionContext)_localctx).rer = relationalExpression();

				        ((EqualityExpressionContext)_localctx).equalityExpressionRet =  new BinaryExpression(_localctx.equalityExpressionRet, ((EqualityExpressionContext)_localctx).rer.relationalExpressionRet, _localctx.op);
				        _localctx.equalityExpressionRet.setLine(_localctx.line);
				    
				}
				}
				setState(571);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationalExpressionContext extends ParserRuleContext {
		public Expression relationalExpressionRet;
		public BinaryOperator op;
		public int line;
		public AdditiveExpressionContext ael;
		public Token gt;
		public Token lt;
		public AdditiveExpressionContext aer;
		public List<AdditiveExpressionContext> additiveExpression() {
			return getRuleContexts(AdditiveExpressionContext.class);
		}
		public AdditiveExpressionContext additiveExpression(int i) {
			return getRuleContext(AdditiveExpressionContext.class,i);
		}
		public List<TerminalNode> GREATER_THAN() { return getTokens(SimpleLOOPParser.GREATER_THAN); }
		public TerminalNode GREATER_THAN(int i) {
			return getToken(SimpleLOOPParser.GREATER_THAN, i);
		}
		public List<TerminalNode> LESS_THAN() { return getTokens(SimpleLOOPParser.LESS_THAN); }
		public TerminalNode LESS_THAN(int i) {
			return getToken(SimpleLOOPParser.LESS_THAN, i);
		}
		public RelationalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterRelationalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitRelationalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitRelationalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationalExpressionContext relationalExpression() throws RecognitionException {
		RelationalExpressionContext _localctx = new RelationalExpressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_relationalExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(572);
			((RelationalExpressionContext)_localctx).ael = additiveExpression();
			 ((RelationalExpressionContext)_localctx).relationalExpressionRet =  ((RelationalExpressionContext)_localctx).ael.additiveExpressionRet; 
			setState(585);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GREATER_THAN || _la==LESS_THAN) {
				{
				{
				setState(578);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case GREATER_THAN:
					{
					setState(574);
					((RelationalExpressionContext)_localctx).gt = match(GREATER_THAN);

					        ((RelationalExpressionContext)_localctx).op =  BinaryOperator.gt;
					        ((RelationalExpressionContext)_localctx).line =  ((RelationalExpressionContext)_localctx).gt.getLine();
					    
					}
					break;
				case LESS_THAN:
					{
					setState(576);
					((RelationalExpressionContext)_localctx).lt = match(LESS_THAN);

					        ((RelationalExpressionContext)_localctx).op =  BinaryOperator.lt;
					        ((RelationalExpressionContext)_localctx).line =  ((RelationalExpressionContext)_localctx).lt.getLine();
					    
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(580);
				((RelationalExpressionContext)_localctx).aer = additiveExpression();

				        ((RelationalExpressionContext)_localctx).relationalExpressionRet =  new BinaryExpression(_localctx.relationalExpressionRet, ((RelationalExpressionContext)_localctx).aer.additiveExpressionRet, _localctx.op);
				        _localctx.relationalExpressionRet.setLine(_localctx.line);
				    
				}
				}
				setState(587);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AdditiveExpressionContext extends ParserRuleContext {
		public Expression additiveExpressionRet;
		public BinaryOperator op;
		public int line;
		public MultiplicativeExpressionContext mel;
		public Token add;
		public Token sub;
		public MultiplicativeExpressionContext mer;
		public List<MultiplicativeExpressionContext> multiplicativeExpression() {
			return getRuleContexts(MultiplicativeExpressionContext.class);
		}
		public MultiplicativeExpressionContext multiplicativeExpression(int i) {
			return getRuleContext(MultiplicativeExpressionContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(SimpleLOOPParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(SimpleLOOPParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(SimpleLOOPParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(SimpleLOOPParser.MINUS, i);
		}
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitAdditiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitAdditiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_additiveExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(588);
			((AdditiveExpressionContext)_localctx).mel = multiplicativeExpression();
			 ((AdditiveExpressionContext)_localctx).additiveExpressionRet =  ((AdditiveExpressionContext)_localctx).mel.multiplicativeExpressionRet; 
			setState(601);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(594);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PLUS:
					{
					setState(590);
					((AdditiveExpressionContext)_localctx).add = match(PLUS);

					                       ((AdditiveExpressionContext)_localctx).op =  BinaryOperator.add;
					                       ((AdditiveExpressionContext)_localctx).line =  ((AdditiveExpressionContext)_localctx).add.getLine();
					                   
					}
					break;
				case MINUS:
					{
					setState(592);
					((AdditiveExpressionContext)_localctx).sub = match(MINUS);

					                       ((AdditiveExpressionContext)_localctx).op =  BinaryOperator.sub;
					                       ((AdditiveExpressionContext)_localctx).line =  ((AdditiveExpressionContext)_localctx).sub.getLine();
					                   
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(596);
				((AdditiveExpressionContext)_localctx).mer = multiplicativeExpression();

				                       ((AdditiveExpressionContext)_localctx).additiveExpressionRet =  new BinaryExpression(_localctx.additiveExpressionRet, ((AdditiveExpressionContext)_localctx).mer.multiplicativeExpressionRet, _localctx.op);
				                       _localctx.additiveExpressionRet.setLine(_localctx.line);
				                   
				}
				}
				setState(603);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public Expression multiplicativeExpressionRet;
		public BinaryOperator op;
		public int line;
		public PreUnaryExpressionContext pel;
		public Token mult;
		public Token div;
		public PreUnaryExpressionContext per;
		public List<PreUnaryExpressionContext> preUnaryExpression() {
			return getRuleContexts(PreUnaryExpressionContext.class);
		}
		public PreUnaryExpressionContext preUnaryExpression(int i) {
			return getRuleContext(PreUnaryExpressionContext.class,i);
		}
		public List<TerminalNode> MULT() { return getTokens(SimpleLOOPParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(SimpleLOOPParser.MULT, i);
		}
		public List<TerminalNode> DIVIDE() { return getTokens(SimpleLOOPParser.DIVIDE); }
		public TerminalNode DIVIDE(int i) {
			return getToken(SimpleLOOPParser.DIVIDE, i);
		}
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterMultiplicativeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitMultiplicativeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitMultiplicativeExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_multiplicativeExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(604);
			((MultiplicativeExpressionContext)_localctx).pel = preUnaryExpression();
			 ((MultiplicativeExpressionContext)_localctx).multiplicativeExpressionRet =  ((MultiplicativeExpressionContext)_localctx).pel.preUnaryExpressionRet; 
			setState(617);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULT || _la==DIVIDE) {
				{
				{
				setState(610);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MULT:
					{
					setState(606);
					((MultiplicativeExpressionContext)_localctx).mult = match(MULT);

					                ((MultiplicativeExpressionContext)_localctx).op =  BinaryOperator.mult;
					                ((MultiplicativeExpressionContext)_localctx).line =  ((MultiplicativeExpressionContext)_localctx).mult.getLine();
					            
					}
					break;
				case DIVIDE:
					{
					setState(608);
					((MultiplicativeExpressionContext)_localctx).div = match(DIVIDE);

					                ((MultiplicativeExpressionContext)_localctx).op =  BinaryOperator.div;
					                ((MultiplicativeExpressionContext)_localctx).line =  ((MultiplicativeExpressionContext)_localctx).div.getLine();
					            
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(612);
				((MultiplicativeExpressionContext)_localctx).per = preUnaryExpression();

				                ((MultiplicativeExpressionContext)_localctx).multiplicativeExpressionRet =  new BinaryExpression(_localctx.multiplicativeExpressionRet, ((MultiplicativeExpressionContext)_localctx).per.preUnaryExpressionRet, _localctx.op);
				                _localctx.multiplicativeExpressionRet.setLine(_localctx.line);
				            
				}
				}
				setState(619);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PreUnaryExpressionContext extends ParserRuleContext {
		public Expression preUnaryExpressionRet;
		public UnaryOperator op;
		public int line;
		public Token not;
		public Token minus;
		public PreUnaryExpressionContext pre;
		public PostUnaryExpressionContext pue;
		public PreUnaryExpressionContext preUnaryExpression() {
			return getRuleContext(PreUnaryExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SimpleLOOPParser.NOT, 0); }
		public TerminalNode MINUS() { return getToken(SimpleLOOPParser.MINUS, 0); }
		public PostUnaryExpressionContext postUnaryExpression() {
			return getRuleContext(PostUnaryExpressionContext.class,0);
		}
		public PreUnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preUnaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterPreUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitPreUnaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitPreUnaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreUnaryExpressionContext preUnaryExpression() throws RecognitionException {
		PreUnaryExpressionContext _localctx = new PreUnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_preUnaryExpression);
		try {
			setState(632);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(624);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NOT:
					{
					setState(620);
					((PreUnaryExpressionContext)_localctx).not = match(NOT);

					                       ((PreUnaryExpressionContext)_localctx).op =  UnaryOperator.not;
					                       ((PreUnaryExpressionContext)_localctx).line =  ((PreUnaryExpressionContext)_localctx).not.getLine();
					                   
					}
					break;
				case MINUS:
					{
					setState(622);
					((PreUnaryExpressionContext)_localctx).minus = match(MINUS);

					                       ((PreUnaryExpressionContext)_localctx).op =  UnaryOperator.minus;
					                       ((PreUnaryExpressionContext)_localctx).line =  ((PreUnaryExpressionContext)_localctx).minus.getLine();
					                   
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(626);
				((PreUnaryExpressionContext)_localctx).pre = preUnaryExpression();

				                       ((PreUnaryExpressionContext)_localctx).preUnaryExpressionRet =  new UnaryExpression(((PreUnaryExpressionContext)_localctx).pre.preUnaryExpressionRet, _localctx.op);
				                       _localctx.preUnaryExpressionRet.setLine(_localctx.line);
				                   
				}
				break;
			case SELF:
			case TRUE:
			case FALSE:
			case SET:
			case LPAR:
			case INT_VALUE:
			case IDENTIFIER:
			case CLASS_IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(629);
				((PreUnaryExpressionContext)_localctx).pue = postUnaryExpression();
				 ((PreUnaryExpressionContext)_localctx).preUnaryExpressionRet =  ((PreUnaryExpressionContext)_localctx).pue.postUnaryExpressionRet; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostUnaryExpressionContext extends ParserRuleContext {
		public Expression postUnaryExpressionRet;
		public UnaryOperator op;
		public int line;
		public AccessExpressionContext ae;
		public Token inc;
		public Token dec;
		public AccessExpressionContext accessExpression() {
			return getRuleContext(AccessExpressionContext.class,0);
		}
		public TerminalNode INC() { return getToken(SimpleLOOPParser.INC, 0); }
		public TerminalNode DEC() { return getToken(SimpleLOOPParser.DEC, 0); }
		public PostUnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postUnaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterPostUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitPostUnaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitPostUnaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostUnaryExpressionContext postUnaryExpression() throws RecognitionException {
		PostUnaryExpressionContext _localctx = new PostUnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_postUnaryExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(634);
			((PostUnaryExpressionContext)_localctx).ae = accessExpression();

			        ((PostUnaryExpressionContext)_localctx).postUnaryExpressionRet =  ((PostUnaryExpressionContext)_localctx).ae.accessExpressionRet;
			    
			setState(643);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INC || _la==DEC) {
				{
				setState(640);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INC:
					{
					setState(636);
					((PostUnaryExpressionContext)_localctx).inc = match(INC);

					        ((PostUnaryExpressionContext)_localctx).op =  UnaryOperator.postinc;
					        ((PostUnaryExpressionContext)_localctx).line =  ((PostUnaryExpressionContext)_localctx).inc.getLine();
					    
					}
					break;
				case DEC:
					{
					setState(638);
					((PostUnaryExpressionContext)_localctx).dec = match(DEC);

					        ((PostUnaryExpressionContext)_localctx).op =  UnaryOperator.postdec;
					        ((PostUnaryExpressionContext)_localctx).line =  ((PostUnaryExpressionContext)_localctx).dec.getLine();
					    
					}
					break;
				default:
					throw new NoViableAltException(this);
				}

				        ((PostUnaryExpressionContext)_localctx).postUnaryExpressionRet =  new UnaryExpression(((PostUnaryExpressionContext)_localctx).ae.accessExpressionRet, _localctx.op);
				        _localctx.postUnaryExpressionRet.setLine(_localctx.line);
				    
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AccessExpressionContext extends ParserRuleContext {
		public Expression accessExpressionRet;
		public OtherExpressionContext oe;
		public Token l1;
		public MethodArgsContext m;
		public Token dot;
		public IdentifierContext id;
		public Token n;
		public Token init;
		public Token lbrack;
		public ExpressionContext exp;
		public OtherExpressionContext otherExpression() {
			return getRuleContext(OtherExpressionContext.class,0);
		}
		public List<TerminalNode> RPAR() { return getTokens(SimpleLOOPParser.RPAR); }
		public TerminalNode RPAR(int i) {
			return getToken(SimpleLOOPParser.RPAR, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(SimpleLOOPParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(SimpleLOOPParser.RBRACK, i);
		}
		public List<TerminalNode> LPAR() { return getTokens(SimpleLOOPParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(SimpleLOOPParser.LPAR, i);
		}
		public List<MethodArgsContext> methodArgs() {
			return getRuleContexts(MethodArgsContext.class);
		}
		public MethodArgsContext methodArgs(int i) {
			return getRuleContext(MethodArgsContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(SimpleLOOPParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(SimpleLOOPParser.DOT, i);
		}
		public List<TerminalNode> LBRACK() { return getTokens(SimpleLOOPParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(SimpleLOOPParser.LBRACK, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> NEW() { return getTokens(SimpleLOOPParser.NEW); }
		public TerminalNode NEW(int i) {
			return getToken(SimpleLOOPParser.NEW, i);
		}
		public List<TerminalNode> INITIALIZE() { return getTokens(SimpleLOOPParser.INITIALIZE); }
		public TerminalNode INITIALIZE(int i) {
			return getToken(SimpleLOOPParser.INITIALIZE, i);
		}
		public AccessExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterAccessExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitAccessExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitAccessExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessExpressionContext accessExpression() throws RecognitionException {
		AccessExpressionContext _localctx = new AccessExpressionContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_accessExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(645);
			((AccessExpressionContext)_localctx).oe = otherExpression();
			 ((AccessExpressionContext)_localctx).accessExpressionRet =  ((AccessExpressionContext)_localctx).oe.otherExprRet; 
			setState(665);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(663);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LPAR:
						{
						{
						setState(647);
						((AccessExpressionContext)_localctx).l1 = match(LPAR);
						setState(648);
						((AccessExpressionContext)_localctx).m = methodArgs();
						setState(649);
						match(RPAR);
						}

						            ((AccessExpressionContext)_localctx).accessExpressionRet =  new MethodCall(_localctx.accessExpressionRet, ((AccessExpressionContext)_localctx).m.methodArgsRet);
						            _localctx.accessExpressionRet.setLine(((AccessExpressionContext)_localctx).l1.getLine());
						        
						}
						break;
					case DOT:
						{
						{
						setState(653);
						((AccessExpressionContext)_localctx).dot = match(DOT);
						setState(661);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case IDENTIFIER:
							{
							setState(654);
							((AccessExpressionContext)_localctx).id = identifier();

							                ((AccessExpressionContext)_localctx).accessExpressionRet =  new ObjectMemberAccess(_localctx.accessExpressionRet, ((AccessExpressionContext)_localctx).id.id);
							                _localctx.accessExpressionRet.setLine(((AccessExpressionContext)_localctx).dot.getLine());
							            
							}
							break;
						case NEW:
							{
							setState(657);
							((AccessExpressionContext)_localctx).n = match(NEW);

							                ((AccessExpressionContext)_localctx).accessExpressionRet =  new NewClassInstance(((AccessExpressionContext)_localctx).oe.ct);
							                _localctx.accessExpressionRet.setLine(((AccessExpressionContext)_localctx).n.getLine());
							            
							}
							break;
						case INITIALIZE:
							{
							setState(659);
							((AccessExpressionContext)_localctx).init = match(INITIALIZE);

							                Identifier id = new Identifier((((AccessExpressionContext)_localctx).init!=null?((AccessExpressionContext)_localctx).init.getText():null));
							                id.setLine(((AccessExpressionContext)_localctx).init.getLine());
							                ((AccessExpressionContext)_localctx).accessExpressionRet =  new ObjectMemberAccess(_localctx.accessExpressionRet, id);
							                _localctx.accessExpressionRet.setLine(((AccessExpressionContext)_localctx).init.getLine());
							            
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(667);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
			}
			setState(679);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(677);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case DOT:
						{
						{
						setState(668);
						((AccessExpressionContext)_localctx).dot = match(DOT);
						{
						setState(669);
						((AccessExpressionContext)_localctx).id = identifier();

						                 ((AccessExpressionContext)_localctx).accessExpressionRet =  new ObjectMemberAccess(_localctx.accessExpressionRet, ((AccessExpressionContext)_localctx).id.id);
						                _localctx.accessExpressionRet.setLine(((AccessExpressionContext)_localctx).dot.getLine());
						            
						}
						}
						}
						break;
					case LBRACK:
						{
						{
						setState(672);
						((AccessExpressionContext)_localctx).lbrack = match(LBRACK);
						setState(673);
						((AccessExpressionContext)_localctx).exp = expression();

						                 ((AccessExpressionContext)_localctx).accessExpressionRet =  new ArrayAccessByIndex(_localctx.accessExpressionRet, ((AccessExpressionContext)_localctx).exp.expressionRet);
						                _localctx.accessExpressionRet.setLine(((AccessExpressionContext)_localctx).lbrack.getLine());
						            
						setState(675);
						match(RBRACK);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(681);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OtherExpressionContext extends ParserRuleContext {
		public Expression otherExprRet;
		public ClassType ct;
		public Class_identifierContext c;
		public ValueContext v;
		public IdentifierContext id;
		public SetNewContext s;
		public Token lpar;
		public ExpressionContext exp;
		public Token self;
		public Class_identifierContext class_identifier() {
			return getRuleContext(Class_identifierContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public SetNewContext setNew() {
			return getRuleContext(SetNewContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(SimpleLOOPParser.RPAR, 0); }
		public TerminalNode LPAR() { return getToken(SimpleLOOPParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SELF() { return getToken(SimpleLOOPParser.SELF, 0); }
		public OtherExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_otherExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterOtherExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitOtherExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitOtherExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OtherExpressionContext otherExpression() throws RecognitionException {
		OtherExpressionContext _localctx = new OtherExpressionContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_otherExpression);
		try {
			setState(701);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASS_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(682);
				((OtherExpressionContext)_localctx).c = class_identifier();

				        ((OtherExpressionContext)_localctx).otherExprRet =  ((OtherExpressionContext)_localctx).c.class_id;
				        ((OtherExpressionContext)_localctx).ct =  new ClassType(((OtherExpressionContext)_localctx).c.class_id);
				    
				}
				break;
			case TRUE:
			case FALSE:
			case INT_VALUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(685);
				((OtherExpressionContext)_localctx).v = value();
				 ((OtherExpressionContext)_localctx).otherExprRet =  ((OtherExpressionContext)_localctx).v.valueRet; 
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(688);
				((OtherExpressionContext)_localctx).id = identifier();
				 ((OtherExpressionContext)_localctx).otherExprRet =  ((OtherExpressionContext)_localctx).id.id; 
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 4);
				{
				setState(691);
				((OtherExpressionContext)_localctx).s = setNew();

				        ((OtherExpressionContext)_localctx).otherExprRet =  ((OtherExpressionContext)_localctx).s.setNewRet;
				    
				}
				break;
			case LPAR:
				enterOuterAlt(_localctx, 5);
				{
				setState(694);
				((OtherExpressionContext)_localctx).lpar = match(LPAR);
				setState(695);
				((OtherExpressionContext)_localctx).exp = expression();
				setState(696);
				match(RPAR);

				        ((OtherExpressionContext)_localctx).otherExprRet =  ((OtherExpressionContext)_localctx).exp.expressionRet;
				        _localctx.otherExprRet.setLine(((OtherExpressionContext)_localctx).lpar.getLine());
				    
				}
				break;
			case SELF:
				enterOuterAlt(_localctx, 6);
				{
				setState(699);
				((OtherExpressionContext)_localctx).self = match(SELF);

				        ((OtherExpressionContext)_localctx).otherExprRet =  new SelfClass();
				        _localctx.otherExprRet.setLine(((OtherExpressionContext)_localctx).self.getLine());
				    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetNewContext extends ParserRuleContext {
		public SetNew setNewRet;
		public ArrayList<Expression> arguments;
		public Token set;
		public OrExpressionContext exp;
		public TerminalNode DOT() { return getToken(SimpleLOOPParser.DOT, 0); }
		public TerminalNode NEW() { return getToken(SimpleLOOPParser.NEW, 0); }
		public List<TerminalNode> LPAR() { return getTokens(SimpleLOOPParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(SimpleLOOPParser.LPAR, i);
		}
		public List<TerminalNode> RPAR() { return getTokens(SimpleLOOPParser.RPAR); }
		public TerminalNode RPAR(int i) {
			return getToken(SimpleLOOPParser.RPAR, i);
		}
		public TerminalNode SET() { return getToken(SimpleLOOPParser.SET, 0); }
		public List<OrExpressionContext> orExpression() {
			return getRuleContexts(OrExpressionContext.class);
		}
		public OrExpressionContext orExpression(int i) {
			return getRuleContext(OrExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleLOOPParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleLOOPParser.COMMA, i);
		}
		public SetNewContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setNew; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterSetNew(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitSetNew(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitSetNew(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetNewContext setNew() throws RecognitionException {
		SetNewContext _localctx = new SetNewContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_setNew);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(703);
			((SetNewContext)_localctx).set = match(SET);
			setState(704);
			match(DOT);
			setState(705);
			match(NEW);
			setState(706);
			match(LPAR);
			((SetNewContext)_localctx).arguments =  new ArrayList<Expression>();
			setState(722);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAR) {
				{
				setState(708);
				match(LPAR);
				setState(709);
				((SetNewContext)_localctx).exp = orExpression();
				_localctx.arguments.add(((SetNewContext)_localctx).exp.orExpressionRet);
				setState(717);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(711);
					match(COMMA);
					setState(712);
					((SetNewContext)_localctx).exp = orExpression();
					_localctx.arguments.add(((SetNewContext)_localctx).exp.orExpressionRet);
					}
					}
					setState(719);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(720);
				match(RPAR);
				}
			}

			setState(724);
			match(RPAR);

			        ((SetNewContext)_localctx).setNewRet =  new SetNew(_localctx.arguments);
			        _localctx.setNewRet.setLine((((SetNewContext)_localctx).set!=null?((SetNewContext)_localctx).set.getLine():0));
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public Value valueRet;
		public BoolValueContext bool;
		public Token i;
		public BoolValueContext boolValue() {
			return getRuleContext(BoolValueContext.class,0);
		}
		public TerminalNode INT_VALUE() { return getToken(SimpleLOOPParser.INT_VALUE, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_value);
		try {
			setState(732);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(727);
				((ValueContext)_localctx).bool = boolValue();

				            ((ValueContext)_localctx).valueRet =  new BoolValue(((ValueContext)_localctx).bool.boolValueRet);
				            _localctx.valueRet.setLine(((ValueContext)_localctx).bool.line);
				        
				}
				break;
			case INT_VALUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(730);
				((ValueContext)_localctx).i = match(INT_VALUE);

				            ((ValueContext)_localctx).valueRet =  new IntValue((((ValueContext)_localctx).i!=null?Integer.valueOf(((ValueContext)_localctx).i.getText()):0));
				            _localctx.valueRet.setLine(((ValueContext)_localctx).i.getLine());
				        
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolValueContext extends ParserRuleContext {
		public boolean boolValueRet;
		public int line;
		public Token tr;
		public Token fa;
		public TerminalNode TRUE() { return getToken(SimpleLOOPParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(SimpleLOOPParser.FALSE, 0); }
		public BoolValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterBoolValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitBoolValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitBoolValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolValueContext boolValue() throws RecognitionException {
		BoolValueContext _localctx = new BoolValueContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_boolValue);
		try {
			setState(738);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(734);
				((BoolValueContext)_localctx).tr = match(TRUE);

				    ((BoolValueContext)_localctx).boolValueRet =  true;
				    ((BoolValueContext)_localctx).line =  ((BoolValueContext)_localctx).tr.getLine();

				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(736);
				((BoolValueContext)_localctx).fa = match(FALSE);

				  ((BoolValueContext)_localctx).boolValueRet =  false;
				  ((BoolValueContext)_localctx).line =  ((BoolValueContext)_localctx).fa.getLine();

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_identifierContext extends ParserRuleContext {
		public Identifier class_id;
		public int line;
		public Token c;
		public TerminalNode CLASS_IDENTIFIER() { return getToken(SimpleLOOPParser.CLASS_IDENTIFIER, 0); }
		public Class_identifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterClass_identifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitClass_identifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitClass_identifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_identifierContext class_identifier() throws RecognitionException {
		Class_identifierContext _localctx = new Class_identifierContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_class_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(740);
			((Class_identifierContext)_localctx).c = match(CLASS_IDENTIFIER);

			            ((Class_identifierContext)_localctx).class_id =  new Identifier((((Class_identifierContext)_localctx).c!=null?((Class_identifierContext)_localctx).c.getText():null));
			            _localctx.class_id.setLine(((Class_identifierContext)_localctx).c.getLine());
			         
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public Identifier id;
		public int line;
		public Token identifierLine;
		public TerminalNode IDENTIFIER() { return getToken(SimpleLOOPParser.IDENTIFIER, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(743);
			((IdentifierContext)_localctx).identifierLine = match(IDENTIFIER);

			           ((IdentifierContext)_localctx).id =  new Identifier((((IdentifierContext)_localctx).identifierLine!=null?((IdentifierContext)_localctx).identifierLine.getText():null));
			           _localctx.id.setLine(((IdentifierContext)_localctx).identifierLine.getLine());

			           ((IdentifierContext)_localctx).line =  ((IdentifierContext)_localctx).identifierLine.getLine();
			       
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Type typeRet;
		public Array_typeContext a;
		public Fptr_typeContext f;
		public Set_typeContext s;
		public Class_identifierContext c;
		public TerminalNode INT() { return getToken(SimpleLOOPParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(SimpleLOOPParser.BOOL, 0); }
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public Fptr_typeContext fptr_type() {
			return getRuleContext(Fptr_typeContext.class,0);
		}
		public Set_typeContext set_type() {
			return getRuleContext(Set_typeContext.class,0);
		}
		public Class_identifierContext class_identifier() {
			return getRuleContext(Class_identifierContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_type);
		try {
			setState(762);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(746);
				match(INT);
				 ((TypeContext)_localctx).typeRet =  new IntType(); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(748);
				match(BOOL);
				 ((TypeContext)_localctx).typeRet =  new BoolType(); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(750);
				((TypeContext)_localctx).a = array_type();
				 ((TypeContext)_localctx).typeRet =  ((TypeContext)_localctx).a.arrayTypeRet; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(753);
				((TypeContext)_localctx).f = fptr_type();
				 ((TypeContext)_localctx).typeRet =  ((TypeContext)_localctx).f.fptrTypeRet; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(756);
				((TypeContext)_localctx).s = set_type();
				 ((TypeContext)_localctx).typeRet =  ((TypeContext)_localctx).s.setTypeRet; 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(759);
				((TypeContext)_localctx).c = class_identifier();

				            ((TypeContext)_localctx).typeRet =  new ClassType(((TypeContext)_localctx).c.class_id);
				      
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Array_typeContext extends ParserRuleContext {
		public ArrayType arrayTypeRet;
		public Type elemType;
		public ArrayList<Expression> dim;
		public Class_identifierContext c;
		public ExpressionContext exp;
		public TerminalNode INT() { return getToken(SimpleLOOPParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(SimpleLOOPParser.BOOL, 0); }
		public Class_identifierContext class_identifier() {
			return getRuleContext(Class_identifierContext.class,0);
		}
		public List<TerminalNode> LBRACK() { return getTokens(SimpleLOOPParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(SimpleLOOPParser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(SimpleLOOPParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(SimpleLOOPParser.RBRACK, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Array_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterArray_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitArray_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitArray_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_typeContext array_type() throws RecognitionException {
		Array_typeContext _localctx = new Array_typeContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_array_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(771);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				{
				setState(764);
				match(INT);
				 ((Array_typeContext)_localctx).elemType =  new IntType(); 
				}
				break;
			case BOOL:
				{
				setState(766);
				match(BOOL);
				 ((Array_typeContext)_localctx).elemType =  new BoolType(); 
				}
				break;
			case CLASS_IDENTIFIER:
				{
				setState(768);
				((Array_typeContext)_localctx).c = class_identifier();
				 ((Array_typeContext)_localctx).elemType =  new ClassType(((Array_typeContext)_localctx).c.class_id); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			((Array_typeContext)_localctx).dim =  new ArrayList<Expression>();
			setState(779); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(774);
				match(LBRACK);
				setState(775);
				((Array_typeContext)_localctx).exp = expression();
				_localctx.dim.add(((Array_typeContext)_localctx).exp.expressionRet);
				setState(777);
				match(RBRACK);
				}
				}
				setState(781); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LBRACK );
			 ((Array_typeContext)_localctx).arrayTypeRet =  new ArrayType(_localctx.elemType, _localctx.dim); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Fptr_typeContext extends ParserRuleContext {
		public FptrType fptrTypeRet;
		public ArrayList<Type> argsTypes;
		public Type returnType;
		public TypesWithCommaContext types;
		public TypeContext t;
		public TerminalNode FPTR() { return getToken(SimpleLOOPParser.FPTR, 0); }
		public TerminalNode LESS_THAN() { return getToken(SimpleLOOPParser.LESS_THAN, 0); }
		public TerminalNode ARROW() { return getToken(SimpleLOOPParser.ARROW, 0); }
		public TerminalNode GREATER_THAN() { return getToken(SimpleLOOPParser.GREATER_THAN, 0); }
		public List<TerminalNode> VOID() { return getTokens(SimpleLOOPParser.VOID); }
		public TerminalNode VOID(int i) {
			return getToken(SimpleLOOPParser.VOID, i);
		}
		public TypesWithCommaContext typesWithComma() {
			return getRuleContext(TypesWithCommaContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Fptr_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fptr_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterFptr_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitFptr_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitFptr_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fptr_typeContext fptr_type() throws RecognitionException {
		Fptr_typeContext _localctx = new Fptr_typeContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_fptr_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(785);
			match(FPTR);
			setState(786);
			match(LESS_THAN);
			setState(792);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				{
				setState(787);
				match(VOID);
				 ((Fptr_typeContext)_localctx).argsTypes =  new ArrayList<Type>(); 
				}
				break;
			case INT:
			case BOOL:
			case FPTR:
			case SET:
			case CLASS_IDENTIFIER:
				{
				setState(789);
				((Fptr_typeContext)_localctx).types = typesWithComma();
				 ((Fptr_typeContext)_localctx).argsTypes =  ((Fptr_typeContext)_localctx).types.typesWithCommaRet; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(794);
			match(ARROW);
			setState(800);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				{
				setState(795);
				match(VOID);
				 ((Fptr_typeContext)_localctx).returnType =  new VoidType(); 
				}
				break;
			case INT:
			case BOOL:
			case FPTR:
			case SET:
			case CLASS_IDENTIFIER:
				{
				setState(797);
				((Fptr_typeContext)_localctx).t = type();
				 ((Fptr_typeContext)_localctx).returnType =  ((Fptr_typeContext)_localctx).t.typeRet; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(802);
			match(GREATER_THAN);
			 ((Fptr_typeContext)_localctx).fptrTypeRet =  new FptrType(_localctx.argsTypes, _localctx.returnType); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypesWithCommaContext extends ParserRuleContext {
		public ArrayList<Type> typesWithCommaRet;
		public TypeContext t1;
		public TypeContext t2;
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleLOOPParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleLOOPParser.COMMA, i);
		}
		public TypesWithCommaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typesWithComma; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterTypesWithComma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitTypesWithComma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitTypesWithComma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypesWithCommaContext typesWithComma() throws RecognitionException {
		TypesWithCommaContext _localctx = new TypesWithCommaContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_typesWithComma);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((TypesWithCommaContext)_localctx).typesWithCommaRet =  new ArrayList<>(); 
			setState(806);
			((TypesWithCommaContext)_localctx).t1 = type();
			 _localctx.typesWithCommaRet.add(((TypesWithCommaContext)_localctx).t1.typeRet); 
			setState(814);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(808);
				match(COMMA);
				setState(809);
				((TypesWithCommaContext)_localctx).t2 = type();
				 _localctx.typesWithCommaRet.add(((TypesWithCommaContext)_localctx).t2.typeRet); 
				}
				}
				setState(816);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Set_typeContext extends ParserRuleContext {
		public SetType setTypeRet;
		public TerminalNode SET() { return getToken(SimpleLOOPParser.SET, 0); }
		public TerminalNode LESS_THAN() { return getToken(SimpleLOOPParser.LESS_THAN, 0); }
		public TerminalNode GREATER_THAN() { return getToken(SimpleLOOPParser.GREATER_THAN, 0); }
		public TerminalNode INT() { return getToken(SimpleLOOPParser.INT, 0); }
		public Set_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterSet_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitSet_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitSet_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Set_typeContext set_type() throws RecognitionException {
		Set_typeContext _localctx = new Set_typeContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_set_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(817);
			match(SET);
			setState(818);
			match(LESS_THAN);
			{
			setState(819);
			match(INT);
			}
			setState(820);
			match(GREATER_THAN);
			 ((Set_typeContext)_localctx).setTypeRet =  new SetType(); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3@\u033a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\7\2d\n\2\f\2\16\2g\13\2"+
		"\3\2\3\2\3\2\7\2l\n\2\f\2\16\2o\13\2\3\2\3\2\3\3\3\3\3\3\6\3v\n\3\r\3"+
		"\16\3w\3\3\3\3\7\3|\n\3\f\3\16\3\177\13\3\3\3\3\3\6\3\u0083\n\3\r\3\16"+
		"\3\u0084\3\3\3\3\7\3\u0089\n\3\f\3\16\3\u008c\13\3\3\4\3\4\3\4\3\4\7\4"+
		"\u0092\n\4\f\4\16\4\u0095\13\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\5\5\u00a1\n\5\3\5\7\5\u00a4\n\5\f\5\16\5\u00a7\13\5\3\5\3\5\6\5\u00ab"+
		"\n\5\r\5\16\5\u00ac\3\5\3\5\6\5\u00b1\n\5\r\5\16\5\u00b2\6\5\u00b5\n\5"+
		"\r\5\16\5\u00b6\3\5\3\5\3\5\5\5\u00bc\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\5\6\u00c5\n\6\3\6\3\6\3\6\5\6\u00ca\n\6\3\7\3\7\3\7\3\7\7\7\u00d0\n\7"+
		"\f\7\16\7\u00d3\13\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00dc\n\7\f\7\16"+
		"\7\u00df\13\7\3\7\3\7\3\7\5\7\u00e4\n\7\3\b\3\b\3\b\6\b\u00e9\n\b\r\b"+
		"\16\b\u00ea\3\b\3\b\3\b\6\b\u00f0\n\b\r\b\16\b\u00f1\7\b\u00f4\n\b\f\b"+
		"\16\b\u00f7\13\b\3\b\3\b\3\b\6\b\u00fc\n\b\r\b\16\b\u00fd\7\b\u0100\n"+
		"\b\f\b\16\b\u0103\13\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u010c\n\b\5\b\u010e"+
		"\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u011a\n\t\f\t\16\t\u011d"+
		"\13\t\5\t\u011f\n\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u0127\n\t\f\t\16\t\u012a"+
		"\13\t\5\t\u012c\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\7\13\u013b\n\13\f\13\16\13\u013e\13\13\5\13\u0140\n\13\3\f\3"+
		"\f\3\f\3\f\6\f\u0146\n\f\r\f\16\f\u0147\3\f\3\f\3\f\5\f\u014d\n\f\3\r"+
		"\3\r\3\r\6\r\u0152\n\r\r\r\16\r\u0153\3\r\3\r\3\r\6\r\u0159\n\r\r\r\16"+
		"\r\u015a\7\r\u015d\n\r\f\r\16\r\u0160\13\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0180\n\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\7\20\u0191\n\20\f\20\16\20\u0194\13\20\3\20\3\20\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u01a8"+
		"\n\22\f\22\16\22\u01ab\13\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7"+
		"\23\u01b5\n\23\f\23\16\23\u01b8\13\23\3\23\3\23\3\23\5\23\u01bd\n\23\3"+
		"\24\7\24\u01c0\n\24\f\24\16\24\u01c3\13\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u01d2\n\25\3\26\7\26\u01d5"+
		"\n\26\f\26\16\26\u01d8\13\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\5\31\u01f1\n\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0208\n\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0211\n\34\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\5\35\u021b\n\35\3\36\3\36\3\36\3\36\3\36\3\36\7\36"+
		"\u0223\n\36\f\36\16\36\u0226\13\36\3\37\3\37\3\37\3\37\3\37\3\37\7\37"+
		"\u022e\n\37\f\37\16\37\u0231\13\37\3 \3 \3 \3 \3 \3 \3 \7 \u023a\n \f"+
		" \16 \u023d\13 \3!\3!\3!\3!\3!\3!\5!\u0245\n!\3!\3!\3!\7!\u024a\n!\f!"+
		"\16!\u024d\13!\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0255\n\"\3\"\3\"\3\"\7\"\u025a"+
		"\n\"\f\"\16\"\u025d\13\"\3#\3#\3#\3#\3#\3#\5#\u0265\n#\3#\3#\3#\7#\u026a"+
		"\n#\f#\16#\u026d\13#\3$\3$\3$\3$\5$\u0273\n$\3$\3$\3$\3$\3$\3$\5$\u027b"+
		"\n$\3%\3%\3%\3%\3%\3%\5%\u0283\n%\3%\5%\u0286\n%\3&\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u0298\n&\7&\u029a\n&\f&\16&\u029d\13&\3"+
		"&\3&\3&\3&\3&\3&\3&\3&\3&\7&\u02a8\n&\f&\16&\u02ab\13&\3\'\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u02c0"+
		"\n\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\7(\u02ce\n(\f(\16(\u02d1\13("+
		"\3(\3(\5(\u02d5\n(\3(\3(\3(\3)\3)\3)\3)\3)\5)\u02df\n)\3*\3*\3*\3*\5*"+
		"\u02e5\n*\3+\3+\3+\3,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-"+
		"\3-\3-\5-\u02fd\n-\3.\3.\3.\3.\3.\3.\3.\5.\u0306\n.\3.\3.\3.\3.\3.\3."+
		"\6.\u030e\n.\r.\16.\u030f\3.\3.\3/\3/\3/\3/\3/\3/\3/\5/\u031b\n/\3/\3"+
		"/\3/\3/\3/\3/\5/\u0323\n/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\60"+
		"\7\60\u032f\n\60\f\60\16\60\u0332\13\60\3\61\3\61\3\61\3\61\3\61\3\61"+
		"\3\61\2\2\62\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:<>@BDFHJLNPRTVXZ\\^`\2\3\3\2\5\6\2\u0367\2e\3\2\2\2\4r\3\2\2\2\6"+
		"\u008d\3\2\2\2\b\u0099\3\2\2\2\n\u00c9\3\2\2\2\f\u00e3\3\2\2\2\16\u010d"+
		"\3\2\2\2\20\u010f\3\2\2\2\22\u012f\3\2\2\2\24\u0133\3\2\2\2\26\u014c\3"+
		"\2\2\2\30\u014e\3\2\2\2\32\u017f\3\2\2\2\34\u0181\3\2\2\2\36\u0189\3\2"+
		"\2\2 \u0197\3\2\2\2\"\u019f\3\2\2\2$\u01ac\3\2\2\2&\u01c1\3\2\2\2(\u01d1"+
		"\3\2\2\2*\u01d6\3\2\2\2,\u01dd\3\2\2\2.\u01e3\3\2\2\2\60\u01ea\3\2\2\2"+
		"\62\u01f2\3\2\2\2\64\u01f7\3\2\2\2\66\u0201\3\2\2\28\u0212\3\2\2\2:\u021c"+
		"\3\2\2\2<\u0227\3\2\2\2>\u0232\3\2\2\2@\u023e\3\2\2\2B\u024e\3\2\2\2D"+
		"\u025e\3\2\2\2F\u027a\3\2\2\2H\u027c\3\2\2\2J\u0287\3\2\2\2L\u02bf\3\2"+
		"\2\2N\u02c1\3\2\2\2P\u02de\3\2\2\2R\u02e4\3\2\2\2T\u02e6\3\2\2\2V\u02e9"+
		"\3\2\2\2X\u02fc\3\2\2\2Z\u0305\3\2\2\2\\\u0313\3\2\2\2^\u0327\3\2\2\2"+
		"`\u0333\3\2\2\2bd\7:\2\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fh\3\2"+
		"\2\2ge\3\2\2\2hi\5\4\3\2im\b\2\1\2jl\7:\2\2kj\3\2\2\2lo\3\2\2\2mk\3\2"+
		"\2\2mn\3\2\2\2np\3\2\2\2om\3\2\2\2pq\7\2\2\3q\3\3\2\2\2r}\b\3\1\2su\5"+
		"\"\22\2tv\7:\2\2ut\3\2\2\2vw\3\2\2\2wu\3\2\2\2wx\3\2\2\2xy\3\2\2\2yz\b"+
		"\3\1\2z|\3\2\2\2{s\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u008a\3\2"+
		"\2\2\177}\3\2\2\2\u0080\u0082\5\b\5\2\u0081\u0083\7:\2\2\u0082\u0081\3"+
		"\2\2\2\u0083\u0084\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085"+
		"\u0086\3\2\2\2\u0086\u0087\b\3\1\2\u0087\u0089\3\2\2\2\u0088\u0080\3\2"+
		"\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b"+
		"\5\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u008e\7\5\2\2\u008e\u008f\7\7\2\2"+
		"\u008f\u0093\5\20\t\2\u0090\u0092\7:\2\2\u0091\u0090\3\2\2\2\u0092\u0095"+
		"\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0096\3\2\2\2\u0095"+
		"\u0093\3\2\2\2\u0096\u0097\5\16\b\2\u0097\u0098\b\4\1\2\u0098\7\3\2\2"+
		"\2\u0099\u009a\7\4\2\2\u009a\u009b\5T+\2\u009b\u00a0\b\5\1\2\u009c\u009d"+
		"\7\34\2\2\u009d\u009e\5T+\2\u009e\u009f\b\5\1\2\u009f\u00a1\3\2\2\2\u00a0"+
		"\u009c\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a5\3\2\2\2\u00a2\u00a4\7:"+
		"\2\2\u00a3\u00a2\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5"+
		"\u00a6\3\2\2\2\u00a6\u00bb\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00aa\7\65"+
		"\2\2\u00a9\u00ab\7:\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac"+
		"\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00b4\3\2\2\2\u00ae\u00b0\5\n"+
		"\6\2\u00af\u00b1\7:\2\2\u00b0\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b5\3\2\2\2\u00b4\u00ae\3\2"+
		"\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7"+
		"\u00b8\3\2\2\2\u00b8\u00b9\7\66\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00bc\5"+
		"\n\6\2\u00bb\u00a8\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bc\t\3\2\2\2\u00bd\u00c4"+
		"\t\2\2\2\u00be\u00bf\5\"\22\2\u00bf\u00c0\b\6\1\2\u00c0\u00c5\3\2\2\2"+
		"\u00c1\u00c2\5\f\7\2\u00c2\u00c3\b\6\1\2\u00c3\u00c5\3\2\2\2\u00c4\u00be"+
		"\3\2\2\2\u00c4\u00c1\3\2\2\2\u00c5\u00ca\3\2\2\2\u00c6\u00c7\5\6\4\2\u00c7"+
		"\u00c8\b\6\1\2\u00c8\u00ca\3\2\2\2\u00c9\u00bd\3\2\2\2\u00c9\u00c6\3\2"+
		"\2\2\u00ca\13\3\2\2\2\u00cb\u00cc\5X-\2\u00cc\u00cd\5V,\2\u00cd\u00d1"+
		"\5\20\t\2\u00ce\u00d0\7:\2\2\u00cf\u00ce\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1"+
		"\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d4\3\2\2\2\u00d3\u00d1\3\2"+
		"\2\2\u00d4\u00d5\5\16\b\2\u00d5\u00d6\b\7\1\2\u00d6\u00e4\3\2\2\2\u00d7"+
		"\u00d8\7\13\2\2\u00d8\u00d9\5V,\2\u00d9\u00dd\5\20\t\2\u00da\u00dc\7:"+
		"\2\2\u00db\u00da\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd"+
		"\u00de\3\2\2\2\u00de\u00e0\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e1\5\16"+
		"\b\2\u00e1\u00e2\b\7\1\2\u00e2\u00e4\3\2\2\2\u00e3\u00cb\3\2\2\2\u00e3"+
		"\u00d7\3\2\2\2\u00e4\r\3\2\2\2\u00e5\u00e6\b\b\1\2\u00e6\u00e8\7\65\2"+
		"\2\u00e7\u00e9\7:\2\2\u00e8\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00e8"+
		"\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00f5\3\2\2\2\u00ec\u00ed\5\"\22\2"+
		"\u00ed\u00ef\b\b\1\2\u00ee\u00f0\7:\2\2\u00ef\u00ee\3\2\2\2\u00f0\u00f1"+
		"\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f4\3\2\2\2\u00f3"+
		"\u00ec\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2"+
		"\2\2\u00f6\u0101\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00f9\5\32\16\2\u00f9"+
		"\u00fb\b\b\1\2\u00fa\u00fc\7:\2\2\u00fb\u00fa\3\2\2\2\u00fc\u00fd\3\2"+
		"\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0100\3\2\2\2\u00ff"+
		"\u00f8\3\2\2\2\u0100\u0103\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2"+
		"\2\2\u0102\u0104\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u010e\7\66\2\2\u0105"+
		"\u0106\5\"\22\2\u0106\u0107\b\b\1\2\u0107\u010c\3\2\2\2\u0108\u0109\5"+
		"\32\16\2\u0109\u010a\b\b\1\2\u010a\u010c\3\2\2\2\u010b\u0105\3\2\2\2\u010b"+
		"\u0108\3\2\2\2\u010c\u010e\3\2\2\2\u010d\u00e5\3\2\2\2\u010d\u010b\3\2"+
		"\2\2\u010e\17\3\2\2\2\u010f\u0110\b\t\1\2\u0110\u012b\7\61\2\2\u0111\u0112"+
		"\5\22\n\2\u0112\u011e\b\t\1\2\u0113\u0114\7/\2\2\u0114\u011f\5:\36\2\u0115"+
		"\u0116\7\67\2\2\u0116\u0117\5\22\n\2\u0117\u0118\b\t\1\2\u0118\u011a\3"+
		"\2\2\2\u0119\u0115\3\2\2\2\u011a\u011d\3\2\2\2\u011b\u0119\3\2\2\2\u011b"+
		"\u011c\3\2\2\2\u011c\u011f\3\2\2\2\u011d\u011b\3\2\2\2\u011e\u0113\3\2"+
		"\2\2\u011e\u011b\3\2\2\2\u011f\u0128\3\2\2\2\u0120\u0121\7\67\2\2\u0121"+
		"\u0122\5\22\n\2\u0122\u0123\b\t\1\2\u0123\u0124\7/\2\2\u0124\u0125\5:"+
		"\36\2\u0125\u0127\3\2\2\2\u0126\u0120\3\2\2\2\u0127\u012a\3\2\2\2\u0128"+
		"\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u0128\3\2"+
		"\2\2\u012b\u0111\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012d\3\2\2\2\u012d"+
		"\u012e\7\62\2\2\u012e\21\3\2\2\2\u012f\u0130\5X-\2\u0130\u0131\5V,\2\u0131"+
		"\u0132\b\n\1\2\u0132\23\3\2\2\2\u0133\u013f\b\13\1\2\u0134\u0135\5\66"+
		"\34\2\u0135\u013c\b\13\1\2\u0136\u0137\7\67\2\2\u0137\u0138\5\66\34\2"+
		"\u0138\u0139\b\13\1\2\u0139\u013b\3\2\2\2\u013a\u0136\3\2\2\2\u013b\u013e"+
		"\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u0140\3\2\2\2\u013e"+
		"\u013c\3\2\2\2\u013f\u0134\3\2\2\2\u013f\u0140\3\2\2\2\u0140\25\3\2\2"+
		"\2\u0141\u0142\5\30\r\2\u0142\u0143\b\f\1\2\u0143\u014d\3\2\2\2\u0144"+
		"\u0146\7:\2\2\u0145\u0144\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0145\3\2"+
		"\2\2\u0147\u0148\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u014a\5\32\16\2\u014a"+
		"\u014b\b\f\1\2\u014b\u014d\3\2\2\2\u014c\u0141\3\2\2\2\u014c\u0145\3\2"+
		"\2\2\u014d\27\3\2\2\2\u014e\u014f\b\r\1\2\u014f\u0151\7\65\2\2\u0150\u0152"+
		"\7:\2\2\u0151\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0151\3\2\2\2\u0153"+
		"\u0154\3\2\2\2\u0154\u015e\3\2\2\2\u0155\u0156\5\32\16\2\u0156\u0158\b"+
		"\r\1\2\u0157\u0159\7:\2\2\u0158\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015a"+
		"\u0158\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015d\3\2\2\2\u015c\u0155\3\2"+
		"\2\2\u015d\u0160\3\2\2\2\u015e\u015c\3\2\2\2\u015e\u015f\3\2\2\2\u015f"+
		"\u0161\3\2\2\2\u0160\u015e\3\2\2\2\u0161\u0162\7\66\2\2\u0162\u0163\b"+
		"\r\1\2\u0163\31\3\2\2\2\u0164\u0165\5$\23\2\u0165\u0166\b\16\1\2\u0166"+
		"\u0180\3\2\2\2\u0167\u0168\5,\27\2\u0168\u0169\b\16\1\2\u0169\u0180\3"+
		"\2\2\2\u016a\u016b\5.\30\2\u016b\u016c\b\16\1\2\u016c\u0180\3\2\2\2\u016d"+
		"\u016e\5\60\31\2\u016e\u016f\b\16\1\2\u016f\u0180\3\2\2\2\u0170\u0171"+
		"\5\62\32\2\u0171\u0172\b\16\1\2\u0172\u0180\3\2\2\2\u0173\u0174\5\64\33"+
		"\2\u0174\u0175\b\16\1\2\u0175\u0180\3\2\2\2\u0176\u0177\5\34\17\2\u0177"+
		"\u0178\b\16\1\2\u0178\u0180\3\2\2\2\u0179\u017a\5\36\20\2\u017a\u017b"+
		"\b\16\1\2\u017b\u0180\3\2\2\2\u017c\u017d\5 \21\2\u017d\u017e\b\16\1\2"+
		"\u017e\u0180\3\2\2\2\u017f\u0164\3\2\2\2\u017f\u0167\3\2\2\2\u017f\u016a"+
		"\3\2\2\2\u017f\u016d\3\2\2\2\u017f\u0170\3\2\2\2\u017f\u0173\3\2\2\2\u017f"+
		"\u0176\3\2\2\2\u017f\u0179\3\2\2\2\u017f\u017c\3\2\2\2\u0180\33\3\2\2"+
		"\2\u0181\u0182\5\66\34\2\u0182\u0183\78\2\2\u0183\u0184\7\16\2\2\u0184"+
		"\u0185\7\61\2\2\u0185\u0186\5:\36\2\u0186\u0187\7\62\2\2\u0187\u0188\b"+
		"\17\1\2\u0188\35\3\2\2\2\u0189\u018a\5\66\34\2\u018a\u018b\78\2\2\u018b"+
		"\u018c\7\17\2\2\u018c\u018d\7\61\2\2\u018d\u0192\5:\36\2\u018e\u018f\7"+
		"\67\2\2\u018f\u0191\5:\36\2\u0190\u018e\3\2\2\2\u0191\u0194\3\2\2\2\u0192"+
		"\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u0195\3\2\2\2\u0194\u0192\3\2"+
		"\2\2\u0195\u0196\7\62\2\2\u0196\37\3\2\2\2\u0197\u0198\5\66\34\2\u0198"+
		"\u0199\78\2\2\u0199\u019a\7\f\2\2\u019a\u019b\7\61\2\2\u019b\u019c\5:"+
		"\36\2\u019c\u019d\7\62\2\2\u019d\u019e\b\21\1\2\u019e!\3\2\2\2\u019f\u01a0"+
		"\b\22\1\2\u01a0\u01a1\5X-\2\u01a1\u01a2\5V,\2\u01a2\u01a9\b\22\1\2\u01a3"+
		"\u01a4\7\67\2\2\u01a4\u01a5\5V,\2\u01a5\u01a6\b\22\1\2\u01a6\u01a8\3\2"+
		"\2\2\u01a7\u01a3\3\2\2\2\u01a8\u01ab\3\2\2\2\u01a9\u01a7\3\2\2\2\u01a9"+
		"\u01aa\3\2\2\2\u01aa#\3\2\2\2\u01ab\u01a9\3\2\2\2\u01ac\u01ad\7\21\2\2"+
		"\u01ad\u01ae\5(\25\2\u01ae\u01af\5\26\f\2\u01af\u01b0\b\23\1\2\u01b0\u01b6"+
		"\b\23\1\2\u01b1\u01b2\5&\24\2\u01b2\u01b3\b\23\1\2\u01b3\u01b5\3\2\2\2"+
		"\u01b4\u01b1\3\2\2\2\u01b5\u01b8\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b6\u01b7"+
		"\3\2\2\2\u01b7\u01bc\3\2\2\2\u01b8\u01b6\3\2\2\2\u01b9\u01ba\5*\26\2\u01ba"+
		"\u01bb\b\23\1\2\u01bb\u01bd\3\2\2\2\u01bc\u01b9\3\2\2\2\u01bc\u01bd\3"+
		"\2\2\2\u01bd%\3\2\2\2\u01be\u01c0\7:\2\2\u01bf\u01be\3\2\2\2\u01c0\u01c3"+
		"\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2\u01c4\3\2\2\2\u01c3"+
		"\u01c1\3\2\2\2\u01c4\u01c5\7\23\2\2\u01c5\u01c6\5(\25\2\u01c6\u01c7\5"+
		"\26\f\2\u01c7\u01c8\b\24\1\2\u01c8\'\3\2\2\2\u01c9\u01ca\7\61\2\2\u01ca"+
		"\u01cb\5\66\34\2\u01cb\u01cc\b\25\1\2\u01cc\u01cd\7\62\2\2\u01cd\u01d2"+
		"\3\2\2\2\u01ce\u01cf\5\66\34\2\u01cf\u01d0\b\25\1\2\u01d0\u01d2\3\2\2"+
		"\2\u01d1\u01c9\3\2\2\2\u01d1\u01ce\3\2\2\2\u01d2)\3\2\2\2\u01d3\u01d5"+
		"\7:\2\2\u01d4\u01d3\3\2\2\2\u01d5\u01d8\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d6"+
		"\u01d7\3\2\2\2\u01d7\u01d9\3\2\2\2\u01d8\u01d6\3\2\2\2\u01d9\u01da\7\22"+
		"\2\2\u01da\u01db\5\26\f\2\u01db\u01dc\b\26\1\2\u01dc+\3\2\2\2\u01dd\u01de"+
		"\7\20\2\2\u01de\u01df\7\61\2\2\u01df\u01e0\5\66\34\2\u01e0\u01e1\7\62"+
		"\2\2\u01e1\u01e2\b\27\1\2\u01e2-\3\2\2\2\u01e3\u01e4\5J&\2\u01e4\u01e5"+
		"\7\61\2\2\u01e5\u01e6\5\24\13\2\u01e6\u01e7\7\62\2\2\u01e7\u01e8\3\2\2"+
		"\2\u01e8\u01e9\b\30\1\2\u01e9/\3\2\2\2\u01ea\u01eb\b\31\1\2\u01eb\u01ec"+
		"\7\n\2\2\u01ec\u01f0\b\31\1\2\u01ed\u01ee\5\66\34\2\u01ee\u01ef\b\31\1"+
		"\2\u01ef\u01f1\3\2\2\2\u01f0\u01ed\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1\61"+
		"\3\2\2\2\u01f2\u01f3\5:\36\2\u01f3\u01f4\7/\2\2\u01f4\u01f5\5\66\34\2"+
		"\u01f5\u01f6\b\32\1\2\u01f6\63\3\2\2\2\u01f7\u01f8\5J&\2\u01f8\u01f9\7"+
		"8\2\2\u01f9\u01fa\7-\2\2\u01fa\u01fb\7.\2\2\u01fb\u01fc\7\36\2\2\u01fc"+
		"\u01fd\5V,\2\u01fd\u01fe\7\36\2\2\u01fe\u01ff\5\26\f\2\u01ff\u0200\b\33"+
		"\1\2\u0200\65\3\2\2\2\u0201\u0202\58\35\2\u0202\u0207\b\34\1\2\u0203\u0204"+
		"\7/\2\2\u0204\u0205\5\66\34\2\u0205\u0206\b\34\1\2\u0206\u0208\3\2\2\2"+
		"\u0207\u0203\3\2\2\2\u0207\u0208\3\2\2\2\u0208\u0210\3\2\2\2\u0209\u020a"+
		"\78\2\2\u020a\u020b\7\r\2\2\u020b\u020c\7\61\2\2\u020c\u020d\5:\36\2\u020d"+
		"\u020e\7\62\2\2\u020e\u020f\b\34\1\2\u020f\u0211\3\2\2\2\u0210\u0209\3"+
		"\2\2\2\u0210\u0211\3\2\2\2\u0211\67\3\2\2\2\u0212\u0213\5:\36\2\u0213"+
		"\u021a\b\35\1\2\u0214\u0215\7\"\2\2\u0215\u0216\58\35\2\u0216\u0217\7"+
		"#\2\2\u0217\u0218\58\35\2\u0218\u0219\b\35\1\2\u0219\u021b\3\2\2\2\u021a"+
		"\u0214\3\2\2\2\u021a\u021b\3\2\2\2\u021b9\3\2\2\2\u021c\u021d\5<\37\2"+
		"\u021d\u0224\b\36\1\2\u021e\u021f\7 \2\2\u021f\u0220\5<\37\2\u0220\u0221"+
		"\b\36\1\2\u0221\u0223\3\2\2\2\u0222\u021e\3\2\2\2\u0223\u0226\3\2\2\2"+
		"\u0224\u0222\3\2\2\2\u0224\u0225\3\2\2\2\u0225;\3\2\2\2\u0226\u0224\3"+
		"\2\2\2\u0227\u0228\5> \2\u0228\u022f\b\37\1\2\u0229\u022a\7\37\2\2\u022a"+
		"\u022b\5> \2\u022b\u022c\b\37\1\2\u022c\u022e\3\2\2\2\u022d\u0229\3\2"+
		"\2\2\u022e\u0231\3\2\2\2\u022f\u022d\3\2\2\2\u022f\u0230\3\2\2\2\u0230"+
		"=\3\2\2\2\u0231\u022f\3\2\2\2\u0232\u0233\5@!\2\u0233\u023b\b \1\2\u0234"+
		"\u0235\7\32\2\2\u0235\u0236\b \1\2\u0236\u0237\5@!\2\u0237\u0238\b \1"+
		"\2\u0238\u023a\3\2\2\2\u0239\u0234\3\2\2\2\u023a\u023d\3\2\2\2\u023b\u0239"+
		"\3\2\2\2\u023b\u023c\3\2\2\2\u023c?\3\2\2\2\u023d\u023b\3\2\2\2\u023e"+
		"\u023f\5B\"\2\u023f\u024b\b!\1\2\u0240\u0241\7\33\2\2\u0241\u0245\b!\1"+
		"\2\u0242\u0243\7\34\2\2\u0243\u0245\b!\1\2\u0244\u0240\3\2\2\2\u0244\u0242"+
		"\3\2\2\2\u0245\u0246\3\2\2\2\u0246\u0247\5B\"\2\u0247\u0248\b!\1\2\u0248"+
		"\u024a\3\2\2\2\u0249\u0244\3\2\2\2\u024a\u024d\3\2\2\2\u024b\u0249\3\2"+
		"\2\2\u024b\u024c\3\2\2\2\u024cA\3\2\2\2\u024d\u024b\3\2\2\2\u024e\u024f"+
		"\5D#\2\u024f\u025b\b\"\1\2\u0250\u0251\7\24\2\2\u0251\u0255\b\"\1\2\u0252"+
		"\u0253\7\25\2\2\u0253\u0255\b\"\1\2\u0254\u0250\3\2\2\2\u0254\u0252\3"+
		"\2\2\2\u0255\u0256\3\2\2\2\u0256\u0257\5D#\2\u0257\u0258\b\"\1\2\u0258"+
		"\u025a\3\2\2\2\u0259\u0254\3\2\2\2\u025a\u025d\3\2\2\2\u025b\u0259\3\2"+
		"\2\2\u025b\u025c\3\2\2\2\u025cC\3\2\2\2\u025d\u025b\3\2\2\2\u025e\u025f"+
		"\5F$\2\u025f\u026b\b#\1\2\u0260\u0261\7\26\2\2\u0261\u0265\b#\1\2\u0262"+
		"\u0263\7\27\2\2\u0263\u0265\b#\1\2\u0264\u0260\3\2\2\2\u0264\u0262\3\2"+
		"\2\2\u0265\u0266\3\2\2\2\u0266\u0267\5F$\2\u0267\u0268\b#\1\2\u0268\u026a"+
		"\3\2\2\2\u0269\u0264\3\2\2\2\u026a\u026d\3\2\2\2\u026b\u0269\3\2\2\2\u026b"+
		"\u026c\3\2\2\2\u026cE\3\2\2\2\u026d\u026b\3\2\2\2\u026e\u026f\7!\2\2\u026f"+
		"\u0273\b$\1\2\u0270\u0271\7\25\2\2\u0271\u0273\b$\1\2\u0272\u026e\3\2"+
		"\2\2\u0272\u0270\3\2\2\2\u0273\u0274\3\2\2\2\u0274\u0275\5F$\2\u0275\u0276"+
		"\b$\1\2\u0276\u027b\3\2\2\2\u0277\u0278\5H%\2\u0278\u0279\b$\1\2\u0279"+
		"\u027b\3\2\2\2\u027a\u0272\3\2\2\2\u027a\u0277\3\2\2\2\u027bG\3\2\2\2"+
		"\u027c\u027d\5J&\2\u027d\u0285\b%\1\2\u027e\u027f\7\30\2\2\u027f\u0283"+
		"\b%\1\2\u0280\u0281\7\31\2\2\u0281\u0283\b%\1\2\u0282\u027e\3\2\2\2\u0282"+
		"\u0280\3\2\2\2\u0283\u0284\3\2\2\2\u0284\u0286\b%\1\2\u0285\u0282\3\2"+
		"\2\2\u0285\u0286\3\2\2\2\u0286I\3\2\2\2\u0287\u0288\5L\'\2\u0288\u029b"+
		"\b&\1\2\u0289\u028a\7\61\2\2\u028a\u028b\5\24\13\2\u028b\u028c\7\62\2"+
		"\2\u028c\u028d\3\2\2\2\u028d\u028e\b&\1\2\u028e\u029a\3\2\2\2\u028f\u0297"+
		"\78\2\2\u0290\u0291\5V,\2\u0291\u0292\b&\1\2\u0292\u0298\3\2\2\2\u0293"+
		"\u0294\7\b\2\2\u0294\u0298\b&\1\2\u0295\u0296\7\7\2\2\u0296\u0298\b&\1"+
		"\2\u0297\u0290\3\2\2\2\u0297\u0293\3\2\2\2\u0297\u0295\3\2\2\2\u0298\u029a"+
		"\3\2\2\2\u0299\u0289\3\2\2\2\u0299\u028f\3\2\2\2\u029a\u029d\3\2\2\2\u029b"+
		"\u0299\3\2\2\2\u029b\u029c\3\2\2\2\u029c\u02a9\3\2\2\2\u029d\u029b\3\2"+
		"\2\2\u029e\u029f\78\2\2\u029f\u02a0\5V,\2\u02a0\u02a1\b&\1\2\u02a1\u02a8"+
		"\3\2\2\2\u02a2\u02a3\7\63\2\2\u02a3\u02a4\5\66\34\2\u02a4\u02a5\b&\1\2"+
		"\u02a5\u02a6\7\64\2\2\u02a6\u02a8\3\2\2\2\u02a7\u029e\3\2\2\2\u02a7\u02a2"+
		"\3\2\2\2\u02a8\u02ab\3\2\2\2\u02a9\u02a7\3\2\2\2\u02a9\u02aa\3\2\2\2\u02aa"+
		"K\3\2\2\2\u02ab\u02a9\3\2\2\2\u02ac\u02ad\5T+\2\u02ad\u02ae\b\'\1\2\u02ae"+
		"\u02c0\3\2\2\2\u02af\u02b0\5P)\2\u02b0\u02b1\b\'\1\2\u02b1\u02c0\3\2\2"+
		"\2\u02b2\u02b3\5V,\2\u02b3\u02b4\b\'\1\2\u02b4\u02c0\3\2\2\2\u02b5\u02b6"+
		"\5N(\2\u02b6\u02b7\b\'\1\2\u02b7\u02c0\3\2\2\2\u02b8\u02b9\7\61\2\2\u02b9"+
		"\u02ba\5\66\34\2\u02ba\u02bb\7\62\2\2\u02bb\u02bc\b\'\1\2\u02bc\u02c0"+
		"\3\2\2\2\u02bd\u02be\7\t\2\2\u02be\u02c0\b\'\1\2\u02bf\u02ac\3\2\2\2\u02bf"+
		"\u02af\3\2\2\2\u02bf\u02b2\3\2\2\2\u02bf\u02b5\3\2\2\2\u02bf\u02b8\3\2"+
		"\2\2\u02bf\u02bd\3\2\2\2\u02c0M\3\2\2\2\u02c1\u02c2\7,\2\2\u02c2\u02c3"+
		"\78\2\2\u02c3\u02c4\7\b\2\2\u02c4\u02c5\7\61\2\2\u02c5\u02d4\b(\1\2\u02c6"+
		"\u02c7\7\61\2\2\u02c7\u02c8\5:\36\2\u02c8\u02cf\b(\1\2\u02c9\u02ca\7\67"+
		"\2\2\u02ca\u02cb\5:\36\2\u02cb\u02cc\b(\1\2\u02cc\u02ce\3\2\2\2\u02cd"+
		"\u02c9\3\2\2\2\u02ce\u02d1\3\2\2\2\u02cf\u02cd\3\2\2\2\u02cf\u02d0\3\2"+
		"\2\2\u02d0\u02d2\3\2\2\2\u02d1\u02cf\3\2\2\2\u02d2\u02d3\7\62\2\2\u02d3"+
		"\u02d5\3\2\2\2\u02d4\u02c6\3\2\2\2\u02d4\u02d5\3\2\2\2\u02d5\u02d6\3\2"+
		"\2\2\u02d6\u02d7\7\62\2\2\u02d7\u02d8\b(\1\2\u02d8O\3\2\2\2\u02d9\u02da"+
		"\5R*\2\u02da\u02db\b)\1\2\u02db\u02df\3\2\2\2\u02dc\u02dd\7;\2\2\u02dd"+
		"\u02df\b)\1\2\u02de\u02d9\3\2\2\2\u02de\u02dc\3\2\2\2\u02dfQ\3\2\2\2\u02e0"+
		"\u02e1\7$\2\2\u02e1\u02e5\b*\1\2\u02e2\u02e3\7%\2\2\u02e3\u02e5\b*\1\2"+
		"\u02e4\u02e0\3\2\2\2\u02e4\u02e2\3\2\2\2\u02e5S\3\2\2\2\u02e6\u02e7\7"+
		"=\2\2\u02e7\u02e8\b+\1\2\u02e8U\3\2\2\2\u02e9\u02ea\7<\2\2\u02ea\u02eb"+
		"\b,\1\2\u02ebW\3\2\2\2\u02ec\u02ed\7)\2\2\u02ed\u02fd\b-\1\2\u02ee\u02ef"+
		"\7*\2\2\u02ef\u02fd\b-\1\2\u02f0\u02f1\5Z.\2\u02f1\u02f2\b-\1\2\u02f2"+
		"\u02fd\3\2\2\2\u02f3\u02f4\5\\/\2\u02f4\u02f5\b-\1\2\u02f5\u02fd\3\2\2"+
		"\2\u02f6\u02f7\5`\61\2\u02f7\u02f8\b-\1\2\u02f8\u02fd\3\2\2\2\u02f9\u02fa"+
		"\5T+\2\u02fa\u02fb\b-\1\2\u02fb\u02fd\3\2\2\2\u02fc\u02ec\3\2\2\2\u02fc"+
		"\u02ee\3\2\2\2\u02fc\u02f0\3\2\2\2\u02fc\u02f3\3\2\2\2\u02fc\u02f6\3\2"+
		"\2\2\u02fc\u02f9\3\2\2\2\u02fdY\3\2\2\2\u02fe\u02ff\7)\2\2\u02ff\u0306"+
		"\b.\1\2\u0300\u0301\7*\2\2\u0301\u0306\b.\1\2\u0302\u0303\5T+\2\u0303"+
		"\u0304\b.\1\2\u0304\u0306\3\2\2\2\u0305\u02fe\3\2\2\2\u0305\u0300\3\2"+
		"\2\2\u0305\u0302\3\2\2\2\u0306\u0307\3\2\2\2\u0307\u030d\b.\1\2\u0308"+
		"\u0309\7\63\2\2\u0309\u030a\5\66\34\2\u030a\u030b\b.\1\2\u030b\u030c\7"+
		"\64\2\2\u030c\u030e\3\2\2\2\u030d\u0308\3\2\2\2\u030e\u030f\3\2\2\2\u030f"+
		"\u030d\3\2\2\2\u030f\u0310\3\2\2\2\u0310\u0311\3\2\2\2\u0311\u0312\b."+
		"\1\2\u0312[\3\2\2\2\u0313\u0314\7+\2\2\u0314\u031a\7\34\2\2\u0315\u0316"+
		"\7\13\2\2\u0316\u031b\b/\1\2\u0317\u0318\5^\60\2\u0318\u0319\b/\1\2\u0319"+
		"\u031b\3\2\2\2\u031a\u0315\3\2\2\2\u031a\u0317\3\2\2\2\u031b\u031c\3\2"+
		"\2\2\u031c\u0322\7\35\2\2\u031d\u031e\7\13\2\2\u031e\u0323\b/\1\2\u031f"+
		"\u0320\5X-\2\u0320\u0321\b/\1\2\u0321\u0323\3\2\2\2\u0322\u031d\3\2\2"+
		"\2\u0322\u031f\3\2\2\2\u0323\u0324\3\2\2\2\u0324\u0325\7\33\2\2\u0325"+
		"\u0326\b/\1\2\u0326]\3\2\2\2\u0327\u0328\b\60\1\2\u0328\u0329\5X-\2\u0329"+
		"\u0330\b\60\1\2\u032a\u032b\7\67\2\2\u032b\u032c\5X-\2\u032c\u032d\b\60"+
		"\1\2\u032d\u032f\3\2\2\2\u032e\u032a\3\2\2\2\u032f\u0332\3\2\2\2\u0330"+
		"\u032e\3\2\2\2\u0330\u0331\3\2\2\2\u0331_\3\2\2\2\u0332\u0330\3\2\2\2"+
		"\u0333\u0334\7,\2\2\u0334\u0335\7\34\2\2\u0335\u0336\7)\2\2\u0336\u0337"+
		"\7\33\2\2\u0337\u0338\b\61\1\2\u0338a\3\2\2\2Oemw}\u0084\u008a\u0093\u00a0"+
		"\u00a5\u00ac\u00b2\u00b6\u00bb\u00c4\u00c9\u00d1\u00dd\u00e3\u00ea\u00f1"+
		"\u00f5\u00fd\u0101\u010b\u010d\u011b\u011e\u0128\u012b\u013c\u013f\u0147"+
		"\u014c\u0153\u015a\u015e\u017f\u0192\u01a9\u01b6\u01bc\u01c1\u01d1\u01d6"+
		"\u01f0\u0207\u0210\u021a\u0224\u022f\u023b\u0244\u024b\u0254\u025b\u0264"+
		"\u026b\u0272\u027a\u0282\u0285\u0297\u0299\u029b\u02a7\u02a9\u02bf\u02cf"+
		"\u02d4\u02de\u02e4\u02fc\u0305\u030f\u031a\u0322\u0330";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}