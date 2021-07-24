package os_gui;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class OS_GUI {
    
    public static void main(String[] args)  {
        
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }
        
        PasswordFrame.display();
        PasswordFrame.correct = true;
        while (true) {
            if (PasswordFrame.correct) {
                break;
            }
        }
        
        desktop.startGUI();
       
   
    }
}
