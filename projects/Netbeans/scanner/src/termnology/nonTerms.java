/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package termnology;

import parsing.Expression;
import parsing.Production;
import static termnology.terms.ACCEPT;
import static termnology.terms.BEGIN;
import static termnology.terms.BE_EQUAL;
import static termnology.terms.CLOSE_BRACKET;
import static termnology.terms.COMMA;
import static termnology.terms.ELSE;
import static termnology.terms.END;
import static termnology.terms.ID;
import static termnology.terms.IF;
import static termnology.terms.IN;
import static termnology.terms.INT;
import static termnology.terms.INT_NUM;
import static termnology.terms.IS_EQUAL;
import static termnology.terms.MINUS;
import static termnology.terms.NOT_EQUAL;
import static termnology.terms.ON;
import static termnology.terms.OPEN_BRACKET;
import static termnology.terms.PLUS;
import static termnology.terms.READ;
import static termnology.terms.REAL;
import static termnology.terms.REAL_NUM;
import static termnology.terms.RETURN;
import static termnology.terms.SEMI_COLON;
import static termnology.terms.STRING;
import static termnology.terms.STRING_VAL;
import static termnology.terms.WRITE;

/**
 *
 * @author DELL
 */
public class nonTerms {

    public static void start_non_terminal() {

        BLOCK = new nonTerminal("BLOCK", new Expression(new Production()));

        start_high_level();
        start_expression();
        start_statements();
    }

// statements definations
    public static String temp[];
    public static nonTerminal ReadStmt;
    public static nonTerminal BLOCK;
    public static nonTerminal Statements;
    public static nonTerminal Statement;
    public static nonTerminal Statement_temp;
    public static nonTerminal WriteStmt;
    public static nonTerminal LocalVarDecl;
    public static nonTerminal AssignStmt;
    public static nonTerminal AssignStmt_;
    public static nonTerminal ReturnStmt;
    public static nonTerminal IfStmt;

    public static void start_statements() {

        LocalVarDecl = new nonTerminal("LocalVarDecl", new Expression(new Production(null)));
        WriteStmt = new nonTerminal("WriteStmt", new Expression(new Production(null)));
        ReturnStmt = new nonTerminal("ReturnStmt", new Expression(new Production(null)));
        IfStmt = new nonTerminal("IfStmt", new Expression(new Production(null)));
        AssignStmt = new nonTerminal("AssignStmt", new Expression(new Production(null)));

        temp = new String[]{READ + " 0"};
        ReadStmt = new nonTerminal("ReadStmt", new Expression(new Production(READ, OPEN_BRACKET, ID, COMMA, STRING_VAL, CLOSE_BRACKET, SEMI_COLON)), temp);

        temp = new String[]{INT + " 1", REAL + " 1", STRING + " 1", ID + " 2", RETURN + " 3", IF + " 4", WRITE + " 5", READ + " 6"};
        Statement = new nonTerminal("Statment", new Expression(BLOCK, LocalVarDecl, AssignStmt, ReturnStmt, IfStmt, WriteStmt, ReadStmt), temp);

        temp = new String[]{INT + " 0", REAL + " 0", STRING + " 0", ID + " 0", RETURN + " 0", IF + " 0", WRITE + " 0", READ + " 0", END + " -1", ELSE + " -1"};
        Statement_temp = new nonTerminal(new Expression(new Production(true, Statement)), temp);

        temp = new String[]{INT + " 0", REAL + " 0", STRING + " 0", ID + " 0", RETURN + " 0", IF + " 0", WRITE + " 0", READ + " 0"};
        Statements = new nonTerminal("Statments", new Expression(new Production(Statement, Statement_temp)), temp);

        temp = new String[]{BEGIN + " 0"};
        BLOCK.setExpression(new Expression(new Production(BEGIN, Statements, END)), temp);

        temp = new String[]{WRITE + " 0"};
        WriteStmt.setExpression(new Expression(new Production(WRITE, OPEN_BRACKET, Expression, COMMA, STRING_VAL, CLOSE_BRACKET, SEMI_COLON)), temp);

        temp = new String[]{RETURN + " 0"};
        ReturnStmt.setExpression(new Expression(new Production(RETURN, Expression, SEMI_COLON)), temp);

        temp = new String[]{INT_NUM + " 0", REAL_NUM + " 0", OPEN_BRACKET + " 0", ID + " 0", STRING_VAL + " 1"};
        AssignStmt_ = new nonTerminal("AssignStmt", new Expression(new Production(Expression, SEMI_COLON), new Production(STRING_VAL, SEMI_COLON)), temp);
        temp = new String[]{ID + " 0", INT_NUM + " 1", REAL_NUM + " 2"};
        AssignStmt.setExpression( new Expression(new Production(ID, BE_EQUAL, AssignStmt_), new Production(INT_NUM), new Production(REAL_NUM)), temp);

        temp = new String[]{IF + " 0"};
        IfStmt.setExpression(new Expression(new Production(IF, OPEN_BRACKET, BoolExpression, CLOSE_BRACKET, Statement, ELSE, Statement)), temp);
        //IfStmt = new nonTerminal("IfStmt", new Expression(new Production(IF, OPEN_BRACKET, BoolExpression, CLOSE_BRACKET, Statement), new Production(IF, OPEN_BRACKET, BoolExpression, CLOSE_BRACKET, Statement, ELSE, Statement)));

        temp = new String[]{INT + " 0", REAL + " 0", STRING + " 0"};
        LocalVarDecl.setExpression(new Expression(new Production(TYPE, AssignStmt)), temp);

    }

    // high level definations
    public static nonTerminal TYPE;
    public static nonTerminal FormalParam;
    public static nonTerminal FormalParams_temp;
    public static nonTerminal FormalParams;
    public static nonTerminal MethodDecl;
    public static nonTerminal MethodDecl_temp;
    public static nonTerminal PROGRAM;

