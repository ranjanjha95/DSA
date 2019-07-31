package Trees;

public class TreeOperations {

	static Node root;

	public static void main(String[] args) {

		TreeOperations treeOps = new TreeOperations();
		root = treeOps.new Node(1);

		root.left = treeOps.new Node(2);
		root.right = treeOps.new Node(3);

		root.left.left = treeOps.new Node(4);
		root.left.right = treeOps.new Node(5);
		
		root.left.left.right = treeOps.new Node(7);
		 
		root.right.left = treeOps.new Node(6);
		
		root.right.left.right = treeOps.new Node(9);

		System.out.println("In order");
		printInorder(root);

		System.out.println("\nPost order");
		printPostorder(root);

		System.out.println("\nPre order");
		printPreorder(root);
	}

	private static void printInorder(Node root) {

		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);

	}

	private static void printPostorder(Node root) {

		if (root == null)
			return;

		printPostorder(root.left);
		printPostorder(root.right);
		System.out.print(root.data + " ");

	}
	
	private static void printPreorder(Node root) {

		if (root == null)
			return;

		System.out.print(root.data + " ");
		printPreorder(root.left);
		printPreorder(root.right);

	}

	class Node {

		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}
}
