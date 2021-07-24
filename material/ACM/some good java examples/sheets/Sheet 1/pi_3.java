//Sheet 1 Problem 3: Pi
public class pi_3 {

    public static void main(String args[]) {
        double pi = 0.0, num = 4.0, denom = 1.0;
        long accuracy = 1000000;
        // set decimal accuracy
        System.out.println(String.format("Accuracy set at: %d", accuracy));
        System.out.println(String.format("term\t\tpi"));
        for (long i = 1; i <= accuracy; ++i) {
            pi += num / denom;
            System.out.println(String.format("%d\t\t%.8f", i, pi));
            num *= -1;
            denom += 2.0;
        }
        System.out.println();
    }
}

