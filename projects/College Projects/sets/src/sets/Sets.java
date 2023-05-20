



package sets;

import java.awt.List;
import java.util.AbstractList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;



public class Sets extends AbstractList{

    
    
    public static void main(String[] args) {
    
    
        Sets  s = new Sets();
    s.add("String");
       s.add("start");
       s.add("work");
        System.out.println(s.toString());
    }

    @Override
    public boolean isEmpty() {
    return get(0).equals(get(1));
    }
    
    @Override
    public Object get(int i) {
       return toArray()[i];
    }

    @Override
    public int size() {
       return toArray().length;
    }
    
}
