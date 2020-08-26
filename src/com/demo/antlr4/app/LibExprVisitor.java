package com.demo.antlr4.app;
// Generated from LibExpr.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import com.demo.antlr4.app.*;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LibExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LibExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LibExprParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(LibExprParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToSetVar}
	 * labeled alternative in {@link LibExprParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToSetVar(LibExprParser.ToSetVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Calculate}
	 * labeled alternative in {@link LibExprParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalculate(LibExprParser.CalculateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetVarible}
	 * labeled alternative in {@link LibExprParser#setVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetVarible(LibExprParser.SetVaribleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetVaribleBRA}
	 * labeled alternative in {@link LibExprParser#setVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetVaribleBRA(LibExprParser.SetVaribleBRAContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetAtom}
	 * labeled alternative in {@link LibExprParser#setVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetAtom(LibExprParser.SetAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetAtomVal}
	 * labeled alternative in {@link LibExprParser#getAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetAtomVal(LibExprParser.SetAtomValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetVarVal}
	 * labeled alternative in {@link LibExprParser#getAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetVarVal(LibExprParser.SetVarValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link LibExprParser#calculateExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplication(LibExprParser.MultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Sequential}
	 * labeled alternative in {@link LibExprParser#calculateExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequential(LibExprParser.SequentialContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Paralle}
	 * labeled alternative in {@link LibExprParser#calculateExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParalle(LibExprParser.ParalleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToCallOrchoice}
	 * labeled alternative in {@link LibExprParser#calculateExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToCallOrchoice(LibExprParser.ToCallOrchoiceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Call}
	 * labeled alternative in {@link LibExprParser#callOrchoice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(LibExprParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Choice}
	 * labeled alternative in {@link LibExprParser#callOrchoice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChoice(LibExprParser.ChoiceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToNext}
	 * labeled alternative in {@link LibExprParser#callOrchoice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToNext(LibExprParser.ToNextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ChangeSign}
	 * labeled alternative in {@link LibExprParser#next}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChangeSign(LibExprParser.ChangeSignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToAtom}
	 * labeled alternative in {@link LibExprParser#next}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToAtom(LibExprParser.ToAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Double}
	 * labeled alternative in {@link LibExprParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDouble(LibExprParser.DoubleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link LibExprParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(LibExprParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link LibExprParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(LibExprParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AtomVar}
	 * labeled alternative in {@link LibExprParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomVar(LibExprParser.AtomVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Braces}
	 * labeled alternative in {@link LibExprParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBraces(LibExprParser.BracesContext ctx);
}