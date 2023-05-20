/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orangequiz;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int len = Integer.parseInt(s.split(" ")[0].trim());
        int inner = Integer.parseInt(s.split(" ")[1].trim());

        s = in.nextLine();
        
        int data[] = new int[len];
        for (int i = 0; i < len; i++) {
            data[i] = Integer.parseInt(s.split(" ")[i]);
        }
        s = "";

        for (int i = 0; i <= len - inner; i++) {
            int max = 0 ;
            for (int j = i; j < i + inner -1 ; j++) {
                int temp = Math.max(data[j], data[j + 1]);
                if (temp > max) {
                    max = temp;
                }
            }
            s += max + " ";
        }

        System.out.println(s.trim());
    }

}
