/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Abdullah.Eid;

/**
 *
 * @author Abo Ahmed
 */
 enum Weekdays {
    sunday(3," work",new first(),new Myinterface() {

        @Override
        public int show() {
            System.out.println("enum show");
        return 0 ;
        }

        @Override
        public void good() {
            System.out.println("enum good");
        }
    }),;
 public int val ;
 public String xtra ;
 public first forign;
 public Myinterface my;
 private Weekdays(int v , String x,first f,Myinterface mm)
 {
     this.my = mm;
 this.forign= f;
 this.val = v;
 this.xtra = x;
 
 }
 
 public void shower()
 {
 
     System.out.println("enum show" + this.xtra);
 
 }
         
 }
