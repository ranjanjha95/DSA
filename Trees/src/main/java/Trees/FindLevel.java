package Trees;

public class FindLevel {

	static Node root;

	public static void main(String[] args) {

		FindLevel treeOps = new FindLevel();
		root = treeOps.new Node(1);

		root.left = treeOps.new Node(2);
		root.right = treeOps.new Node(3);

		root.left.left = treeOps.new Node(4);
		root.left.right = treeOps.new Node(5);

		root.left.left.right = treeOps.new Node(7);

		root.right.left = treeOps.new Node(6);
		root.right.left.right = treeOps.new Node(9);

		System.out.println("Level: " + getLevel(root, 5));
	}

	private static int findLevelOfNode(Node root, int data, int level) {

		if (root == null)
			return -1;

		if (root.data == data)
			return level;
		
		int ls = findLevelOfNode(root.left, data, level + 1);
		if (ls != -1)
			return ls;

		int rs = findLevelOfNode(root.right, data, level + 1);
		if (rs != -1)
			return rs;

		return -1;

	}

	private static int getLevel(Node root, int data) {

		return findLevelOfNode(root, data, 0);

	}

	class Node {

		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}
}
