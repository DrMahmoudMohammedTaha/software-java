//Sheet 2 Problem 3: Standard Deviation b)
import java.util.Scanner;

public class standard_deviation_b {

    public static void main(String args[]) {
        final int N = 10;
        double[] x = new double[N];
        for (int i = 0; i < N; i++) {
            System.out.print("Enter a real number: ");
            Scanner in = new Scanner(System.in);
            x[i] = in.nextDouble();
        }
        System.out.println(String.format("sigma =  %f", sigma(x)));
    }

    static double sigma(double x[]) {
        double sum1 = 0, sum2 = 0;
        for (int i = 0; i < x.length; i++) {
            sum1 += x[i];
            sum2 += x[i] * x[i];
        }
        sum1 /= x.length;
        sum2 /= x.length;
        return Math.sqrt(sum2 - sum1 * sum1);
    }
}

