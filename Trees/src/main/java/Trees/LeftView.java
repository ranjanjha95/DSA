package Trees;

public class LeftView {

	public static void main(String[] args) {

		LeftView treeOps = new LeftView();

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

		System.out.println("\nprintLeftView");
		treeOps.printLeftView(root);
	}

	static int maxLevel = -1;
	private void printLeftView(Node root) {

		printLeftView(root, 0);

	}

	private static void printLeftView(Node root, int level) {

		if(root == null)
			return;
		
		if(level > maxLevel) {
			
			maxLevel = level;
			System.out.print(root.data + " ");
			
		}
		
		printLeftView(root.left, level + 1);
		printLeftView(root.right, level + 1);
		
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
