//Sheet 1 Problem 4: Encryption/Decryption b)
import java.util.Scanner;

public class decryption_decryption_a {

    public static void main(String args[]) {
        int digit1, digit2, digit3, digit4, x, temp;
        int decrypted;
        System.out.print("Enter a four digit number to be decrypted: ");
        Scanner in = new Scanner(System.in);
        x = in.nextInt();
        //Extract Digits
        digit1 = x % 10000 / 1000;
        digit2 = x % 1000 / 100;
        digit3 = x % 100 / 10;
        digit4 = x % 10 / 1;
        //Change Digits
        digit1 = (digit1 + 3) % 10;
        digit2 = (digit2 + 3) % 10;
        digit3 = (digit3 + 3) % 10;
        digit4 = (digit4 + 3) % 10;
        //Swap Digits
        temp = digit1;
        digit1 = digit3;
        digit3 = temp;
        temp = digit2;
        digit2 = digit4;
        digit4 = temp;
        //Construct Decrypted Number
        decrypted = digit1 * 1000 + digit2 * 100 + digit3 * 10 + digit4;
        System.out.println("Decrypted number is: " + String.format("%04d", decrypted));
    }
}

