
package zekra2;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
//end tray
public class ZEKRA2 {

    static JFrame mainFrm = GUI_Ruler2.addFrm(false, false, 400, 300, 500, 360, "ذكرى", "zekra.png","1.png", false);
    static JButton Next = GUI_Ruler2.addBtn(15, 10, 150, 50, "اعرض حديث", mainFrm);
    static JButton hkmabtn = GUI_Ruler2.addBtn(15, 10, 150, 50, "اعرض حكمة", mainFrm);
    static JButton important = GUI_Ruler2.addBtn(15, 10, 150, 50, "اعرض الهام", mainFrm);
    static JButton adjust = GUI_Ruler2.addBtn(15, 10, 150, 50, "اضبط", mainFrm);
    static JButton addhkma = GUI_Ruler2.addBtn(15, 10, 230, 50, "اضف حكمة", mainFrm);
    static JButton homeParadise = GUI_Ruler2.addBtn(15, 10, 140, 50, "بيت فى الجنة", mainFrm);
    static JButton exit = GUI_Ruler2.addBtn(15, 10, 230, 50, "إغلاق نهائى", mainFrm);
    static JList profile = new JList();
    static JScrollPane pp = new JScrollPane(profile);
    static DefaultListModel profileModel = new DefaultListModel();
    static JList mission = new JList();
    static JScrollPane mp = new JScrollPane(mission);
    static DefaultListModel missionModel = new DefaultListModel();
    static JList hdithno = new JList();
    static JScrollPane hh = new JScrollPane(hdithno);
    static DefaultListModel hdithnoModel = new DefaultListModel();
    static JButton show = GUI_Ruler2.addBtn(15, 250, 150, 50, "اعرض", mainFrm);
    static JTextArea searchtext = GUI_Ruler2.addtxt(30, 30, 290, 50, "", mainFrm);
    static JButton searchbtn = GUI_Ruler2.addBtn(15, 250, 150, 50, "ابحث", mainFrm);

    static JFrame zkrFrm = GUI_Ruler2.addFrm(false, false, 200, 200, 440, 500, "ذكرى", "zekra.png","1.png", false);
    static JTextArea text = GUI_Ruler2.addtxt(30, 30, 300, 300, "", zkrFrm);
    static JScrollPane holderText = new JScrollPane(text);
    static JButton zkrimportant = GUI_Ruler2.addBtn(450, 10, 200, 50, "اضف للهام", zkrFrm);
    static JButton zkrmain = GUI_Ruler2.addBtn(450, 400, 200, 50, "الصفحة الرئيسية", zkrFrm);

    static JFrame hkmaFrm = GUI_Ruler2.addFrm(false, false, 200, 200, 440, 500, "ذكرى", "hkma.jpg","1.png", false);
    static JTextArea hkmatext = GUI_Ruler2.addtxt(30, 30, 300, 300, "", hkmaFrm);
    static JScrollPane hkmaholderText = new JScrollPane(hkmatext);
    static JButton hkmaimportant = GUI_Ruler2.addBtn(450, 10, 200, 50, "اضف للهام", hkmaFrm);
    static JButton hkmamain = GUI_Ruler2.addBtn(450, 400, 200, 50, "الصفحة الرئيسية", hkmaFrm);

    static JFrame adjustFrm = GUI_Ruler2.addFrm(false, false, 200, 200, 440, 500, "ذكرى", "hkma.jpg","1.png", false);
    static JTextArea adjusttext = GUI_Ruler2.addtxt(30, 30, 300, 150, "", adjustFrm);
    static JScrollPane adjustholderText = new JScrollPane(adjusttext);
    static JButton adjustdelete = GUI_Ruler2.addBtn(450, 10, 200, 50, "مسح", adjustFrm);
    static JButton adjuster = GUI_Ruler2.addBtn(450, 400, 200, 50, "تعديل", adjustFrm);
    static JList results = new JList();
    static JScrollPane rp = new JScrollPane(results);
    static DefaultListModel resultsModel = new DefaultListModel();

