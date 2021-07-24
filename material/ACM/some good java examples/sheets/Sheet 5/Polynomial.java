//Sheet 5 Problem 1: Quadratic Equation

public class Polynomial {

    protected double[] a;

    public Polynomial(double[] a) {
        this.a = a;
    }

    public double f(double x) {
        double ret = 0;
        double prod = 1;
        for (int i = 0; i < a.length; i++) {
            ret += a[i] * prod;
            prod *= x;
        }
        return ret;
    }

    @Override
    public String toString() {
        String ret = "";
        boolean first = true;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0 && a.length > 1) {
                continue;
            }
            ret += String.format("%s%.2f%s",
                    a[i] < 0 ? " - " : !first ? " + " : "",
                    Math.abs(a[i]), i > 0 ? String.format("x%s",
                                    i > 1 ? String.format("^%d", i) : "") : "");
            first = false;
        }
        return ret;
    }

    public Polynomial derivative() {
        if (a.length > 1) {
            double[] b = new double[a.length - 1];
            for (int i = 1; i < a.length; i++) {
                b[i - 1] = i * a[i];
            }
            return new Polynomial(b);
        } else {
            return new Polynomial(new double[]{0});
        }
    }

}

