/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepgo;

import static deepgo.DeepGo.mainFrm;
import static deepgo.servent.BOARD;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author DELL
 */
public class drawer {

    public static BufferedImage imgBlack, imgRed;
    public static final int STEP = 35;
    public static final int margin = 9;
    public static final int SIZE = 20;
    public static ArrayList<JLabel> old = new ArrayList<JLabel>();

    public static void startBuffers() {
        try {
            imgBlack = ImageIO.read(new File("black.png"));
        } catch (IOException ex) {
        }

        try {
            imgRed = ImageIO.read(new File("red.png"));
        } catch (IOException ex) {
        }

    }

    public static void drawPoint(point p, int TYPE) {

        JLabel background;

        if (TYPE == 1) {
            background = new JLabel(new ImageIcon(imgRed));

        } else if (TYPE == -1) {
            background = new JLabel(new ImageIcon(imgBlack));

        } else {
            return;
        }
        background.setBounds(p.x * STEP + margin, p.y * STEP + margin, SIZE, SIZE);
        mainFrm.add(background, 0);
        mainFrm.repaint();
        mainFrm.repaint();
        old.add(background);

    }

    public static void drawBoard() {
        clearBoard();
        for (int i = 0; i < BOARD.length; i++) {
            for (int j = 0; j < BOARD.length; j++) {
                drawPoint(new point(i, j), BOARD[i][j]);
            }
        }
    }

    public static void clearBoard() {
        for (int i = 0; i < old.size(); i++) {
            mainFrm.remove(old.get(i));
        }
        old = new ArrayList<JLabel>();
    }

}
