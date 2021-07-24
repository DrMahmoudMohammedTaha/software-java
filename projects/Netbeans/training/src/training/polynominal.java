
package training;


public class polynominal {

    private int paramater [] ;

    public int[] getParamater() {
        return paramater;
    }
    
    public polynominal(int x[]) {
    paramater = x;
    
    
    }
    
    @Override
    public String toString()
    {String sum="";
        if(paramater.length>1)
        sum += "f(x) = " + paramater[0] + " + " + paramater[1]+" x " ;
        else
            sum += "f(x) = " + paramater[0];
        for (int i = 2; i < paramater.length; i++) {
            sum += " + ";
        sum += paramater[i] + " x ^ " + i ;
         
        }
    return sum;
    }
    
    public String show()
    {
    String sum = "";
        for (int i = 0; i < paramater.length; i++) {
            sum += derivative(i) + "\n";
        }
    
    return sum;
    
    }
    public  int  getValue(int x)
    {
    
    int num = 0;
        for (int i = 0; i <  paramater.length; i++) {
            num += paramater[i] * Math.pow(x, i);
        }
    return num;
    }
    public polynominal derivative (int num)
    {
        polynominal y = null;
    if(num > paramater.length)
        return null;
    else
    {
        int hold []= new int[ paramater.length-num] ;
       int count = 0 ;
        for (int i = num  ; i < paramater.length; i++) {
           hold[count++]= derive(paramater[i], i, num);
        }
     y = new polynominal(hold);
    
    
    }
    return y;
    }

public int derive (int factor ,int degree,int times)
{
for (int i = 0; i < times; i++) {
        factor *= (degree--);
    }
return factor;
}
}
