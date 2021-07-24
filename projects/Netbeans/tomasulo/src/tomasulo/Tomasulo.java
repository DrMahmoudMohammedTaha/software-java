package tomasulo;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Tomasulo {

    static JFrame addFrm = GUI_Ruler_tomasolu.addFrm(false, false, 300, 30, 400, 400, "add code", "addb.jpg", "ico.png", false);
    static JButton ok = GUI_Ruler_tomasolu.addBtn(20, 310, 80, 40, "OK", addFrm);
    static JTextArea code = GUI_Ruler_tomasolu.addtxt(20, 20, 300, 280, "", addFrm);

    static JFrame mainFrm = GUI_Ruler_tomasolu.addFrm(true, false, 300, 30, 730, 680, "Tomasolu Simulator", "back.png", "ico.png", true);

    static JList instructions = new JList();
    static JScrollPane II = new JScrollPane(instructions);
    static DefaultListModel instrModel = new DefaultListModel();

    static JList registers = new JList();
    static JScrollPane rr = new JScrollPane(registers);
    static DefaultListModel registerModel = new DefaultListModel();

    static JList loads = new JList();
    static JScrollPane LL = new JScrollPane(loads);
    static DefaultListModel loadModel = new DefaultListModel();

    static JList stores = new JList();
    static JScrollPane ss = new JScrollPane(stores);
    static DefaultListModel storeModel = new DefaultListModel();

    static JList addresses = new JList();
    static JScrollPane aa = new JScrollPane(addresses);
    static DefaultListModel addressModel = new DefaultListModel();

    static JList adds = new JList();
    static JScrollPane dd = new JScrollPane(adds);
    static DefaultListModel addModel = new DefaultListModel();

    static JList muls = new JList();
    static JScrollPane mm = new JScrollPane(muls);
    static DefaultListModel mulModel = new DefaultListModel();

    static JButton addCode = GUI_Ruler_tomasolu.addBtn(15, 10, 150, 40, "add code", mainFrm);
    static JButton step = GUI_Ruler_tomasolu.addBtn(15, 10, 100, 40, "Step", mainFrm);
    static JButton run = GUI_Ruler_tomasolu.addBtn(15, 10, 100, 40, "Run", mainFrm);
    static JButton stop = GUI_Ruler_tomasolu.addBtn(15, 10, 100, 40, "Stop", mainFrm);
    static JButton stat = GUI_Ruler_tomasolu.addBtn(15, 10, 100, 40, "Static", mainFrm);
    static JButton exit = GUI_Ruler_tomasolu.addBtn(15, 10, 100, 40, "Exit", mainFrm);
    static JLabel timer = GUI_Ruler_tomasolu.addLbl(20, 20, 85, 20, "", mainFrm);
    static JTextArea hint = GUI_Ruler_tomasolu.addtxt(20, 20, 150, 100, "", mainFrm);
    static JScrollPane adjustholderText = new JScrollPane(hint);

    static String assembly[];
    static int index = 0;
    static int time = 1;
    static Timer runner = new Timer(0, null);
    static int struct = 0;
    static int hazard = 0;

    public static void main(String[] args) {

        //  UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("WinSoft Thuluth", Font.BOLD, 15)));
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }

        initialize_lists();
        hint.setLineWrap(true);
        adjustholderText.setBounds(20, 90, 180, 60);
        mainFrm.add(adjustholderText, 0);
        hint.setEditable(false);

        mainFrm.repaint(0);
        mainFrm.repaint();

        GUI_Ruler_tomasolu.makeHorizontal(addCode, step, run, stop, stat, exit);
        GUI_Ruler_tomasolu.makeVertical(addCode, timer);

        JOptionPane.showMessageDialog(null, "This is a simplified Tomasulo version\n"
                + "it supports the following instructions:\n"
                + "LD , SD , ADD , SUB , MUL and DIV \n"
                + "we have floating point registers F0 - F10\n"
                + "we have integer regiesters R0 - R5\n"
                + "load/store >> 10 , mul >> 8 , add >> 2");

        exit.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {

                JOptionPane.showMessageDialog(null, "Peace be upon you!");
                System.exit(0);

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
        addCode.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {

                code.setText("");
                addFrm.setVisible(true);

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
        ok.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {

                flush();
                assembly = code.getText().split("\n");
                for (int i = 0; i < assembly.length; i++) {
                    if (!validate(assembly[i])) {
                        flush();
                        return;
                    }
                    assembly[i] = assembly[i].trim();
                    instrModel.addElement(assembly[i]);

                }
                addFrm.setVisible(false);
                instructions.setSelectedIndex(0);
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
        step.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                step();
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
        run.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {

                runner.stop();
                runner = new Timer(1000, null);
                runner.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        step();
                    }
                });
                runner.start();

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
        stop.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {

                runner.stop();
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
        stat.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {

                JOptionPane.showMessageDialog(null, "Execution time: " + time + "\n"
                        + "Structural hazard time: " + struct + " \n"
                        + "Data hazard time: " + hazard);

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

    }

    public static void step() {

        execute();
        issue_new();
        timer.setText("clock: " + (time++));

    }

    private static void initialize_lists() {

        instructions.setForeground(Color.black);
        instructions.setBackground(Color.white);
        instructions.setFont(new Font("Georgia", Font.PLAIN, 15));
        instructions.repaint();
        II.setBounds(310, 125, 150, 150);
        mainFrm.add(II, 0);
        instructions.setModel(instrModel);

        registers.setForeground(Color.black);
        registers.setBackground(Color.white);
        registers.setFont(new Font("Georgia", Font.PLAIN, 15));
        registers.repaint();
        rr.setBounds(495, 185, 190, 80);
        mainFrm.add(rr, 0);
        registers.setModel(registerModel);

        for (int i = 0; i < 10; i++) {
            registerModel.addElement("F" + i + " >> 0");
        }

        loads.setForeground(Color.black);
        loads.setBackground(Color.white);
        loads.setFont(new Font("Georgia", Font.PLAIN, 11));
        loads.repaint();
        LL.setBounds(153, 375, 60, 110);
        mainFrm.add(LL, 0);
        loads.setModel(loadModel);

        stores.setForeground(Color.black);
        stores.setBackground(Color.white);
        stores.setFont(new Font("Georgia", Font.PLAIN, 11));
        stores.repaint();
        ss.setBounds(50, 375, 50, 110);
        mainFrm.add(ss, 0);
        stores.setModel(storeModel);

        addresses.setForeground(Color.black);
        addresses.setBackground(Color.white);
        addresses.setFont(new Font("Georgia", Font.PLAIN, 11));
        addresses.repaint();
        aa.setBounds(99, 375, 50, 110);
        mainFrm.add(aa, 0);
        addresses.setModel(addressModel);

        adds.setForeground(Color.black);
        adds.setBackground(Color.white);
        adds.setFont(new Font("Georgia", Font.PLAIN, 11));
        adds.repaint();
        dd.setBounds(230, 473, 140, 52);
        mainFrm.add(dd, 0);
        adds.setModel(addModel);

        muls.setForeground(Color.black);
        muls.setBackground(Color.white);
        muls.setFont(new Font("Georgia", Font.PLAIN, 11));
        muls.repaint();
        mm.setBounds(462, 475, 140, 40);
        mainFrm.add(mm, 0);
        muls.setModel(mulModel);

    }

    private static boolean validate(String string) {
        string = string.trim();
        if (!(string.contains(" ") && string.contains(","))) {
            JOptionPane.showMessageDialog(null, "There is an erorr in your code!");
            return false;
        }
        String operator = string.substring(0, string.indexOf(" ")).trim();
        string = string.replace(operator, "");
        String f1 = string.split(",")[0].trim();
        String f2 = string.split(",")[1].trim();

        if (operator.equals("LD") || operator.equals("SD") || operator.equals("ADD") || operator.equals("SUB") || operator.equals("MUL") || operator.equals("DIV")) {
            if (f1.contains("F") && Integer.parseInt(f1.replace("F", "")) >= 0 && Integer.parseInt(f1.replace("F", "")) < 10) {
                if ((operator.equals("LD") || operator.equals("SD")) && f2.contains("R")) {

                    int num = Integer.parseInt(f2.substring(f2.indexOf("R") + 1, f2.length() - 1));
                    if (num >= 0 && num <= 5) {
                        return true;
                    }

                } else {
                    if (f2.contains("F") && Integer.parseInt(f2.replace("F", "")) >= 0 && Integer.parseInt(f2.replace("F", "")) < 10) {
                        return true;
                    }

                }

            }
        }
        JOptionPane.showMessageDialog(null, "There is an erorr in your code!");
        return false;
    }

    private static void flush() {
        time = 1;
        index = struct = hazard = 0;
        runner.stop();
        assembly = new String[0];
        instrModel.clear();
        loadModel.clear();
        addModel.clear();
        mulModel.clear();
        storeModel.clear();
        addressModel.clear();
        addUnit.clear();
        mulUnit.clear();
        loadUnit.busy = 0;
        timer.setText("");
        registerModel.clear();
        for (int i = 0; i < 10; i++) {
            registerModel.addElement("F" + i + " >> 0");
        }
    }

    private static void issue_new() {
        if (index == assembly.length) {
            return;
        }

        String inst = assembly[index];

        if (registerModel.getElementAt(Integer.parseInt(inst.split(",")[0].split("F")[1].trim())).toString().contains("w:")) {
            return;
        }

        if (inst.contains("LD")) {

            String source = assembly[index].split(" ")[1].split(",")[0].split("F")[1];
            registerModel.setElementAt("F" + source + " >> w: Load" + (loadUnit.busy + 1), Integer.parseInt(source));
            loadUnit.busy++;
            loadModel.addElement(assembly[index].split(" ")[1].split(",")[1]);
            instrModel.removeElementAt(0);
            instructions.setSelectedIndex(0);
            index++;
        } else if (inst.contains("SD")) {
            storeModel.addElement(assembly[index].split(" ")[1].split(",")[0]);
            addressModel.addElement(assembly[index].split(" ")[1].split(",")[1]);
            instrModel.removeElementAt(0);
            instructions.setSelectedIndex(0);
            index++;

        } else if (inst.contains("ADD") || inst.contains("SUB")) {

            if (registerModel.getElementAt(Integer.parseInt(inst.split(",")[1].split("F")[1].trim())).toString().contains("w:")) {
                hazard++;
                return;
            }

            if (addUnit.canAdd()) {

                addUnit.addWork(assembly[index]);
                instrModel.removeElementAt(0);
                instructions.setSelectedIndex(0);
                index++;
            }

        } else if (inst.contains("MUL") || inst.contains("DIV")) {

            if (registerModel.getElementAt(Integer.parseInt(inst.split(",")[1].split("F")[1].trim())).toString().contains("w:")) {
                hazard++;

                return;
            }

            if (mulUnit.canAdd()) {

                mulUnit.addWork(assembly[index]);
                instrModel.removeElementAt(0);
                instructions.setSelectedIndex(0);
                index++;
            }

        }

    }

    private static void execute() {

        storeUnit.execute();
        loadUnit.execute();
        addUnit.execute();
        mulUnit.execute();

    }

}
