package Trees;

public class CheckIdentical {

	public static void main(String[] args) {

		CheckIdentical treeOps = new CheckIdentical();

		Node root1, root2;

		root1 = treeOps.new Node(1);
		root1.left = treeOps.new Node(2);
		root1.right = treeOps.new Node(3);
		root1.left.left = treeOps.new Node(4);
		root1.left.right = treeOps.new Node(5);
		root1.right.left = treeOps.new Node(5);
		root1.right.right = treeOps.new Node(7);
		root1.right.right.right = treeOps.new Node(9);
		System.out.println("\nPost-order");
		printPostorder(root1);

		root2 = treeOps.new Node(1);
		root2.left = treeOps.new Node(2);
		root2.right = treeOps.new Node(3);
		root2.left.left = treeOps.new Node(4);
		root2.left.right = treeOps.new Node(5);
		root2.right.left = treeOps.new Node(6);
		root2.right.right = treeOps.new Node(7);
		root2.right.right.right = treeOps.new Node(9);
		System.out.println("\nPost-order");
		printPostorder(root2);

		System.out.println("\nGiven 2 tress are identical: " + isIdentical(root1, root2));

	}

	private static boolean isIdentical(Node root1, Node root2) {

		if (root1 == null && root2 == null)
			return true;

		if (root1 == null || root2 == null)
			return false;

		if (root1.data == root2.data) {
			if (isIdentical(root1.left, root2.left))
				if (isIdentical(root2.right, root2.right))
					return true;

		}

		return false;

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
