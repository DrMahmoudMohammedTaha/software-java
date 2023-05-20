package manager;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class Manager {

    static int first_index, second_index;
    static boolean dragged = false, home = false;
    //theme space
    static theme[] themes = {new theme("sky.jpg", Color.BLUE, Color.WHITE), new theme("flower.jpg", Color.BLACK, Color.WHITE), new theme("wood.jpg", Color.ORANGE, Color.BLACK)};
    static theme th = readTheme("theme.txt");

    static JLabel lMain = new JLabel();
    static JLabel lSearch = new JLabel();
    static JFrame mainFrm = GUI_Ruler.addFrm(lMain, false, false, 200, 50, 800, 400, "TIME MANAGER, PEACE BE UPON YOU", th, "1.png", false);
    static JLabel Time = GUI_Ruler.addLbl(10, 10, 400, 40, "", th, mainFrm);
    static JLabel day = GUI_Ruler.addLbl(10, 50, 200, 40, "", th, mainFrm);
    static JButton save = GUI_Ruler.addBtn(100, 300, 80, 40, "save", th, mainFrm);
    static JButton Exit = GUI_Ruler.addBtn(10, 300, 80, 40, "Exit", th, mainFrm);
    static JButton deleteAll = GUI_Ruler.addBtn(10, 200, 140, 40, "Delete All", th, mainFrm);
    static JButton edit = GUI_Ruler.addBtn(10, 250, 80, 40, "Edit", th, mainFrm);
    static JButton search = GUI_Ruler.addBtn(10, 100, 140, 40, "Search", th, mainFrm);
    static JButton oneDelete = GUI_Ruler.addBtn(10, 100, 140, 40, "Delete", th, mainFrm);
    static JButton Add = GUI_Ruler.addBtn(10, 100, 80, 40, "Add", th, mainFrm);
    static JButton Mekka = GUI_Ruler.addBtn(752, 30, 40, 40, "", th, mainFrm);
    static JButton monthly = GUI_Ruler.addBtn(752, 80, 40, 40, "", th, mainFrm);
    static JButton daily = GUI_Ruler.addBtn(752, 130, 40, 40, "", th, mainFrm);
    static JButton today = GUI_Ruler.addBtn(752, 180, 40, 40, "", th, mainFrm);
    static JButton general = GUI_Ruler.addBtn(752, 230, 40, 40, "", th, mainFrm);
    static JTextArea text = GUI_Ruler.addtxt(190, 285, 570, 70, "", th, mainFrm);
    static JScrollPane holderText = new JScrollPane(text);
    static JList profile = new JList();
    static JScrollPane pp = new JScrollPane(profile);
    static DefaultListModel profileModel = new DefaultListModel();
    static JList mission = new JList();
    static JScrollPane mp = new JScrollPane(mission);
    static DefaultListModel missionModel = new DefaultListModel();

    //search tools
    static JList searchResults = new JList();
    static JScrollPane sr = new JScrollPane(searchResults);
    static DefaultListModel searchModel = new DefaultListModel();
    static JFrame searchFrm = GUI_Ruler.addFrm(lSearch, false, false, 20, 480, 400, 270, "Search Results!", th, "1.png", false);
    static Component[] totalCommts = {Mekka, monthly, daily, today, general, day, save, Time, Add, edit, Exit, search, profile, searchResults, text, oneDelete, deleteAll};

    public static theme readTheme(String path4) {
        theme t = new theme();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path4));
            if (br.ready()) {

                t.desktop = br.readLine();
                String s = br.readLine();
                t.c1 = new Color(Integer.parseInt(s.split(" ")[0]), Integer.parseInt(s.split(" ")[1]), Integer.parseInt(s.split(" ")[2]));

                s = br.readLine();
                t.c2 = new Color(Integer.parseInt(s.split(" ")[0]), Integer.parseInt(s.split(" ")[1]), Integer.parseInt(s.split(" ")[2]));

                if(br.readLine().equals("t"))
                    Mission_Data.valid = true;
                else 
                    Mission_Data.valid = false ;
                
                
            }
        } catch (Exception e) {
        }
        return t;
    }

    public static void refreshGUI() {

        Mekka.setIcon(new ImageIcon("mekka.jpg"));
        monthly.setIcon(new ImageIcon("month.png"));
        daily.setIcon(new ImageIcon("day.png"));
        today.setIcon(new ImageIcon("today.png"));
        general.setIcon(new ImageIcon("flag.png"));

        GUI_Ruler.makeVertical(search, deleteAll, oneDelete, edit, Exit);
        GUI_Ruler.makeHorizontal(edit, Add);
        GUI_Ruler.makeHorizontal(Exit, save);
        holderText.setBounds(190, 290, 570, 60);
        holderText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mainFrm.add(holderText, 0);
        GUI_Ruler.Changetheme(text, th);
        text.setLineWrap(true);
        
        profile.setFont(new Font("Courier New", Font.BOLD, 18));
        profile.repaint();
        pp.setBounds(160, 60, 160, 170);
        mainFrm.add(pp, 0);
        profile.setModel(profileModel);
        GUI_Ruler.ChangeReverseTheme(th, profile);
        GUI_Ruler.Changetheme(mission, th);
        mission.setFont(new Font("Segoe UI", Font.BOLD, 18));
        mission.repaint();
        mp.setBounds(325, 30, 400, 250);
        mainFrm.add(mp, 0);
        mission.setModel(missionModel);
        searchFrm.setLayout(null);

        mission.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        profile.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        searchResults.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        GUI_Ruler.Changetheme(search, th);
        searchResults.setFont(new Font("Courier New", Font.BOLD, 18));
        sr.setBounds(10, 10, 370, 220);
        searchResults.setModel(searchModel);
        searchFrm.add(sr, 0);

        Mission_Data.startTime(Time, day);
        profileModel.clear();
        missionModel.clear();
        Mission_Data.refresh(profileModel);

    }

    public static void main(String[] args) throws IOException, AWTException {

        //to change messege font size
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("WinSoft Thuluth", Font.BOLD, 15)));

        //frame adjust
        refreshGUI();
        
        Mission_Data.intial("data.txt", "home.txt");

        //keycodes,
        searchResults.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                //problem
            }
        });
        searchResults.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                if (!searchResults.isSelectionEmpty()) {
                    if (ke.getKeyCode() == 10) { // check the enter code
                        //problem
                    }
                }
            }
        });
        save.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                Mission_Data.save("data.txt", "theme.txt", "home.txt");

            }
        });
        deleteAll.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                int k = JOptionPane.showConfirmDialog(null, "are you sure to delete all data!");
                if (k == 0) {
                    Back.valid = true;
                    Back.action = "delete all";
                    Back.folderSafe = Back.colonize(Mission_Data.folder);
                    Mission_Data.folder.clear();
                    profileModel.clear();
                    missionModel.clear();
                    //alarmModel.clear();
                    Mission_Data.noProfile = 0;
                    JOptionPane.showMessageDialog(null, "All data have been deleted!", "Information", JOptionPane.INFORMATION_MESSAGE);

                }
            }

        });
        profile.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {

                if (!profile.isSelectionEmpty()) {
                    missionModel.clear();
                    for (int i = 0; i < Integer.parseInt(Mission_Data.folder.get(profile.getSelectedIndex()).get(0)); i++) {
                        missionModel.addElement((i + 1) + " M: " + Mission_Data.folder.get(profile.getSelectedIndex()).get(i + 2));
                    }

                    text.setText(Mission_Data.folder.get(profile.getSelectedIndex()).get(1));
                    text.setCaretPosition(0);
                }
                Mission_Data.target = true;
                GUI_Ruler.ChangeReverseTheme(th, text, Add, edit, oneDelete);

            }

        });
        mission.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (!profileModel.isEmpty() && !profile.isSelectionEmpty() && !mission.isSelectionEmpty()) {
                    text.setText(Mission_Data.folder.get(profile.getSelectedIndex()).get(mission.getSelectedIndex() + 2));
                    text.setCaretPosition(0);
                }
                Mission_Data.target = false;
                GUI_Ruler.Changetheme(th, text, Add, edit, oneDelete);

            }
        });
        profile.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                if (!profile.isSelectionEmpty()) {
                    if (ke.getKeyCode() == 127) {
                        int k = JOptionPane.showConfirmDialog(null, "Do you want to  delete this item!");
                        if (k == 0 && !profile.isSelectionEmpty()) {
                            Back.valid = true;
                            Back.action = "delete p";
                            Back.lastData = (ArrayList<String>) Mission_Data.folder.get(profile.getSelectedIndex()).clone();

                            Mission_Data.noProfile--;
                            Mission_Data.folder.remove(profile.getSelectedIndex());
                            missionModel.clear();
                            profileModel.clear();

                            for (int i = 0; i < Mission_Data.folder.size(); i++) {
                                profileModel.addElement((i + 1) + " M: " + Mission_Data.folder.get(i).get(1));
                            }
                        }
                        text.setText("");

                    } else if (ke.getKeyCode() == 10) {
                        mission.requestFocus(true);
                        mission.setSelectedIndex(0);
                        text.setText(mission.getSelectedValue().toString().replaceFirst("\\d+\\sM:\\s", ""));
                        text.setCaretPosition(0);
                        Mission_Data.target = false;
                        GUI_Ruler.Changetheme(th, text, Add, edit, oneDelete);
                    } else if (Character.isDigit(ke.getKeyChar())) {
                        //prolem

                    } else if (Character.isLetter(ke.getKeyChar())) {
                        for (int i = 0; i < Mission_Data.folder.size(); i++) {
                            if (Mission_Data.folder.get(i).get(1).charAt(0) == ke.getKeyChar()) //prolem
                            {
                                System.out.println("");
                            }
                        }

                    } else {
                        text.setText(Mission_Data.folder.get(profile.getSelectedIndex()).get(1));
                        text.setCaretPosition(0);
                        missionModel.clear();
                        for (int i = 0; i < Integer.parseInt(Mission_Data.folder.get(profile.getSelectedIndex()).get(0)); i++) {
                            missionModel.addElement((i + 1) + " M: " + Mission_Data.folder.get(profile.getSelectedIndex()).get(i + 2));
                        }
                    }
                }
            }
        });
        mission.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                if (!mission.isSelectionEmpty() && !profile.isSelectionEmpty()) {

                    if (ke.getKeyCode() == 127) {
                        int k = JOptionPane.showConfirmDialog(null, "Do you want to delete this item!");
                        if (k == 0 && !profile.isSelectionEmpty() && !mission.isSelectionEmpty()) {

                            Back.valid = true;
                            Back.action = "delete m";
                            Back.lastData = new ArrayList(mission.getSelectedValuesList());

                            Back.profileno = profile.getSelectedIndex();

                            ArrayList<String> x = new ArrayList(mission.getSelectedValuesList());
                            for (int i = 0; i < x.size(); i++) {
                                Mission_Data.folder.get(profile.getSelectedIndex()).remove(Integer.parseInt(x.get(i).split("M")[0].trim()) + 1 - i);

                            }
                            Mission_Data.folder.get(profile.getSelectedIndex()).set(0, (Integer.parseInt(Mission_Data.folder.get(profile.getSelectedIndex()).get(0)) - x.size()) + "");
                            missionModel.clear();
                            for (int i = 0; i <= Integer.parseInt(Mission_Data.folder.get(profile.getSelectedIndex()).get(0)); i++) {
                                if (i != 0) {
                                    missionModel.addElement((i) + " M: " + Mission_Data.folder.get(profile.getSelectedIndex()).get(i + 1));
                                }
                            }
                        }

                        text.setText("");
                    } else if (ke.getKeyCode() == 8) {

                        profile.requestFocus(true);

                        text.setText(profile.getSelectedValue().toString().replaceFirst("\\d+\\sM:\\s", ""));
                        text.setCaretPosition(0);
                        Mission_Data.target = true;
                        GUI_Ruler.ChangeReverseTheme(th, text, Add, edit, oneDelete);

                    } else if (Character.isDigit(ke.getKeyChar())) {

                    } else if (Character.isLetter(ke.getKeyChar())) {

                    } else {
                        text.setText(Mission_Data.folder.get(profile.getSelectedIndex()).get(mission.getSelectedIndex() + 2));
                        text.setCaretPosition(0);
                    }
                }
            }
        });
        search.addMouseListener(new MouseAdapter() {

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
                        searchModel.clear();
                        String datalist = "";
                        for (int j = 0; j < container.size(); j++) {
                            String x[] = container.get(j).split("&&");
                            datalist += "p: " + (Integer.parseInt(x[0]) + 1) + " - " + "m: " + (Integer.parseInt(x[1]) - 1) + " ";
                            searchModel.addElement(datalist + Mission_Data.folder.get(Integer.parseInt(x[0])).get((Integer.parseInt(x[1]))));
                            datalist = "";
                        }
                        searchFrm.setTitle("Search Results!");
                        searchFrm.setVisible(true);
                    }

                }
            }

        });
        Add.addMouseListener(new MouseAdapter() {

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

        });
        edit.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                if ("".equals(text.getText())) {
                    JOptionPane.showMessageDialog(null, "No text found", "Warning", JOptionPane.INFORMATION_MESSAGE);
                } else if (text.getText().contains("@") || text.getText().contains("#") || text.getText().contains("\n")) {
                    JOptionPane.showMessageDialog(null, "you can't include # or @ or break lines in your profile  or mission name", "Warning", JOptionPane.INFORMATION_MESSAGE);
                } else if (Mission_Data.target && !profile.isSelectionEmpty()) {

                    Back.valid = true;
                    Back.action = "edit p";
                    Back.profileno = profile.getSelectedIndex();
                    Back.editedText = profile.getSelectedValue().toString().replaceFirst("\\d+\\sM:\\s", "");
                    Mission_Data.folder.get(profile.getSelectedIndex()).set(1, text.getText().trim());
                    profileModel.setElementAt((profile.getSelectedIndex() + 1) + " M: " + text.getText().trim(), profile.getSelectedIndex());

                } else if (!mission.isSelectionEmpty()) {
                    Back.valid = true;
                    Back.action = "edit m";
                    Back.profileno = profile.getSelectedIndex();
                    Back.missionno = mission.getSelectedIndex();
                    Back.editedText = mission.getSelectedValue().toString().replaceFirst("\\d+\\sM:\\s", "");
                    Mission_Data.folder.get(profile.getSelectedIndex()).set(mission.getSelectedIndex() + 2, text.getText().trim());
                    missionModel.setElementAt((mission.getSelectedIndex() + 1) + " M: " + text.getText().trim(), mission.getSelectedIndex());

                }

            }

        });
        oneDelete.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                if (Mission_Data.target) {
                    int k = JOptionPane.showConfirmDialog(null, "Do you want to  delete this item!");
                    if (k == 0 && !profile.isSelectionEmpty()) {
                        Back.valid = true;
                        Back.action = "delete p";
                        Back.lastData = (ArrayList<String>) Mission_Data.folder.get(profile.getSelectedIndex()).clone();

                        Mission_Data.noProfile--;
                        Mission_Data.folder.remove(profile.getSelectedIndex());
                        missionModel.clear();
                        profileModel.clear();
                        for (int i = 0; i < Mission_Data.folder.size(); i++) {
                            profileModel.addElement((i + 1) + " M: " + Mission_Data.folder.get(i).get(1));
                        }
                        text.setText("");

                    }

                } else {
                    int k = JOptionPane.showConfirmDialog(null, "Do you want to delete this item!");
                    if (k == 0 && !profile.isSelectionEmpty() && !mission.isSelectionEmpty()) {
                        Back.valid = true;
                        Back.action = "delete m";
                        Back.editedText = Mission_Data.folder.get(profile.getSelectedIndex()).get(mission.getSelectedIndex() + 2);;
                        Back.profileno = profile.getSelectedIndex();
                        Mission_Data.folder.get(profile.getSelectedIndex()).remove(mission.getSelectedIndex() + 2);
                        Mission_Data.folder.get(profile.getSelectedIndex()).set(0, (Integer.parseInt(Mission_Data.folder.get(profile.getSelectedIndex()).get(0)) - 1) + "");
                        missionModel.clear();
                        for (int i = 0; i <= Integer.parseInt(Mission_Data.folder.get(profile.getSelectedIndex()).get(0)); i++) {
                            if (i != 0) {
                                missionModel.addElement((i) + " M: " + Mission_Data.folder.get(profile.getSelectedIndex()).get(i + 1));
                            }
                        }
                    }
                    text.setText("");

                }
            }

        });
        Exit.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {

                int k = JOptionPane.showConfirmDialog(null, "Do you want to save data!");
                if (k == 0) {
                    Mission_Data.save("data.txt", "theme.txt", "home.txt");
                    System.exit(0);
                } else if (k == 1) {
                    System.exit(0);
                }

            }

        });

        ActionListener homeAL = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                home = true;
                try {
                    Mission_Data.saveHome("home.txt");
                } catch (IOException ex) {
                }

            }
        };
        //system tray code
        PopupMenu popMenu = new PopupMenu();

        MenuItem itemislam = new MenuItem("Islamic Life");
        itemislam.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                if (searchFrm.isVisible() && searchFrm.getTitle().equals("Isalmic Life")) {
                    searchFrm.setVisible(false);
                    return;
                }

                ArrayList<String> datalist = new ArrayList();

                searchFrm.setTitle("Isalmic Life");

                datalist.add("Time until: " + Mission_Data.timeForPray());
                String[] s = Mission_Data.getPrayName();
                for (int i = 0; i < s.length; i++) {
                    datalist.add(s[i]);
                }
                if (!"".equals(Mission_Data.getSiam())) {
                    datalist.add(Mission_Data.getSiam());
                }
                if (home) {
                    datalist.add("Paradise Home");
                }
                //datalist.add(Mission_Data.getHome());
                searchModel.clear();
                for (String datalist1 : datalist) {
                    searchModel.addElement(datalist1);
                }
                searchFrm.setVisible(true);

            }
        }); //adding action listener to item

        MenuItem itemYear = new MenuItem("Year");
        itemYear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                    ArrayList<String> dates = new ArrayList();

                    for (int i = 0; i < Mission_Data.folder.size(); i++) {

                        for (int j = 0; j < Integer.parseInt(Mission_Data.folder.get(i).get(0)); j++) {
                            String s = Mission_Data.folder.get(i).get(j + 2);
                            if (!s.equals(s.replaceAll("\\d+{4}-\\d+{2}-\\d+{2}", ""))) {

                                String temp = s.replaceAll("<\\d+{4}-\\d+{2}-\\d+{2}>", "~~~~");
                                int k = temp.indexOf("~~~~");

                                dates.add(s.substring(k + 1).split(">")[0] + " " + s.replaceAll("<\\d+{4}-\\d+{2}-\\d+{2}>", ""));

                            }
                        }
                    }

                    Mission_Data.MrArrange(dates);

                    searchFrm.setTitle("All missions with date");
                    searchModel.clear();
                    for (int i = 0; i < dates.size(); i++) {
                        searchModel.addElement("M: " + dates.get(i));
                    }
                    searchFrm.setVisible(true);


            }
        }); //adding action listener to item

        MenuItem itemMonth = new MenuItem("Month");
        itemMonth.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                ArrayList<String> saturday = new ArrayList();
                ArrayList<String> sunday = new ArrayList();
                ArrayList<String> monday = new ArrayList();
                ArrayList<String> tuesday = new ArrayList();
                ArrayList<String> wednesday = new ArrayList();
                ArrayList<String> thursday = new ArrayList();
                ArrayList<String> friday = new ArrayList();
                ArrayList<String> month = new ArrayList();
                for (int i = 0; i < Mission_Data.folder.size(); i++) {

                    for (int j = 0; j < Integer.parseInt(Mission_Data.folder.get(i).get(0)); j++) {
                        String s = Mission_Data.folder.get(i).get(j + 2);
                        if (s.toLowerCase().contains("<saturday>")) {
                            saturday.add(s.toLowerCase().replaceAll("<saturday>", ""));
                        } else if (s.toLowerCase().contains("<sunday>")) {
                            sunday.add(s.toLowerCase().replaceAll("<sunday>", ""));
                        } else if (s.toLowerCase().contains("<monday>")) {
                            monday.add(s.toLowerCase().replaceAll("<monday>", ""));
                        } else if (s.toLowerCase().contains("<tuesday>")) {
                            tuesday.add(s.toLowerCase().replaceAll("<tuesday>", ""));
                        } else if (s.toLowerCase().contains("<wednesday>")) {
                            wednesday.add(s.toLowerCase().replaceAll("<wednesday>", ""));
                        } else if (s.toLowerCase().contains("<thursday>")) {
                            thursday.add(s.toLowerCase().replaceAll("<thursday>", ""));
                        } else if (s.toLowerCase().contains("<friday>")) {
                            friday.add(s.toLowerCase().replaceAll("<friday>", ""));
                        } else if (s.contains("<" + new SimpleDateFormat("yyyy").format(new Date()) + "-" + Integer.parseInt(new SimpleDateFormat("MM").format(new Date())))) {
                            month.add(s);
                        }

                    }

                }

                month = Mission_Data.arrangeDays(month);

                searchFrm.setTitle("All missions in this month:");
                searchModel.clear();
                if (!saturday.isEmpty()) {
                    searchModel.addElement("Saturday:__________________________________");
                    for (int k = 0; k < saturday.size(); k++) {
                        searchModel.addElement("M:" + saturday.get(k));
                    }
                    searchModel.addElement(" ");
                }
                if (!sunday.isEmpty()) {
                    searchModel.addElement("Sunday:__________________________________");
                    for (int k = 0; k < sunday.size(); k++) {
                        searchModel.addElement("M:" + sunday.get(k));
                    }
                    searchModel.addElement(" ");
                }
                if (!monday.isEmpty()) {
                    searchModel.addElement("Monday:__________________________________");
                    for (int k = 0; k < monday.size(); k++) {
                        searchModel.addElement("M:" + monday.get(k));
                    }
                    searchModel.addElement(" ");
                }
                if (!tuesday.isEmpty()) {
                    searchModel.addElement("Tuesday:__________________________________");
                    for (int k = 0; k < tuesday.size(); k++) {
                        searchModel.addElement("M:" + tuesday.get(k));
                    }
                    searchModel.addElement(" ");
                }
                if (!wednesday.isEmpty()) {
                    searchModel.addElement("Wednesday:__________________________________");
                    for (int k = 0; k < wednesday.size(); k++) {
                        searchModel.addElement("M:" + wednesday.get(k));
                    }
                    searchModel.addElement(" ");
                }
                if (!thursday.isEmpty()) {
                    searchModel.addElement("Thursday:__________________________________");
                    for (int k = 0; k < thursday.size(); k++) {
                        searchModel.addElement("M:" + thursday.get(k));
                    }
                    searchModel.addElement(" ");
                }
                if (!friday.isEmpty()) {
                    searchModel.addElement("Friday:__________________________________");
                    for (int k = 0; k < friday.size(); k++) {
                        searchModel.addElement("M:" + friday.get(k));
                    }
                    searchModel.addElement(" ");
                }
                if (!month.isEmpty()) {
                    searchModel.addElement("Month Work:__________________________________");
                    for (int k = 0; k < month.size(); k++) {
                        searchModel.addElement("M:" + month.get(k));
                    }
                    searchModel.addElement(" ");
                }
                searchFrm.setVisible(true);

            }
        }); //adding action listener to item

        MenuItem itemDay = new MenuItem("Today");
        itemDay.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                    ArrayList<String> hours = new ArrayList();
                    ArrayList<String> nhours = new ArrayList();
                    for (int i = 0; i < Mission_Data.folder.size(); i++) {

                        for (int j = 0; j < Integer.parseInt(Mission_Data.folder.get(i).get(0)); j++) {
                            String s = Mission_Data.folder.get(i).get(j + 2);
                            if (s.contains(new SimpleDateFormat("yyyy").format(new Date()) + "-" + Integer.parseInt(new SimpleDateFormat("MM").format(new Date())) + "-" + Integer.parseInt(new SimpleDateFormat("dd").format(new Date())))) {
                                s = s.replaceAll("<\\d+{4}-\\d+{2}-\\d+{2}>", "");
                               if (s.contains("<H: ")) {
                                    String x = s.substring(s.indexOf("<H: "));
                                    x = x.split(">")[0] ;
                                    s = s.replaceAll(x + ">", "");
                                    x = x.substring(1);
                                    s = x + " > " + s;
                                    hours.add(s);
                                    
                                } else {

                                    nhours.add("M: " + s);
                                }
                            } else if ((s.toLowerCase().contains(new SimpleDateFormat("EEEE").format(new Date()).toLowerCase())) && ((s.equals(s.replaceAll("\\d+{4}-\\d+{2}-\\d+{2}", ""))))) {

                                s = s.replaceAll("<\\w+day>", "");

                               if (s.contains("<H: ")) {
                                    String x = s.substring(s.indexOf("<H: "));
                                    x = x.split(">")[0] ;
                                    s = s.replaceAll(x + ">", "");
                                    x = x.substring(1);
                                    s = x + " > " + s;
                                    hours.add(s);
                              
                               } else {
                                    nhours.add("M: " + s);

                                }

                            }
                        }

                    }

                    Mission_Data.arrangeAmPm(hours);
                    searchFrm.setTitle("Today's work");
                    searchModel.clear();
                    searchModel.addElement("Today: " + new SimpleDateFormat("yyyy-MM-dd     EEEE").format(new Date()));
                    for (int i = 0; i < hours.size(); i++) {
                        searchModel.addElement(hours.get(i));
                    }

                    for (int i = 0; i < nhours.size(); i++) {
                        searchModel.addElement(nhours.get(i));
                    }

                    searchFrm.setVisible(true);
            }
        
        
        }); //adding action listener to item

        MenuItem itemImp = new MenuItem("Important work");
        itemImp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                searchFrm.setTitle("All Mission with importance");
                searchModel.clear();
                ArrayList<String> nimp = new ArrayList();
                for (int i = 0; i < Mission_Data.folder.size(); i++) {
                    for (int j = 1; j < Mission_Data.folder.get(i).size(); j++) {
                        if (Mission_Data.folder.get(i).get(j).contains("<i>")) {
                            searchModel.addElement("<i>" + Mission_Data.folder.get(i).get(j).replaceAll("<i>", ""));
                        } else {
                            nimp.add("M:" + Mission_Data.folder.get(i).get(j));
                        }
                    }
                }

                for (int i = 0; i < nimp.size(); i++) {
                    searchModel.addElement(nimp.get(i));
                }

                searchFrm.setVisible(true);

            }
        }); //adding action listener to item

        MenuItem item = new MenuItem("Paradise Home");
        item.addActionListener(homeAL); //adding action listener to item1

        MenuItem item1 = new MenuItem("Main window");
        item1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                mainFrm.setVisible(true);

            }
        }); //adding action listener to item1

        MenuItem item2 = new MenuItem("Exit");
        item2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                int k = JOptionPane.showConfirmDialog(null, "Do you want to save data!");
                if (k == 0) {
                    Mission_Data.save("data.txt", "theme.txt", "home.txt");
                    System.exit(0);
                } else if (k == 1) {
                    System.exit(0);
                }

            }
        }); //adding action listener to item1

         MenuItem itemOn   = new MenuItem("Message On");
        itemOn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                Mission_Data.valid = true;
                
            }
        }); //adding action listener to item1
         MenuItem itemOff = new MenuItem("Message Off");
        itemOff.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                Mission_Data.valid = false ;
                 System.out.println(Mission_Data.valid);
                
            }
        }); //adding action listener to item1
        
        PopupMenu work = new PopupMenu("Work of");
        work.add(itemYear);
        work.add(itemMonth);
        work.add(itemDay);

        popMenu.add(itemislam);
        popMenu.add(work);
        popMenu.add(itemImp);

        popMenu.add(item);
        popMenu.add(item1);
        popMenu.add(item2);
        popMenu.add(itemOn);
        popMenu.add(itemOff);
        Image img = Toolkit.getDefaultToolkit().getImage("2.png");
        TrayIcon trayIcon = new TrayIcon(img, "Time Management", popMenu);
        SystemTray.getSystemTray().add(trayIcon);
        trayIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    mainFrm.setVisible(true);

                }

            }

        });
        //end of system tray code

        //action listners for the Jmenu
        ActionListener ae = new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent ae) {
                th = themes[Integer.parseInt(((JMenuItem) ae.getSource()).getText().split(" ")[1]) - 1];
                GUI_Ruler.Changetheme(th, totalCommts);
                GUI_Ruler.ChangeReverseTheme(mission, th);
                lMain.setIcon(new ImageIcon(th.desktop));
                lSearch.setIcon(new ImageIcon(th.desktop));
                GUI_Ruler.ChangeReverseTheme(th, profile);
                GUI_Ruler.Changetheme(mission, th);
                
                Mission_Data.target = true;
                text.setText("");

            }

        };
        ActionListener ae2 = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae2) {
                if (((JMenuItem) ae2.getSource()).getText().split(" ")[1].contains("fore")) {
                    Color c = JColorChooser.showDialog(null, "Choose a color", th.c1);
                    th = new theme(th.desktop, c, th.c2);
                    GUI_Ruler.Changefore(c, totalCommts);
                    GUI_Ruler.Changeback(c, mission);
                } else {
                    Color c = JColorChooser.showDialog(null, "Choose a color", th.c2);
                    th = new theme(th.desktop, th.c1, c);
                    GUI_Ruler.Changeback(c, totalCommts);
                    GUI_Ruler.Changefore(c, mission);
                }

                Mission_Data.target = true;
                text.setText("");

            }
        };

        GUI_Ruler.tt1.addActionListener(ae); //adding action listener to item1
        GUI_Ruler.tt2.addActionListener(ae); //adding action listener to item1
        GUI_Ruler.tt3.addActionListener(ae); //adding action listener to item1
        GUI_Ruler.t2.addActionListener(ae2); //adding action listener to item1
        GUI_Ruler.t3.addActionListener(ae2); //adding action listener to item1
        GUI_Ruler.t4.addActionListener(homeAL); //adding action listener to item1

        KeyAdapter ma = new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == 90 && evt.getModifiersEx() == 128) {
                    Mission_Data.goBack(text, profile, profileModel, mission, missionModel, searchFrm);
                }

                if (evt.getKeyCode() == 83 && evt.getModifiersEx() == 128) {
                    Mission_Data.save("data.txt", "theme.txt", "home.txt");
                }
                if (evt.getKeyCode() == 116) {
                    refreshGUI();
                }

            }

        };

        mission.addKeyListener(ma);
        mainFrm.addKeyListener(ma);
        searchFrm.addKeyListener(ma);
        for (int i = 0; i < totalCommts.length; i++) {
            totalCommts[i].addKeyListener(ma);
        }
        mission.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent evt) {

                if (evt.getKeyCode() == 67 && evt.getModifiersEx() == 128) {

                    Mission_Data.copy(mission);
                }
                if (evt.getKeyCode() == 88 && evt.getModifiersEx() == 128 && !profile.isSelectionEmpty() && !mission.isSelectionEmpty()) {

                    text.setText((Mission_Data.cut(profile, mission, missionModel)) ? "" : text.getText());;
                }

                if (evt.getKeyCode() == 86 && evt.getModifiersEx() == 128) {
                    Mission_Data.past(profile, missionModel);
                }

            }

        });
        profile.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent evt) {

                if (evt.getKeyCode() == 86 && evt.getModifiersEx() == 128) {
                    Mission_Data.past(profile, missionModel);
                }

            }

        });

        text.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == 68 && evt.getModifiersEx() == 128) {
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
                if (evt.getKeyCode() == 69 && evt.getModifiersEx() == 128) {

                    if ("".equals(text.getText())) {
                        JOptionPane.showMessageDialog(null, "No text found", "Warning", JOptionPane.INFORMATION_MESSAGE);
                    } else if (text.getText().contains("@") || text.getText().contains("#") || text.getText().contains("\n")) {
                        JOptionPane.showMessageDialog(null, "you can't include # or @ or break lines in your profile  or mission name", "Warning", JOptionPane.INFORMATION_MESSAGE);
                    } else if (Mission_Data.target && !profile.isSelectionEmpty()) {

                        Back.valid = true;
                        Back.action = "edit p";
                        Back.profileno = profile.getSelectedIndex();
                        Back.editedText = profile.getSelectedValue().toString().replaceFirst("\\d+\\sM:\\s", "");

                        Mission_Data.folder.get(profile.getSelectedIndex()).set(1, text.getText().trim());
                        profileModel.setElementAt((profile.getSelectedIndex() + 1) + " M: " + text.getText().trim(), profile.getSelectedIndex());

                    } else if (!mission.isSelectionEmpty()) {

                        Back.valid = true;
                        Back.action = "edit m";
                        Back.profileno = profile.getSelectedIndex();
                        Back.missionno = mission.getSelectedIndex();
                        Back.editedText = mission.getSelectedValue().toString().replaceFirst("\\d+\\sM:\\s", "");
                        Mission_Data.folder.get(profile.getSelectedIndex()).set(mission.getSelectedIndex() + 2, text.getText().trim());
                        missionModel.setElementAt((mission.getSelectedIndex() + 1) + " M: " + text.getText().trim(), mission.getSelectedIndex());

                    }

                }

            }

        });

        profile.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent evt) {
                first_index = profile.getSelectedIndex();
            }

            @Override
            public void mouseReleased(MouseEvent evt) {
                if (dragged) {

                    Mission_Data.changeProfile(first_index, second_index);
                    text.setText("");
                    profileModel.clear();
                    Mission_Data.refresh(profileModel);
                    profile.setSelectedIndex(second_index);
                    missionModel.clear();
                    for (int i = 0; i < Integer.parseInt(Mission_Data.folder.get(second_index).get(0)); i++) {
                        missionModel.addElement((i + 1) + " M: " + Mission_Data.folder.get(second_index).get(i + 2));
                    }
                    dragged = false;
                }
            }

        });
        profile.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent evt) {
                dragged = true;
                second_index = profile.getSelectedIndex();

            }

        });
        mission.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                first_index = mission.getSelectedIndex();
            }

            @Override
            public void mouseReleased(MouseEvent evt) {
                if (dragged) {

                    Mission_Data.changeMission(first_index, second_index, profile.getSelectedIndex());
                    text.setText("");
                    missionModel.clear();
                    for (int i = 0; i < Integer.parseInt(Mission_Data.folder.get(profile.getSelectedIndex()).get(0)); i++) {
                        missionModel.addElement((i + 1) + " M: " + Mission_Data.folder.get(profile.getSelectedIndex()).get(i + 2));
                    }
                    dragged = false;
                }
            }

        });
        mission.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent evt) {
                dragged = true;
                second_index = mission.getSelectedIndex();

            }

        });
        Mekka.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent evt) {

                if (searchFrm.isVisible() && searchFrm.getTitle().equals("Isalmic Life")) {
                    searchFrm.setVisible(false);
                    return;
                }

                ArrayList<String> datalist = new ArrayList();

                searchFrm.setTitle("Isalmic Life");

                datalist.add("Time until: " + Mission_Data.timeForPray());
                String[] s = Mission_Data.getPrayName();
                for (int i = 0; i < s.length; i++) {
                    datalist.add(s[i]);
                }
                if (!"".equals(Mission_Data.getSiam())) {
                    datalist.add(Mission_Data.getSiam());
                }
                if (home) {
                    datalist.add("Paradise Home");
                }
                //datalist.add(Mission_Data.getHome());
                searchModel.clear();
                for (String datalist1 : datalist) {
                    searchModel.addElement(datalist1);
                }
                searchFrm.setVisible(true);
            }

        });
