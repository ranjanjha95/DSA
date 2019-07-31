package Trees;

public class TopViewUsingDLL {

	public static void main(String[] args) {

		TopViewUsingDLL treeOps = new TopViewUsingDLL();
		TreeNode treeRoot = treeOps.new TreeNode(1);

		treeRoot.left = treeOps.new TreeNode(2);
		treeRoot.right = treeOps.new TreeNode(3);

		treeRoot.left.left = treeOps.new TreeNode(4);
		treeRoot.left.right = treeOps.new TreeNode(5);

		treeRoot.left.left.right = treeOps.new TreeNode(7);

		treeRoot.right.left = treeOps.new TreeNode(6);
		treeRoot.right.left.right = treeOps.new TreeNode(9);

		DLL topViewList = treeOps.topView(treeRoot);

	}

	private DLL topView(TreeNode treeRoot) {

		DLL dllRoot = new DLL(treeRoot, 0);

		top(treeRoot, dllRoot, 0, 0);

		return null;
	}

	private void top(TreeNode treeNode, DLL dllNode, int col, int level) {

		if (dllNode == null) {
			dllNode = new DLL(treeNode, level);
		}else {
			if(dllNode.level<level)
				dllNode.level = level;
		}

		top(treeNode.left, dllNode.prev, col - 1, level + 1);
		top(treeNode.right, dllNode.next, col + 1, level + 1);

	}

	class TreeNode {

		int data;
		TreeNode left, right;

		TreeNode(int data) {
			this.data = data;
		}
	}

	class DLL {
		DLL next;
		DLL prev;
		TreeNode node;
		int level;

		public DLL(TreeNode node, int level) {
			super();
			this.node = node;
			this.level = level;
		}
	}

}
