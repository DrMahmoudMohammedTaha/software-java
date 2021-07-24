/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepgo;

/**
 *
 * @author DELL
 */
public class point {

    int x, y;
    public static final short white = 1;
    public static final short black = -1;

    enum colour {

        white, black
    };

    public point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static double eculideanDist(point p1, point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    public static boolean nextTo(point p1, point p2) {
        return (eculideanDist(p1, p2) < 2);
    }

    public static boolean similar(point p1, point p2) {
        return (eculideanDist(p1, p2) == 0);
    }

    @Override
    public String toString() {
        return "( " + x + " , " + y + " )";
    }

}
