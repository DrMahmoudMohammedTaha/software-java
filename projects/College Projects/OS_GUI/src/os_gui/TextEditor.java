/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os_gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author DELL
 */
public class TextEditor {

    private JFrame editor = GUI_Ruler.addFrm(false, false, 300, 100, 400, 400,
            "Text Editor", "CAL_BACK.jpg", "CAL_ICON.png", false, false, false);
    private JTextArea texter = GUI_Ruler.addtxt(10, 10, 370, 300, null, editor);
    private JButton save = GUI_Ruler.addBtn(10, 10, 100, 50, "SAVE", null, editor);
    private JButton end = GUI_Ruler.addBtn(10, 10, 100, 50, "EXIT", null, editor);
    private JButton delete = GUI_Ruler.addBtn(10, 10, 100, 50, "DELETE", null, editor);
    private JScrollPane holderText = new JScrollPane(texter);
    public String content = "";

    private void getFile(String path) throws FileNotFoundException, IOException {

        BufferedReader br = null;

        br = new BufferedReader(new FileReader(path));
        String temp = "";
        while (true) {
            temp = br.readLine(); // this for the  dot in the start of the notepad

            if (temp.equals("xxx")) {
                break;
            }
            content += "\n" + temp;
        }
        try {
            br.close();
        } catch (IOException ex) {

        }
        texter.setText(content);
    }

    public void startTEXT(String path)  {
        
        try {
            
        getFile(path);    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error opening the file!");
        }
        
        GUI_Ruler.makeVertical(texter, save);
        GUI_Ruler.makeHorizontal(save, delete, end);
        GUI_Ruler.makeCenter(texter, editor);
        holderText.setBounds(texter.getX(), texter.getY(), texter.getWidth(), texter.getHeight());
        holderText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        editor.add(holderText, 0);
        save.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                try {
                    saveFile(path);
                } catch (IOException ex) {
                    System.out.println("ENTERED ERROR STATE TEXT");
                }
            }
        });
        end.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                editor.setVisible(false);

            }
        });
        delete.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                try {
                    deleteFile(path);
                } catch (IOException ex) {
                    System.out.println("ENTERED ERROR STATE TEXT");
                }
            }
        });
        editor.setVisible(true);
    }

    private void saveFile(String path) throws IOException {

        BufferedWriter wr = null;

        wr = new BufferedWriter(new FileWriter(path));

        String temper[] = texter.getText().split("\n");

        wr.write("");
        for (int i = 0; i < temper.length; i++) {
            wr.append(temper[i]);
            wr.newLine();

        }
        wr.append("xxx");
        wr.close();

    }

    private void deleteFile(String path) throws IOException {
        File file = new File(path);
        file.delete();
        editor.setVisible(false);
    }
}
