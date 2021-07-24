/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package higridate;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.HijrahChronology;
import java.time.chrono.HijrahDate;
import java.util.Calendar;
import java.util.Date;

public class Higridate {

    
    public static final String HigriMonth [] = {"محرم","صفر","ربيع اول","ربيع اخر","جمادى اول","جمادى اخر","رجب","شعبان","رمضان","شوال","ذى القعدة","ذى الحجة"};
    public static String getHigriDate() {

        Calendar cl = Calendar.getInstance();
        cl.setTime(new Date());
        HijrahDate islamyDate = HijrahChronology.INSTANCE.date(LocalDate.of(cl.get(Calendar.YEAR), cl.get(Calendar.MONTH) + 1, cl.get(Calendar.DATE)));
        return islamyDate.toString().split(" ")[2];
    }
public static String getSiam()
{

String dayName = new SimpleDateFormat("EEEE").format(new Date());
int dayno = Integer.parseInt(getHigriDate().split("-")[2]);
String message = "استعد للصيام غدا ان شاء الله \n";
if(dayName.equals("Sunday") || dayName.contains("حد")  )
    message += "يوم الاثنين\n";
else if(dayName.equals("Wednesday") || dayName.contains("ربعاء") )
            message += "يوم الخميس\n";
if(dayno == 11 ||dayno == 12 ||dayno == 13 ||dayno == 14 )
    message += "ربما يكون غدا " + (dayno + 1 ) +" او " + (dayno + 2 ) + " "+ HigriMonth[Integer.parseInt(getHigriDate().split("-")[1])-1] ; 
    
if(message.equals("استعد للصيام غدا ان شاء الله \n"))
return "";
else 
return message;
}
    
    
    public static void main(String[] args) {

        System.out.println( getSiam());  
        
    }

}
