package formating;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Formating {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String name[] = {"muslim", "bokhari", "trmzi", "nesaai", "maga", "dawd", "moataa" , "saleh"};
        convert(name[6]);
    }

    private static void convert(String inputS) throws IOException, ClassNotFoundException {
        ArrayList< ArrayList<String>> content = new ArrayList();
        ArrayList <String > star = new ArrayList();
        
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("b_"+inputS + ".txt"));
        content = (ArrayList< ArrayList<String>>) input.readObject();
        input.close();

        for (int i = 0; i < content.size(); i++) {
            for (int j = 0; j < content.get(i).size(); j++) {
                star.add(content.get(i).get(j));
                System.out.println(content.get(i).get(j));
            }
        }
        
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("h_"+inputS + ".txt"));
        output.writeObject(star);
        output.close();

    }

}
