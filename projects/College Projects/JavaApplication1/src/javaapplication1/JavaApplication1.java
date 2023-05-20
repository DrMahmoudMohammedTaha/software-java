package javaapplication1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.Timer;

public class JavaApplication1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Timer clock = new Timer( 5000, null);
    clock.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
    
                System.out.println("3");
            }
        });
   clock.start();
    
   
   while (true)
    {
        try {
    if(s.nextInt()==1)
        clock.stop();
            clock.start();
        } catch (Exception e) {
        }
 
    }
    
    
    
    
    
    }
    
    
    
    
    
}
