package dsa.dp.basic;

public class Path2DMatrix {

	public static void main(String[] args) {

		Path2DMatrix path2dmatrix = new Path2DMatrix();

		// Insert base condition values
		int[][] a = { { 1, 1, 1 }, { 1, 0, 0 }, { 1, 0, 0 }, { 1, 0, 0 } };

		long startTime, numOfPath;

		// With recursion
		startTime = System.nanoTime();
		numOfPath = path2dmatrix.numberOfPath(3, 2);
		System.out.println("\n===Recursion solution===\nExecution time: " + (System.nanoTime() - startTime)
				+ "ns\nNumber of paths to reach: " + numOfPath);

		// With DP
		startTime = System.nanoTime();
		numOfPath = path2dmatrix.numberOfPath(a);
		System.out.println("\n===DP solution===\nExecution time: " + (System.nanoTime() - startTime)
				+ "ns\nNumber of paths to reach: " + numOfPath);

	}

	private int numberOfPath(int[][] a) {

		// return numberOfPath(a.length, a[0].length);

		int m = a.length;
		int n = a[0].length;

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				a[i][j] = a[i - 1][j] + a[i][j - 1];// + a[i - 1][j - 1];
			}
		}
		return a[m - 1][n - 1];
	}

	private int numberOfPath(int m, int n) {

		if (m == 0 || n == 0)
			return 1;

		return numberOfPath(m - 1, n) + numberOfPath(m, n - 1);// + numberOfPath(m - 1, n - 1);
	}

}