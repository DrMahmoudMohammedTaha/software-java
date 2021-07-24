
package graphics.project;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class draw extends JPanel{
    
    @Override
    public void  paintComponent(Graphics g)
    {
       
   
   g.setColor(Color.getHSBColor(338,330,244 ));
  
        for (int i = 0; i < 10; i++) {
            g.drawArc(20*i , 20*i, getWidth()-20*i , getHeight()-20*i , 180 * i, 180);          
        }
   
  
  
    
    }
   
    
}
