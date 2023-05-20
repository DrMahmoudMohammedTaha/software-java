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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
//end tray

public class ZEKRA2 {

    static JFrame mainFrm = GUI_Ruler2.addFrm(false, false, 400, 250, 450, 400, "ذكرى", "zekra.png", "1.png", false);
    static JButton Next = GUI_Ruler2.addBtn(15, 10, 150, 50, "اعرض حديث", mainFrm);
    static JButton hkmabtn = GUI_Ruler2.addBtn(15, 10, 150, 50, "اعرض حكمة", mainFrm);
    static JButton important = GUI_Ruler2.addBtn(15, 10, 150, 50, "اعرض قائمتى", mainFrm);
    static JButton adjust = GUI_Ruler2.addBtn(15, 10, 150, 50, "اضبط", mainFrm);
    static JButton addhkma = GUI_Ruler2.addBtn(15, 10, 230, 50, "اضف حكمة", mainFrm);
    static JButton homeParadise = GUI_Ruler2.addBtn(15, 10, 140, 50, "بيت فى الجنة", mainFrm);
    static JButton exit = GUI_Ruler2.addBtn(15, 10, 230, 50, "إغلاق نهائى", mainFrm);
    static JList profile = new JList();
    static JScrollPane pp = new JScrollPane(profile);
    static DefaultListModel profileModel = new DefaultListModel();
    static JTextArea searchtext = GUI_Ruler2.addtxt(30, 30, 290, 50, "", mainFrm);
    static JButton searchbtn = GUI_Ruler2.addBtn(15, 250, 100, 50, "ابحث", mainFrm);
    static JButton imageAddbtn = GUI_Ruler2.addBtn(15, 250, 120, 50, "اضف صورة", mainFrm);
    static JButton imageDeletebtn = GUI_Ruler2.addBtn(15, 250, 120, 50, "امسح صورة", mainFrm);

    static JFrame zkrFrm = GUI_Ruler2.addFrm(false, false, 800, 250, 440, 500, "ذكرى", null, "1.png", false);
    static JTextArea text;
    static JScrollPane holderText;
    static JButton zkrimportant;
    static JButton zkrmain;

    static JFrame imageFrm = GUI_Ruler2.addFrm(false, false, 800, 220, 445, 530, "ذكرى", null, "1.png", false);
    static BufferedImage img;

    static JFrame hkmaFrm = GUI_Ruler2.addFrm(false, false, 800, 250, 440, 500, "ذكرى", "hkma.jpg", "1.png", false);
    static JTextArea hkmatext = GUI_Ruler2.addtxt(30, 30, 300, 300, "", hkmaFrm);
    static JScrollPane hkmaholderText = new JScrollPane(hkmatext);
    static JButton hkmaimportant = GUI_Ruler2.addBtn(450, 10, 200, 50, "اضف لقائمتى", hkmaFrm);
    static JButton hkmamain = GUI_Ruler2.addBtn(450, 400, 200, 50, "الصفحة الرئيسية", hkmaFrm);

    static JFrame adjustFrm = GUI_Ruler2.addFrm(false, false, 800, 250, 440, 500, "ذكرى", "hkma.jpg", "1.png", false);
    static JTextArea adjusttext = GUI_Ruler2.addtxt(30, 30, 300, 150, "", adjustFrm);
    static JScrollPane adjustholderText = new JScrollPane(adjusttext);
    static JButton adjustdelete = GUI_Ruler2.addBtn(450, 10, 200, 50, "مسح", adjustFrm);
    static JButton adjuster = GUI_Ruler2.addBtn(450, 400, 200, 50, "تعديل", adjustFrm);
    static JList results = new JList();
    static JScrollPane rp = new JScrollPane(results);
    static DefaultListModel resultsModel = new DefaultListModel();

