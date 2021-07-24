
package graphics.project;

import java.awt.Graphics;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aboahmed
 */
public class drawing extends JPanel{
    
    @Override
    public void  paintComponent(Graphics g)
    {
    
        for (int i = 10; i < getWidth()-50; i += 20) {
            if(2*i < getWidth()-59 && 2*i < getHeight() )
                
            g.drawRect(i, i, i+10, i);
        }
    }
}
