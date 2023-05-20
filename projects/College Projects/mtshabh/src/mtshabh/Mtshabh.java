/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtshabh;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Mtshabh {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader("mtshbh.txt"));
        ArrayList<ArrayList<String>> content = new ArrayList();
        String work;
        content.add(new ArrayList<String>());

        for (;;) {

            if ((work = br.readLine()).equals("xxx")) {
                break;
            }
            if (work.equals("(((((((((")) {
                content.add(new ArrayList<String>());
            } else {
                
                if (work.length() < 15 && work.contains("{")) {
                  String s =  content.get(content.size() - 1).get(content.get(content.size() - 1).size()-1);
                    content.get(content.size() - 1).set(content.get(content.size() - 1).size()-1, s + " " + work);
                 }else if (work.length() > 2) {
                content.get(content.size() - 1).add(work);
                }
              
            }

        }

        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("mtshbh_o.txt"));
        output.writeObject(content);
        output.close();
content.clear();
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("mtshbh_o.txt"));
  content = (ArrayList< ArrayList< String>>) input.readObject();
       int x = 0;    
        for (int i = 0; i < content.size(); i++) {
            for (int j = 0; j < content.get(i).size(); j++) {
                if (content.get(i).get(j).length() < 30 ) {
                    if (j != 0) {
                        System.out.println("error");
                    }
                    x++;
                }
                   
            }
        }
        
        System.out.println(x);
    }

}
