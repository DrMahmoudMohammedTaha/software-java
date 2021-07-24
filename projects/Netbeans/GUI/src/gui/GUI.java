package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import static javafx.scene.input.KeyCode.C;
import static javafx.scene.input.KeyCode.J;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicSliderUI;

/**
 *
 * @author Aboahmed
 */
public class GUI {

    static JFrame mainFrm = GUI_Ruler.addFrm(true, true, 400, 300, 500, 360, "ذكرى", null, false);
    static    String [] names = {"white","red","yellow"};
    static Color [] colors = {Color.white , Color.red, Color.yellow }; 
    static JList x = new  JList(names);
    static JList y = new  JList();
static JPanel jp = new JPanel();
    
    public static void main(String[] args) {
    
        
        
        jp.setBackground(Color.yellow);
        mainFrm.add(jp,BorderLayout.NORTH);
    mainFrm.addMouseListener(new mousedrag());
        JButton B1 = new JButton("copy >>>");
 
        
        
        B1.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
      
            y .setListData(x.getSelectedValues());
        
        }
    });
    
    mainFrm.setLayout(new FlowLayout());
    x.setVisibleRowCount(3);
    x.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    mainFrm.add(new JScrollPane(x),0);
    y.setVisibleRowCount(3);
    y.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    mainFrm.add(new JScrollPane(y),0);
    x.addListSelectionListener(new handl());
    
    x.setToolTipText("play games");
    mainFrm.add(B1,0);
    B1.addMouseMotionListener(new MouseMotionListener() {

        @Override
        public void mouseDragged(MouseEvent me) {
    JButton b = ((JButton) me.getSource());
    b.setBounds(me.getX(),me.getY(),b.getWidth(),b.getHeight());
        
        }

        @Override
        public void mouseMoved(MouseEvent me) {
        }
    });
    
   
    
    
    
    }
    
    public static class mousedrag extends MouseAdapter
    {
    
         @Override
   public void mouseClicked(MouseEvent me)
   {
       if(me.isAltDown())    
       mainFrm.setTitle(me.getClickCount()+"");
  
   }
            
    
    
    
    }
    
    
public static class handl  implements ListSelectionListener
{

        @Override
        public void valueChanged(ListSelectionEvent lse) {

        mainFrm.getContentPane().setBackground(colors[x.getSelectedIndex()]);
        System.out.println(x.getSelectedValue());
        }

         
    }
}
