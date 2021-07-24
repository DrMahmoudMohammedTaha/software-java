/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JPanel;
import static paint.Paint.shape;
import static paint.Paint.chB;

public class paintpanel extends JPanel {

    ArrayList<shape> shapes = new ArrayList();

    static public boolean cleared = false;

    public paintpanel() {

        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent me) {
      
                shape x = null;
                switch (shape.getSelectedIndex()) {
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

                shapes.add(x);

               shapes.get(shapes.size() - 1).c =  Paint.global_color;

                shapes.get(shapes.size() - 1).filled = chB.isSelected();
                
                
                
                
                
                
                
                
                shapes.get(shapes.size() - 1).start(me);

            }

      
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent event) {
                shapes.get(shapes.size() - 1).increase(event);
                repaint();

            }

        });

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
       // this.setBackground(Color.yellow);
        if (!cleared) {
            for (shape shape : shapes) {
                shape.draw(g);
            }

        }
        cleared = false;
    }

}
