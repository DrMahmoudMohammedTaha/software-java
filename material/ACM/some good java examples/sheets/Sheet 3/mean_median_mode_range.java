//Sheet 3 Problem 4: Mean, Median, Mode, and Range
import java.util.Scanner;

public class mean_median_mode_range {

    public static void main(String args[]) {
        final int N = 5;
        int[] x = new int[N];
        readArray(x, N);
        printSeparator("Original Array");
        printArray(x, N);
        sort(x, N);
        printSeparator("Sorted Array");
        printArray(x, N);
        printSeparator("Array Mean");
        System.out.println(String.format("%9.2f", mean(x, N)));
        printSeparator("Array Median");
        System.out.println(String.format("%9.2f", median(x, N)));
        printSeparator("Array Range");
        System.out.println(String.format("%6d", range(x, N)));
        printSeparator("Array Mode");
        System.out.println(String.format("%6d", mode(x, N)));
    }

    static void readArray(int x[], int n) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.print("Enter an integer [0,99]: ");
            x[i] = in.nextInt();
        }
    }

    static void printSeparator(String s) {
        System.out.print("\n---------------------------\n");
        System.out.println(s + ":");
    }

    static void printArray(int x[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(String.format("%6d\t", x[i]));
            for (int j = 0; j < x[i]; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    static void sort(int x[], int n) {
        //Selection Sort
        int i, j;
        int iMin;
        for (j = 0; j < n - 1; j++) {
            iMin = j;
            for (i = j + 1; i < n; i++) {
                if (x[i] < x[iMin]) {
                    iMin = i;
                }
            }
            if (iMin != j) {
                int temp = x[j];
                x[j] = x[iMin];
                x[iMin] = temp;
            }
        }
    }

    static double mean(int x[], int n) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += x[i];
        }
        return sum / n;
    }

    static double median(int x[], int n) {
        if (n % 2 == 0) {
            return (x[n / 2] + x[n / 2 - 1]) / 2.0;
        } else {
            return x[(n - 1) / 2];
        }
    }

    static int mode(int x[], int n) {
        int[] freq = new int[100];
        for (int i = 0; i < 100; i++) {
            freq[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            freq[x[i]]++;
        }
        int maxF = freq[0];
        int freqX = 0;
        for (int i = 1; i < 100; i++) {
            if (maxF < freq[i]) {
                maxF = freq[i];
                freqX = i;
            }
        }
        return freqX;
    }

    static int range(int x[], int n) {
        return max(x, n) - min(x, n);
    }

    static int max(int x[], int n) {
        int maxX = x[0];
        for (int i = 1; i < n; i++) {
            if (maxX < x[i]) {
                maxX = x[i];
            }
        }
        return maxX;
    }

    static int min(int x[], int n) {
        int minX = x[0];
        for (int i = 1; i < n; i++) {
            if (minX > x[i]) {
                minX = x[i];
            }
        }
        return minX;
    }
}

