import java.util.Scanner;
public class Exercise2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer n for the countdown: ");
        int n = sc.nextInt();
        System.out.println("Starting countdown from " + n + ":");
        countDown(n);
    }

    //Recursive countdown
    public static void countDown(int n) {
        if (n == 0){
            System.out.print("    BlastOff!");
        } else {
            System.out.print("    " + n);
            countDown(n-1);
        }
    }
}
