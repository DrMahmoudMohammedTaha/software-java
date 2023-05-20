package gui2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import javax.swing.JPanel;

public class paintpanel extends JPanel {

    static Point[] p = new Point[10000];
    static int counter = 0;

    public paintpanel() {

        this.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent event) {
                if(counter < p.length)
                {
                p[counter++] = event .getPoint();
                repaint();
                
                }
                
                
            }
            
        });

        
        
        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        GeneralPath gp =  new GeneralPath();
        gp .moveTo(0, 0);
        gp.lineTo(20, 40);
        gp.lineTo(80, 40);
        gp.lineTo(10, 120);
        gp.lineTo(100, 100);
        gp.closePath();
        Graphics2D gg = (Graphics2D) g;
        //gg.translate(50, 50);
        //gg.rotate(45);
        gg.setPaint(new GradientPaint(10, 20, Color.red, 100 , 100  , Color.black, false));
       gg.setStroke(new BasicStroke(10.6f));
       gg.fill(gp);
        
      // gg.draw(new Line2D.Double(10,10,50,50));
        for (int i = 0; i < counter; i++) {
        if(i%2==0)
        g.setColor(Color.red);
        else 
            g.setColor(Color.black);
        
            g.fillRect((int) p[i].x, (int) p[i].y, 2, 2);

        }

    }

}