    public static void main(String[] args) throws IOException, AWTException {

        imageFrm.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {

            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                ((JFrame) ke.getSource()).setVisible(false);
            }

        });

        imageDeletebtn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                File file;
                JFileChooser fileChooser = new JFileChooser(new File("images"));
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

                while (true) {

                    if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION && fileChooser.getSelectedFile().getPath().contains("\\images\\")) {
                        file = fileChooser.getSelectedFile(); // get File
                        if (file.getName().endsWith(".jpg") || file.getName().endsWith(".png") || file.getName().endsWith(".gif")) {
                            {
                                file.delete();
                                break;
                            }

                        }
                    } else if (fileChooser.showOpenDialog(null) == JFileChooser.CANCEL_OPTION) {
                        break;
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
        imageAddbtn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {

                File file;
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

                while (true) {

                    if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                        file = fileChooser.getSelectedFile(); // get File
                        if (file.getName().endsWith(".jpg") || file.getName().endsWith(".png") || file.getName().endsWith(".gif")) {
                            {
                                file.renameTo(new File("images\\" + file.getName()));
                                break;
                            }

                        }
                    } else if (fileChooser.showOpenDialog(null) == JFileChooser.CANCEL_OPTION) {
                        break;
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
        }
        );

        Data_Zekra2.background = new JLabel(new ImageIcon(ImageIO.read(new File("8.jpg"))));
        Data_Zekra2.background.setBounds(0, 0, zkrFrm.getWidth(), zkrFrm.getHeight());
        Data_Zekra2.background.repaint();
        zkrFrm.add(Data_Zekra2.background, 0);
        text = GUI_Ruler2.addtxt(30, 30, 300, 300, "", zkrFrm);
        holderText = new JScrollPane(text);
        zkrimportant = GUI_Ruler2.addBtn(450, 10, 200, 50, "اضف لقائمتى", zkrFrm);
        zkrmain = GUI_Ruler2.addBtn(450, 400, 200, 50, "الصفحة الرئيسية", zkrFrm);

        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("WinSoft Thuluth", Font.BOLD, 15)));
        Data_Zekra2.intial("data.txt", "time.txt", "hkma.txt");
        Data_Zekra2.startTimer(zkrFrm, text, zkrimportant, zkrmain, hkmaFrm, hkmatext, hkmaimportant);

        text.setLineWrap(true);
        hkmatext.setLineWrap(true);
        searchtext.setWrapStyleWord(true);
        adjusttext.setLineWrap(true);
        text.setTabSize(10);

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

        text.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        searchtext.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        GUI_Ruler2.makeVertical(Next, important, hkmabtn, searchbtn, imageAddbtn, exit);
        GUI_Ruler2.makeHorizontal(imageAddbtn, imageDeletebtn);
        GUI_Ruler2.makeHorizontal(searchbtn, searchtext);
        GUI_Ruler2.makeHorizontal(exit, homeParadise);
        GUI_Ruler2.makeHorizontal(hkmabtn, addhkma);
        GUI_Ruler2.makeHorizontal(90, important, adjust);
        GUI_Ruler2.makeHorizontal(90, Next, pp);
        profile.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        results.setForeground(Color.black);
        results.setBackground(Color.BLUE);
        results.setFont(new Font("Courier New", Font.BOLD, 18));
        results.repaint();
        rp.setBounds(20, 210, 400, 150);
        adjustFrm.add(rp, 0);
        results.setModel(resultsModel);
        results.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

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
                            resultsModel.addElement(holding[i] + " " + Data_Zekra2.hkma.get(Integer.parseInt(holding[i].trim())));
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
                        Logger.getLogger(ZEKRA2.class
                                .getName()).log(Level.SEVERE, null, ex);

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
                                resultsModel.addElement(holding[i] + " " + Data_Zekra2.hkma.get(Integer.parseInt(holding[i].trim())));
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
                    Logger.getLogger(ZEKRA2.class
                            .getName()).log(Level.SEVERE, null, ex);
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
                    Data_Zekra2.hkma.set(Integer.parseInt(results.getSelectedValue().toString().split(" ")[0]), adjusttext.getText());

                    try {
                        Data_Zekra2.save("data.txt", "hkma.txt");

                    } catch (IOException ex) {
                        Logger.getLogger(ZEKRA2.class
                                .getName()).log(Level.SEVERE, null, ex);

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
                                resultsModel.addElement(holding[i] + " " + Data_Zekra2.hkma.get(Integer.parseInt(holding[i].trim())));
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

                hkmatext.setEditable(true);
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
                try {
                    Data_Zekra2.showZkr(zkrFrm, text, zkrimportant, zkrmain);

                } catch (ClassNotFoundException ex) {
                } catch (IOException ex) {
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

        hkmabtn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                if (!Data_Zekra2.hkma.isEmpty()) {
                    hkmamain.setText("الصفحة الرئيسية");
                    Data_Zekra2.showhkma(hkmaFrm, hkmatext, hkmaimportant);

                } else {

                    showImage();
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

                try {
                    Data_Zekra2.setPeriod("time.txt", i);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "NO time file");
                }
                Data_Zekra2.startTimer(zkrFrm, text, zkrimportant, zkrmain, hkmaFrm, hkmatext, hkmaimportant);
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
                        Logger.getLogger(ZEKRA2.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    Data_Zekra2.important += text.getText().split("---------------")[0] + "\n" + "#############################" + "\n";
                    try {
                        Data_Zekra2.save("data.txt", "hkma.txt");

                    } catch (IOException ex) {
                        Logger.getLogger(ZEKRA2.class
                                .getName()).log(Level.SEVERE, null, ex);
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
                if (hkmaimportant.getText().equals("اضف لقائمتى")) {
                    Data_Zekra2.important += hkmatext.getText().split("---------------")[0] + "\n" + "#############################" + "\n";
                    try {
                        Data_Zekra2.save("data.txt", "hkma.txt");

                    } catch (IOException ex) {
                        Logger.getLogger(ZEKRA2.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (hkmaimportant.getText().equals("اضف")) {
                    Data_Zekra2.hkma.add(hkmatext.getText());
                    try {

                        Data_Zekra2.save("data.txt", "hkma.txt");

                    } catch (IOException ex) {
                        Logger.getLogger(ZEKRA2.class
                                .getName()).log(Level.SEVERE, null, ex);
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
                text.setEditable(true);
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
                adjusttext.setText(Data_Zekra2.hkma.get(Integer.parseInt(results.getSelectedValue().toString().split(" ")[0])));
                adjusttext.setCaretPosition(0);
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

                    adjusttext.setText(Data_Zekra2.hkma.get(Integer.parseInt(results.getSelectedValue().toString().split(" ")[0])));
                    adjusttext.setCaretPosition(0);
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

        MenuItem item2 = new MenuItem("حديث");
        item2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    Data_Zekra2.showZkr(zkrFrm, text, zkrimportant, zkrmain);

                } catch (ClassNotFoundException ex) {
                } catch (IOException ex) {
                }

            }
        }); //adding action listener to item1

        MenuItem item3 = new MenuItem("إغلاق");
        item3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                System.exit(0);

            }
        }); //adding action listener to item1
        MenuItem item5 = new MenuItem("اكمل العرض");
        item5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                Data_Zekra2.clock.start();

            }
        }); //adding action listener to item1

        MenuItem item6 = new MenuItem("حكمة");
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
                hkmatext.setEditable(true);
            }
        }); //adding action listener to item1

        MenuItem item8 = new MenuItem("صيام الغد");
        item8.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (Data_Zekra2.getSiam().equals("")) {
                    JOptionPane.showMessageDialog(null, "لا يوجد صيام الغد ان شاء الله");
                } else {
                    JOptionPane.showMessageDialog(null, Data_Zekra2.getSiam());
                }
            }
        }); //adding action listener to item1

        MenuItem item9 = new MenuItem("بيت فى الحنة");
        item9.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    Data_Zekra2.paradise();

                } catch (IOException ex) {
                    Logger.getLogger(ZEKRA2.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }); //adding action listener to item1

        PopupMenu shower = new PopupMenu("اعرض");

        shower.add(item2);
        shower.add(item6);

        PopupMenu times = new PopupMenu("اوقف لمدة");

        MenuItem times1 = new MenuItem("10 دقائق");
        times1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                Data_Zekra2.temporaryTimer(10);
            }
        }); //adding action listener to item1

        MenuItem times2 = new MenuItem("30 دقائق");
        times2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                Data_Zekra2.temporaryTimer(30);
            }
        }); //adding action listener to item1

        MenuItem times3 = new MenuItem("كليا");
        times3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                Data_Zekra2.clock.stop();
            }
        }); //adding action listener to item1

        times.add(times1);
        times.add(times2);
        times.add(times3);

        PopupMenu control = new PopupMenu("تحكم");
        control.add(times);
        control.add(item5);

        popMenu.add(item1);
        popMenu.add(item7);
        popMenu.add(item8);
        popMenu.add(item9);
        popMenu.add(control);
        popMenu.add(shower);
        popMenu.add(item3);

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

    public static void showImage() {

        try {

            File f = new File("images");
            File files[] = f.listFiles();
            String s = "";
            while (!(s.endsWith(".jpg") || s.endsWith(".png") || s.endsWith(".gif"))) {
                s = files[new Random().nextInt(files.length)].getName();
            }

            img = ImageIO.read(new File("images\\" + s));

            int width = img.getWidth();
            int height = img.getHeight();

            while (width > 600 || height > 600) {
                width /= 5;
                height /= 5;
                width *= 4;
                height *= 4;
            }

            Image image = img.getScaledInstance(width, height, 0);

            JLabel background = new JLabel(new ImageIcon(image));

            background.setBounds(0, 0, width, height);
            imageFrm.setBounds(1260 - width, 720 - height, width + 5, height + 25);
            imageFrm.add(background, 0);
            background.repaint();
            imageFrm.setVisible(true);

        } catch (IOException e) {
        }

    }

}
