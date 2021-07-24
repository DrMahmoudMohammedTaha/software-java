package zekra2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.HijrahChronology;
import java.time.chrono.HijrahDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class Data_Zekra2 {

    public static final String HigriMonth[] = {"محرم", "صفر", "ربيع اول", "ربيع اخر", "جمادى اول", "جمادى اخر", "رجب", "شعبان", "رمضان", "شوال", "ذى القعدة", "ذى الحجة"};

    static ArrayList<String> hkma = new ArrayList();
    static ArrayList<String> zekr = new ArrayList();
    static String important = "";
    static Timer clock = new Timer(0, null);
    static private int period, choice;
    static String paradise;

    public static String getHigriDate() {

        Calendar cl = Calendar.getInstance();
        cl.setTime(new Date());
        HijrahDate islamyDate = HijrahChronology.INSTANCE.date(LocalDate.of(cl.get(Calendar.YEAR), cl.get(Calendar.MONTH) + 1, cl.get(Calendar.DATE)));
        return islamyDate.toString().split(" ")[2];
    }

    public static String getSiam() {

        String dayName = new SimpleDateFormat("EEEE").format(new Date());
        int dayno = Integer.parseInt(getHigriDate().split("-")[2]);
        String message = "استعد للصيام غدا ان شاء الله \n";
        if (dayName.equals("Sunday") || dayName.contains("حد")) {
            message += "يوم الاثنين\n";
        } else if (dayName.equals("Wednesday") || dayName.contains("ربعاء")) {
            message += "يوم الخميس\n";
        }
        if (dayno == 11 || dayno == 12 || dayno == 13 || dayno == 14) {
            message += "ربما يكون غدا " + (dayno + 1) + " او " + (dayno + 2) + " " + HigriMonth[Integer.parseInt(getHigriDate().split("-")[1]) - 1];
        }

        if (message.equals("استعد للصيام غدا ان شاء الله \n")) {
            return "";
        } else {
            return message;
        }
    }

    public static void setPeriod(String path, int p, int c) throws IOException {
        period = p;
        choice = c;
        BufferedWriter bf = new BufferedWriter(new FileWriter(path));
        bf.write(p + "");
        bf.newLine();
        bf.append(c + "");
        bf.newLine();
        bf.append(paradise);
        bf.close();

    }

    public static String format(String f) {
        String[] s = f.split("\n");
        String cover = "";
        for (int i = 0; i < s.length; i++) {

            cover += s[i] + "&&&";
        }

        return cover;
    }

    public static String adjustclear(String s) {

        String[] g = s.trim().split("<>");
        s = "";
        for (int i = 1; i < g.length; i++) {
            String x[] = g[i].trim().split("\n");
            for (int j = 0; j < x.length; j++) {
                s += x[j] + " ";
            }

            s += "&&&";
        }
        return s;
    }

    public static String clear(String s) {

        String[] g = s.trim().split("&&&");
        s = "";
        for (int i = 0; i < g.length; i++) {
            s += g[i];
        }

        return s;

    }

    public static String pure(String x) {

        int i = x.indexOf("");
        while (i != -1) {

            x = new StringBuffer(x).deleteCharAt(i).toString();
            i = x.indexOf("");
        }
        i = x.indexOf("");
        while (i != -1) {

            x = new StringBuffer(x).deleteCharAt(i).toString();
            i = x.indexOf("");
        }

        i = x.indexOf("()");
        while (i != -1) {

            x = new StringBuffer(x).deleteCharAt(i).toString();
            x = new StringBuffer(x).deleteCharAt(i).toString();
            i = x.indexOf("()");
        }

        i = x.indexOf("");
        while (i != -1) {

            x = new StringBuffer(x).deleteCharAt(i).toString();
            i = x.indexOf("");
        }

        i = x.indexOf("");
        while (i != -1) {

            x = new StringBuffer(x).deleteCharAt(i).toString();
            i = x.indexOf("");
        }

        i = x.indexOf("");
        while (i != -1) {
            x = new StringBuffer(x).deleteCharAt(i).toString();
            i = x.indexOf("");
        }
        i = x.indexOf("");
        while (i != -1) {
            x = new StringBuffer(x).deleteCharAt(i).toString();
            i = x.indexOf("");
        }

        i = x.indexOf("");
        while (i != -1) {

            x = new StringBuffer(x).deleteCharAt(i).toString();
            i = x.indexOf("");
        }

        i = x.indexOf("");
        while (i != -1) {

            x = new StringBuffer(x).deleteCharAt(i).toString();
            i = x.indexOf("");
        }
        return x;
    }

    public static void intial(String path1, String path2, String path3, String path4) throws FileNotFoundException, IOException {

        BufferedReader br = new BufferedReader(new FileReader(path1));
        br.readLine(); // this for the  dot in the start of the notepad
        String good;
        good = br.readLine();

        while (!"xxx".equals(good)) {
            zekr.add(pure(good));
            good = br.readLine();
        }
        br.close();
        br = new BufferedReader(new FileReader(path2));
        good = br.readLine();
        while (!"xxx".trim().equals(good)) {
            important += good + "\n";
            good = br.readLine();
        }
        br.close();
        br = new BufferedReader(new FileReader(path3));
        period = Integer.parseInt(br.readLine());
        choice = Integer.parseInt(br.readLine());

        paradise = br.readLine();
        br.close();

        br = new BufferedReader(new FileReader(path4));
        int constant = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < constant; i++) {
            hkma.add("");
            String x = br.readLine();
            do {

                hkma.set(i, hkma.get(i) + x);
                x = br.readLine();
                if (!x.equals("###")) {
                    hkma.set(i, hkma.get(i) + "\n");
                }
            } while (!x.equals("###"));

        }
        br.close();

    }

    public static void showZkr(JFrame zkrframe, JTextArea text, JButton b) {

        zkrframe.setVisible(true);
        b.setText("اضف للهام");
        text.setText(arrangehdith(zekr.get(new Random().nextInt(zekr.size()))) + "\n---------------\n" + getSiam() + gethome());

    }

    public static void showhkma(JFrame hkmaframe, JTextArea text, JButton b) {

        hkmaframe.setVisible(true);
        b.setText("اضف للهام");

        text.setText(arrangehkma(hkma.get(new Random().nextInt(hkma.size()))) + "\n---------------\n" + getSiam() + gethome());

    }

    public static String hkmasearch(String x) {
        String index = "";

        for (int i = 0; i < hkma.size(); i++) {
            if (freeTashkeel(hkma.get(i)).contains(freeTashkeel(x))) {
                index += " " + i;
            }
        }

        return index;
    }

    public static String freeTashkeel(String s) {

        StringBuilder sbuild = new StringBuilder(s);

        String x = " ";
        for (int i = 1570; i < 1595; i++) {
            x += ((char) (i)) + "";
        }
        for (int i = 1601; i < 1611; i++) {
            x += ((char) (i)) + "";

        }
        for (int i = 0; i < sbuild.length(); i++) {

            if (!x.contains(sbuild.charAt(i) + "")) {
                sbuild.delete(i, i + 1);
            }

        }

        return sbuild.toString();
    }

    public static String arrangehkma(String s) {
        String[] g = s.trim().split("&&&");
        s = "";
        for (int i = 0; i < g.length; i++) {
            if (freeTashkeel(g[i]).length() > 47) {
                s += "<>" + arrange(g[i]) + "\n";
            } else {
                s += "<>" + g[i] + "\n";
            }
        }

        return s;
    }

    public static String arrange(String s) {

        String[] g = s.trim().split(" ");
        s = "";
        String max = "";
        for (int i = 0; i < g.length; i++) {
            if (freeTashkeel(max + " " + g[i]).length() > 47) {
                s += max + "\n";
                max = "";
            }
            max += g[i] + " ";
        }
        s += max;
        return s;
    }

    public static String arrangehdith(String s) {
        String x = s.trim().split(" ")[0];
        return "حديث رقم \n" + x.split("-")[0] + "\n" + arrange(s.replaceAll(x, ""));
    }

    public static void startTimer(JFrame zkrframe, JTextArea text, JButton b, JFrame hkmaFrm, JTextArea hkmatext, JButton hkmaimportant) {
        clock.stop();
        clock = new Timer(period * 60 * 1000, null);
        clock.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (choice == 0 || hkma.isEmpty()) {
                    showZkr(zkrframe, text, b);
                } else if (choice == 1) {
                    showhkma(hkmaFrm, hkmatext, hkmaimportant);
                } else if (new Random().nextInt() % 2 == 0) {
                    showZkr(zkrframe, text, b);
                } else {
                    showhkma(hkmaFrm, hkmatext, hkmaimportant);
                }

            }
        });
        clock.start();
    }

    public static void save(String path1, String path2) throws IOException {

        BufferedWriter bf = new BufferedWriter(new FileWriter(path1));
        String holder[] = important.split("\n");
        bf.write("");
        for (String string : holder) {
            bf.append(string);

            bf.newLine();

        }

        bf.append("xxx");
        bf.close();

        bf = new BufferedWriter(new FileWriter(path2));
        bf.write(hkma.size() + "");
        bf.newLine();
        for (int i = 0; i < hkma.size(); i++) {
            String[] holding = hkma.get(i).split("\n");
            for (int j = 0; j < holding.length; j++) {
                bf.append(holding[j]);
                bf.newLine();
            }
            bf.append("###");
            bf.newLine();
        }
        bf.close();
    }

    public static void paradise() throws IOException {
        paradise = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        setPeriod("time.txt", period, choice);
    }

    private static String gethome() {

        if (paradise.equals(new SimpleDateFormat("yyyy/MM/dd").format(new Date()))) {
            return "\nلا تنس بناء بيت فى الجنة";
        } else {
            return "";
        }

    }

}
