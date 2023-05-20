package phonetics.quiz;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class PhoneticsQuiz {

    //main frame design
    static final JFrame mainFrame = GUI_Ruler.addFrm(true, false, 200, 50, 410, 340, "Phonetics Quize", (new Random().nextInt(5) + 1) + ".jpg", true);
    static final JButton testBtn = GUI_Ruler.addBtn(15, 10, 250, 50, "Start new Quiz", mainFrame);
    static final JButton AddBtn = GUI_Ruler.addBtn(15, 10, 250, 50, "Add new word", mainFrame);
    static final JButton SearchBtn = GUI_Ruler.addBtn(15, 10, 120, 50, "Search", mainFrame);
    static final JButton exitBtn = GUI_Ruler.addBtn(15, 10, 120, 50, "Exit", mainFrame);
    static final JTextArea text = GUI_Ruler.addtxt(10, 10, 200, 40, "", mainFrame);

    //search frame
    static final JFrame searchFrm = GUI_Ruler.addFrm(false, false, 700, 50, 330, 250, "Search results!", (new Random().nextInt(5) + 1) + ".jpg", false);
    static final JButton delete = GUI_Ruler.addBtn(15, 160, 100, 45, "Delete", searchFrm);

    //add frame
    static JFrame addFrm = GUI_Ruler.addFrm(false, false, 200, 450, 700, 320, "Add new phonen!", (new Random().nextInt(5) + 1) + ".jpg", false);
    static final JButton b = GUI_Ruler.addBtn(10, 90, 60, 25, "b", addFrm);
    static final JButton d = GUI_Ruler.addBtn(15, 160, 60, 25, "d", addFrm);
    static final JButton This = GUI_Ruler.addBtn(15, 160, 60, 25, "ð", addFrm);
    static final JButton jam = GUI_Ruler.addBtn(15, 160, 60, 25, "dʒ", addFrm);
    static final JButton sh = GUI_Ruler.addBtn(15, 160, 60, 25, "ʃ", addFrm);
    static final JButton f = GUI_Ruler.addBtn(15, 160, 60, 25, "f", addFrm);
    static final JButton g = GUI_Ruler.addBtn(15, 160, 60, 25, "g", addFrm);
    static final JButton h = GUI_Ruler.addBtn(15, 160, 60, 25, "h", addFrm);
    static final JButton j = GUI_Ruler.addBtn(15, 160, 60, 25, "j", addFrm);
    static final JButton k = GUI_Ruler.addBtn(15, 160, 60, 25, "k", addFrm);
    static final JButton l = GUI_Ruler.addBtn(15, 160, 60, 25, "l", addFrm);
    static final JButton m = GUI_Ruler.addBtn(15, 160, 60, 25, "m", addFrm);
    static final JButton n = GUI_Ruler.addBtn(15, 160, 60, 25, "n", addFrm);
    static final JButton ng = GUI_Ruler.addBtn(15, 160, 60, 25, "ŋ", addFrm);
    static final JButton p = GUI_Ruler.addBtn(15, 160, 60, 25, "p", addFrm);
    static final JButton r = GUI_Ruler.addBtn(15, 160, 60, 25, "r", addFrm);
    static final JButton s = GUI_Ruler.addBtn(15, 160, 60, 25, "s", addFrm);
    static final JButton t = GUI_Ruler.addBtn(15, 160, 60, 25, "t", addFrm);
    static final JButton x = GUI_Ruler.addBtn(15, 160, 60, 25, "x", addFrm);
    static final JButton tsh = GUI_Ruler.addBtn(15, 160, 60, 25, "tʃ", addFrm);
    static final JButton v = GUI_Ruler.addBtn(15, 160, 60, 25, "v", addFrm);
    static final JButton w = GUI_Ruler.addBtn(15, 160, 60, 25, "w", addFrm);
    static final JButton z = GUI_Ruler.addBtn(15, 160, 60, 25, "z", addFrm);
    static final JButton ga = GUI_Ruler.addBtn(15, 160, 60, 25, "ʒ", addFrm);
    static final JButton th = GUI_Ruler.addBtn(15, 160, 60, 25, "θ", addFrm);
    static final JButton u_ = GUI_Ruler.addBtn(15, 160, 60, 25, "uː", addFrm);
    static final JButton i_ = GUI_Ruler.addBtn(15, 160, 60, 25, "iː", addFrm);
    static final JButton a_reversed = GUI_Ruler.addBtn(15, 160, 60, 25, "ɒː", addFrm);
    static final JButton E_reversed = GUI_Ruler.addBtn(15, 160, 60, 25, "ɜː", addFrm);
    static final JButton c_reversed = GUI_Ruler.addBtn(15, 160, 60, 25, "ɔː", addFrm);
    static final JButton a_ = GUI_Ruler.addBtn(15, 160, 60, 25, "ɑː", addFrm);
    static final JButton I = GUI_Ruler.addBtn(15, 160, 60, 25, "I", addFrm);
    static final JButton i = GUI_Ruler.addBtn(15, 160, 60, 25, "i", addFrm);
    static final JButton e = GUI_Ruler.addBtn(15, 160, 60, 25, "e", addFrm);
    static final JButton eReversed = GUI_Ruler.addBtn(15, 160, 60, 25, "ə", addFrm);
    static final JButton u = GUI_Ruler.addBtn(15, 160, 60, 25, "u", addFrm);
    static final JButton A = GUI_Ruler.addBtn(15, 160, 60, 25, "ʌ", addFrm);
    static final JButton aReversed = GUI_Ruler.addBtn(15, 160, 60, 25, "ɒ", addFrm);
    static final JButton ae = GUI_Ruler.addBtn(15, 160, 60, 25, "æ", addFrm);
    static final JButton pot = GUI_Ruler.addBtn(15, 160, 60, 25, "ʊ", addFrm);
    static final JButton aI = GUI_Ruler.addBtn(15, 160, 60, 25, "aI", addFrm);
    static final JButton eI = GUI_Ruler.addBtn(15, 160, 60, 25, "eI", addFrm);
    static final JButton apot = GUI_Ruler.addBtn(15, 160, 60, 25, "aʊ", addFrm);
    static final JButton eReversedpot = GUI_Ruler.addBtn(15, 160, 60, 25, "əʊ", addFrm);
    static final JButton ieReversed = GUI_Ruler.addBtn(15, 160, 60, 25, "iə", addFrm);
    static final JButton IeReversed = GUI_Ruler.addBtn(15, 160, 60, 25, "Iə", addFrm);
    static final JButton eeReversed = GUI_Ruler.addBtn(15, 160, 60, 25, "eə", addFrm);
    static final JButton poteReversed = GUI_Ruler.addBtn(15, 160, 60, 25, "ʊə", addFrm);
    static final JButton opot = GUI_Ruler.addBtn(15, 160, 60, 25, "Iʊ", addFrm);
    static final JButton cReversedI = GUI_Ruler.addBtn(15, 160, 60, 25, "ɔI", addFrm);
    static final JLabel englishl = GUI_Ruler.addLbl(60, 10, 100, 40, "English", addFrm);
    static final JLabel phonen1 = GUI_Ruler.addLbl(10, 10, 100, 40, "Phonens", addFrm);
    static final JTextArea englisht = GUI_Ruler.addtxt(40, 15, 200, 40, "", addFrm);
    static final JTextArea phonent = GUI_Ruler.addtxt(10, 15, 200, 40, "", addFrm);
    static final JButton action = GUI_Ruler.addBtn(15, 160, 120, 25, "Add", addFrm);

    public static void main(String[] args) throws IOException {

        Phonen_Data.intial("words.txt");

        //to change messege font size
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("WinSoft Thuluth", Font.BOLD, 15)));

        //add frame install
        GUI_Ruler.makeVertical(6, englishl, englisht, b, m, This, u_, A, apot);
        GUI_Ruler.makeHorizontal(100, englishl, phonen1);
        GUI_Ruler.makeHorizontal(20, englisht, phonent, action);
        GUI_Ruler.makeHorizontal(6, b, d, f, g, h, l, j, k, p);
        GUI_Ruler.makeHorizontal(6, m, n, r, s, t, v, x, w, z);
        GUI_Ruler.makeHorizontal(6, This, ga, jam, ng, sh, th, tsh);
        GUI_Ruler.makeHorizontal(6, u_, a_, a_reversed, E_reversed, c_reversed, i_);
        GUI_Ruler.makeHorizontal(6, A, I, i, u, ae, e, eReversed, pot, aReversed);
        GUI_Ruler.makeHorizontal(6, apot, aI, eI, eReversedpot, eeReversed, IeReversed, ieReversed, poteReversed, opot, cReversedI);

        //organize main frame
        GUI_Ruler.makeVertical(15, testBtn, AddBtn, SearchBtn, exitBtn);
        GUI_Ruler.makeHorizontal(15, SearchBtn, text);

        //searchframe design
        JList<String> list = new JList();
        list.setForeground(Color.black);
        list.setBackground(Color.WHITE);
        list.setFont(new Font("Segoe UI", Font.BOLD, 14));
        list.repaint();
        JScrollPane mp = new JScrollPane(list);
        mp.setBounds(15, 10, 250, 145);
        searchFrm.add(mp, 0);
        DefaultListModel missionModel = new DefaultListModel();
        list.setModel(missionModel);

        Phonen_Data.totalGet(phonent, b, d, f, g, h, l, j, k, p,m, n, r, s, t, v, x, w, z,This, ga, jam, ng, sh, th, tsh,u_, a_, a_reversed, E_reversed, c_reversed, i_, A, I, i, u, ae, e, eReversed, pot, aReversed,apot, aI, eI, eReversedpot, eeReversed, IeReversed, ieReversed, poteReversed, opot, cReversedI);
        
         delete.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {

               Phonen_Data.multiDelete(Integer.parseInt(list.getSelectedValue().trim().split(" ")[0].trim()));
                missionModel.remove(list.getSelectedIndex());

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
       
        
        exitBtn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                int confirm = JOptionPane.showConfirmDialog(null, "Do you want to save all changes!", "Peace be upon you:-", JOptionPane.INFORMATION_MESSAGE);
                switch (confirm) {
                    case 0:
                        //save data close
                        try {
                            Phonen_Data.save("words.txt");

                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Error, changes are not saved!", "Warning", JOptionPane.INFORMATION_MESSAGE);
                        }

                        //end  
                        System.exit(0);
                        break;
                    case 1:
                        // close without saving
                        System.exit(0);
                        break;

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

        SearchBtn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                // check first there are some results
                if (text.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Text box is empty!", "Information!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    missionModel.clear();

                    for (int i = 0; i < Phonen_Data.english.size(); i++) {
                        if (Phonen_Data.english.get(i).toLowerCase().contains(text.getText().trim().toLowerCase())) {
                            missionModel.addElement(i + " - " + Phonen_Data.english.get(i) + " -------- " + Phonen_Data.phonen.get(i));
                        }
                    }
                    if (!missionModel.isEmpty()) {
                        addFrm.setVisible(false);
                        searchFrm.setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(null, "The word is not found!", "Information!", JOptionPane.INFORMATION_MESSAGE);
                    }

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

        AddBtn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                addFrm.setVisible(true);
                searchFrm.setVisible(false);
                addFrm.setTitle("Add new phonen!");
                action.setText("Add");
                englishl.setText("English");
                englisht.setText("");
                phonen1.setText("Phonen");
                phonent.setText("");

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

        testBtn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                addFrm.setVisible(true);
                searchFrm.setVisible(false);
                addFrm.setTitle("Quiz!");
                action.setText("Next");
                Phonen_Data.clear();
                Phonen_Data.newQuiz(addFrm , englishl, englisht,phonent);
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

        action.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                if (action.getText().equals("Add")) {
                    if (englisht.getText().trim().isEmpty() || phonent.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "fill in the word", "Information!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        Phonen_Data.multiAdd(englisht.getText(), phonent.getText());
                        englisht.setText("");
                        phonent.setText("");

                    }}
                else if (action.getText().equals("Next"))
                    {
                      if(Phonen_Data.target)      
                      {Phonen_Data.newQuiz(addFrm , englishl, englisht,phonent);}
                        else
                      {
                      Phonen_Data.check(englishl, englisht);
                      }
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

}
