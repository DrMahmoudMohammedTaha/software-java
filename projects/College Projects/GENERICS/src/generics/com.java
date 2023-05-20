/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package generics;

import java.util.Comparator;

/**
 *
 * @author Aboahmed
 */
public class com implements Comparator<String>{
        @Override
    public int compare(String t, String t1) {
    int sum1 = 0 , sum2 = 0 ;
        for (int i = 0; i < t.length(); i++) {
            sum1 += Integer.parseInt(t.charAt(i)+"");
         }
        for (int i = 0; i < t1.length(); i++) {
            sum2 += Integer.parseInt(t1.charAt(i)+"");
        }
        
        return  sum1 - sum2;
    }


}
