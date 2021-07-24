package phonetics.quiz;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Phonen_Data {

    public static String decode(String target)
    {
    String hold []= target.trim().split("#");
    String data = "" ;
        for (int i = 0; i < hold.length; i++) {
            data +=(char) Integer.parseInt(hold[i]);
        }
    return data;
    }
    public static void intial(String path) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(path));
        int lines = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < lines; i++) {
            String speak = br.readLine();
            english.add(speak.split("•")[0]);
            phonen.add(decode(speak.split("•")[1]));

        }

    }

    public static void multiDelete(int i) {
        english.remove(i);
        phonen.remove(i);
    }

    public static void getBtnTxt(JButton btn, JTextArea txt) {
        btn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                txt.setText(txt.getText() + btn.getText());

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

    public static void totalGet(JTextArea txt, JButton... btns) {
        for (JButton jButton : btns) {
            getBtnTxt(jButton, txt);
        }
    }

    public static void multiAdd(String eng, String arb) {
        english.add(eng);
        phonen.add(arb);
    }

    public static void clear() {
        old.clear();
        target = true;
    }

    public static void newQuiz(JFrame frm ,JLabel what, JTextArea word,JTextArea ans) {
        int i = newInt(frm);
        target = false;
        old.add(i);
        ans.setText("");
        what.setText("Word");
        word.setText(english.get(i));
    }

    public static void check(JLabel what,  JTextArea word) {
        target = true;
        what.setText("answer");
        word.setText(phonen.get(old.get(old.size()-1)));
        
    }
    public static String code(String target)
            
    {
    String holder = "" ;
        for (int i = 0; i < target.length(); i++) {
            holder += (int) target.charAt(i) + "#";
        }
    return holder;
    }
    public static void save(String path) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        bw.append(english.size() + "");

        bw.newLine();
        for (int i = 0; i < english.size(); i++) {
            bw.append(english.get(i) + "•" + code(phonen.get(i)) + " ");
            bw.newLine();
        }
        bw.close();
    }

    public static int newInt(JFrame frm ) {
        int i = 0;
        if(old.size() == english.size())
        {
            JOptionPane.showMessageDialog(null, "No more data in the database!","Warning!",JOptionPane.INFORMATION_MESSAGE);
            frm.setVisible(false);
        }
        else
        {
        while (true) {

            i = new Random().nextInt(english.size());
            boolean check = true;
            for (int j = 0; j < old.size(); j++) {
                if (old.get(j).equals(i)) {
                    check = false;
                    break;
                }
            }
            if (check) {

                break;
            }

        }
        }
        return i;
    }

    static ArrayList<String> english = new ArrayList();
    static ArrayList<String> phonen = new ArrayList();
    static ArrayList<Integer> old = new ArrayList();
    static boolean target;
}
