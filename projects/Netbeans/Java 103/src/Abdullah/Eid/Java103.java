/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Abdullah.Eid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Abo Ahmed
 */
public class Java103 {
   public static void average(String...work)
   {
       float [] x = new float[work.length];
       for (int i = 0 ; i < work.length ; i++) {
           String string = work[i];
           String s [] = string.split("/");
           x[i]= Float.parseFloat(s[0]) /Float.parseFloat(s[1]);
       }
       float sum = 0;
       for (float f : x) {
           sum +=f;
           
       }
       System.out.println(sum/work.length + " for "+ work.length);
   }
    
    public static void work ( )
    {
        
        average(	"4000/4"
	,	"7000/6"
	,	"4000/1.5"
	,	"9300/7.9"
	,	"3000/5"
	,	"3000/1"
	,	"2500/1.3"
	,	"9000/12"
	,	"6000/5"
	,	"7500/9"
,	"1500/1"
,	"2500/2"
,	"4000/4"
	
	);
    
    }
    
    
    
    
    
    public static void main(String[] args) throws IOException {
    
           
    //work();
        System.out.println("man power\r");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(br.readLine());
    }
  



}
