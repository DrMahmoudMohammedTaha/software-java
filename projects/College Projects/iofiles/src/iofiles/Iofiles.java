package iofiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Iofiles {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
     
        int endInt;
        
        String path;
        System.out.println("Enter the path of the file");
        path = s.nextLine();
        try {
        System.out.println("Enter the key: ");
            endInt = s.nextInt();

        } catch (Exception e) {

            endInt = 10;

        }

        File f = new File(path);

        if (f.exists() && f.isFile()) {

        } else {
            f.createNewFile();
            System.out.println("not Found");
        }

        FileInputStream fileS = new FileInputStream(new File(path));

        FileOutputStream fileI = new FileOutputStream(new File("D:\\texter.txt"));

        
        
        int c;
        while ((c = fileS.read()) != -1) {
            fileI.write(c + endInt);
        }
    }

}
