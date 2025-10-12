/*
Binary Number Generation
This class tests the code for Exercise3. It calls a method that accepts a positive integer n and generates binary numbers between 0 and 2^n -1. The main method prints information about running time.
*/

import java.util.Scanner;

public class Binary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();

        long startTime = System.currentTimeMillis();
        generateBinary(n);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("The execution time to generate binary numbers from 0 to " +
                ((int)Math.pow(2, n) - 1) + " is " + executionTime + " ms");

        scanner.close();
    }

    public static void generateBinary(int n) {
        int limit = (int) Math.pow(2, n);

        for (int i = 0; i < limit; i++) {
            // Generate binary string but DON'T print it
            String binary = Integer.toBinaryString(i);
        }
    }
}