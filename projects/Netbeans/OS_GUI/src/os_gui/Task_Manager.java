package os_gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class Task_Manager {

    public static String RAM_S[] = new String[20];
    public static String[] CACHE_S = new String[5];
    public static String[] CPU_S = new String[5];

    public static int lastIndexRAM = 0;
    public static int lastWriteCACHE = 0;
    public static int lastReadCACHE = 0;
    public static int lastIndexCPU_R = 0;
    public static int lastIndexCPU_W = 0;

    public static JList RAM = new JList();
    public static JScrollPane pRAM = new JScrollPane(RAM);
    public static DefaultListModel RAMModel = new DefaultListModel();

    public static JList CACHE = new JList();
    public static JScrollPane pCACHE = new JScrollPane(CACHE);
    public static DefaultListModel CACHEModel = new DefaultListModel();
    
    public static JList THREADS = new JList();
    public static JScrollPane P_THREADS = new JScrollPane(THREADS);
    public static DefaultListModel THREADSModel = new DefaultListModel();

    public static JFrame manager = GUI_Ruler.addFrm(false, false, 10, 10, 600, 400,
            "EXPLORER", "CAL_BACK.jpg", "TASK_ICON.png", false, false, false);
    public static JLabel RAM_L = GUI_Ruler.addLbl(475, 5, 120, 40, "RAM", manager);
    public static JLabel CHACHE_L = GUI_Ruler.addLbl(320, 155, 120, 40, "CACHE", manager);

    public static JLabel THREADS_L = GUI_Ruler.addLbl(475, 5, 120, 40, "THREADS", manager);
    public static JLabel CPU_L = GUI_Ruler.addLbl(20, 155, 120, 40, "CPU", manager);
    private static  JTextArea texter = GUI_Ruler.addtxt(20, 10, 120, 40, null, manager);

    static Timer CLOCK = new Timer(0, null);

    public static void addToRAM(String name, int num) {
        for (int i = lastIndexRAM; i < lastIndexRAM + num; i++) {
            RAM_S[i % RAM_S.length] = name;
        }
        lastIndexRAM = (lastIndexRAM + num) % RAM_S.length;
    }

    public static void addToCACHE() {

        while (RAM_S[lastReadCACHE] == null) {
            lastReadCACHE = (lastReadCACHE + 1) % RAM_S.length;
        }
        CACHE_S[lastWriteCACHE] = RAM_S[lastReadCACHE];
        lastWriteCACHE = (lastWriteCACHE + 1) % CACHE_S.length;
        lastReadCACHE = (lastReadCACHE + 1) % RAM_S.length;
    }

    public static void addToCPU(String name) {

        for (int i = 0; i < CPU_S.length; i++) {
            if(CPU_S[i] == null)
                break;
            if(CPU_S[i].equals(name))
                return;
        }
        CPU_S[lastIndexCPU_W] = name;
        lastIndexCPU_W = (lastIndexCPU_W + 1) % CPU_S.length;
        
    }

    public static void updateCPU() {

        while (CPU_S[lastIndexCPU_R] == null || CPU_S[lastIndexCPU_R].equals("")) {
            lastIndexCPU_R = (lastIndexCPU_R + 1) % CPU_S.length;
        }
        texter.setText(CPU_S[lastIndexCPU_R]);
        lastIndexCPU_R = (lastIndexCPU_R + 1) % CPU_S.length;
        
    }

    public static void updateMEMORY() {
        RAMModel.clear();
        CACHEModel.clear();
        THREADSModel.clear();
        
        for (int i = 0; i < RAM_S.length; i++) {
            RAMModel.addElement(RAM_S[i]);
        }
        for (int i = 0; i < CACHE_S.length; i++) {
            CACHEModel.addElement(CACHE_S[i]);
        }
        for (int i = 0; i < CPU_S.length; i++) {
            THREADSModel.addElement(CPU_S[i]);
        }
        updateCPU();
    }

    public static void startManger() {

        GUI_Ruler.makeHorizontal(30.0,CPU_L, THREADS_L);
        GUI_Ruler.makeVertical(CPU_L , texter);
        pRAM.setBounds(450, 50, 120, 300);
        manager.add(pRAM, 0);
        RAM.setModel(RAMModel);

        pCACHE.setBounds(300, 200, 120, 150);
        manager.add(pCACHE, 0);
        CACHE.setModel(CACHEModel);

        P_THREADS.setBounds(THREADS_L.getX() - 10 , THREADS_L.getY() + 45 , 120, 150);
        manager.add(P_THREADS, 0);
        THREADS.setModel(THREADSModel);

        
        RAM.setFont(new Font("Jokerman", Font.PLAIN, 15));
        CACHE.setFont(new Font("Jokerman", Font.PLAIN, 15));
        THREADS.setFont(new Font("Jokerman", Font.PLAIN, 15));
        texter.setFont(new Font("Jokerman", Font.PLAIN, 15));
        
        
        for (int i = 0; i < 5; i++) {
            addToCACHE();
        }
        updateMEMORY();

        CLOCK.stop();
        CLOCK = new Timer(2000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                addToCACHE();
                updateMEMORY();
            }
        });

        CLOCK.start();

        manager.setVisible(true);

    }

}
