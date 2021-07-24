package filing;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class Filing {

    static ArrayList< ArrayList<String>> star = new ArrayList();
    static ArrayList< ArrayList<String>> content = new ArrayList();
    static int profileNum = 0 , contentNum = 0 ;

    public static void main(String[] args) throws FileNotFoundException, IOException {

        //to change messege font size
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Andalus", Font.BOLD, 15)));

        
        BufferedReader  br = new BufferedReader(new FileReader("moataa 1.txt"));
        br.readLine();
        String s = "";
        while (true) {
            s = br.readLine();
            if (s.equals("xxx")) {
                break;
            }
            if (s.contains("(") && s.contains(")") && !s.contains("/")) {
                s = s.trim().substring(1, s.length() - 2);
                String num = s.split(" ")[0];

                if (s.replaceFirst("\\d+", "").trim().startsWith("كتاب")) {
                    star.add(new ArrayList<String>());
                    star.get(profileNum++).add( ">>> " + num  + s + " :-");
                } else {
                    star.get(profileNum - 1).add(s);
                    content.add(new ArrayList<String >());
                    contentNum++;
                }
            }else if(!(s.contains("(") && s.contains(")")) &&  !s.trim().isEmpty())
            {
            content.get(contentNum - 1 ).add(s);
            }
        }
       
        br = new BufferedReader(new FileReader("moataa 2.txt"));
        br.readLine();
        s = "";
        while (true) {
            s = br.readLine();
            if (s.equals("xxx")) {
                break;
            }
            if (s.contains("(") && s.contains(")") && !s.contains("/")) {
                s = s.trim().substring(1, s.length() - 2);
                String num = s.split(" ")[0];

                if (s.replaceFirst("\\d+", "").trim().startsWith("كتاب")) {
                    star.add(new ArrayList<String>());
                    star.get(profileNum++).add( ">>> " + num  + s + " :-");
                } else {
                    star.get(profileNum - 1).add(s);
                    content.add(new ArrayList<String >());
                    contentNum++;
                }
            }else if(!(s.contains("(") && s.contains(")")) && !s.trim().isEmpty())
            {
            content.get(contentNum - 1 ).add(s);
            }
        }
        br.close();
/*
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter("moataa.txt"));
            bf.write("");
            int contenter = 0 ;
            for (int i = 0; i < star.size(); i++) {
                
               bf.append(star.get(i).get(0));
               bf.newLine();
                for (int j = 1; j < star.get(i).size(); j++) {
                    bf.append(star.get(i).get(j));
                    bf.newLine();
                    for (int k = 0; k <content.get(contenter).size() ; k++) {
                        bf.append(content.get(contenter).get(k));
                        bf.newLine();
                    }
                    bf.append("-----------------");
                    bf.newLine();
                    contenter++;
//              bf.newLine();
        //            bf.append(star.get(i).get(j));
                }
          //      bf.newLine();
           }
        
        }
        catch(Exception e)
        {}
    */
    	ObjectOutputStream  output = new ObjectOutputStream( new FileOutputStream("b_moataa.txt"));
	output.writeObject(content);
	output.close();

        output = new ObjectOutputStream( new FileOutputStream("i_b_moataa.txt"));
	output.writeObject(star);
	output.close();
    }

}
