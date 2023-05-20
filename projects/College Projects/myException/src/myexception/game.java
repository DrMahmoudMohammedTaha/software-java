/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package myexception;

/**
 *
 * @author Aboahmed
 */
public class game implements AutoCloseable{
public int p ;
    @Override
    public void close() throws Exception {
        System.out.println(p + "end"); 
    
    
    
    }
    
}
