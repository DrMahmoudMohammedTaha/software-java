package calculator;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Calculator extends JFrame implements ActionListener {

    boolean state = true;
    JTextField n1;
    JTextField n2;
    JTextField result;
    JLabel n1_L;
    JLabel n2_L;
    JLabel result_L;
    JButton add, sub, mul, div, mod;

    public Calculator() throws HeadlessException {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //new JFrame().addWindowStateListener(this);
        setLayout(new GridLayout(9, 2, 5, 5));

        result_L = new JLabel("result");
        n2_L = new JLabel("Y");
        n1_L = new JLabel("x");
        result = new JTextField(10);
        n2 = new JTextField(10);
        n1 = new JTextField(10);
        result.setEditable(false);
        add = new JButton("add");
        sub = new JButton("subtract");
        mul = new JButton("multiply");
        div = new JButton("divide");
        mod = new JButton("modulus");

        add(add, 0);
        add(sub, 0);
        add(mul, 0);
        add(div, 0);
        add(mod, 0);

        add(n1, 0);
        add(n2, 0);
        add(result, 0);

        add(n1_L, 0);
        add(n2_L, 0);
        add(result_L, 0);

        add(new JLabel());
        n1.addMouseListener(new MouseAdapter() {
        
        @Override
        public void mousePressed (MouseEvent evt)
        {
        state = true;
        }
        });
        n2.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed (MouseEvent evt)
        {
        state = false;
        }
        });
        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        mod.addActionListener(this);

        for (int i = 9; i > -1; i--) {
            JButton b = new JButton(i + "");
            b.addActionListener(this);

            if (i == 0) {
                add(new JLabel());
            }
            add(b);
        }

        setSize(300, 600);
        setVisible(true);

    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if ((ae.getSource()).equals(add)) {
            try {
                result.setText(Double.parseDouble(n1.getText()) + Double.parseDouble(n2.getText()) + "");
            } catch (Exception e) {
            }
        } else if ((ae.getSource()).equals(sub)) {

            try {
                result.setText(Double.parseDouble(n1.getText()) - Double.parseDouble(n2.getText()) + "");
            } catch (Exception e) {
            }
        } else if ((ae.getSource()).equals(mul)) {

            try {
                result.setText(Double.parseDouble(n1.getText()) * Double.parseDouble(n2.getText()) + "");
            } catch (Exception e) {
            }
        } else if ((ae.getSource()).equals(div)) {
            try {
                result.setText( new DecimalFormat("000.000").format(Double.parseDouble(n1.getText()) / Double.parseDouble(n2.getText())) + "");
            } catch (Exception e) {
            }

        } else if ((ae.getSource()).equals(mod)) {
            try {
                result.setText(Double.parseDouble(n1.getText()) % Double.parseDouble(n2.getText()) + "");
            } catch (Exception e) {
            }
        } else {
            if (state) {
                n1.setText(n1.getText() + ((JButton) ae.getSource()).getText());
            } else {
                n2.setText(n2.getText() + ((JButton) ae.getSource()).getText());
            }
        }

    }

}

