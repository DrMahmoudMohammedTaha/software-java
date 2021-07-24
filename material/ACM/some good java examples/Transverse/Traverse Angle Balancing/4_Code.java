
import java.util.Scanner;

public class Traverse {

    public static void main(String args[]) {
        // Declarations
        double a[];
        int n, i;
        double tsum, sum, error, correction;

        // Reading traverse size
        n = getTraverseSize();
        a = new double[n];

        // Reading angles values
        readAngles(a, n);

        // Calculating angles sum
        sum = getSum(a, n);

        // Calculating correction
        tsum = 180 * (n - 2);
        error = sum - tsum;
        correction = error / n;

        // Correcting angles
        correct(a, n, correction);
        // Printing corrected angles
        System.out.println("Error = " + error);
        System.out.println("Correction = " + correction);
        System.out.println("Corrected angles:");
        print(a, n);
    }

    private static int getTraverseSize() {
        Scanner s = new Scanner(System.in);
        int n;
        do {
            System.out.print("How many angles [3+]? ");
            n = s.nextInt();
            if (n < 3) {
                System.out.println("Too few angles!");
            }
        } while (n < 3);
        return n;
    }

    private static void readAngles(double[] a, int n) {
        Scanner s = new Scanner(System.in);
        System.out.println(String.format("Enter %d angles:", n));

        for (int i = 0; i <= n - 1; i += 1) {
            do {
                System.out.print(String.format("Angle %d (0,360): ", i + 1));
                a[i] = s.nextDouble();
                if (a[i] <= 0 || a[i] >= 360) {
                    System.out.println("Out of range!");
                }
            } while (a[i] <= 0 || a[i] >= 360);
        }
    }

    private static double getSum(double[] a, int n) {
        double sum = 0;
        for (int i = 0; i <= n - 1; i += 1) {
            sum = sum + a[i];
        }
        return sum;
    }

    private static void correct(double[] a, int n, double correction) {
        for (int i = 0; i <= n - 1; i += 1) {
            a[i] = a[i] - correction;
        }
    }

    private static void print(double[] a, int n) {
        for (int i = 0; i <= n - 1; i += 1) {
            System.out.println(a[i]);
        }
    }
}