//additions

        general.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                if (me.isControlDown()) {
                    searchFrm.setTitle("All Mission with importance");
                    searchModel.clear();
                    ArrayList<String> nimp = new ArrayList();
                    for (int i = 0; i < Mission_Data.folder.size(); i++) {
                        for (int j = 1; j < Mission_Data.folder.get(i).size(); j++) {
                            if (Mission_Data.folder.get(i).get(j).contains("<i>")) {
                                searchModel.addElement("<i>" + Mission_Data.folder.get(i).get(j).replaceAll("<i>", ""));
                            } else {
                                nimp.add("M:" + Mission_Data.folder.get(i).get(j));
                            }
                        }
                    }

                    for (int i = 0; i < nimp.size(); i++) {
                        searchModel.addElement(nimp.get(i));
                    }

                    searchFrm.setVisible(true);
                } else {
                    if (!Mission_Data.target && !mission.isSelectionEmpty() && !profile.isSelectionEmpty()) {

                        ArrayList<String> s = new ArrayList(mission.getSelectedValuesList());
                        for (int i = 0; i < s.size(); i++) {
                            s.set(i, reverse(s.get(i)));
                        }
                        for (int i = 0; i < s.size(); i++) {
                            Mission_Data.folder.get(profile.getSelectedIndex()).set(Integer.parseInt(s.get(i).split("M")[0].trim()) + 1, s.get(i).replaceFirst("\\d+\\sM:\\s", ""));

                        }

                        missionModel.clear();
                        for (int i = 0; i < Integer.parseInt(Mission_Data.folder.get(profile.getSelectedIndex()).get(0)); i++) {
                            missionModel.addElement((i + 1) + " M: " + Mission_Data.folder.get(profile.getSelectedIndex()).get(i + 2));
                        }
                    } else if (Mission_Data.target && !profile.isSelectionEmpty()) {
                        ArrayList<String> s = (ArrayList<String>) Mission_Data.folder.get(profile.getSelectedIndex()).clone();
                        for (int i = 2; i < s.size(); i++) {
                            s.set(i, reverse(s.get(i)));
                        }
                        Mission_Data.folder.set(profile.getSelectedIndex(), s);

                        missionModel.clear();
                        for (int i = 0; i < Integer.parseInt(Mission_Data.folder.get(profile.getSelectedIndex()).get(0)); i++) {
                            missionModel.addElement((i + 1) + " M: " + Mission_Data.folder.get(profile.getSelectedIndex()).get(i + 2));
                        }

                    }

                }

            }

        });
        monthly.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                if (me.isControlDown()) {

                    ArrayList<String> dates = new ArrayList();

                    for (int i = 0; i < Mission_Data.folder.size(); i++) {

                        for (int j = 0; j < Integer.parseInt(Mission_Data.folder.get(i).get(0)); j++) {
                            String s = Mission_Data.folder.get(i).get(j + 2);
                            if (!s.equals(s.replaceAll("\\d+{4}-\\d+{2}-\\d+{2}", ""))) {

                                String temp = s.replaceAll("<\\d+{4}-\\d+{2}-\\d+{2}>", "~~~~");
                                int k = temp.indexOf("~~~~");

                                dates.add(s.substring(k + 1).split(">")[0] + " " + s.replaceAll("<\\d+{4}-\\d+{2}-\\d+{2}>", ""));

                            }
                        }
                    }

                    Mission_Data.MrArrange(dates);

                    searchFrm.setTitle("All missions with date");
                    searchModel.clear();
                    for (int i = 0; i < dates.size(); i++) {
                        searchModel.addElement("M: " + dates.get(i));
                    }
                    searchFrm.setVisible(true);
                } else {
                    if (!Mission_Data.target && !mission.isSelectionEmpty() && !profile.isSelectionEmpty() && text.getText().trim().matches("\\d+{4}-\\d+{2}-\\d+{2}")) {
                        int year = Integer.parseInt(text.getText().split("-")[0]);
                        int month = Integer.parseInt(text.getText().split("-")[1]);
                        int day = Integer.parseInt(text.getText().split("-")[2]);
                        if (year >= 2000 && month >= 1 && month <= 12 && day <= 31 && day >= 1) {
                            String s = Mission_Data.folder.get(profile.getSelectedIndex()).get(mission.getSelectedIndex() + 2).replaceAll("<\\d+{4}-\\d+{2}-\\d+{2}>", "") + "<" + year + "-" + month + "-" + day + ">";

                            Mission_Data.folder.get(profile.getSelectedIndex()).set(mission.getSelectedIndex() + 2, s);

                        }
                        day = mission.getSelectedIndex();
                        missionModel.clear();
                        for (int i = 0; i < Integer.parseInt(Mission_Data.folder.get(profile.getSelectedIndex()).get(0)); i++) {
                            missionModel.addElement((i + 1) + " M: " + Mission_Data.folder.get(profile.getSelectedIndex()).get(i + 2));
                        }
                        mission.setSelectedIndex(day);
                    }

                }
            }

        });
        daily.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                if (me.isControlDown()) {

                    ArrayList<String> saturday = new ArrayList();
                    ArrayList<String> sunday = new ArrayList();
                    ArrayList<String> monday = new ArrayList();
                    ArrayList<String> tuesday = new ArrayList();
                    ArrayList<String> wednesday = new ArrayList();
                    ArrayList<String> thursday = new ArrayList();
                    ArrayList<String> friday = new ArrayList();
                    ArrayList<String> month = new ArrayList();
                    for (int i = 0; i < Mission_Data.folder.size(); i++) {

                        for (int j = 0; j < Integer.parseInt(Mission_Data.folder.get(i).get(0)); j++) {
                            String s = Mission_Data.folder.get(i).get(j + 2);
                            if (s.toLowerCase().contains("<saturday>")) {
                                saturday.add(s.toLowerCase().replaceAll("<saturday>", ""));
                            } else if (s.toLowerCase().contains("<sunday>")) {
                                sunday.add(s.toLowerCase().replaceAll("<sunday>", ""));
                            } else if (s.toLowerCase().contains("<monday>")) {
                                monday.add(s.toLowerCase().replaceAll("<monday>", ""));
                            } else if (s.toLowerCase().contains("<tuesday>")) {
                                tuesday.add(s.toLowerCase().replaceAll("<tuesday>", ""));
                            } else if (s.toLowerCase().contains("<wednesday>")) {
                                wednesday.add(s.toLowerCase().replaceAll("<wednesday>", ""));
                            } else if (s.toLowerCase().contains("<thursday>")) {
                                thursday.add(s.toLowerCase().replaceAll("<thursday>", ""));
                            } else if (s.toLowerCase().contains("<friday>")) {
                                friday.add(s.toLowerCase().replaceAll("<friday>", ""));
                            } else if (s.contains("<" + new SimpleDateFormat("yyyy").format(new Date()) + "-" + Integer.parseInt(new SimpleDateFormat("MM").format(new Date())))) {
                                month.add(s);
                            }

                        }

                    }

                    month = Mission_Data.arrangeDays(month);

                    searchFrm.setTitle("All missions in this month:");
                    searchModel.clear();
                    if (!saturday.isEmpty()) {
                        searchModel.addElement("Saturday:__________________________________");
                        for (int k = 0; k < saturday.size(); k++) {
                            searchModel.addElement("M:" + saturday.get(k));
                        }
                        searchModel.addElement(" ");
                    }
                    if (!sunday.isEmpty()) {
                        searchModel.addElement("Sunday:__________________________________");
                        for (int k = 0; k < sunday.size(); k++) {
                            searchModel.addElement("M:" + sunday.get(k));
                        }
                        searchModel.addElement(" ");
                    }
                    if (!monday.isEmpty()) {
                        searchModel.addElement("Monday:__________________________________");
                        for (int k = 0; k < monday.size(); k++) {
                            searchModel.addElement("M:" + monday.get(k));
                        }
                        searchModel.addElement(" ");
                    }
                    if (!tuesday.isEmpty()) {
                        searchModel.addElement("Tuesday:__________________________________");
                        for (int k = 0; k < tuesday.size(); k++) {
                            searchModel.addElement("M:" + tuesday.get(k));
                        }
                        searchModel.addElement(" ");
                    }
                    if (!wednesday.isEmpty()) {
                        searchModel.addElement("Wednesday:__________________________________");
                        for (int k = 0; k < wednesday.size(); k++) {
                            searchModel.addElement("M:" + wednesday.get(k));
                        }
                        searchModel.addElement(" ");
                    }
                    if (!thursday.isEmpty()) {
                        searchModel.addElement("Thursday:__________________________________");
                        for (int k = 0; k < thursday.size(); k++) {
                            searchModel.addElement("M:" + thursday.get(k));
                        }
                        searchModel.addElement(" ");
                    }
                    if (!friday.isEmpty()) {
                        searchModel.addElement("Friday:__________________________________");
                        for (int k = 0; k < friday.size(); k++) {
                            searchModel.addElement("M:" + friday.get(k));
                        }
                        searchModel.addElement(" ");
                    }
                    if (!month.isEmpty()) {
                        searchModel.addElement("Month Work:__________________________________");
                        for (int k = 0; k < month.size(); k++) {
                            searchModel.addElement("M:" + month.get(k));
                        }
                        searchModel.addElement(" ");
                    }
                    searchFrm.setVisible(true);

                } else {
                    if (!Mission_Data.target && !mission.isSelectionEmpty() && !profile.isSelectionEmpty() && text.getText().trim().matches("\\w+")) {
                        String s = text.getText();
                        if (s.equalsIgnoreCase("saturday") || s.equalsIgnoreCase("sunday") || s.equalsIgnoreCase("monday") || s.equalsIgnoreCase("tuesday") || s.equalsIgnoreCase("wednesday") || s.equalsIgnoreCase("thursday") || s.equalsIgnoreCase("friday")) {
                            s = Mission_Data.folder.get(profile.getSelectedIndex()).get(mission.getSelectedIndex() + 2).replaceAll("<\\w+day>", "") + "<" + s + ">";
                            Mission_Data.folder.get(profile.getSelectedIndex()).set(mission.getSelectedIndex() + 2, s);

                            int count = mission.getSelectedIndex();
                            missionModel.clear();
                            for (int i = 0; i < Integer.parseInt(Mission_Data.folder.get(profile.getSelectedIndex()).get(0)); i++) {
                                missionModel.addElement((i + 1) + " M: " + Mission_Data.folder.get(profile.getSelectedIndex()).get(i + 2));
                            }
                            mission.setSelectedIndex(count);

                        }

                    }
                }

            }

        });
        today.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                if (me.isControlDown()) {

                    ArrayList<String> hours = new ArrayList();
                    ArrayList<String> nhours = new ArrayList();
                    for (int i = 0; i < Mission_Data.folder.size(); i++) {

                        for (int j = 0; j < Integer.parseInt(Mission_Data.folder.get(i).get(0)); j++) {
                            String s = Mission_Data.folder.get(i).get(j + 2);
                            if (s.contains(new SimpleDateFormat("yyyy").format(new Date()) + "-" + Integer.parseInt(new SimpleDateFormat("MM").format(new Date())) + "-" + Integer.parseInt(new SimpleDateFormat("dd").format(new Date())))) {
                                s = s.replaceAll("<\\d+{4}-\\d+{2}-\\d+{2}>", "");
                               if (s.contains("<H: ")) {
                                    String x = s.substring(s.indexOf("<H: "));
                                    x = x.split(">")[0] ;
                                    s = s.replaceAll(x + ">", "");
                                    x = x.substring(1);
                                    s = x + " > " + s;
                                    hours.add(s);
                                    
                                } else {

                                    nhours.add("M: " + s);
                                }
                            } else if ((s.toLowerCase().contains(new SimpleDateFormat("EEEE").format(new Date()).toLowerCase())) && ((s.equals(s.replaceAll("\\d+{4}-\\d+{2}-\\d+{2}", ""))))) {

                                s = s.replaceAll("<\\w+day>", "");

                               if (s.contains("<H: ")) {
                                    String x = s.substring(s.indexOf("<H: "));
                                    x = x.split(">")[0] ;
                                    s = s.replaceAll(x + ">", "");
                                    x = x.substring(1);
                                    s = x + " > " + s;
                                    hours.add(s);
                              
                               } else {
                                    nhours.add("M: " + s);

                                }

                            }
                        }

                    }

                    Mission_Data.arrangeAmPm(hours);
                    searchFrm.setTitle("Today's work");
                    searchModel.clear();
                    searchModel.addElement("Today: " + new SimpleDateFormat("yyyy-MM-dd     EEEE").format(new Date()));
                    for (int i = 0; i < hours.size(); i++) {
                        searchModel.addElement(hours.get(i));
                    }
 
                    for (int i = 0; i < nhours.size(); i++) {
                        searchModel.addElement(nhours.get(i));
                    }

                    searchFrm.setVisible(true);
                } else {
                    if (!Mission_Data.target && !mission.isSelectionEmpty() && !profile.isSelectionEmpty() && text.getText().trim().matches("\\d+{2}\\s[APap][mM]")) {
                        int count = Integer.parseInt(text.getText().split(" ")[0]);
                        String pmam = text.getText().split(" ")[1];
                        if (count >= 1 && count <= 12) {
                            String s = Mission_Data.folder.get(profile.getSelectedIndex()).get(mission.getSelectedIndex() + 2).replaceAll("<H: \\d+{2}\\s[APap][mM]>", "") + "<H: " + count + " "+ pmam.toLowerCase() +">";
                            Mission_Data.folder.get(profile.getSelectedIndex()).set(mission.getSelectedIndex() + 2, s);

                        }
                        count = mission.getSelectedIndex();
                        missionModel.clear();
                        for (int i = 0; i < Integer.parseInt(Mission_Data.folder.get(profile.getSelectedIndex()).get(0)); i++) {
                            missionModel.addElement((i + 1) + " M: " + Mission_Data.folder.get(profile.getSelectedIndex()).get(i + 2));
                        }
                        mission.setSelectedIndex(count);

                    }

                }

            }

        });

    refreshGUI();
    
    }

    public static String reverse(String s) {
        if (s.contains("<i>")) {
            s = s.replaceAll("<i>", "");
        } else {
            s += "<i>";
        }
        return s;
    }

}
