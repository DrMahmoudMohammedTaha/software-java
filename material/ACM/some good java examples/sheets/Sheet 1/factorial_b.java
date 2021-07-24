//Sheet 1 Problem 2: Factorial b)
public class factorial_b {

    public static void main(String args[]) {
        int i = 1, fact = 1, accuracy = 10;
        double e = 1;
        System.out.print("e = 1");
        while (i <= accuracy) {
            System.out.print(String.format(" + 1/%d!", i));
            fact *= i;
            e += 1.0 / fact;
            i++;
        }
        System.out.println(String.format(" = %f", e));
    }
}

