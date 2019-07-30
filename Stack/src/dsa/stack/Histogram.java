package dsa.stack;

import java.util.Stack;

public class Histogram {

	public static void main(String[] args) {

		// int[] arr = new int[] { 6, 2, 5, 4, 5, 1, 6 };
		int[] arr = new int[] { 1, 10, 5, 2, 3, 6, 4, 9 };

		int[] rectangularArea = findMaxRectangle(arr);

		int maxArea = 0;
		for (int i = 0; i < rectangularArea.length; i++) {

			if (maxArea < rectangularArea[i])
				maxArea = rectangularArea[i];

			System.out.println(arr[i] + " -> " + rectangularArea[i]);
		}

		System.out.println("Maximum Area: " + maxArea);
	}

	private static int[] findMaxRectangle(int[] a) {

		int size = a.length;
		int[] rectangularArea = new int[size];

		Stack<Integer> s = new Stack<Integer>();

		s.push(0);
		for (int i = 1; i < size; i++) {

			while (!s.isEmpty() && a[s.peek()] > a[i]) {

				int pi = s.pop();
				int top = s.isEmpty() ? -1 : s.peek();

				rectangularArea[pi] = (i - top - 1) * a[pi];

			}

			s.push(i);
		}

		while (!s.isEmpty()) {

			int pi = s.pop();
			int top = s.isEmpty() ? -1 : s.peek();

			rectangularArea[pi] = (pi - top) * a[pi];

		}

		return rectangularArea;
	}

}
