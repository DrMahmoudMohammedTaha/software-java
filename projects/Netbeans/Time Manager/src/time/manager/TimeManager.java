/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package time.manager;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

/**
 *
 * @author Abo Ahmed
 */
public class TimeManager {

    public static boolean target = true;
    public static int noprofile = 0;

    public static void main(String[] args) throws IOException {
        //define package of reminder add and edit
        BufferedImage imgplate = ImageIO.read(new File("wood.jpg"));

        JLabel backgroundplate = new JLabel(new ImageIcon(imgplate));
        backgroundplate.setBounds(0, 0, 800, 400);

        JFrame plate = new JFrame("Edit and Add space!");
        plate.setBounds(650, 470, 400, 270);
        plate.setLayout(null);
        plate.setBackground(Color.BLACK);
        plate.add(backgroundplate, 0);

        JButton plateB = new JButton("Add");
        plateB.setBounds(10, 180, 100, 40);
        plateB.setForeground(Color.white);
        plateB.setBackground(Color.black);
        plateB.setFont(new Font("Bradley Hand ITC", Font.BOLD | Font.ITALIC, 22));
        plateB.repaint();
        plate.add(plateB, 0);

        JTextArea textp = new JTextArea();
        textp.setForeground(Color.BLACK);
        textp.setBackground(Color.white);
        textp.setFont(new Font("Arial", Font.BOLD, 15));
        textp.repaint();
        JScrollPane holderp = new JScrollPane(textp);
        holderp.setBounds(10, 120, 370, 40);
        plate.add(holderp, 0);

        JCheckBox ch1 = new JCheckBox("week style");
        ch1.setForeground(Color.BLACK);
        ch1.setBackground(Color.orange);
        ch1.setFont(new Font("Arial", Font.BOLD, 15));
        ch1.setBounds(10, 10, 100, 20);
        ch1.repaint();
        plate.add(ch1, 0);

        JCheckBox ch2 = new JCheckBox("date style");
        ch2.setForeground(Color.BLACK);
        ch2.setBackground(Color.orange);
        ch2.setFont(new Font("Arial", Font.BOLD, 15));
        ch2.setBounds(10, 65, 100, 20);
        ch2.repaint();
        plate.add(ch2, 0);

        JList weekdays = new JList();
        weekdays.setForeground(Color.black);
        weekdays.setBackground(Color.orange);
        weekdays.setFont(new Font("Courier New", Font.BOLD, 15));
        weekdays.repaint();
        JScrollPane wp = new JScrollPane(weekdays);
        wp.setBounds(130, 10, 120, 25);
        plate.add(wp, 0);
        DefaultListModel weekdaysModel = new DefaultListModel();
        weekdays.setModel(weekdaysModel);
        weekdaysModel.addElement("Saturday");
        weekdaysModel.addElement("Sunday");
        weekdaysModel.addElement("Monday");
        weekdaysModel.addElement("Tuesday");
        weekdaysModel.addElement("Wednesday");
        weekdaysModel.addElement("Thursday");
        weekdaysModel.addElement("Friday");

        JLabel classic = new JLabel("year          month           day");
        classic.setBounds(140, 40, 200, 30);
        classic.setForeground(Color.WHITE);
        classic.setBackground(Color.yellow);//doesnt work
        classic.setFont(new Font("serif", Font.BOLD, 15));
        classic.repaint();
        plate.add(classic, 0);

        JTextArea year = new JTextArea();
        year.setForeground(Color.BLACK);
        year.setBackground(Color.white);
        year.setFont(new Font("Arial", Font.BOLD, 15));
        year.repaint();
        year.setBounds(135, 70, 40, 20);
        plate.add(year, 0);

        JTextArea month = new JTextArea();
        month.setForeground(Color.BLACK);
        month.setBackground(Color.white);
        month.setFont(new Font("Arial", Font.BOLD, 15));
        month.repaint();
        month.setBounds(210, 70, 40, 20);
        plate.add(month, 0);

        JTextArea dayno = new JTextArea();
        dayno.setForeground(Color.BLACK);
        dayno.setBackground(Color.white);
        dayno.setFont(new Font("Arial", Font.BOLD, 15));
        dayno.repaint();
        dayno.setBounds(285, 70, 40, 20);
        plate.add(dayno, 0);

        ch1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (ch1.isSelected()) {
                    ch2.setSelected(false);
                    year.setVisible(false);
                    month.setVisible(false);
                    dayno.setVisible(false);
                    classic.setVisible(false);
                    weekdays.setEnabled(true);
                }
            }
        });
        ch2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (ch2.isSelected()) {
                    ch1.setSelected(false);
                    year.setVisible(true);
                    month.setVisible(true);
                    dayno.setVisible(true);
                    classic.setVisible(true);
                    weekdays.setEnabled(false);
                }
            }
        });

        //end of package of reminder add and edit
        //define package of reminder
        BufferedReader br0 = new BufferedReader(new FileReader("remind0.txt"));
        BufferedReader br1 = new BufferedReader(new FileReader("remind1.txt"));
        ArrayList<String> Rweek = new ArrayList();
        ArrayList<String> Rdate = new ArrayList();
        ArrayList <String> safty = new ArrayList();
        if (br0.ready()) {
            String hang = br0.readLine();

            String R0[] = hang.split("#");
            for (int i = 0; i < R0.length; i++) {
                Rweek.add(R0[i]);

            }

        }
        if (br1.ready()) {
            String hang = br1.readLine();

            String R1[] = hang.split("#");
            for (int i = 0; i < R1.length; i++) {
                Rdate.add(R1[i]);

            }

        }
        
        BufferedImage imgReminder = ImageIO.read(new File("wood.jpg"));

        JLabel backgroundReminder = new JLabel(new ImageIcon(imgReminder));
        backgroundReminder.setBounds(0, 0, 800, 400);

        JFrame reminder = new JFrame("REMINDER!");
        reminder.setBounds(200, 470, 400, 270);
        reminder.setLayout(null);
        reminder.setBackground(Color.BLACK);
        reminder.add(backgroundReminder, 0);

        JButton Radd = new JButton("Add");
        Radd.setBounds(10, 20, 100, 40);
        Radd.setForeground(Color.white);
        Radd.setBackground(Color.black);
        Radd.setFont(new Font("Bradley Hand ITC", Font.BOLD | Font.ITALIC, 22));
        Radd.repaint();
        reminder.add(Radd, 0);

        Radd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                plate.setVisible(true);
                plateB.setText("Add");
                ch1.setSelected(false);
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
                weekdays.clearSelection();
            }
        });
        JButton Redit = new JButton("Edit");
        Redit.setBounds(10, 80, 100, 40);
        Redit.setForeground(Color.white);
        Redit.setBackground(Color.black);
        Redit.setFont(new Font("Bradley Hand ITC", Font.BOLD | Font.ITALIC, 22));
        Redit.repaint();
        reminder.add(Redit, 0);

        JButton alarm = new JButton("Alarm");
        alarm.setBounds(10, 140, 100, 40);
        alarm.setForeground(Color.white);
        alarm.setBackground(Color.black);
        alarm.setFont(new Font("Bradley Hand ITC", Font.BOLD | Font.ITALIC, 22));
        alarm.repaint();
        reminder.add(alarm, 0);

        JList alarms = new JList();
        alarms.setForeground(Color.black);
        alarms.setBackground(Color.orange);
        alarms.setFont(new Font("Courier New", Font.BOLD, 18));
        alarms.repaint();
        JScrollPane Rp = new JScrollPane(alarms);
        Rp.setBounds(130, 10, 230, 180);
        reminder.add(Rp, 0);
        DefaultListModel alarmModel = new DefaultListModel();
        alarms.setModel(alarmModel);

        alarms.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    if (alarms.getSelectedIndex() + 1 <= Rweek.size()) {
                        int k = JOptionPane.showConfirmDialog(null, "Do you want to delete this week alarm!");
                        if (k == 0) {
                            Rweek.remove(alarms.getSelectedIndex());
                        }
                    } else {
                        int k = JOptionPane.showConfirmDialog(null, "Do you want to delete this date alarm!");
                        if (k == 0) {
                            Rdate.remove(alarms.getSelectedIndex() - Rweek.size());
                        }
                    }
                    alarmModel.clear();
                    for (int i = 0; i < Rweek.size(); i++) {
                        alarmModel.addElement(Rweek.get(i));
                    }
                    for (int i = 0; i < Rdate.size(); i++) {
                        alarmModel.addElement(Rdate.get(i));
                    }

                }
            }
        });

        Redit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (alarms.isSelectionEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please, select an item to edit it!", "Warning", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    plate.setVisible(true);
                    plateB.setText("Edit");
                    ch1.setSelected(false);
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
                    weekdays.clearSelection();
                    if (alarms.getSelectedIndex() + 1 <= Rweek.size()) {
                        ch1.setSelected(true);
                        String maker[] = Rweek.get(alarms.getSelectedIndex()).split(" ");
                        for (int i = 1; i < maker.length; i++) {
                            textp.setText(textp.getText() + " " + maker[i]);
                        }
                    } else {
                        ch2.setSelected(true);
                        String maker[] = Rdate.get(alarms.getSelectedIndex() - Rweek.size()).split(" ");
                        String make[] = maker[0].split("/");
                        year.setText(make[0]);
                        month.setText(make[1]);
                        dayno.setText(make[2]);
                        for (int i = 1; i < maker.length; i++) {
                            textp.setText(textp.getText() + " " + maker[i]);
                        }
                    }
                }
            }
        });

        plateB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                

                if (plateB.getText() == "Add") {

                    //your main code here}
                    if (ch1.isSelected() == false && ch2.isSelected() == false) {
                    JOptionPane.showMessageDialog(null, "you should select timing system", "Warning", JOptionPane.INFORMATION_MESSAGE);
                } else if (ch1.isSelected() == true && weekdays.isSelectionEmpty() == true) {
                    JOptionPane.showMessageDialog(null, "you should select a day", "Warning", JOptionPane.INFORMATION_MESSAGE);
                } else if (ch2.isSelected() == true && ("".equals(year.getText()) || "".equals(month.getText()) || "".equals(dayno.getText()))) {
                    JOptionPane.showMessageDialog(null, "you should enter the full date", "Warning", JOptionPane.INFORMATION_MESSAGE);
                } else if ("".equals(textp.getText())) {
                    JOptionPane.showMessageDialog(null, "you didn't enter you reminder", "Warning", JOptionPane.INFORMATION_MESSAGE);
                }   
                else if(textp.getText().contains("#")|| textp.getText().contains("\n")||year.getText().contains("#")|| year.getText().contains("\n")||month.getText().contains("#")|| month.getText().contains("\n")||dayno.getText().contains("#")|| dayno.getText().contains("\n"))
                {
                     JOptionPane.showMessageDialog(null, "you can't include # or break lines in your input!", "Warning", JOptionPane.INFORMATION_MESSAGE);
                }
                    else if (ch1.isSelected()) {
                            Rweek.add(weekdays.getSelectedValue() + " " + textp.getText());
                    alarmModel.clear();
                        for (int i = 0; i < Rweek.size(); i++) {
                            alarmModel.addElement(Rweek.get(i));
                        }
                        for (int i = 0; i < Rdate.size(); i++) {
                            alarmModel.addElement(Rdate.get(i));
                        }
                        plate.setVisible(false);
     
                    } else {
                            String work ;
                        work =year.getText() + "/" ;
                            if(month.getText().length() == 1)
                                work +='0'+ month.getText() + "/";  
                            else
                                work += month.getText() + "/";
                            
                            if(dayno.getText().length() == 1)
                                work +='0'+ dayno.getText() ;  
                            else
                                work += dayno.getText() ;
                            
                              if(textp.getText().charAt(0) == ' ')
                            work += textp.getText() ;
                            else
                            work += ' '+ textp.getText() ;
                          
                            Rdate.add(work);
                                    
                   
                                    
                                    alarmModel.clear();
                        for (int i = 0; i < Rweek.size(); i++) {
                            alarmModel.addElement(Rweek.get(i));
                        }
                        for (int i = 0; i < Rdate.size(); i++) {
                            alarmModel.addElement(Rdate.get(i));
                        }
                        plate.setVisible(false);
     
                    }
                                           
                } else {//enter edit code here
                    if (ch1.isSelected() == false && ch2.isSelected() == false) {
                    JOptionPane.showMessageDialog(null, "you should select timing system", "Warning", JOptionPane.INFORMATION_MESSAGE);
                } else if (ch1.isSelected() == true && weekdays.isSelectionEmpty() == true) {
                    JOptionPane.showMessageDialog(null, "you should select a day", "Warning", JOptionPane.INFORMATION_MESSAGE);
                } else if (ch2.isSelected() == true && ("".equals(year.getText()) || "".equals(month.getText()) || "".equals(dayno.getText()))) {
                    JOptionPane.showMessageDialog(null, "you should enter the full date", "Warning", JOptionPane.INFORMATION_MESSAGE);
                } else if ("".equals(textp.getText())) {
                    JOptionPane.showMessageDialog(null, "you didn't enter you reminder", "Warning", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(textp.getText().contains("#")|| textp.getText().contains("\n")||year.getText().contains("#")|| year.getText().contains("\n")||month.getText().contains("#")|| month.getText().contains("\n")||dayno.getText().contains("#")|| dayno.getText().contains("\n"))
                {
                     JOptionPane.showMessageDialog(null, "you can't include # or break lines in your input!", "Warning", JOptionPane.INFORMATION_MESSAGE);
                }
                    else    if (ch1.isSelected()) {
                        if(textp.getText().charAt(0)==' ')
                            Rweek.set(alarms.getSelectedIndex(),weekdays.getSelectedValue() + textp.getText());
                        else
                            Rweek.set(alarms.getSelectedIndex(),weekdays.getSelectedValue() + " "+textp.getText());
                        alarmModel.clear();
                        for (int i = 0; i < Rweek.size(); i++) {
                            alarmModel.addElement(Rweek.get(i));
                        }
                        for (int i = 0; i < Rdate.size(); i++) {
                            alarmModel.addElement(Rdate.get(i));
                        }
                        plate.setVisible(false);
                    
                    } else if (ch2.isSelected()){
                        
                        String work ;
                        work = year.getText() + "/" ;
                            if(month.getText().length() == 1)
                                work +='0'+ month.getText() + "/";  
                            else
                                work += month.getText() + "/";
                            
                            if(dayno.getText().length() == 1)
                                work +='0'+ dayno.getText() ;  
                            else
                                work +=  dayno.getText() ;
                            
                            if(textp.getText().charAt(0) == ' ')
                            work += textp.getText() ;
                            else
                            work += ' '+ textp.getText() ;
                            Rdate.set( alarms.getSelectedIndex() - Rweek.size(),work);
                                    
                   
                        alarmModel.clear();
                        for (int i = 0; i < Rweek.size(); i++) {
                            alarmModel.addElement(Rweek.get(i));
                        }
                        for (int i = 0; i < Rdate.size(); i++) {
                            alarmModel.addElement(Rdate.get(i));
                        }
                        plate.setVisible(false);
                    
                    }
                    
                }
            }
        });
        //end of reminder package
        BufferedImage img = ImageIO.read(new File("wood.jpg"));

        JLabel background = new JLabel(new ImageIcon(img));
        background.setBounds(0, 0, 800, 400);
        //making a frame
        JFrame root = new JFrame("TIME MANAGER, PEACE BE UPON YOU");
        root.setBounds(200, 50, 800, 400);
        root.setLayout(null);
        root.setBackground(Color.BLACK);
        root.setVisible(true);
        root.add(background, 0);
        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        root.setVisible(true);

        JLabel Time = new JLabel();
        Time.setBounds(10, 10, 400, 40);
        Time.setForeground(Color.ORANGE);
        Time.setBackground(Color.yellow);//doesnt work
        Time.setFont(new Font("serif", Font.BOLD, 30));
        Time.repaint();
        root.add(Time, 0);
        JLabel day = new JLabel();
        day.setBounds(10, 50, 200, 40);
        day.setForeground(Color.ORANGE);
        day.setBackground(Color.yellow);//doesnt work
        day.setFont(new Font("serif", Font.BOLD, 30));
        day.repaint();
        root.add(day, 0);

        //define my button without functions
        JButton remind = new JButton("reminder");
        remind.setBounds(190, 240, 130, 40);
        remind.setForeground(Color.white);
        remind.setBackground(Color.RED);//doesnt work
        remind.setFont(new Font("Bradley Hand ITC", Font.BOLD | Font.ITALIC, 22));
        remind.repaint();
        root.add(remind, 0);

        remind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                reminder.setVisible(true);
                alarmModel.clear();
                for (int i = 0; i < Rweek.size(); i++) {
                    alarmModel.addElement(Rweek.get(i));
                }
                for (int i = 0; i < Rdate.size(); i++) {
                    alarmModel.addElement(Rdate.get(i));
                }
            }
        });

        JButton save = new JButton("save");
        save.setBounds(100, 300, 80, 40);
        save.setForeground(Color.white);
        save.setBackground(Color.BLACK);//doesnt work
        save.setFont(new Font("Bradley Hand ITC", Font.BOLD | Font.ITALIC, 24));
        save.repaint();
        root.add(save, 0);

        JButton Exit = new JButton("Exit");
        Exit.setBounds(10, 300, 80, 40);
        Exit.setForeground(Color.white);
        Exit.setBackground(Color.BLACK);//doesnt work
        Exit.setFont(new Font("Bradley Hand ITC", Font.BOLD | Font.ITALIC, 24));
        Exit.repaint();
        root.add(Exit, 0);

        JButton delete = new JButton("Delete All");
        delete.setBounds(10, 200, 140, 40);
        delete.setForeground(Color.white);
        delete.setBackground(Color.BLACK);//doesnt work
        delete.setFont(new Font("Bradley Hand ITC", Font.BOLD | Font.ITALIC, 24));
        delete.repaint();
        root.add(delete, 0);
        JButton edit = new JButton("Edit");
        edit.setBounds(10, 250, 80, 40);
        edit.setForeground(Color.orange);
        edit.setBackground(Color.black);
        edit.setFont(new Font("Bradley Hand ITC", Font.BOLD | Font.ITALIC, 24));
        edit.repaint();
        root.add(edit, 0);

        JButton search = new JButton("Search");
        search.setBounds(10, 150, 140, 40);
        search.setForeground(Color.orange);
        search.setBackground(Color.black);
        search.setFont(new Font("Bradley Hand ITC", Font.BOLD | Font.ITALIC, 24));
        search.repaint();
        root.add(search, 0);

        JButton Add = new JButton("Add");
        Add.setBounds(100, 250, 80, 40);
        Add.setForeground(Color.orange);
        Add.setBackground(Color.black);
        Add.setFont(new Font("Bradley Hand ITC", Font.BOLD | Font.ITALIC, 24));
        Add.repaint();
        root.add(Add, 0);

        JButton get = new JButton("Get out");
        get.setBounds(10, 100, 140, 40);
        get.setForeground(Color.white);
        get.setBackground(Color.BLACK);//doesnt work
        get.setFont(new Font("Bradley Hand ITC", Font.BOLD | Font.ITALIC, 24));
        get.repaint();
        root.add(get, 0);

        JTextArea text = new JTextArea();
        text.setForeground(Color.orange);
        text.setBackground(Color.BLACK);
        text.setFont(new Font("Arial", Font.BOLD, 15));
        text.repaint();
        JScrollPane holder = new JScrollPane(text);
        holder.setBounds(190, 290, 570, 60);
        root.add(holder, 0);

        JList profile = new JList();
        profile.setForeground(Color.orange);
        profile.setBackground(Color.black);
        profile.setFont(new Font("Courier New", Font.BOLD, 18));
        profile.repaint();
        JScrollPane pp = new JScrollPane(profile);
        pp.setBounds(160, 60, 160, 170);
        root.add(pp, 0);
        DefaultListModel profileModel = new DefaultListModel();
        profile.setModel(profileModel);

        JList mission = new JList();
        mission.setForeground(Color.black);
        mission.setBackground(Color.orange);
        mission.setFont(new Font("Segoe UI", Font.BOLD, 18));
        mission.repaint();
        JScrollPane mp = new JScrollPane(mission);
        mp.setBounds(350, 20, 400, 250);
        root.add(mp, 0);
        DefaultListModel missionModel = new DefaultListModel();
        mission.setModel(missionModel);

        DateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd --- HH:mm:ss");
        DateFormat dateFormat2 = new SimpleDateFormat("EEEE");
        Date dateday = new Date();
        day.setText(dateFormat2.format(dateday));
        
        if(!Rweek.isEmpty())
            for (int i = 0; i < Rweek.size(); i++) {
                if(Rweek.get(i).contains(day.getText()))
                    safty.add(Rweek.get(i));
            }
       String hanger []= dateFormat1.format(new Date()).substring(0, 10).split("/");
       if(!Rdate.isEmpty())
           for (int i = 0; i < Rdate.size(); i++) {
               String nower [] = Rdate.get(i).substring(0, 10).split("/");
                if(Integer.parseInt(hanger[0].trim())>Integer.parseInt(nower[0].trim()))
                    safty.add(Rdate.get(i));
                else if(Integer.parseInt(hanger[0].trim())==Integer.parseInt(nower[0].trim()) && Integer.parseInt(hanger[1].trim())>Integer.parseInt(nower[1].trim()))
                    safty.add(Rdate.get(i));
                else if(Integer.parseInt(hanger[0].trim())==Integer.parseInt(nower[0].trim()) && Integer.parseInt(hanger[1].trim())==Integer.parseInt(nower[1].trim()) && Integer.parseInt(hanger[2].trim())>=Integer.parseInt(nower[2].trim()))
                    safty.add(Rdate.get(i));
                    }
       String forward = ""; 
       for (int i = 0; i < safty.size(); i++) {
            forward += safty.get(i)+"\n";
        }
        JOptionPane.showMessageDialog(null, "Your missions today! \n"+forward, "INFORMATION", JOptionPane.INFORMATION_MESSAGE);   
        //update time stimunuously
        ArrayList< ArrayList<String>> folder = new ArrayList();
        //here i start my events
        //getting all data form the saved file
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        String saving = br.readLine();
        String blocks[] = saving.split("#");

        noprofile = Integer.parseInt(blocks[0]);
        if (noprofile != 0) {
            for (int i = 1; i < blocks.length; i++) {
                String details[] = blocks[i].split("@");
                ArrayList<String> need = new ArrayList();
                for (int j = 0; j < details.length; j++) {
                    need.add(details[j]);
                }
                folder.add(need);
                if (folder.get(i - 1).size() > 1) {
                    profileModel.addElement((i) + " - " + folder.get(i - 1).get(1));
                }
            }
        }
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ("".equals(text.getText())) {
                    JOptionPane.showMessageDialog(null, "No text found", "Warning", JOptionPane.INFORMATION_MESSAGE);
                } else if (text.getText().contains("@") || text.getText().contains("#") || text.getText().contains("\n")) {
                    JOptionPane.showMessageDialog(null, "you can't include # or @ or break lines in your profile  or mission name", "Warning", JOptionPane.INFORMATION_MESSAGE);
                } else if (target && !profile.isSelectionEmpty()) {

                    folder.get(profile.getSelectedIndex()).set(1, text.getText().trim());
                    profileModel.setElementAt((profile.getSelectedIndex() + 1) + " - " + text.getText().trim(), profile.getSelectedIndex());

                } else if (!mission.isSelectionEmpty()) {
                    folder.get(profile.getSelectedIndex()).set(mission.getSelectedIndex() + 2, text.getText().trim());
                    missionModel.setElementAt((mission.getSelectedIndex() + 1) + " - " + text.getText().trim(), mission.getSelectedIndex());
                }

            }
        });

        Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ("".equals(text.getText())) {
                    JOptionPane.showMessageDialog(null, "No text found", "Warning", JOptionPane.INFORMATION_MESSAGE);
                } else if (text.getText().contains("@") || text.getText().contains("#") || text.getText().contains("\n")) {
                    JOptionPane.showMessageDialog(null, "you can't include # or @ or break lines in your profile or mission name", "Warning", JOptionPane.INFORMATION_MESSAGE);
                } else if (target) {
                    noprofile++;
                    ArrayList<String> moment = new ArrayList();
                    moment.add("0");
                    moment.add(text.getText().trim());
                    folder.add(new ArrayList(moment));
                    profileModel.addElement(noprofile + " - " + text.getText().trim());

                } else if (!profile.isSelectionEmpty()) {
                    folder.get(profile.getSelectedIndex()).set(0, (Integer.parseInt(folder.get(profile.getSelectedIndex()).get(0)) + 1) + "");
                    folder.get(profile.getSelectedIndex()).add(text.getText().trim());
                    missionModel.addElement(Integer.parseInt(folder.get(profile.getSelectedIndex()).get(0)) + " - " + text.getText().trim());
                }

            }
        });
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ("".equals(text.getText())) {
                    JOptionPane.showMessageDialog(null, "No text found", "Warning", JOptionPane.INFORMATION_MESSAGE);
                } else if (target) {
                    ArrayList<String> container = new ArrayList();
                    for (int i = 0; i < folder.size(); i++) {
                        if (folder.get(i).get(1).toLowerCase().contains(text.getText().toLowerCase())) {
                            container.add(i + "");
                        }
                    }

                    if (container.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Not found", "Information", JOptionPane.INFORMATION_MESSAGE);
                    } else if (container.size() == 1) {
                        profile.setSelectedIndex(Integer.parseInt(container.get(0)));

                    } else {
                        String datalist = "";
                        for (int i = 0; i < container.size(); i++) {
                            datalist += "profile no: " + (Integer.parseInt(container.get(i)) + 1) + "\n";
                        }
                        JOptionPane.showMessageDialog(null, datalist, "Information", JOptionPane.INFORMATION_MESSAGE);

                    }

                } else {
                    ArrayList<String> container = new ArrayList();
                    for (int i = 0; i < folder.size(); i++) {
                        for (int j = 2; j < folder.get(i).size(); j++) {
                            if (folder.get(i).get(j).toLowerCase().contains(text.getText().toLowerCase())) {
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
                        for (int i = 2; i < folder.get(profile.getSelectedIndex()).size(); i++) {
                            missionModel.addElement((i - 1) + " - " + folder.get(profile.getSelectedIndex()).get(i));
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
        });
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                int k = JOptionPane.showConfirmDialog(null, "Do you want to save changes!");
                if (k == 0) {

                    FileWriter file;
                    try {
                        file = new FileWriter("data.txt");
                        BufferedWriter bf = new BufferedWriter(file);
                        String datalist = "";
                        datalist += noprofile + "#";

                        for (int i = 0; i < folder.size(); i++) {
                            for (int j = 0; j < folder.get(i).size(); j++) {
                                datalist += folder.get(i).get(j) + "@";
                            }
                            datalist += "#";

                        }

                        bf.write(datalist);

                        bf.close();

                    } catch (IOException ex) {
                        Logger.getLogger(TimeManager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //saving reminder data
                    FileWriter fileweek;
                    try {
                        fileweek = new FileWriter("remind0.txt");
                        BufferedWriter bf = new BufferedWriter(fileweek);
                        String datalist = "";
                        for (int i = 0; i < Rweek.size(); i++) {
                            datalist += Rweek.get(i) + "#";
                        }
                        bf.write(datalist);
                        bf.close();
                    } catch (IOException ex) {
                        Logger.getLogger(TimeManager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    FileWriter filedate;
                    try {
                        filedate = new FileWriter("remind1.txt");
                        BufferedWriter bf = new BufferedWriter(filedate);
                        String datalist = "";
                        for (int i = 0; i < Rdate.size(); i++) {
                            datalist += Rdate.get(i) + "#";
                        }
                        bf.write(datalist);
                        bf.close();
                    } catch (IOException ex) {
                        Logger.getLogger(TimeManager.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    //end of saving reminder data
                    System.exit(0);
                } else if (k == 1) {
                    System.exit(0);
                }
            }
        });

        get.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (noprofile == 0) {
                    JOptionPane.showMessageDialog(null, "No thing to get out", "Information", JOptionPane.INFORMATION_MESSAGE);

                } else if (!profile.isSelectionEmpty()) {
                    FileWriter file;
                    try {
                        JOptionPane.showMessageDialog(null, "Finished...", "Information", JOptionPane.INFORMATION_MESSAGE);
                        file = new FileWriter("output.txt");
                        BufferedWriter bf = new BufferedWriter(file);
                        //here you should have your profiles missions
                        for (int i = 1; i <= Integer.parseInt(folder.get(profile.getSelectedIndex()).get(0)) + 1; i++) {
                            if (i == 1) {
                                bf.append(folder.get(profile.getSelectedIndex()).get(i));
                            } else {
                                bf.append((i - 1) + " - " + folder.get(profile.getSelectedIndex()).get(i));
                            }

                            bf.newLine();
                        }
                        bf.close();

                    } catch (IOException ex) {
                        Logger.getLogger(TimeManager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                int k = JOptionPane.showConfirmDialog(null, "are you sure to delete all data!");
                if (k == 0) {
                    folder.clear();
                    profileModel.clear();
                    missionModel.clear();
                    noprofile = 0;
                    JOptionPane.showMessageDialog(null, "All data have been deleted!", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                FileWriter file;
                try {
                    file = new FileWriter("data.txt");
                    BufferedWriter bf = new BufferedWriter(file);
                    String datalist = "";
                    datalist += noprofile + "#";

                    for (int i = 0; i < folder.size(); i++) {
                        for (int j = 0; j < folder.get(i).size(); j++) {
                            datalist += folder.get(i).get(j) + "@";
                        }
                        datalist += "#";

                    }

                    bf.write(datalist);

                    bf.close();
                    JOptionPane.showMessageDialog(null, "All data have been saved!", "Information", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    Logger.getLogger(TimeManager.class.getName()).log(Level.SEVERE, null, ex);
                }

                //saving reminder data
                FileWriter fileweek;
                try {
                    fileweek = new FileWriter("remind0.txt");
                    BufferedWriter bf = new BufferedWriter(fileweek);
                    String datalist = "";
                    for (int i = 0; i < Rweek.size(); i++) {
                        datalist += Rweek.get(i) + "#";
                    }
                    bf.write(datalist);
                    bf.close();
                } catch (IOException ex) {
                    Logger.getLogger(TimeManager.class.getName()).log(Level.SEVERE, null, ex);
                }
                FileWriter filedate;
                try {
                    filedate = new FileWriter("remind1.txt");
                    BufferedWriter bf = new BufferedWriter(filedate);
                    String datalist = "";
                    for (int i = 0; i < Rdate.size(); i++) {
                        datalist += Rdate.get(i) + "#";
                    }
                    bf.write(datalist);
                    bf.close();
                } catch (IOException ex) {
                    Logger.getLogger(TimeManager.class.getName()).log(Level.SEVERE, null, ex);
                }

                //end of saving reminder data
            }
        });

        profile.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 1) {

                    if (!profile.isSelectionEmpty()) {
                        missionModel.clear();
                        for (int i = 0; i < Integer.parseInt(folder.get(profile.getSelectedIndex()).get(0)); i++) {
                            missionModel.addElement((i + 1) + " - " + folder.get(profile.getSelectedIndex()).get(i + 2));
                        }
                    }

                    if (!profileModel.isEmpty() && !profile.isSelectionEmpty()) {
                        text.setText(folder.get(profile.getSelectedIndex()).get(1));
                    }
                    target = true;
                    text.setForeground(Color.orange);
                    text.setBackground(Color.black);
                    Add.setForeground(Color.orange);
                    Add.setBackground(Color.black);
                    search.setForeground(Color.orange);
                    search.setBackground(Color.black);
                    edit.setForeground(Color.orange);
                    edit.setBackground(Color.black);
                } else if (evt.getClickCount() == 2) {
                    int k = JOptionPane.showConfirmDialog(null, "Do you want to save delete this item!");
                    if (k == 0 && !profile.isSelectionEmpty()) {
                        noprofile--;
                        folder.remove(profile.getSelectedIndex());
                        missionModel.clear();
                        profileModel.clear();
                        for (int i = 0; i < folder.size(); i++) {
                            profileModel.addElement((i + 1) + " - " + folder.get(i).get(1));
                        }
                    }
                }
            }
        }
        );
        mission.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {

                if (evt.getClickCount() == 1) {
                    if (!profileModel.isEmpty() && !profile.isSelectionEmpty() && !mission.isSelectionEmpty()) {
                        text.setText(folder.get(profile.getSelectedIndex()).get(mission.getSelectedIndex() + 2));
                    }
                    target = false;
                    text.setForeground(Color.black);
                    text.setBackground(Color.orange);
                    Add.setForeground(Color.black);
                    Add.setBackground(Color.orange);
                    edit.setForeground(Color.black);
                    edit.setBackground(Color.orange);
                    search.setForeground(Color.black);
                    search.setBackground(Color.orange);
                } else if (evt.getClickCount() == 2) {
                    int k = JOptionPane.showConfirmDialog(null, "Do you want to delete this item!");
                    if (k == 0 && !profile.isSelectionEmpty() && !mission.isSelectionEmpty()) {
                        folder.get(profile.getSelectedIndex()).remove(mission.getSelectedIndex() + 2);
                        folder.get(profile.getSelectedIndex()).set(0, (Integer.parseInt(folder.get(profile.getSelectedIndex()).get(0)) - 1) + "");
                        missionModel.clear();
                        for (int i = 0; i <= Integer.parseInt(folder.get(profile.getSelectedIndex()).get(0)); i++) {
                            if (i != 0) {
                                missionModel.addElement((i) + " - " + folder.get(profile.getSelectedIndex()).get(i + 1));
                            }
                        }
                    }
                }
            }
        }
        );
        text.setToolTipText("Don't use # or @ in yout profiles or mission names not to confuse the program");
        get.setToolTipText("click here to get the specified profile out in your output text file");
        search.setToolTipText("click here to search about a mission contains you word");
        edit.setToolTipText("click here to adjust current target");
        Add.setToolTipText("click here to add to your current target");
        profile.setToolTipText("click here to target this list for add or edit");
        mission.setToolTipText("click here to target this list for add or edit");
        profile.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {

                if (event.getKeyCode() == 40) {

                    //your code here
                    if (!profile.isSelectionEmpty() && profile.getSelectedIndex() != noprofile - 1) {
                        text.setText(folder.get(profile.getSelectedIndex() + 1).get(1));
                        missionModel.clear();
                        for (int i = 0; i < Integer.parseInt(folder.get(profile.getSelectedIndex() + 1).get(0)); i++) {
                            missionModel.addElement((i + 1) + " - " + folder.get(profile.getSelectedIndex() + 1).get(i + 2));
                        }

                    }
                }
            }
        });
        profile.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {

                if (event.getKeyCode() == 38) {

                    //your code here
                    if (!profile.isSelectionEmpty() && profile.getSelectedIndex() != 0) {
                        text.setText(folder.get(profile.getSelectedIndex() - 1).get(1));
                        missionModel.clear();
                        for (int i = 0; i < Integer.parseInt(folder.get(profile.getSelectedIndex() - 1).get(0)); i++) {
                            missionModel.addElement((i + 1) + " - " + folder.get(profile.getSelectedIndex() - 1).get(i + 2));
                        }

                    }
                }
            }
        });
        ///////////////////////////////////
        mission.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
                if (event.getKeyCode() == 38 && !mission.isSelectionEmpty() && mission.getSelectedIndex() != 0 && !profile.isSelectionEmpty()) {
                    text.setText(folder.get(profile.getSelectedIndex()).get(mission.getSelectedIndex() + 1));
                }

            }
        });

        mission.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
                if (event.getKeyCode() == 40 && !mission.isSelectionEmpty() && mission.getSelectedIndex() != ((Integer.parseInt(folder.get(profile.getSelectedIndex()).get(0))) - 1) && !profile.isSelectionEmpty()) {
                    text.setText(folder.get(profile.getSelectedIndex()).get(mission.getSelectedIndex() + 3));
                }

            }
        });
         alarm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
              safty.clear();
        if(!Rweek.isEmpty())
            for (int i = 0; i < Rweek.size(); i++) {
                if(Rweek.get(i).contains(day.getText()))
                    safty.add(Rweek.get(i));
            }
       String hanger []= dateFormat1.format(new Date()).substring(0, 10).split("/");
       if(!Rdate.isEmpty())
           for (int i = 0; i < Rdate.size(); i++) {
               String nower [] = Rdate.get(i).substring(0, 10).split("/");
                if(Integer.parseInt(hanger[0].trim())>Integer.parseInt(nower[0].trim()))
                    safty.add(Rdate.get(i));
                else if(Integer.parseInt(hanger[0].trim())==Integer.parseInt(nower[0].trim()) && Integer.parseInt(hanger[1].trim())>Integer.parseInt(nower[1].trim()))
                    safty.add(Rdate.get(i));
                else if(Integer.parseInt(hanger[0].trim())==Integer.parseInt(nower[0].trim()) && Integer.parseInt(hanger[1].trim())==Integer.parseInt(nower[1].trim()) && Integer.parseInt(hanger[2].trim())>=Integer.parseInt(nower[2].trim()))
                    safty.add(Rdate.get(i));
                    }
       
       String forward = ""; 
       for (int i = 0; i < safty.size(); i++) {
            forward += safty.get(i)+"\n";
        }
        JOptionPane.showMessageDialog(null, "Your missions today! \n"+forward, "INFORMATION", JOptionPane.INFORMATION_MESSAGE);   

            
            }});
        //for timer affairs 
       
        ////////////////
        while (true) {
       
            Time.setText(dateFormat1.format(new Date()));
        }

    }

}
