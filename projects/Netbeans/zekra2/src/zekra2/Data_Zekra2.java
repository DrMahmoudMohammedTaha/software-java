package zekra2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.HijrahChronology;
import java.time.chrono.HijrahDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.regex.PatternSyntaxException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class Data_Zekra2 {

    public static final String HigriMonth[] = {"محرم", "صفر", "ربيع اول", "ربيع اخر", "جمادى اول", "جمادى اخر", "رجب", "شعبان", "رمضان", "شوال", "ذى القعدة", "ذى الحجة"};
    public static final String name[] = {"muslim", "bokhari", "trmzi", "nesaai", "maga", "dawd", "moataa", "saleh"};
    public static final String title[] = {"مسلم", "البخارى", "الترمذى", "النسائى", "ابن ماجه", "ابن داود", "الموطأ", "رياض الصالحين"};

    static ArrayList<String> hkma = new ArrayList();
    static ArrayList<String> zekr = new ArrayList();
    static String important = "";
    static Timer clock = new Timer(0, null);
    static Timer tempo = new Timer(0, null);
    static private int period;
    static String paradise;
    static boolean tempoState = false;

    public static JLabel background;

    public static String getHigriDate() {

        Calendar cl = Calendar.getInstance();
        cl.setTime(new Date());
        HijrahDate islamyDate = HijrahChronology.INSTANCE.date(LocalDate.of(cl.get(Calendar.YEAR), cl.get(Calendar.MONTH) + 1, cl.get(Calendar.DATE)));
        return islamyDate.toString().split(" ")[2];
    }

    public static double[] convertToDouble(int[] x, int[] y) {
        double z[] = new double[x.length];
        for (int i = 0; i < z.length; i++) {
            z[i] = Double.parseDouble(x[i] + "." + y[i]);
        }
        return z;

    }

    static double degToRad(double degree) {
        return ((3.1415926 / 180) * degree);
    }
//convert Radian to Degree

    static double radToDeg(double radian) {
        return (radian * (180 / 3.1415926));
    }
//make sure a value is between 0 and 360

    static double moreLess360(double value) {
        while (value > 360 || value < 0) {
            if (value > 360) {
                value -= 360;
            } else if (value < 0) {
                value += 360;
            }
        }

        return value;
    }
//make sure a value is between 0 and 24

    static double moreLess24(double value) {
        while (value > 24 || value < 0) {
            if (value > 24) {
                value -= 24;
            } else if (value < 0) {
                value += 24;
            }
        }

        return value;
    }

    public static String getFajrTime() {

        final int timeZone = 2;
        final double longitude = 30.2, latitude = 30, fajrTwilight = -19.5, ishaTwilight = -17.5;
        int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date())), month = Integer.parseInt(new SimpleDateFormat("MM").format(new Date())), day = Integer.parseInt(new SimpleDateFormat("dd").format(new Date())), hours = Integer.parseInt(new SimpleDateFormat("HH").format(new Date())), minutes = Integer.parseInt(new SimpleDateFormat("mm").format(new Date()));
        double fajrTime, zuhrTime;

        double D = (367 * year) - ((year + (int) ((month + 9) / 12)) * 7 / 4) + (((int) (275 * month / 9)) + day - 730531.5);
        double L = 280.461 + 0.9856474 * D;
        L = moreLess360(L);
        double M = 357.528 + (0.9856003) * D;
        M = moreLess360(M);
        double Lambda = L + 1.915 * Math.sin(degToRad(M)) + 0.02 * Math.sin(degToRad(2 * M));
        Lambda = moreLess360(Lambda);
        double Obliquity = 23.439 - 0.0000004 * D;
        double Alpha = radToDeg(Math.atan((Math.cos(degToRad(Obliquity)) * Math.tan(degToRad(Lambda)))));
        Alpha = moreLess360(Alpha);
        Alpha = Alpha - (360 * (int) (Alpha / 360));
        Alpha = Alpha + 90 * (Math.floor(Lambda / 90) - Math.floor(Alpha / 90));
        double ST = 100.46 + 0.985647352 * D;
        double Dec = radToDeg(Math.asin(Math.sin(degToRad(Obliquity)) * Math.sin(degToRad(Lambda))));
        double Durinal_Arc = radToDeg(Math.acos((Math.sin(degToRad(-0.8333)) - Math.sin(degToRad(Dec)) * Math.sin(degToRad(latitude))) / (Math.cos(degToRad(Dec)) * Math.cos(degToRad(latitude)))));
        double Noon = Alpha - ST;
        Noon = moreLess360(Noon);
        double UT_Noon = Noon - longitude;

        // 2) Zuhr Time [Local noon]
        zuhrTime = UT_Noon / 15 + timeZone;

        double Fajr_Arc = radToDeg(Math.acos((Math.sin(degToRad(fajrTwilight)) - Math.sin(degToRad(Dec)) * Math.sin(degToRad(latitude))) / (Math.cos(degToRad(Dec)) * Math.cos(degToRad(latitude)))));
        fajrTime = zuhrTime - (Fajr_Arc / 15);

        return new DecimalFormat("00").format(fajrTime) + ":" + new DecimalFormat("00").format((fajrTime % 1) * 60);
    }

    public static boolean compareDate(String s) {

        int nowh = Integer.parseInt(new SimpleDateFormat("HH").format(new Date()));
        int nowm = Integer.parseInt(new SimpleDateFormat("mm").format(new Date()));
        int hour = Integer.parseInt(s.split(":")[0]);
        int minute = Integer.parseInt(s.split(":")[1]);

        return (hour < nowh || (hour == nowh && minute < nowm));

    }

    public static String getSiam() {

        String dayName = new SimpleDateFormat("EEEE").format(new Date());
        int dayno = Integer.parseInt(getHigriDate().split("-")[2]);
        String message = "استعد للصيام غدا ان شاء الله \n";
        if (((dayName.equals("Sunday") || dayName.contains("حد")) && compareDate(getFajrTime())) || ((dayName.equals("Monday") || dayName.contains("ثنين")) && !compareDate(getFajrTime()))) {
            message += "يوم الاثنين\n";
        } else if (((dayName.equals("Wednesday") || dayName.contains("ربعاء")) && compareDate(getFajrTime())) || ((dayName.equals("Thursday") || dayName.contains("خميس")) && !compareDate(getFajrTime()))) {
            message += "يوم الخميس\n";
        }
        if ((dayno == 11 || dayno == 12 || dayno == 13 || dayno == 14) && compareDate(getFajrTime())) {
            message += "ربما يكون غدا " + (dayno + 1) + " او " + (dayno + 2) + " " + HigriMonth[Integer.parseInt(getHigriDate().split("-")[1]) - 1];
        } else if ((dayno == 12 || dayno == 13 || dayno == 14 || dayno == 15) && !compareDate(getFajrTime())) {
            message += "ربما يكون غدا " + (dayno) + " او " + (dayno + 1) + " " + HigriMonth[Integer.parseInt(getHigriDate().split("-")[1]) - 1];
        }

        if (message.equals("استعد للصيام غدا ان شاء الله \n")) {
            return "";
        } else {
            return message;
        }
    }

    public static void setPeriod(String path, int p) throws IOException {
        period = p;
        BufferedWriter bf = new BufferedWriter(new FileWriter(path));
        bf.write(p + "");
        bf.newLine();
        bf.append(paradise);
        bf.close();

    }
    /*
     public static String pure(String x) {

     //?
        
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

        
     i = x.indexOf("?");
     while (i != -1) {

     x = new StringBuffer(x).deleteCharAt(i).toString();
     i = x.indexOf("?");
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
     */

    public static void intial(String path1, String path2, String path3) throws FileNotFoundException, IOException {

        BufferedReader br = new BufferedReader(new FileReader(path1));
        br.readLine(); // this for the  dot in the start of the notepad
        String good;
        good = br.readLine();

        while (!"xxx".trim().equals(good)) {
            important += good + "\n";
            good = br.readLine();
        }
        br.close();
        br = new BufferedReader(new FileReader(path2));
        period = Integer.parseInt(br.readLine());
        paradise = br.readLine();
        br.close();

        br = new BufferedReader(new FileReader(path3));
        int constant = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < constant; i++) {
            hkma.add("");

            String sum = "";
            String x = br.readLine();
            while (!x.equals("###")) {
                sum += x + "\n";
                x = br.readLine();
            }
            hkma.set(i, sum);

        }
        br.close();

    }

    public static void showZkr(JFrame zkrframe, JTextArea text, JButton b, JButton b1) throws ClassNotFoundException, IOException {

        int target = new Random().nextInt(8);
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("h_" + name[target] + ".txt"));
        zekr = (ArrayList< String>) input.readObject();
        input.close();
        String holder = "لا حديث";
        if (target == 1) {

            while (holder.contains("لا حديث") || !(holder.contains("تحفة") || holder.contains("أطرافه") || holder.contains("طرفاه") || holder.contains("طرفه")) || holder.length() < 200) {
                holder = zekr.get(new Random().nextInt(zekr.size()));

            }

            holder = holder.replaceAll("تحفة", "").replaceAll("أطرافه", "").replaceAll("طرفاه", "").replaceAll("طرفه", "").replaceAll("   ", "").replaceAll("/", "").replaceAll(".،", ".").replaceAll("\\(.", "");

            String holding[] = holder.split(" ");

            if (holding[holding.length - 1].equals("باب")) {
                holder = "";

                for (int i = 0; i < holding.length - 2; i++) {
                    if (!holding[i].equals(freeTashkeel(holding[i]))) {
                        holder += holding[i] + " ";
                    }

                }
            }

        } else {
            while (holder.contains("لا حديث") || holder.length() < 100) {
                holder = zekr.get(new Random().nextInt(zekr.size()));

            }
        }
        if (target == 7) {
            holder = arrangehdith(holder).replaceAll("", "");
        } else {
            try {
                holder = holder.split("-")[0] + "\n" + holder.replaceFirst(holder.split("-")[0], "").replaceAll("-", "").trim().replaceAll("Y", "");
            } catch (PatternSyntaxException e) {
                holder = holder.replaceAll("\\(", "").replaceAll("\\)", "");
                holder = holder.split("-")[0] + "\n" + holder.replaceFirst(holder.split("-")[0], "").replaceAll("-", "").trim().replaceAll("Y", "");
            }

        }

        text.setText(title[target] + "\n" + holder + "\n---------------\n" + getSiam() + gethome());
        text.setCaretPosition(0);
        text.setEditable(false);

        try {

            b.setText("اضف لقائمتى");
            zkrframe.remove(background);
            BufferedImage img = ImageIO.read(new File((target + 1) + ".jpg"));
            background = new JLabel(new ImageIcon(img));
            background.setBounds(0, 0, zkrframe.getWidth(), zkrframe.getHeight());

            background.repaint();
            zkrframe.add(background);
            text.repaint();
            b.repaint();
            b1.repaint();
            zkrframe.repaint();
            zkrframe.setVisible(true);

        } catch (IOException ex) {
        }

        zekr.clear();

    }

    public static void showhkma(JFrame hkmaframe, JTextArea text, JButton b) {

        if (new Random().nextInt(8) == 0 || hkma.isEmpty() ) {
           ZEKRA2.showImage();
        } else {
            text.setEditable(false);
            hkmaframe.setVisible(true);
            b.setText("اضف لقائمتى");

            text.setText(hkma.get(new Random().nextInt(hkma.size())) + "\n---------------\n" + getSiam() + gethome());
            text.setCaretPosition(0);
        }
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
        x += (char) (1569);
        for (int i = 0; i < sbuild.length(); i++) {

            if (!x.contains(sbuild.charAt(i) + "")) {
                sbuild.delete(i, i + 1);
            }

        }

        return sbuild.toString();
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

    public static String arrange(String s) {

        String[] g = s.trim().split(" ");
        s = "";
        String max = "";
        for (int i = 0; i < g.length; i++) {
            if (freeTashkeel(max + " " + g[i]).length() > 47) {
                s += " " + max + "\n";
                max = "";
            }
            max += g[i] + " ";
        }
        s += " " + max;
        return s;
    }

    public static String arrangehdith(String s) {
        String x = s.trim().split(" ")[0];
        return "حديث رقم \n" + x.split("-")[0] + "\n" + s.replaceAll(x, "");
    }

    public static void temporaryTimer(int time) {
        tempoState = true;
        tempo.stop();
        tempo = new Timer(0, null);

        tempo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                if (tempoState) {
                    clock.stop();
                    tempo.setDelay(time * 1000 * 60);
                    tempoState = false;
                } else {
                    clock.start();
                    tempo.stop();

                }

            }
        });
        tempo.start();

    }

    public static void startTimer(JFrame zkrframe, JTextArea text, JButton b, JButton b1, JFrame hkmaFrm, JTextArea hkmatext, JButton hkmaimportant) {
        clock.stop();
        clock = new Timer(period * 60 * 1000, null);
        clock.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (new Random().nextInt() % 8 != 0 ) {
                    try {
                        showZkr(zkrframe, text, b, b1);
                    } catch (ClassNotFoundException ex) {
                    } catch (IOException ex) {
                    }
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
            while (hkma.get(i).contains("\n###\n")) {
                hkma.set(i, hkma.get(i).replaceFirst("###", "***"));
            }
        }

        for (String hkma1 : hkma) {
            bf.append(hkma1);
            bf.newLine();
            bf.append("###");
            bf.newLine();
        }
        bf.close();
    }

    public static void paradise() throws IOException {
        paradise = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        setPeriod("time.txt", period);
    }

    private static String gethome() {

        if (paradise.equals(new SimpleDateFormat("yyyy/MM/dd").format(new Date()))) {
            return "\nلا تنس بناء بيت فى الجنة";
        } else {
            return "";
        }

    }

}
