/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package multithreading;

/**
 *
 * @author Aboahmed
 */
public class First_class implements Runnable{

    public char z ;

    public First_class(char z) {
        this.z = z;
    }
    
  public  void printc() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(z);
        }
}

    @Override
    public void run() {
        printc();
        }

}