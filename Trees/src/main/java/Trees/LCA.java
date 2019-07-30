package Trees;

public class LCA {

	public static void main(String[] args) {

		LCA treeOps = new LCA();

		Node root;

		root = treeOps.new Node(1);
		root.left = treeOps.new Node(2);
		root.left.left = treeOps.new Node(9);
		root.left.right = treeOps.new Node(5);
		Node node8 = treeOps.new Node(8);
		root.left.left.right = node8;
		Node node6 = treeOps.new Node(6);
		root.left.right.right = node6;
		Node node7 = treeOps.new Node(7);
		root.left.right.right.left = node7;

		root.right = treeOps.new Node(3);
		root.right.right = treeOps.new Node(9);
		root.right.right.left = treeOps.new Node(10);
		root.right.right.right = treeOps.new Node(11);
		// Node node12 = treeOps.new Node(12);

		System.out.println("Post-order");
		printInorder(root);

		// Node lcaNode = treeOps.lca(root, node8, node7);
		Node lcaNode = treeOps.lca(root, node6, node7);

		System.out.println("LCA: " + lcaNode.data);
	}

	private Node lca(Node root, Node p, Node q) {

		if (root == null)
			return null;

		Node ls = lca(root.left, p, q);
		Node rs = lca(root.right, p, q);

		if ((root.data == p.data) || (root.data == q.data))
			return root;

		if (ls != null && rs != null)
			return root;

		else if (ls != null && rs == null)
			return ls;
		else if (rs != null && ls == null)
			return rs;

		return null;
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