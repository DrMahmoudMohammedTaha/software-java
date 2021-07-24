/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fib;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Aboahmed
 */
public class Fib {

    public static int series(int intial, int stop, int sum) {
if(intial < stop)
{
    
    sum += intial;
   return series(++intial,stop , sum);
}
    return sum;
  }
   //0 , 1 , 3 , 6 , 10 , 15 , 21 , 28 , 36 ,   

    
    
    public static void main(String[] args) {
    
        JTextArea x = new JTextArea();
        x.setText("work");
        JButton xx = new JButton("click");
        JOptionPane.showInputDialog(null, xx,"title",JOptionPane.INFORMATION_MESSAGE);
    
    
    }

}
