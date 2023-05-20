/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Aboahmed
 */
public class Importantmethods {

    public double[] convertToDouble(int[] x, int[] y) {
        double z[] = new double[x.length];
        for (int i = 0; i < z.length; i++) {
            z[i] = Double.parseDouble(x[i] + "." + y[i]);
        }
        return z;

    }

    int gethours(double pray) {
        return (int) Math.floor(moreLess24(pray));
    }
//get the minutes of any prayer

    int getminutes(double pray, int hours) {
        return (int) Math.floor(moreLess24(pray - hours) * 60);
    }

   public  String getFajrTime() {

        final int timeZone = 2;
        final double longitude = 30.2, latitude = 30, fajrTwilight = -19.5, ishaTwilight = -17.5;
        int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date())), month = Integer.parseInt(new SimpleDateFormat("MM").format(new Date())), day = Integer.parseInt(new SimpleDateFormat("dd").format(new Date())), hours = Integer.parseInt(new SimpleDateFormat("HH").format(new Date())), minutes = Integer.parseInt(new SimpleDateFormat("mm").format(new Date()));
        double fajrTime,  zuhrTime;
        
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

    public double[] getPrayerTime() { //defination of variables for calculating prayer times
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

        return new double[]{fajrTime, sunRiseTime , zuhrTime, asrTime, maghribTime, ishaTime};

    }

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(new Importantmethods().getPrayerTime()));
        //System.out.println(new Importantmethods().getFajrTime());

        JFrame x = new JFrame();
        x.setBounds(100, 100, 300, 300);
        x.setVisible(true);
        x.setLayout(new GridLayout(2, 2, 10, 10));

       
        JTextArea t = new JTextArea();
         JScrollPane y = new JScrollPane(t);
         JScrollPane z = new JScrollPane();
        //y.setFocusCycleRoot(false);
         z.add(new JTextArea("never mind"));

        x.add(z);
        x.add(y);
        x.add(new JScrollPane(new JTextField("playing in the skyplaying in the skyplaying in the skyplaying in the skyplaying in the skyplaying in the skyplaying in the skyplaying in the skyplaying in the skyplaying in the skyplaying in the skyplaying in the skyplaying in the skyplaying in the skyplaying in the skyplaying in the skyplaying in the skyplaying in the skyplaying in the skyplaying in the skyplaying in the skyplaying in the skyplaying in the sky")));

        t.setText("working in the \nsun is so goodworking in the \nsun is so goodworking in the \nsun is so goodworking in the \nsun is so goodworking in the \nsun is so goodworking in the \nsun is so goodworking in the \nsun is so goodworking in the \nsun is so goodworking in the \nsun is so goodworking in the \nsun is so goodworking in the \nsun is so goodworking in the \nsun is so goodworking in the \nsun is so good");
       //t.setCaretPosition(3);
        
        JButton b = new JButton("Click");
x.add(b);
b.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent evt)
{
    System.out.println("here");
t.setCaretPosition(5);

}

});
    }

    double degToRad(double degree) {
        return ((3.1415926 / 180) * degree);
    }
//convert Radian to Degree

    double radToDeg(double radian) {
        return (radian * (180 / 3.1415926));
    }
//make sure a value is between 0 and 360

    double moreLess360(double value) {
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

    double moreLess24(double value) {
        while (value > 24 || value < 0) {
            if (value > 24) {
                value -= 24;
            } else if (value < 0) {
                value += 24;
            }
        }

        return value;
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

    
}
