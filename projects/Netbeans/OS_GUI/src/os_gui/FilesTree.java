package os_gui;

import java.awt.Font;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FilesTree {

    public static final String rooter = "H:\\software projects\\Netbeans Projects\\OS_GUI\\";
    public static String directoryName[] = {rooter + "root"};
    static JFrame mainFrm = GUI_Ruler.addFrm(true, false, 400, 300, 450, 340,
            "File Tree", "TREE_ICO.png", "TREE_ICON.png", false, false, false);
    public static String Message = "";
    static JTextArea jt = new JTextArea();
    static JScrollPane holderText = new JScrollPane(jt);

    public static synchronized void getMessage() {
        Message = "";
        for (int j = 0; j < directoryName.length; j++) {
            int count = 0;
            File f = new File(directoryName[j]);
            try {

                String files[] = f.list();
                // statement to make error happen if not valid file 
                if (f.exists()) {
                    Message += "Directory >>>" + f.getName() + "\n";

                    for (int i = 0; i < files.length; i++) {

                        if (new File(directoryName[j] + files[i]).getName().equals("System Volume Information")) {
                            break;

                        }
                        if (new File(directoryName[j] + "\\" + files[i]).isDirectory()) {
                            Message += (count++ + 1) + " > " + files[i] + "\n";
                            String[] inner_files = new File(directoryName[j] + "\\" + files[i]).list();
                            for (int k = 0; k < inner_files.length; k++) {

                                if (new File(directoryName[j] + "\\" + files[i] + "\\" + inner_files[k]).isDirectory()) {
                                    Message += "    f: " + inner_files[k] + " \n";
                                }

                            }

                        }

                    }
                    Message += "            ####################\n";
                }
            } catch (Exception e) {
                System.out.println("ERROR CATCHER");
            }

        }

    }

    public static synchronized void getGUI() {

        jt.setEditable(false);
        jt.setText(Message);

        holderText.setBounds(10, 10, 400, 270);
        jt.setFont(new Font("Times New Roman", Font.BOLD, 20));
        jt.repaint();
        GUI_Ruler.makeCenter(holderText, mainFrm);
        mainFrm.setLayout(null);
        mainFrm.add(holderText, 0);
        mainFrm.repaint();

    }

    public static void startTree() throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {

                getMessage();
                getGUI();

            }

        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                getGUI();

            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }

}
