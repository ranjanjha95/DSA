package Trees;

public class SumNodes {

	static Node root;

	public static void main(String[] args) {

		SumNodes treeOps = new SumNodes();
		root = treeOps.new Node(1);

		root.left = treeOps.new Node(2);
		root.right = treeOps.new Node(3);

		root.left.left = treeOps.new Node(4);
		root.left.right = treeOps.new Node(5);

		root.right.left = treeOps.new Node(6);
		root.right.right = treeOps.new Node(7);
		root.right.right.right = treeOps.new Node(9);

		System.out.println("Post Order Taversal");
		treeOps.postOrderPrint(root);

		treeOps.replaceNodeWithChildrenSum(root);

		System.out.println("Post Order Taversal");
		treeOps.postOrderPrint(root);
	}

	private int replaceNodeWithChildrenSum(Node root) {

		if (root == null)
			return 0;

		int sum = replaceNodeWithChildrenSum(root.left) + replaceNodeWithChildrenSum(root.right) + root.data;
		

		return root.data = sum;

	}

	private void postOrderPrint(Node root) {

		if (root == null)
			return;

		postOrderPrint(root.left);
		postOrderPrint(root.right);
		System.out.print(root.data + " ");

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
