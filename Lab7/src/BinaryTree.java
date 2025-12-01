//This class contains the methods for the BinaryTree class.
//For the lab Exercise 1, you need to complete the TO-DO methods

import java.util.ArrayList;

public class BinaryTree<T> {
	private T data;
	private BinaryTree<T> parent;
	private BinaryTree<T> left;
	private BinaryTree<T> right;

	public BinaryTree() {
		parent = left = right = null;
		data = null;
	}

	public void makeRoot(T data) {
		if (!isEmpty()) {
			System.out.println("Can't make root. Already exists");
		} else
			this.data = data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setLeft(BinaryTree<T> tree) {
		left = tree;
	}

	public void setRight(BinaryTree<T> tree) {
		right = tree;
	}

	public void setParent(BinaryTree<T> tree) {
		parent = tree;
	}

	public T getData() {
		return data;
	}

	public BinaryTree<T> getParent() {
		return parent;
	}

	public BinaryTree<T> getLeft() {
		return left;
	}

	public BinaryTree<T> getRight() {
		return right;
	}

	public void attachLeft(BinaryTree<T> tree) {
		if (tree == null)
			return;
		else if (left != null || tree.getParent() != null) {
			System.out.println("Can't attach");
			return;
		} else {
			tree.setParent(this);
			this.setLeft(tree);
		}
	}

	public void attachRight(BinaryTree<T> tree) {
		if (tree == null)
			return;
		else if (right != null || tree.getParent() != null) {
			System.out.println("Can't attach");
			return;
		} else {
			tree.setParent(this);
			this.setRight(tree);
		}
	}

	public BinaryTree<T> detachLeft() {
		if (this.isEmpty())
			return null;
		BinaryTree<T> retLeft = left;
		left = null;
		if (retLeft != null)
			retLeft.setParent(null);
		return retLeft;
	}

	public BinaryTree<T> detachRight() {
		if (this.isEmpty())
			return null;
		BinaryTree<T> retRight = right;
		right = null;
		if (retRight != null)
			retRight.setParent(null);
		return retRight;
	}

	public boolean isEmpty() {
		if (data == null)
			return true;
		else
			return false;
	}

	public void clear() {
		left = right = parent = null;
		data = null;
	}

	public BinaryTree<T> root() {
		if (parent == null)
			return this;
		else {
			BinaryTree<T> next = parent;
			while (next.getParent() != null)
				next = next.getParent();
			return next;
		}
	}

	//this method counts the number of nodes in a BinaryTree recursively
	public static <T> int countNodes(BinaryTree<T> t){
		if (t == null || t.isEmpty())
			return 0;
		return 1 + countNodes(t.getLeft()) + countNodes(t.getRight());
	}


	// this method returns the height of a BinaryTree
	public static <T> int findHeight(BinaryTree<T> t) {
		if (t == null || t.isEmpty())
			return -1;

		int leftH = findHeight(t.getLeft());
		int rightH = findHeight(t.getRight());

		return 1 + Math.max(leftH, rightH);
	}
	
	// this method tests whether a tree is height balanced
	public static <T> boolean heightBalanced(BinaryTree<T> t) {
		if (t == null || t.isEmpty())
			return true;

		int leftH = findHeight(t.getLeft());
		int rightH = findHeight(t.getRight());

		if (Math.abs(leftH - rightH) > 1)
			return false;

		return heightBalanced(t.getLeft()) && heightBalanced(t.getRight());
	}

	public static <T> void preorder(BinaryTree<T> t) {
		if (t != null) {
			System.out.print(t.getData() + "\t");
			preorder(t.getLeft());
			preorder(t.getRight());
		}
	}

	public static <T> void inorder(BinaryTree<T> t) {
		if (t != null) {
			inorder(t.getLeft());
			System.out.print(t.getData() + "\t");
			inorder(t.getRight());
		}
	}

	public static <T> void postorder(BinaryTree<T> t) {
		if (t != null) {
			postorder(t.getLeft());
			postorder(t.getRight());
			System.out.print(t.getData() + "\t");
		}
	}

	// this method uses an ArrayList to print the data associated with all
	// nodes/trees in level order
	public static <T> void levelOrder(BinaryTree<T> t) {
		if (t == null || t.isEmpty())
			return;

		ArrayList<BinaryTree<T>> q = new ArrayList<>();
		q.add(t);

		while (!q.isEmpty()) {
			BinaryTree<T> curr = q.remove(0);
			System.out.print(curr.getData() + "\t");

			if (curr.getLeft() != null)
				q.add(curr.getLeft());
			if (curr.getRight() != null)
				q.add(curr.getRight());
		}
	}
}
