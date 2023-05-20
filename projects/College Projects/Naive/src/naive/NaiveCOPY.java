package naive;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author DELL
 */
public class NaiveCOPY {

    /**
     * Naive bayes implementation with JAVA
     */
    static ArrayList<ArrayList<Float>> Data = new ArrayList();
    static String attributes[];
    private static String[] labels;
    public static mean_Var meansVar[][];
    public static float labelsPro[];
    public static int comapreMatrix[][];
    public static int TestResult[];

    public static void maine(String[] args) {

        readData();
        showIntro();
        NaiveBayes();
        TestOnSamples();
        showTestResult();
        checkNaive();

    }

    private static void readData() {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }

        attributes = new String[10];
        String temp[] = new String[]{"RI: refractive index ", "Na: Sodium ", " Mg: Magnesium ", "Al: Aluminum ", "Si: Silicon", " K: Potassium ", "Ca: Calcium", " Ba: Barium ", "Fe: Iron"};
        for (int i = 0; i < temp.length; i++) {
            attributes[i] = temp[i].trim();
        }

        attributes[9] = "glass class";

        labels = new String[7];
        temp = new String[]{"building_windows_float_processed", "building_windows_non_float_processed", "vehicle_windows_float_processed", "vehicle_windows_non_float_processed", "containers", "tableware", "headlamps"};
        for (int i = 0; i < temp.length; i++) {
            labels[i] = temp[i].trim();
        }

