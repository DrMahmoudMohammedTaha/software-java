//Sheet 2 Problem 2: GCD b) Euclid Algorithm (division) ii. iteration
import java.util.Scanner;

public class gcd_b_ii {

    public static void main(String args[]) {
        int m, n;
        do {
            System.out.print("Enter a nonnegative integer: ");
            Scanner in = new Scanner(System.in);
            m = in.nextInt();
        } while (m < 0);
        do {
            System.out.print("Enter another nonnegative integer: ");
            Scanner in = new Scanner(System.in);
            n = in.nextInt();
        } while (n < 0);
        System.out.println(String.format("GCD(%d,%d) = %d", m, n, gcd(m, n)));
    }

    static int gcd(int m, int n) {
        while (n != 0) {
            int temp = m;
            m = n;
            n = temp % n;
        }
        return m;
    }
}

