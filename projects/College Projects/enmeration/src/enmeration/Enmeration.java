
package enmeration;

import java.io.IOException;


public class Enmeration {

enum working 
{
day(3,2),week(4,4) , play(11,111);

private int x ;
private int y ;

        private working(int x, int y) {
            this.x = x;
            this.y = y;
        }

}

enum work 
{

day,week, play;


}
    public static void main(String[] args) {
    
//running anther program
        final ProcessBuilder pb = new ProcessBuilder("java.exe","E:\\Programming Track\\software projects\\Phonetics Exams\\Phonetics Exam.exe");
        try {
            final Process p = pb.start();
        } catch (final IOException ex) {
            System.out.println("OK");
        }

//end of multi-threading
        
        
        working i = working.day;
        System.out.println(i);
        System.out.println("working...");
    while(true)
    {}
    }
    
}
