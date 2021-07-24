//Sheet 5 Problem 1: Quadratic Equation

public class Quadratic extends Polynomial {

    public Quadratic(double a0, double a1, double a2) {
        super(new double[]{a0, a1, a2});
    }

    public Root[] roots() {
        Root[] ret;
        double d = a[1] * a[1] - 4 * a[0] * a[2];
        if (d > 0) {
            ret = new Root[]{
                new RealRoot((-a[1] + Math.sqrt(d)) / (2 * a[0])),
                new RealRoot((-a[1] - Math.sqrt(d)) / (2 * a[0]))};
        } else if (d < 0) {
            ret = new Root[]{
                new ComplexRoot(-a[1] / (2 * a[0]), Math.sqrt(-d) / (2 * a[0])),
                new ComplexRoot(-a[1] / (2 * a[0]), -Math.sqrt(-d) / (2 * a[0]))};
        } else {
            ret = new Root[]{
                new RealRoot(-a[1] / (2 * a[0]))};
        }
        return ret;
    }

    public String solution() {
        Root r[] = roots();
        switch (r.length) {
            case 1:
                return String.format("x1,2 = %s", r[0].toString());
            case 2:
                return String.format("x1 = %s, x2 = %s", r[0].toString(), r[1].toString());
            default:
                return "Error!";
        }
    }
}
