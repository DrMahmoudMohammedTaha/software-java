/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepgo;

import static deepgo.board.deleteGroup;
import static deepgo.point.nextTo;
import static deepgo.servent.BOARD;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class treeBuilder {

    public static int[][] start_board = new int[BOARD.length][BOARD.length];

    public static ArrayList<point> group;

    public static ArrayList<point> target = new ArrayList<>();

    public static int TYPE;

    public static void smartTreeBuilder(ArrayList<point> selected, int type) {

        TYPE = type;
        group = selected;
        startTrialBoard();
        System.out.println("group.size() " + group.size());
        addTargets();
        System.out.println("target.size() " + target.size());

        limitedDepthSearch();
    }

    public static void addTargets() {

        target.clear();
        target = new ArrayList<>();
        for (int i = 0; i < group.size(); i++) {
            point p = group.get(i);
            System.out.println(p);

            for (int f = p.x - 1; f <= p.x + 1; f++) {
                for (int j = p.y - 1; j <= p.y + 1; j++) {
                    try {
                        if (start_board[f][j] == 0 && (f == p.x || j == p.y)) {
                            target.add(new point(f, j));
                        }

                    } catch (Exception e) {
                        System.out.println("smart index exception! " + e.toString());
                    }
                }
            }

        }
    }

    public static void limitedDepthSearch() {

        int max = 0;
        int index = 0;
        for (int i = 0; i < target.size(); i++) {
            int temp = measureNode(target.get(i));
            if (temp > max) {
                max = temp;
                index = i;
            }
        }

        if (target.isEmpty()) {
            deleteGroup(group);
        } else {
            helper.setPoint(target.get(index), TYPE);
        }
    }

    public static int measureNode(point p) {

        int temper = (TYPE == 1) ? -1 : 1;
        int x1 = (p.x == 0) ? p.x + 1 : p.x - 1,
                x2 = (p.x == BOARD.length - 1) ? p.x - 1 : p.x + 1,
                y1 = (p.y == 0) ? p.y + 1 : p.y - 1,
                y2 = (p.y == BOARD.length - 1) ? p.y - 1 : p.y + 1;
        if (BOARD[x1][p.y] == temper && BOARD[x2][p.y] == temper && BOARD[p.x][y1] == temper && BOARD[p.x][y2] == temper) {
            return 0;
        }
        start_board[p.x][p.y] = TYPE;
        int temp = 0;
        for (int i = 0; i < start_board.length; i++) {
            for (int j = 0; j < start_board.length; j++) {
                int k1 = ((i - 1) < 0) ? i : i - 1,
                        k2 = ((i + 1) >= start_board.length) ? i : i + 1,
                        l1 = ((j - 1) < 0) ? j : j - 1,
                        l2 = ((j + 1) >= start_board.length) ? j : j + 1;
                for (int k = k1; k <= k2; k++) {
                    for (int l = l1; l <= l2; l++) {
                        if (start_board[k][l] == TYPE && nextTo(new point(k, l), p)) {
                            temp++;
                        }
                    }
                }
            }
        }
        start_board[p.x][p.y] = 0;

        return temp;
    }

    private static void startTrialBoard() {

        for (int i = 0; i < BOARD.length; i++) {
            for (int j = 0; j < BOARD.length; j++) {
                start_board[i][j] = BOARD[i][j];
            }
        }
    }

}
