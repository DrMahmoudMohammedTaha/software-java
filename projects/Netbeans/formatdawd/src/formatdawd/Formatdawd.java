package formatdawd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Formatdawd {

    static ArrayList< ArrayList<String>> star = new ArrayList();
    static ArrayList< ArrayList<String>> content = new ArrayList();

    static int noContent = 0, hdithno = 1, numburStep = 0;
    static String contener = "";

    static int ketabI = 1, babI = 1, hdithI = 1;
    private static int nowValue = -1;

    public static String freeTashkeel(String s) {

        StringBuilder sbuild = new StringBuilder(s);

        String x = " ";
        for (int i = 1570; i < 1595; i++) {
            x += ((char) (i)) + "";
        }
        for (int i = 1601; i < 1611; i++) {
            x += ((char) (i)) + "";

        }
        for (int i = 0; i < sbuild.length(); i++) {

            if (!x.contains(sbuild.charAt(i) + "")) {
                sbuild.delete(i, i + 1);
            }

        }

        return sbuild.toString();
    }

    private static void extractNesaai(String input) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(input + ".txt"));
        br.readLine();
        String s;

        while (true) {
            s = br.readLine();
            if (s.equals("xxx")) {
                break;
            }
            if (!s.contains("/") && !s.isEmpty()) {
                if (s.trim().startsWith("(") && s.trim().endsWith(")")) {
                    if ((s.contains("كتاب") || s.contains("بواب") || s.contains("ذكر")) && s.contains(ketabI + "") && Integer.parseInt(s.trim().split(" ")[1]) == ketabI) {

                        s = s.replaceAll(ketabI + "", "").replaceAll("[(]", "").replaceAll("[)]", "");
                        star.add(new ArrayList<String>());
                        star.get(star.size() - 1).add(">>> " + ketabI + " " + s);

                        ketabI++;
                        if (ketabI != 4 && ketabI != 14 && ketabI != 15 && ketabI != 69) {
                            babI = 1;
                        }
                    } else if (s.contains(babI + "") && Integer.parseInt(s.trim().split(" ")[1]) == babI) {
                        star.get(star.size() - 1).add(babI + " " + s.replaceAll(babI + "", "").replaceAll("[(]", "").replaceAll("[)]", ""));
                        content.add(new ArrayList<String>());
                        nowValue++;

                        babI++;

                    }

                } else if (s.contains("-")) {
                    if (Integer.parseInt(s.split("-")[0].trim()) == hdithI) {
                        content.get(nowValue).add(s);
                        hdithI++;
                    } else if (Integer.parseInt(s.split("-")[0].trim()) == hdithI + 1) {
                        content.get(nowValue).add(hdithI + "لا حديث");
                        hdithI++;
                        content.get(nowValue).add(s);
                        hdithI++;
                    } else if (Integer.parseInt(s.split("-")[0].trim()) == hdithI + 2) {
                        content.get(nowValue).add(hdithI + "لا حديث");
                        hdithI++;
                        content.get(nowValue).add(hdithI + "لا حديث");
                        hdithI++;
                        content.get(nowValue).add(s);
                        hdithI++;
                    } else if (Integer.parseInt(s.split("-")[0].trim()) == hdithI + 3) {
                        content.get(nowValue).add(hdithI + "لا حديث");
                        hdithI++;
                        content.get(nowValue).add(hdithI + "لا حديث");
                        hdithI++;
                        content.get(nowValue).add(hdithI + "لا حديث");
                        hdithI++;
                        content.get(nowValue).add(s);
                        hdithI++;
                    }
                }
            }

        }
        br.close();
    }

    private static void extractMaga(String input) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(input + ".txt"));
        br.readLine();
        String s = "";
        while (true) {
            s = br.readLine();
            if (s.equals("xxx")) {
                break;
            }
            if (!s.contains("/") && !s.isEmpty()) {
                if ((freeTashkeel(s).contains("بواب")) && s.length() < 50) {
                    star.add(new ArrayList<String>());
                    star.get(star.size() - 1).add(">>> " + ketabI + " " + s);
                    ketabI++;
                    if (ketabI != 3) {
                        babI = 1;
                    }
                    //System.out.println(s);
                }
                if (s.matches("\\d+-\\D+")) {
                    if ((Integer.parseInt(s.split("-")[0].trim()) == ketabI) && (freeTashkeel(s).contains("كتاب"))) {
                        star.add(new ArrayList<String>());
                        star.get(star.size() - 1).add(">>> " + ketabI + s.replaceAll(ketabI + "", "").replaceAll("-", ""));
                        ketabI++;
                        babI = 1;
                        //  System.out.println(s);
                    } else if ((Integer.parseInt(s.split("-")[0].trim()) == babI && freeTashkeel(s).contains("باب"))) {
                        s = s.replaceAll("-", "");
                        star.get(star.size() - 1).add(babI + " " + s.replaceAll(babI + "", ""));
                        content.add(new ArrayList<String>());
                        nowValue++;
                        babI++;
                        // System.out.println(s);
                    } else if (Integer.parseInt(s.split("-")[0].trim()) == hdithI) {
                        content.get(nowValue).add(s);
                        hdithI++;

                    }

                }

            }
        }
    }

    private static void extractTrmzi(String input) throws IOException, Exception {

        BufferedReader br = new BufferedReader(new FileReader(input + ".txt"));
        br.readLine();
        String s = "";
        while (true) {
            s = br.readLine();
            if (s.equals("xxx")) {
                break;
            }
            if (!s.contains("/") && !s.isEmpty()) {
                if (s.contains("باب") && s.contains(" " + babI + " ")) {
                    star.get(star.size() - 1).add(babI + " " + s.replaceAll(babI + "", ""));
                    content.add(new ArrayList<String>());
                    nowValue++;

                    babI++;
                } else if (s.matches("\\d+ -\\D+")) {
                    if (Integer.parseInt(s.split("-")[0].trim()) == ketabI && ((s.contains("كتاب") || s.contains("بواب")))) {
                        star.add(new ArrayList<String>());
                        star.get(star.size() - 1).add(">>> " + s.replaceAll("- ", ""));
                        ketabI++;
                        if (ketabI == 7) {
                            babI = 2;
                        } else if (ketabI > 7) {
                            babI = 1;
                        }
                    } else if ((Integer.parseInt(s.split("-")[0].trim()) == babI && s.contains("باب"))) {
                        star.get(star.size() - 1).add(babI + " " + s.replaceAll(babI + "", ""));
                        content.add(new ArrayList<String>());
                        nowValue++;
                        babI++;

                    } else if (Integer.parseInt(s.split("-")[0].trim()) == hdithI) {
                        content.get(nowValue).add(s);
                        hdithI++;
                    }
                }

            }
        }

        br.close();
    }

    public static void extract(String input) throws FileNotFoundException, IOException {

        BufferedReader br = new BufferedReader(new FileReader(input + ".txt"));
        br.readLine();
        String s = "";
        while (true) {
            if (s.equals("xxx")) {
                if (!contener.isEmpty()) {
                    content.get(noContent - 1).add(contener);
                }
                contener = "";
                break;
            }

            s = br.readLine();
            if (s.split("-")[0].trim().matches("\\d+") && Integer.parseInt(s.split("-")[0].trim()) == hdithno && s.length() > 50) {
                // System.out.println(s);
                //System.out.println(noContent - 1 );
                if (!contener.isEmpty()) {
                    content.get(noContent - 1).add(contener);
                }
                hdithno++;
                contener = s;
                // System.out.println(hdithno++);
            } else if (s.contains("(") && s.contains(")") && !s.contains("/") && s.contains("باب")) {

                s = s.replaceAll("[(]\\d+[)]", "");
                star.get(star.size() - 1).add(s.replaceAll("-", ""));
                content.add(new ArrayList<String>());
                if (!contener.isEmpty()) {
                    content.get(noContent - 1).add(contener);
                }
                contener = "";
                noContent++;

                //  System.out.println(s);
            } else if (s.split("-")[0].trim().matches("\\d+") && s.length() < 50) {

                star.add(new ArrayList<String>());
                star.get(star.size() - 1).add(">>> " + s.split("-")[0] + " كتاب " + s.split("-")[1] + ":-");
                //System.out.println("كتاب " + s);
            } else if (!s.contains("(") && !s.contains(")") && !s.trim().isEmpty() && !s.equals("xxx")) {
                contener += "\n" + s;
            }
        }
        br.close();

    }

    public static void save_i(String input) throws IOException {
        BufferedWriter bf = new BufferedWriter(new FileWriter(input + ".txt"));
        bf.write("");
        for (int i = 0; i < star.size(); i++) {
            for (int j = 0; j < star.get(i).size(); j++) {
                bf.append(star.get(i).get(j));
                bf.newLine();
            }
            bf.append("-----------------");
            bf.newLine();
        }
        bf.close();
    }

    public static void save_i_b(String input) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(input + ".txt"));
        output.writeObject(star);
        output.close();

    }

    public static void save_b(String input) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(input + ".txt"));
        output.writeObject(content);
        output.close();

    }

    public static void save_d_muslim(String input) throws IOException {
        BufferedWriter bf = new BufferedWriter(new FileWriter(input + ".txt"));
        bf.write("");
        for (int i = 0; i < star.size(); i++) {
            bf.append(star.get(i).get(0));
            bf.newLine();

            for (int k = 0; k < content.get(numburStep).size(); k++) {
                bf.append(content.get(numburStep).get(k));
                bf.newLine();
            }
            numburStep++;
            bf.append("-----------------");
            bf.newLine();
        }

        bf.close();

    }

    public static void save_d(String input) throws IOException {
        BufferedWriter bf = new BufferedWriter(new FileWriter(input + ".txt"));
        bf.write("");
        for (int i = 0; i < star.size(); i++) {
            bf.append(star.get(i).get(0));
            bf.newLine();
            for (int j = 1; j < star.get(i).size(); j++) {

                bf.append(star.get(i).get(j));
                bf.newLine();

                for (int k = 0; k < content.get(numburStep).size(); k++) {
                    bf.append(content.get(numburStep).get(k));
                    bf.newLine();
                }

                numburStep++;
                bf.append("-----------------");
                bf.newLine();
            }
        }

        bf.close();
    }

    public static void main(String[] args) throws IOException, Exception {

        for (int i = 1; i <= 3; i++) {
            extractBokhari("bokhari " + i);

        }
        save_d("bokhari");
        save_i("i_bokhari");
        save_b("b_bokhari");
        save_i_b("i_b_bokhari");

    }

    private static void extractBokhari(String input) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(input + ".txt"));
        br.readLine();
        String s = "";
        while (true) {
            s = br.readLine();
            if (s.trim().equals("xxx")) {
                break;
            }
            if ((s.contains("كتاب") || s.contains("بواب")) && s.contains("-") && s.contains(ketabI + " ")) {
                // System.out.println(">>> " + s.split("-")[0].replaceAll("بسم الله الرحمن الرحيم", "") + " " + s.split("-")[1]);
                star.add(new ArrayList<String>());
                star.get(star.size() - 1).add(">>> " + s.split("-")[0].replaceAll("بسم الله الرحمن الرحيم", "") + " " + s.split("-")[1]);

                ketabI++;
                babI = 1;
            } else if (s.contains("باب") && !s.contains("حَدَّثَ") && s.contains("-")) {

                star.get(star.size() - 1).add(babI + " " + s.trim().replaceAll("\\d+", "").replaceAll("-", "").replaceAll("\\(", "").split("\\)")[0]);
                babI++;
                content.add(new ArrayList<String>());
                nowValue++;

                //System.out.println(s);
            } else if (s.contains("-")) {

                if (s.contains(" " + hdithI + " ")) {

                    content.get(nowValue).add(hdithI + s.replaceAll("\\d+", "").replaceAll("،  ،  ", ""));
                    hdithI++;
                    //   System.out.println(s.replaceAll("\\d+", "").replaceAll(" ، ", ""));
                    // System.out.println("#######################" + hdithI);
                } else if (s.contains(" " + (hdithI + 1) + " ")) {
                    //System.out.println("#######################" + hdithI++);
                    //System.out.println(s.replaceAll("\\d+", "").replaceAll(" ، ", ""));

                    //System.out.println("#######################" + hdithI);
                    content.get(nowValue).add(hdithI + "لا حديث");
                    hdithI++;
                    content.get(nowValue).add(hdithI + s.replaceAll("\\d+", "").replaceAll("،  ،  ", ""));
                    hdithI++;

                }
            } else if(hdithI > 1 && !content.get(content.size() - 1).isEmpty()){
                String hold = content.get(content.size() - 1).get(content.get(content.size() - 1).size() - 1);

                content.get(content.size() - 1).set(content.get(content.size() - 1).size() - 1, hold + "\n" + s.replaceAll("\\d+", "").replaceAll("،  ،  ", ""));

            }

        }

    }

    private static void extractMuslim(String input) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(input + ".txt"));
        br.readLine();
        String s = "";
        while (true) {
            s = br.readLine();
            if (s.equals("xxx")) {
                break;
            }
            if (!s.contains("/") && !s.isEmpty()) {
                if (s.contains("كتاب") && s.contains("-") && s.contains(ketabI + " ") && s.length() < 50) {
                    star.add(new ArrayList<String>());
                    star.get(star.size() - 1).add(">>> " + s.replaceAll("- ", ""));
                    content.add(new ArrayList<String>());
                    nowValue++;
                    ketabI++;
                    babI = 1;
                    hdithI = 1;

                } else if (s.contains("باب") && s.contains("-") && s.contains(babI + " ") && !s.contains(" " + babI) && !s.contains("(")) {
                    star.get(star.size() - 1).add(babI + " " + s.replaceAll(babI + "", "").replaceAll("-", ""));

                    babI++;
                } else if (s.contains("-") && s.split("-")[0].trim().equals(hdithI + "") && s.contains(")")) {
                    content.get(nowValue).add(s);
                    hdithI++;
                    hdithno++;
                } else {
                    if (ketabI > 1 && hdithI > 1) {
                        String hold = content.get(content.size() - 1).get(content.get(content.size() - 1).size() - 1);
                        hold = hold.replaceAll("/", "");
                        content.get(content.size() - 1).set(content.get(content.size() - 1).size() - 1, hold + "\n" + s);
                    }
                }

            }

        }
        br.close();
    }

}
