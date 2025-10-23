/**
 * Antony Punnassery
 * B01012905
 */
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long n = sc.nextLong();
            if (n == 0) break;

            long startTime = System.currentTimeMillis();
            long bestNumber = 1;
            long maxLength = 1;

            // Check all numbers from 1 to n
            for (long i = 1; i <= n; i++) {
                long current = i;
                long length = 1;

                // Collatz sequence
                while (current != 1) {
                    if (current % 2 == 0) {
                        current = current / 2;
                    } else {
                        current = 3 * current + 1;
                    }
                    length++;
                }

                // Update if this sequence is longer
                if (length > maxLength) {
                    maxLength = length;
                    bestNumber = i;
                }
            }

            long endTime = System.currentTimeMillis();
            long time = endTime - startTime;

            // Output: n bestNumber maxLength time
            System.out.println(n + " " + bestNumber + " " + maxLength + " " + time);
        }

    }
}
