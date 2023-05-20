/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package filing;

import java.io.Serializable;

/**
 *
 * @author Aboahmed
 */
public class gui implements Comparable<gui>{
 
    int x ;

    public gui(int x) {
        this.x = x;
    }

    @Override
    public int compareTo(gui t) {
   if(this.x > t.x)
       return 1; 
   else if (this.x == t.x )
       return  0 ; 
   else 
       return  -1 ;
       
    }

    @Override
    public String toString() {
        return  "x "+ x;
    }
    
    
}
