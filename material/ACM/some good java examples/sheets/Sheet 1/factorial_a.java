//Sheet 1 Problem 2: Factorial a)
import java.util.Scanner;

public class factorial_a {

    public static void main(String args[]) {
        int number, factorial = 1;
        do {
            System.out.print("Enter a positive integer: ");
            Scanner in = new Scanner(System.in);
            number = in.nextInt();
        } while (number < 0);
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        System.out.println(String.format("%d! is %d", number, factorial));
    }
}

