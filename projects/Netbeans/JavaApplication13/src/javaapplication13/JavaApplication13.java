
package javaapplication13;

import java.util.StringTokenizer;




public class JavaApplication13 {
public static float xtra(float x[])
{

return x[2];
}
    public static String freeTashkeel(String s)
    {
        System.out.println(xtra(new float[]{2, 2 , (float)50/34})); 
        StringBuilder sbuild = new StringBuilder(s);
        
        String x  = " ";
        for (int i = 1570 ; i < 1595; i++) {
            x += ((char)(i)) + "";
        }
        for (int i = 1601; i < 1611; i++) {
            x += ((char)(i)) + "";
            
        }
        for (int i = 0; i < sbuild.length(); i++) {
           
            if(!x.contains(sbuild.charAt(i)+""))
            sbuild.delete(i, i+1);
            
            
        }
    
    return sbuild.toString();
    }
    
    public static void main(String[] args) {
        String s = "وَاسْتَفْزِزْ مَنِ اسْتَطَعْتَ مِنْهُم بِصَوْتِكَ وَأَجْلِبْ ";
        String x = "با" ;
        System.out.println(freeTashkeel(s));
        System.out.println(freeTashkeel(x));
        System.out.println(freeTashkeel(s).contains(freeTashkeel(x)));
    }
    
}
