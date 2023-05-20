package database_console;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

public class DB_project {

    static JFrame mainFrm = GUI_Ruler_DB.addFrm(true, false, 400, 250, 350, 250, "Charity Organization", "back.jpg", "back.jpg", true);
    static JButton queryBtn = GUI_Ruler_DB.addBtn(15, 20, 150, 50, "SEARCH", mainFrm);
    static JButton stat = GUI_Ruler_DB.addBtn(15, 10, 150, 50, "STATISTICS", mainFrm);
    static JButton exit = GUI_Ruler_DB.addBtn(15, 10, 150, 50, "EXIT", mainFrm);
    static JButton insert = GUI_Ruler_DB.addBtn(15, 10, 150, 50, "INSERT", mainFrm);
    static JTextArea selector = GUI_Ruler_DB.addtxt(20, 20, 210, 70, "", mainFrm);
    static JScrollPane selectholder = new JScrollPane(selector);
    static JButton select_btn = GUI_Ruler_DB.addBtn(15, 10, 100, 50, "GO", mainFrm);

    static JFrame queryFrm = GUI_Ruler_DB.addFrm(false, false, 400, 150, 300, 500, "Query", "back.jpg", "back.jpg", false);
    static JButton ok = GUI_Ruler_DB.addBtn(20, 20, 70, 40, "OK", queryFrm);
    static JTextArea cond = GUI_Ruler_DB.addtxt(20, 200, 190, 50, "", queryFrm);
    static JTextArea result = GUI_Ruler_DB.addtxt(20, 20, 250, 200, "", queryFrm);
    static JLabel table_L = GUI_Ruler_DB.addLbl(20, 10, 100, 40, "TABELS", queryFrm);
    static JLabel col_L = GUI_Ruler_DB.addLbl(20, 10, 100, 40, "ATTR", queryFrm);
    static JScrollPane adjustholderText = new JScrollPane(result);
    static JScrollPane condholderText = new JScrollPane(cond);

    static JList tables = new JList();
    static JScrollPane tt = new JScrollPane(tables);
    static DefaultListModel tableModel = new DefaultListModel();

    static JList colums = new JList();
    static JScrollPane cc = new JScrollPane(colums);
    static DefaultListModel colModel = new DefaultListModel();

    static JFrame department_Frm = GUI_Ruler_DB.addFrm(false, false, 400, 250, 420, 340, "INSERT", "back.jpg", "back.jpg", false);
    static JTextArea show = GUI_Ruler_DB.addtxt(20, 20, 250, 200, "", department_Frm);
    static JScrollPane showholder = new JScrollPane(show);
    static JTextArea adder = GUI_Ruler_DB.addtxt(20, 230, 210, 70, "", department_Frm);
    static JScrollPane addholder = new JScrollPane(adder);
    static JButton add_btn = GUI_Ruler_DB.addBtn(15, 10, 100, 50, "ADD", department_Frm);

    static JList d_table = new JList();
    static JScrollPane dd = new JScrollPane(d_table);
    static DefaultListModel depModel = new DefaultListModel();

    static table[] content = {
        new table("medicine", "medicine_id", "medicine_name", "side_effects", "expire_date", "availability"),
        new table("patients", "patient_id", "patient_name", "birth_date"),
        new table("room", "room_id", "location", "availability", "no_of_bed"),
        new table("assign_medicine", "assign_id", "patient_id", "medicine_id", "doctor_id", "assign_date", "prescription"),
        new table("assign_room", "assign_id", "patient_id", "room_id", "assign_date"),
        new table("doctors", "doctor_id", "doctor_name", "birth_date", "salary"),
        new table("certificate", "certificate_id", "certificate_name", "date_get", "degree", "student_id"),
        new table("student", "student_id", "student_name", "birth_date", "academic_degree"),
        new table("teacher", "teacher_id", "teacher_name", "birth_date", "job"),
        new table("sessions", "session_id", "cost", "date_get", "hall", "course_id", "student_id", "teacher_id"),
        new table("course", "course_id", "course_name", "course_degree", "course_hours"),
        new table("prerequest", "prerequest_id", "course_id", "prequest_id"),
        new table("donation", "money", "pay_type", "donor_id", "volunteer_id"),
        new table("donor", "donor_id", "address", "birth_date"),
        new table("manager", "manager_id", "manager_name", "address", "salary"),
        new table("volunteer", "volunteer_id", "volunteer_name", "year_experience", "manager_id")
    };

