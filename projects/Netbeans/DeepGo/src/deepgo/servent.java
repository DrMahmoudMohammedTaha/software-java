/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepgo;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class servent {

    public static final int boardSize = 19;
    public static int steps = 300;
    public static boolean stilPlaying = true;
    public static actionable players[] = {new robot1(), new board(), new robot2(), new board()};
    public static final int[][] BOARD = new int[boardSize][boardSize];
    public static int SECONDS = 1000;
    
    public static void clearAll(){
       
    }
    public static void startGame() {
        startBoard();
        drawer.startBuffers();
        while (stilPlaying && steps-- != 0) {
            System.out.println("step " + steps + " turn " + players[steps % 4].getClass());
            giveTurn();
            drawer.drawBoard();
            // small delay

        }
        displayWinner();
    }

    public static void giveTurn() {
        players[steps % 4].doTurn();
    }

    public static void startBoard() {
        for (int i = 0; i < BOARD.length; i++) {
            for (int j = 0; j < BOARD[i].length; j++) {
                BOARD[i][j] = 0;
            }
        }
    }

    private static void displayWinner() {
        int count1 = 0, count2 = 0;
        for (int i = 0; i < BOARD.length; i++) {
            for (int j = 0; j < BOARD.length; j++) {
                if (BOARD[i][j] == 1) {
                    count1++;
                } else if (BOARD[i][j] == -1) {
                    count2++;
                }
            }
        }

        String temp = "player 1 has: " + count1 + "\nplayer 2 has: " + count2 + "\n";
        if (count1 > count2) {
            temp += "player 1 wins!";
        } else if (count1 < count2) {
            temp += "player 2 wins!";
        } else {
            temp += "withdrawal!";
        }
        JOptionPane.showMessageDialog(null, temp);
        System.out.println(temp);
    }
}
