
package filestree;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class GUI_Ruler2 {

    public static JCheckBox addchk(int x, int y, int l, int h, String name, JFrame parentFrame) {
        JCheckBox chk = new JCheckBox(name);

        chk.setBounds(x, y, l, h);
        chk.setForeground(Color.BLACK);
        chk.setBackground(Color.orange);
        chk.setFont(new Font("Andalus", Font.BOLD, 18));
        chk.repaint();
        parentFrame.add(chk, 0);

        return chk;
    }

    public static JButton addBtn(int x, int y, int l, int h, String name, JFrame parentFrame) {
        JButton btn = new JButton(name);

        btn.setBounds(x, y, l, h);
        btn.setForeground(Color.black);
        btn.setBackground(Color.white);
        btn.setFont(new Font("Andalus", Font.BOLD, 18));
        btn.repaint();
        parentFrame.add(btn, 0);

        return btn;
    }

    public static JLabel addLbl(int x, int y, int l, int h, String name, JFrame parentFrame) {
        JLabel lbl = new JLabel();
        lbl.setText(name);
        lbl.setBounds(x, y, l, h);
        lbl.setForeground(Color.BLACK);
        lbl.setFont(new Font("Andalus", Font.BOLD, 26));
        lbl.repaint();
        parentFrame.add(lbl, 0);

        return lbl;
    }

    public static JTextArea addtxt(int x, int y, int l, int h, String name, JFrame parentFrame) {
        JTextArea txt = new JTextArea();
        txt.setText(name);
        txt.setBounds(x, y, l, h);
        txt.setForeground(Color.black);
        txt.setBackground(Color.white);
        txt.setFont(new Font("Times New Roman", Font.BOLD  , 30));
        txt.repaint();
        parentFrame.add(txt, 0);
        
        
        return txt;
    }

    public static JFrame addFrm(boolean visib, boolean resize, int x, int y, int l, int h, String name, String imgName,String iconName, boolean exit) {

        JFrame frm = new JFrame(name);
        frm.setBounds(x, y, l, h);
        frm.setLayout(null);
        frm.setBackground(Color.BLACK);
        frm.setResizable(resize);
        if (imgName != null) {
            BufferedImage img;
            try {
                img = ImageIO.read(new File(imgName));
                JLabel background = new JLabel(new ImageIcon(img));
                background.setBounds(0, 0, l, h);
                frm.add(background, 0);
            } catch (IOException ex) {
            }

        }
         if (iconName != null) {
            BufferedImage img;
            try {
                img = ImageIO.read(new File(iconName));
                frm.setIconImage(img);
            } catch (IOException ex) {
            }

        }
        frm.setVisible(visib);
        if (exit) {
            frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        return frm;

    }

    // make all elements in one horizontal line
    public static void makeHorizontal(JComponent... cmnt) {

        int sum = 15;
        int mainCmt = cmnt[0].getY();

        for (int i = 0; i < cmnt.length; i++) {

            cmnt[i].setBounds(sum, mainCmt, cmnt[i].getWidth(), cmnt[i].getHeight());
            sum += cmnt[i].getWidth() + 10;
        }

    }

    
    public static void makeHorizontal(int x  , JComponent... cmnt) {

        int sum = 15;
        int mainCmt = cmnt[0].getY();

        for (int i = 0; i < cmnt.length; i++) {

            cmnt[i].setBounds(sum, mainCmt, cmnt[i].getWidth(), cmnt[i].getHeight());
            sum += cmnt[i].getWidth() + x;
        }

    }

    // make all elements hava the same vertical spaces
    public static void makeVertical(JComponent... cmnt) {
        int sum = cmnt[0].getY();

        for (int i = 0; i < cmnt.length; i++) {

            cmnt[i].setBounds(cmnt[i].getX(), sum, cmnt[i].getWidth(), cmnt[i].getHeight());
            sum += cmnt[i].getHeight() + 10;
        }

    }

    //check that set all checkboxes false except the first one 
    public static void oneChecked(JCheckBox... chks) {
        chks[0].setSelected(true);
        for (int i = 1; i < chks.length; i++) {
            chks[i].setSelected(false);
        }

    }

    public static void makeCenter(JComponent cmnt, JFrame frm) {
        cmnt.setBounds((frm.getWidth() - cmnt.getWidth()) / 2, cmnt.getY(), cmnt.getWidth(), cmnt.getHeight());
    }

}
