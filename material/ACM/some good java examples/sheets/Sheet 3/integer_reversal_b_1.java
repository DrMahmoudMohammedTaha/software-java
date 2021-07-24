//Sheet 3 Problem 1: Integer Reversal b) recursion
import java.util.Scanner;

public class integer_reversal_b {

    public static void main(String args[]) {
        int x;
        do {
            System.out.print("Enter a nonnegative integer: ");
            Scanner in = new Scanner(System.in);
            x = in.nextInt();
        } while (x < 0);
        System.out.println(String.format("intRev(%d) =  %d", x, intRev(x)));
    }

    static int intRev(int x) {
        if (x == 0) //Base Case
        {
            return 0;
        } else {
            int n = 1;
            while (n <= x) {
                n *= 10;
            }
            n /= 10;
            return intRev(x, n);
        }
    }

    static int intRev(int x, int n) {
        if (n == 1) {
            return x;
        } else {
            return intRev(x % n, n / 10) * 10 + x / n;
        }
    }
}

