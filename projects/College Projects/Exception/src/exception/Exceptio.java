package exception;

import java.io.IOException;

public class Exceptio {

    
    public static void main(String[] args) {
        try {
             m3();
   
        } catch (IOException e) {
            System.out.println(e.getMessage());
            
        
        }
        
    
    
    }
    public static void m3() throws IOException {
        m2();
    }

    public static void m2() throws IOException {
        m1();
    }

    public static void m1() throws IOException{
          throw new IOException("work");
       
    
    }
    
        
    }


