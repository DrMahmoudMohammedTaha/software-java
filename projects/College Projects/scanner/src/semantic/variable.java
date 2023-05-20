/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semantic;

import static semantic.semant.variables;
import static termnology.terms.INT;
import static termnology.terms.INT_NUM;
import static termnology.terms.REAL;
import static termnology.terms.REAL_NUM;
import static termnology.terms.STRING;
import static termnology.terms.STRING_VAL;

/**
 *
 * @author DELL
 */
public class variable {

    public String type;
    public String name;
    public String value;

    public variable(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public static boolean checkTypes(variable v1, variable v2) {
        return v1.type.equals(v2.type);
    }

    public static boolean checkFlow(variable v1, String data) {
        if (data.equals(INT_NUM)) {
            return v1.type.equals(INT);
        } else if (data.equals(REAL_NUM)) {
            return v1.type.equals(REAL);
        } else if (data.equals(STRING_VAL)) {
            return v1.type.equals(STRING);
        }
        return false;
    }

    public static String get_t(String data) {
        if (data.equals(INT_NUM.toString())) {
            return INT.toString();
        } else if (data.equals(REAL_NUM.toString())) {
            return REAL.toString();
        } else if (data.equals(STRING_VAL.toString())) {
            return STRING.toString();
        }
        return "";
    }

    public static boolean checkExist(String nm) {
        for (int i = 0; i < variables.size(); i++) {
            if (variables.get(i).name.equals(nm)) {
                return true;
            }
        }
        return false;
    }

    public static String check2Exist(String s1, String s2, String t1, String t2) {
        String temp = "";
        if (s1.contains("var")) {
            if (!checkExist(s1)) {
                temp += "variable " + s1 + " doesn't exist!\n";
            }
        } else if (s2.contains("var")) {
            if (!checkExist(s2)) {
                temp += "variable " + s2 + " doesn't exist!\n";
            }

        }
        if (temp.equals("")) {
            temp += check2Flow(s1, s2, t1, t2);
        }
        return temp;
    }

    public static String check2Flow(String s1, String s2, String t1, String t2) {
        String temp = "";
        String tp1 = get_t(t1) , tp2 = get_t(t2);
        for (int i = 0; i < variables.size(); i++) {
            if (variables.get(i).name.equals(s1)) {
                tp1 = variables.get(i).type;
                break;
            }
        }

        for (int i = 0; i < variables.size(); i++) {
            if (variables.get(i).name.equals(s2)) {
                tp2 = variables.get(i).type;
                break;
            }
        }

        if (!tp1.equals(tp2)) {
            temp += s1 + " and " + s2 + " cannot have operations together!\n";
        }

        return temp;
    }
}
