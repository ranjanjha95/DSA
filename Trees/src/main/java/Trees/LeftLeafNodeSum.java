package Trees;

public class LeftLeafNodeSum {

	public static void main(String[] args) {

		LeftLeafNodeSum treeOps = new LeftLeafNodeSum();

		Node root;

		root = treeOps.new Node(3);
		root.left = treeOps.new Node(9);
		root.right = treeOps.new Node(20);
		root.right.left = treeOps.new Node(15);
		root.right.right = treeOps.new Node(7);

		System.out.println("Post-order");
		printPostorder(root);

		System.out.println("\nLeft Leaf Node Sum:" + treeOps.leftLeafNodeSum(root));

	}

	private int leftLeafNodeSum(Node root) {

		return leftLeafNodeSum(root, false);

	}

	private int leftLeafNodeSum(Node root, boolean isLeft) {

		if (root == null)
			return 0;

		if (root.left == null && root.right == null) {

			if (isLeft == true)
				return root.data;
			else
				return 0;
		}

		return leftLeafNodeSum(root.left, true) + leftLeafNodeSum(root.right, false);

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
