package Trees;

public class CountNodes {

	static Node root;

	public static void main(String[] args) {

		CountNodes treeOps = new CountNodes();
		root = treeOps.new Node(1);

		root.left = treeOps.new Node(2);
		root.right = treeOps.new Node(3);

		root.left.left = treeOps.new Node(4);
		root.left.right = treeOps.new Node(5);

		System.out.println("\nPre-order");
		// int totalNodes = treeOps.getTotalNumberOfNodes(root, 0);
		int totalNodes = treeOps.getTotalNumberOfNodes(root);

		System.out.println("Total number of nodes: " + totalNodes);
	}

	private int getTotalNumberOfNodes(Node root, int cnt) {

		if (root == null)
			return 0;

		return getTotalNumberOfNodes(root.left, cnt) + getTotalNumberOfNodes(root.right, cnt) + 1;
	}

	private int getTotalNumberOfNodes(Node root) {

		if (root == null)
			return 0;

		int lCnt = getTotalNumberOfNodes(root.left);
		int rCnt = getTotalNumberOfNodes(root.right);

		return lCnt + rCnt + 1;
	}

	class Node {

		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}

	}
}
