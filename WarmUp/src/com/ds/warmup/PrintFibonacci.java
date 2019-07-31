package com.ds.warmup;

public class PrintFibonacci {

	public static void main(String[] args) {

		System.out.println("Finbonacci element: " + printFibonaciSeries(5));

	}

	private static int printFibonaciSeries(int n) {

		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		int x = printFibonaciSeries(n - 1);
		int y = printFibonaciSeries(n - 2);

		// return printFibonaciSeries(n - 1) + printFibonaciSeries(n - 2);
		return x + y;
	}

}
