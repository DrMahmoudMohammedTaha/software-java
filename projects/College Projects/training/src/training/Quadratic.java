package training;

public class Quadratic extends polynominal {

    public Quadratic(int x1, int x2, int x3) {
        super(new int[]{x1, x2, x3});
    }

    public String solution() {
        int p[] = getParamater();
        double root = p[1] * p[1] - 4 * p[0] * p[2];

        if (root >= 0) {
             return "\n the solution is " + ((-p[1]+root) / 2*p[0]) + " or " + ((-p[1]-root) / 2*p[0]);
        
        } else {
            root = Math.sqrt( -root  );
        return "\n the solution is " + new Complex((-p[1]) / (2 * p[0]) , root/ (2 * p[0])) + " or " + new Complex((-p[1]) / (2*p[0]) ,- root/ (2*p[0]));
        
        }
     
    }


@Override
        public String toString() {
        return super.toString() + solution();
    }

}
