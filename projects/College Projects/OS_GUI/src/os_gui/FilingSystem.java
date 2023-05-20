package os_gui;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class FilingSystem {

    public void displayPath(String name) {

        JFrame folderFrm = GUI_Ruler.addFrm(false, false, 10, 10, 600, 400,
                "FOLDER", "CAL_BACK.jpg", "FOLDER_ICON.png", false, false, false);

        JLabel path_L = GUI_Ruler.addLbl(20, 20, 500, 40, name.substring(name.indexOf("root")), folderFrm);
        path_L.setFont(new Font("Jokerman", Font.PLAIN, 20));
        File f = new File(name);
        String files[] = f.list();
        JButton returner = GUI_Ruler.addBtn(20, 100, 50, 50, "", "BACK_BTN.png", folderFrm);
        JButton btns[] = new JButton[files.length];
        JButton creator = GUI_Ruler.addBtn(20, 100, 50, 50, "", "ADD_BTN.png", folderFrm);
        
        
        returner.setName(f.getAbsolutePath().substring(0, f.getAbsolutePath().indexOf(f.getName())));

        returner.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                if (((JButton) (me.getSource())).getName().equals(FilesTree.rooter + "root")) {
                    return;
                } else {
                    new FilingSystem().displayPath(((JButton) (me.getSource())).getName());
                    ((JFrame) SwingUtilities.getRoot((JButton) me.getSource())).setVisible(false);
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

        
        creator.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                String input = JOptionPane.showInputDialog(null, "Please Enter your folder name:");
                if(input == null || input.equals(""))
                    return;
                
                File folder = new File(((JButton) (me.getSource())).getName()+"\\"+input);
                folder.mkdir();
                
                System.out.println("directory added");
                //new FilingSystem().displayPath(((JButton) (me.getSource())).getName());
                //((JFrame) SwingUtilities.getRoot((JButton) me.getSource())).setVisible(false);
                
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

        
        if (f.exists()) {

            for (int i = 0; i < files.length; i++) {
                String imgName = "";
                if (f.listFiles()[i].isDirectory()) {
                    imgName = "FOLDER_ICON.png";
                } else {
                    String temp = files[i];
                    if (temp.endsWith(".mp3")) {
                        imgName = "MP3_ICON.png";
                    } else if (temp.endsWith(".mpg")) {
                        imgName = "MP4_ICON.png";
                    } else if (temp.endsWith(".txt")) {
                        imgName = "TEXT_ICON.png";
                    } else if (temp.endsWith(".pdf")) {
                        imgName = "PDF_ICON.png";
                    } else if (temp.endsWith(".jpg") || temp.endsWith(".png")
                            || temp.endsWith(".gif")) {
                        imgName = "IMAGE_ICON.png";
                    } else {
                        imgName = "UNDEFINED_ICON.png";
                    }
                }

                btns[i] = GUI_Ruler.addBtn(10, 10, 50, 50, "", imgName, folderFrm);
                btns[i].setName(f.listFiles()[i].getAbsolutePath());
                btns[i].setToolTipText(f.listFiles()[i].getName());
                creator.setName(f.getAbsolutePath());
                switch (imgName) {

                    case "FOLDER_ICON.png":
                        btns[i].addMouseListener(new MouseListener() {

                            @Override
                            public void mouseClicked(MouseEvent me) {
                                if (me.isControlDown()) {
                                    String temp = ((JButton) (me.getSource())).getName();
                                    File f_temp = new File(temp);

                                    JOptionPane.showMessageDialog(null, "META DATA:\n"
                                            + "path: " + temp
                                            + "\nSize: " + f_temp.length()
                                            + "\ntype: FOLDER DIRECTORY");
                                } else {
                                    new FilingSystem().displayPath(((JButton) (me.getSource())).getName());
                                    ((JFrame) SwingUtilities.getRoot((JButton) me.getSource())).setVisible(false);
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

                        break;
                    case "MP3_ICON.png":
                        btns[i].addMouseListener(new MouseListener() {

                            @Override
                            public void mouseClicked(MouseEvent me) {
                                if (me.isControlDown()) {
                                    String temp = ((JButton) (me.getSource())).getName();
                                    File f_temp = new File(temp);

                                    JOptionPane.showMessageDialog(null, "META DATA:\n"
                                            + "path:" + temp
                                            + "\nSize: " + f_temp.length()
                                            + "\ntype: MP3 FILE");
                                } else {
                                    new MP3(((JButton) (me.getSource())).getName());
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

                        break;
                    case "MP4_ICON.png":

                        btns[i].addMouseListener(new MouseListener() {

                            @Override
                            public void mouseClicked(MouseEvent me) {
                                if (me.isControlDown()) {
                                    String temp = ((JButton) (me.getSource())).getName();
                                    File f_temp = new File(temp);

                                    JOptionPane.showMessageDialog(null, "META DATA:\n"
                                            + "path:" + temp
                                            + "\nSize: " + f_temp.length()
                                            + "\ntype: MP4 FILE");
                                } else {
                                    MP4_player.start_MP4(((JButton) (me.getSource())).getName());
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

                        break;
                    case "TEXT_ICON.png":

                        btns[i].addMouseListener(new MouseListener() {

                            @Override
                            public void mouseClicked(MouseEvent me) {
                                if (me.isControlDown()) {
                                    String temp = ((JButton) (me.getSource())).getName();
                                    File f_temp = new File(temp);

                                    JOptionPane.showMessageDialog(null, "META DATA:\n"
                                            + "path:" + temp
                                            + "\nSize: " + f_temp.length()
                                            + "\ntype: TEXT FILE");
                                } else {
                                    new TextEditor().startTEXT(((JButton) (me.getSource())).getName());
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

                        break;
                    case "PDF_ICON.png":

                        btns[i].addMouseListener(new MouseListener() {

                            @Override
                            public void mouseClicked(MouseEvent me) {
                                if (me.isControlDown()) {
                                    String temp = ((JButton) (me.getSource())).getName();
                                    File f_temp = new File(temp);

                                    JOptionPane.showMessageDialog(null, "META DATA:\n"
                                            + "path:" + temp
                                            + "\nSize: " + f_temp.length()
                                            + "\ntype: PFD FILE");
                                } else {
                                    PDFReader.startPDF(((JButton) (me.getSource())).getName());
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

                        break;
                    case "IMAGE_ICON.png":
                        btns[i].addMouseListener(new MouseListener() {

                            @Override
                            public void mouseClicked(MouseEvent me) {
                                if (me.isControlDown()) {
                                    String temp = ((JButton) (me.getSource())).getName();
                                    File f_temp = new File(temp);

                                    JOptionPane.showMessageDialog(null, "META DATA:\n"
                                            + "path:" + temp
                                            + "\nSize: " + f_temp.length()
                                            + "\ntype: IMAGE FILE");
                                } else {
                                    imageViewer.newViewer(((JButton) (me.getSource())).getName());
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

                        break;
                    default:
                        btns[i].addMouseListener(new MouseListener() {

                            @Override
                            public void mouseClicked(MouseEvent me) {
                            }

                            @Override
                            public void mousePressed(MouseEvent me) {
                                JOptionPane.showMessageDialog(null, "Not supported File");

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

                        break;
                }
            }

        }
        if (btns.length != 0) {
            GUI_Ruler.makeVertical(path_L, returner, btns[0]);
        }

        for (int i = 1; i < btns.length; i++) {
            if (i % 9 == 0) {
                GUI_Ruler.makeVertical(btns[i - 1], btns[i]);
            } else {
                GUI_Ruler.makeFairHorizontal(btns[i - 1], btns[i]);
            }

        }
        GUI_Ruler.makeHorizontal(returner , creator);
        folderFrm.setVisible(true);
    }

}
