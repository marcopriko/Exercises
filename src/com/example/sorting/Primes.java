package com.example.sorting;

public class Primes {

	public static void main(String[] args) {
		for(int i=0;i<=100;++i){
			if (primeBetter(i))
				System.out.println(i+" is prime");
		}
	}

	public static boolean primeNaive(int n){
		if(n<2)
			return false;
		for(int i=2; i<n; i++){
			if(n%i==0) return false;
		}
		return true;
	}

	public static boolean primeBetter(int n){
		if(n<2)
			return false;
		int sqrt = (int) Math.sqrt(n);
		for(int i=2; i<=sqrt; i++){
			if(n%i==0) return false;
		}	 
		return true;
	}
	
	

}
