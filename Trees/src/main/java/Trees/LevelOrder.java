package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

	static Node root;

	public static void main(String[] args) {

		LevelOrder treeOps = new LevelOrder();
		root = treeOps.new Node(1);

		root.left = treeOps.new Node(2);
		root.right = treeOps.new Node(3);

		root.left.left = treeOps.new Node(4);
		root.left.right = treeOps.new Node(5);

		System.out.println("In-order");
		printInorder(root);

		System.out.println("\nPost-order");
		printPostorder(root);

		System.out.println("\nPre-order");
		printPreorder(root);

		System.out.println("\nprintLevelNode");
		q.add(root);
		treeOps.printLevelNode(root);
		System.out.println("\nprintNodeWithLevelNumber");
		treeOps.printNodeWithLevelNumber(q);

	}

	private void printNodeWithLevelNumber(Queue q) {

		Node curr = null;
		while ((curr = (Node) q.poll()) != null) {

			if (curr.ch == '?')
				System.out.println("===Level===");
			else
				System.out.println(curr.data);

		}

	}

	static Queue<Node> q = new LinkedList<>();

	private void printLevelNode(Node root) {

		if (root == null)
			return;

		System.out.print(root.data + " ");

		q.add(new Node('?'));
		q.add(root.left);
		q.add(root.right);

		printLevelNode(root.left);
		printLevelNode(root.right);

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
