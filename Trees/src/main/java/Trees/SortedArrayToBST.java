package Trees;

public class SortedArrayToBST {

	static Node root;

	public static void main(String[] args) {

		SortedArrayToBST treeOps = new SortedArrayToBST();

		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		Node root = treeOps.createBST(arr, 0, arr.length - 1);

		System.out.println("\nInorder Taversal");
		treeOps.inorderPrint(root);
	}

	private Node createBST(int[] arr, int i, int j) {

		if (i > j)
			return null;

		int mid = (i + j) / 2;

		Node root = new Node(arr[mid]);

		root.left = createBST(arr, i, mid - 1);
		root.right = createBST(arr, mid + 1, j);

		return root;

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

		Node(int data) {
			this.data = data;
		}
	}
}
