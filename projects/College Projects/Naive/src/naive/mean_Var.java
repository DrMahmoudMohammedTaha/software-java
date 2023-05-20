/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package naive;

/**
 *
 * @author DELL
 */
public class mean_Var {

    float mean;
    float var;
    
    public float getGaussProp(float value) {
        
        float exp = (float) (-.5 * (Math.pow(value - mean, 2.0) / (Math.pow(var, 2.0))));
        float multi = (float) (1 / Math.sqrt(2 * Math.PI * Math.pow(var, 2)));
        return (float) (multi * Math.exp(exp));
    }
}
