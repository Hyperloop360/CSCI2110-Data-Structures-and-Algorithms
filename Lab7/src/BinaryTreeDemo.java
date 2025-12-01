public class BinaryTreeDemo {
	public static void main(String[] args) {

		BinaryTree<String> A = new BinaryTree<String>();
		BinaryTree<String> B = new BinaryTree<String>();
		BinaryTree<String> C = new BinaryTree<String>();
		BinaryTree<String> D = new BinaryTree<String>();
		BinaryTree<String> E = new BinaryTree<String>();
		BinaryTree<String> F = new BinaryTree<String>();
		A.makeRoot("A");
		B.makeRoot("B");
		C.makeRoot("C");
		D.makeRoot("D");
		E.makeRoot("E");
		F.makeRoot("F");

		A.attachLeft(B);
		A.attachRight(C);
		B.attachLeft(D);
		B.attachRight(E);
		D.attachLeft(F);

		// test statements
		System.out.printf("Height of the tree is: %d\n", BinaryTree.findHeight(A));

		System.out.printf("Number of nodes in the tree is: %d\n", BinaryTree.countNodes(A));

		System.out.println();

		System.out.print("Inorder:\t");
		BinaryTree.inorder(A);
		System.out.println();

		System.out.print("Preorder:\t");
		BinaryTree.preorder(A);
		System.out.println();

		System.out.print("Postorder:\t");
		BinaryTree.postorder(A);
		System.out.println();

		System.out.print("Levelorder:\t");
		BinaryTree.levelOrder(A);
		System.out.println();
		System.out.println();

		System.out.printf("And is it height balanced... %s\n", BinaryTree.heightBalanced(A) ? "Yes!" : "No.");

		System.out.println();
	}

}
