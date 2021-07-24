//Sheet 3 Problem 1: Integer Reversal a) iteration
import java.util.Scanner;

public class integer_reversal_a {

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
        int y = 0;
        while (x > 0) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        return y;
    }
}