    public static void main(String[] args) throws SQLException {

        DB_driver.startDB("jdbc:derby://localhost:1527/charity", "aboahmed", "aboahmed");

        intialize_lists();

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

        ok.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                String star[] = new String[colums.getSelectedValues().length];
                for (int i = 0; i < star.length; i++) {
                    star[i] = (String) colums.getSelectedValues()[i];
                }
                try {
                    ArrayList<String> temp;
                    if (cond.getText().equals("")) {
                        temp = DB_driver.selectCols((String) tables.getSelectedValue(), star);
                    } else {
                        temp = DB_driver.selectCols_cond((String) tables.getSelectedValue(), cond.getText(), star);
                    }

                    result.setText("");
                    for (int i = 0; i < temp.size(); i++) {
                        result.setText(result.getText() + "\n" + temp.get(i));
                    }

                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(null, "there is error in your input!");
                }

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

                try {
                    JOptionPane.showMessageDialog(null, getState());
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }

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

        queryBtn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {

                colModel.clear();
                tableModel.clear();
                cond.setText("");
                result.setText("");
                queryFrm.setVisible(true);

                for (int i = 0; i < content.length; i++) {

                    tableModel.addElement(content[i].name);

                }

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

        insert.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                depModel.clear();
                for (int i = 0; i < 16; i++) {
                    depModel.addElement(content[i].name);
                }
                show.setText("");
                adder.setText("");
                department_Frm.setVisible(true);

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

        tables.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {
                colModel.clear();
                int index = tables.getSelectedIndex();
                int size = content[index].cols.size();
                for (int i = 0; i < size; i++) {
                    colModel.addElement(content[index].cols.get(i));
                }

            }
        });

