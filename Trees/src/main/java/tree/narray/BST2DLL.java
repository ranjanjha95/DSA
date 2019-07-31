package tree.narray;

public class BST2DLL {

	public static void main(String[] args) {

		BST2DLL treeOps = new BST2DLL();

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

		// printDLL(treeOps.getBST2DLL(root));
		treeOps.getBST2DLL(root, null);

	}

	private Node getBST2DLL(Node root, Node prev) {

		if (root == null)
			return null;

		getBST2DLL(root.left, root);
		if (root.right != null) {
			root.right.right = prev;
			prev.left = root.right;
		}
			

		getBST2DLL(root.right, root);
		if (prev != null)
			root.left = prev;

		return root;

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