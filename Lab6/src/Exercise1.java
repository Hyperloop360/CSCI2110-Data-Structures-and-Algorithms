/**
 * Antony Punnassery
 * B01012905
 */
import java.util.Scanner;
public class Exercise1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Factorial:
        System.out.println("Factorial of a number");
        System.out.println("Enter a positive integer: ");
        int factorialInput = sc.nextInt();
        int factResult = factorial(factorialInput);
        System.out.println("Factorial of " + factorialInput + " is " + factResult);
        System.out.println("------- \n");

        //Fibonachi
        System.out.println("Fibonacci Numbers");
        System.out.println("The first 20 numbers in the fibonacci sequence are: ");
        for (int i = 0; i < 20; i++) {
            System.out.print(fib(i));
            if (i < 19) System.out.print(", ");
        }
        System.out.println("\n--------\n");

        //Exponential
        System.out.println("Power of a number");
        System.out.print("Enter a positive integer x: ");
        int x = sc.nextInt();
        System.out.print("Enter another positive integer: ");
        int n = sc.nextInt();
        int powerResult = power(x, n);
        System.out.println(x + " to the power of " + n + " is " + powerResult);
        System.out.println("--------");

    }

    //Recursive factorial of an Integer n
    public static int factorial (int n) {
        if (n == 0) return 1;
        else return (n * factorial(n - 1));
    }

    //Fibonacci Series
    public static int fib (int n) {
        if(n==0) return 0;
        else if (n==1) return 1;
        else return fib(n-1) + fib(n-2);
    }

    //Exponential (x to the power of n)
    public static int power (int x, int n) {
        if (n == 0) return 1;
        else return power(x, n - 1) * x;
    }

}