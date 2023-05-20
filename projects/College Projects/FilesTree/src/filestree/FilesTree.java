package filestree;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FilesTree {

    public static String directoryName[] = {"E:\\", "D:\\", "F:\\", "G:\\", "H:\\"};
    static JFrame mainFrm = GUI_Ruler2.addFrm(true, false, 400, 300, 450, 340, "File Tree", null, "file.png", true);
    public static String Message = "";
    static JTextArea jt = new JTextArea();
    static JScrollPane holderText = new JScrollPane(jt);

    public static synchronized void getMessage() {

        for (int j = 0; j < directoryName.length; j++) {
            int count =  0;
            File f = new File(directoryName[j]);
            try {

                String files[] = f.list();

                // statement to make error happen if not valid file 
                if (f.exists()) {
                    Message += "Directory >>>" + f.getPath() + "\n";

                    for (int i = 0; i < files.length; i++) {

                        if (new File(directoryName[j] + files[i]).getName().equals("System Volume Information")) {
                            break;

                        }

                        
                        if (new File(directoryName[j] + files[i]).isDirectory()) {

                            Message += (count++ + 1) + " > " + files[i] + "\n";

                            String[] inner_files = new File(directoryName[j] + files[i]).list();
                            for (int k = 0; k < inner_files.length; k++) {
                            
                                if (new File(directoryName[j] + files[i] + "\\" + inner_files[k]).isDirectory()) {
                                    Message += "    f: " + inner_files[k] + " \n";
                                }
                            
                            
                            }

                        }

                    }
                    Message += "            ####################\n";
                }
            } catch (Exception e) {
            }

        }

    }

    public static synchronized void getGUI() {

        jt.setEditable(false);
        jt.setText(Message);

        holderText.setBounds(10, 10, 400, 270);
        jt.setFont(new Font("Times New Roman", Font.BOLD, 20));
        jt.repaint();
        GUI_Ruler2.makeCenter(holderText, mainFrm);
        mainFrm.getContentPane().setBackground(Color.CYAN);
        mainFrm.setLayout(null);
        mainFrm.add(holderText, 0);
        mainFrm.repaint();

    }

    public static void main(String[] args) throws InterruptedException {

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
