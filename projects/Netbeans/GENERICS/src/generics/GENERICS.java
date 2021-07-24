


package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;



public class GENERICS {

    public static void maintain(Collection <Integer >  s) {
      
        
        Iterator it  =  s.iterator();
        
        while (it.hasNext())
            System.out.println(it.next());
    }
    
    
    public static void main(String[] args) {
    
    List <GGG > x = new ArrayList();
   
    x.add(new GGG("18"));
    x.add(new GGG("100"));
    x.add(new GGG("101"));
    x.add(new GGG("1022"));
    x.add(new GGG("103"));

Collections.sort(x, new GGG("10"));

    // sort in descending order using a comparator
    //Collections.sort( x, Collections.reverseOrder() );

        System.out.println(x.toString());
    
       // maintain(new LinkedList<String>());
        
    
    }
    
}
