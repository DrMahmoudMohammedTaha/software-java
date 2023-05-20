package formatter;

import java.util.Arrays;
import java.util.Random;

public class Formatter {

    public static void main(String[] args) {
        Random r = new Random();
        int x[] = new int[99999];
        x[0] = 1;
        for (int i = 1; i < x.length; i++) {
            x[i] =   r.nextInt(90);

        }
        System.out.println("me");
        new Formatter().sort(x);
        System.out.println(Arrays.toString(x));
     
    }

    // calls recursive split method to begin merge sorting
    public void sort(int[] data) {
        sortArray(0, data.length - 1 , data);// split entire array
    }// end method sort
    //splits array, sorts sub arrays and merges sub arrays into sorted array

    private void sortArray(int low, int high , int [] data) {
        // test base case; size of array equals 1
        if ((high - low) >= 1)// if not base case
        {
            int middle1 = (low + high) / 2;// calculate middle of array
            int middle2 = middle1 + 1;// calculate next element over
            // split array in half; sort each half (recursive calls)
            sortArray(low, middle1 , data); // first half of array
            sortArray(middle2, high , data);// second half of array
            // merge two sorted arrays after split calls return
            merge(low, middle1, middle2, high , data);
        } // end if
    }// end method sortArray
    // merge arrays until reaching end of either
    // merge two sorted subarrays into one sorted subarray

    private void merge(int left, int middle1, int middle2, int right, int []data) {
        int leftIndex = left; // index into left subarray
        int rightIndex = middle2;// index into right subarray
        int combinedIndex = left;// index into temporary working array
        int[] combined = new int[data.length];// working array
        while (leftIndex <= middle1 && rightIndex <= right) {
	// place smaller of two current elements into result
            // and move to next space in arrays
            if (data[ leftIndex] <= data[ rightIndex]) {
                combined[ combinedIndex++] = data[ leftIndex++];
            } else {
                combined[ combinedIndex++] = data[ rightIndex++];
            }
        } // end while
        // if left array is empty
        if (leftIndex == middle2) // copy in rest of right array
        {
            while (rightIndex <= right) {
                combined[ combinedIndex++] = data[ rightIndex++];
            }
        } else // right array is empty
        // copy in rest of left array
        {
            while (leftIndex <= middle1) {
                combined[ combinedIndex++] = data[ leftIndex++];
            }
        }
        // copy values back into original array
        for (int i = left; i <= right; i++) {
            data[ i] = combined[ i];
        }
    }// end method merge
}
