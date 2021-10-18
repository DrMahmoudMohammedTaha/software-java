/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emailcv;

/**
 *
 * @author El-Wattaneya
 */
public class EmailCV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
  
    String recipient = "Hiring Manager";
    String position = "Database Developer";
    String company = "BASHAR soft";
    String experience = "Database Development in Ejada Systems";
    
    String mail = "Dear " + recipient + ",\n"
    + "I am writing to express my interest in the " + position + " with " + company + ".\n"
    + "Based on my experience as " + experience + ", I believe that I would be a strong contributor to your team.\n"
    + "In particular, I am interested in joining " + company + " because i can interact and work efficiently in a dynamic environment to transfer skills.\n"
    + "Please see my attached CV for more detail regarding my background and let me know if you have any questions.\n"
    + "Thank you for your consideration, and I look forward to hearing from you regarding potential next steps.\n"
    + "Best regards,\n"
    + "Mahmoud";
    
    
    System.out.println (mail);
   
    }  

}
