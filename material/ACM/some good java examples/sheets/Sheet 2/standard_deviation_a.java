//Sheet 2 Problem 3: Standard Deviation a)
import java.util.Scanner;

public class standard_deviation_a {

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
        }
        sum1 /= x.length;
        for (int i = 0; i < x.length; i++) {
            sum2 += (x[i] - sum1) * (x[i] - sum1);
        }
        sum2 /= x.length;
        return Math.sqrt(sum2);
    }
}

