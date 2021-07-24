package semster.project;

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
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class SemsterProject {

    
    
    static JFrame welcomeFrm = GUI_Ruler.addFrm(true, false, 400, 300, 400, 300, "welcome", "zekra.jpg", null, true);
    static JButton enter = GUI_Ruler.addBtn(15, 10, 150, 50, "Enter", welcomeFrm);
    static JButton exit = GUI_Ruler.addBtn(15, 10, 150, 50, "Exit", welcomeFrm);
    static JTextArea name = GUI_Ruler.addtxt(30, 30, 150, 50, "", welcomeFrm);
    static JPasswordField password = GUI_Ruler.addpass(30, 30, 150, 50, "", welcomeFrm);
    static JLabel name_L = GUI_Ruler.addLbl(30, 30, 150, 50, "Name: ", welcomeFrm);
    static JLabel password_L = GUI_Ruler.addLbl(30, 30, 150, 50, "Password: ", welcomeFrm);

    static JFrame secondFrm = GUI_Ruler.addFrm(false, false, 400, 300, 450, 100, "choose", "zekra.jpg", null, true);
    static JButton encrypt = GUI_Ruler.addBtn(15, 10, 200, 50, "Encryption-project", secondFrm);
    static JButton student = GUI_Ruler.addBtn(15, 10, 200, 50, "student-project", secondFrm);

    static JFrame encryptFrm = GUI_Ruler.addFrm(false, false, 300, 200, 700, 500, "Encryption-Decryption project", "zekra.jpg", null, true);
    static JButton save = GUI_Ruler.addBtn(15, 10, 150, 50, "Save as", encryptFrm);
    static JButton Encryption = GUI_Ruler.addBtn(15, 10, 150, 50, "En/De-crypt", encryptFrm);
    static JButton Browse = GUI_Ruler.addBtn(15, 10, 150, 50, "Browse", encryptFrm);
    static JTextArea fileName = GUI_Ruler.addtxt(30, 30, 250, 50, "", encryptFrm);
    static JTextArea key = GUI_Ruler.addtxt(30, 30, 250, 50, "", encryptFrm);
    static JTextArea content = GUI_Ruler.addtxt(30, 30, 600, 250, "", encryptFrm);
    static JLabel show = GUI_Ruler.addLbl(30, 30, 150, 50, "key", encryptFrm);
    static final JRadioButton chE = GUI_Ruler.addradio(10, 10, 100, 40, "Encrypt", encryptFrm);
    static final JRadioButton chD = GUI_Ruler.addradio(10, 10, 100, 40, "Decrypt", encryptFrm);
    static final JPanel jpEncryption = GUI_Ruler.addpanel(10, 10, 680, 480, "Encryption-Decryption", encryptFrm);

    static JFrame studentFrm = GUI_Ruler.addFrm(false, false, 150, 150, 1100, 550, "student project", "zekra.jpg", null, true);
    static JLabel courseName = GUI_Ruler.addLbl(30, 30, 150, 50, "course name", studentFrm);
    static JLabel Hours = GUI_Ruler.addLbl(30, 30, 150, 50, "Hours", studentFrm);
    static JLabel ID = GUI_Ruler.addLbl(30, 30, 150, 50, "ID", studentFrm);
    static JLabel name_ID = GUI_Ruler.addLbl(30, 30, 150, 50, "name", studentFrm);
    static JLabel courses = GUI_Ruler.addLbl(30, 30, 150, 50, "courses", studentFrm);
    static JLabel list = GUI_Ruler.addLbl(30, 30, 150, 50, "list of availabe courses", studentFrm);
    static JButton addCourse = GUI_Ruler.addBtn(15, 10, 150, 50, "Add", studentFrm);
    static JButton addID = GUI_Ruler.addBtn(15, 10, 150, 50, "Add", studentFrm);
    static JButton getList = GUI_Ruler.addBtn(15, 10, 150, 50, "List of courses", studentFrm);
    static JButton statics = GUI_Ruler.addBtn(15, 10, 150, 50, "statics", studentFrm);
    static JTextArea courseNT = GUI_Ruler.addtxt(30, 30, 150, 50, "", studentFrm);
    static JTextArea HoursT = GUI_Ruler.addtxt(30, 30, 150, 50, "", studentFrm);
    static JTextArea IDT = GUI_Ruler.addtxt(30, 30, 150, 50, "", studentFrm);
    static JTextArea nameT = GUI_Ruler.addtxt(30, 30, 150, 50, "", studentFrm);
    static JTextArea listT = GUI_Ruler.addtxt(30, 30, 300, 200, "", studentFrm);
    static final JPanel jpCourses = GUI_Ruler.addpanel(10, 10, 350, 480, "Encryption-Decryption", studentFrm);
    static final JPanel jpStudent = GUI_Ruler.addpanel(300, 10, 350, 480, "Encryption-Decryption", studentFrm);
    static final JPanel jpStatics = GUI_Ruler.addpanel(600, 10, 350, 480, "Encryption-Decryption", studentFrm);
    static final JComboBox<String> como = GUI_Ruler.addcomo(30, 30, 150, 50, studentFrm);
    static JTable jt = GUI_Ruler.addtable(30, 30, 300, 300, studentFrm, null, null);

    static String NAME, PASS, fileContent;
    static File file;
    static String studentWork[];

    
    public static void main(String[] args) {

        
        
        //welcome frame
        GUI_Ruler.makeVertical(name_L, password_L, enter);
        GUI_Ruler.makeHorizontal(name_L, name);
        GUI_Ruler.makeHorizontal(password_L, password);
        GUI_Ruler.makeHorizontal(enter, exit);

        //second frame
        GUI_Ruler.makeHorizontal(encrypt, student);

        //encryption frame
        GUI_Ruler.makeHorizontal(30, fileName, Browse, Encryption);
        GUI_Ruler.makeVertical(fileName, key, chE, content);
        GUI_Ruler.makeHorizontal(30, key, show, save);
        GUI_Ruler.makeHorizontal(30, chE, chD);
        fileName.setEditable(false);
        ButtonGroup bg = new ButtonGroup();
        bg.add(chD);
        bg.add(chE);
        chE.setSelected(true);
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

        GUI_Ruler.AddHolderText(welcomeFrm, name); // to add scroll bar to the textarea
        GUI_Ruler.AddHolderText(encryptFrm, fileName, key, content);
        GUI_Ruler.AddHolderText(studentFrm, listT);

        //codes
        statics.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent evt) {
                jt.setVisible(false);
                String t[][];
                
                t = new String[como.getItemCount() + 1][studentWork.length + 1];
                for (int i = 0; i < t.length; i++) {
                    t[i] = new String[studentWork.length + 1];
                 Arrays.fill(t[i], "");  
                }
               
                System.out.println(Arrays.deepToString(t));
                for (int i = 0; i < t[0].length; i++) {
                    if (i == 0) {
                        t[0][i] = "";
                    } else {
                        t[0][i] = studentWork[i - 1].split(" ")[0];
                    }
                }
                for (int i = 0; i < como.getItemCount() + 1 ; i++) {
                   if (i == 0 ) {
                        t[i][i] = "";
                    }
                   else
                    t[i][0] = como.getItemAt(i-1).split(" ")[0];
                }
                
                for (int i = 1; i < como.getItemCount() + 1; i++) {
                    for (int j = 1; j < studentWork.length + 1; j++) {
                        
                        //i-1 // subject index
                          //      j-1 // student index
                        String holder [] = studentWork[j-1].split(" ");
                        for (int k = 2; k < holder.length; k++) {
                            if (holder[k].equals((i-1) + "")) {
                                t[i][j]= "A";
                            }
                        }
                        
                    }
                }
                
                
                jt = GUI_Ruler.addtable(30, 30, 300, 300, studentFrm, t, t[1]);
                GUI_Ruler.fillPanel(jpStatics, statics, jt);
                GUI_Ruler.makeVertical(statics, jt);

            }

        });
        addCourse.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent evt) {

                if (courseNT.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No Course name found!");
                } else if (HoursT.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No Hourse name found!");
                } else {
                    como.addItem(courseNT.getText() + " - " + HoursT.getText() + "h");
                }
            }

        });
        getList.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent evt) {
                int k = como.getItemCount();
                String s = "";
                for (int i = 0; i < k; i++) {
                    s += (i + 1) + " >>> " + como.getItemAt(i) + "\n";

                }
                listT.setText(s);
            }

        });
        addID.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent evt) {
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

                            studentWork[i] += " " + como.getSelectedIndex();
                            JOptionPane.showMessageDialog(null, como.getSelectedItem() + " added to " + studentWork[i].split(" ")[0]);
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "No such an ID!");
                    // end of code   
                }

            }

        });

        //////////////////////////////////////////////////////
        Browse.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent evt) {

                JFileChooser fileChooser = new JFileChooser();// create new file chooser
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

                while (true) {

                    if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                        file = fileChooser.getSelectedFile(); // get File
                        fileName.setText(file.getPath());
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

        });
        save.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent evt) {

                if (fileName.getText().endsWith(".txt")) {

                    try {

                        BufferedWriter bf = new BufferedWriter(new FileWriter(file));
                        bf.write("");// start file with write

                        String holder[] = fileContent.split("\n");
                        for (int i = 0; i < holder.length; i++) {
                            bf.append(holder[i]);// add text to file
                           bf.newLine(); // add new line 
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

        });
        Encryption.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent evt) {

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

        });
        //////////////////////////////////////////////////////////////////////
        enter.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent evt) {

                try { // try to check if file is not found
                    BufferedReader br = new BufferedReader(new FileReader("pass.txt"));//open file
                    int count = Integer.parseInt(br.readLine());//read first line as integer
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

        });
        exit.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent evt) {
                System.exit(0);
            }

        });
        ///////////////////////////////////////////////////////////
        encrypt.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent evt) {

                secondFrm.setVisible(false);
                encryptFrm.setVisible(true);
            }

        });
        student.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent evt) {
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

        });

    }

}
