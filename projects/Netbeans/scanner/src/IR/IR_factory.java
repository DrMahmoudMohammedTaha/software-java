package IR;

import java.util.ArrayList;
import java.util.Arrays;
import static semantic.semant.realTokens;
import static termnology.terms.BEGIN;
import static termnology.terms.ELSE;
import static termnology.terms.END;
import static termnology.terms.IF;
import static termnology.terms.INT;
import static termnology.terms.READ;
import static termnology.terms.REAL;
import static termnology.terms.RETURN;
import static termnology.terms.SEMI_COLON;
import static termnology.terms.STRING;
import static termnology.terms.WRITE;

public class IR_factory {

    public static ArrayList<IR_inst> instructions = new ArrayList();
    public static ArrayList<String[]> blocks = new ArrayList();

    public static String getIRAssembly() {
        convert2IR();
        String temp = "IR code                          assembly code\nop    arg1   arg2   result\n";
        for (int i = 0; i < instructions.size(); i++) {
            //    temp += instructions.get(i).toString() + "              " +instructions.get(i).get_assembly().replaceAll("\n", "\n                                              ")+ "\n";
            // temp += instructions.get(i).toString() +"\n";
            temp += formatData(instructions.get(i).toString(), instructions.get(i).get_assembly());
        }
        return temp;
    }

    public static String formatData(String s1, String s2) {
        String temp = s1;

        for (int i = s1.length(); i < 40; i++) {
            temp += " ";
        }
        temp += "\n";
        String tmps[] = s2.split("\n");
        for (int i = 0; i < tmps.length; i++) {
            for (int j = 0; j < 40; j++) {
                temp += " ";
            }
            temp += tmps[i] + "\n";
        }
        temp += "\n";
        return temp;
    }

    private static void convert2IR() {
        getBlocks();
        getInstructions();
    }

    private static void getBlocks() {
        //    parser.tokens;
        int start_index = 0;

        for (int i = 0; i < realTokens.length; i++) {
            if (realTokens[i].equals(END.toString())) {
                blocks.add(Arrays.copyOfRange(realTokens, start_index, i + 1));
                start_index = i + 1;
            }
        }
    }

    public static String getAssembly() {
        String temp = "";
        for (int i = 0; i < instructions.size(); i++) {
            temp += instructions.get(i).get_assembly() + "\n";
        }
        return temp;
    }

    private static void getInstructions() {

        for (int i = 0; i < blocks.size(); i++) {
            int start_index = 0;
            for (int j = 0; j < blocks.get(i).length; j++) {
                if (blocks.get(i)[j].equals(SEMI_COLON.toString())) {
                    add_instruction(Arrays.copyOfRange(blocks.get(i), start_index, j));
                    start_index = j + 1;
                } else if (blocks.get(i)[j].equals(BEGIN.toString())) {
                    IR_inst.add_begin(Arrays.copyOfRange(blocks.get(i), start_index, j));
                    start_index = j + 1;
                }
            }
        }
        IR_inst.add_end();

    }

    public static void add_instruction(String[] copyOfRange) {

        if (copyOfRange[0].contains("var")) {
            IR_inst.add_assign(copyOfRange);
        } else if (copyOfRange[0].equalsIgnoreCase(RETURN.toString())) {
            IR_inst.add_return(copyOfRange);
        } else if (copyOfRange[0].equalsIgnoreCase(INT.toString()) || copyOfRange[0].equalsIgnoreCase(REAL.toString()) || copyOfRange[0].equalsIgnoreCase(STRING.toString())) {
            IR_inst.add_define(copyOfRange);
        } else if (copyOfRange[0].equalsIgnoreCase(WRITE.toString())) {
            IR_inst.add_write(copyOfRange);
        } else if (copyOfRange[0].equalsIgnoreCase(READ.toString())) {
            IR_inst.add_read(copyOfRange);
        } else if (copyOfRange[0].equalsIgnoreCase(IF.toString())) {
            IR_inst.add_if(copyOfRange);
        } else if (copyOfRange[0].equalsIgnoreCase(ELSE.toString())) {
            IR_inst.add_else(copyOfRange);
        }
    }

    public static String getIR() {
        String temp = "";
        for (int i = 0; i < instructions.size(); i++) {
            temp += instructions.get(i).toString() + "\n";
        }
        return temp;
    }
}
