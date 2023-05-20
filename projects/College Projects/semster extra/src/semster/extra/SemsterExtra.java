package semster.extra;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class SemsterExtra {

    static JPopupMenu pE = new JPopupMenu();
    static JPopupMenu pST = new JPopupMenu();

    static JMenuItem ft1 = new JMenuItem("> Open file!");
    static JMenuItem ft2 = new JMenuItem("> Delete file!");
    static JMenuItem ft3 = new JMenuItem("> Move to...");

    static JMenuItem addAccount = new JMenuItem("Add new account");
    static JMenuItem deleteAccount = new JMenuItem("Delete account");
    static JMenuItem saveData = new JMenuItem("Save Data Base!");

    static JFrame welcomeFrm = GUI_Ruler.addFrm(true, false, 400, 300, 400, 300, "welcome", "zekra.jpg", "1.png", false, null, null);
    static JButton enter = GUI_Ruler.addBtn(15, 10, 150, 50, "Enter", welcomeFrm, null);
    static JButton exit = GUI_Ruler.addBtn(15, 10, 150, 50, "Exit", welcomeFrm, null);
    static JTextArea name = GUI_Ruler.addtxt(30, 30, 150, 50, "", welcomeFrm, "Enter you name here!");
    static JPasswordField password = GUI_Ruler.addpass(30, 30, 150, 50, "", welcomeFrm, "Enter your password here!");
    static JLabel name_L = GUI_Ruler.addLbl(30, 30, 150, 50, "Name: ", welcomeFrm);
    static JLabel password_L = GUI_Ruler.addLbl(30, 30, 150, 50, "Password: ", welcomeFrm);

    static JFrame secondFrm = GUI_Ruler.addFrm(false, false, 400, 300, 450, 100, "choose", "zekra.jpg", "1.png", false, "select one button", null);
    static JButton encrypt = GUI_Ruler.addBtn(15, 10, 200, 50, "Encryption-project", secondFrm, "open Encryption-file frame!");
    static JButton student = GUI_Ruler.addBtn(15, 10, 200, 50, "student-project", secondFrm, "open studetns-word frame!");

    static JFrame encryptFrm = GUI_Ruler.addFrm(false, false, 300, 200, 700, 500, "Encryption-Decryption project", "zekra.jpg", "1.png", false, null, pE);
    static JButton save = GUI_Ruler.addBtn(15, 10, 150, 50, "Save as", encryptFrm, "save file process!");
    static JButton Encryption = GUI_Ruler.addBtn(15, 10, 150, 50, "En/De-crypt", encryptFrm, "En\\Decrypt with the specified key!");
    static JButton Browse = GUI_Ruler.addBtn(15, 10, 150, 50, "Browse", encryptFrm, "Browse system file to get specified file!");
    static JTextArea fileName = GUI_Ruler.addtxt(30, 30, 250, 50, "", encryptFrm, null);
    static JTextArea key = GUI_Ruler.addtxt(30, 30, 250, 50, "", encryptFrm, "write your key here!");
    static JTextArea content = GUI_Ruler.addtxt(30, 30, 600, 250, "", encryptFrm, "your file content!");
    static JLabel show = GUI_Ruler.addLbl(30, 30, 150, 50, "key", encryptFrm);
    static final JRadioButton chE = GUI_Ruler.addradio(10, 10, 100, 40, "Encrypt", encryptFrm);
    static final JRadioButton chD = GUI_Ruler.addradio(10, 10, 100, 40, "Decrypt", encryptFrm);
    static final JPanel jpEncryption = GUI_Ruler.addpanel(10, 10, 680, 480, "Encryption-Decryption", encryptFrm);

    static JFrame studentFrm = GUI_Ruler.addFrm(false, false, 150, 150, 1100, 550, "student project", "zekra.jpg", "1.png", false, null, pST);
    static JLabel courseName = GUI_Ruler.addLbl(30, 30, 150, 50, "course name", studentFrm);
    static JLabel Hours = GUI_Ruler.addLbl(30, 30, 150, 50, "Hours", studentFrm);
    static JLabel ID = GUI_Ruler.addLbl(30, 30, 150, 50, "ID", studentFrm);
    static JLabel name_ID = GUI_Ruler.addLbl(30, 30, 150, 50, "name", studentFrm);
    static JLabel courses = GUI_Ruler.addLbl(30, 30, 150, 50, "courses", studentFrm);
    static JLabel list = GUI_Ruler.addLbl(30, 30, 150, 50, "list of availabe courses", studentFrm);
    static JButton addCourse = GUI_Ruler.addBtn(15, 10, 150, 50, "Add", studentFrm, "add to list of courses!");
    static JButton getList = GUI_Ruler.addBtn(15, 10, 150, 50, "List of courses", studentFrm, "click to display all available courses!");
    static JButton statics = GUI_Ruler.addBtn(15, 10, 150, 50, "statics", studentFrm, null);
    static JTextArea courseNT = GUI_Ruler.addtxt(30, 30, 150, 50, "", studentFrm, null);
    static JTextArea HoursT = GUI_Ruler.addtxt(30, 30, 150, 50, "", studentFrm, null);
    static JTextArea IDT = GUI_Ruler.addtxt(30, 30, 150, 50, "", studentFrm, null);
    static JTextArea nameT = GUI_Ruler.addtxt(30, 30, 150, 50, "", studentFrm, null);
    static JTextArea listT = GUI_Ruler.addtxt(30, 30, 300, 200, "", studentFrm, null);

    static final JPanel jpCourses = GUI_Ruler.addpanel(10, 10, 350, 480, "Encryption-Decryption", studentFrm);
    static final JPanel jpStudent = GUI_Ruler.addpanel(300, 10, 350, 480, "Encryption-Decryption", studentFrm);
    static final JPanel jpStatics = GUI_Ruler.addpanel(600, 10, 350, 480, "Encryption-Decryption", studentFrm);
    static final JComboBox<String> como = GUI_Ruler.addcomo(30, 30, 150, 50, studentFrm);
    static JButton addID = GUI_Ruler.addBtn(15, 10, 150, 50, "Add", studentFrm, "add subject to this student");

    static JTable jt = GUI_Ruler.addtable(30, 30, 300, 300, studentFrm, null, null);

    static JComponent tools[] = {como, addID, chD, chE, enter, exit, name, password, name_L, password_L, encrypt, student, save, Encryption, Browse, fileName, key, content, show, chE, chD, courseName, Hours, ID, name_ID, courses, list, addCourse, getList, statics, courseNT, HoursT, IDT, nameT, listT};

    static String NAME, PASS, fileContent;
    static File file;
    static String studentWork[];
    static int golobalInt = 0;

    public static void main(String[] args) throws AWTException {

        ActionListener ae = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent AE) {
                if (fileName.getText().isEmpty()) {
                    return;
                }

                if (((JMenuItem) AE.getSource()).getText().contains("Open")) {
                    try {
                        Desktop.getDesktop().open(file);
                    } catch (IOException ex) {

                    }
                } else if (((JMenuItem) AE.getSource()).getText().contains("Delete")) {
                    file.delete();
                } else {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                    while (true) {

                        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

                            file.renameTo(new File(fileChooser.getSelectedFile().getPath() + "\\" + file.getName()));
                            file = new File(fileChooser.getSelectedFile().getPath() + "\\" + file.getName());
                            fileName.setText(file.getPath());
                            break;
                        }
                    }
                }

            }
        };

        ft1.addActionListener(ae);
        ft2.addActionListener(ae);
        ft3.addActionListener(ae);
        pE.add(ft1);
        pE.add(ft2);
        pE.add(ft3);

        ActionListener ae1 = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent AE) {

                String name = JOptionPane.showInputDialog(null, "Enter account name:");
                if (name != null && !name.trim().isEmpty()) {
                    String pass = JOptionPane.showInputDialog(null, "Enter password:");

                    if (pass != null && !pass.trim().isEmpty()) {
                        String pass1 = JOptionPane.showInputDialog(null, "confirm password name:");
                        if (pass1 != null && !pass1.trim().isEmpty()) {

                            for (int i = 0; i < studentWork.length; i++) {
                                if (studentWork[i].split(" ")[0].equals(name) && studentWork[i].split(" ")[1].equals(pass)) {
                                    JOptionPane.showMessageDialog(null, "Account is already existing!");
                                    return;
                                }
                            }

                            if (pass.equals(pass1)) {
                                String s[] = new String[studentWork.length + 1];
                                for (int i = 0; i < studentWork.length; i++) {
                                    s[i] = studentWork[i];
                                }
                                s[studentWork.length] = name + " " + pass;
                                studentWork = s;
                            } else {
                                JOptionPane.showMessageDialog(null, "Password mismatch!");
                            }

                        }

                    }

                }

            }
        };

        addAccount.addActionListener(ae1);

        ActionListener ae2 = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent AE) {
                try {

                    BufferedWriter bf = new BufferedWriter(new FileWriter("pass.txt"));
                    bf.write("");

                    bf.append(studentWork.length + "");
                    bf.newLine();
                    for (int i = 0; i < studentWork.length; i++) {
                        bf.append(studentWork[i].split(" ")[0] + " " + studentWork[i].split(" ")[1]);
                        bf.newLine();
                    }
                    bf.close();

                    /*
                     FileOutputStream fileI = new FileOutputStream(file);
                     String s = content.getText();
                     for (int i = 0; i < s.length(); i++) {
                     fileI.write(s.charAt(i));
                     }
                     */
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Error while opening the file!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error while opening the file!");
                }

                JOptionPane.showMessageDialog(null, "All data have been saved!");
            }
        };

        saveData.addActionListener(ae2);

        ActionListener ae3 = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent AE) {

                String name = JOptionPane.showInputDialog(null, "Enter account name:");
                if (name != null && !name.trim().isEmpty()) {
                    String pass = JOptionPane.showInputDialog(null, "Enter password:");

                    if (pass != null && !pass.trim().isEmpty()) {
                        for (int i = 0; i < studentWork.length; i++) {
                            if (studentWork[i].split(" ")[0].equals(name) && studentWork[i].split(" ")[1].equals(pass)) {
                                String s[] = new String[studentWork.length - 1];
                                int k = 0;
                                for (int j = 0; j < studentWork.length; j++) {
                                    if (j == i) {
                                        k = 1;
                                    } else {
                                        s[j - k] = studentWork[j];
                                    }

                                }
                                studentWork = s;
                            }
                        }
                    }

                }

            }
        };

        deleteAccount.addActionListener(ae3);

        pST.add(addAccount);
        pST.add(deleteAccount);
        pST.add(saveData);

        Timer clock = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                golobalInt++;

            }
        });

        clock.start();

        //second frame
        GUI_Ruler.makeHorizontal(encrypt, student);

        //encryption frame
        GUI_Ruler.makeHorizontal(
                30, fileName, Browse, Encryption);
        GUI_Ruler.makeVertical(fileName, key, chE, content);

        GUI_Ruler.makeHorizontal(
                30, key, show, save);
        GUI_Ruler.makeHorizontal(
                30, chE, chD);
        fileName.setEditable(
                false);
        ButtonGroup bg = new ButtonGroup();

        bg.add(chD);

        bg.add(chE);

        chE.setSelected(
                true);
        GUI_Ruler.fillPanel(jpEncryption, save, Encryption, Browse, fileName, key, content, show, chD, chE);

        //student frame
        GUI_Ruler.makeHorizontal(jpCourses, jpStudent, jpStatics);

        GUI_Ruler.fillPanel(jpCourses, courseName, courseNT, Hours, HoursT, addCourse, getList, list, listT);

        GUI_Ruler.makeVertical(courseName, Hours, addCourse, list, listT);

        GUI_Ruler.makeHorizontal(courseName, courseNT);

        GUI_Ruler.makeHorizontal(Hours, HoursT);

        GUI_Ruler.makeHorizontal(addCourse, getList);

        GUI_Ruler.fillPanel(jpStudent, ID, IDT, name_ID, nameT, courses, addID, como);

        GUI_Ruler.makeVertical(ID, name_ID, courses, addID);

        GUI_Ruler.makeHorizontal(ID, IDT);

        GUI_Ruler.makeHorizontal(name_ID, nameT);

        GUI_Ruler.makeHorizontal(courses, como);

        GUI_Ruler.fillPanel(jpStatics, statics, jt);

        GUI_Ruler.makeVertical(statics, jt);

        //welcome frame
        GUI_Ruler.makeVertical(name_L, password_L, enter);

        GUI_Ruler.makeHorizontal(name_L, name);

        GUI_Ruler.makeHorizontal(password_L, password);

        GUI_Ruler.makeHorizontal(enter, exit);

        GUI_Ruler.AddHolderText(encryptFrm, fileName, key, content);

        GUI_Ruler.AddHolderText(studentFrm, listT);

        //codes
        statics.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent evt
                    ) {

                        if (como.getItemCount() == 0) {
                            return;
                        }

                        jt.setVisible(false);
                        String t[][];

                        t = new String[como.getItemCount() + 1][studentWork.length + 1];
                        for (int i = 0; i < t.length; i++) {
                            t[i] = new String[studentWork.length + 1];
                            Arrays.fill(t[i], "");
                        }

                        for (int i = 0; i < t[0].length; i++) {
                            if (i == 0) {
                                t[0][i] = "";
                            } else {
                                t[0][i] = studentWork[i - 1].split(" ")[0];
                            }
                        }
                        for (int i = 0; i < como.getItemCount() + 1; i++) {
                            if (i == 0) {
                                t[i][i] = "";
                            } else {
                                t[i][0] = como.getItemAt(i - 1).split(" ")[0];
                            }
                        }

                        for (int i = 1; i < como.getItemCount() + 1; i++) {
                            for (int j = 1; j < studentWork.length + 1; j++) {

                                //i-1 // subject index
                                //      j-1 // student index
                                String holder[] = studentWork[j - 1].split(" ");
                                for (int k = 2; k < holder.length; k++) {
                                    if (holder[k].equals((i - 1) + "")) {
                                        t[i][j] = "A";
                                    }
                                }

                            }
                        }

                        jt = GUI_Ruler.addtable(30, 30, 300, 300, studentFrm, t, t[0]);
                        GUI_Ruler.fillPanel(jpStatics, statics, jt);
                        GUI_Ruler.makeVertical(statics, jt);

                    }

                }
        );

        addCourse.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent evt
                    ) {

                        if (courseNT.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "No Course name found!");
                        } else if (HoursT.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "No Hourse name found!");
                        } else {
                            try {
                                como.addItem(courseNT.getText() + " - " + Integer.parseInt(HoursT.getText()) + "h");
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "No valid number of hours found!");
                            }

                        }
                    }

                }
        );
        getList.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent evt
                    ) {
                        int k = como.getItemCount();
                        String s = "";
                        for (int i = 0; i < k; i++) {
                            s += (i + 1) + " >>> " + como.getItemAt(i) + "\n";

                        }
                        listT.setText(s);
                    }

                }
        );
        addID.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent evt
                    ) {
                        if (nameT.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "No Name found!");
                        } else if (IDT.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "No ID found!");
                        } else if (como.getSelectedItem() == null) {
                            JOptionPane.showMessageDialog(null, "No selected Subject!");
                        } else {
                            //start of code
                            for (int i = 0; i < studentWork.length; i++) {
                                if (studentWork[i].split(" ")[0].equals(nameT.getText()) && studentWork[i].split(" ")[1].equals(IDT.getText())) {

                                    if (studentWork[i].contains(" " + como.getSelectedIndex() + " ") || studentWork[i].endsWith(" " + como.getSelectedIndex())) {
                                        JOptionPane.showMessageDialog(null, "This student has this subject already added!");
                                        return;
                                    }
                                    studentWork[i] += " " + como.getSelectedIndex();
                                    JOptionPane.showMessageDialog(null, como.getSelectedItem() + " added to " + studentWork[i].split(" ")[0]);
                                    return;
                                }
                            }
                            JOptionPane.showMessageDialog(null, "No such an ID!");
                            // end of code   
                        }

                    }

                }
        );

        //////////////////////////////////////////////////////
        Browse.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent evt
                    ) {

                        JFileChooser fileChooser = new JFileChooser();
                        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

                        while (true) {

                            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                                file = fileChooser.getSelectedFile(); // get File
                                fileName.setText(file.getPath());
                                System.out.println(file.getPath());
                                if (file.getName().contains(".txt")) {
                                    try {

                                        BufferedReader br = new BufferedReader(new FileReader(file));
                                        String good = "";
                                        fileContent = "";

                                        while (true) {
                                            good = br.readLine();
                                            if (good == null) {
                                                break;
                                            } else {
                                                fileContent += good + '\n';
                                            }

                                        }
                                        br.close();
                                        content.setText(fileContent);
                                        /*
                                         fileS = new FileInputStream(file);
                                         int c;
                                         String s = "";
                                         while ((c = fileS.read()) != -1) {
                                         s += (char) c;
                                         }

                                         content.setText(s.replaceAll("Â", "").substring(0, s.length()-1));
                                         */
                                    } catch (FileNotFoundException ex) {
                                        JOptionPane.showMessageDialog(null, "File not found!");
                                    } catch (IOException ex) {
                                        JOptionPane.showMessageDialog(null, "Error while reading file!");
                                    }

                                } else {
                                    JOptionPane.showMessageDialog(null, "you should select text file");
                                }
                                break;
                            }
                        }

                    }

                }
        );
        save.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent evt
                    ) {

                        if (fileName.getText().endsWith(".txt")) {

                            try {

                                BufferedWriter bf = new BufferedWriter(new FileWriter(file));
                                bf.write("");

                                String holder[] = fileContent.split("\n");
                                for (int i = 0; i < holder.length; i++) {
                                    bf.append(holder[i]);
                                    bf.newLine();
                                }
                                bf.close();

                                /*
                                 FileOutputStream fileI = new FileOutputStream(file);
                                 String s = content.getText();
                                 for (int i = 0; i < s.length(); i++) {
                                 fileI.write(s.charAt(i));
                                 }
                                 */
                            } catch (FileNotFoundException ex) {
                                JOptionPane.showMessageDialog(null, "Error while opening the file!");
                            } catch (IOException ex) {
                                JOptionPane.showMessageDialog(null, "Error while opening the file!");
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Cannot save data in this type of files!");

                        }

                    }

                }
        );
        Encryption.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent evt
                    ) {

                        if (!key.getText().isEmpty()) {

                            int k = Integer.parseInt(key.getText());
                            char hold[] = fileContent.toCharArray();

                            if (chE.isSelected()) {
                                for (int i = 0; i < hold.length; i++) {
                                    if (hold[i] != '\n') {
                                        hold[i] = (char) ((int) hold[i] + k);

                                    }

                                }

                            } else {
                                for (int i = 0; i < hold.length; i++) {
                                    if (hold[i] != '\n') {
                                        hold[i] = (char) ((int) hold[i] - k);

                                    }

                                }

                            }
                            fileContent = "";
                            for (int i = 0; i < hold.length; i++) {
                                fileContent += hold[i];
                            }

                            content.setText(fileContent);
                        } else {
                            JOptionPane.showMessageDialog(null, "Enter Key first!");
                        }

                    }

                }
        );
        //////////////////////////////////////////////////////////////////////
        enter.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent evt
                    ) {

                        try {
                            BufferedReader br = new BufferedReader(new FileReader("pass.txt"));
                            int count = Integer.parseInt(br.readLine());
                            for (int i = 0; i < count; i++) {
                                String s = br.readLine();
                                if (name.getText().equals(s.split(" ")[0]) && password.getText().equals(s.split(" ")[1])) {
                                    NAME = s.split(" ")[0];
                                    PASS = s.split(" ")[1];
                                    welcomeFrm.setVisible(false);
                                    secondFrm.setVisible(true);
                                    return;
                                }
                            }

                            JOptionPane.showMessageDialog(null, "No such an account!");
                        } catch (FileNotFoundException ex) {
                            JOptionPane.showMessageDialog(null, "The file of data is not found!");
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Error in data of the input file!");
                        }

                    }

                }
        );
        exit.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent evt
                    ) {
                        System.exit(0);
                    }

                }
        );
        ///////////////////////////////////////////////////////////
        encrypt.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent evt
                    ) {

                        secondFrm.setVisible(false);
                        encryptFrm.setVisible(true);
                    }

                }
        );
        student.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent evt
                    ) {
                        secondFrm.setVisible(false);

                        studentFrm.setVisible(true);

                        try {
                            BufferedReader br = new BufferedReader(new FileReader("pass.txt"));
                            int count = Integer.parseInt(br.readLine());
                            studentWork = new String[count];
                            for (int i = 0; i < count; i++) {
                                String s = br.readLine();
                                studentWork[i] = s;

                            }

                        } catch (FileNotFoundException ex) {
                            JOptionPane.showMessageDialog(null, "The file of data is not found!");
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Error in data of the input file!");
                        }

                    }

                }
        );

        //system tray code
        PopupMenu popMenu = new PopupMenu();
        MenuItem item1 = new MenuItem("> Main page");

        item1.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae
                    ) {

                        welcomeFrm.setVisible(true);
                        encryptFrm.setVisible(false);
                        secondFrm.setVisible(false);
                        studentFrm.setVisible(false);

                    }
                }
        ); //adding action listener to item1

        MenuItem item2 = new MenuItem("> Statics");

        item2.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae
                    ) {
                        showStatics();
                    }
                }
        ); //adding action listener to item1

        MenuItem item = new MenuItem("> Duration");

        item.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae
                    ) {
                        showDuration();
                    }
                }
        ); //adding action listener to item1
        MenuItem fontColor = new MenuItem("> Font color");

        fontColor.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae
                    ) {

                        Color c = JColorChooser.showDialog(null, "Choose a color", Color.black);
                        if (c != null) {
                            for (int i = 0; i < tools.length; i++) {
                                tools[i].setForeground(c);
                            }
                        }

                    }
                }
        ); //adding action listener to item1

        MenuItem backColor = new MenuItem("> Back color");

        backColor.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae
                    ) {

                        Color c = JColorChooser.showDialog(null, "Choose a color", Color.black);
                        if (c != null) {
                            for (int i = 0; i < tools.length; i++) {
                                tools[i].setBackground(c);
                            }
                        }

                    }
                }
        ); //adding action listener to item1
        MenuItem item3 = new MenuItem("> Exit");

        item3.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae
                    ) {
                        System.exit(0);

                    }
                }
        ); //adding action listener to item1

        popMenu.add(item1);

        popMenu.add(item2);

        popMenu.add(item);

        popMenu.add(fontColor);

        popMenu.add(backColor);

        popMenu.add(item3);

        Image img = Toolkit.getDefaultToolkit().getImage("1.png");
        TrayIcon trayIcon = new TrayIcon(img, "Study Tool", popMenu);

        SystemTray.getSystemTray()
                .add(trayIcon);
        trayIcon.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent evt
                    ) {
                        if (evt.getClickCount() == 2) {
                            welcomeFrm.setVisible(true);
                            encryptFrm.setVisible(false);
                            secondFrm.setVisible(false);
                            studentFrm.setVisible(false);
                        }

                    }

                }
        );

        //end of system tray code
        //////////////////////
    }

    public static void showStatics() {
        if (studentWork == null) {
            return;
        }

        String statics = "We have:\n";
        statics += como.getItemCount() + " subjects\n" + studentWork.length + " student\n";
        int max = 0;
        int studentN = -1;
        String names = "";
        int holding[] = new int[como.getItemCount()];
        for (int i = 0; i < studentWork.length; i++) {
            String holder[] = studentWork[i].split(" ");
            if (holder.length > max + 2) {
                max = holder.length - 2;
                studentN = i;
                names = studentWork[i].split(" ")[0];
            } else if (holder.length == max + 2) {
                names += " , " + studentWork[i].split(" ")[0];
            }

            for (int j = 2; j < holder.length; j++) {
                holding[Integer.parseInt(holder[j])]++;
            }

        }
        if (studentN != -1) {
            statics += "the best studetnt is " + names;
        }

        studentN = -1;
        int best = 0;
        names = "";
        for (int i = 0; i < holding.length; i++) {
            if (holding[i] > best) {
                best = holding[i];
                studentN = i;
                names = como.getItemAt(i);

            } else if (holding[i] == best) {
                names += " , " + como.getItemAt(i);
            }

        }

        if (studentN != -1) {
            statics += "\nthe best subject is " + names;
        }

        JOptionPane.showMessageDialog(null, statics);
    }

    public static void showDuration() {
        JOptionPane.showMessageDialog(null, "you have been using program for:\n" + (golobalInt / 60) + " minutes and " + (golobalInt % 60) + " seconds");
    }
}
