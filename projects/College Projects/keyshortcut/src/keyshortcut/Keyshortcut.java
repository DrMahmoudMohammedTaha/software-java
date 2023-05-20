
package keyshortcut;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class Keyshortcut {


    public static void main(String[] args) {
    
        
        System.out.println(new Color (255,255,25));
        System.out.println(Color.BLUE.getBlue());
        System.out.println(Color.BLUE.getRed());
        System.out.println(Color.BLUE.getGreen());
    JFrame x = new JFrame();
    x.setVisible(true);
  x.setLayout(new GridLayout(2, 2));
  x.add(new JButton());
    ActionListener a=new ActionListener(){
   
        @Override
        public void actionPerformed(ActionEvent ae) {
            JOptionPane.showMessageDialog(null,"Done...");
        
        
        }
    };
    
    
        x.addKeyListener(new KeyAdapter() {
@Override
public void keyReleased (KeyEvent ke)
{

    System.out.println(ke.getKeyCode());

}
        
        });
        

    x. getRootPane().registerKeyboardAction(a,KeyStroke.getKeyStroke("ctrl S"),0);
  
    
    
    }
    
}
