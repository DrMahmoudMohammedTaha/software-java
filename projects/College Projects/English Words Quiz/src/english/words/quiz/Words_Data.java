/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package english.words.quiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.Timer;

public final class Words_Data {

    public static void intial(String path) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(path));

        int lines = Integer.parseInt(br.readLine());

        for (int i = 0; i < lines; i++) {

            String speak = br.readLine();
            english.add(speak.split("•")[0]);
            arabic.add(speak.split("•")[1]);

        }
    }

    public static void multiDelete(int i) {
        english.remove(i);
        arabic.remove(i);
    }

    public static void multiAdd(String eng, String arb) {
        english.add(eng);
        arabic.add(arb);
    }

    public static void quizEnd() {
        clock.stop();
        JOptionPane.showMessageDialog(null, "Your score is : \n" + score + " solved of " + (count - 1) + "\n precentage : " + Math.round(score / (double) (count - 1) * 100.0) + " % ", "Quiz results!", JOptionPane.INFORMATION_MESSAGE);

        String man = "";
        for (int i = 0; i < mistakes.size(); i++) {
            man += english.get(mistakes.get(i)) + "---------" + arabic.get(mistakes.get(i)) + "\n";
        }
        if (!mistakes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Words you did't answer:\n" + man, "Peace be upon you:-", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public static void clear() {
        old.clear();
        mistakes.clear();
        score = 0;
        count = 0;
        seconds = 0;
        clock.stop();
        clock = new Timer(0, null);
    }

    public static void quizLevel1(JFrame frm ,JLabel time, JLabel what, JLabel word, JButton choice1, JButton choice2) {
        int i = newInt(frm);
        count++;
        old.add(i);
        what.setText(count + " - what the meaning of:-");
        word.setText(english.get(i));
        randomBtn(choice1, choice2, arabic.get(i));
        setTimer1(frm , time, what, word, choice1, choice2);
    }

    public static void quizLevel2(JFrame frm ,JLabel time, JLabel what, JLabel word, JButton next, JButton yes, JButton no) {

        int i = newInt(frm);
        count++;
        what.setText(count + " - what the meaning of:-");
        old.add(i);
        word.setText(english.get(i));
        setTimer2(frm  ,time, what, word, next, yes, no);
    }

    public static void save(String path) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        bw.append(english.size() + "");
        bw.newLine();
        for (int i = 0; i < english.size(); i++) {
            bw.append(english.get(i) + "•" + arabic.get(i) + " ");
            bw.newLine();
        }
        bw.close();
    }

    public static void randomBtn(JButton x1, JButton x2, String s1) {

        String s2 = arabic.get(new Random().nextInt(arabic.size()));
        if (new Random().nextBoolean()) {
            x1.setText(s1);
            x2.setText(s2);
        } else {
            x1.setText(s2);
            x2.setText(s1);
        }
    }

    public static int newInt(JFrame frm) {
        int i = 0;
        if (old.size() == english.size()) {
         
            JOptionPane.showMessageDialog(null, "No more data in the database!", "Warning!", JOptionPane.INFORMATION_MESSAGE);
            Words_Data.quizEnd();
            frm.setVisible(false);
        } else {

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

    public static void setTimer1(JFrame frm ,JLabel time, JLabel what, JLabel word, JButton choice1, JButton choice2) {
        clock.stop();
        seconds = 0;
        clock = new Timer(1000, null);
        clock.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                time.setText(time.getText().split(" ")[0] + " " + (10 - seconds));
                seconds++;
                if (seconds > 10) {
                    Words_Data.mistakes.add(Words_Data.old.get(Words_Data.old.size() - 1));
                    Words_Data.quizLevel1(frm ,time, what, word, choice1, choice2);
                }
            }
        });
        clock.start();
    }

    public static void setTimer2(JFrame frm , JLabel time, JLabel what, JLabel word, JButton next, JButton yes, JButton no) {

        clock.stop();
        seconds = 0;
        clock = new Timer(1000, null);
        clock.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                time.setText(time.getText().split(" ")[0] + " " + (10 - seconds));
                seconds++;
                if (seconds > 10) {
                    Words_Data.mistakes.add(Words_Data.old.get(Words_Data.old.size() - 1));
                    next.setVisible(true);
                    yes.setVisible(false);
                    no.setVisible(false);
                    what.setText("What the meaning of:-");
                    Words_Data.quizLevel2(frm , time, what, word, next, yes, no);
                }

            }
        });
        clock.start();
    }

    static ArrayList<String> english = new ArrayList();
    static ArrayList<String> arabic = new ArrayList();
    static ArrayList<Integer> old = new ArrayList();
    static ArrayList<Integer> mistakes = new ArrayList();
    static int score, count, seconds;
    static Timer clock = new Timer(0, null);

}
