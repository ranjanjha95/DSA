package com.java.array;

import java.util.Arrays;

public class ModifyWithLeftRightProduct {

	// input arr[] = {2, 4, 1, 6, 8};
	// output arr[] = {8, 2, 24,8, 48};

	public static void main(String[] args) {

		int[] a = { 2, 4, 1, 6, 8 };

		int[] arr = modifyArray(a);

		System.out.println(Arrays.toString(arr));

	}

	private static int[] modifyArray(int[] a) {

		int len = a.length - 1;
		int prev = a[0];
		int curr = 0;
		
		a[0] = a[0]*a[1]; 
		for (int i = 1; i < len; i++) {

			//prev = a[i-1];
			curr = a[i];
			a[i] = prev*a[i+1];
			prev=curr;
			
		}
		a[len] = prev*a[len];

		return a;
	}

}
