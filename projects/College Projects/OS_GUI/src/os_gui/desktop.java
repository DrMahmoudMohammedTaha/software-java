/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os_gui;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class desktop {

    static private String desktopBackground = "desktop.jpg";
    static public JLabel background;
    public static final int imgWidth = 1400;
    public static final int imgHight = 770;
    static private JFrame desktop = GUI_Ruler.addFrm(false, false, 0, 0, imgWidth, imgHight,
            "ذكرى", desktopBackground, null, true, true, true);
    public static ArrayList<JFrame> OTHER_FRAMES = new ArrayList();

    //minimized programs code
    public static ArrayList<JFrame> MINIMIZED_FRAMES = new ArrayList();
    public static JList profile = new JList();
    public static JScrollPane pp = new JScrollPane(profile);
    public static DefaultListModel profileModel = new DefaultListModel();

    public static void setDesktopBackground(String desktopName) {
        desktopBackground = desktopName;
        refresh();
    }

    public static void refreshOtherFrames() {
        for (int i = 0; i < OTHER_FRAMES.size(); i++) {
            if (OTHER_FRAMES.get(i) != null && OTHER_FRAMES.get(i).isVisible()) {
                OTHER_FRAMES.get(i).toFront();
            }
        }

    }

    public static void initiatePopMenu() {

        profile.setFont(new Font("Jokerman", Font.PLAIN, 15));
        int x = imgWidth / 2 - 200, y = imgHight / 2 - 130;
        JLabel time = GUI_Ruler.addLbl(90 + x, 100 + y, 130, 25, "", desktop);
        JLabel day = GUI_Ruler.addLbl(100 + x, 125 + y, 130, 25, "", desktop);
        JLabel date = GUI_Ruler.addLbl(110 + x, 150 + y, 140, 25, "", desktop);
        TimeDater.startTime(time, day, date);

    }

    public static void initiateBtn() {

        JButton shutDown = GUI_Ruler.addBtn(imgWidth - 103, 0, 70, 70, "", "shutdown.png", desktop);
        shutDown.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                int k = JOptionPane.showConfirmDialog(null, "Ary really want to Exit");
                if (k == 0) {
                    System.exit(0);
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {
                refreshOtherFrames();

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

        JButton BACK = GUI_Ruler.addBtn(shutDown.getX(), shutDown.getY() + shutDown.getHeight() + 620, 70, 70, "", "GROUND.png", desktop);
        BACK.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
//
                //code  here
                File file;
                JFileChooser fileChooser = new JFileChooser("H:\\software projects\\Netbeans Projects\\OS_GUI\\root");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int count;
                while (true) {
                    count = fileChooser.showOpenDialog(null);

                    if (count == JFileChooser.APPROVE_OPTION) {
                        file = fileChooser.getSelectedFile(); // get File
                        if (file.getName().endsWith(".jpg") || file.getName().endsWith(".png")
                                || file.getName().endsWith(".gif")) {
                            {
                                setDesktopBackground(file.getAbsolutePath());
                                break;
                            }
                        }
                    } else if (count == JFileChooser.CANCEL_OPTION) {
                        break;
                    }
                }
                //
            }

            @Override
            public void mousePressed(MouseEvent me) {
                refreshOtherFrames();
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
        
        
        JButton CAL_BTN = GUI_Ruler.addBtn(20, 20, 100, 100, "", "CAL_ICO.png", desktop);
        CAL_BTN.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                Calculator.viewCalculator();
            }

            @Override
            public void mousePressed(MouseEvent me) {
                refreshOtherFrames();

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

        JButton MP3_BTN = GUI_Ruler.addBtn(20, 20, 100, 100, "", "MP3_ICON.png", desktop);
        MP3_BTN.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                 //code  here
                File file;
                JFileChooser fileChooser = new JFileChooser("H:\\software projects\\Netbeans Projects\\OS_GUI\\root");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int count;
                while (true) {
                    count = fileChooser.showOpenDialog(null);

                    if (count == JFileChooser.APPROVE_OPTION) {
                        file = fileChooser.getSelectedFile(); // get File
                        if (file.getName().endsWith(".mp3") ) {
                            {
                                new MP3(file.getAbsolutePath());
                                break;
                            }
                        }
                    } else if (count == JFileChooser.CANCEL_OPTION) {
                        break;
                    }
                }
                //

            }

            @Override
            public void mousePressed(MouseEvent me) {
                refreshOtherFrames();

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

        JButton MP4_BTN = GUI_Ruler.addBtn(20, 20, 100, 100, "", "MP4_ICON.png", desktop);
        MP4_BTN.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                 //code  here
                File file;
                JFileChooser fileChooser = new JFileChooser("H:\\software projects\\Netbeans Projects\\OS_GUI\\root");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int count;
                while (true) {
                    count = fileChooser.showOpenDialog(null);

                    if (count == JFileChooser.APPROVE_OPTION) {
                        file = fileChooser.getSelectedFile(); // get File
                        if (file.getName().endsWith(".mpg") ) {
                            {
                                MP4_player.start_MP4(file.getAbsolutePath());
                                break;
                            }
                        }
                    } else if (count == JFileChooser.CANCEL_OPTION) {
                        break;
                    }
                }
                //

            }

            @Override
            public void mousePressed(MouseEvent me) {
                refreshOtherFrames();

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

         
        JButton PAINT_BTN = GUI_Ruler.addBtn(20, 20, 100, 100, "", "PAINT_ICON.png", desktop);
        PAINT_BTN.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                new Paint().createNewPaint();
            }

            @Override
            public void mousePressed(MouseEvent me) {
                refreshOtherFrames();

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

        JButton PDF_BTN = GUI_Ruler.addBtn(20, 20, 100, 100, "", "PDF_ICON.png", desktop);
        PDF_BTN.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                 //code  here
                File file;
                JFileChooser fileChooser = new JFileChooser("H:\\software projects\\Netbeans Projects\\OS_GUI\\root");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int count;
                while (true) {
                    count = fileChooser.showOpenDialog(null);

                    if (count == JFileChooser.APPROVE_OPTION) {
                        file = fileChooser.getSelectedFile(); // get File
                        if (file.getName().endsWith(".pdf") ) {
                            {
                                PDFReader.startPDF(file.getAbsolutePath());
                                break;
                            }
                        }
                    } else if (count == JFileChooser.CANCEL_OPTION) {
                        break;
                    }
                }
                //

            }

            @Override
            public void mousePressed(MouseEvent me) {
                refreshOtherFrames();

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
       
        JButton TEXT_BTN = GUI_Ruler.addBtn(20, 20, 100, 100, "", "TEXT_ICON.png", desktop);
        TEXT_BTN.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                 //code  here
                File file;
                JFileChooser fileChooser = new JFileChooser("H:\\software projects\\Netbeans Projects\\OS_GUI\\root");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int count;
                while (true) {
                    count = fileChooser.showOpenDialog(null);

                    if (count == JFileChooser.APPROVE_OPTION) {
                        file = fileChooser.getSelectedFile(); // get File
                        if (file.getName().endsWith(".txt") ) {
                            {
                                new TextEditor().startTEXT(file.getAbsolutePath());
                                break;
                            }
                        }
                    } else if (count == JFileChooser.CANCEL_OPTION) {
                        break;
                    }
                }
                //

            }

            @Override
            public void mousePressed(MouseEvent me) {
                refreshOtherFrames();

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
       
        JButton IMAGE_BTN = GUI_Ruler.addBtn(20, 20, 100, 100, "", "IMAGE_ICON.png", desktop);
        IMAGE_BTN.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                 //code  here
                File file;
                JFileChooser fileChooser = new JFileChooser("H:\\software projects\\Netbeans Projects\\OS_GUI\\root");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int count;
                while (true) {
                    count = fileChooser.showOpenDialog(null);

                    if (count == JFileChooser.APPROVE_OPTION) {
                        file = fileChooser.getSelectedFile(); // get File
                        if (file.getName().endsWith(".jpg") || file.getName().endsWith(".png")
                                || file.getName().endsWith(".gif")) {
                            {
                               imageViewer.newViewer(file.getAbsolutePath());
                                break;
                            }
                        }
                    } else if (count == JFileChooser.CANCEL_OPTION) {
                        break;
                    }
                }
                //

            }

            @Override
            public void mousePressed(MouseEvent me) {
                refreshOtherFrames();

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
        
        JButton FOLDER_BTN = GUI_Ruler.addBtn(20, 20, 100, 100, "", "FOLDER_ICON.png", desktop);
        FOLDER_BTN.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
              new  FilingSystem().displayPath(FilesTree.rooter + "root");
            }
 
            @Override
            public void mousePressed(MouseEvent me) {
                refreshOtherFrames();

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

        JButton TASK_BTN = GUI_Ruler.addBtn(20, 660, 100, 100, "", "TASK_ICON.png", desktop);
        TASK_BTN.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                Task_Manager.startManger();
            }

            @Override
            public void mousePressed(MouseEvent me) {
                refreshOtherFrames();

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

        JButton TREE_BTN = GUI_Ruler.addBtn(20, 660, 100, 100, "", "TREE_ICON.png", desktop);
        TREE_BTN.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                try {
                    FilesTree.startTree();
                } catch (InterruptedException ex) {
                   JOptionPane.showMessageDialog(null, "Error happenned with you file system!");
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {
                refreshOtherFrames();

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

        
        GUI_Ruler.makeHorizontal( CAL_BTN , MP3_BTN , MP4_BTN , PAINT_BTN , PDF_BTN , TEXT_BTN , IMAGE_BTN , FOLDER_BTN);
        GUI_Ruler.makeHorizontal(TASK_BTN , TREE_BTN);
        profile.repaint();
        
        pp.setBounds(shutDown.getX() - 120 + shutDown.getWidth(), shutDown.getY() + shutDown.getHeight() + 20, 120, 590);
        desktop.add(pp, 0);
        profile.setModel(profileModel);
        profile.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        profile.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                refreshOtherFrames();
            }

            @Override
            public void mouseReleased(MouseEvent evt) {
                if (profile.getSelectedIndex() == -1) {
                    return;
                }

                MINIMIZED_FRAMES.get(profile.getSelectedIndex())
                        .setExtendedState(JFrame.NORMAL);
                MINIMIZED_FRAMES.remove(MINIMIZED_FRAMES.get(profile.getSelectedIndex()));
                profileModel.remove(profile.getSelectedIndex());

            }
        });
        profile.repaint();
        profile.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
        
        pp.setOpaque(false);
        pp.setViewportView(profile);
        pp.getViewport().setOpaque(false);
        pp.setOpaque(false);
        ((DefaultListCellRenderer) profile.getCellRenderer()).setOpaque(false);
        profile.setOpaque(false);
    }

    public static void updateList() {
        profileModel.clear();
        for (int i = 0; i < MINIMIZED_FRAMES.size(); i++) {
            profileModel.addElement(MINIMIZED_FRAMES.get(i).getTitle());
        }

    }

    public static void refresh() {
        desktop.remove(background);
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(desktopBackground));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "sorry,cannot open your image");
            try {
                img = ImageIO.read(new File("desktop.jpg"));
            } catch (IOException ex1) {

            }
        }
        Image image = img.getScaledInstance(imgWidth, imgHight, 0);
        background = new JLabel(new ImageIcon(image));
        background.setBounds(0, 0, imgWidth, imgHight);
        background.repaint();
        desktop.add(background);
        //TODO refresh all desktop components
        desktop.repaint();

        background.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {

                refreshOtherFrames();
            }
        });
    }

    public static void startGUI() {
        new Mp3Player().play("welcome.mp3");
        initiateBtn();
        initiatePopMenu();
        refresh();
        PasswordFrame.lockPassFrame();
        desktop.setVisible(true);
    }
}
