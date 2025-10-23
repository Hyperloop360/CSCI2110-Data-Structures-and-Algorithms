/**
 * Antony Punnassery
 * B01012905
 */

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            long n = scanner.nextLong();
            if (n == 0) break;

            long startTime = System.currentTimeMillis();
            long bestNumber = 1;
            long maxLength = 1;

            for (long i = 1; i <= n; i++) {
                long current = i;
                long length = 1;

                while (current != 1) {
                    if (current % 2 == 0) {
                        current = current / 2;
                    } else {
                        if (current % 4 == 1) {
                            current = 7 * current + 1;
                        } else {
                            current = 7 * current - 1;
                        }
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

            System.out.println(n + " " + bestNumber + " " + maxLength + " " + time);
        }
    }
}