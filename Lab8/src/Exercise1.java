/**
 * Antony Punnasery
 * B01012905
 */
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        //Input
        System.out.print("Enter int or '0': ");
        int value = sc.nextInt();

        while (value != 0) {
            if (value > 0) {
                bst.insert(value);
            }
            System.out.print("Enter int or '0': ");
            value = sc.nextInt();
        }

        //Print Max
        System.out.println("The max data value in the BST is: " + bst.findMax());

        //Print Min
        System.out.println("The min data value in the BST is: " + bst.findMin());

        // Search for Existing
        System.out.print("What key would you like to search for? ");
        int key = sc.nextInt();

        BinaryTree<Integer> result = bst.recursiveSearch(key);

        if (result != null) System.out.println("Found!");
        else System.out.println("Not found.");
    }
}
