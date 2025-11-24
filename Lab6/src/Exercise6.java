/**
 * Antony Punnassery
 * B01012905
 */
import java.util.Scanner;
public class Exercise6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive integer n to calculate sum: ");
        int n = sc.nextInt();
        int result = squares(n);
        System.out.println("The sum of squares from 1 to " + n + " is " + result);
    }

    //Recursive method to calculate squares of all integers from 1 to n
    public static int squares(int n) {
        if (n == 1){
            return 1;
        }
        return (n * n) + squares(n - 1);

    }
}
