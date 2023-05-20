/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourgui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 *
 * @author DELL
 */
public class OurGui {

    /**
     * @param args the command line arguments
     */
    public static JFrame frm = new JFrame("my frame");

    public static void main(String[] args) {

        frm.setBounds(200, 200, 100, 300);
        frm.setLayout(null);
        frm.setBackground(Color.BLACK);
        frm.setVisible(true);
        frm.setResizable(false);

         frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
            JButton btn = new JButton("working");
        btn.setBounds(10, 10, 100, 50);
        btn.setForeground(Color.black);
        btn.setBackground(Color.white);
        btn.repaint();
        frm.add(btn, 0);

        btn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
           
            String k  =  JOptionPane.showInputDialog(frm,"enter name");
            }

            @Override
            public void mousePressed(MouseEvent me) {
         
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        });
//        
//        btn.addMouseListener(new MouseListener() {
//
//            @Override
//            public void mouseClicked(MouseEvent me) {
//            String k =    JOptionPane.showInputDialog(frm, "enter you name");
//            }
//
//            @Override
//            public void mousePressed(MouseEvent me) {
//      
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent me) {
//            
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent me) {
//            
//            }
//
//            @Override
//            public void mouseExited(MouseEvent me) {
//            
//            }
//        });
        
        JLabel lbl = new JLabel();
    JTextArea txt = new JTextArea();
  

    }

}
