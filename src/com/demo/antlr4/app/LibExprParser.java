package com.demo.antlr4.app;

// Generated from LibExpr.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import com.demo.antlr4.app.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LibExprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ID=1, ATOM=2, INT=3, DOUBLE=4, POW=5, NL=6, WS=7, EQUAL=8, MUL=9, SEQ=10, 
		PARA=11, CHO=12, CAL=13, COMMA=14, LPAR=15, RPAR=16, LBRA=17, RBRA=18, 
		NUL=19, UND=20;
	public static final int
		RULE_prog = 0, RULE_input = 1, RULE_setVar = 2, RULE_getAtom = 3, RULE_calculateExpr = 4, 
		RULE_callOrchoice = 5, RULE_next = 6, RULE_atom = 7;
	public static final String[] ruleNames = {
		"prog", "input", "setVar", "getAtom", "calculateExpr", "callOrchoice", 
		"next", "atom"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, "'^'", "'\n'", null, "'='", "'*'", "';'", 
		"'||'", "'#'", "'@'", "','", "'('", "')'", "'['", "']'", "'_'", "'!'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ID", "ATOM", "INT", "DOUBLE", "POW", "NL", "WS", "EQUAL", "MUL", 
		"SEQ", "PARA", "CHO", "CAL", "COMMA", "LPAR", "RPAR", "LBRA", "RBRA", 
		"NUL", "UND"
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

	@Override
	public String getGrammarFileName() { return "LibExpr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LibExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public List<InputContext> input() {
			return getRuleContexts(InputContext.class);
		}
		public InputContext input(int i) {
			return getRuleContext(InputContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LibExprVisitor ) return ((LibExprVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(16);
				input();
				}
				}
				setState(19); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << ATOM) | (1L << INT) | (1L << DOUBLE) | (1L << MUL) | (1L << LPAR))) != 0) );
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

	public static class InputContext extends ParserRuleContext {
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
	 
		public InputContext() { }
		public void copyFrom(InputContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CalculateContext extends InputContext {
		public CalculateExprContext calculateExpr() {
			return getRuleContext(CalculateExprContext.class,0);
		}
		public TerminalNode NL() { return getToken(LibExprParser.NL, 0); }
		public CalculateContext(InputContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LibExprVisitor ) return ((LibExprVisitor<? extends T>)visitor).visitCalculate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ToSetVarContext extends InputContext {
		public SetVarContext setVar() {
			return getRuleContext(SetVarContext.class,0);
		}
		public ToSetVarContext(InputContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LibExprVisitor ) return ((LibExprVisitor<? extends T>)visitor).visitToSetVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputContext input() throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_input);
		try {
			setState(25);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new ToSetVarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(21);
				setVar();
				}
				break;
			case 2:
				_localctx = new CalculateContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(22);
				calculateExpr(0);
				setState(23);
				match(NL);
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

	public static class SetVarContext extends ParserRuleContext {
		public SetVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setVar; }
	 
		public SetVarContext() { }
		public void copyFrom(SetVarContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SetAtomContext extends SetVarContext {
		public TerminalNode ATOM() { return getToken(LibExprParser.ATOM, 0); }
		public TerminalNode EQUAL() { return getToken(LibExprParser.EQUAL, 0); }
		public CalculateExprContext calculateExpr() {
			return getRuleContext(CalculateExprContext.class,0);
		}
		public TerminalNode NL() { return getToken(LibExprParser.NL, 0); }
		public SetAtomContext(SetVarContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LibExprVisitor ) return ((LibExprVisitor<? extends T>)visitor).visitSetAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetVaribleBRAContext extends SetVarContext {
		public TerminalNode ID() { return getToken(LibExprParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(LibExprParser.EQUAL, 0); }
		public TerminalNode LBRA() { return getToken(LibExprParser.LBRA, 0); }
		public GetAtomContext getAtom() {
			return getRuleContext(GetAtomContext.class,0);
		}
		public TerminalNode RBRA() { return getToken(LibExprParser.RBRA, 0); }
		public TerminalNode NL() { return getToken(LibExprParser.NL, 0); }
		public SetVaribleBRAContext(SetVarContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LibExprVisitor ) return ((LibExprVisitor<? extends T>)visitor).visitSetVaribleBRA(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetVaribleContext extends SetVarContext {
		public TerminalNode ID() { return getToken(LibExprParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(LibExprParser.EQUAL, 0); }
		public CalculateExprContext calculateExpr() {
			return getRuleContext(CalculateExprContext.class,0);
		}
		public TerminalNode NL() { return getToken(LibExprParser.NL, 0); }
		public SetVaribleContext(SetVarContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LibExprVisitor ) return ((LibExprVisitor<? extends T>)visitor).visitSetVarible(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetVarContext setVar() throws RecognitionException {
		SetVarContext _localctx = new SetVarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_setVar);
		try {
			setState(44);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new SetVaribleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(27);
				match(ID);
				setState(28);
				match(EQUAL);
				setState(29);
				calculateExpr(0);
				setState(30);
				match(NL);
				}
				break;
			case 2:
				_localctx = new SetVaribleBRAContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(32);
				match(ID);
				setState(33);
				match(EQUAL);
				setState(34);
				match(LBRA);
				setState(35);
				getAtom();
				setState(36);
				match(RBRA);
				setState(37);
				match(NL);
				}
				break;
			case 3:
				_localctx = new SetAtomContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(39);
				match(ATOM);
				setState(40);
				match(EQUAL);
				setState(41);
				calculateExpr(0);
				setState(42);
				match(NL);
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

	public static class GetAtomContext extends ParserRuleContext {
		public GetAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_getAtom; }
	 
		public GetAtomContext() { }
		public void copyFrom(GetAtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SetAtomValContext extends GetAtomContext {
		public TerminalNode ATOM() { return getToken(LibExprParser.ATOM, 0); }
		public TerminalNode COMMA() { return getToken(LibExprParser.COMMA, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public SetAtomValContext(GetAtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LibExprVisitor ) return ((LibExprVisitor<? extends T>)visitor).visitSetAtomVal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetVarValContext extends GetAtomContext {
		public TerminalNode DOUBLE() { return getToken(LibExprParser.DOUBLE, 0); }
		public TerminalNode COMMA() { return getToken(LibExprParser.COMMA, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public SetVarValContext(GetAtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LibExprVisitor ) return ((LibExprVisitor<? extends T>)visitor).visitSetVarVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GetAtomContext getAtom() throws RecognitionException {
		GetAtomContext _localctx = new GetAtomContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_getAtom);
		try {
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ATOM:
				_localctx = new SetAtomValContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				match(ATOM);
				setState(47);
				match(COMMA);
				setState(48);
				atom();
				}
				break;
			case DOUBLE:
				_localctx = new SetVarValContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				match(DOUBLE);
				setState(50);
				match(COMMA);
				setState(51);
				atom();
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

	public static class CalculateExprContext extends ParserRuleContext {
		public CalculateExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calculateExpr; }
	 
		public CalculateExprContext() { }
		public void copyFrom(CalculateExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MultiplicationContext extends CalculateExprContext {
		public TerminalNode INT() { return getToken(LibExprParser.INT, 0); }
		public TerminalNode MUL() { return getToken(LibExprParser.MUL, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public MultiplicationContext(CalculateExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LibExprVisitor ) return ((LibExprVisitor<? extends T>)visitor).visitMultiplication(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SequentialContext extends CalculateExprContext {
		public CalculateExprContext calculateExpr() {
			return getRuleContext(CalculateExprContext.class,0);
		}
		public TerminalNode SEQ() { return getToken(LibExprParser.SEQ, 0); }
		public CallOrchoiceContext callOrchoice() {
			return getRuleContext(CallOrchoiceContext.class,0);
		}
		public SequentialContext(CalculateExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LibExprVisitor ) return ((LibExprVisitor<? extends T>)visitor).visitSequential(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParalleContext extends CalculateExprContext {
		public CalculateExprContext calculateExpr() {
			return getRuleContext(CalculateExprContext.class,0);
		}
		public TerminalNode PARA() { return getToken(LibExprParser.PARA, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public CallOrchoiceContext callOrchoice() {
			return getRuleContext(CallOrchoiceContext.class,0);
		}
		public ParalleContext(CalculateExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LibExprVisitor ) return ((LibExprVisitor<? extends T>)visitor).visitParalle(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ToCallOrchoiceContext extends CalculateExprContext {
		public CallOrchoiceContext callOrchoice() {
			return getRuleContext(CallOrchoiceContext.class,0);
		}
		public ToCallOrchoiceContext(CalculateExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LibExprVisitor ) return ((LibExprVisitor<? extends T>)visitor).visitToCallOrchoice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CalculateExprContext calculateExpr() throws RecognitionException {
		return calculateExpr(0);
	}

	private CalculateExprContext calculateExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CalculateExprContext _localctx = new CalculateExprContext(_ctx, _parentState);
		CalculateExprContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_calculateExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				_localctx = new MultiplicationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(55);
				match(INT);
				setState(56);
				match(MUL);
				setState(57);
				atom();
				}
				break;
			case 2:
				{
				_localctx = new ToCallOrchoiceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(58);
				callOrchoice(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(71);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(69);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new SequentialContext(new CalculateExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_calculateExpr);
						setState(61);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(62);
						match(SEQ);
						setState(63);
						callOrchoice(0);
						}
						break;
					case 2:
						{
						_localctx = new ParalleContext(new CalculateExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_calculateExpr);
						setState(64);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(65);
						match(PARA);
						setState(66);
						atom();
						setState(67);
						callOrchoice(0);
						}
						break;
					}
					} 
				}
				setState(73);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class CallOrchoiceContext extends ParserRuleContext {
		public CallOrchoiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callOrchoice; }
	 
		public CallOrchoiceContext() { }
		public void copyFrom(CallOrchoiceContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CallContext extends CallOrchoiceContext {
		public CallOrchoiceContext callOrchoice() {
			return getRuleContext(CallOrchoiceContext.class,0);
		}
		public TerminalNode CAL() { return getToken(LibExprParser.CAL, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public NextContext next() {
			return getRuleContext(NextContext.class,0);
		}
		public CallContext(CallOrchoiceContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LibExprVisitor ) return ((LibExprVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ChoiceContext extends CallOrchoiceContext {
		public CallOrchoiceContext callOrchoice() {
			return getRuleContext(CallOrchoiceContext.class,0);
		}
		public TerminalNode CHO() { return getToken(LibExprParser.CHO, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public NextContext next() {
			return getRuleContext(NextContext.class,0);
		}
		public ChoiceContext(CallOrchoiceContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LibExprVisitor ) return ((LibExprVisitor<? extends T>)visitor).visitChoice(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ToNextContext extends CallOrchoiceContext {
		public NextContext next() {
			return getRuleContext(NextContext.class,0);
		}
		public ToNextContext(CallOrchoiceContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LibExprVisitor ) return ((LibExprVisitor<? extends T>)visitor).visitToNext(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallOrchoiceContext callOrchoice() throws RecognitionException {
		return callOrchoice(0);
	}

	private CallOrchoiceContext callOrchoice(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CallOrchoiceContext _localctx = new CallOrchoiceContext(_ctx, _parentState);
		CallOrchoiceContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_callOrchoice, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ToNextContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(75);
			next();
			}
			_ctx.stop = _input.LT(-1);
			setState(89);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(87);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new CallContext(new CallOrchoiceContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_callOrchoice);
						setState(77);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(78);
						match(CAL);
						setState(79);
						atom();
						setState(80);
						next();
						}
						break;
					case 2:
						{
						_localctx = new ChoiceContext(new CallOrchoiceContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_callOrchoice);
						setState(82);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(83);
						match(CHO);
						setState(84);
						atom();
						setState(85);
						next();
						}
						break;
					}
					} 
				}
				setState(91);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class NextContext extends ParserRuleContext {
		public NextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_next; }
	 
		public NextContext() { }
		public void copyFrom(NextContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ChangeSignContext extends NextContext {
		public TerminalNode MUL() { return getToken(LibExprParser.MUL, 0); }
		public NextContext next() {
			return getRuleContext(NextContext.class,0);
		}
		public ChangeSignContext(NextContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LibExprVisitor ) return ((LibExprVisitor<? extends T>)visitor).visitChangeSign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ToAtomContext extends NextContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public ToAtomContext(NextContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LibExprVisitor ) return ((LibExprVisitor<? extends T>)visitor).visitToAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NextContext next() throws RecognitionException {
		NextContext _localctx = new NextContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_next);
		try {
			setState(95);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MUL:
				_localctx = new ChangeSignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				match(MUL);
				setState(93);
				next();
				}
				break;
			case ID:
			case ATOM:
			case INT:
			case DOUBLE:
			case LPAR:
				_localctx = new ToAtomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				atom();
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

	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AtomVarContext extends AtomContext {
		public TerminalNode ATOM() { return getToken(LibExprParser.ATOM, 0); }
		public AtomVarContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LibExprVisitor ) return ((LibExprVisitor<? extends T>)visitor).visitAtomVar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableContext extends AtomContext {
		public TerminalNode ID() { return getToken(LibExprParser.ID, 0); }
		public VariableContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LibExprVisitor ) return ((LibExprVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BracesContext extends AtomContext {
		public TerminalNode LPAR() { return getToken(LibExprParser.LPAR, 0); }
		public CalculateExprContext calculateExpr() {
			return getRuleContext(CalculateExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(LibExprParser.RPAR, 0); }
		public BracesContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LibExprVisitor ) return ((LibExprVisitor<? extends T>)visitor).visitBraces(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoubleContext extends AtomContext {
		public TerminalNode DOUBLE() { return getToken(LibExprParser.DOUBLE, 0); }
		public DoubleContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LibExprVisitor ) return ((LibExprVisitor<? extends T>)visitor).visitDouble(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntContext extends AtomContext {
		public TerminalNode INT() { return getToken(LibExprParser.INT, 0); }
		public IntContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LibExprVisitor ) return ((LibExprVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_atom);
		try {
			setState(105);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOUBLE:
				_localctx = new DoubleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				match(DOUBLE);
				}
				break;
			case INT:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				match(INT);
				}
				break;
			case ID:
				_localctx = new VariableContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(99);
				match(ID);
				}
				break;
			case ATOM:
				_localctx = new AtomVarContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(100);
				match(ATOM);
				}
				break;
			case LPAR:
				_localctx = new BracesContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(101);
				match(LPAR);
				setState(102);
				calculateExpr(0);
				setState(103);
				match(RPAR);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return calculateExpr_sempred((CalculateExprContext)_localctx, predIndex);
		case 5:
			return callOrchoice_sempred((CallOrchoiceContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean calculateExpr_sempred(CalculateExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean callOrchoice_sempred(CallOrchoiceContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26n\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\6\2\24\n\2\r\2"+
		"\16\2\25\3\3\3\3\3\3\3\3\5\3\34\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4/\n\4\3\5\3\5\3\5\3\5\3\5\3\5\5"+
		"\5\67\n\5\3\6\3\6\3\6\3\6\3\6\5\6>\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\7\6H\n\6\f\6\16\6K\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\7\7Z\n\7\f\7\16\7]\13\7\3\b\3\b\3\b\5\bb\n\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\5\tl\n\t\3\t\2\4\n\f\n\2\4\6\b\n\f\16\20\2\2\2t\2\23\3"+
		"\2\2\2\4\33\3\2\2\2\6.\3\2\2\2\b\66\3\2\2\2\n=\3\2\2\2\fL\3\2\2\2\16a"+
		"\3\2\2\2\20k\3\2\2\2\22\24\5\4\3\2\23\22\3\2\2\2\24\25\3\2\2\2\25\23\3"+
		"\2\2\2\25\26\3\2\2\2\26\3\3\2\2\2\27\34\5\6\4\2\30\31\5\n\6\2\31\32\7"+
		"\b\2\2\32\34\3\2\2\2\33\27\3\2\2\2\33\30\3\2\2\2\34\5\3\2\2\2\35\36\7"+
		"\3\2\2\36\37\7\n\2\2\37 \5\n\6\2 !\7\b\2\2!/\3\2\2\2\"#\7\3\2\2#$\7\n"+
		"\2\2$%\7\23\2\2%&\5\b\5\2&\'\7\24\2\2\'(\7\b\2\2(/\3\2\2\2)*\7\4\2\2*"+
		"+\7\n\2\2+,\5\n\6\2,-\7\b\2\2-/\3\2\2\2.\35\3\2\2\2.\"\3\2\2\2.)\3\2\2"+
		"\2/\7\3\2\2\2\60\61\7\4\2\2\61\62\7\20\2\2\62\67\5\20\t\2\63\64\7\6\2"+
		"\2\64\65\7\20\2\2\65\67\5\20\t\2\66\60\3\2\2\2\66\63\3\2\2\2\67\t\3\2"+
		"\2\289\b\6\1\29:\7\5\2\2:;\7\13\2\2;>\5\20\t\2<>\5\f\7\2=8\3\2\2\2=<\3"+
		"\2\2\2>I\3\2\2\2?@\f\5\2\2@A\7\f\2\2AH\5\f\7\2BC\f\4\2\2CD\7\r\2\2DE\5"+
		"\20\t\2EF\5\f\7\2FH\3\2\2\2G?\3\2\2\2GB\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ"+
		"\3\2\2\2J\13\3\2\2\2KI\3\2\2\2LM\b\7\1\2MN\5\16\b\2N[\3\2\2\2OP\f\5\2"+
		"\2PQ\7\17\2\2QR\5\20\t\2RS\5\16\b\2SZ\3\2\2\2TU\f\4\2\2UV\7\16\2\2VW\5"+
		"\20\t\2WX\5\16\b\2XZ\3\2\2\2YO\3\2\2\2YT\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2["+
		"\\\3\2\2\2\\\r\3\2\2\2][\3\2\2\2^_\7\13\2\2_b\5\16\b\2`b\5\20\t\2a^\3"+
		"\2\2\2a`\3\2\2\2b\17\3\2\2\2cl\7\6\2\2dl\7\5\2\2el\7\3\2\2fl\7\4\2\2g"+
		"h\7\21\2\2hi\5\n\6\2ij\7\22\2\2jl\3\2\2\2kc\3\2\2\2kd\3\2\2\2ke\3\2\2"+
		"\2kf\3\2\2\2kg\3\2\2\2l\21\3\2\2\2\r\25\33.\66=GIY[ak";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}