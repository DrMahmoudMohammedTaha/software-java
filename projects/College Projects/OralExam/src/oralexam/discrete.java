
package oralexam;

import java.text.DecimalFormat;



public abstract  class discrete {

    public boolean valid ;
    public abstract float calulateEX();
    public abstract float calulateEX2();
    public abstract float calulatevarX();
    public abstract float calulatesegmax();
    public abstract String gettResult();
    public abstract boolean checkValid();
    
    public float[] round(float f[]) {
        for (int i = 0; i < f.length; i++) {

            f[i] = Float.parseFloat(new DecimalFormat("0.00000").format(new Float(f[i])));

        }

        return f;
    }

    
}
