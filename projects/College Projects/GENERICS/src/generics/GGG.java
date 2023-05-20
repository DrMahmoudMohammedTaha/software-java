


package generics;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;




public class GGG  implements Comparator<GGG>{
 
    String x ;

    public GGG(String x) {
        this.x = x;
    }

    @Override
    public int compare(GGG t, GGG t1) {
    int sum1 = 0 , sum2 = 0 ;
        for (int i = 0; i < t.x.length(); i++) {
            sum1 += Integer.parseInt(t.x.charAt(i)+"");
         }
        for (int i = 0; i < t1.x.length(); i++) {
            sum2 += Integer.parseInt(t1.x.charAt(i)+"");
        }
        
        return  sum1 - sum2;
    }

    @Override
    public String toString() {
    return  x;
    }

  
    
    
    
}