        try {
            readDataFile();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading data file!");
        }

    }

    private static void readDataFile() throws IOException {
        File file;
        JFileChooser fileChooser = new JFileChooser(new File("Data File"));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        while (true) {

            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile(); // get File
                if (file.getName().endsWith(".data") || file.getName().endsWith(".txt")) {
                    {

                        fillData(file);
                        break;
                    }

                }
            }
        }

    }

    private static void fillData(File file) throws FileNotFoundException, IOException {

        BufferedReader br = new BufferedReader(new FileReader(file));
        String tmpS = br.readLine();

        int counter = 0;
        while (!tmpS.equals("xxx")) {
            String temp[] = tmpS.split(",");
            Data.add(new ArrayList<Float>());
            for (int i = 1; i < temp.length; i++) {
                Data.get(counter).add(Float.parseFloat(temp[i].trim()));
            }
            counter++;
            tmpS = br.readLine();

        }
    }

    private static void showIntro() {

        String show = "we have " + (attributes.length - 1) + " attributes";
        show += "\nwe have " + labels.length + " classes of Label";
        show += "\nwe have " + Data.size() + " instances";
        JOptionPane.showMessageDialog(null, show);

    }

    private static void NaiveBayes() {

        calculateLabelPro();
        calculateMeans();
        calcuateVars();
    }

    private static void calculateMeans() {

        System.out.println("Menas table");
        System.out.println("---------------------------------------------");
        meansVar = new mean_Var[attributes.length - 1][labels.length];
        float tempMeans[] = new float[labels.length];

        for (int i = 0; i < attributes.length - 1; i++) {
            for (int k = 0; k < Data.size(); k++) {
                int index = (Data.get(k).get(attributes.length - 1).intValue()) - 1;
                float value = Data.get(k).get(i);
                tempMeans[index] += value;
            }
            System.out.print(attributes[i].split(" ")[0] + "    ");
            for (int j = 0; j < tempMeans.length; j++) {
                meansVar[i][j] = new mean_Var();
                meansVar[i][j].mean = (float) (tempMeans[j] / labelsPro[j]);
                System.out.print(meansVar[i][j].mean + "         ");
            }

            for (int j = 0; j < tempMeans.length; j++) {
                tempMeans[j] = 0;
            }
            System.out.println("");
        }

    }

    private static void calculateLabelPro() {

        labelsPro = new float[labels.length];

        for (int i = 0; i < Data.size(); i++) {
            int temp = Data.get(i).get(Data.get(i).size() - 1).intValue();
            labelsPro[temp - 1]++;

        }

        for (int i = 0; i < labels.length; i++) {
            System.out.print(" " + labels[i]);
        }
        System.out.println("");

        System.out.println("priories");
        System.out.println("--------------------------");
        System.out.print("p:  ");
        for (int i = 0; i < labelsPro.length; i++) {
            System.out.print("      " + labelsPro[i]);
        }
        System.out.println("");
    }

    private static void calcuateVars() {

        System.out.println("");
        System.out.println("");
        System.out.println("Vars table");
        System.out.println("---------------------------------------------");

        float[] tempvars = new float[labels.length];

        for (int i = 0; i < attributes.length - 1; i++) {
            for (int k = 0; k < Data.size(); k++) {
                int index = (Data.get(k).get(attributes.length - 1).intValue()) - 1;
                float value = Data.get(k).get(i);
                tempvars[index] += Math.sqrt(Math.abs(value - meansVar[i][index].mean));

            }

            System.out.print(attributes[i].split(" ")[0] + "    ");
            for (int j = 0; j < tempvars.length; j++) {

                meansVar[i][j].var = (float) (tempvars[j] / labelsPro[j]);
                System.out.print(meansVar[i][j].var + "         ");
            }

            for (int j = 0; j < tempvars.length; j++) {
                tempvars[j] = 0;
            }
            System.out.println("");

        }

    }

    private static void TestOnSamples() {
        TestResult = new int[Data.size()];
        for (int m = 0; m < TestResult.length; m++) {

            float temp_pro[] = new float[7];
            for (int i = 0; i < 7; i++) {
                temp_pro[i] = getProGivenClass(m, i);
            }
            for (int i = 0; i < 7; i++) {
                temp_pro[i] = temp_pro[i] * labelsPro[i] / Data.size();
            }
            float tmp = temp_pro[0];
            int win_class = 1;
            for (int i = 1; i < 7; i++) {
                if (temp_pro[i] > tmp) {
                    tmp = temp_pro[i];
                    win_class = i + 1;
                }
            }
            TestResult[m] = win_class;
        }

    }

    private static void showTestResult() {
        System.out.println("Test Results: ");
        System.out.println("----------------------");
        for (int i = 0; i < TestResult.length; i++) {
            System.out.println("sampele " + (i+1) + " is from class " + TestResult[i]);
        }
        System.out.println("");
    }

    private static void checkNaive() {
        showQuality();
        showMatrix();
    }

    private static void showQuality() {
        int all = Data.size();
        int TRUE = 0;
        int FALSE = 0;
        for (int i = 0; i < TestResult.length; i++) {
            if (TestResult[i] == Data.get(i).get(Data.get(i).size() - 1)) {
                TRUE++;
            } else {
                FALSE++;
            }
        }

        JOptionPane.showMessageDialog(null, "Correctly classified: " + TRUE + " samples = " + TRUE / (float)all * 100+ " %"
                + " \n" + "In-correctly classified: " + FALSE + " samples = " +  FALSE / (float)all  * 100 + " %");

    }

    private static void showMatrix() {

        comapreMatrix = new int[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                comapreMatrix[i][j] = 0;
            }
        }
        for (int i = 0; i < TestResult.length; i++) {

            int index1 = Data.get(i).get(Data.get(i).size() - 1).intValue();
            int index2 = TestResult[i];
            comapreMatrix[index1-1][index2-1]++;
        }

        System.out.println("Matrix");
        System.out.println("--------------------------------");
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(comapreMatrix[i][j] + "    ");
            }
            System.out.println("");
        }

    }

    private static float getProGivenClass(int index, int CLASS) {

        float temp_result[] = new float[9];
        for (int i = 0; i < 9; i++) {
            temp_result[i] = meansVar[i][CLASS].getGaussProp(Data.get(index).get(i));
        }
        float multiplier = 1;
        for (int i = 0; i < temp_result.length; i++) {
            multiplier = multiplier * temp_result[i];
        }
        return multiplier;
    }

}
