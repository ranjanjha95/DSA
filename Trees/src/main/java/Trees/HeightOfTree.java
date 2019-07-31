package Trees;

public class HeightOfTree {

	static Node root;

	public static void main(String[] args) {

		HeightOfTree treeOps = new HeightOfTree();
		root = treeOps.new Node(1);

		root.left = treeOps.new Node(2);
		root.right = treeOps.new Node(3);
		root.left.left = treeOps.new Node(4);
		root.left.right = treeOps.new Node(5);
		root.right.left = treeOps.new Node(6);
		root.right.right = treeOps.new Node(7);
		root.right.right.right = treeOps.new Node(9);

		System.out.println("\nPost-order");
		printPostorder(root);

		System.out.println("Height of given tree: "+ getHeight(root));
		
	}

	private static int getHeight(Node root) {
		
		if(root == null)
			return -1;
		
		int ls = getHeight(root.left);
		int rs = getHeight(root.right);
		
		return Math.max(ls, rs) + 1;
		
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
		char ch;

		Node(int data) {
			this.data = data;
		}

		Node(char ch) {
			this.ch = ch;
		}
	}
}
