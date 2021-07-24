package english.words.quiz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class EnglishWordsQuiz {

    //main frame design
    static final JFrame mainFrame = GUI_Ruler.addFrm(true, false, 200, 100, 410, 370, "English Work Quize", (new Random().nextInt(5) + 1) + ".jpg", true);
    static final JButton testBtn = GUI_Ruler.addBtn(15, 10, 250, 50, "Start new Quiz", mainFrame);
    static final JButton AddBtn = GUI_Ruler.addBtn(15, 10, 250, 50, "Add new word", mainFrame);
    static final JButton SearchBtn = GUI_Ruler.addBtn(15, 10, 120, 50, "Search", mainFrame);
    static final JButton exitBtn = GUI_Ruler.addBtn(15, 10, 120, 50, "Exit", mainFrame);
    static final JTextArea text = GUI_Ruler.addtxt(10, 10, 200, 40, "", mainFrame);
    static final JCheckBox ch1 = GUI_Ruler.addchk(10, 10, 100, 40, "Level 1", mainFrame);
    static final JCheckBox ch2 = GUI_Ruler.addchk(10, 10, 100, 40, "Level 2", mainFrame);

    
    //quiz frame
    static final JFrame quizFrm = GUI_Ruler.addFrm(false, false, 700, 100, 460, 330, "Quiz!", (new Random().nextInt(5) + 1) + ".jpg", false);
    public static void main(String[] args) throws FileNotFoundException, IOException {

        
        
        Words_Data.intial("words.txt");
        
        
        
        //to change messege font size
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("WinSoft Thuluth", Font.BOLD, 15)));

        //organize main frame
        ch1.setSelected(true);
        GUI_Ruler.makeVertical(testBtn, AddBtn, SearchBtn, exitBtn);
        GUI_Ruler.makeHorizontal(SearchBtn, text);
        GUI_Ruler.makeHorizontal(testBtn, ch1);
        GUI_Ruler.makeHorizontal(AddBtn, ch2);
        GUI_Ruler.makeVertical(ch1, ch2);

        // add frame design
        JFrame addFrm = GUI_Ruler.addFrm(false, false, 700, 100, 330, 250, "Add a word!", (new Random().nextInt(5) + 1) + ".jpg", false);
        JTextArea englisht = GUI_Ruler.addtxt(10, 15, 200, 40, "", addFrm);
        JTextArea arabict = GUI_Ruler.addtxt(10, 15, 200, 40, "", addFrm);
        englisht.setFont(new Font("Segoe UI", Font.BOLD, 18));
        arabict.setFont(new Font("Segoe UI", Font.BOLD, 18));
        JButton add2Btn = GUI_Ruler.addBtn(15, 10, 100, 50, "Add", addFrm);
        JLabel englishl = GUI_Ruler.addLbl(10, 10, 100, 40, "English", addFrm);
        JLabel arabicl = GUI_Ruler.addLbl(10, 10, 100, 40, "العربية", addFrm);
        GUI_Ruler.makeVertical(englisht, arabict, add2Btn);
        GUI_Ruler.makeHorizontal(englisht, englishl);
        GUI_Ruler.makeHorizontal(arabict, arabicl);

        //searchframe design
        JFrame searchFrm = GUI_Ruler.addFrm(false, false, 700, 100, 330, 250, "Search results!", (new Random().nextInt(5) + 1) + ".jpg", false);
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
        JButton delete = GUI_Ruler.addBtn(15, 160, 100, 45, "Delete", searchFrm);

        // quizframe design
        JLabel what = GUI_Ruler.addLbl(10, 10, 400, 40, "What the meaning of:- ", quizFrm);
        JLabel word = GUI_Ruler.addLbl(10, 10, 400, 40, "the word", quizFrm);
        JLabel time = GUI_Ruler.addLbl(10, 10, 400, 40, "Time: ...", quizFrm);
        what.setForeground(Color.BLACK);
        word.setForeground(Color.BLACK);
        time.setForeground(Color.BLACK);
        what.setFont(new Font("Segoe UI", Font.BOLD, 20));
        word.setFont(new Font("Segoe UI", Font.BOLD, 20));
        JButton choice1 = GUI_Ruler.addBtn(30, 160, 200, 45, "choice1", quizFrm);
        JButton choice2 = GUI_Ruler.addBtn(15, 160, 200, 45, "choice1", quizFrm);
        JButton yes = GUI_Ruler.addBtn(30, 170, 200, 45, "Ok", quizFrm);
        JButton no = GUI_Ruler.addBtn(15, 170, 200, 45, "missed it", quizFrm);
        choice1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        choice2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        JButton exit = GUI_Ruler.addBtn(10, 160, 140, 45, "End Exam", quizFrm);
        JButton next = GUI_Ruler.addBtn(180, 160, 100, 45, "Next", quizFrm);
        GUI_Ruler.makeVertical( what, word, time,choice1, exit);
        GUI_Ruler.makeVertical( what, word,time, yes, exit);
        GUI_Ruler.makeHorizontal(exit, next);
        GUI_Ruler.makeHorizontal(choice1, choice2);
        GUI_Ruler.makeHorizontal(yes, no);

        exit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                Words_Data.quizEnd();
                quizFrm.setVisible(false);
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
        choice1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (Words_Data.arabic.get(Words_Data.old.get(Words_Data.old.size() - 1)).equals(choice1.getText())) {
                    Words_Data.score++;
                } else {
                    Words_Data.mistakes.add(Words_Data.old.get(Words_Data.old.size() - 1));
                }

                Words_Data.quizLevel1(quizFrm , time , what ,word, choice1, choice2);

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
        choice2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (Words_Data.arabic.get(Words_Data.old.get(Words_Data.old.size() - 1)).equals(choice2.getText())) {
                    Words_Data.score++;
                } else {
                    Words_Data.mistakes.add(Words_Data.old.get(Words_Data.old.size() - 1));
                }

                Words_Data.quizLevel1(quizFrm , time ,what, word, choice1, choice2);

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
                what.setText("The right meaning is:- ");
                word.setText(Words_Data.arabic.get(Words_Data.old.get(Words_Data.old.size() - 1)));
                yes.setVisible(true);
                no.setVisible(true);
                next.setVisible(false);
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
        no.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {

                Words_Data.mistakes.add(Words_Data.old.get(Words_Data.old.size() - 1));
                next.setVisible(true);
                yes.setVisible(false);
                no.setVisible(false);
                what.setText("What the meaning of:-");
                Words_Data.quizLevel2(quizFrm , time ,what , word,next , yes ,no);
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
        yes.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {

                Words_Data.score++;
                next.setVisible(true);
                yes.setVisible(false);
                no.setVisible(false);
                what.setText("What the meaning of:-");
                Words_Data.quizLevel2(quizFrm , time ,what , word,next , yes ,no);

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
        delete.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {

                Words_Data.multiDelete(Integer.parseInt(list.getSelectedValue().trim().split(" ")[0].trim()));
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
        add2Btn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {

                if (englisht.getText().isEmpty() || arabict.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter full data!", "Information!", JOptionPane.INFORMATION_MESSAGE);
                } else {

                    Words_Data.multiAdd(englisht.getText(), arabict.getText());
                    englisht.setText("");
                    arabict.setText("");
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
        testBtn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                searchFrm.setVisible(false);
                addFrm.setVisible(false);
                quizFrm.setVisible(true);
                Words_Data.clear();
                next.setVisible(!ch1.isSelected());
                choice1.setVisible(ch1.isSelected());
                choice2.setVisible(ch1.isSelected());
                yes.setVisible(false);
                no.setVisible(false);
                if (ch1.isSelected()) {
                    Words_Data.quizLevel1( quizFrm , time ,what ,word, choice1, choice2);
                } else {
                    Words_Data.quizLevel2(quizFrm , time ,what , word,next , yes ,no);
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
                if (text.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Text box is empty!", "Information!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    missionModel.clear();

                    for (int i = 0; i < Words_Data.english.size(); i++) {
                        if (Words_Data.english.get(i).toLowerCase().contains(text.getText().trim().toLowerCase())) {
                            missionModel.addElement(i + " - " + Words_Data.english.get(i) + " -------- " + Words_Data.arabic.get(i));
                        }
                    }
                    if (!missionModel.isEmpty()) {
                        quizFrm.setVisible(false);
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
                quizFrm.setVisible(false);
                searchFrm.setVisible(false);
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
                            Words_Data.save("words.txt");
                        
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
        ch1.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                GUI_Ruler.oneChecked(ch1, ch2);
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
        ch2.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                GUI_Ruler.oneChecked(ch2, ch1);
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
