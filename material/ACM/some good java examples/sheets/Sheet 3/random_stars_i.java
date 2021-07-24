//Sheet 3 Problem 2: Random Stars I
import java.util.Scanner;

public class random_stars_i {

    public static void main(String args[]) {
        int w;
        float p;
        do {
            System.out.print("Enter the square size: ");
            Scanner in = new Scanner(System.in);
            w = in.nextInt();
        } while (w < 0);
        do {
            System.out.print("Enter the stars ratio: ");
            Scanner in = new Scanner(System.in);
            p = in.nextFloat();
        } while (p < 0 || p > 1);
        System.out.println(rndStars(w, p));
    }

    static String rndStars(int w, float p) {
        String sky = "";
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < w; j++) {
                sky += Math.random() <= p ? '*' : ' ';
            }
            sky += "\n";
        }
        return sky;
    }
}

