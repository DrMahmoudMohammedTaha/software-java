
package stringbuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Stringbuilder {

 public static String freeTashkeel(String s) {

        StringBuilder sbuild = new StringBuilder(s);

        String x = " ";
        for (int i = 1570; i < 1595; i++) {
            x += ((char) (i)) + "";
        }
        for (int i = 1601; i < 1611; i++) {
            x += ((char) (i)) + "";

        }
        for (int i = 0; i < sbuild.length(); i++) {

            if (!x.contains(sbuild.charAt(i) + "")) {
                sbuild.delete(i, i + 1);
            }

        }

        return sbuild.toString();
    }

    
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("saleh.txt"));
        br.readLine(); // this for the  dot in the start of the notepad
        String x ;
        for (int i = 0; i < 660; i++) {
            x = br.readLine();
                if(freeTashkeel(x).contains("زحزح"))
                System.out.println(x);
        }
            
        br.close();
                         
    
    
    
    }
    
}
