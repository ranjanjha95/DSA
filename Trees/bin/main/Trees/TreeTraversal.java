package Trees;

public class TreeTraversal {

	public static void main(String[] args) {

		TreeTraversal obj = new TreeTraversal();

		Node root = obj.constructTree();

		System.out.println("---Level 0---");
		System.out.println(root.data);

		System.out.print("---Level 1---\n");
		System.out.print(root.left.data);
		System.out.print(" " + root.right.data);

		System.out.println("\n---Level 2---");
		System.out.print(root.left.left.data);
		System.out.print(" " + root.left.right.data);
		System.out.print(" " + root.right.left.data);

		System.out.println("\n---Level 3---");
		System.out.print(root.left.left.right.data);
		System.out.print(" " + root.right.left.right.data);

		System.out.println("============================\n");

		// Pre-order
		obj.traverse(root);
	}

	private void traverse(Node root) {

		if (root == null)
			return;

		traverse(root.left);
		traverse(root.right);
		System.out.print(root.data + " ");

	}

	private Node constructTree() {

		Node root = new Node(1);

		// Level 1
		root.left = new Node(2);
		root.right = new Node(3);

		// Level 2
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);

		// Level 3
		root.left.left.right = new Node(7);
		root.right.left.right = new Node(9);

		return root;
	}

}

class Node {

	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
	}
}