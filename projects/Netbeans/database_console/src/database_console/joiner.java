/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database_console;

/**
 *
 * @author DELL
 */
public class joiner {

    condition cond ;
    String joinTable ;

    public joiner(condition cond, String joinTable) {
        this.cond = cond;
        this.joinTable = joinTable;
    }
    
    
    
    @Override
    public String toString() { 
        return " join " + joinTable + " on ( " + cond.toString()  + " ) " ;
    }
   
    
    
}
