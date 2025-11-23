import java.util.Scanner;
public class Exercise3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer n for the countdown: ");
        int n = sc.nextInt();
        System.out.println("Starting countdown from " + n + ":");
        countDown(n);
    }

    //Recursive countdown Odd and Even
    public static void countDown(int n) {
        if (n < 1) {
            System.out.print("    BlastOff!");
            return;
        }
        System.out.print("    " + n);
        countDown(n-2);
    }
}
