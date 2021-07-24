//Sheet 1 Problem 4: Encryption/Decryption a)
import java.util.Scanner;

public class encryption_decryption_a {

    public static void main(String args[]) {
        int digit1, digit2, digit3, digit4, x, temp;
        int encrypted;
        System.out.print("Enter a four digit number to be encrypted: ");
        Scanner in = new Scanner(System.in);
        x = in.nextInt();
        //Extract Digits
        digit1 = x % 10000 / 1000;
        digit2 = x % 1000 / 100;
        digit3 = x % 100 / 10;
        digit4 = x % 10 / 1;
        //Change Digits
        digit1 = (digit1 + 7) % 10;
        digit2 = (digit2 + 7) % 10;
        digit3 = (digit3 + 7) % 10;
        digit4 = (digit4 + 7) % 10;
        //Swap Digits
        temp = digit1;
        digit1 = digit3;
        digit3 = temp;
        temp = digit2;
        digit2 = digit4;
        digit4 = temp;
        //Construct Encrypted Number
        encrypted = digit1 * 1000 + digit2 * 100 + digit3 * 10 + digit4;
        System.out.println("Encrypted number is: " + String.format("%04d", encrypted));
    }
}

