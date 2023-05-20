package javaapplication7;

import java.text.DecimalFormat;

public  class Main extends supere{

    
    
    public static void main(String[] args) throws Throwable  {
   Main  x = new Main();
   x.x = 10 ;
  x.finalize();
        System.out.println(x.x);
        System.out.println(x);
        System.out.println(new DecimalFormat("0000000").format(1222.32334));
        
    }
        

  }
