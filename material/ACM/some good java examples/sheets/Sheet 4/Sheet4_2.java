//Sheet 4 Problem 2: Polynomial
public class Sheet4_2 {

    public static void main(String args[]) {
        Polynomial p1 = new Polynomial(new double[]{1, 0, -2, 3});
        System.out.println(String.format("f(x) = %s", p1.toString()));
        System.out.println(String.format("f'(x) = %s", p1.derivative().toString()));
        System.out.println(String.format("f''(x) = %s", p1.derivative().derivative().toString()));
        System.out.println(String.format("f'''(x) = %s", p1.derivative().derivative().derivative().toString()));
        double x = 1;
        System.out.println(String.format("f(%.2f) = %s", x, p1.f(x)));
    }
}

