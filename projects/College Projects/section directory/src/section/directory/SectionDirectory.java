/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package section.directory;

import java.io.File;

/**
 File f = new File(directoryName);
        String files[] = f.list();
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);

        }
        
        */
public class SectionDirectory {

    public static String directoryName = "D:\\";

    public static void main(String[] args) {
         File f = new File(directoryName + "texter.txt");
    f.renameTo(new File("E:\\" + "worker.txt"));
    }

}
