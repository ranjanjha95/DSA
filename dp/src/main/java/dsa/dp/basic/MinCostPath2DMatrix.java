package dsa.dp.basic;

public class MinCostPath2DMatrix {

	int[][] a = { { 2, 0, 6 }, { 3, 1, 7 }, { 4, 5, 9 } };;

	public static void main(String[] args) {

		MinCostPath2DMatrix path2dmatrix = new MinCostPath2DMatrix();

		// Insert base condition values

		// With recursion
		System.out.println(path2dmatrix.minPathWithRecursion(2, 2));

		// With DP
		System.out.println(path2dmatrix.minPathWithDP());

		// Print path/Backtracking
		path2dmatrix.printMinPath(path2dmatrix.minPathWithDP());
	}

	private void printMinPath(int minCost) {

		int m = a.length;
		int n = a[0].length;

		while (m >= 0 && n >= 0) {
		}

	}

	private int minPathWithRecursion(int m, int n) {

		if (m == 0 && n == 0)
			return a[m][n];

		if (m < 0 || n < 0)
			return Integer.MAX_VALUE;

		return a[m][n] + Math.min(Math.min(minPathWithRecursion(m - 1, n), minPathWithRecursion(m, n - 1)),
				minPathWithRecursion(m - 1, n - 1));

	}

	private int minPathWithDP() {

		int m = a.length;
		int n = a[0].length;

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {

				if (i == 0) {
					if (j > 0)
						a[i][j] = a[i][j] + a[i][j - 1];
				}

				else if (j == 0) {
					if (i > 0)
						a[i][j] = a[i][j] + a[i - 1][j];
				}

				else
					a[i][j] = a[i][j] + Math.min(Math.min(a[i - 1][j], a[i][j - 1]), a[i - 1][j - 1]);
			}

		return a[m - 1][n - 1];
	}

}