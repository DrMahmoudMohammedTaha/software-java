/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IR;

import static IR.IR_factory.add_instruction;
import static IR.IR_factory.instructions;
import java.util.ArrayList;
import java.util.Arrays;
import termnology.terms;
import static termnology.terms.BE_EQUAL;
import static termnology.terms.IF;
import static termnology.terms.IN;
import static termnology.terms.INT;
import static termnology.terms.IS_EQUAL;
import static termnology.terms.MINUS;
import static termnology.terms.ON;
import static termnology.terms.PLUS;
import static termnology.terms.READ;
import static termnology.terms.REAL;
import static termnology.terms.RETURN;
import static termnology.terms.STRING;
import static termnology.terms.WRITE;

/**
 *
 * @author DELL
 */
public class IR_inst {

    String op;
    String arg1;
    String arg2;
    String result;
    String assembly_code;

    public static final String DEFINE = "def";
    public static final String END_ = "END";
    public static final String BEGIN_ = "def";
    public static int temp_num = 0;
    public static int label_num = 0;
    public static final String param = "getParameter";
    public static final String GOTO = "goto";
    public static final String LABEL = "lbl";

    public String get_assembly() {
        return assembly_code;
    }

    public IR_inst(String op, String arg1, String arg2, String result, String assembly_code) {
        this.op = op;
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.result = result;
        this.assembly_code = assembly_code;
    }

    @Override
    public String toString() {
        return op + "   " + arg1 + "    " + arg2 + "    " + result;
    }

    public static void add_end() {
        instructions.add(new IR_inst(END_, "main", "", "", "end main"));
    }

    public static void add_define(String[] copyOfRange) {
        String name = copyOfRange[1];
        String type = copyOfRange[0];
        String value = copyOfRange[3];
        String temp = "";
        if (type.equalsIgnoreCase(INT.toString())) {
            temp = "DB";
        } else if (type.equalsIgnoreCase(REAL.toString())) {
            temp = "DW";
        } else if (type.equalsIgnoreCase(STRING.toString())) {
            temp = "DQ";
        }
        String assmbly = name + "    " + temp + "    " + value;
        instructions.add(new IR_inst(DEFINE, type, value, name, assmbly));
    }

    public static void add_begin(String[] copyOfRange) {

        for (int i = 0; i < copyOfRange.length; i += 3) {
            String name = copyOfRange[i + 1];
            String type = copyOfRange[i];
            String value = "0";
            String temp = "";
            if (type.equalsIgnoreCase(INT.toString())) {
                temp = "DB";
            } else if (type.equalsIgnoreCase(REAL.toString())) {
                temp = "DW";
            } else if (type.equalsIgnoreCase(STRING.toString())) {
                temp = "DQ";
            }
            String assmbly = name + "    " + temp + "    " + value;
            instructions.add(new IR_inst(DEFINE, type, value, name, assmbly));
            if (i != 0) {
                instructions.add(new IR_inst(param, name, "   ", "   ", "pop   " + name));
            }
            if (copyOfRange[i + 2].equals(terms.CLOSE_BRACKET.toString())) {
                break;
            }
        }
        instructions.add(new IR_inst("", "", "", "", ""));
        instructions.add(new IR_inst(BEGIN_, "main", " ", " ", "main PROC"));
    }

    public static void add_return(String[] copyOfRange) {
        instructions.add(new IR_inst(RETURN.toString(), copyOfRange[1], "", "", "push " + copyOfRange[1]));
    }

