


package database_console;


public class condition {

    public String col;
    public String sign;
    public String value;

    public condition(String col, String sign, String value) {
        this.col = col;
        this.value = value;
        if( ">".equals(sign) || "<".equals(sign) ||"=".equals(sign) ||">=".equals(sign) ||"<=".equals(sign) )
        this.sign = sign;
        else 
        this.sign = "="; 
               
    }
    
    
    
    @Override
    public String toString() {
        return  this.col + " " + this.sign + " " + this.value ;
    }
    
}
