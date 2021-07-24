//Sheet 2 Problem 2: GCD c) Euclid Algorithm (subtraction)
import java.util.Scanner;

public class gcd_c {

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
        if (m > n) {
            return gcd(m - n, n);
        } else if (m < n) {
            return gcd(m, n - m);
        } else {
            return m;
        }
    }
}

