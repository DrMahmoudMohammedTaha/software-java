//Sheet 1 Problem 2: Factorial c)
public class factorial_c {

    public static void main(String args[]) {
        int i = 1, accuracy = 15, x = 3, times = 0, count;
        double e = 1.0, exp = 1.0, fact = 1.0;
        System.out.print(String.format("e^%d = 1", x));
        while (i <= accuracy) {
            System.out.print(String.format(" + %d^%d/%d!", x, i, i));
            fact *= i;
            exp *= x;
            e += exp / fact;
            i++;
        }
        System.out.println(String.format(" = %.4f", e));
    }
}

