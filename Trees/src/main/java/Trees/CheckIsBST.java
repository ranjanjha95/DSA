package Trees;

public class CheckIsBST {

	public static void main(String[] args) {

		CheckIsBST treeOps = new CheckIsBST();

		Node root;

		root = treeOps.new Node(5);
		root.left = treeOps.new Node(3);
		root.left.left = treeOps.new Node(1);
		root.left.right = treeOps.new Node(4);
		root.left.left.right = treeOps.new Node(2);

		root.right = treeOps.new Node(8);
		root.right.left = treeOps.new Node(7);
		root.right.left.left = treeOps.new Node(6);
		root.right.right = treeOps.new Node(10);
		root.right.right.left = treeOps.new Node(9);

		System.out.println("Inorder");
		printInorder(root);

		System.out.println("Is BST: " + treeOps.isBST(root, null));
		// treeOps.isBST(root, null);
	}

	private boolean isBST(Node root, Node prev) {

		if (root == null)
			return true;

		isBST(root.left, prev);

		if (prev != null && prev.data > root.data)
			return false;

		prev = root;

		isBST(root.right, prev);

		return true;
	}

	private static void printInorder(Node root) {

		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);

	}

	class Node {

		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}
}