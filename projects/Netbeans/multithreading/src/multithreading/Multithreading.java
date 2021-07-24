package multithreading;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Multithreading {

    char z ;
boolean state = true;
    public Multithreading(char z) {
        this.z = z;
    }
    
    
    public static void main(String[] args) throws InterruptedException {

        
        
    new Thread(new First_class('r'), "wokring");
   
    }

  public  void printc() {
      
      try {
            wait();
        } catch (InterruptedException ex) {
         
        }
      for (int i = 0; i < 10000; i++) {
            System.out.println(z);
        }

        notify();
  }


}
    

    