/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a51;

/**
 *
 * @author DELL
 */
public class A51 {

    public static String x = "", y = "", z = "";
    public static String key = "1111 1001   1110 0110   1100 0000   0000 1111  1111 1001   1110 0110   1100 0000   0000 1111  ";
    public static String message = "";
    public static int major;

    private static String processkey() {
        return key.replaceAll(" ", "");
    }

    private static void init_registers() {
        x = key.substring(0, 19);
        y = key.substring(19, 19 + 22);
        z = key.substring(19 + 22, 19 + 22 + 23);
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }
    /*
     private static String encrypt(String message) {
     init_registers();
     String temp = "";
     for (int i = 0; i < message.length() ; i++) {
         
     }
     return temp;
     }

     private static String decrypt(String temp) {
     String recoved = "";
     for (int i = 0; i < message.length() ; i++) {
         
     }
     return recoved;
     }
     */

    public static int getKeyBit() {
        return Integer.parseInt(x.charAt(x.length() - 1) + "") ^ Integer.parseInt(y.charAt(y.length() - 1) + "") ^ Integer.parseInt(z.charAt(z.length() - 1) + "");
    }

    /* Look at the middle bits of R1,R2,R3, take a vote, and
     * return the majority value of those 3 bits. */
    public static int majority() {
        return Integer.parseInt(x.charAt(8) + "") ^ Integer.parseInt(y.charAt(10) + "") ^ Integer.parseInt(z.charAt(10) + "");
    }

    public static void stepX() {
        if (Integer.parseInt(x.charAt(8) + "") == major) {
            int temp = (Integer.parseInt(x.charAt(13) + "") ^ Integer.parseInt(x.charAt(16) + "") ^ Integer.parseInt(x.charAt(17) + "") ^ Integer.parseInt(x.charAt(18) + ""));
            x = x.substring(0, x.length() - 1);
            x = temp + x;
        }
    }

    public static void stepY() {
        if (Integer.parseInt(y.charAt(10) + "") == major) {
            int temp = (Integer.parseInt(y.charAt(20) + "") ^ Integer.parseInt(y.charAt(21) + ""));
            y = y.substring(0, y.length() - 1);
            y = temp + y;
        }

    }

    public static void stepZ() {
        if (Integer.parseInt(z.charAt(10) + "") == major) {
            int temp = (Integer.parseInt(z.charAt(7) + "") ^ Integer.parseInt(z.charAt(20) + "") ^ Integer.parseInt(z.charAt(21) + "") ^ Integer.parseInt(z.charAt(22) + ""));
            z = z.substring(0, z.length() - 1);
            z = temp + z;
        }

    }

    public static void main(String[] args) {
        key = processkey();
        init_registers();
        for (int i = 0; i < 32; i++) {
            System.out.println("bit " + i + " " + getKeyBit());
            stepper();
        }

    }

    private static void stepper() {
        major = majority();
        stepX();
        stepY();
        stepZ();
    }

}
