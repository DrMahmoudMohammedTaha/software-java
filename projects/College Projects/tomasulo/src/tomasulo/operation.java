/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tomasulo;

import static tomasulo.Tomasulo.registerModel;

/**
 *
 * @author DELL
 */
public class operation {

    String operation;
    int op1, op2;
    int p1 , p2;
    @Override
    public String toString() {
        return operation + " | F" + p1 + " | F" + p2;
    }

    public static int removeRedundancy(int value, String... operation) {
        int changed = -1;
        for (int i = 0; i < 10; i++) {

            String temp = registerModel.getElementAt(i).toString();
            if (temp.contains(operation[0] + "1")) {
                registerModel.setElementAt(temp.replace(operation[0] + "1", "").replace("w:", "") + " " + value, i);
                changed = i; 
                continue;
            }

            for (int j = 0; j < operation.length; j++) {
                if (temp.contains(operation[j])) {
                    int t = Integer.parseInt(temp.substring(temp.indexOf(operation[j])).replace(operation[j], "").trim());
                    registerModel.setElementAt(temp.replace(operation[j] + t , operation[j] +(t - 1) + ""), i);
                    continue;

                }
            }

        }
        return changed;
    }
}
