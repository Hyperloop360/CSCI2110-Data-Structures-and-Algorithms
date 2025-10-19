// Antony Punnassery
// B01012905
import java.util.*;
import java.util.Random;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        //Enter Value of n:
        System.out.print("Enter Value of n: ");
        int n = sc.nextInt();

        //Make and put random numbers in Array size n
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(n);
        }

        int[] newArr = new int[n];
        long startTime, endTime, executionTime; startTime = System.currentTimeMillis();
        sort(arr);
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;

        //display the executionTime
        System.out.println("Execution Time for Bubble Sort: " + executionTime + " milliseconds");
    }

    public static int[] sort(int[] arr) {
        int n = arr.length;

        // Outer loop to traverse the array from 0 to n-2 (the last element doesn't need a pass)
        // 'i' marks the boundary between the sorted and unsorted portions of the array.
        for (int i = 0; i < n - 1; i++) {
            // Assume the current element is the minimum
            int min_index = i;

            // Inner loop to find the minimum element in the unsorted part (from i+1 to n-1)
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }

            // Swap the found minimum element with the element at index i (if a new minimum was found)
            if (min_index != i) {
                // Swap arr[i] with arr[min_index]
                int temp = arr[i]; // Use a temporary variable for the swap operation.
                arr[i] = arr[min_index];
                arr[min_index] = temp;
            }
        }
        return arr;
    }

}