        tables.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent evt) {

                colModel.clear();
                int index = tables.getSelectedIndex();
                int size = content[index].cols.size();
                for (int i = 0; i < size; i++) {
                    colModel.addElement(content[index].cols.get(i));
                }
            }

            @Override
            public void mouseReleased(MouseEvent evt) {
            }

        });

        d_table.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                ArrayList<String> temp = new ArrayList();
                int index = d_table.getSelectedIndex();
                String m = content[index].cols.get(0);

                for (int i = 1; i < content[index].cols.size(); i++) {
                    m += " , " + content[index].cols.get(i);
                }
                adder.setToolTipText(m);
                try {
                    temp = DB_driver.selectCols(content[index].name, content[index].getCols());
                } catch (SQLException ex) {
                    Logger.getLogger(DB_project.class.getName()).log(Level.SEVERE, null, ex);
                }

                String t = "";
                for (int i = 0; i < temp.size(); i++) {
                    t += temp.get(i) + "\n";
                }

                show.setText(t);
            }
        });

        d_table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                ArrayList<String> temp = new ArrayList();
                int index = d_table.getSelectedIndex();
                String m = content[index].cols.get(0);

                for (int i = 1; i < content[index].cols.size(); i++) {
                    m += " , " + content[index].cols.get(i);
                }
                adder.setToolTipText(m);
                try {
                    temp = DB_driver.selectCols(content[index].name, content[index].getCols());
                } catch (SQLException ex) {
                    Logger.getLogger(DB_project.class.getName()).log(Level.SEVERE, null, ex);
                }

                String t = "";
                for (int i = 0; i < temp.size(); i++) {
                    t += temp.get(i) + "\n";
                }

                show.setText(t);
            }

            @Override
            public void mouseReleased(MouseEvent evt) {
            }
        });

        select_btn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {

                try {

                    DB_driver.addTableCol_exe(selector.getText());
                    JOptionPane.showMessageDialog(null, "updates done!");

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "your Query statement contains erros!\n" + e.getStackTrace());
                }

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

        add_btn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                
                try {
                    DB_driver.insterROW((String) d_table.getSelectedValue(), adder.getText().split(","));
                    JOptionPane.showMessageDialog(null, "row added");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Wrong insertion!");
                            
                    Logger.getLogger(DB_project.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
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

    public static String getState() throws SQLException {

        String msg = "";
        msg += "number of courses " + DB_driver.selectGroup("course", "count", "*") + "\n";
        msg += "number of doctors " + DB_driver.selectGroup("doctors", "count", "*") + "\n";
        msg += "number of patients " + DB_driver.selectGroup("patients", "count", "*") + "\n";
        msg += "number of rooms " + DB_driver.selectGroup("room", "count", "*") + "\n";
        msg += "number of students " + DB_driver.selectGroup("student", "count", "*") + "\n";
        msg += "number of teachers " + DB_driver.selectGroup("teacher", "count", "*") + "\n";
        msg += "number of volunteer " + DB_driver.selectGroup("volunteer", "count", "*") + "\n";
        msg += "doctor salaries from " + DB_driver.selectGroup("doctors", "min", "salary") + " to " + DB_driver.selectGroup("doctors", "max", "salary") + "\n";
        msg += "Donations ranges from " + DB_driver.selectGroup("donation", "min", "money") + " to " + DB_driver.selectGroup("donation", "max", "money") + "\n";
        msg += "sessions average cost " + DB_driver.selectGroup("sessions", "avg", "cost");

        return msg;
    }

    public static void intialize_lists() {

        tables.setForeground(Color.black);
        tables.setBackground(Color.white);
        tables.setFont(new Font("Georgia", Font.PLAIN, 15));
        tables.repaint();
        tt.setBounds(20, 40, 100, 150);
        queryFrm.add(tt, 0);
        tables.setModel(tableModel);

        colums.setForeground(Color.black);
        colums.setBackground(Color.white);
        colums.setFont(new Font("Georgia", Font.PLAIN, 15));
        colums.repaint();
        cc.setBounds(150, 40, 100, 150);
        queryFrm.add(cc, 0);
        colums.setModel(colModel);
        colums.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tables.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        d_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        d_table.setForeground(Color.black);
        d_table.setBackground(Color.white);
        d_table.setFont(new Font("Georgia", Font.PLAIN, 15));
        d_table.repaint();
        dd.setBounds(20, 20, 100, 200);
        department_Frm.add(dd, 0);
        d_table.setModel(depModel);

        show.setLineWrap(false);
        showholder.setBounds(140, 20, 250, 200);
        department_Frm.add(showholder, 0);
        show.setEditable(false);

        GUI_Ruler_DB.makeVertical(insert, stat, selector);

        GUI_Ruler_DB.makeHorizontal(selector, select_btn);

        GUI_Ruler_DB.makeHorizontal(insert, queryBtn);
        GUI_Ruler_DB.makeHorizontal(stat, exit);
        GUI_Ruler_DB.makeHorizontal(40, table_L, col_L);

        GUI_Ruler_DB.makeHorizontal(cond, ok);
        GUI_Ruler_DB.makeVertical(cond, result);
        GUI_Ruler_DB.makeVertical(adder, show);
        GUI_Ruler_DB.makeHorizontal(adder, add_btn);

        selector.setLineWrap(true);
        selectholder.setBounds(selector.getX(), selector.getY(), selector.getWidth(), selector.getHeight());
        mainFrm.add(selectholder, 0);

        adder.setLineWrap(true);
        addholder.setBounds(adder.getX(), adder.getY(), adder.getWidth(), adder.getHeight());
        department_Frm.add(addholder, 0);

        result.setLineWrap(true);
        adjustholderText.setBounds(result.getX(), result.getY(), result.getWidth(), result.getHeight());
        queryFrm.add(adjustholderText, 0);
        result.setEditable(false);

        cond.setLineWrap(true);
        condholderText.setBounds(cond.getX(), cond.getY(), cond.getWidth(), cond.getHeight());
        queryFrm.add(condholderText, 0);

    }

    //addTable("employee", "emp_id number(11) primary key");
    // for (int i = 9; i > 0; i--) {
    //      insterROW("givens" , 10 - i  +  " , " + i );
    // }
    //joiner j = new joiner(new condition( " givens.poor_id "  , " = " , " poor.poor_id " ), "poor");
    //select("select  name from givens join poor on ( givens.poor_id = poor.poor_id ) ");
    //   condition cond = new condition("poor_id", "<", "5");
    //order = "poor_id desc" ;
    //select("select  poor_id  from poor ");
}
