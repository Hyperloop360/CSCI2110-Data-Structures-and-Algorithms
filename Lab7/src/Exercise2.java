import java.util.ArrayList;
import java.util.Scanner;

public class Exercise2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<BinaryTree<String>> nodes = new ArrayList<>();

        //Input
        while (true) {
            System.out.print("Enter name or done: ");
            String input = sc.nextLine().trim();

            if (input.equalsIgnoreCase("done"))
                break;

            BinaryTree<String> t = new BinaryTree<>();
            t.makeRoot(input);
            nodes.add(t);
        }

        if (nodes.isEmpty()) {
            System.out.println("No tree built.");
            return;
        }

            //Build Tree
            for (int i = 0; i < nodes.size(); i++) {
            BinaryTree<String> curr = nodes.get(i);

            int leftIndex = 2 * i + 1;
            int rightIndex = 2 * i + 2;

            if (leftIndex < nodes.size())
                curr.attachLeft(nodes.get(leftIndex));

            if (rightIndex < nodes.size())
                curr.attachRight(nodes.get(rightIndex));
        }

        // Root is the first node
        BinaryTree<String> root = nodes.get(0);

        //Print
        System.out.printf("\nHeight of the tree is: %d\n", BinaryTree.findHeight(root));
        System.out.printf("Number of nodes in the tree is: %d\n\n", BinaryTree.countNodes(root));

        System.out.print("Inorder:\t");
        BinaryTree.inorder(root);
        System.out.println();

        System.out.print("Preorder:\t");
        BinaryTree.preorder(root);
        System.out.println();

        System.out.print("Postorder:\t");
        BinaryTree.postorder(root);
        System.out.println();

        System.out.print("Level order:\t");
        BinaryTree.levelOrder(root);
        System.out.println();
    }
}