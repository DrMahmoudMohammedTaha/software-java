/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsing;

import termnology.nonTerms;
import termnology.terms;
import java.util.Stack;
import scanner.keyWord;
import static scanner.Definaton.keys;
import termnology.Symbol;

/**
 *
 * @author DELL
 */
public class parser {

    public static String[] tokens;
    public static Stack<String> tokenStack = new Stack();
    public static Stack<Symbol> parseStack = new Stack();
    public static String ID;
    public static String FormalParam;

    public static boolean parse(String s) {
        terms.start_terminals();
        nonTerms.start_non_terminal();
        fillTokens(s);
        fillParser();
        return table.moveSteps();
    }
    public static void fillParser ()
    {
       parseStack.push(terms.ACCEPT);
       parseStack.push(nonTerms.PROGRAM);
       table.checkValidity();
    }
    public static void fillTokens(String s) {
        tokens = s.replaceAll("\n", " ").replaceAll("\\s+", " ").split(" ");
        tokenStack.empty();
        tokenStack.push("$");
        
        for (int i = tokens.length-1 ; i >= 0 ; i--) {
            tokenStack.push(tokens[i]);
 
        }
    }

    public static keyWord getKey(String k) {
        for (int i = 0; i < keys.size(); i++) {
            if (k.toLowerCase().equals(keys.get(i).scannerValue.toLowerCase())) {
                return keys.get(i);
            }
        }
        return null;
    }

}
