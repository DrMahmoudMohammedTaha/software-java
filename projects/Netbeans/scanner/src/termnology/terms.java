/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package termnology;

import static parsing.parser.getKey;
import scanner.keyWord;

/**
 *
 * @author DELL
 */
public class terms {
    
    public final static  terminal ACCEPT = new terminal(new keyWord("$", "$") {});
    public static terminal SEMI_COLON;
    public static terminal WRITE;
    public static terminal READ;
    public static terminal IF;
    public static terminal ELSE;
    public static terminal RETURN;
    public static terminal BEGIN;
    public static terminal END;
    public static terminal MAIN;
    public static terminal STRING;
    public static terminal STRING_VAL;
    public static terminal INT;
    public static terminal REAL;
    public static terminal PLUS;
    public static terminal MINUS;
    public static terminal IN;
    public static terminal ON;
    public static terminal COMMA;
    public static terminal OPEN_BRACKET;
    public static terminal CLOSE_BRACKET;
    public static terminal NOT_EQUAL;
    public static terminal IS_EQUAL;
    public static terminal BE_EQUAL;
    public static terminal GREATER;
    public static terminal LESS;
    public static terminal INT_NUM;
    public static terminal REAL_NUM;
    public static terminal ID;
    
    public static void start_terminals() {

        SEMI_COLON = new terminal(getKey(";"));
        WRITE = new terminal(getKey("write"));
        READ = new terminal(getKey("read"));
        IF = new terminal(getKey("if"));
        ELSE = new terminal(getKey("else"));
        RETURN = new terminal(getKey("return"));
        BEGIN = new terminal(getKey("begin"));
        END = new terminal(getKey("end"));
        MAIN = new terminal(getKey("main"));
        STRING = new terminal(getKey("string"));
        STRING_VAL = new terminal(getKey("STRING_VAL"));
        INT = new terminal(getKey("int"));
        REAL = new terminal(getKey("real"));
        PLUS = new terminal(getKey("+"));
        MINUS = new terminal(getKey("-"));
        IN = new terminal(getKey("*"));
        ON = new terminal(getKey("/"));
        COMMA = new terminal(getKey(","));
        OPEN_BRACKET = new terminal(getKey("("));
        CLOSE_BRACKET = new terminal(getKey(")"));
        NOT_EQUAL = new terminal(getKey("!="));
        IS_EQUAL = new terminal(getKey("=="));
        BE_EQUAL = new terminal(getKey(":="));
        GREATER = new terminal(getKey(">"));
        LESS = new terminal(getKey("<"));
        INT_NUM = new terminal(getKey("int_number"));
        REAL_NUM = new terminal(getKey("real_number"));
        ID = new terminal(getKey("id"));
    }
}
