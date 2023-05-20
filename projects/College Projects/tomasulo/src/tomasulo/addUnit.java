/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tomasulo;

import static tomasulo.Tomasulo.addModel;
import static tomasulo.Tomasulo.hint;
import static tomasulo.Tomasulo.registerModel;
import static tomasulo.Tomasulo.struct;

/**
 *
 * @author DELL
 */
public class addUnit {

    static int time = 0;
    static final int max = 3;
    static int busy = 0;
    static operation work[] = new operation[max];
    static final int rule = 4;

    public static void addWork(String s) {
        work[busy] = new operation();
        work[busy].operation = s.split(" ")[0];
        work[busy].op1 = Integer.parseInt(registerModel.getElementAt(Integer.parseInt(s.split(",")[0].substring(s.indexOf(" ")).trim().replace("F", ""))).toString().split(">>")[1].trim());
        work[busy].op2 = Integer.parseInt(registerModel.getElementAt(Integer.parseInt(s.split(",")[1].replace("F", "").trim())).toString().split(">>")[1].trim());
        work[busy].p1 = Integer.parseInt(s.split(",")[0].split(" ")[1].replace("F", "").trim());
        work[busy].p2 = Integer.parseInt(s.split(",")[1].replace("F", "").trim());
        registerModel.setElementAt("F" + work[busy].p1 + " >> w: " + s.split(" ")[0] + (busy + 1), work[busy].p1);
        addModel.addElement(work[busy].toString());
        busy++;
    }

    public static boolean canAdd() {
        if (busy >= max) {
            struct++;
        }

        return busy < max;
    }

    public static void clear() {
        busy = 0;
        work = new operation[max];
    }

    static void execute() {
        if (addModel.isEmpty()) {
            return;
        }

        time++;

        if (time >= rule) {
            time = 0;
            String temp = addModel.getElementAt(0).toString().split(" ")[0];
            addModel.removeElementAt(0);
            int t = operation.removeRedundancy(calculate(temp, work[0].op1, work[0].op2), temp, "ADD", "SUB");
            hint.setText("F" + t + " is on the CDB");
            
            busy--;

            for (int i = 0; i < max - 1; i++) {
                try {
                    work[i].operation = work[i + 1].operation;
                    work[i].op1 = work[i + 1].op1;
                    work[i].op2 = work[i + 1].op2;
                } catch (Exception e) {
                }
            }
        }

    }

    static int calculate(String s, int o1, int o2) {

        if (s.equals("ADD")) {
            return o1 + o2;
        } else {
            return o1 - o2;
        }
    }

}
