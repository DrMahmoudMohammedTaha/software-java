package gui3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Gui3 {

    static JFrame f = new JFrame();

    
    public static void main(String[] args) {
        GridLayout l1 = new GridLayout(2, 2, 6, 6);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        JTextArea jt = new JTextArea("working ",10,20);
        //jt.setLineWrap(true);
        JScrollPane js = new JScrollPane(jt);
        //js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        
        Box b = Box.createHorizontalBox();
        b.setBounds(10, 10, 100, 100);
        b.add(js);
        b.add(new JButton("stop"));
        f.add(b);
        
        b.addMouseListener(new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent evt)
        {
      
        
        };
                
                });
        
jt.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                System.out.println(jt.getSelectedText());
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        });
    
    }

}
