/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author DELL
 */
public class Pdf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        BufferedReader br = new BufferedReader(new FileReader("1.pdf"));
        String s = "";
        String temp = "";
        while (temp != null) {

            s += temp;
            temp = br.readLine();

        }
        br.close();
        System.out.println(temp);
        
        

    }

}
