

package threadingproject;

import java.util.Random;

public class newStringThread extends Thread {


    @Override
    public void run() {

        while (true) {
            
            synchronized(ThreadingProject.names)
            {
                System.out.println("start synchronized adding -----------------");
                ThreadingProject.names.add(newString());
                System.out.println("end synchronized adding ----------------- size  " + ThreadingProject.names.size());
            
            }
        }
    }

    
    
    public  static String newString ()
    {
    String temp = "";
        for (int i = 0; i < 50; i++) {
            temp += (char) (new Random().nextInt(25) + 65);
        }
    return temp;
    };
    
    
}
