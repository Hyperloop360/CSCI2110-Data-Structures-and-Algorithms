//Antony Punnassery
//B01012905
import java.util.*;
import java.util.Random;

public class BubbleSort {
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
    public static int[] sort(int[] arr){
        int n = arr.length;
        for (int k = 1; k < arr.length; k++) {
            // Perform the kth pass through the array.
            // With each pass, the largest element gets placed in its final position.
            // Therefore, we can reduce the range of the inner loop by k, as the last k elements are
            //already sorted.
            for (int i = 0; i < arr.length - k; i++) {
                // Compare adjacent elements in the array.
                // The inner loop iterates through the unsorted part of the array.
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        return arr;
    }
}