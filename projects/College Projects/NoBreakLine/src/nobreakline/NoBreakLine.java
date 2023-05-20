package nobreakline;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class NoBreakLine {

    public static void main(String[] args) throws IOException {

        
        File f = new File("work.txt");    
        while (true) {
            String important = JOptionPane.showInputDialog(null, "Enter text!");
            if (important.equals("0")) {
                break;
            }
            important = important.replaceAll("\n", " ");
            BufferedWriter bf = new BufferedWriter(new FileWriter("work.txt"));
            bf.write("");
            bf.append(important);
            bf.close();
            Desktop.getDesktop().open(f);
            
        }
        f.delete();
    }

}
