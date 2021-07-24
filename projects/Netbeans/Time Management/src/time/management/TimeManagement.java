package time.management;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

//import for system tray
import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;

//end tray
public class TimeManagement {

    //main frame design
    static JFrame mainFrm = GUI_Ruler.addFrm(true, false, 200, 50, 800, 400, "TIME MANAGER, PEACE BE UPON YOU", "wood.jpg", false);
    static JLabel Time = GUI_Ruler.addLbl(10, 10, 400, 40, "", mainFrm);
    static JLabel day = GUI_Ruler.addLbl(10, 50, 200, 40, "", mainFrm);
    static JButton remind = GUI_Ruler.addBtn(190, 240, 130, 40, "reminder", mainFrm);
    static JButton save = GUI_Ruler.addBtn(100, 300, 80, 40, "save", mainFrm);
    static JButton Exit = GUI_Ruler.addBtn(10, 300, 80, 40, "Exit", mainFrm);
    static JButton deleteAll = GUI_Ruler.addBtn(10, 200, 140, 40, "Delete All", mainFrm);
    static JButton edit = GUI_Ruler.addBtn(10, 250, 80, 40, "Edit", mainFrm);
    static JButton search = GUI_Ruler.addBtn(10, 100, 140, 40, "Search", mainFrm);
    static JButton oneDelete = GUI_Ruler.addBtn(10, 100, 140, 40, "Delete", mainFrm);
    static JButton Add = GUI_Ruler.addBtn(10, 100, 80, 40, "Add", mainFrm);
    static JTextArea text = GUI_Ruler.addtxt(190, 290, 570, 60, "", mainFrm);
    static JScrollPane holderText = new JScrollPane(text);
    static JList profile = new JList();
    static JScrollPane pp = new JScrollPane(profile);
    static DefaultListModel profileModel = new DefaultListModel();
    static JList mission = new JList();
    static JScrollPane mp = new JScrollPane(mission);
    static DefaultListModel missionModel = new DefaultListModel();

    //plate frame 
    static JFrame plate = GUI_Ruler.addFrm(false, false, 650, 470, 400, 270, "Edit and Add space!", "wood.jpg", false);
    static JButton plateB = GUI_Ruler.addBtn(10, 180, 100, 40, "Add", plate);
    static JTextArea textp = GUI_Ruler.addtxt(10, 120, 370, 40, "", plate);
    static JScrollPane holderTextP = new JScrollPane(textp);
    static JCheckBox ch1 = GUI_Ruler.addchk(10, 10, 100, 20, "week style", plate);
    static JCheckBox ch2 = GUI_Ruler.addchk(10, 65, 100, 20, "date style", plate);
    static JList weekdays = new JList();
    static JScrollPane wp = new JScrollPane(weekdays);
    static DefaultListModel weekdaysModel = new DefaultListModel();
    static JLabel classic = GUI_Ruler.addLbl(140, 40, 200, 30, "", plate);
    static JTextArea year = GUI_Ruler.addtxt(135, 70, 40, 20, "", plate);
    static JTextArea month = GUI_Ruler.addtxt(210, 70, 40, 20, "", plate);
    static JTextArea dayno = GUI_Ruler.addtxt(285, 70, 40, 20, "", plate);
    static JTextArea clock1 = GUI_Ruler.addtxt(270, 10, 40, 20, "", plate);
    static JTextArea clock2 = GUI_Ruler.addtxt(285, 70, 40, 20, "", plate);
  
//reminder frame
    static JFrame reminder = GUI_Ruler.addFrm(false, false, 200, 470, 400, 270, "REMINDER!", "wood.jpg", false);
    static JButton Radd = GUI_Ruler.addBtn(10, 20, 100, 40, "Add", reminder);
    static JButton Redit = GUI_Ruler.addBtn(10, 80, 100, 40, "Edit", reminder);
    static JButton alarm = GUI_Ruler.addBtn(10, 140, 100, 40, "Alarm", reminder);
    static JButton Rdelete = GUI_Ruler.addBtn(10, 140, 100, 40, "Delete", reminder);
    static JList alarms = new JList();
    static JScrollPane Rp = new JScrollPane(alarms);
    static DefaultListModel alarmModel = new DefaultListModel();

