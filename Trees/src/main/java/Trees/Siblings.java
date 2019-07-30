package Trees;

public class Siblings {

	public static void main(String[] args) {

		Siblings treeOps = new Siblings();

		Node root;

		root = treeOps.new Node(1);
		root.left = treeOps.new Node(2);
		root.right = treeOps.new Node(3);

		Node node4 = treeOps.new Node(4);
		root.left.left = node4;
		Node node5 = treeOps.new Node(5);
		root.left.right = node5;

		System.out.println("\nPost-order");
		printPostorder(root);

		System.out.println("isSibling: " + isSibling(root, node4, node5));
	}

	private static boolean isSibling(Node root, Node a, Node b) {

		if (root == null)
			return false;

		return ((root.left == a && root.right == b) || (root.left == b && root.right == a))
				|| isSibling(root.left, a, b) || isSibling(root.right, a, b);
	}

	private static void printPostorder(Node root) {

		if (root == null)
			return;

		printPostorder(root.left);
		printPostorder(root.right);
		System.out.print(root.data + " ");

	}

	class Node {

		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}
}
