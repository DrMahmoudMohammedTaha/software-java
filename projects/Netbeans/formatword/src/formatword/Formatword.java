/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formatword;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Formatword {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        ArrayList<String> content = new ArrayList();
        BufferedReader br = new BufferedReader(new FileReader("words.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("word.txt"));
        int lines = Integer.parseInt(br.readLine());
        bw.write("");
        bw.append(lines + "");
        bw.newLine();
        for (int i = 0; i < lines; i++) {

            String speak = br.readLine();
            bw.append(speak.replace("•", "@"));
            bw.newLine();

        }
    bw.close();
    br.close();
    
    }

}
