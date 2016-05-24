package com.example.dsa.test;

import java.util.Arrays;

public class TestMiscellaneous {

	public static void main(String[] args) {
//		int[] data = {1,2,3,5};
//		System.out.println(unique2(data));
//		double[] prefixAvg = prefixAvg(data);
//		for (int i=0;i<prefixAvg.length;i++){
//			System.out.println(" "+prefixAvg[i]+" ");
//		}
//		System.out.println(sumOfPrefixSums(data));
		System.out.println(factorial(10));
	}

	// runs in O(nˆ2)
	public static boolean unique1(int[] data){
		for (int i=0;i<data.length-1;i++){     // n times
			for (int j=i+1;j<data.length;j++){ // (n-1)+(n-2)+...+1 times
				if (data[i]==data[j]) return false;
			}
		}
		return true;
	}
	
	//runs in O(n*logn)
	public static boolean unique2(int[] data){
		int[] sorted = Arrays.copyOfRange(data, 0, data.length);
		Arrays.sort(sorted);
		for (int i=0;i<sorted.length-1;i++){
			if(sorted[i]==sorted[i+1])
				return false;
		}
		return true;
	}
	
	public static double[] prefixAvg(double[] data){
		double[] result = new double[data.length];
		double curVal = 0;
		for (int i=0;i<data.length;i++){
			curVal+=data[i];
			result[i]=curVal/(i+1);
		}
		return result;
	}
	
	public static int sumOfEvenInt(int[] data){
		int sum = 0;
		for (int i=0;i<data.length;i+=2){
			sum+=data[i];
		}
		return sum;
	}
	
	public static int sumOfPrefixSums(int[] data){
		int sumOfSums=0;
		int prefixSum=0;
		for(int i=0;i<data.length;++i){
			prefixSum+=data[i];
			sumOfSums+=prefixSum;
		}
		return sumOfSums;
	}
	
	public static int factorial(int n) throws IllegalArgumentException{
		if(n<0) 
			throw new IllegalArgumentException();
		
		if(n==0)
			return 1;
		else
			return n*factorial(n-1);
	}
}
