package training;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Training {
    /*
     public static int fac(int x)
     {
     int num = 1 ;
     if(x == 0)
     return 1;
     else
     for (int i = 1; i <= x ; i++) {
     num *= i;
     }
     return num;
     }
     */

    /*
     double pi = 0 ;
     boolean state = false;
     for (int i = 1; i < 1000000; i += 2) {
     if(state)
     {  pi -=  4/(double) i;
     state = false ;
     }
     else
     { pi += 4 / (double)i;
     state = true;
     }
     System.out.println(pi);
     if(Math.abs(pi - 3.14159 )< 0.000001)
     {System.out.println("pi with "+ i + " terms = "+ pi);
     break;}
     System.out.println("pi with "+ i + " terms = "+ pi);
     }
    
     */
    /*
     public static String encrypt(String s )
     {
     String start = "" ;
     String ss ="" ;
     for (int i = 0; i < s.length(); i++) {
     int y = Integer.parseInt(s.charAt(i)+"");
     y += 7 ;
     y %= 10 ;
     if(i > 1)  
     start += y+"";
     else
     ss += y + "";

     }
     start += ss;
     return start;

     }

     public static String decript(String s)
     {

     String start = "" ;
     String ss ="" ;
     for (int i = 0; i < s.length(); i++) {
     int y = Integer.parseInt(s.charAt(i)+"");
     if(y < 7)
     y += 3;
     else
     y -= 7;
     if(i > 1)  
     start += y+"";
     else
     ss += y + "";

     }
     start += ss;
     return start;


     }
     */
    /*
     public static int fac (int x)
     {
     int sum = 1 ;
     if(x == 0 || x == 1)
     return 1;
     else
     {
     sum *= x *fac(x-1);

     }
     return sum;
     }

     */
    /*
     static int gcd(int m, int n) {
     if (n == 0) {
     return m;
     } else {
     return gcd(n, m % n);
     }
     }
     public static int GCD_r(int n1 , int n2 )
     {
     if(Math.max(n2, n1)% Math.min(n2, n1)==0)
     return Math.min(n2, n1);
     else
     return  GCD_r(n1, n2-1 );
      
     }
     public static int GCD(int n1 , int n2 )
     {
     int mx = Math.max(n2, n1);
     int mn = Math.min(n2, n1);
     int divider = 1;
     for (int i = 2; i <= mn; i++) {
     if(mx % i == 0 && mn % i == 0 && i > divider)
     divider = i ;
                      
     }
      
  
     return divider;
  
     }
     public static int GCD_s(int n1 , int n2 )
     {
     if(n1 > n2)
     return GCD_s(n1-n2, n2);
     else if(n1 < n2)
     return GCD_s(n1, n2-n1);
     else
     return n1;
  
     }
     */
    /*
     public static int intRev(int x)
     {
     String s = "";
     String xtra = x + "";
     for (int i = xtra.length()-1; i >=  0 ; i--) {
     s +=  xtra.charAt(i) ;
     }
     return Integer.parseInt(s);
     }
     public static int intRev_r(int x)
     {   String s = x+ "";
     if(s.length()==0)
     return x;
     else
     return intRev(x/10);
    
     }
     */
  /*
    static String rndStars(int w, float p) {
        String sky = "";
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < w; j++) {
                sky += Math.random() <= p ? '*' : ' ';
            }
            sky += "\n";
        }
        return sky;
    }
    public static String rndStar(int x, double y) {
        String sum = "";
        
        int num = (int) ((double) x * x * y);
        char mat [][] = new char[x][x];
        for (int i = 0; i < num; i++) {
            
            while(true){
            int j = new Random().nextInt(x);
            int k = new Random().nextInt(x);
            if(mat[j][k] != '*')
            {
            mat[j][k] = '*';
            break;
            }
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                sum += mat[i][j];
            }
            sum += "\n";
        }
        return sum;
    }
*/
    /*
    public static void random999()
    {
    boolean rand []= new boolean[999];
    
        for (int i = 0; i < 999; i++) {
            while(true)
            {
            int x = new Random().nextInt(999);
            if(!rand[x])
            {
                System.out.println(x + " " + i);
                rand[x] = true;
                break;
            }
            }
        }
    
    }
    
    */
 //fibonatchi
    /*int n1 = 1;
 int n2 = 1;
 int temp ;
        System.out.print(n1 + " , " + n2);
        for (int i = 2; i < 10; i++) {
            temp = n1 + n2;
            System.out.print( " , "+ temp);    
            n1 = n2 ;
            n2 = temp;
            
            
        }
 */
    
    public static int[] sort_b(int x [])
    {
    
    return x;
    }
    public static int[] sort(int x [])
    {
        for (int i = 0; i < x.length; i++) {
            int min ;
            for (int j = i; j < x.length; j++) {
                if(x[j] < x[i])
                {
                min = x[j];
                x[j] = x[i];
                x[i] = min ;
                }
            }
        }
        
        
    return x;
    }
    public static void bubbleSort(int[] array) {
    boolean swapped = true;
    int j = 0;
    int tmp;
    while (swapped) {
        swapped = false;
        j++;
        for (int i = 0; i < array.length - j; i++) {
            if (array[i] > array[i + 1]) {
                tmp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = tmp;
                swapped = true;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
    public static int Binarysearch(int x [],int y)
    {
    
        int start = 0 , end = x.length , mid = (start + end ) / 2 ;
        while(true)
        {System.out.println("here");
            System.out.println(mid + " " + start +  " " + end );
        if(start >= end)
            return -1;
        else if(x[mid] == y)
            return mid;
        else if (x[mid] > y)
        {end = mid;
        mid = (start + end)/2 ;}
        else
        {
        start = mid;
        mid = (start + end)/2 ;
        }
        if(mid == start || mid == end)
            return -1;
        
        } 
        
        
    }
    
    public static void main(String[] args) {
    int x [] = new int[]{5,4,3,5,3,2,6,7,8,9,6,65,453,43,4};
    bubbleSort(x);
        System.out.println(Arrays.toString(x));
    
    //    System.out.println(Binarysearch(new int[]{1,2,4,5,6,7,8,8,9,11,22,33,44,55,66,77,88}, 3));
  
        System.out.println(Binarysearch(sort(new int[]{2,344,1,4,6,332,5,7,8,854,34,2,56,3,7}),3));
       
        System.out.println();
    }
}
/*
      
 int i = 1, accuracy = 10, x = 3 ;
 double e = 1.0, exp = 1.0, fact = 1.0;
 System.out.print(String.format("e^%d = 1", x));
 while (i <= accuracy) {
 System.out.print(String.format(" + %d^%d/%d!", x, i, i));
 fact *= i;
 exp *= x;
 e += exp / fact;
 i++;
 }
 System.out.println(String.format(" = %.4f", e));
 System.out.println("");
 float accuracy2 = 10 ;
 int x2  = 3 ;
 float exp2 = 0 ;
      
 for (int i2 = 0; i2 <= accuracy2; i2++) {
 exp2 += Math.pow(x2, i2) / (float)fac(i2);
 }
 System.out.println(exp2);

 */
/*

 int x = 11 ;
    
 for (int i = 0; i < x; i++) {
   
 int y = Math.abs(i- x/2);
            
 for (int j = 0; j < y; j++) {
 System.out.print(" ");
 }
 for (int j = 0; j < x-2*y; j++) {
 System.out.print("*");
 }
 System.out.println("");
            
            
 }
    

 */
