package time.management;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public abstract class Mission_Data {

    public static void intial(String path1, String path2, String path3) throws FileNotFoundException, IOException {
//timing messag
        remindclock.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                safety.clear();
                if (!Rweek.isEmpty()) {
                    for (int i = 0; i < Rweek.size(); i++) {
                        if (Rweek.get(i).contains(new SimpleDateFormat("EEEE").format(new Date()))) {
                            safety.add(Rweek.get(i));
                        }
                    }
                }
                String hanger[] = new SimpleDateFormat("yyyy/MM/dd --- HH:mm:ss").format(new Date()).substring(0, 10).split("/");
                if (!Rdate.isEmpty()) {
                    for (int i = 0; i < Rdate.size(); i++) {
                        String nower[] = Rdate.get(i).substring(0, 10).split("/");
                        if (Integer.parseInt(hanger[0].trim()) > Integer.parseInt(nower[0].trim())) {
                            safety.add(Rdate.get(i));
                        } else if (Integer.parseInt(hanger[0].trim()) == Integer.parseInt(nower[0].trim()) && Integer.parseInt(hanger[1].trim()) > Integer.parseInt(nower[1].trim())) {
                            safety.add(Rdate.get(i));
                        } else if (Integer.parseInt(hanger[0].trim()) == Integer.parseInt(nower[0].trim()) && Integer.parseInt(hanger[1].trim()) == Integer.parseInt(nower[1].trim()) && Integer.parseInt(hanger[2].trim()) >= Integer.parseInt(nower[2].trim())) {
                            safety.add(Rdate.get(i));
                        }
                    }
                }
                if (!safety.isEmpty()) {
                    String forward = "";
                    forward += new SimpleDateFormat("EEEE").format(new Date()) + "       " + new SimpleDateFormat("yyyy/MM/dd --- HH:mm:ss").format(new Date()).split(" ")[0] + "\n";

                    for (int i = 0; i < safety.size(); i++) {

                        String safe[] = safety.get(i).split(" ");

                        if ((Integer.parseInt(safe[1]) <= Integer.parseInt(new SimpleDateFormat("HH").format(new Date())))) {
                            for (int j = 1; j < safe.length; j++) {
                                forward += safe[j] + " ";
                            }
                            forward += "\n";
                        }

                    }
                    JOptionPane.showMessageDialog(null, "Your missions today! \n" + forward, "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                }

                //code perfomed here
            }
        });
        remindclock.start();

//end of timing message
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

        br = new BufferedReader(new FileReader(path2));
        if (br.ready()) {
            String R0[] = br.readLine().split("#");
            for (int i = 0; i < R0.length; i++) {
                Rweek.add(R0[i]);
            }

        }

        br = new BufferedReader(new FileReader(path3));
        if (br.ready()) {

            String R1[] = br.readLine().split("#");
            for (int i = 0; i < R1.length; i++) {
                Rdate.add(R1[i]);

            }

        }

///end
    }

    public static void startTime(JLabel time, JLabel day) {

        clock.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                day.setText(new SimpleDateFormat("EEEE").format(new Date()));
                time.setText(new SimpleDateFormat("yyyy/MM/dd --- HH:mm:ss").format(new Date()));

            }
        });
        clock.start();
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
            datalist = "";
            for (int i = 0; i < Rweek.size(); i++) {
                datalist += Rweek.get(i) + "#";
            }
            bf.write(datalist);
            bf.close();
            bf = new BufferedWriter(new FileWriter(path3));
            datalist = "";
            for (int i = 0; i < Rdate.size(); i++) {
                datalist += Rdate.get(i) + "#";
            }
            bf.write(datalist);
            bf.close();
            JOptionPane.showMessageDialog(null, "All data have been saved!", "Information", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error while saving data!", "Warning!", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    public static void alarmMes() {
        safety.clear();
        if (!Rweek.isEmpty()) {
            for (int i = 0; i < Rweek.size(); i++) {
                if (Rweek.get(i).contains(new SimpleDateFormat("EEEE").format(new Date()))) {
                    safety.add(Rweek.get(i));
                }
            }
        }
        String hanger[] = new SimpleDateFormat("yyyy/MM/dd --- HH:mm:ss").format(new Date()).substring(0, 10).split("/");
        if (!Rdate.isEmpty()) {
            for (int i = 0; i < Rdate.size(); i++) {
                String nower[] = Rdate.get(i).substring(0, 10).split("/");
                if (Integer.parseInt(hanger[0].trim()) > Integer.parseInt(nower[0].trim())) {
                    safety.add(Rdate.get(i));
                } else if (Integer.parseInt(hanger[0].trim()) == Integer.parseInt(nower[0].trim()) && Integer.parseInt(hanger[1].trim()) > Integer.parseInt(nower[1].trim())) {
                    safety.add(Rdate.get(i));
                } else if (Integer.parseInt(hanger[0].trim()) == Integer.parseInt(nower[0].trim()) && Integer.parseInt(hanger[1].trim()) == Integer.parseInt(nower[1].trim()) && Integer.parseInt(hanger[2].trim()) >= Integer.parseInt(nower[2].trim())) {
                    safety.add(Rdate.get(i));
                }
            }
        }
        if (safety.size() == 0) {
            JOptionPane.showMessageDialog(null, "No new missions for today!", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String forward = "";
            forward += new SimpleDateFormat("EEEE").format(new Date()) + "       " + new SimpleDateFormat("yyyy/MM/dd --- HH:mm:ss").format(new Date()).split(" ")[0] + "\n";
            for (int i = 0; i < safety.size(); i++) {

                String safe[] = safety.get(i).split(" ");

                for (int j = 1; j < safe.length; j++) {
                    forward += safe[j] + " ";
                }
                forward += "\n";

            }
            JOptionPane.showMessageDialog(null, "Your missions today! \n" + forward, "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
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

    static DateFormat dateFormat;
    static int noProfile;
    static ArrayList< ArrayList<String>> folder = new ArrayList();
    static Timer clock = new Timer(1000, null);
    static Timer remindclock = new Timer(60 * 60 * 1000, null);
    static boolean target = true;
    static ArrayList<String> Rweek = new ArrayList();
    static ArrayList<String> Rdate = new ArrayList();
    static ArrayList<String> safety = new ArrayList();
}
