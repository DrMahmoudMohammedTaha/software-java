//Sheet 2 Problem 2: GCD b) Euclid Algorithm (division) i. recursion
import java.util.Scanner;

public class gcd_b_i {

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
        if (n == 0) {
            return m;
        } else {
            return gcd(n, m % n);
        }
    }
}

