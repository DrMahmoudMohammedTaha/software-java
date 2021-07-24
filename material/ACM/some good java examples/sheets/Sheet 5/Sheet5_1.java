//Sheet 5 Problem 1: Quadratic Equation

public class Sheet5_1 {

    public static void main(String args[]) {
        Quadratic q1 = new Quadratic(1, 2, 2);
        System.out.println(String.format("f(x) = %s", q1.toString()));
        System.out.println(String.format("f'(x) = %s", q1.derivative().toString()));
        System.out.println(String.format("f''(x) = %s", q1.derivative().derivative().toString()));
        System.out.println(String.format("f'''(x) = %s", q1.derivative().derivative().derivative().toString()));
        System.out.println(String.format("f(x) = 0 @ %s", q1.solution()));
    }
}
