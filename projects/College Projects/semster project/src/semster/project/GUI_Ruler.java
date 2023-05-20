package semster.project;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class GUI_Ruler {

    public static JRadioButton addradio(int x, int y, int l, int h, String name, JFrame parentFrame) {
        JRadioButton radio = new JRadioButton(name);

        radio.setBounds(x, y, l, h);
        radio.setForeground(Color.BLACK);
        radio.setBackground(Color.orange);
        radio.setFont(new Font("Andalus", Font.BOLD, 18));
        radio.repaint();
        parentFrame.add(radio, 0);

        return radio;
    }

    public static JButton addBtn(int x, int y, int l, int h, String name, JFrame parentFrame) {
        JButton btn = new JButton(name);

        btn.setBounds(x, y, l, h);
        btn.setForeground(Color.black);
        btn.setBackground(Color.white);
        btn.setFont(new Font("Andalus", Font.BOLD, 14));
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

    public static void AddHolderText(JFrame frm, JTextArea... textA) {

        for (int i = 0; i < textA.length; i++) {
            textA[i].setLineWrap(true);
            JScrollPane holderText = new JScrollPane(textA[i]);
            holderText.setBounds(textA[i].getBounds());
            frm.add(holderText, 0);

        }

    }

    public static JTextArea addtxt(int x, int y, int l, int h, String name, JFrame parentFrame) {
        JTextArea txt = new JTextArea();
        txt.setText(name);
        txt.setBounds(x, y, l, h);
        txt.setForeground(Color.black);
        txt.setBackground(Color.white);
        txt.setFont(new Font("Arial", Font.BOLD, 14));
        txt.repaint();
        parentFrame.add(txt, 0);

        return txt;
    }

    public static void fillPanel(JPanel jp, JComponent... jcomnt) {
        for (int i = 0; i < jcomnt.length; i++) {
            jp.add(jcomnt[i]);
        }

    }

    public static JPanel addpanel(int x, int y, int l, int h, String name, JFrame parentFrame) {
        JPanel panel = new JPanel();
        panel.setName(name);
        panel.setBounds(x, y, l, h);
        panel.setForeground(Color.black);
        panel.setBackground(Color.white);
        panel.setFont(new Font("Times New Roman", Font.BOLD, 21));
        panel.setLayout(null);
        panel.setBackground(Color.cyan);

        panel.repaint();
        parentFrame.add(panel, 0);

        return panel;
    }

    public static JPasswordField addpass(int x, int y, int l, int h, String name, JFrame parentFrame) {
        JPasswordField pass = new JPasswordField();
        pass.setText(name);
        pass.setBounds(x, y, l, h);
        pass.setForeground(Color.black);
        pass.setBackground(Color.white);
        pass.setFont(new Font("Times New Roman", Font.BOLD, 21));
        pass.repaint();
        parentFrame.add(pass, 0);

        return pass;
    }

    public static JFrame addFrm(boolean visib, boolean resize, int x, int y, int l, int h, String name, String imgName, String iconName, boolean exit) {

        JFrame frm = new JFrame(name);  // create new frame
        frm.setBounds(x, y, l, h); // set x y and width and height
        frm.setLayout(null);      // no loayout
        frm.setBackground(Color.BLACK);  // background color
        frm.setResizable(resize); // set if the window is resizeable
        if (imgName != null) {
            BufferedImage img;
            try {
                img = ImageIO.read(new File(imgName)); // read the image with the name
                JLabel background = new JLabel(new ImageIcon(img)); // create new label
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
            frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // close application when close window
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

    public static void makeHorizontal(int x, JComponent... cmnt) {

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

    public static void makeCenter(JComponent cmnt, JFrame frm) {
        cmnt.setBounds((frm.getWidth() - cmnt.getWidth()) / 2, cmnt.getY(), cmnt.getWidth(), cmnt.getHeight());
    }

    public static JComboBox addcomo(int x, int y, int l, int h, JFrame parentFrame) {
        JComboBox como = new JComboBox();
        como.setBounds(x, y, l, h);
        como.setForeground(Color.black);
        como.setBackground(Color.white);
        como.setFont(new Font("Times New Roman", Font.BOLD, 21));
        como.repaint();
        parentFrame.add(como, 0);

        return como;
    }

    public static JTable addtable(int x, int y, int l, int h, JFrame parentFrame, String ss[][] , String s[]) {
        JTable table;
        if (ss == null || s == null) {
            table = new JTable();    
        }
        else  {
            table = new JTable(ss, s);
        }

        table.setEnabled(false);
        table.setBounds(x, y, l, h);
        table.setForeground(Color.black);
        table.setBackground(Color.white);
        table.setFont(new Font("Times New Roman", Font.BOLD, 21));
        table.repaint();

        parentFrame.add(table, 0);
        return table;
    }

}
