package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTree {

	static Node root;

	public static void main(String[] args) {

		ZigZagTree treeOps = new ZigZagTree();
		root = treeOps.new Node(1);

		root.left = treeOps.new Node(2);
		root.right = treeOps.new Node(3);

		root.left.left = treeOps.new Node(4);
		root.left.right = treeOps.new Node(5);

		root.left.left.right = treeOps.new Node(7);

		root.right.left = treeOps.new Node(6);
		root.right.left.right = treeOps.new Node(9);

		System.out.println("In-order");
		printInorder(root);

		System.out.println("\nPost-order");
		printPostorder(root);

		System.out.println("\nPre-order");
		printPreorder(root);

		System.out.println("\nLevel-order");
		printLevelOrder(root);

		System.out.println("\nLevel-order: printLevelOrderWithLevel");
		q.add(root);
		q.add(treeOps.new Node('$'));
		treeOps.printLevelOrderWithLevel(root);
	}

	static Queue<Node> q = new LinkedList<>();
	static int level = 0;
	private void printLevelOrderWithLevel(Node root) {

		Node curr = null;
		if ((curr = q.poll()) == null)
			return;

		if (curr.ch == '$') {
			System.out.println("====Level===");
			q.add(new Node('$'));
			level++;
			return;
		}
		
		System.out.println(curr.data + " ");
		
		if(level%2==0) {
			if (root.left != null)
				q.add(root.left);
			if (root.right != null)
				q.add(root.right);
		}else {
			if (root.right != null)
				q.add(root.right);
			if (root.left != null)
				q.add(root.left);
		}
		
		printLevelOrderWithLevel(root.left);
		printLevelOrderWithLevel(root.right);
		
	}

	private static void printLevelOrder(Node root) {

		Queue<Node> q = new LinkedList<>();

		q.add(root);

		Node curr = null;
		while ((curr = q.poll()) != null) {
			
			System.out.print(curr.data + " ");
			if (curr.left != null)
				q.add(curr.left);
			if (curr.right != null)
				q.add(curr.right);
		}
	}

	private static void printInorder(Node root) {

		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);

	}

	private static void printPostorder(Node root) {

		if (root == null)
			return;

		printPostorder(root.left);
		printPostorder(root.right);
		System.out.print(root.data + " ");

	}

	private static void printPreorder(Node root) {

		if (root == null)
			return;

		System.out.print(root.data + " ");
		printPreorder(root.left);
		printPreorder(root.right);

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
