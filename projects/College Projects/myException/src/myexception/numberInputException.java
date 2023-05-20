

package myexception;

import java.io.IOException;
import java.util.InputMismatchException;


public class numberInputException extends InputMismatchException{

    public  static String numberInputException(String s) {
      
        String orignal = "";
        for (int i = 0; i < s.length(); i++) {
            
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9' )
            orignal += s.charAt(i);
            
            
            
        }
        System.out.println(orignal);
        return orignal;
    }
    
    
    
    
    
    
    
    
        
    
}
