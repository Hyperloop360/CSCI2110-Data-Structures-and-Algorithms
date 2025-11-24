/**
 * Antony Punnassery
 * B01012905
 */
import java.util.Scanner;
public class Exercise5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive integer n to display vertically: ");
        int n = sc.nextInt();
        System.out.println("Digits of " + n + " printed vertically: ");
        writeVertical(n);
    }

    //Recursive method to write the input vertically
    public static void writeVertical(int n) {
        if (n < 10) {
            System.out.println(n);
        } else {
            writeVertical(n / 10);
            System.out.println(n % 10);
        }
    }

}
