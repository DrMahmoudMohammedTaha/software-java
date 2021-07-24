//Sheet 4 Problem 1: Complex
public class Complex {

    private double real;
    private double imaginary;

    public Complex() {
        this(0.0, 0.0);
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex add(Complex right) {
        return new Complex(real + right.real,
                imaginary + right.imaginary);
    }

    public Complex subtract(Complex right) {
        return new Complex(real - right.real,
                imaginary - right.imaginary);
    }

    public String toComplexString() {
        return "(" + real + ", " + imaginary + ")";
    }
}
