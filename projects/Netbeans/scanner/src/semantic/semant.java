/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semantic;

import java.util.ArrayList;
import static parsing.parser.tokens;
import static scanner.servent.coder;
import static termnology.terms.INT;
import static termnology.terms.REAL;
import static termnology.terms.STRING;

/**
 *
 * @author DELL
 */
public class semant {

    public static ArrayList<variable> variables = new ArrayList();
    public static String realTokens[] = new String[tokens.length];

    public static String semantic_ana(String[] tokens) {
        get_real();
        String tmp = "";
        String x = "correct semantics\n";
        for (int i = 0; i < tokens.length; i++) {

            String temp = tokens[i];
            if (temp.equals(INT.toString()) || temp.equals(REAL.toString()) || temp.equals(STRING.toString())) {
                if (variable.checkExist(realTokens[i + 1])) {
                    tmp += "variable " + realTokens[i + 1] + " is defined more than one time\n";
                } else {
                    variables.add(new variable(temp, realTokens[i + 1]));
                }
            } else if (temp.equals(":=") || temp.equals("==") || temp.equals("!=") || temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/")) {
                tmp += variable.check2Exist(realTokens[i - 1], realTokens[i + 1], tokens[ i - 1], tokens[i + 1]);
            }
        }

        return tmp.equals("") ? x : tmp;
    }

    public static void get_real() {
        int index = 0;

        for (int i = 0; i < coder.length; i++) {
            if (coder[i].equals("\n") || coder[i].length() == 0) {

                continue;
            }
            realTokens[index++] = coder[i];
        }
    }

    public static String get_vars() {
        String temp = "variable     type       value\n";
        for (variable variable : variables) {
            temp += variable.name + "    " + variable.type + "    " + variable.value + "\n";
        }
        return temp;
    }

    public static String oneLine(String[] s, String tmp) {
        String temp = "";
        for (int i = 0; i < s.length; i++) {
            temp += s[i] + tmp;
        }
        return temp;
    }
}
