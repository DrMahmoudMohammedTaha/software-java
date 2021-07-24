
package ahmed;

import javax.swing.JOptionPane;

public class Ahmed {
   
    
    
    
    public static void main(String[] args) {

        human mahmoud = new human();
        mahmoud.age = 100;
        
        System.out.println(mahmoud);
        
        
        
        
        
    int k = 0 ;
            int sum = 0 ;
            
            while (k != -1)
            {
            sum = (sum + k)/2;
                k = Integer.parseInt(JOptionPane.showInputDialog( "Enter number"));
           
            
            }
    JOptionPane.showMessageDialog(null,"you average is: \n"+ sum);
    
    }
    
}
