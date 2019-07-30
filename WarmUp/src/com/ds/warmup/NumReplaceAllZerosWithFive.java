package com.ds.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumReplaceAllZerosWithFive {

	public static void main(String[] args) {

		// i/p: 1004
		// o/p: 1554

		//System.out.println(convertFive(convertFive(7003)));
		
		try {
			f();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static int convertFive(int n) {

		int reverseNum = 0;
		int rem = 0;

		while (n > 0) {

			rem = n % 10;
			reverseNum = reverseNum * 10 + (rem == 0 ? 5 : rem);
			n = n / 10;

		}

		return reverseNum;
	}
	
	public static void f() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   	 
   	 int tc = Integer.parseInt(br.readLine());
   	 String inputStr = "";
   	 
   	 while(tc-->0){
   	     inputStr = br.readLine();
   	     int inputStrLen = inputStr.length();
   	     
   	     if(inputStrLen<2)
   	        System.out.println("YES");
   	     for(int i=1; i<inputStrLen; i++){
   	         if(inputStr.charAt(i) != inputStr.charAt(0)){
   	             System.out.println("NO");
   	             return;
   	         }
   	     }
   	     
   	     System.out.println("YES");
   	 }
	}

}
