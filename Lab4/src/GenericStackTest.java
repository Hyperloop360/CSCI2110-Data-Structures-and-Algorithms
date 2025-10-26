/**
 * Antony Punnassery
 * B01012905
 */
import java.util.Scanner;

public class GenericStackTest {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    GenericStack<String> stackS = new GenericStack<>();
    GenericStack<Integer> stackI = new GenericStack<>();

    // --------Strings Section---------//
    System.out.println("Enter strings to PUS (one per line). Press Enter on an empty line to finish: ");
    while (true){
        String line = sc.nextLine();
        if (line.isEmpty()) break;
        stackS.push(line);
    }

    System.out.println("Stack<String> size: " + stackS.size());
    if (!stackS.isEmpty()){
        System.out.println("Stack<String> peek: " + stackS.peek());
    }

    System.out.println("Popping all String items (LIFO): ");
    while(!stackS.isEmpty()){
        System.out.print(stackS.pop() + " ");
    }
    System.out.println();
    System.out.println("Stack<String> empty? " +  stackS.isEmpty());

    //-------Integer Section-------//
    System.out.println("\nEnter Integers to PUSH (one per line). Press enter on an empty line to finish: ");
    while(true){
        String line = sc.nextLine();
        if (line.isEmpty()) break;
        try {
            int num = Integer.parseInt(line);
            stackI.push(num);
        } catch (NumberFormatException e) {
            System.out.println("Invalid integer!!!");
        }
    }

    System.out.println("Stack<Integer> size: " + stackI.size());
    if (!stackI.isEmpty()){
        System.out.println("Peek<Integer>: " + stackI.peek());
    }

    System.out.println("Popping all Integer items (LIFO): ");
    while(!stackI.isEmpty()){
        System.out.print(stackI.pop() + " ");
    }
    System.out.println();
    System.out.println("Stack<Integer> empty? " + stackI.isEmpty());

    }
}
