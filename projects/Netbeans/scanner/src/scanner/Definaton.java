/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scanner;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Definaton {

    public static ArrayList<keyWord> keys = new ArrayList();
    public static ArrayList<String> STRINGS = new ArrayList();
    public static ArrayList<String> IDS = new ArrayList();
    public static ArrayList<Double> REALS = new ArrayList();
    public static ArrayList<Integer> INTEGERS = new ArrayList();
    public static ArrayList<String> FUNCTIONS = new ArrayList();

    public static void start_defination() {

        keys.add(new keyWord("else", "ELSE") {
        });
        keys.add(new keyWord("if", "IF") {
        });
        keys.add(new keyWord("end", "END") {
        });
        keys.add(new keyWord("int", "INT") {
        });
        keys.add(new keyWord("string", "STRING") {
        });
        keys.add(new keyWord("real", "REAL") {
        });
        keys.add(new keyWord("read", "READ") {
        });
        keys.add(new keyWord("write", "WRITE") {
        });
        keys.add(new keyWord("return", "RETURN") {
        });
        keys.add(new keyWord(";", ";") {
        });
        keys.add(new keyWord(",", ",") {
        });
        keys.add(new keyWord("[+]", "+") {
        });
        keys.add(new keyWord("-", "-") {
        });
        keys.add(new keyWord("[*]", "*") {
        });
        keys.add(new keyWord("[/]", "/") {
        });
        keys.add(new keyWord(">", "<") {
        });
        keys.add(new keyWord(">", "<") {
        });
        keys.add(new keyWord("[(]", "(") {
        });
        keys.add(new keyWord("\n", "\n") {
        });
        keys.add(new keyWord("[)]", ")") {
        });
        keys.add(new keyWord(":=", ":=") {
        });
        keys.add(new keyWord("==", "==") {
        });
        keys.add(new keyWord("!=", "!=") {
        });
        keys.add(new keyWord("[-]?[0-9]+", "int_number") {

            @Override
            public void action(String temp) {
                INTEGERS.add(Integer.parseInt(temp));
            }

            @Override
            public String show() {
                return ("->" + INTEGERS.get(INTEGERS.size() - 1) + " ");
            }

        });
        keys.add(new keyWord("[-]?[0-9]+.[0-9]+", "real_number") {

            @Override
            public void action(String temp) {
                REALS.add(Double.parseDouble(temp));
            }

            @Override
            public String show() {
                return ("->" + REALS.get(REALS.size() - 1) + " ");
            }

        });
        keys.add(new keyWord("var[a-z]*", "ID") {

            @Override
            public void action(String temp) {
                IDS.add(temp);
            }

            @Override
            public String show() {
                return ("->" + IDS.get(IDS.size() - 1) + " ");
            }

        });
        keys.add(new keyWord("begin", "BEGIN") {
        });
        keys.add(new keyWord("main", "MAIN") {
        });
        keys.add(new keyWord("f[[a-z]*[A-Z]*[0-9]*]*", "FUNCTION") {

            @Override
            public void action(String temp) {
                FUNCTIONS.add(temp);
            }

            @Override
            public String show() {
                return ("->" + FUNCTIONS.get(FUNCTIONS.size() - 1) + " ");
            }

        });
        keys.add(new keyWord("[\"][\\w*\\W*]*[\"]", "STRING_VAL") {

            @Override
            public void action(String temp) {
                STRINGS.add(temp.replaceAll("\"", "").replaceAll("sp", " ").replaceAll("ss", ""));
            }

            @Override
            public String show() {
                return ("->\"" + STRINGS.get(STRINGS.size() - 1) + "\" ");
            }

        });
        keys.add(new keyWord("", "") {
        });
    }

    // each variable starts with var only chars
    // each fucntion starts with f only chars and numbers
    // need to leave space between each token and anther
    // strings don't have spacceduse sp instead of space or ss instead of s
    public static String matcher(String[] code) {
        String temp = "";

        for (int i = 0; i < code.length; i++) {
            for (int j = 0; j < keys.size(); j++) {
                if (code[i].toLowerCase().matches(keys.get(j).codeValue)) {
                    keys.get(j).action(code[i]);
                    temp += keys.get(j).scannerValue + " ";
                    break;
                }
                if (j == keys.size() - 1) {
                    temp += " Error:" + code[i] + " ";
                }
            }

        }
        return temp;
    }
}
