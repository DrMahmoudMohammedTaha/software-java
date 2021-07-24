package os_gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import static os_gui.desktop.refreshOtherFrames;

/**
 *
 * @author DELL
 */
public class GUI_Ruler {

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

    public static JButton addBtn(int x, int y, int l, int h, String name, String imgName, JFrame parentFrame) {

        JButton btn;

        if (imgName != null) {
            BufferedImage img;
            try {
                img = ImageIO.read(new File(imgName));
                Image image = img.getScaledInstance(l, h, 0);
                btn = new JButton("", new ImageIcon(image));
            } catch (IOException ex) {
                btn = new JButton();
            }

        } else {
            btn = new JButton(name);
        }

        btn.setBounds(x, y, l, h);
        btn.setForeground(Color.black);
        btn.setBackground(Color.white);
        btn.setFont(new Font("Andalus", Font.BOLD, 18));
        btn.repaint();
        parentFrame.add(btn, 0);

        btn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                new Mp3Player().play("click.mp3");
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

    public static JPasswordField addPass(int x, int y, int l, int h, JFrame parentFrame) {
        JPasswordField pass = new JPasswordField();
        pass.setBounds(x, y, l, h);
        pass.setForeground(Color.black);
        pass.setBackground(Color.white);
        pass.setFont(new Font("Times New Roman", Font.BOLD, 21));
        pass.repaint();
        parentFrame.add(pass, 0);

        return pass;
    }

    public static JTextArea addtxt(int x, int y, int l, int h, String name, JFrame parentFrame) {
        JTextArea txt = new JTextArea();
        txt.setText(name);
        txt.setBounds(x, y, l, h);
        txt.setForeground(Color.black);
        txt.setBackground(Color.white);
        txt.setFont(new Font("Times New Roman", Font.BOLD, 21));
        txt.repaint();
        parentFrame.add(txt, 0);

        return txt;
    }

    public static JFrame addSimpleFrm(String name) {
        JFrame frm = new JFrame(name);
        desktop.OTHER_FRAMES.add(frm);
        Task_Manager.addToRAM(name, new Random().nextInt(4)+1);
        Task_Manager.addToCPU(name);
        frm.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                desktop.OTHER_FRAMES.remove(frm);
            }
        });

        frm.addWindowStateListener(new WindowStateListener() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                if ((e.getNewState() & Frame.ICONIFIED) == Frame.ICONIFIED) {
                    desktop.MINIMIZED_FRAMES.add(frm);
                    desktop.updateList();
                }
            }
        });

        return frm;
    }

    public static JFrame addFrm(boolean visib, boolean resize, int x, int y, int l, int h, String name, String imgName, String iconName, boolean exit, boolean fullscreen, boolean desk) {

        JFrame frm = new JFrame(name);
        if (fullscreen) {
            frm.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frm.setUndecorated(true);
        } else {
            frm.setBounds(x, y, l, h);
        }

        frm.setLayout(null);
        frm.setBackground(Color.BLACK);
        frm.setResizable(resize);

        if (imgName != null) {
            BufferedImage img;
            try {
                img = ImageIO.read(new File(imgName));

                Image image = img.getScaledInstance(l, h, 0);
                JLabel background = new JLabel(new ImageIcon(image));
                background.setBounds(0, 0, l, h);
                frm.add(background, 0);
                if (desk) {
                    desktop.background = background;
                    background.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent evt) {
                          
                            refreshOtherFrames();
                            
                        }
                        
                    });
                }

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
        frm.repaint();

        if (!desk) {
            desktop.OTHER_FRAMES.add(frm);
            Task_Manager.addToRAM(name, new Random().nextInt(4)+1);
            Task_Manager.addToCPU(name);
            frm.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    desktop.OTHER_FRAMES.remove(frm);
                }
            });

            frm.addWindowStateListener(new WindowStateListener() {
                @Override
                public void windowStateChanged(WindowEvent e) {
                    if ((e.getNewState() & Frame.ICONIFIED) == Frame.ICONIFIED) {
                        desktop.MINIMIZED_FRAMES.add(frm);
                        desktop.updateList();
                    }
                }
            });

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
public static void makeFairHorizontal(JComponent... cmnt) {

        int sum = cmnt[0].getX();
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

    public static void makeHorizontal(double x, JComponent... cmnt) {

        int sum = (int) x;
        int mainCmt = cmnt[0].getY();

        for (int i = 0; i < cmnt.length; i++) {

            cmnt[i].setBounds(sum, mainCmt, cmnt[i].getWidth(), cmnt[i].getHeight());
            sum += cmnt[i].getWidth() + 25;
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
