//Sheet 5 Problem 1: Quadratic Equation

public class RealRoot implements Root {

    private final double r;

    public RealRoot(double r) {
        this.r = r;
    }

    @Override
    public String toString() {
        return String.format("%.2f", r);
    }
}
