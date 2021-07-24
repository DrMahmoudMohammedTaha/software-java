package oralexam;

import java.text.DecimalFormat;

public final class dicreteJointFuction extends discrete {

    int          x[], y[];
    float        fy[], fx[], fxy[][];
public float [] [] round (float f [][])
{
        for (int i = 0; i < f.length; i++) {
            round(f[i]);
    }
    
    return f;


}
    
    public dicreteJointFuction(int[] x, int[] y, float[][] fxy) {
        this.x = x;
        this.y = y;
        this.fxy = round(fxy);
        this.fy = round(calculatefy(fxy));
        this.fx = round(calculatefy(fxy));
        
    
    }

    public float[] calculatefy(float fxy[][]) {
        float fy[] = new float[fxy.length];
        for (int i = 0; i < fxy.length; i++) {
            float sum = 0;
            for (int j = 0; j < fxy.length; j++) {
                sum += fxy[i][j];
            }
            fy[i] = sum;
        }

        return fy;

    }

    public float[] calculatefx(float fxy[][]) {
        float fx[] = new float[fxy.length];
        for (int i = 0; i < fxy.length; i++) {
            float sum = 0;
            for (int j = 0; j < fxy.length; j++) {
                sum += fxy[j][i];
            }
            fx[i] = sum;
        }

        return fx;

    }

    public float caculateEXY() {
        float sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += x[i] * y[i] * fxy[i][i];
        }
        return sum;
    }

    @Override

    public float calulateEX() {
       
        float sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += x[i] * fx[i];
        }
        return sum;
    }

    @Override
    public float calulateEX2() {
        float sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += x[i] * x[i] * fx[i];
        }
        return sum;

    }

    @Override
    public float calulatevarX() {
        return calulateEX2() - calulateEX() * calulateEX();
    }

    @Override
    public float calulatesegmax() {
        return (float) Math.sqrt((double) calulatevarX());
    }

    @Override
    public boolean checkValid() {
        float sum = 0 ,sum2 = 0;
        for (int i = 0; i < fy.length; i++) {
            sum += fy[i];
        }
        
        for (int i = 0; i < fx.length; i++) {
            sum2 += fx[i];
        }
        return  Math.abs(sum-1) < 0.1 && Math.abs(sum2-1) < 0.1;

    }

    public void setX(int x[]) {
        this.x = x;
        
    }

    public void setY(int y[]) {
        this.y = y;
    }

    public void setXY(float fxy[][]) {
        this.fxy = round(fxy);
        this.fy = round(calculatefy(fxy));
        this.fx = round(calculatefy(fxy));

    }

    @Override
    public String gettResult() {
      if(!valid)
        return "Discrete joint function\nNot valid problem";
        
      String sum = "Discrete joint function\nY \\ X |";
        for (int i = 0; i < x.length; i++) {
            sum += new DecimalFormat("      0|").format(x[i]);
        }
        sum += "    fy\n";
        for (int i = 0; i < y.length; i++) {
            sum += y[i] + "     | ";
            for (int j = 0; j < fxy.length ; j++) {
                sum += new DecimalFormat(".00000 |").format(fxy[i][j]);
            }
            sum += fy[i] + "\n";
        }
        sum += "fx    |";
        for (int i = 0; i < fx.length; i++) {
            sum += new DecimalFormat(" .00000 |").format(fx[i]);
        }
        sum += 1;
        sum += "\n";
        sum += "Expected value of X: " + calulateEX() + "\nvariance of X: " + calulatevarX() + "\nstandard deviation of X: " + calulatesegmax() +"\nExpected value of Y:"+ calculateEY()+"\nExpected value of xy :" + caculateEXY();
        return sum;
    }

    private float calculateEY() {
   
       float sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += y[i] * fy[i];
        }
        return sum;
        
        
    }

}
