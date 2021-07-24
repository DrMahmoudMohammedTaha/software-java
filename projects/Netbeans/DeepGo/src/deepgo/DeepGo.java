/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepgo;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author DELL
 */
public class DeepGo {

    /**
     * @param args the command line arguments
     */
    static final JFrame mainFrm = GUI_Ruler2.addFrm(true, false, 270, 20, 680, 685, "Go", "board.png", null, true);
    //static final JButton repeater = GUI_Ruler2.addBtn(mainFrm.getWidth() - 70, mainFrm.getHeight() - 60, 80, 30, "NEW", mainFrm);

    public static void main(String[] args) {

        servent.startGame();

    }

}
