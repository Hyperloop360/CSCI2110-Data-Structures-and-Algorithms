/**
 * Antony Punnassery
 * B01012905
 */
import java.util.Scanner;
public class Exercise7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a String to reverse: ");
        String s = sc.nextLine();
        String result = reverseString(s);
        System.out.println("The Reversed String is: " + result);
    }

    //Recursive method to reverse a String input
    public static String reverseString(String s) {
        if (s.length() <= 1){
            return s;
        }
        String restOfString = s.substring(1);
        char firstChar = s.charAt(0);
        return reverseString(restOfString) + firstChar;
    }
}
