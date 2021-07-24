//Sheet 1 Problem 1: Diamond
public class diamond_1 {

    public static void main(String args[]) {
        int row;
        // top half
        for (row = 1; row <= 5; ++row) {
            for (int space = 1; space <= 5 - row; ++space) {
                System.out.print(' ');
            }
            for (int asterisk = 1; asterisk <= 2 * row - 1; ++asterisk) {
                System.out.print('*');
            }
            System.out.println();
        }
        // bottom half
        for (row = 4; row >= 1; --row) {
            for (int space = 1; space <= 5 - row; ++space) {
                System.out.print(' ');
            }
            for (int asterisk = 1; asterisk <= 2 * row - 1; ++asterisk) {
                System.out.print('*');
            }
            System.out.println();
        }
        System.out.println();
    }
}

