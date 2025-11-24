/**
 * Antony Punnassery
 * B01012905
 */
import java.util.Scanner;
public class Exercise8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of steps (below 30): ");
        int steps = sc.nextInt();
        int result = countWays(steps);
        System.out.println("Number of ways to climb " + steps + " steps: " + result);
    }

    //Recurse method to count the number of possible ways to reach the same value by adding (steps)
    public static int countWays(int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        return countWays(n - 1) + countWays(n - 2) + countWays (n - 3);
    }
}
