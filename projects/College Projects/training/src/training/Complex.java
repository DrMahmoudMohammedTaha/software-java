
package training;




public class Complex {
    
    private double real , complx;

    public Complex() {
    }

    public Complex(double real, double complx) {
        this.real = real;
        this.complx = complx;
    }

    public void setComplx(double complx) {
        this.complx = complx;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getComplx() {
        return complx;
    }

    public double getReal() {
        return real;
    }
    
    public static Complex add(Complex n1 , Complex n2)
    {
    n1.real += n2.real;
    n1.complx += n2.complx;
    return n1;
    }
    public static Complex sub(Complex n1 , Complex n2)
    {
    n1.real -= n2.real;
    n1.complx -= n2.complx;
    return n1;
    }
    
    public static Complex mult(Complex n1 , Complex n2)
    {
    double num1 = n1.real * n2.real - n1.complx * n2.complx;
    double num2 = n1.real * n2.complx + n1.complx * n2.real;
    return new Complex(num1, num2);
    }
    public static Complex con(Complex n)
    {
    n.complx = -n.complx;
    return n;
    }
    public static double modulus (Complex n)
    {
    return Math.sqrt(n.real * n.real + n.complx * n.complx);
        
        
    }
    public static Complex div (Complex n1 , Complex n2)
    {
    
    n1 = mult(n1, con(n2));
    n2 = mult(n2, con(n2));;
    n1.real /= n2.real;
    n1.complx /= n2.real;
    return n1;
    }    

    @Override
    public  String toString()
{


return this.real +" + "+ this.complx +" j ";
}


}
