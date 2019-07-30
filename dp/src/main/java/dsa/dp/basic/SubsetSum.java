package dsa.dp.basic;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {

	public static void main(String[] args) {

		SubsetSum subsetSum = new SubsetSum();

		int[] input = { 5, 3, 2, 4, 1, 6 };
		int sum = 6;// sum=6 -> {2,4}, {5,1},{6},{3,2,1}

		int inputSize = input.length;
		List<Integer> result = new ArrayList<>();

		// With recursion
		System.out.println(subsetSum.isSubsetSum(input, inputSize, sum, result, true));

		System.out.println(subsetSum.isSubsetSum(input, inputSize, sum, result));

	}

	private boolean isSubsetSum(int[] set, int indx, int sum, List<Integer> result, boolean isInclude) {

		if (sum == 0) {
			System.out.println("Result set: " + result);
			result.clear();
			return true;
		}

		if (indx == 0 && sum > 0)
			return false;

		if (set[indx - 1] > sum)
			return isSubsetSum(set, indx - 1, sum, result, false);

		if (isInclude)
			result.add(set[indx - 1]);

		return isSubsetSum(set, indx - 1, sum - set[indx - 1], result, true)
				|| isSubsetSum(set, indx - 1, sum, result, false);

	}

	private boolean isSubsetSum(int[] set, int indx, int sum, List<Integer> result) {

		if (sum == 0) {
			System.out.println("Result set: " + result);
			result.clear();
			return true;
		}

		if (indx == 0 && sum != 0)
			return false;

		if (set[indx - 1] > sum)
			return isSubsetSum(set, indx - 1, sum, result);

		boolean exclude = isSubsetSum(set, indx - 1, sum, result);
		boolean include = isSubsetSum(set, indx - 1, sum - set[indx - 1], result);

		if (include)
			result.add(set[indx - 1]);

		return exclude || include;

	}
}