/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadingproject;

import java.util.logging.Level;
import java.util.logging.Logger;
import static threadingproject.ThreadingProject.names;

/**
 *
 * @author DELL
 */
public class ShowThread extends Thread{

    int SIZE = 0 ;

   
    @Override
    public void run() {

        while (true) {            
            synchronized(ThreadingProject.names)
            {
            System.out.println("start synchronized showing >>>>>>>>>>>>");
                if (ThreadingProject.names.size() > SIZE) {
                    System.out.println(ThreadingProject.names.get(SIZE));
                    SIZE++;
                }
                System.out.println("end synchronized showing >>>>>>>>>>>> current " + SIZE);
            }
            
        }
    }
}
