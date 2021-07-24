/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication22;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class JavaApplication22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
       
       
       
        String important = JOptionPane.showInputDialog(null, "Enter text!");
        
        String x [] = important.split(" ");
            
         important = JOptionPane.showInputDialog(null, "Enter text!");
        
        String y [] = important.split(" ");
        
        for (int i = 0; i < 100; i++) {
             System.out.println(x[i] + " , " + y[i] );
        }
       
        
            
    }
    
}