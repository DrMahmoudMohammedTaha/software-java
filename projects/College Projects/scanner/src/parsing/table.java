/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsing;

import static parsing.parser.parseStack;
import static parsing.parser.tokenStack;
import termnology.Symbol;
import static termnology.terms.ACCEPT;

/**
 *
 * @author DELL
 */
public class table {

    public static String process = "";
    public static String matched = "";
    public static String Action = "";
    public static boolean working = true;

    public static boolean checkValidity() {

        return (tokenStack.peek().equals(ACCEPT.toString()) && parseStack.peek().toString().equals(ACCEPT.toString()) && tokenStack.size() == 1);
    }

    public static boolean moveSteps() {
        working = true;
        process = "Matched       Stack      Input      Action\n------------------------------------------\n         & PROGRAM  " + getTokens() + "     ";
        while (working) {
            updateStacks();
            if (tokenStack.isEmpty()) {
                return false;
            }
            if (checkValidity() == true) {
                System.out.println(process);
                return true;
            }
        }
        System.out.println(process);
        return false;
    }

    private static void updateStacks() {

        String token = tokenStack.pop();
        Symbol parsed = parseStack.pop();
        //    System.out.println("token " + token + "         parsed " + parsed);
        if (parsed.toString().equals(token)) {
            process += matchingState(token);
        } else {
            Production temp = parsed.getProduction(token);
            if (temp == null) {
                errorState(token);
            } else {
                tokenStack.push(token);
                if (temp.symbols != null) {

                    for (int i = temp.symbols.size() - 1; i >= 0; i--) {
                        parseStack.push(temp.symbols.get(i));
                    }
                    process += replaceState(parsed, temp);
                }
            }
        }
    }

    private static String matchingState(String token) {

        matched += " " + token;
        Action = token + " matched";
        return Action + "\n" + matched + "       " + getParsed() + "      " + getTokens() + "     ";
    }

    private static String getParsed() {
        String temp = "";
        for (int i = 0; i < parseStack.size(); i++) {
            temp += " " + parseStack.elementAt(i).toString();
        }
        return temp;
    }

    private static String getTokens() {
        String temp = "";
        for (int i = 0; i < tokenStack.size(); i++) {
            temp += " " + tokenStack.elementAt(i);
        }
        return temp;
    }

    private static void errorState(String temp) {
        working = false;
        System.out.println("Error parsing this code it may have errors at element " + temp);
    }

    private static String replaceState(Symbol p, Production temp) {

        Action = p.toString() + " --> " + temp.toString();
        return Action + "\n" + matched + "       " + getParsed() + "      " + getTokens() + "     ";

    }

}
