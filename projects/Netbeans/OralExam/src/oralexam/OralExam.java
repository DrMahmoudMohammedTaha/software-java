package oralexam;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class OralExam {

     

    
    public static void main(String[] args) {
    
        
        int problemnumber;

        try {
            problemnumber = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of problems."));

            if(problemnumber < 1)
                problemnumber = 1;
        } catch (Exception e) {
            problemnumber = 1;
        }

        discrete[] question = new discrete[problemnumber];
        for (int i = 0; i < problemnumber; i++) {
            if (JOptionPane.showConfirmDialog(null, "problem no." + (i + 1) + "\nis this joint variable") == 0) {

                try {
                    String s1 = JOptionPane.showInputDialog(null, "Enter X @ y @ F(X,Y) matrix");
                    String s2 = s1.split("@")[1];
                    String s3 = s1.split("@")[2];
                    s1 = s1.split("@")[0];

                    question[i] = new dicreteJointFuction(toIntArray(s1), toIntArray(s2), toMatrix(s3));

                    question[i].valid = (toIntArray(s1).length == toIntArray(s2).length && toMatrix(s3).length == toMatrix(s3)[0].length && question[i].checkValid());

                } catch (Exception e) {
                    question[i] = null;
                }

            } else {

                try {
                    String s1 = JOptionPane.showInputDialog(null, "Enter X @ F(X)");
                    String s2 = s1.split("@")[1];
                    s1 = s1.split("@")[0];

                    question[i] = new discreteRandomVariable(toIntArray(s1), toFloatArray(s2));
                    question[i].valid = (toIntArray(s1).length == toFloatArray(s2).length && question[i].checkValid());

                } catch (Exception e) {
                    question[i] = null;
                }

            }
        }
        String s[] = arrangeresults(solve(question));
        for (String string : s) {
            System.out.println("############################################################");
            System.out.println(string);
     
        }
        new Scanner (System.in).next();

    
    
    
    }
    
    
    
    public static String[] arrangeresults(String[] x) {
        int content = 0;
        String holder[] = new String[x.length];
        for (int i = 0; i < x.length; i++) {
            if ((x[i].contains("joint")) && (!x[i].contains("valid"))) {
                holder[content] = x[i];
                content++;
            }
        }

        for (int i = 0; i < x.length; i++) {
            if ((x[i].contains("random")) && (!x[i].contains("valid"))) {
                holder[content] = x[i];
                content++;
            }
        }
        for (int i = 0; i < x.length; i++) {
            if (x[i].contains("Not valid")) {
                holder[content] = x[i];
                content++;
            }
        }

        return holder;
    }

    public static String[] solve(discrete problems[]) {
        String answer[] = new String[problems.length];
        for (int i = 0; i < problems.length; i++) {
            try {
                answer[i] = "solution of question no : " + (i + 1) + "\n" + "problem type:" + problems[i].gettResult();

            } catch (Exception e) {
                answer[i] = "question no: " + (i + 1) + " is Not valid.\nBeacause of input error.";
            }
        }

        return answer;

    }

    public static float[] toFloatArray(String s) {
        String holder[] = s.split(",");
        float x[] = new float[holder.length];
        for (int i = 0; i < holder.length; i++) {
            if (holder[i].contains("/")) {
                x[i] = (float) (Float.parseFloat(holder[i].split("/")[0].trim()) / (float) Float.parseFloat(holder[i].split("/")[1].trim()));
            } else {
                x[i] = Float.parseFloat(holder[i].trim());
            }
        }
        return x;
    }

    public static float[][] toMatrix(String s) {
        String holder[] = s.split("#");
        float x[][] = new float[holder.length][holder[0].split(",").length];
        for (int i = 0; i < holder.length; i++) {
            x[i] = toFloatArray(holder[i]);
        }

        return x;
    }

    public static int[] toIntArray(String s) {
        String holder[] = s.split(",");
        int x[] = new int[holder.length];
        for (int i = 0; i < holder.length; i++) {
            x[i] = Integer.parseInt(holder[i].trim());
        }
        return x;
    }

}
