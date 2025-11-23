import java.util.Scanner;
public class Exercise4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter positive integer n: ");
        int n = sc.nextInt();
        System.out.print("Enter positive integer m (number of multiples): ");
        int m = sc.nextInt();
        System.out.print("The first " + m + " multiples of " + n +  " are: ");
        multiples(n,m);

    }
    public static void multiples(int n, int m) {
       printMultiplesHelper(n, m, 1);
    }
    public static void printMultiplesHelper(int n, int m, int k) {
        if (k > m){
            System.out.println();
            return;
        }
        int currentMultiple = n * k;
        System.out.print(currentMultiple);

        //print comma and space if not last multiple:
        if (k < m) {
            System.out.print(", ");
        }

        printMultiplesHelper(n, m, k + 1);
    }
}