    public static void main(String[] args) throws IOException, AWTException {

        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("WinSoft Thuluth", Font.BOLD, 15)));
        Data_Zekra2.intial("saleh.txt", "data.txt", "time.txt", "hkma.txt");
        Data_Zekra2.startTimer(zkrFrm, text, zkrimportant, hkmaFrm, hkmatext, hkmaimportant);

    
        text.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        searchtext.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        GUI_Ruler2.makeVertical(adjust, important, searchbtn, exit);
        GUI_Ruler2.makeHorizontal(searchbtn, searchtext);
        GUI_Ruler2.makeCenter(exit, mainFrm);
        GUI_Ruler2.makeHorizontal(exit, addhkma);
        GUI_Ruler2.makeHorizontal(important, Next, hkmabtn);
        // we must define set bounds for lists before we use it in the makehorizontal method
        hh.setBounds(200, 250, 160, 70);
        GUI_Ruler2.makeHorizontal(show,hh,homeParadise);
        
        profile.setForeground(Color.black);
        profile.setBackground(Color.pink);
        profile.setFont(new Font("Courier New", Font.BOLD, 18));
        profile.repaint();
        pp.setBounds(180, 10, 120, 50);
        mainFrm.add(pp, 0);
        profile.setModel(profileModel);
        profileModel.addElement("5 دقيقة");
        profileModel.addElement("10 دقيقة");
        profileModel.addElement("15 دقيقة");
        profileModel.addElement("30 دقيقة");
        profileModel.addElement("45 دقيقة");
        profileModel.addElement("1 ساعة");
        profile.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        mission.setForeground(Color.black);
        mission.setBackground(Color.pink);
        mission.setFont(new Font("Courier New", Font.BOLD, 18));
        mission.repaint();
        mp.setBounds(310, 10, 170, 50);
        mainFrm.add(mp, 0);
        mission.setModel(missionModel);
        missionModel.addElement("رياض الصالحين");
        missionModel.addElement("حكمة");
        missionModel.addElement("كليهما");
        mission.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        hdithno.setForeground(Color.black);
        hdithno.setBackground(Color.pink);
        hdithno.setFont(new Font("Courier New", Font.BOLD, 18));
        hdithno.repaint();
        
        mainFrm.add(hh, 0);
        hdithno.setModel(hdithnoModel);

        results.setForeground(Color.black);
        results.setBackground(Color.BLUE);
        results.setFont(new Font("Courier New", Font.BOLD, 18));
        results.repaint();
        rp.setBounds(20, 210, 400, 150);
        adjustFrm.add(rp, 0);
        results.setModel(resultsModel);
        results.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        for (int i = 0; i < Data_Zekra2.zekr.size(); i++) {
            hdithnoModel.addElement(i + 1 + "");
        }

        holderText.setBounds(30, 30, 400, 350);
        GUI_Ruler2.makeCenter(holderText, zkrFrm);
        zkrFrm.add(holderText, 0);
        text.setBackground(Color.white);
        GUI_Ruler2.makeHorizontal(zkrmain, zkrimportant);

        hkmaholderText.setBounds(30, 30, 400, 350);
        GUI_Ruler2.makeCenter(hkmaholderText, hkmaFrm);
        hkmaFrm.add(hkmaholderText, 0);
        hkmatext.setBackground(Color.white);
        GUI_Ruler2.makeHorizontal(hkmamain, hkmaimportant);
        hkmatext.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        adjustholderText.setBounds(30, 30, 400, 150);
        GUI_Ruler2.makeCenter(adjustholderText, adjustFrm);
        adjustFrm.add(adjustholderText, 0);
        adjusttext.setBackground(Color.white);
        GUI_Ruler2.makeHorizontal(adjuster, adjustdelete);
        adjusttext.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        //program coding
        searchbtn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {

                if (!searchtext.getText().trim().equals("")) {
                    String index = Data_Zekra2.hkmasearch(searchtext.getText());

                    if (index.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "لا توجد");
                    } else {
                        String holding[] = index.trim().split(" ");
                        adjustFrm.setVisible(true);
                        adjusttext.setText("");
                        resultsModel.clear();
                        for (int i = 0; i < holding.length; i++) {
                            resultsModel.addElement(holding[i] + " " + Data_Zekra2.clear(Data_Zekra2.hkma.get(Integer.parseInt(holding[i].trim()))));
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
        adjustdelete.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {

                if (!results.isSelectionEmpty()) {
                    Data_Zekra2.hkma.remove(Integer.parseInt(results.getSelectedValue().toString().split(" ")[0]));

                    try {
                        Data_Zekra2.save("data.txt", "hkma.txt");
                    } catch (IOException ex) {
                        Logger.getLogger(ZEKRA2.class.getName()).log(Level.SEVERE, null, ex);

                    }

                    resultsModel.clear();
                    if (!searchtext.getText().trim().equals("")) {
                        String index = Data_Zekra2.hkmasearch(searchtext.getText());

                        if (!index.isEmpty()) {
                            String holding[] = index.trim().split(" ");
                            adjustFrm.setVisible(true);
                            adjusttext.setText("");
                            resultsModel.clear();
                            for (int i = 0; i < holding.length; i++) {
                                resultsModel.addElement(holding[i] + " " + Data_Zekra2.clear(Data_Zekra2.hkma.get(Integer.parseInt(holding[i].trim()))));
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

        homeParadise.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                try {
                    Data_Zekra2.paradise();
                } catch (IOException ex) {
                    Logger.getLogger(ZEKRA2.class.getName()).log(Level.SEVERE, null, ex);
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
        adjuster.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {

                if (!results.isSelectionEmpty()) {
                    Data_Zekra2.hkma.set(Integer.parseInt(results.getSelectedValue().toString().split(" ")[0]), Data_Zekra2.adjustclear(adjusttext.getText()));

                    try {
                        Data_Zekra2.save("data.txt", "hkma.txt");
                    } catch (IOException ex) {
                        Logger.getLogger(ZEKRA2.class.getName()).log(Level.SEVERE, null, ex);

                    }

                    resultsModel.clear();
                    if (!searchtext.getText().trim().equals("")) {
                        String index = Data_Zekra2.hkmasearch(searchtext.getText());

                        if (!index.isEmpty()) {
                            String holding[] = index.trim().split(" ");
                            adjustFrm.setVisible(true);
                            adjusttext.setText("");
                            resultsModel.clear();
                            for (int i = 0; i < holding.length; i++) {
                                resultsModel.addElement(holding[i] + " " + Data_Zekra2.clear(Data_Zekra2.hkma.get(Integer.parseInt(holding[i].trim()))));
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

        addhkma.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {

                hkmaFrm.setVisible(true);
                hkmamain.setText("الصفحة الرئيسية");
                hkmaimportant.setText("اضف");
                hkmatext.setText("");
                //we did the next two steps to give the user suffiecent time to write his words in hkma
                Data_Zekra2.clock.stop();
                Data_Zekra2.clock.start();
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

        exit.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {

                JOptionPane.showMessageDialog(null, "السلام عليكم و رحمة الله و بركاته");
                System.exit(0);

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
        show.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                if (!hdithno.isSelectionEmpty()) {
                    zkrFrm.setVisible(true);
                    zkrimportant.setText("اضف للهام");
                    text.setText(Data_Zekra2.arrangehdith(Data_Zekra2.zekr.get(hdithno.getSelectedIndex())));
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

        zkrmain.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                mainFrm.setVisible(true);
                searchtext.setText("");
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

        hkmamain.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                if (hkmamain.getText().equals("الصفحة الرئيسية")) {
                    mainFrm.setVisible(true);
                    searchtext.setText("");
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

        Next.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                Data_Zekra2.showZkr(zkrFrm, text, zkrimportant);
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

        hkmabtn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                if (!Data_Zekra2.hkma.isEmpty()) {
                    hkmamain.setText("الصفحة الرئيسية");
                       Data_Zekra2.showhkma(hkmaFrm, hkmatext, hkmaimportant);
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

        adjust.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                int i = 0;
                switch (profile.getSelectedIndex()) {
                    case 0:
                        i = 5;
                        break;
                    case 1:
                        i = 10;
                        break;
                    case 2:
                        i = 15;
                        break;
                    case 3:
                        i = 30;
                        break;
                    case 4:
                        i = 45;
                        break;
                    case 5:
                        i = 60;
                        break;
                    default:
                        i = 10;
                }

                int j = 0;
                switch (mission.getSelectedIndex()) {
                    case 0:
                        j = 0;
                        break;
                    case 1:
                        j = 1;
                        break;
                    case 2:
                        j = 2;
                        break;
                    default:
                        j = 2;
                }
                try {
                    Data_Zekra2.setPeriod("time.txt", i, j);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "NO time file");
                }
                Data_Zekra2.startTimer(zkrFrm, text, zkrimportant, hkmaFrm, hkmatext, hkmaimportant);
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
        zkrimportant.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                if (zkrimportant.getText().equals("احفظ التغيرات")) {
                    Data_Zekra2.important = text.getText();
                    try {
                        Data_Zekra2.save("data.txt", "hkma.txt");
                    } catch (IOException ex) {
                        Logger.getLogger(ZEKRA2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    Data_Zekra2.important += text.getText().split("---------------")[0] + "\n" + "#############################" + "\n";
                    try {
                        Data_Zekra2.save("data.txt", "hkma.txt");
                    } catch (IOException ex) {
                        Logger.getLogger(ZEKRA2.class.getName()).log(Level.SEVERE, null, ex);
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

        hkmaimportant.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                if (hkmaimportant.getText().equals("اضف للهام")) {
                    Data_Zekra2.important += hkmatext.getText().split("---------------")[0] + "\n" + "#############################" + "\n";
                    try {
                        Data_Zekra2.save("data.txt", "hkma.txt");
                    } catch (IOException ex) {
                        Logger.getLogger(ZEKRA2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (hkmaimportant.getText().equals("اضف")) {
                    Data_Zekra2.hkma.add(Data_Zekra2.format(hkmatext.getText()));
                    try {
                        
                        Data_Zekra2.save("data.txt", "hkma.txt");
                    } catch (IOException ex) {
                        Logger.getLogger(ZEKRA2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    hkmaFrm.setVisible(false);
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
        important.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                text.setText(Data_Zekra2.important);
                zkrimportant.setText("احفظ التغيرات");
                zkrFrm.setVisible(true);
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

        results.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                adjusttext.setText(Data_Zekra2.arrangehkma(Data_Zekra2.hkma.get(Integer.parseInt(results.getSelectedValue().toString().split(" ")[0]))));
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

        results.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {

            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                if (ke.getKeyCode() == 40 || ke.getKeyCode() == 38) {

                    adjusttext.setText(Data_Zekra2.arrangehkma(Data_Zekra2.hkma.get(Integer.parseInt(results.getSelectedValue().toString().split(" ")[0]))));
                } //start   

            }

        });

        //system tray code
        PopupMenu popMenu = new PopupMenu();
        MenuItem item1 = new MenuItem("الرئيسية");
        
        item1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                mainFrm.setVisible(true);
                searchtext.setText("");
            }
        }); //adding action listener to item1

        MenuItem item2 = new MenuItem("اعرض حديث");
        item2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                Data_Zekra2.showZkr(zkrFrm, text, zkrimportant);

            }
        }); //adding action listener to item1

        MenuItem item3 = new MenuItem("إغلاق");
        item3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                System.exit(0);

            }
        }); //adding action listener to item1
        MenuItem item4 = new MenuItem("اوقف العرض");
        item4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                Data_Zekra2.clock.stop();
            }
        }); //adding action listener to item1
        MenuItem item5 = new MenuItem("اكمل العرض");
        item5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                Data_Zekra2.clock.start();

            }
        }); //adding action listener to item1

        MenuItem item6 = new MenuItem("اعرض حكمة");
        item6.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                hkmamain.setText("الصفحة الرئيسية");
                Data_Zekra2.showhkma(hkmaFrm, hkmatext, hkmaimportant);

            }
        }); //adding action listener to item1

        MenuItem item7 = new MenuItem("اضف حكمة");
        item7.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                hkmaFrm.setVisible(true);
                hkmamain.setText("الصفحة الرئيسية");
                hkmaimportant.setText("اضف");
                hkmatext.setText("");
            }
        }); //adding action listener to item1

         MenuItem item8 = new MenuItem("صيام الغد");
        item8.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
            if(Data_Zekra2.getSiam().equals(""))
                JOptionPane.showMessageDialog(null, "لا يوجد صيام الغد ان شاء الله");
            else
                JOptionPane.showMessageDialog(null,Data_Zekra2.getSiam());
            }
        }); //adding action listener to item1

        popMenu.add(item1);
        popMenu.add(item2);
        popMenu.add(item3);
        popMenu.add(item4);
        popMenu.add(item5);
        popMenu.add(item6);
        popMenu.add(item7);
        popMenu.add(item8);
        Image img = Toolkit.getDefaultToolkit().getImage("1.png");
        TrayIcon trayIcon = new TrayIcon(img, "ذكرى", popMenu);
        SystemTray.getSystemTray().add(trayIcon);
        trayIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    mainFrm.setVisible(true);
                    searchtext.setText("");
                }

            }

        });

        //end of system tray code
        //////////////////////
    }

}
