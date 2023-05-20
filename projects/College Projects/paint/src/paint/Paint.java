package paint;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Paint {

    static paintpanel pp = new paintpanel();
    static JFrame f = new JFrame("paint");
    static JCheckBox chB = new JCheckBox("Filled");
    static JButton clear_btn = new JButton("Clear");
    static JButton undo_btn = new JButton("Undo");
    static JButton choose_btn = new JButton("Choose Color");
    static JComboBox shape = new JComboBox();
    static JPanel jp = new JPanel();
    static Color global_color = Color.BLACK;

    public static void main(String[] args) {

        undo_btn.setFont(new Font("Monospaced", Font.BOLD, 10));

        shape.addItem("Circle");
        shape.addItem("Rect");
        shape.addItem("LIne");
        shape.addItem("free");

        jp.setLayout(new FlowLayout());
        jp.add(undo_btn);
        jp.add(clear_btn);
        jp.add(shape);
        jp.add(choose_btn);
        jp.add(chB);
        
        pp.setBackground(Color.white);
        f.setBounds(100, 100, 300, 300);
        f.setVisible(true);
        f.setLayout(new GridLayout(2, 1));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(jp);
        f.add(pp);

        clear_btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {

                pp.shapes.clear();
                paintpanel.cleared = true;
                pp.repaint();

            }

        });
        choose_btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {

                Color c = new Color(100);
                c = JColorChooser.showDialog(undo_btn, "choosing", c);
                if (c != null) {
                    global_color = c;
                }

            }

        });
        undo_btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {

                if (pp.shapes.isEmpty()) {
                    return;
                }
                pp.shapes.remove(pp.shapes.size() - 1);
                pp.repaint();

            }

        });

    }

}