    public static void add_assign(String[] copyOfRange) {

        ArrayList<String> tempData = new ArrayList<>();
        tempData.addAll(Arrays.asList(copyOfRange));

        for (int i = 0; i < tempData.size(); i++) {

            if (tempData.get(i).equals(IN.toString()) || tempData.get(i).equals(ON.toString())) {
                String op = tempData.get(i);
                String arg1 = tempData.get(i - 1);
                String arg2 = tempData.get(i + 1);
                String result = "t" + temp_num++;
                String tmp1 = "LD  " + arg1 + " , R0\n";
                String tmp2 = "LD  " + arg2 + " , R1\n";
                String temp = (tempData.get(i).equals(IN.toString())) ? "MUL" : "DIV";
                String tp = "ST " + "R1" + " , " + result;
                String assembly = tmp1 + tmp2 + temp + " " + "R1" + " , " + "R1" + " , " + "R2\n" + tp;
                instructions.add(new IR_inst(op, arg1, arg2, result, assembly));
                tempData.set(i, result);
                tempData.remove(i - 1);
                tempData.remove(i);
                i -= 2;

            }

        }

        for (int i = 0; i < tempData.size(); i++) {
            if (tempData.get(i).equals(PLUS.toString()) || tempData.get(i).equals(MINUS.toString())) {
                String op = tempData.get(i);
                String arg1 = tempData.get(i - 1);
                String arg2 = tempData.get(i + 1);
                String tmp1 = "LD  " + arg1 + " , R0\n";
                String tmp2 = "LD  " + arg2 + " , R1\n";
                String result = "t" + temp_num++;
                String tp = "ST  " + "R1" + " , " + result;
                String temp = (tempData.get(i).equals(PLUS.toString())) ? "ADD" : "SUB";
                String assembly = tmp1 + tmp2 + temp + " " + "R1" + " , " + "R1" + " , " + "R2\n" + tp;
                instructions.add(new IR_inst(op, arg1, arg2, result, assembly));
                tempData.set(i, result);
                tempData.remove(i - 1);
                tempData.remove(i);
                i -= 2;

            }

        }
        instructions.add(new IR_inst("=", tempData.get(2), "       ", tempData.get(0), "cpy   " + tempData.get(0) + " , " + tempData.get(2)));
    }

    public static void add_read(String[] copyOfRange) {

        String op = BE_EQUAL.toString();
        String arg1 = copyOfRange[4];
        String arg2 = "     ";
        String result = "t" + temp_num++;
        String temp = "CPY";
        String assembly = temp + " " + result + " , " + arg1;
        instructions.add(new IR_inst(op, arg1, arg2, result, assembly));

        op = READ.toString();
        arg1 = result;
        arg2 = "     ";
        result = copyOfRange[2];
        temp = "LD";
        assembly = temp + " " + arg1 + " , " + result;
        instructions.add(new IR_inst(op, arg1, arg2, result, assembly));

    }

    public static void add_write(String[] copyOfRange) {

        String op = BE_EQUAL.toString();
        String arg1 = copyOfRange[4];
        String arg2 = "     ";
        String result = "t" + temp_num++;
        String temp = "CPY";
        String assembly = temp + " " + result + " , " + arg1;
        instructions.add(new IR_inst(op, arg1, arg2, result, assembly));

        op = WRITE.toString();
        arg1 = copyOfRange[2];
        arg2 = "     ";
        temp = "ST";
        assembly = temp + " " + arg1 + " , " + result;
        instructions.add(new IR_inst(op, arg1, arg2, result, assembly));
    }

    static void add_if(String[] copyOfRange) {

        String op = IS_EQUAL.toString();
        String arg1 = copyOfRange[2];
        String arg2 = copyOfRange[4];
        String result = "t" + temp_num++;
        String tmp1 = "LD " + "R1 , " + arg1 + "\n";
        String tmp2 = "LD " + "R2 , " + arg2 + "\n";
        String temp = "SUB";
        String tp = "SD " + "R1 , " + result ;
        String assembly = tmp1 + tmp2 + temp + " " + "R1" + " , " + "R1" + " , " + "R2\n" + tp;
        instructions.add(new IR_inst(op, arg1, arg2, result, assembly));

        op = IF.toString();
        arg1 = "t" + (temp_num - 1);
        arg2 = LABEL + (label_num);
        result = "";
        temp = "BRLZ";
        String tmp = "LD " + "R1 , " + arg1 + "\n";
        assembly = tmp + temp + "   " + "R1";

        instructions.add(new IR_inst(op, arg1, arg2, result, assembly));
        add_instruction(Arrays.copyOfRange(copyOfRange, 6, copyOfRange.length));
        instructions.add(new IR_inst(GOTO, LABEL + (label_num + 1), "", "", "BR  " + LABEL + (label_num + 1)));

    }

    static void add_else(String[] copyOfRange) {
        instructions.add(new IR_inst(LABEL + label_num + ":", "", "", "", LABEL + label_num++ + ":"));
        add_instruction(Arrays.copyOfRange(copyOfRange, 1, copyOfRange.length));
        instructions.add(new IR_inst(LABEL + label_num + ":", "", "", "", LABEL + label_num++ + ":"));
    }

}
