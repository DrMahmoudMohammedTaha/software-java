package os_gui;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

/**
 *
 * @author Aboahmed
 */
public class free extends shape {

    static public Point[] p = new Point[10000];
    static public int counter = 0;

    @Override
    public void draw(Graphics g) {
        g.setColor(c);
        for (int i = 0; i < counter; i++) {
            g.fillRect((int) p[i].x, (int) p[i].y, 2, 2);
        }
    }

    @Override
    public void increase(MouseEvent me) {

        p[counter++] = me.getPoint();

    }

    @Override
    public void start(MouseEvent me) {
    }

}
