package manager;

import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;

public abstract class GUI_Ruler {

    static JPopupMenu p = new JPopupMenu();
    static JMenuItem t2 = new JMenuItem("Change foreground");
    static JMenuItem t3 = new JMenuItem("Change background");
    static JMenuItem t4 = new JMenuItem("Paradise Home");
    static JMenuItem tt1 = new JMenuItem("Theme 1");
    static JMenuItem tt2 = new JMenuItem("Theme 2");
    static JMenuItem tt3 = new JMenuItem("Theme 3");

    public static JCheckBox addchk(int x, int y, int l, int h, String name, theme t, JFrame parentFrame) {
        JCheckBox chk = new JCheckBox(name);

        chk.setBounds(x, y, l, h);
        chk.setForeground(t.c2);
        chk.setBackground(t.c1);
        chk.setFont(new Font("Arial", Font.BOLD, 15));
        chk.repaint();
        parentFrame.add(chk, 0);

        return chk;
    }

    public static JButton addBtn(int x, int y, int l, int h, String name, theme t, JFrame parentFrame) {
        JButton btn = new JButton(name);

        btn.setBounds(x, y, l, h);
        btn.setForeground(t.c1);
        btn.setBackground(t.c2);
        btn.setFont(new Font("Bradley Hand ITC", Font.BOLD | Font.ITALIC, 22));
        btn.repaint();
        parentFrame.add(btn, 0);

        return btn;
    }

    public static JLabel addLbl(int x, int y, int l, int h, String name, theme t, JFrame parentFrame) {
        JLabel lbl = new JLabel();
        lbl.setText(name);
        lbl.setBounds(x, y, l, h);
        lbl.setForeground(t.c1);
        lbl.setBackground(t.c2);
        lbl.setFont(new Font("serif", Font.BOLD | Font.ITALIC, 22));
        lbl.repaint();
        parentFrame.add(lbl, 0);

        return lbl;
    }

    public static JTextArea addtxt(int x, int y, int l, int h, String name, theme t, JFrame parentFrame) {
        JTextArea txt = new JTextArea();
        txt.setText(name);
        txt.setBounds(x, y, l, h);
        txt.setForeground(t.c2);
        txt.setBackground(t.c1);
        txt.setFont(new Font("Arial", Font.BOLD, 17));
        txt.repaint();
        parentFrame.add(txt, 0);

        return txt;
    }

    public static JFrame addFrm(JLabel background , boolean visib, boolean resize, int x, int y, int l, int h, String name, theme t, String iconName, boolean exit) {

        JFrame frm = new JFrame(name);
        frm.setBounds(x, y, l, h);
        frm.setLayout(null);
        frm.setBackground(t.c2);
        frm.setResizable(resize);
        if (t.desktop != null) {
            BufferedImage img;
            try {
                img = ImageIO.read(new File(t.desktop));
                background.setIcon(new ImageIcon(img));
                
                background.setBounds(0, 0, l, h);
                frm.add(background, 0);
                //Jpopup menu
                p.add(tt1);
                p.add(tt2);
                p.add(tt3);
                p.add(t2);
                p.add(t3);
                p.add(t4);
                background.setComponentPopupMenu(p);
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

        int sum = 10;
        int mainCmt = cmnt[0].getY();

        for (int i = 0; i < cmnt.length; i++) {

            cmnt[i].setBounds(sum, mainCmt, cmnt[i].getWidth(), cmnt[i].getHeight());
            sum += cmnt[i].getWidth() + 10;
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

    public static void changeBackground(JFrame frm, theme t) {
        if (t.desktop != null) {
            BufferedImage img;
            try {
                img = ImageIO.read(new File(t.desktop));
                JLabel background = new JLabel(new ImageIcon(img));
                background.setBounds(0, 0, frm.getWidth(), frm.getHeight());
                frm.add(background, 0);
                //Jpopup menu
                p.add(tt1);
                p.add(tt2);
                p.add(tt3);
                p.add(t2);
                p.add(t3);
                background.setComponentPopupMenu(p);
            } catch (IOException ex) {

            }
        }

    }

    public static void Changetheme(Component jc, theme t) {
         jc.setForeground(t.c1);
        jc.setBackground(t.c2);
    }

    public static void ChangeReverseTheme(Component jc, theme t) {
        jc.setForeground(t.c2);
        jc.setBackground(t.c1);
    }

    public static void Changetheme(theme t, Component... jc) {
        for (int i = 0; i < jc.length; i++) {
            jc[i].setForeground(t.c1);
            jc[i].setBackground(t.c2);
        }
    }
 public static void Changefore(Color c, Component... jc) {
        for (int i = 0; i < jc.length; i++) {
            jc[i].setForeground(c);
        }
    }

 public static void Changeback(Color c, Component... jc) {
        for (int i = 0; i < jc.length; i++) {
            jc[i].setBackground(c);
        }
    }
    
    public static void ChangeReverseTheme(theme t, Component... jc) {
        for (int i = 0; i < jc.length; i++) {
            jc[i].setForeground(t.c2);
            jc[i].setBackground(t.c1);
        }
    }
}
