/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package format;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Format {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 String x = new Scanner(System.in).nextLine().replaceAll("-"," \" ");
          System.out.println(x.length());
          
          
    }
    
}
