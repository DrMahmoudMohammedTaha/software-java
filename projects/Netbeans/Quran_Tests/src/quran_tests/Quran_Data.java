package quran_tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public abstract class Quran_Data {

    static ArrayList<String> name = new ArrayList();
    static ArrayList<String> content = new ArrayList();
    static ArrayList<ArrayList<String>> mtshbh = new ArrayList();

    static int currentName;
    static boolean target = false , target_m = false;

    public static void intial(String path , String path2) throws FileNotFoundException, IOException {

        BufferedReader br = new BufferedReader(new FileReader(path));

        name.add(br.readLine());
        content.add(br.readLine());
        for (int i = 1; i < 114; i++) {
            name.add(br.readLine());
            br.readLine();
            content.add(br.readLine());
        }
        br.close();

        mtshbh.add(new ArrayList<String>());
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(path2));
        try {
            mtshbh = (ArrayList< ArrayList< String>>) input.readObject();
        } catch (ClassNotFoundException ex) {
         
        }
        input.close();
    }
    public static void newMtshbh(JLabel title, JTextArea ask) {
    title.setText("كم مرة تكررت الآية الكريمة");
    currentName = new Random().nextInt(mtshbh.size());
    ask.setText(mtshbh.get(currentName).get(0));
    }
    public static void newQues(JLabel title, JTextArea ask) {
        title.setText("أين توجد هذه الآية الكريمة");
        currentName = new Random().nextInt(114);
        int i = new Random().nextInt(content.get(currentName).length() - 40);
        String keeper = content.get(currentName).substring(i, i + 39);
        while ( keeper.contains("(") || keeper.contains(")")  )
        {
        currentName = new Random().nextInt(114);
        i = new Random().nextInt(content.get(currentName).length() - 40);
        keeper = content.get(currentName).substring(i, i + 39);
        
        }
        ask.setText(keeper);

    }
public static void mtshbhAns(  JLabel num ,  DefaultListModel missions) {

num.setText("تكررت هذه الآية " + (mtshbh.get(currentName).size()-1) );
    for (int i = 1; i < mtshbh.get(currentName).size(); i++) {
        missions.addElement(mtshbh.get(currentName).get(i));
    }
}
    public static void quesAns(JLabel title, JTextArea ask ,JLabel answer , JLabel num ,  DefaultListModel missions) {

        title.setText("هذه الآية توجد فى");
        answer.setText(name.get(currentName));
        ArrayList<String> results = Quran_Data.search(ask.getText());
                    missions.clear();

                    for (String string : results) {
                        missions.addElement(string);
                    }
                    num.setText("عدد السور " + results.size());

    }

    public static ArrayList<String> search(String word) {
        ArrayList<String> results = new ArrayList();
        for (int i = 0; i < 114; i++) {
            if (content.get(i).contains(word)) {
                int index = 1;
               while (true) {
                    if (content.get(i).contains(index + "") && content.get(i).contains((index + 1) + "")) {
                        String holder = content.get(i).substring(content.get(i).indexOf(index + ""), content.get(i).indexOf((index + 1) + ""));
                        if (holder.contains(word.substring(1, word.length() - 1))) {
                            results.add( holder + name.get(i).replace("سورة", "").replace("-", ")")  );
                        }
                        index++;
                    } else {
                        break;
                    }

                }

            }

        }

        return results;
    }


}
