package gui2;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI2 extends JPanel {

    static JFrame f = new JFrame();
    static paintpanel jp = new paintpanel();
    
    public static void main(String[] args) {
      //  System.out.println("1994-12-22".split("-")[0]);
//NewJFrame ff = new NewJFrame();
//ff.setVisible(true);
        f.setBounds(200, 200, 200, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        jp.setBackground(Color.yellow);
        //f.add(new NewJPanel());
        f.add(jp, BorderLayout.CENTER);
        f.setSize(300,400);
        f.setVisible(true);
           
        
    }

   

}
