package dsa.stack;

import java.util.Stack;

public class SpanProblem {

	public static void main(String[] args) {

		// int[] arr = new int[] { 100, 80, 60, 70, 60, 75, 85 };
		int[] arr = new int[] { 10, 4, 5, 90, 120, 80 };

		int[] span = printSpan(arr);

		for (int i = 0; i < span.length; i++) {
			System.out.println(arr[i] + " -> " + span[i]);
		}
	}

	private static int[] printSpan(int[] a) {

		Stack<Integer> s = new Stack<Integer>();
		s.push(0);
		int popedVal = 0, top = -1, span[] = new int[a.length];

		for (int i = 1; i < a.length; i++) {

			while (!s.isEmpty() && a[s.peek()] < a[i]) {
				popedVal = s.pop();
				top = s.isEmpty() ? -1 : s.peek();
				span[popedVal] = popedVal - top;
			}
			s.push(i);
		}

		while (!s.isEmpty()) {
			popedVal = s.pop();
			top = s.isEmpty() ? -1 : s.peek();
			span[popedVal] = popedVal - top;
		}

		return span;
	}

	private static void printSpan1(int[] a) {

		Stack<Integer> s = new Stack<Integer>();
		s.push(0);
		int popedVal = 0, top = -1;

		for (int i = 1; i < a.length; i++) {

			while (a[s.peek()] < a[i]) {
				popedVal = s.pop();
				top = s.isEmpty() ? -1 : s.peek();
				System.out.println("Span for " + a[popedVal] + " is: " + (popedVal - top));

			}
			s.push(i);
		}

		while (!s.isEmpty()) {
			popedVal = s.pop();
			top = s.isEmpty() ? -1 : s.peek();
			System.out.println("Span for " + a[popedVal] + " is: " + (popedVal - top));
		}
	}
}
