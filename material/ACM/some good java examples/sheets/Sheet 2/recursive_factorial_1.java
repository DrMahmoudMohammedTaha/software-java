//Sheet 2 Problem 1: Recursive Factorial
import java.util.Scanner;

public class recursive_factorial_1 {

    public static void main(String args[]) {
        int n;
        do {
            System.out.print("Enter a nonnegative integer: ");
            Scanner in = new Scanner(System.in);
            n = in.nextInt();
        } while (n < 0);
        System.out.println(String.format("%d! is %d", n, fact(n)));
    }

    static int fact(int n) {
        if (n == 0) //Base Case
        {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }
}

