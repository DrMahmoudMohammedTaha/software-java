package Starter;

import java.awt.Desktop;
import java.io.*;

public class Starter {
/*
    public static File start(String name) throws IOException {
        File f = new File(name);
        Desktop.getDesktop().open(f);
        return f;
    }
  
*/
    
    
    public static void main(String[] args) throws Exception {
    
    Desktop.getDesktop().open(new File("E:\\Programming Track\\software projects\\ZEKRA\\ذكرى.exe"));
    System.exit(0);
    }
}
