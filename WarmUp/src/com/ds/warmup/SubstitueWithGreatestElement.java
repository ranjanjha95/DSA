package com.ds.warmup;


public class SubstitueWithGreatestElement {
	
	public static void main(String[] args) {
		
		int[] arr = new int[]{16, 17, 4, 3, 5, 2};
		
		System.out.println("Input Array: ");
		ArrayUtil.printArray(arr);
		
		modifyArray(arr);
		
		System.out.println("\n\nOutput Array: ");
		ArrayUtil.printArray(arr);
		
	}
	
	
	//Input : 16, 17, 4, 3, 5, 2
	//Output: 17, 5, 5, 5, 2, -1
			
	//Input : 6, 2, 4, 5, 3, 1
	//Output: 5, 5, 5, 3, 1, -1
	
	public static int[] modifyArray(int[] arr) {
		
		int lastIndx = arr.length - 1;
		int prevElement = arr[lastIndx];
		arr[lastIndx] = -1;
		int rMax = 0;
		
		for (int indx = lastIndx-1; indx >= 0; indx--) {
			
			//update the greatest element of right side
			if(rMax<prevElement)
				rMax=prevElement;
			
			prevElement = arr[indx];
			arr[indx]=rMax;
			
		}
		
		return arr;
	}
	
}
