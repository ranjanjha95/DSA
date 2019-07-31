package Trees;

public class MirrorImage {

	public static void main(String[] args) {

		MirrorImage treeOps = new MirrorImage();

		Node root;

		root = treeOps.new Node(1);
		root.left = treeOps.new Node(2);
		root.left.left = treeOps.new Node(4);
		root.right = treeOps.new Node(3);
		root.right.left = treeOps.new Node(6);
		root.right.right = treeOps.new Node(5);
		root.right.left.left = treeOps.new Node(7);

		System.out.println("\nPost-order");
		printPostorder(root);

		treeOps.printMirror(root);
		System.out.println("\nPost-order");
		printPostorder(root);
	}

	private void printMirror(Node root) {

		if (root == null)
			return;

		printMirror(root.left);
		printMirror(root.right);
		
		// Swap
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;

		
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