    public static void start_high_level() {

        temp = new String[]{INT + " 0", REAL + " 1", STRING + " 2"};
        TYPE = new nonTerminal("TYPE", new Expression(INT, REAL, STRING), temp);

        temp = new String[]{INT + " 0", REAL + " 0", STRING + " 0"};
        FormalParam = new nonTerminal("FormalParam", new Expression(new Production(TYPE, ID)), temp);
        temp = new String[]{COMMA + " 0", SEMI_COLON + " -1", CLOSE_BRACKET + " -1"};
        FormalParams_temp = new nonTerminal(new Expression(new Production(true, COMMA, FormalParam)), temp);
        temp = new String[]{INT + " 0", REAL + " 0", STRING + " 0", CLOSE_BRACKET + " -1"};
        FormalParams = new nonTerminal("FormalParams", new Expression(new Production(FormalParam, FormalParams_temp)), temp);

        temp = new String[]{INT + " 0", REAL + " 0", STRING + " 0"};
        MethodDecl = new nonTerminal("MethodDecl", new Expression(new Production(TYPE, ID, OPEN_BRACKET, FormalParams, CLOSE_BRACKET, BLOCK)), temp);
        temp = new String[]{INT + " 0", REAL + " 0", STRING + " 0", ACCEPT + " -1"};
        MethodDecl_temp = new nonTerminal(new Expression(new Production(true, MethodDecl)), temp);

        temp = new String[]{INT + " 0", REAL + " 0", STRING + " 0", ACCEPT + " 0"};
        PROGRAM = new nonTerminal("PROGRAM", new Expression(new Production(MethodDecl, MethodDecl_temp)), temp);

    }

    public static nonTerminal Expression;
    public static nonTerminal Expression_temp;
    public static nonTerminal MultiplicativeExpr;
    public static nonTerminal PrimaryExpr;
    public static nonTerminal ActualParams;
    public static nonTerminal BoolExpression;
    public static nonTerminal BoolExpression_;
    public static nonTerminal NUMBER;
    public static nonTerminal ADDITIVE;
    public static nonTerminal MULTIVIE;
    public static nonTerminal MultiplicativeExpr_temp;
    public static nonTerminal PrimaryExpr_temp;

    private static void start_expression() {

        temp = new String[]{IN + " 0", ON + " 1"};
        MULTIVIE = new nonTerminal(new Expression(IN, ON), temp);

        temp = new String[]{PLUS + " 0", MINUS + " 1"};
        ADDITIVE = new nonTerminal(new Expression(PLUS, MINUS), temp);

        temp = new String[]{INT_NUM + " 0", REAL_NUM + " 1"};
        NUMBER = new nonTerminal("NUMBER", new Expression(INT_NUM, REAL_NUM), temp);

        temp = new String[]{INT_NUM + " 0", REAL_NUM + " 0", OPEN_BRACKET + " 0", ID + " 0"};
        Expression = new nonTerminal("Expression", new Expression(new Production()), temp);

        temp = new String[]{COMMA + " 0", CLOSE_BRACKET + " -1", COMMA + " -1", SEMI_COLON + " -1", IS_EQUAL + " -1", NOT_EQUAL + " -1"};
        Expression_temp = new nonTerminal(new Expression(new Production(true, COMMA, Expression)), temp);

        temp = new String[]{INT_NUM + " 0", REAL_NUM + " 0", OPEN_BRACKET + " 0", ID + " 0"};
        ActualParams = new nonTerminal("ActualParams", new Expression(new Production(Expression, Expression_temp)), temp);

        temp = new String[]{INT_NUM + " 0", REAL_NUM + " 0", ID + " 1", OPEN_BRACKET + " 2"};
        PrimaryExpr = new nonTerminal("PrimaryExpr", new Expression(new Production(NUMBER),
                new Production(ID), new Production(OPEN_BRACKET, Expression, CLOSE_BRACKET)), temp);

        temp = new String[]{IN + " 0", ON + " 0", PLUS + " -1", MINUS + " -1", CLOSE_BRACKET + " -1", COMMA + " -1", SEMI_COLON + " -1", IS_EQUAL + " -1", NOT_EQUAL + " -1"};
        PrimaryExpr_temp = new nonTerminal(new Expression(new Production(true, MULTIVIE, PrimaryExpr)), temp);

        temp = new String[]{IS_EQUAL + " 0", NOT_EQUAL + " 1"};
        BoolExpression_ = new nonTerminal("BoolExpression", new Expression(new Production(IS_EQUAL, Expression), new Production(NOT_EQUAL, Expression)), temp);

        temp = new String[]{INT_NUM + " 0", REAL_NUM + " 0", OPEN_BRACKET + " 0", ID + " 0"};
        BoolExpression = new nonTerminal("BoolExpression", new Expression(new Production(Expression, BoolExpression_)), temp);

        temp = new String[]{INT_NUM + " 0", REAL_NUM + " 0", OPEN_BRACKET + " 0", ID + " 0"};
        MultiplicativeExpr = new nonTerminal("MultiplicativeExpr", new Expression(new Production(PrimaryExpr, PrimaryExpr_temp)), temp);

        temp = new String[]{PLUS + " 0", MINUS + " 0", CLOSE_BRACKET + " -1", COMMA + " -1", SEMI_COLON + " -1", IS_EQUAL + " -1", NOT_EQUAL + " -1"};
        MultiplicativeExpr_temp = new nonTerminal(new Expression(new Production(true, ADDITIVE, MultiplicativeExpr)), temp);

        Expression.setExpression(new Expression(new Production(MultiplicativeExpr, MultiplicativeExpr_temp)));

    }
}
