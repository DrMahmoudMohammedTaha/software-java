import java.util.Scanner;

public class Quiz_Time_Series_Derivative {

    public static void main(String args[]) {
        // Declaration
        int s1, s2;
        String ret;
        Scanner in = new Scanner(System.in);
        // Read The First Term
        System.out.print("Enter a term: ");
        s1 = in.nextInt();;
        if (s1 >= 0) {
            // Initialize The Derivative
            ret = "D = ";
            // Read The NextTerm
            System.out.print("Enter a term: ");
            s2 = in.nextInt();;
            while (s2 >= 0) {
                // Update The Derivative
                ret = ret + (s2 - s1) + ", ";
                // Update The Buffer
                s1 = s2;
                // Read The Next Term
                System.out.print("Enter a term: ");
                s2 = in.nextInt();;
            }
        } else {
            // Empty Series!
            ret = "Enter at least two terms.";
        }
        // Display The Derivative
        System.out.println(ret);
    }
}

