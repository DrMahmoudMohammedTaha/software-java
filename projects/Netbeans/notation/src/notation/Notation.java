/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package notation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Abo Ahmed
 */
public class Notation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("words.docx"));
        System.out.println(br.readLine());
        
     BufferedWriter bw = new BufferedWriter(new FileWriter("words.docx"));
     bw.append("1");
     bw.newLine();
     bw.append("man • æeʊ");
     bw.close();
    
    }
    
}
