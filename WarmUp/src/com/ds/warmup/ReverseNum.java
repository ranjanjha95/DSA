package com.ds.warmup;

public class ReverseNum {
	
	public static void main(String[] args) {
		
		System.out.print(getReverseNum(503) + " ");
		
	}

	private static int getReverseNum(int num){
        
        int reverseNum = 0;
        
        while(num > 0){
            reverseNum = reverseNum*10 + num%10;
            num = num/10;
        }
        
        return reverseNum;
    }
	
}

