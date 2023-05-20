package oralexam;

import java.text.DecimalFormat;

public final class discreteRandomVariable extends discrete {

    private int x[];
    private float FX[], FXcommulative[];

    //constructor
    public discreteRandomVariable(int[] x, float[] FX) {
        this.x = x;
        this.FX = FX;
        FXcommulative = new float[FX.length];
        calculatecommulative();
        round(FX);round(FXcommulative);
    }

    public void calculatecommulative() {
        float sum = 0;
        for (int i = 0; i < FX.length; i++) {
            sum += FX[i];
            FXcommulative[i] = sum;
        }

    }
 
    //special methods of the class
    public int getMiddin() {
        float difference = 1;
        int index = 0;
        for (int i = 0; i < FXcommulative.length; i++) {
            if (Math.abs(FXcommulative[i] - .5) < difference) {

                index = i;
                difference = Math.abs(FXcommulative[i] - (float) 1 / 2);
            }
        }

        return x[index];
    }

    public float getMode() {
        int U = 0;
        for (int i = 0; i < FX.length; i++) {
            if (FX[i] > U) {
                U = i;
            }

        }
        return x[U];

    }

    public void setX(int x[]) {
        this.x = x.clone();

    }

    public void seFX(float fx[]) {
        this.FX = fx.clone();
        calculatecommulative();
        round(fx);round(FXcommulative);
    }

    // mehtods for the direct super class
    @Override
    public float calulateEX() {
        float sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += x[i] * FX[i];
        }
        return sum;
    }

    @Override
    public float calulateEX2() {
        float sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += x[i] * x[i] * FX[i];
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
    public String gettResult() {
        if(!valid)
            return "Discrete random variable\nNot valid problem";
        String sum = "Discrete random variable\nX:     ";
        for (int i = 0; i < x.length; i++) {
            sum += new DecimalFormat("0     | ").format(x[i]);
        }
        sum += "\nF(X): ";
        for (int i = 0; i < FX.length; i++) {
            sum += new DecimalFormat(".00000 |").format(FX[i]);
        }
        sum += "\nFcom: ";
        for (int i = 0; i < FX.length; i++) {
            sum += new DecimalFormat(".00000 |").format(FXcommulative[i]);
        }
        sum += "\nExpected value: " + calulateEX() + "\nvariance : " + calulatevarX() + "\nstandard deviation: " + calulatesegmax() + "\nThe Mode: " + getMode() + "\nThe Middin: " + getMiddin();
        return sum;
    }

    @Override
    public boolean checkValid() {
    return  ((Math.abs(FXcommulative[FXcommulative.length-1] - 1 )< 0.1))?true:false ;
    }

}
