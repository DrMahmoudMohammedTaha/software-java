/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package end;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Aboahmed
 */
public class End {

    public static ArrayList<String> star = new ArrayList();

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("indexer.txt"));
       
        String good = br.readLine();

        while (!"xxx".equals(good)) {
            if (!good.contains("#")) {
                String s[] = good.split(" ");

                for (int i = 0; i < s.length; i++) {

                    if (s[i].startsWith("ال")) {
                     s[i] =    s[i].replaceFirst("ال", "");
                    }
                    if (s[i].length() == 2) {
                        continue;
                    }
                        
                    if (Collections.frequency(star, s[i]) == 0) {
                        star.add(s[i]);
                    }

                }

            }

            good = br.readLine();

        }

        Collections.sort(star);
        for (int i = 0; i < star.size(); i++) {
            System.out.println(star.get(i));
        }
        System.out.println(star.size());
    
    
    BufferedWriter bf = new BufferedWriter(new FileWriter("indexing.txt"));
        bf.write("");
        for (int i = 0; i < star.size(); i++) {
            bf.append(star.get(i));
            bf.newLine();
        }
    bf.close();
    
    }

}
