/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os_gui;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JPanel;

public class paintpanel extends JPanel {

   
    public boolean cleared = false;
    Paint xtra ;

    public paintpanel(Paint p) {
    xtra = p;
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent me) {
      
                shape x = null;
                switch (p.shape.getSelectedIndex()) {
                    case 0:
                        x = new Oval();
                        break;
                    case 1:
                        x = new rectangle();
                        break;

                    case 2:
                        x = new line();
                        break;

                    case 3:
                        x = new free();
                        break;

                }

                p.shapes.add(x);

               p.shapes.get(p.shapes.size() - 1).c =  p.global_color;

                p.shapes.get(p.shapes.size() - 1).filled = p.chB.isSelected();
                
                
                
                
                
                
                
                
                p.shapes.get(p.shapes.size() - 1).start(me);

            }

      
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent event) {
                p.shapes.get(p.shapes.size() - 1).increase(event);
                repaint();

            }

        });

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
       // this.setBackground(Color.yellow);
        if (!cleared) {
            for (shape shape : xtra.shapes) {
                shape.draw(g);
            }

        }
        cleared = false;
    }

}
