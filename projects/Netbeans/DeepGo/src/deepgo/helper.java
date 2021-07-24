/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepgo;

import static deepgo.servent.BOARD;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class helper {

    public static int countType(short t) {
        int temp = 0;
        for (int i = 0; i < BOARD.length; i++) {
            for (int j = 0; j < BOARD.length; j++) {
                if (BOARD[i][j] == t) {
                    temp++;
                }
            }
        }
        return temp;
    }

    public static int measureConnectivity(short t) {
        int temp = 0;
        for (int i = 0; i < BOARD.length; i++) {
            for (int j = 0; j < BOARD.length; j++) {
                int k1 = ((i - 1) < 0) ? i : i - 1,
                        k2 = ((i + 1) >= BOARD.length) ? i : i + 1,
                        l1 = ((j - 1) < 0) ? j : j - 1,
                        l2 = ((j + 1) >= BOARD.length) ? j : j + 1;
                for (int k = k1; k <= k2; k++) {
                    for (int l = l1; l <= l2; l++) {
                        if (BOARD[k][l] == t && BOARD[i][j] == t) {
                            temp++;
                        }
                    }
                }
            }
        }
        return temp;
    }

    public static ArrayList getVacants() {
        ArrayList<point> vacant = new ArrayList();
        for (int i = 1; i < BOARD.length-1; i++) {
            for (int j = 1; j < BOARD.length-1; j++) {
                if (BOARD[i][j] == 0) {
                    vacant.add(new point(i, j));
                }
            }
        }
        return vacant;
    }

    public static void setPoint(point p , int t) {
        System.out.println("wow");
        BOARD[p.x][p.y] = t;
    }
}
