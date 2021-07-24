//Sheet 1 Problem 1: Diamond
public class diamond_2 {

    public static void main(String args[]) {
        int row;
        for (row = 1; row <= 9; ++row) {
            int n = 5 - Math.abs(row - 5);
            for (int space = 1; space <= 5 - n; ++space) {
                System.out.print(' ');
            }
            for (int asterisk = 1; asterisk <= 2 * n - 1; ++asterisk) {
                System.out.print('*');
            }
            System.out.println();
        }
        System.out.println();
    }
}

