// Antony Punnassery
// B01012905

import java.util.Scanner;

public class LinkedListDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<>();

        System.out.println("Enter Pokemon names, one on each line");
        System.out.println("Enter quit to end");

        // Input loop
        while (true) {
            String name = sc.nextLine();
            if (name.equals("quit"))
                break;
            list.add(name);
        }

        System.out.println("\nHere is the linked list:");
        list.enumerate();

        // Display even-numbered indices
        System.out.println("\n\nHere is the linked list with even-numbered indices:");
        displayEven(list);

        // Display odd-numbered indices
        System.out.println("\n\nHere is the linked list with odd-numbered indices:");
        displayOdd(list);

        // Reverse the list
        System.out.println("\n\nHere is the reversed linked list:");
        LinkedList<String> reversedList = reverse(list);
        reversedList.enumerate();

        // Remove middle node
        System.out.println("\n\nRemoving the middle node...");
        removeMiddle(list);
        System.out.println("Here is the linked list after removing the middle node:");
        list.enumerate();

        sc.close();
    }

    // Display nodes at even-numbered indices
    public static void displayEven(LinkedList<String> list) {
        Node<String> current = list.getFront();
        int index = 0;
        while (current != null) {
            if (index % 2 == 0)
                System.out.print(current.getData() + "  ");
            current = current.getNext();
            index++;
        }
        System.out.println();
    }

    // Display nodes at odd-numbered indices
    public static void displayOdd(LinkedList<String> list) {
        Node<String> current = list.getFront();
        int index = 0;
        while (current != null) {
            if (index % 2 != 0)
                System.out.print(current.getData() + "  ");
            current = current.getNext();
            index++;
        }
        System.out.println();
    }

    // Create and return a reversed linked list
    public static LinkedList<String> reverse(LinkedList<String> list) {
        LinkedList<String> reversed = new LinkedList<>();
        Node<String> current = list.getFront();
        while (current != null) {
            reversed.add(current.getData()); // add() adds to front, so order is reversed
            current = current.getNext();
        }
        return reversed;
    }

    // Remove the middle node in the linked list
    public static void removeMiddle(LinkedList<String> list) {
        int size = list.size();
        if (size == 0) return;

        int midIndex = (size - 1) / 2;
        list.removeAt(midIndex);
    }
}