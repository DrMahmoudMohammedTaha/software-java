package os_gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Paint {
     ArrayList<shape> shapes = new ArrayList();

    paintpanel pp = new paintpanel(this);
    JFrame f = GUI_Ruler.addFrm(true, true, 100, 100, 300, 300,
            "Paint", null, "can.jpg", false, false, false);
    JCheckBox chB = new JCheckBox("Filled");
    JButton clear_btn = new JButton("Clear");
    JButton undo_btn = new JButton("Undo");
    JButton choose_btn = new JButton("Choose Color");
    JComboBox shape = new JComboBox();
    JPanel jp = new JPanel();
    Color global_color = Color.BLACK;
  public void createNewPaint() {

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
        jp.setBackground(Color.orange);
        pp.setBackground(Color.white);

        f.setLayout(new GridLayout(2, 1));
        f.add(jp,0);
        f.add(pp,0);
        f.repaint();
      
        clear_btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {

                shapes.clear();
                pp.cleared = true;
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

                if (shapes.isEmpty()) {
                    return;
                }
                shapes.remove(shapes.size() - 1);
                pp.repaint();

            }

        });

    }

  
}
