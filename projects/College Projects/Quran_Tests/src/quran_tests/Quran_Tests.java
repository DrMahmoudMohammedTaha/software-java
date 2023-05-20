package quran_tests;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Quran_Tests {

    //main frame desing 
    static JFrame mainFrm = GUI_Ruler.addFrm(true, false, 200, 50, 750, 350, "اختبارات القرآن الكريم", (new Random().nextInt(5) + 1) + ".png", true);
    static JButton exit = GUI_Ruler.addBtn(15, 10, 120, 40, "إغلاق", mainFrm);
    static JButton next = GUI_Ruler.addBtn(15, 10, 120, 40, "التالى", mainFrm);
    static JLabel title = GUI_Ruler.addLbl(15, 10, 260, 40, "", mainFrm);
    static JTextArea ask = GUI_Ruler.addtxt(10, 10, 300, 40, "", mainFrm);
    static JLabel answer = GUI_Ruler.addLbl(90, 40, 260, 40, "", mainFrm);
    static JCheckBox chk1 = GUI_Ruler.addchk(15, 40, 110, 40, "عام", mainFrm);
    static JCheckBox chk2 = GUI_Ruler.addchk(15, 40, 110, 40, "متشابهات", mainFrm);
    static JLabel rNumber = GUI_Ruler.addLbl(15, 10, 200, 40, "", mainFrm);

    public static void main(String[] args) throws FileNotFoundException, IOException {

        Quran_Data.intial("quran.txt", "mtshbh_o.txt");

        //check frame install
        //ask.setEditable(false);
        JList<String> list = new JList();
        list.setForeground(Color.black);
        list.setBackground(Color.WHITE);
        list.setFont(new Font("Tahoma", Font.BOLD, 16));
        list.repaint();
        JScrollPane mp = new JScrollPane(list);
        mp.setBounds(15, 70, 350, 240);
        mainFrm.add(mp, 0);

        final DefaultListModel missionModel = new DefaultListModel();
        list.setModel(missionModel);

        ButtonGroup g = new ButtonGroup();
        g.add(chk1);
        g.add(chk2);
        chk1.setSelected(true);

        GUI_Ruler.makeVertical(title, ask, answer, chk1,  exit);
        GUI_Ruler.makeHorizontal(100, title, rNumber);
        GUI_Ruler.makeHorizontal(30, ask, mp);
        GUI_Ruler.makeHorizontal(chk1, chk2);
        GUI_Ruler.makeHorizontal(exit, next);

        exit.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {

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
        next.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {

                if (chk1.isSelected() && Quran_Data.target) {
                    Quran_Data.quesAns(title, ask, answer, rNumber, missionModel);
                    Quran_Data.target = false;
                } else if (chk1.isSelected() && !Quran_Data.target) {
                    answer.setText("");
                    rNumber.setText("");
                    missionModel.clear();
                    Quran_Data.target = true;
                    Quran_Data.target_m=false;
                    Quran_Data.newQues(title, ask);
                } else if (Quran_Data.target_m) {
                    Quran_Data.mtshbhAns(  rNumber, missionModel);
                    Quran_Data.target_m = false;
                } else {
                    answer.setText("");
                    rNumber.setText("");
                    missionModel.clear();
                    Quran_Data.target_m = true;
                    Quran_Data.target = false;
                    Quran_Data.newMtshbh(title, ask);
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
        }
        );

    }

}
