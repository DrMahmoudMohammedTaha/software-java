package os_gui;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import static os_gui.desktop.imgHight;
import static os_gui.desktop.imgWidth;

public class PasswordFrame {

    public static boolean correct = false;
    public static String passWord = "mm";
    static private JFrame passFrame = GUI_Ruler.addFrm(false, false, imgWidth / 3 + 100, imgHight / 3 + 50, imgWidth , imgHight ,
            "Password", dataSystem.systemBackground, "password.png", true, true, false);

    static private JButton enter = GUI_Ruler.addBtn(620, 100, 150, 30, "Enter", null, passFrame);
    static private JButton exit = GUI_Ruler.addBtn(620, 100, 150, 30, "Exit", null, passFrame);
    static private JLabel passward_L = GUI_Ruler.addLbl(600, 400, 150, 30, "Password: ", passFrame);
    static private JPasswordField pass = GUI_Ruler.addPass(10, 10, 150, 30, passFrame);
    public static void lockPassFrame()
    {
    passFrame.setVisible(false);
    }

    public static void display() {
        passward_L.setFont(new Font("Jokerman", Font.BOLD, 25));
        exit.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                int k = JOptionPane.showConfirmDialog(null, "Ary really want to Exit");
                if(k == 0)
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }

        });
        enter.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
               if(pass.getText().equals(passWord))
               {    
                       correct = true;
                       
                   
                       
               }
               else
               {
               JOptionPane.showMessageDialog(null, "Wrong password!");
               }
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }

        });

        GUI_Ruler.makeHorizontal(600.0,passward_L , pass);
        GUI_Ruler.makeVertical(passward_L , enter,exit);
        
        passFrame.setVisible(true);
    }
              
        
    
    
    

}
