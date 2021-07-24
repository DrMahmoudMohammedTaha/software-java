//Sheet 3 Problem 2: Random Stars II
import java.util.Scanner;

public class random_stars_ii {

    public static void main(String args[]) {
        final int W = 5;
        char[][] sky = new char[W][];
        for (int i = 0; i < W; i++) {
            sky[i] = new char[W];
        }
        float p;
        do {
            System.out.print("Enter the stars ratio: ");
            Scanner in = new Scanner(System.in);
            p = in.nextFloat();
        } while (p < 0 || p > 1);
        rndStars(sky, p);
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(sky[i][j]);
            }
            System.out.println();
        }
    }

    static void rndStars(char[][] sky, float p) {
        for (int i = 0; i < sky.length; i++) {
            for (int j = 0; j < sky.length; j++) {
                sky[i][j] = ' ';
            }
        }
        for (int i = 0; i < p * sky.length * sky.length; i++) {
            int col, row;
            do {
                col = (int) (Math.random() * sky.length);
                row = (int) (Math.random() * sky.length);
            } while (sky[row][col] == '*');
            sky[row][col] = '*';
        }
    }
}

