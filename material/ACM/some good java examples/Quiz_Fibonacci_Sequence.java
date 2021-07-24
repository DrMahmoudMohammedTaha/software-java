import java.util.Scanner;

public class Quiz_Fibonacci_Sequence {

    public static void main(String args[]) {
        // Declaration
        int n, i, f1, f2;
        String ret;
        // Initialize The Buffers
        f1 = 1;
        f2 = 1;
        // Read The Number of Terms
        System.out.print("How many terms? ");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        // Initialize The Series
        ret = "Fibonacci(1:" + n + ") = ";
        for (i = 1; i <= n; i += 1) {
            // Update The Series
            ret = ret + f1 + ", ";
            // Update The Buffers
            f2 = f1 + f2;
            f1 = f2 - f1;
        }
        // Display The Series
        System.out.println(ret);
    }
}

