/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paint;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

/**
 *
 * @author Aboahmed
 */
public class line extends shape{
     public int firstx, firsty, lastx, lasty;
    
  
    @Override
    public void draw(Graphics g) {
        g.setColor(c);
                   g.drawLine(firstx, firsty, lastx, lasty);
 }

    @Override
    public void increase(MouseEvent me) {
      lastx = (int) me.getPoint().getX();
                lasty = (int) me.getPoint().getY();
          
    }

    @Override
    public void start(MouseEvent me) {
        firstx = (int) me.getPoint().getX();
                firsty = (int) me.getPoint().getY();
           }
}
