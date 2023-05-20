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
public class second extends first implements Myinterface{
      public  void dummy()
      {
          System.out.println("second dummy");
      
      }

    @Override
    public int show() {
        System.out.println("second show");
   return  0 ;
    }

    @Override
    public void good() {
        System.out.println("good second");
    }

}
