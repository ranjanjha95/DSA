package Trees;

public class BSTReplaceNodeWithGreater {

	static Node root;

	public static void main(String[] args) {

		BSTReplaceNodeWithGreater treeOps = new BSTReplaceNodeWithGreater();

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

		System.out.println("Inorder Taversal");
		treeOps.inorderPrint(root);

		treeOps.replaceNodeWithSumOfGreater(root);

		System.out.println("\nInorder Taversal");
		treeOps.inorderPrint(root);
	}

	private int replaceNodeWithSumOfGreater(Node root) {

		if (root == null)
			return 0;

		int rs = replaceNodeWithSumOfGreater(root.right);
		root.data = root.data + rs;
		int ls = replaceNodeWithSumOfGreater(root.left);
		
		return root.data;

	}

	int sum = 0;

	private void replaceNodeWithSumOfGreater1(Node root) {

		if (root == null)
			return;

		replaceNodeWithSumOfGreater1(root.right);
		root.data = root.data + sum;
		sum = root.data;
		replaceNodeWithSumOfGreater1(root.left);

	}

	private void inorderPrint(Node root) {

		if (root == null)
			return;

		inorderPrint(root.left);
		System.out.print(root.data + " ");
		inorderPrint(root.right);

	}

	class Node {

		int data;
		Node left, right;
		char ch;

		Node(int data) {
			this.data = data;
		}

		Node(char ch) {
			this.ch = ch;
		}
	}
}
