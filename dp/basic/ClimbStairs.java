package dsa.dp.basic;

/**
 * There are n stairs, a person standing at the bottom wants to reach the top.
 * The person can climb either 1 stair or 2 stairs at a time. Count the number
 * of ways, the person can reach the top.
 * 
 * Input: n = 1 Output: 1 There is only one way to climb 1 stair
 * 
 * Input: n = 2 Output: 2 There are two ways: (1, 1) and (2)
 * 
 * Input: n = 4 Output: 5 (1, 1, 1, 1), (1, 1, 2), (2, 1, 1), (1, 2, 1), (2, 2)
 */

public class ClimbStairs {

	public static void main(String[] args) {

		ClimbStairs stairs = new ClimbStairs();

		long startTime, numOfWays;
		int numberOfStair = 48;

		startTime = System.nanoTime();
		numOfWays = stairs.numOfWays_DP(numberOfStair);
		System.out.println("\n===DP solution===\nExecution time: " + ((System.nanoTime() - startTime) / 1000f)
				+ "mi-s\nNumber of ways to climb " + numberOfStair + " stairs: " + numOfWays);

		startTime = System.currentTimeMillis();
		numOfWays = stairs.numOfWays_Recurns(numberOfStair);
		System.out.println("\n===Recursion solution===\nExecution time: " + (System.currentTimeMillis() - startTime)
				+ "ms\nNumber of ways to climb " + numberOfStair + " stairs: " + numOfWays);
	}

	private int numOfWays_DP(int numberOfStair) {

		int[] numOfWays = new int[numberOfStair];

		// Initialize the base condition
		numOfWays[0] = 1;
		numOfWays[1] = 2;

		for (int i = 2; i < numberOfStair; i++) {
			numOfWays[i] = numOfWays[i - 1] + numOfWays[i - 2];
		}

		return numOfWays[numberOfStair - 1];

	}

	private int numOfWays_Recurns(int numberOfStair) {

		if (numberOfStair == 1 || numberOfStair == 2)
			return numberOfStair;

		return numOfWays_Recurns(numberOfStair - 1) + numOfWays_Recurns(numberOfStair - 2);

	}

}