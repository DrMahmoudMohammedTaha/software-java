package manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.HijrahChronology;
import java.time.chrono.HijrahDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

public abstract class Mission_Data {

    public static boolean compare_Date(String s1, String s2) {
        int y1 = Integer.parseInt(s1.split("-")[0]);
        int m1 = Integer.parseInt(s1.split("-")[1]);
        int d1 = Integer.parseInt(s1.split("-")[2]);
        int y2 = Integer.parseInt(s2.split("-")[0]);
        int m2 = Integer.parseInt(s2.split("-")[1]);
        int d2 = Integer.parseInt(s2.split("-")[2]);

        return ((y1 < y2) || (y1 == y2 && m1 < m2) && (y1 == y2 && m1 == m2 && d1 < d2));

    }

    public static void intial(String path1, String path2) throws FileNotFoundException, IOException {
///start
        BufferedReader br = new BufferedReader(new FileReader(path1));

        String blocks[] = br.readLine().split("#");

        noProfile = Integer.parseInt(blocks[0]);

        if (noProfile != 0) {
            for (int i = 1; i < blocks.length; i++) {
                String details[] = blocks[i].split("@");
                ArrayList<String> need = new ArrayList();
                for (int j = 0; j < details.length; j++) {
                    need.add(details[j]);
                }
                folder.add(need);

            }
        }
        br.close();
        br = new BufferedReader(new FileReader(path2));
        Manager.home = br.readLine().equals(new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
        br.close();

///end
    }

    public static void arrangeAmPm(ArrayList<String> s) {

        ArrayList<String> am = new ArrayList();
        ArrayList<String> pm = new ArrayList();
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i).split(" ")[2].equalsIgnoreCase("pm")) {
                pm.add(s.get(i));
            } else {
                am.add(s.get(i));
            }
        }
        arrangeHours(am);
        arrangeHours(pm);
        s.clear();
        for (int i = 0; i < am.size(); i++) {
            s.add(am.get(i));
        }
        for (int i = 0; i < pm.size(); i++) {
            s.add(pm.get(i));
        }

    }

    public static void arrangeHours(ArrayList<String> s) {

        for (int i = 0; i < s.size(); i++) {

            for (int j = i; j < s.size(); j++) {
                String tempi = s.get(i);
                String tempj = s.get(j);

                if (compareHour(tempi, tempj)) {

                    s.set(i, tempj);
                    s.set(j, tempi);

                }

            }

        }

    }

    public static void MrArrange(ArrayList<String> s) {

        for (int i = 0; i < s.size(); i++) {

            for (int j = i; j < s.size(); j++) {
                String tempi = s.get(i);
                String tempj = s.get(j);
                int y1 = Integer.parseInt(tempi.split(" ")[0].split("-")[0]);
                int y2 = Integer.parseInt(tempj.split(" ")[0].split("-")[0]);
                int m1 = Integer.parseInt(tempi.split(" ")[0].split("-")[1]);
                int m2 = Integer.parseInt(tempj.split(" ")[0].split("-")[1]);
                int d1 = Integer.parseInt(tempi.split(" ")[0].split("-")[2]);
                int d2 = Integer.parseInt(tempj.split(" ")[0].split("-")[2]);
                if ((y1 > y2) || ((y1 == y2) && (m1 > m2)) || ((y1 == y2) && (m1 == m2) && (d1 > d2))) {
                    s.set(i, tempj);
                    s.set(j, tempi);
                }

            }
        }

    }

    public static boolean compareHour(String x, String y) {
        int h1 = Integer.parseInt(x.split(" ")[1]);
        int h2 = Integer.parseInt(y.split(" ")[1]);

        return h1 > h2;
    }

    public static String formatDate(String s) {
        int k = s.indexOf("<" + new SimpleDateFormat("yyyy").format(new Date()) + "-" + Integer.parseInt(new SimpleDateFormat("MM").format(new Date())));
        int e = k + 9;
        for (int i = k; i < s.length(); i++) {
            if (s.charAt(i) == '>') {
                e = i;
            }
        }
        String date = s.substring(k, e + 1);
        s = s.replaceAll(date, "");
        s = date.substring(1, date.length() - 1) + " > " + s;
        return s;
    }

    public static boolean compareDays(String s1, String s2) {

        int d1 = Integer.parseInt(s1.split(">")[0].trim().split("-")[2]);
        int d2 = Integer.parseInt(s2.split(">")[0].trim().split("-")[2]);
        return d1 > d2;
    }

    public static ArrayList<String> arrangeDays(ArrayList<String> s) {

        for (int i = 0; i < s.size(); i++) {
            s.set(i, formatDate(s.get(i)));
        }

        for (int i = 0; i < s.size(); i++) {

            for (int j = i; j < s.size(); j++) {
                String tempi = s.get(i);
                String tempj = s.get(j);

                if (compareDays(tempi, tempj)) {
                    s.set(i, tempj);
                    s.set(j, tempi);
                }

            }
        }

        return s;
    }

    public static void startTime(JLabel time, JLabel day) {

        clock.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                day.setText(new SimpleDateFormat("EEEE").format(new Date()));
                time.setText(new SimpleDateFormat("yyyy/MM/dd - hh:mm:ss aa").format(new Date()));
                if (Integer.parseInt(new SimpleDateFormat("mm").format(new Date())) == 0 && Integer.parseInt(new SimpleDateFormat("ss").format(new Date())) == 0) //// start
                {
                    ArrayList<String> hours = new ArrayList();

                    for (int i = 0; i < Mission_Data.folder.size(); i++) {

                        for (int j = 0; j < Integer.parseInt(Mission_Data.folder.get(i).get(0)); j++) {
                            String s = Mission_Data.folder.get(i).get(j + 2);
                            if (s.contains(new SimpleDateFormat("yyyy").format(new Date()) + "-" + Integer.parseInt(new SimpleDateFormat("MM").format(new Date())) + "-" + Integer.parseInt(new SimpleDateFormat("dd").format(new Date())))) {
                                s = s.replaceAll("<\\d+{4}-\\d+{2}-\\d+{2}>", "");
                                if (s.contains("<H: ")) {
                                    String x = s.substring(s.indexOf("<H: "));
                                    x = x.split(">")[0];
                                    s = s.replaceAll(x + ">", "");
                                    x = x.substring(1);
                                    s = x + " > " + s;
                                    hours.add(s);

                                }
                            } else if ((s.toLowerCase().contains(new SimpleDateFormat("EEEE").format(new Date()).toLowerCase())) && ((s.equals(s.replaceAll("\\d+{4}-\\d+{2}-\\d+{2}", ""))))) {

                                s = s.replaceAll("<\\w+day>", "");

                                if (s.contains("<H: ")) {
                                    String x = s.substring(s.indexOf("<H: "));
                                    x = x.split(">")[0];
                                    s = s.replaceAll(x + ">", "");
                                    x = x.substring(1);
                                    s = x + " > " + s;
                                    hours.add(s);

                                }

                            }
                        }

                    }

                    arrangeAmPm(hours);

                    getWork(hours);

                    if (!hours.isEmpty()) {
                        Manager.searchFrm.setTitle("Today's work");
                        Manager.searchModel.clear();
                        Manager.searchModel.addElement("Now and next hour you have: ");

                        for (int i = 0; i < hours.size(); i++) {
                            Manager.searchModel.addElement(hours.get(i));
                        }

                        Manager.searchFrm.setVisible(true);
                    }
                }
            }
        });
        clock.start();
    }

    public static void getWork(ArrayList<String> s) {
        for (int i = 0; i < s.size(); i++) {
            int x = Integer.parseInt(s.get(i).split(" ")[1]);
            int y = Integer.parseInt(new SimpleDateFormat("HH").format(new Date()));
            String ampm = (y > 12) ? "pm" : "am";
            y = (y > 12) ? y - 12 : y;
            String fact = s.get(i).split(" ")[2];

            
            if (((x == y || x == y + 1) && ampm.equals(fact)) && valid ) {
            } else if (((x == 1) && (y == 12) && (!(ampm.equals(fact)))) && valid ) {
            } else {
                s.remove(i);
                i--;
            }

        }

    }

    public static void save(String path1, String path2, String path3) {
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter(path1));
            String datalist = "";
            datalist += noProfile + "#";

            for (int i = 0; i < folder.size(); i++) {
                for (int j = 0; j < folder.get(i).size(); j++) {
                    datalist += folder.get(i).get(j) + "@";
                }
                datalist += "#";

            }

            bf.write(datalist);

            bf.close();
            bf = new BufferedWriter(new FileWriter(path2));
            bf.write(Manager.th.desktop);
            bf.newLine();
            bf.append(Manager.th.c1.getRed() + " " + Manager.th.c1.getGreen() + " " + Manager.th.c1.getBlue());
            bf.newLine();
            bf.append(Manager.th.c2.getRed() + " " + Manager.th.c2.getGreen() + " " + Manager.th.c2.getBlue());
            
            bf.newLine();
            
           
            if(valid)
            bf.append("t");
            else 
            bf.append("f");
            bf.close();
            saveHome(path3);
            JOptionPane.showMessageDialog(null, "All data have been saved!", "Information", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error while saving data!", "Warning!", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    public static void saveHome(String path) throws IOException {

        if (Manager.home) {
            BufferedWriter bf = new BufferedWriter(new FileWriter(path));
            bf.write(new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
            bf.close();
        }
    }

    public static void refresh(DefaultListModel profileModel) {

        if (noProfile != 0) {
            for (int i = 0; i < folder.size(); i++) {

                {
                    profileModel.addElement((i + 1) + " M: " + folder.get(i).get(1));
                }
            }
        }

    }

    public static void goBack(JTextArea t, JList profile, DefaultListModel profileModel, JList mission, DefaultListModel missionModel, JFrame searchFrm) {
        boolean x = true;

        if (Back.valid) {
            if (Back.action.equals("edit p")) {
                Mission_Data.folder.get(Back.profileno).set(1, Back.editedText);
                profileModel.setElementAt((Back.profileno + 1) + " M: " + Back.editedText, Back.profileno);
            } else if (Back.action.equals("edit m")) {

                folder.get(Back.profileno).set(Back.missionno + 2, Back.editedText);

                if (profile.getSelectedIndex() == Back.profileno) {
                    missionModel.setElementAt((Back.missionno + 1) + " M: " + Back.editedText, Back.missionno);
                }

            } else if (Back.action.equals("cut")) {
                versionData.clear();
                for (int i = 0; i < Back.lastData.size(); i++) {
                    folder.get(profile.getSelectedIndex()).set(0, (Integer.parseInt(folder.get(profile.getSelectedIndex()).get(0)) + 1) + "");
                    folder.get(Back.profileno).add(Back.lastData.get(i).replaceFirst("\\d+\\sM:\\s", ""));
                }
                if (!profile.isSelectionEmpty() && profile.getSelectedIndex() == Back.profileno) {
                    missionModel.clear();
                    for (int i = 0; i < Integer.parseInt(folder.get(profile.getSelectedIndex()).get(0)); i++) {
                        missionModel.addElement((i + 1) + " M: " + folder.get(profile.getSelectedIndex()).get(i + 2));
                    }
                }

            } else if (Back.action.equals("delete p")) {
                folder.add((ArrayList<String>) Back.lastData.clone());
                noProfile++;
                profileModel.clear();
                refresh(profileModel);

            } else if (Back.action.equals("delete m")) {
                for (int i = 0; i < Back.lastData.size(); i++) {
                    folder.get(Back.profileno).add(Back.lastData.get(i).replaceFirst("\\d+\\sM:\\s", ""));
                }

                folder.get(Back.profileno).set(0, (Integer.parseInt(folder.get(Back.profileno).get(0)) + Back.lastData.size()) + "");
                if (profile.getSelectedIndex() == Back.profileno) {
                    missionModel.clear();
                    for (int i = 0; i < Integer.parseInt(folder.get(profile.getSelectedIndex()).get(0)); i++) {
                        missionModel.addElement((i + 1) + " M: " + folder.get(profile.getSelectedIndex()).get(i + 2));
                    }

                }
            } else if (Back.action.equals("delete all")) {
                folder = Back.colonize(Back.folderSafe);
                noProfile = folder.size();
                refresh(profileModel);

            } else {
                x = false;
            }
            if (x) {
                Back.reset();
                t.setText("");
                Back.valid = false;

            }
        }
    }

    public static void copy(JList x) {

        if (!x.isSelectionEmpty()) {
            versionData = new ArrayList(x.getSelectedValuesList());
            for (int i = 0; i < versionData.size(); i++) {
                versionData.set(i, versionData.get(i).replaceFirst("\\d+\\sM:\\s", ""));
            }

        }
        Back.profilenocopy = x.getSelectedIndex();
    }

    public static boolean cut(JList p, JList m, DefaultListModel dm) {

        int k = JOptionPane.showConfirmDialog(null, "Do you want to cut this items!");
        if (k == 0) {

            Back.valid = true;
            Back.action = "cut";
            Back.profileno = p.getSelectedIndex();
            Back.lastData = new ArrayList(m.getSelectedValuesList());
            Back.profilenocopy = p.getSelectedIndex();
            versionData = new ArrayList(m.getSelectedValuesList());

            folder.get(p.getSelectedIndex()).set(0, (Integer.parseInt(folder.get(p.getSelectedIndex()).get(0)) - versionData.size()) + "");
            for (int i = 0; i < versionData.size(); i++) {
                folder.get(p.getSelectedIndex()).remove(Integer.parseInt(versionData.get(i).split("M")[0].trim()) + 1 - i);

                versionData.set(i, versionData.get(i).replaceFirst("\\d+\\sM:\\s", ""));
            }

            dm.clear();
            for (int i = 0; i <= Integer.parseInt(folder.get(p.getSelectedIndex()).get(0)); i++) {
                if (i != 0) {
                    dm.addElement((i) + " M: " + folder.get(p.getSelectedIndex()).get(i + 1));
                }
            }

            return true;
        }

        return false;

    }

    public static void past(JList p, DefaultListModel m) {
        if (!p.isSelectionEmpty() && !versionData.isEmpty()) {
            for (int i = 0; i < versionData.size(); i++) {
                folder.get(p.getSelectedIndex()).set(0, (Integer.parseInt(folder.get(p.getSelectedIndex()).get(0)) + 1) + "");
                folder.get(p.getSelectedIndex()).add(versionData.get(i));
                m.addElement(Integer.parseInt(folder.get(p.getSelectedIndex()).get(0)) + " M: " + versionData.get(i));
            }

        }

    }

    public double[] convertToDouble(int[] x, int[] y) {
        double z[] = new double[x.length];
        for (int i = 0; i < z.length; i++) {
            z[i] = Double.parseDouble(x[i] + "." + y[i]);
        }
        return z;

    }

    static int gethours(double pray) {
        return (int) Math.floor(moreLess24(pray));
    }
//get the minutes of any prayer

    static int getminutes(double pray, int hours) {
        return (int) Math.floor(moreLess24(pray - hours) * 60);
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

    public static String prayer() {
        String[] s = getPrayerTime();
        String x = "";
        x += "Fajr:    " + s[0];
        x += "\nZuhr:    " + s[1];
        x += "\nAsr:     " + s[2];
        x += "\nMaghrib: " + s[3];
        x += "\nIshaa:   " + s[4];

        return x;
    }

    public static String getHigriDate() {

        Calendar cl = Calendar.getInstance();
        cl.setTime(new Date());
        HijrahDate islamyDate = HijrahChronology.INSTANCE.date(LocalDate.of(cl.get(Calendar.YEAR), cl.get(Calendar.MONTH) + 1, cl.get(Calendar.DATE)));
        return islamyDate.toString().split(" ")[2];
    }

    public static boolean compareTime(String s) {

        int nowh = Integer.parseInt(new SimpleDateFormat("HH").format(new Date()));
        int nowm = Integer.parseInt(new SimpleDateFormat("mm").format(new Date()));
        int hour = Integer.parseInt(s.split(":")[0]);
        int minute = Integer.parseInt(s.split(":")[1]);

        return (hour < nowh || (hour == nowh && minute < nowm));

    }

    public static String getSiam() {

        String dayName = new SimpleDateFormat("EEEE").format(new Date());
        int dayno = Integer.parseInt(getHigriDate().split("-")[2]);
        String message = "Tommorow";
        if (((dayName.equals("Sunday") || dayName.contains("حد")) && compareTime(getFajrTime())) || ((dayName.equals("Monday") || dayName.contains("ثنين")) && !compareTime(getFajrTime()))) {
            message += " is Monday";
        } else if (((dayName.equals("Wednesday") || dayName.contains("ربعاء")) && compareTime(getFajrTime())) || ((dayName.equals("Thursday") || dayName.contains("خميس")) && !compareTime(getFajrTime()))) {
            message += " is Tuesday";
        }
        if ((dayno == 11 || dayno == 12 || dayno == 13 || dayno == 14) && compareTime(getFajrTime())) {
            message += " may be " + (dayno + 1) + " or " + (dayno + 2);
        } else if ((dayno == 12 || dayno == 13 || dayno == 14 || dayno == 15) && !compareTime(getFajrTime())) {
            message += " may be " + (dayno) + " or " + (dayno + 1);
        }

        if (message.equals("Tommorow")) {
            return "";
        } else {
            return message;
        }
    }

    public static String[] getPrayerTime() { //defination of variables for calculating prayer times
        final int timeZone = 2;
        final double longitude = 30.2, latitude = 30, fajrTwilight = -19.5, ishaTwilight = -17.5;
        int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date())), month = Integer.parseInt(new SimpleDateFormat("MM").format(new Date())), day = Integer.parseInt(new SimpleDateFormat("dd").format(new Date())), hours = Integer.parseInt(new SimpleDateFormat("HH").format(new Date())), minutes = Integer.parseInt(new SimpleDateFormat("mm").format(new Date()));
        double fajrTime, sunRiseTime, zuhrTime, asrTime, maghribTime, ishaTime;
        //end of prayer time variables

        //end of stage 1						
        //satge 2 update your prayer times
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
        // Asr Hanafi
        // Asr Shafii
        double Asr_Alt = radToDeg(Math.atan(1 + Math.tan(degToRad(latitude - Dec))));
        double Asr_Arc = radToDeg(Math.acos((Math.sin(degToRad(90 - Asr_Alt)) - Math.sin(degToRad(Dec)) * Math.sin(degToRad(latitude))) / (Math.cos(degToRad(Dec)) * Math.cos(degToRad(latitude)))));
        Asr_Arc = Asr_Arc / 15;
        // 3) Asr Time
        asrTime = zuhrTime + Asr_Arc;
        // 1) Shorouq Time
        sunRiseTime = zuhrTime - (Durinal_Arc / 15);
        // 4) Maghrib Time
        maghribTime = zuhrTime + (Durinal_Arc / 15);
        double Esha_Arc = radToDeg(Math.acos((Math.sin(degToRad(ishaTwilight)) - Math.sin(degToRad(Dec)) * Math.sin(degToRad(latitude))) / (Math.cos(degToRad(Dec)) * Math.cos(degToRad(latitude)))));
        // 5) Isha Time
        ishaTime = zuhrTime + (Esha_Arc / 15);
        // 0) Fajr Time
        double Fajr_Arc = radToDeg(Math.acos((Math.sin(degToRad(fajrTwilight)) - Math.sin(degToRad(Dec)) * Math.sin(degToRad(latitude))) / (Math.cos(degToRad(Dec)) * Math.cos(degToRad(latitude)))));
        fajrTime = zuhrTime - (Fajr_Arc / 15);
        //end of stage 2

        return new String[]{timeprayer(fajrTime), timeprayer(zuhrTime), timeprayer(asrTime), timeprayer(maghribTime), timeprayer(ishaTime)};

    }

    public static String[] getPrayName() {
        String s[] = getPrayerTime();

        return new String[]{"Fajr    >>> " + s[0], "Zuhr    >>> " + s[1], "Asr     >>> " + s[2], "Maghrib >>> " + s[3], "Ishaa   >>> " + s[4]};

    }

    public static String timeprayer(double f) {
        return new DecimalFormat("00").format(f) + ":" + new DecimalFormat("00").format((f % 1) * 60);
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

    public static String timeForPray() {
        String now = new SimpleDateFormat("HH:mm").format(new Date());
        String[] pray = getPrayerTime();

        int meH = Integer.parseInt(now.split(":")[0]);
        int mem = Integer.parseInt(now.split(":")[1]);

        int Hf = Integer.parseInt(pray[0].split(":")[0]);
        int mf = Integer.parseInt(pray[0].split(":")[1]);

        int Hz = Integer.parseInt(pray[1].split(":")[0]);
        int mz = Integer.parseInt(pray[1].split(":")[1]);

        int Ha = Integer.parseInt(pray[2].split(":")[0]);
        int ma = Integer.parseInt(pray[2].split(":")[1]);

        int Hm = Integer.parseInt(pray[3].split(":")[0]);
        int mm = Integer.parseInt(pray[3].split(":")[1]);

        int Hi = Integer.parseInt(pray[4].split(":")[0]);
        int mi = Integer.parseInt(pray[4].split(":")[1]);

        String end = "";
        int i;

        if (meH < Hf || (meH == Hf && mem < mf)) {
            i = 0;
            end += "Fajr";
        } else if (meH < Hz || (meH == Hz && mem < mz)) {
            i = 1;
            end += "Zuhr";
        } else if (meH < Ha || (meH == Ha && mem < ma)) {
            i = 2;
            end += "Asr";
        } else if (meH < Hm || (meH == Hm && mem < mm)) {
            i = 3;
            end += "Maghrib";
        } else if (meH < Hi || (meH == Hi && mem < mi)) {
            i = 4;
            end += "Ishaa";
        } else {
            i = 5;
            end += "Fajr";
        }

        end += " >>> ";
        if (i != 5) {
            end += timeDif(now, pray[i]);
        } else {
            end += timeDif(now, (Integer.parseInt(pray[0].split(":")[0]) + 24) + ":" + Integer.parseInt(pray[0].split(":")[1]));
        }

        return end;
    }

    public static String timeDif(String now, String pray) {
        String end;
        int meH = Integer.parseInt(now.split(":")[0]);
        int mem = Integer.parseInt(now.split(":")[1]);

        int Hp = Integer.parseInt(pray.split(":")[0]);
        int mp = Integer.parseInt(pray.split(":")[1]);
        if (mem > mp) {
            end = new DecimalFormat("00").format(Hp - meH - 1) + ":" + new DecimalFormat("00").format(mp + 60 - mem);
        } else {

            end = new DecimalFormat("00").format(Hp - meH) + ":" + new DecimalFormat("00").format(mp - mem);
        }

        return end;
    }

    public static void changeProfile(int first, int second) {
        ArrayList f = (ArrayList) folder.get(first).clone();
        ArrayList s = (ArrayList) folder.get(second).clone();
        folder.set(first, s);
        folder.set(second, f);
    }

    public static void changeMission(int first, int second, int pNo) {

        String f = folder.get(pNo).get(first + 2);
        String s = folder.get(pNo).get(second + 2);
        folder.get(pNo).set(first + 2, s);
        folder.get(pNo).set(second + 2, f);
    }
    static DateFormat dateFormat;
    static int noProfile;
    static ArrayList< ArrayList<String>> folder = new ArrayList();
    static Timer clock = new Timer(1000, null);
    static boolean target = true , valid = true ;
    static ArrayList<String> safety = new ArrayList();
    static ArrayList<String> versionData = new ArrayList();
    public static final String HigriMonth[] = {"محرم", "صفر", "ربيع اول", "ربيع اخر", "جمادى اول", "جمادى اخر", "رجب", "شعبان", "رمضان", "شوال", "ذى القعدة", "ذى الحجة"};

    
}
