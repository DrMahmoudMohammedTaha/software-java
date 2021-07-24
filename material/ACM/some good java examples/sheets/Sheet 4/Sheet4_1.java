//Sheet 4 Problem 1: Complex
public class Sheet4_1 {

    public static void main(String args[]) {
        Complex left, right;
        left = new Complex(9.5, 7.7);
        right = new Complex(1.2, 3.1);
        String result = "left = " + left.toComplexString();
        result += "\nright = " + right.toComplexString();
        result += "\nleft + right = " + left.add(right).toComplexString();
        result += "\nleft - right = " + left.subtract(right).toComplexString();
        System.out.println(result);
    }
}
