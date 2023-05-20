package removeold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveOld {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        do {
            s += " " + br.readLine();
        } while (!s.contains("xxx"));
        System.out.println(freeTashkeel(s));
    }

    public static String freeTashkeel(String s) {

        StringBuilder sbuild = new StringBuilder(s);

        String x = " ";
        for (int i = 1570; i < 1595; i++) {
            x += ((char) (i)) + "";
        }
        for (int i = 1601; i < 1611; i++) {
            x += ((char) (i)) + "";
        }
        x += (char) (1569);

        for (int i = 0; i < sbuild.length(); i++) {

            if (!x.contains(sbuild.charAt(i) + "")) {
                sbuild.delete(i, i + 1);
            }

        }

        return sbuild.toString();
    }

}
