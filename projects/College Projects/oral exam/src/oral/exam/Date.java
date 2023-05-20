
package oral.exam;

public class Date {
private int year , month , day ;

    
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
   
    public String getDate ()
    {
    return year + " // " + month + " // " + day + " // "  ;
    
    }
           
}
