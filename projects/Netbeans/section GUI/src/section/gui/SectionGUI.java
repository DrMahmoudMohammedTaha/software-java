/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package section.gui;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Aboahmed
 */
public class SectionGUI extends JFrame implements ActionListener{

    JLabel l1;
    JTextField fd;
    JTextField fd1;
    JTextField fd2;
    JButton b1 , b2;
    int count = 0 ; 
    public SectionGUI() {

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    //new JFrame().addWindowStateListener(this);
    
        setLayout(new FlowLayout());
        
        
        l1 = new JLabel("number");
        fd = new JTextField(  10);
        fd1 = new JTextField(  10);
        fd2 = new JTextField( 10);
        b1 = new JButton("add");
        b2 = new JButton("subtract");
        add(l1,0);
        add(fd,0);
        add(fd1,0);
        add(fd2,0);
        
        add(b1,0);
        add(b2,0);
        b1.addActionListener(this);
        b2.addActionListener(this);
        setSize(200, 200);
        setVisible(true);
    
        
    }

    public static void main(String[] args) {
        
        SectionGUI fr = new SectionGUI();
        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
     
        if (((JButton)(ae.getSource())).equals(b1)) {
    
            fd.setText((Integer.parseInt(fd1.getText()) + Integer.parseInt(fd2.getText())) + "");     
        }
        else{
        fd.setText((Integer.parseInt(fd1.getText()) - Integer.parseInt(fd2.getText())) + "");     
        }
       
    }

}
