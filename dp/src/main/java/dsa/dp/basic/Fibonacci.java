package dsa.dp.basic;

public class Fibonacci {

	public static void main(String[] args) {

		Fibonacci treeOps = new Fibonacci();
		System.out.println(treeOps.fib(6));

	}

	private int fib(int n) {

		int[] a = new int[n];
		a[0] = 0;
		a[1] = 1;

		return fib(n, a);

	}

	private int fib(int n, int[] a) {

		if (n == 2 || n == 1)
			return a[n];

		fib(--n, a);
		a[n] = a[n - 1] + a[n - 2];

		return a[n];
	}

}