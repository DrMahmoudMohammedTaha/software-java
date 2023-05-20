/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepgo;

import static deepgo.point.black;
import static deepgo.point.white;
import static deepgo.servent.BOARD;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class board implements actionable {

    private static void smartChecker(int i) {
        int temp = (i == 1) ? -1 : 1;

        for (int j = 0; j < BOARD.length; j++) {
            for (int k = 0; k < BOARD.length; k++) {
                int x1 = (j == 0) ? 0 : j - 1, x2 = (j == BOARD.length - 1) ? j : j + 1,
                        y1 = (k == 0) ? 0 : k - 1,
                        y2 = (k == BOARD.length - 1) ? k : k + 1;
                if (BOARD[x1][k] == temp && BOARD[x2][k] == temp && BOARD[j][y1] == temp && BOARD[j][y2] == temp && BOARD[j][k] == i )  {
                    BOARD[j][k] = 0;

                }
            }
        }

    }

    @Override
    public void doTurn() {
        removeType(white);
        removeType(black);
    }

    public static void removeType(int i) {

        smartChecker(i);
        ArrayList< ArrayList<point>> temp = grouping.getGroups(i);
        for (int j = 0; j < temp.size(); j++) {
            if (checkDeath(temp.get(j), i)) {
                deleteGroup(temp.get(j));
            }
        }

    }

    public static void deleteGroup(ArrayList<point> arrPoint) {
        for (int i = 0; i < arrPoint.size(); i++) {
            point p = arrPoint.get(i);
            BOARD[p.x][p.y] = 0;
        }
    }

    private static boolean checkDeath(ArrayList<point> groupPoints, int TYPE) {

        int temp = (TYPE == 1) ? -1 : 1;
        int simulatingBoard[][] = new int[BOARD.length][BOARD.length];
        for (int i = 0; i < groupPoints.size(); i++) {
            simulatingBoard[groupPoints.get(i).x][groupPoints.get(i).y] = TYPE;
        }

        for (int i = 0; i < BOARD.length; i++) {
            for (int j = 0; j < BOARD.length; j++) {
                try {
                    if (simulatingBoard[i - 1][j] == TYPE && BOARD[i][j] != temp) {
                        return false;
                    }
                } catch (Exception e) {
                }
                try {
                    if (simulatingBoard[i + 1][j] == TYPE && BOARD[i][j] != temp) {
                        return false;
                    }
                } catch (Exception e) {
                }
                try {
                    if (simulatingBoard[i][j - 1] == TYPE && BOARD[i][j] != temp) {
                        return false;
                    }
                } catch (Exception e) {
                }
                try {
                    if (simulatingBoard[i][j + 1] == TYPE && BOARD[i][j] != temp) {
                        return false;
                    }
                } catch (Exception e) {
                }
            }
        }
        return true;
    }

}
