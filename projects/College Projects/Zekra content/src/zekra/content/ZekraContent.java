/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zekra.content;

import com.sun.glass.ui.SystemClipboard;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Aboahmed
 */
public class ZekraContent {

    public static void main(String[] args) throws IOException {
    BufferedReader x = new BufferedReader(new FileReader("saleh.txt"));

        String work;
        ArrayList<String> special = new ArrayList();
        work = x.readLine();
        while(!work.equals("xxx"))
        {
             int i = work.indexOf("");
        while(i != -1)
        {
         
       work =   new StringBuffer(work).deleteCharAt(i).toString();
           i = work.indexOf("");
        }
        
        special.add(work);
        work = x.readLine();
        
        }
        for (String string : special) {
            System.out.println(string);
        }
    }
 /*
    BufferedReader x = new BufferedReader(new FileReader("riad.txt"));

        String work;
        ArrayList<Integer> special = new ArrayList();
        ArrayList<Integer> bab = new ArrayList();
        ArrayList<String> babName = new ArrayList();
        ArrayList<String>[] hdith = new ArrayList[78];

        for (int i = 0; i < 78; i++) {
            hdith[i] = new ArrayList();
        }
        int i = -1;
        do {

            work = x.readLine();
            if (work.length() > 4 && (work.charAt(1) == '-' || work.charAt(2) == '-' || work.charAt(3) == '-' || work.charAt(4) == '-' || work.charAt(5) == '-')) {

                if (work.length() > 10 && work.substring(0, 10).contains("باب")) {
                    bab.add(Integer.parseInt(work.split("-")[0].trim()));
                    System.out.println(bab.get(bab.size() - 1));
                    babName.add((work));
                    i++;
                } else {
                    if (work.contains("###")) {

                        work = work.substring(0, work.length() - 3);
                        System.out.println("work" + work);
                        String job;
                        do {
                            job = x.readLine();
                            if (!"###".equals(job)) {
                                work += job;
                            }
                        } while (!"###".equals(job));
                    }
                    special.add(Integer.parseInt(work.split("-")[0].trim()));
                    System.out.println(special.get(special.size() - 1));
                    hdith[i].add("");
                    hdith[i].set(hdith[i].size() - 1, hdith[i].get(hdith[i].size() - 1) + work);

                }

            }

            System.out.println(work);
        } while (!"xxx".equals(work));
        System.out.println(special.size());
        System.out.println(bab.size());
        for (int j = 1; j < special.size(); j++) {
            if (!(special.get(j) == special.get(j - 1) + 1)) {
                System.out.print(special.get(j) + "   ");
            }
        }
        System.out.println("");
        for (int j = 0; j < babName.size(); j++) {
            System.out.println(babName.get(j));
            for (int k = 0; k < hdith[j].size(); k++) {
                System.out.println(hdith[j].get(k));
            }
            System.out.println("###############################");
        }
//        System.out.println(babName.get(77));
        
        BufferedWriter bf = new BufferedWriter(new FileWriter("saleh.txt"));
        for (ArrayList<String> arrayList : hdith) {
            for (String string : arrayList) {
            bf.append(string);
            bf.newLine();
     
            }
        }
        
        bf.close();

    }
*/
}
