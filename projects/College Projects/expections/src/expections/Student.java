
package expections;

import javax.swing.JOptionPane;

public  class Student  extends myExpClass{

    public static void main(String[] args) {

        int length = 0 ;
        try {
         length  = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number of students"));     
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
        }
        int students [] = new int [length];
        for (int i = 0; i < students.length; i++) {
            
        try {
         students[i]  = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter precentage of student no.: "+ (i+1) ));     
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
        }
        
        }
        JOptionPane.showMessageDialog(null, "The average value: \n" + new Student().calPercentage(students));
        
    }
    
    @Override
public int  calPercentage(int x[])
{
    int sum = 0 ;
    for (int i = 0; i < x.length; i++) {
        sum += x[i] ;
    }
    
    return (sum / x.length) ;
}


}
