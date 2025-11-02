/**
 * Antony Punnassery
 * B01012905
 */
import java.util.Scanner;

public class GenericQueueTest {

    //Utility: print queue from front to rear without changing final order
    private static <T> void display (GenericQueue<T> q) {
        int size = q.size();
        System.out.print("Queue: ");
        if (q.isEmpty()){
            System.out.println();
            return;
        }

        for (int i = 0; i < size; i++) {
            T item = q.dequeue();
            System.out.print(item + " ");
            q.enqueue(item);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GenericQueue<String> qs = new GenericQueue<>();
        GenericQueue<Integer> qi = new GenericQueue<>();

        //----------Strings section-----------//
        System.out.println("Enter strings to ENQUEUE (one per line). Blank line to finish:");
        while (true) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) break;
            qs.enqueue(line);
        }

        System.out.println("Queue<String> size: " + qs.size());
        display(qs);
        if (!qs.isEmpty()) {
            System.out.println("Peek<String>: " + qs.peek());
        }

        System.out.println("Enter a String to search with positionOf:");
        String searchStr = sc.nextLine().trim();
        int pos = qs.positionOf(searchStr);
        if (pos != -1)
            System.out.println("String " + searchStr + " found in position " + pos);
        else
            System.out.println("String " + searchStr + " not found");

        System.out.println("Enter String to remove (first occurrence):");
        String removeStr = sc.nextLine().trim();
        qs.remove(removeStr);
        display(qs);

        System.out.println("Dequeuing twice");
        if (!qs.isEmpty()) System.out.println(qs.dequeue());
        if (!qs.isEmpty()) System.out.println(qs.dequeue());
        display(qs);
        System.out.println("Queue<String> empty? " + qs.isEmpty());

        //----------Integers section-----------//
        System.out.println("\nEnter integers to ENQUEUE (one per line). Blank line to finish:");
        while (true) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) break;
            try {
                qi.enqueue(Integer.parseInt(line));
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer ignored.");
            }
        }

        System.out.println("Queue<Integer> size: " + qi.size());
        display(qi);
        if (!qi.isEmpty()) {
            System.out.println("Peek<Integer>: " + qi.peek());
        }

        System.out.println("Enter an int to search with positionOf:");
        String searchIntStr = sc.nextLine().trim();
        try {
            int searchInt = Integer.parseInt(searchIntStr);
            int posI = qi.positionOf(searchInt);
            if (posI != -1)
                System.out.println("Integer " + searchInt + " found in position " + posI);
            else
                System.out.println("Integer " + searchInt + " not found");
        } catch (NumberFormatException e) {
            System.out.println("Invalid integer input.");
        }

        System.out.println("Enter an int to remove (first occurrence):");
        String removeIntStr = sc.nextLine().trim();
        try {
            int removeInt = Integer.parseInt(removeIntStr);
            qi.remove(removeInt);
        } catch (NumberFormatException e) {
            System.out.println("Invalid integer input.");
        }

        display(qi);

        System.out.println("Dequeuing twice");
        if (!qi.isEmpty()) System.out.println(qi.dequeue());
        if (!qi.isEmpty()) System.out.println(qi.dequeue());
        display(qi);
        System.out.println("Queue<Integer> empty? " + qi.isEmpty());

    }
}
