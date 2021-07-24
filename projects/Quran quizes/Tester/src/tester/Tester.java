package tester;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class Tester {
    public  static  String decode (String h)
{
    ArrayList <String>  letter = new ArrayList ();
    char c =0;
    letter.add("");
    
for(int i = 0 ; i < h.length() ; i++)
{
    h= h.trim();
if (h.charAt(i)=='+' && i != h.length()-1)
{
   c++; 
   letter.add("");
   continue;
   }
if(i == h.length()-1)
    break;
letter.set(c, letter.get(c)+h.charAt(i));
}
h=" ";
for (int i = 0 ; i < letter.size() ; i++)
{
h+= (char)(Integer.parseInt(letter.get(i)));
}
return h ;
}

    public static void main(String[] args) throws FileNotFoundException, IOException {
       ArrayList <String> name = new ArrayList ();
       ArrayList<String> content = new ArrayList ();
           BufferedReader br = new BufferedReader( new FileReader("tob.txt"));
      String h ="";
   while(br.ready())
 h+=br.readLine()+"\n";
   h=h.trim();
    String [] holder = h.split("@");
        
    for (int i = 0; i < holder.length; i++) 
        {   StringTokenizer token = new StringTokenizer(holder[i]);
        name.add(decode(token.nextToken())+decode(token.nextToken()));
        String [] internal = token.nextToken().split("&");
            content.add("");
            for (int j = 2; j < internal.length; j++) 
            {
                content.set(i,content.get(i)+decode(internal[j]));
            }
            
        }
 /*
    for (int i = 0; i < name.size(); i++) 
        {
            System.out.println(name.get(i));
            System.out.println(content.get(i));
        }
  */
    UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("WinSoft Thuluth", Font.BOLD, 20) ) );
    
  
  
  
      int index , count=0 , k ,score =  0;
  while(true)
  {
  index = (int) (Math.random()*(name.size()));
  count = (int) (Math.random()*(content.get(index).length()-40));
  JOptionPane.showMessageDialog(null, "اين توجد هذه الايات ؟\n"+content.get(index).substring(count, count+39),"السلام عليكم و رحمة الله  وبركاته", JOptionPane.INFORMATION_MESSAGE);
  k=JOptionPane.showConfirmDialog(null, "هذه الايات توجد فى سورة\n"+name.get(index));
  if(k==2)
  break;
  }
  System.exit(0);    
    }



}