    public static void main(String[] args) throws IOException, AWTException {

        //to change messege font size
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("WinSoft Thuluth", Font.BOLD, 15)));

        //frame adjust
        GUI_Ruler.makeVertical(search, deleteAll, oneDelete, edit, Exit);
        GUI_Ruler.makeHorizontal(edit, Add);
        GUI_Ruler.makeHorizontal(Exit, save);
        remind.setBackground(Color.red);
        holderText.setBounds(190, 290, 570, 60);
        mainFrm.add(holderText, 0);
        text.setForeground(Color.orange);
        text.setBackground(Color.BLACK);
        profile.setForeground(Color.orange);
        profile.setBackground(Color.black);
        profile.setFont(new Font("Courier New", Font.BOLD, 18));
        profile.repaint();
        pp.setBounds(160, 60, 160, 170);
        mainFrm.add(pp, 0);
        profile.setModel(profileModel);
        mission.setForeground(Color.black);
        mission.setBackground(Color.orange);
        mission.setFont(new Font("Segoe UI", Font.BOLD, 18));
        mission.repaint();
        mp.setBounds(350, 20, 400, 250);
        mainFrm.add(mp, 0);
        mission.setModel(missionModel);

        //plate adjust 
        GUI_Ruler.makeHorizontal(ch2, year, month, dayno, clock2);
        holderTextP.setBounds(10, 120, 370, 40);
        plate.add(holderTextP, 0);
        weekdays.setForeground(Color.black);
        weekdays.setBackground(Color.orange);
        weekdays.setFont(new Font("Courier New", Font.BOLD, 15));
        weekdays.repaint();
        wp.setBounds(130, 10, 120, 25);
        plate.add(wp, 0);
        weekdays.setModel(weekdaysModel);
        weekdaysModel.addElement("Saturday");
        weekdaysModel.addElement("Sunday");
        weekdaysModel.addElement("Monday");
        weekdaysModel.addElement("Tuesday");
        weekdaysModel.addElement("Wednesday");
        weekdaysModel.addElement("Thursday");
        weekdaysModel.addElement("Friday");

        //reminder install 
        GUI_Ruler.makeVertical(Radd, Redit, Rdelete, alarm);
        alarms.setForeground(Color.black);
        alarms.setBackground(Color.orange);
        alarms.setFont(new Font("Courier New", Font.BOLD, 18));
        alarms.repaint();
        Rp.setBounds(130, 10, 230, 180);
        reminder.add(Rp, 0);
        alarms.setModel(alarmModel);

        Mission_Data.intial("data.txt", "remind0.txt", "remind1.txt");
        Mission_Data.startTime(Time, day);
        Mission_Data.alarmMes();
        Mission_Data.refresh(profileModel);

        save.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                Mission_Data.save("data.txt", "remind0.txt", "remind1.txt");

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
        deleteAll.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                int k = JOptionPane.showConfirmDialog(null, "are you sure to delete all data!");
                if (k == 0) {
                    Mission_Data.folder.clear();
                    Mission_Data.Rdate.clear();
                    Mission_Data.Rweek.clear();
                    profileModel.clear();
                    missionModel.clear();
                    alarmModel.clear();
                    Mission_Data.noProfile = 0;
                    JOptionPane.showMessageDialog(null, "All data have been deleted!", "Information", JOptionPane.INFORMATION_MESSAGE);
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
        
        profile.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {

                if (!profile.isSelectionEmpty()) {
                    missionModel.clear();
                    for (int i = 0; i < Integer.parseInt(Mission_Data.folder.get(profile.getSelectedIndex()).get(0)); i++) {
                        missionModel.addElement((i + 1) + " M: " + Mission_Data.folder.get(profile.getSelectedIndex()).get(i + 2));
                    }

                    text.setText(Mission_Data.folder.get(profile.getSelectedIndex()).get(1));
                }
                Mission_Data.target = true;
                text.setForeground(Color.orange);
                text.setBackground(Color.black);
                Add.setForeground(Color.orange);
                Add.setBackground(Color.black);
                edit.setForeground(Color.orange);
                edit.setBackground(Color.black);
                oneDelete.setForeground(Color.orange);
                oneDelete.setBackground(Color.black);
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
      
      
            profile.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == 40) {

                    //your code here
                    if (!profile.isSelectionEmpty() && profile.getSelectedIndex() != Mission_Data.noProfile - 1) {
                        text.setText(Mission_Data.folder.get(profile.getSelectedIndex() + 1).get(1));
                        missionModel.clear();
                        for (int i = 0; i < Integer.parseInt(Mission_Data.folder.get(profile.getSelectedIndex() + 1).get(0)); i++) {
                            missionModel.addElement((i + 1) + " M: " + Mission_Data.folder.get(profile.getSelectedIndex() + 1).get(i + 2));
                        }

                    }
                } //start   
                else if (ke.getKeyCode() == 38) {

                    //your code here
                    if (!profile.isSelectionEmpty() && profile.getSelectedIndex() != 0) {
                        text.setText(Mission_Data.folder.get(profile.getSelectedIndex() - 1).get(1));
                        missionModel.clear();
                        for (int i = 0; i < Integer.parseInt(Mission_Data.folder.get(profile.getSelectedIndex() - 1).get(0)); i++) {
                            missionModel.addElement((i + 1) + " M: " + Mission_Data.folder.get(profile.getSelectedIndex() - 1).get(i + 2));
                        }

                    }
                }
//end     
            }

            @Override
            public void keyReleased(KeyEvent ke) {
            }
        });
        mission.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                if (!profileModel.isEmpty() && !profile.isSelectionEmpty() && !mission.isSelectionEmpty()) {
                    text.setText(Mission_Data.folder.get(profile.getSelectedIndex()).get(mission.getSelectedIndex() + 2));
                }
                Mission_Data.target = false;
                text.setForeground(Color.black);
                text.setBackground(Color.orange);
                Add.setForeground(Color.black);
                Add.setBackground(Color.orange);
                edit.setForeground(Color.black);
                edit.setBackground(Color.orange);
                oneDelete.setForeground(Color.black);
                oneDelete.setBackground(Color.orange);
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
        mission.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == 38 && !mission.isSelectionEmpty() && mission.getSelectedIndex() != 0 && !profile.isSelectionEmpty()) {
                    text.setText(Mission_Data.folder.get(profile.getSelectedIndex()).get(mission.getSelectedIndex() + 1));
                } else if (ke.getKeyCode() == 40 && !mission.isSelectionEmpty() && mission.getSelectedIndex() != ((Integer.parseInt(Mission_Data.folder.get(profile.getSelectedIndex()).get(0))) - 1) && !profile.isSelectionEmpty()) {
                    text.setText(Mission_Data.folder.get(profile.getSelectedIndex()).get(mission.getSelectedIndex() + 3));
                }

            }

            @Override
            public void keyReleased(KeyEvent ke) {
            }
        });
        search.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                if ("".equals(text.getText())) {
                    JOptionPane.showMessageDialog(null, "No text found", "Warning", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    ArrayList<String> container = new ArrayList();
                    for (int i = 0; i < Mission_Data.folder.size(); i++) {
                        for (int j = 2; j < Mission_Data.folder.get(i).size(); j++) {
                            if (Mission_Data.folder.get(i).get(j).toLowerCase().contains(text.getText().toLowerCase())) {
                                container.add(i + "&&" + j);
                            }
                        }
                    }
                    if (container.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Not found", "Information", JOptionPane.INFORMATION_MESSAGE);
                    } else if (container.size() == 1) {
                        String x[] = container.get(0).split("&&");

                        profile.setSelectedIndex(Integer.parseInt(x[0]));
                        missionModel.clear();
                        for (int i = 2; i < Mission_Data.folder.get(profile.getSelectedIndex()).size(); i++) {
                            missionModel.addElement((i - 1) + " M: " + Mission_Data.folder.get(profile.getSelectedIndex()).get(i));
                        }

                        mission.setSelectedIndex(Integer.parseInt(x[1]) - 2);
                    } else {
                        String datalist = "";
                        for (int j = 0; j < container.size(); j++) {
                            String x[] = container.get(j).split("&&");
                            datalist += "profile no: " + (Integer.parseInt(x[0]) + 1) + "---" + "mission no: " + (Integer.parseInt(x[1]) - 1) + "\n";
                        }
                        JOptionPane.showMessageDialog(null, datalist, "Information", JOptionPane.INFORMATION_MESSAGE);
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
        Add.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                if ("".equals(text.getText())) {
                    JOptionPane.showMessageDialog(null, "No text found", "Warning", JOptionPane.INFORMATION_MESSAGE);
                } else if (text.getText().contains("@") || text.getText().contains("#") || text.getText().contains("\n")) {
                    JOptionPane.showMessageDialog(null, "you can't include # or @ or break lines in your profile or mission name", "Warning", JOptionPane.INFORMATION_MESSAGE);
                } else if (Mission_Data.target) {
                    Mission_Data.noProfile++;
                    ArrayList<String> moment = new ArrayList();
                    moment.add("0");
                    moment.add(text.getText().trim());
                    Mission_Data.folder.add(new ArrayList(moment));
                    profileModel.addElement(Mission_Data.noProfile + " M: " + text.getText().trim());

                } else if (!profile.isSelectionEmpty()) {
                    Mission_Data.folder.get(profile.getSelectedIndex()).set(0, (Integer.parseInt(Mission_Data.folder.get(profile.getSelectedIndex()).get(0)) + 1) + "");
                    Mission_Data.folder.get(profile.getSelectedIndex()).add(text.getText().trim());
                    missionModel.addElement(Integer.parseInt(Mission_Data.folder.get(profile.getSelectedIndex()).get(0)) + " M: " + text.getText().trim());
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
        edit.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                if ("".equals(text.getText())) {
                    JOptionPane.showMessageDialog(null, "No text found", "Warning", JOptionPane.INFORMATION_MESSAGE);
                } else if (text.getText().contains("@") || text.getText().contains("#") || text.getText().contains("\n")) {
                    JOptionPane.showMessageDialog(null, "you can't include # or @ or break lines in your profile  or mission name", "Warning", JOptionPane.INFORMATION_MESSAGE);
                } else if (Mission_Data.target && !profile.isSelectionEmpty()) {

                    Mission_Data.folder.get(profile.getSelectedIndex()).set(1, text.getText().trim());
                    profileModel.setElementAt((profile.getSelectedIndex() + 1) + " M: " + text.getText().trim(), profile.getSelectedIndex());

                } else if (!mission.isSelectionEmpty()) {
                    Mission_Data.folder.get(profile.getSelectedIndex()).set(mission.getSelectedIndex() + 2, text.getText().trim());
                    missionModel.setElementAt((mission.getSelectedIndex() + 1) + " M: " + text.getText().trim(), mission.getSelectedIndex());
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
        oneDelete.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                if (Mission_Data.target) {
                    int k = JOptionPane.showConfirmDialog(null, "Do you want to save delete this item!");
                    if (k == 0 && !profile.isSelectionEmpty()) {
                        Mission_Data.noProfile--;
                        Mission_Data.folder.remove(profile.getSelectedIndex());
                        missionModel.clear();
                        profileModel.clear();
                        for (int i = 0; i < Mission_Data.folder.size(); i++) {
                            profileModel.addElement((i + 1) + " M: " + Mission_Data.folder.get(i).get(1));
                        }
                    }

                } else {
                    int k = JOptionPane.showConfirmDialog(null, "Do you want to delete this item!");
                    if (k == 0 && !profile.isSelectionEmpty() && !mission.isSelectionEmpty()) {
                        Mission_Data.folder.get(profile.getSelectedIndex()).remove(mission.getSelectedIndex() + 2);
                        Mission_Data.folder.get(profile.getSelectedIndex()).set(0, (Integer.parseInt(Mission_Data.folder.get(profile.getSelectedIndex()).get(0)) - 1) + "");
                        missionModel.clear();
                        for (int i = 0; i <= Integer.parseInt(Mission_Data.folder.get(profile.getSelectedIndex()).get(0)); i++) {
                            if (i != 0) {
                                missionModel.addElement((i) + " M: " + Mission_Data.folder.get(profile.getSelectedIndex()).get(i + 1));
                            }
                        }
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
        Exit.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {

                int k = JOptionPane.showConfirmDialog(null, "Do you want to save delete this item!");
                if (k == 0) {
                    Mission_Data.save("data.txt", "remind0.txt", "remind1.txt");
                    System.exit(0);
                } else if (k == 1) {
                    System.exit(0);
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
        remind.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {

                reminder.setVisible(true);
                alarmModel.clear();
                for (int i = 0; i < Mission_Data.Rweek.size(); i++) {
                    alarmModel.addElement(Mission_Data.Rweek.get(i));
                }
                for (int i = 0; i < Mission_Data.Rdate.size(); i++) {
                    alarmModel.addElement(Mission_Data.Rdate.get(i));
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
        Rdelete.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                if (alarms.getSelectedIndex() + 1 <= Mission_Data.Rweek.size()) {
                    int k = JOptionPane.showConfirmDialog(null, "Do you want to delete this week alarm!");
                    if (k == 0) {
                        Mission_Data.Rweek.remove(alarms.getSelectedIndex());
                    }
                } else {
                    int k = JOptionPane.showConfirmDialog(null, "Do you want to delete this date alarm!");
                    if (k == 0) {
                        Mission_Data.Rdate.remove(alarms.getSelectedIndex() - Mission_Data.Rweek.size());
                    }
                }
                alarmModel.clear();
                for (int i = 0; i < Mission_Data.Rweek.size(); i++) {
                    alarmModel.addElement(Mission_Data.Rweek.get(i));
                }
                for (int i = 0; i < Mission_Data.Rdate.size(); i++) {
                    alarmModel.addElement(Mission_Data.Rdate.get(i));
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
        alarm.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                Mission_Data.alarmMes();
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
        Radd.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                plate.setVisible(true);
                plateB.setText("Add");
                ch1.setSelected(false);
                ch2.setSelected(false);
                clock1.setVisible(true);
                clock2.setVisible(true);
                weekdays.setEnabled(true);
                classic.setVisible(true);
                year.setVisible(true);
                month.setVisible(true);
                dayno.setVisible(true);
                textp.setText("");
                year.setText("");
                month.setText("");
                dayno.setText("");
                clock1.setText("");
                clock2.setText("");
                weekdays.clearSelection();

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
        Redit.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                if (alarms.isSelectionEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please, select an item to edit it!", "Warning", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    plate.setVisible(true);
                    plateB.setText("Edit");
                    ch1.setSelected(false);
                    clock1.setVisible(true);
                    clock2.setVisible(true);
                    ch2.setSelected(false);
                    weekdays.setEnabled(true);
                    classic.setVisible(true);
                    year.setVisible(true);
                    month.setVisible(true);
                    dayno.setVisible(true);
                    textp.setText("");
                    year.setText("");
                    month.setText("");
                    dayno.setText("");
                    clock1.setText("");
                    clock2.setText("");
                    weekdays.clearSelection();
                    if (alarms.getSelectedIndex() + 1 <= Mission_Data.Rweek.size()) {
                        ch1.setSelected(true);
                        String maker[] = Mission_Data.Rweek.get(alarms.getSelectedIndex()).split(" ");
                       clock1.setText(maker[1]);
                       
                       for (int i = 2; i < maker.length; i++) {
                            textp.setText(textp.getText() + " " + maker[i]);
                        }
                    } else {
                        ch2.setSelected(true);
                        String maker[] = Mission_Data.Rdate.get(alarms.getSelectedIndex() - Mission_Data.Rweek.size()).split(" ");
                        String make[] = maker[0].split("/");
                        year.setText(make[0]);
                        month.setText(make[1]);
                        dayno.setText(make[2]);
                       clock2.setText(maker[1]);
                        
                        
                        for (int i = 2; i < maker.length; i++) {
                            textp.setText(textp.getText() + " " + maker[i]);
                        }
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
        plateB.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                //system check
                int clock1v, clock2v, yearv, monthv, daynv;
//new SimpleDateFormat("yyyy/MM/dd --- HH:mm:ss").format(new Date())
                try {
                    clock1v = Integer.parseInt(clock1.getText().trim());
                    if (clock1v > 23 || clock1v < 0) {
                        clock1v = Integer.parseInt(new SimpleDateFormat("HH").format(new Date()));
                    }
                } catch (Exception e) {
                    clock1v = Integer.parseInt(new SimpleDateFormat("HH").format(new Date()));

                }
                try {
                    clock2v = Integer.parseInt(clock2.getText().trim());
                    if (clock2v > 23 || clock2v < 0) {
                        clock2v = Integer.parseInt(new SimpleDateFormat("HH").format(new Date()));
                    }
                } catch (Exception e) {
                    clock2v = Integer.parseInt(new SimpleDateFormat("HH").format(new Date()));

                }
                try {
                    yearv = Integer.parseInt(year.getText().trim());

                } catch (Exception e) {
                    yearv = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));

                }
                try {
                    monthv = Integer.parseInt(month.getText().trim());
                    if (monthv > 12 || monthv < 1) {
                        monthv = Integer.parseInt(new SimpleDateFormat("MM").format(new Date()));

                    }
                } catch (Exception e) {
                    monthv = Integer.parseInt(new SimpleDateFormat("MM").format(new Date()));

                }
                try {
                    daynv = Integer.parseInt(dayno.getText().trim());
                    if (daynv > 31 || daynv < 1) {
                        daynv = Integer.parseInt(new SimpleDateFormat("dd").format(new Date()));

                    }
                } catch (Exception e) {
                    daynv = Integer.parseInt(new SimpleDateFormat("dd").format(new Date()));

                }
                //end of system check
                if (plateB.getText() == "Add") {

                    //your main code here}
                    if (ch1.isSelected() == false && ch2.isSelected() == false) {
                        JOptionPane.showMessageDialog(null, "you should select timing system", "Warning", JOptionPane.INFORMATION_MESSAGE);
                    } else if (ch1.isSelected() == true && weekdays.isSelectionEmpty() == true) {
                        JOptionPane.showMessageDialog(null, "you should select a day", "Warning", JOptionPane.INFORMATION_MESSAGE);
                    } else if ("".equals(textp.getText())) {
                        JOptionPane.showMessageDialog(null, "you didn't enter you reminder", "Warning", JOptionPane.INFORMATION_MESSAGE);
                    } else if (textp.getText().contains("#") || textp.getText().contains("\n") || year.getText().contains("#") || year.getText().contains("\n") || month.getText().contains("#") || month.getText().contains("\n") || dayno.getText().contains("#") || dayno.getText().contains("\n")) {
                        JOptionPane.showMessageDialog(null, "you can't include # or break lines in your input!", "Warning", JOptionPane.INFORMATION_MESSAGE);
                    } else if (ch1.isSelected()) {
                        Mission_Data.Rweek.add(weekdays.getSelectedValue() + " " + clock1v  + " " + textp.getText());
                        alarmModel.clear();
                        for (int i = 0; i < Mission_Data.Rweek.size(); i++) {
                            alarmModel.addElement(Mission_Data.Rweek.get(i));
                        }
                        for (int i = 0; i < Mission_Data.Rdate.size(); i++) {
                            alarmModel.addElement(Mission_Data.Rdate.get(i));
                        }
                        plate.setVisible(false);

                    } else {
                        String work;
                        work = yearv + "/";
                        if ((monthv + "").length() == 1) {
                            work += '0' + monthv + "/";
                        } else {
                            work += monthv + "/";
                        }

                        if ((daynv + "").length() == 1) {
                            work += '0' + daynv;
                        } else {
                            work += daynv;
                        }

                        work += " ";
                        if ((clock2v + "").length() == 1) {
                            work += '0' + clock2v;
                        } else {
                            work += clock2v;
                        }
                        
                      
                        if (textp.getText().charAt(0) == ' ') {
                            work += textp.getText();
                        } else {
                            work += ' ' + textp.getText();
                        }

                        Mission_Data.Rdate.add(work);

                        alarmModel.clear();
                        for (int i = 0; i < Mission_Data.Rweek.size(); i++) {
                            alarmModel.addElement(Mission_Data.Rweek.get(i));
                        }
                        for (int i = 0; i < Mission_Data.Rdate.size(); i++) {
                            alarmModel.addElement(Mission_Data.Rdate.get(i));
                        }
                        plate.setVisible(false);

                    }

                } else {//enter edit code here
                    if (ch1.isSelected() == false && ch2.isSelected() == false) {
                        JOptionPane.showMessageDialog(null, "you should select timing system", "Warning", JOptionPane.INFORMATION_MESSAGE);
                    } else if (ch1.isSelected() == true && weekdays.isSelectionEmpty() == true) {
                        JOptionPane.showMessageDialog(null, "you should select a day", "Warning", JOptionPane.INFORMATION_MESSAGE);
                    } else if ("".equals(textp.getText())) {
                        JOptionPane.showMessageDialog(null, "you didn't enter you reminder", "Warning", JOptionPane.INFORMATION_MESSAGE);
                    } else if (textp.getText().contains("#") || textp.getText().contains("\n") || year.getText().contains("#") || year.getText().contains("\n") || month.getText().contains("#") || month.getText().contains("\n") || dayno.getText().contains("#") || dayno.getText().contains("\n")) {
                        JOptionPane.showMessageDialog(null, "you can't include # or break lines in your input!", "Warning", JOptionPane.INFORMATION_MESSAGE);
                    } else if (ch1.isSelected()) {
                        if (textp.getText().charAt(0) == ' ') {
                            Mission_Data.Rweek.set(alarms.getSelectedIndex(), weekdays.getSelectedValue() + " " + clock1v + textp.getText());
                        } else {
                            Mission_Data.Rweek.set(alarms.getSelectedIndex(), weekdays.getSelectedValue() + " " + clock1v + " " + textp.getText());
                        }
                        alarmModel.clear();
                        for (int i = 0; i < Mission_Data.Rweek.size(); i++) {
                            alarmModel.addElement(Mission_Data.Rweek.get(i));
                        }
                        for (int i = 0; i < Mission_Data.Rdate.size(); i++) {
                            alarmModel.addElement(Mission_Data.Rdate.get(i));
                        }
                        plate.setVisible(false);

                    } else if (ch2.isSelected()) {

                        String work;
                        work = yearv + "/";
                        if ((monthv + "").length() == 1) {
                            work += '0' + monthv + "/";
                        } else {
                            work += monthv + "/";
                        }

                        if ((daynv + "").length() == 1) {
                            work += '0' + daynv;
                        } else {
                            work += daynv;
                        }
                        work += " ";
                        if ((clock2v + "").length() == 1) {
                            work += '0' + clock2v;
                        } else {
                            work += clock2v;
                        }
                        work += " ";
                        if (textp.getText().charAt(0) == ' ') {
                            work += textp.getText();
                        } else {
                            work += ' ' + textp.getText();
                        }
                        Mission_Data.Rdate.set(alarms.getSelectedIndex() - Mission_Data.Rweek.size(), work);

                        alarmModel.clear();
                        for (int i = 0; i < Mission_Data.Rweek.size(); i++) {
                            alarmModel.addElement(Mission_Data.Rweek.get(i));
                        }
                        for (int i = 0; i < Mission_Data.Rdate.size(); i++) {
                            alarmModel.addElement(Mission_Data.Rdate.get(i));
                        }
                        plate.setVisible(false);

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
        ch1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (ch1.isSelected()) {
                    ch2.setSelected(false);
                    year.setVisible(false);
                    month.setVisible(false);
                    dayno.setVisible(false);
                    clock2.setVisible(false);
                    classic.setVisible(false);
                    weekdays.setEnabled(true);
                    clock1.setVisible(true);
                    }
            }
        });
        ch2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (ch2.isSelected()) {
                    ch1.setSelected(false);
                    clock1.setVisible(false);
                    year.setVisible(true);
                    month.setVisible(true);
                    dayno.setVisible(true);
                    classic.setVisible(true);
                    weekdays.setEnabled(false);
                    clock2.setVisible(true);
             }
            }
        });

        
        
        //system tray code
        PopupMenu popMenu = new PopupMenu();
        MenuItem item1 = new MenuItem("Main window");
        item1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                mainFrm.setVisible(true);

            }
        }); //adding action listener to item1

        MenuItem item2 = new MenuItem("All day work");
        item2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                Mission_Data.alarmMes();

            }
        }); //adding action listener to item1

        MenuItem item3 = new MenuItem("Exit");
        item3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                int k = JOptionPane.showConfirmDialog(null, "Do you want to save delete this item!");
                if (k == 0) {
                    Mission_Data.save("data.txt", "remind0.txt", "remind1.txt");
                    System.exit(0);
                } else if (k == 1) {
                    System.exit(0);
                }

            }
        }); //adding action listener to item1

        MenuItem item4 = new MenuItem("Message off");
        item4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                Mission_Data.remindclock.stop();
               
            }
        }); //adding action listener to item1

        MenuItem item5 = new MenuItem("Message on");
        item5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                Mission_Data.remindclock.start();
               
            }
        }); //adding action listener to item1

        popMenu.add(item1);
        popMenu.add(item2);

        popMenu.add(item3);
        popMenu.add(item4);
        popMenu.add(item5);
        

        Image img = Toolkit.getDefaultToolkit().getImage("1.png");
        TrayIcon trayIcon = new TrayIcon(img, "Time Management", popMenu);
        SystemTray.getSystemTray().add(trayIcon);

        //end of system tray code
        //////////////////////
    }

}
