
package graphics.project;

import java.awt.Color;
import javax.swing.JFrame;

public class GraphicsProject {
    
    
    
    public static void main(String[] args) {

        
        JFrame x = new JFrame ("rainbow");
        x.setBounds(100, 100, 300, 300);
        x.setVisible(true);
        //x.setBackground(Color.white);
        x.add(new draw());
    }
    
}
