//Sheet 5 Problem 1: Quadratic Equation

public class Complex {

    private double r;
    private double i;

    public Complex() {
        this(0.0, 0.0);
    }

    public Complex(double r, double i) {
        this.r = r;
        this.i = i;
    }

    @Override
    public String toString() {
        return String.format("%.2f%s%.2fi", r, i > 0 ? " + " : " - ", Math.abs(i));
    }
}
