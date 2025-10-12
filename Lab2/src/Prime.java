import java.util.Scanner;
/*
Prime Solution
This class tests the code for Exercise1. It calls a method to
calculate the nth prime and prints information about running time.
*/
public class Prime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLong()) {
            long n = scanner.nextLong();
            if (n == 0) break;

            long startTime = System.currentTimeMillis();
            long prime = nthPrime(n);
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;

            System.out.println(n + " " + prime + " " + executionTime);
        }
        scanner.close();
    }

    public static long nthPrime(long n) {
        if (n == 1) return 2;

        long count = 1;
        long num = 3;

        while (count < n) {
            if (isPrimeSimple(num)) {
                count++;
                if (count == n) {
                    return num;
                }
            }
            num++;
        }
        return num;
    }

    public static boolean isPrimeSimple(long num) {
        if (num < 2) return false;

        for (long i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}