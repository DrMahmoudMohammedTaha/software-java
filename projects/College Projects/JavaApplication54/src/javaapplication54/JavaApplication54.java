/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication54;

/**
 *
 * @author DELL
 */
public class JavaApplication54 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        String y = "mahmoudmohammedx";
        for (int i = 0; i < y.length(); i++) {
            System.out.print(Integer.toHexString((int)(y.charAt(i))));
        }
        System.out.println("");
        String x = "mahmoud mohammed mahmoud mohammed Taha";
        for (int i = 0; i < x.length(); i++) {
            System.out.print(Integer.toHexString((int)(x.charAt(i))));
        }
        
        String z = "11111010011000110110101000101000001001011011001100111001110010010100000001100110100010100011000101010111001001000100110100010111";
        String n = "01110100100010011011101100000101011011000100001111000110111001100001101100010010000101100111111011001011111001101001010011101011";
        int c = 0;
        for (int i = 0; i < z.length(); i++) {
            if(z.charAt(i) != n.charAt(i))
                c++;
        }
        System.out.println("\nc "+ c);
        
        
    }
    
}
