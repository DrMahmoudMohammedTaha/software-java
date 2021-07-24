//Sheet 2 Problem 2: GCD a) Brute Force
import java.util.Scanner;

public class gcd_a {

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
        for (int i = Math.min(m, n); i >= 1; i--) {
            if (m % i == 0 && n % i == 0) {
                return i;
            }
        }
        return 1;
    }
}

