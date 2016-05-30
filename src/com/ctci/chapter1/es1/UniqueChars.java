package com.ctci.chapter1.es1;

public class UniqueChars {

	public static void main(String[] args) {
		String str = "abcsdertksy";
		System.out.println(hasUniqueChars2(str));
		for (Character i: str.toCharArray()){
			System.out.print(i+" ");
		}
	}

	private static void orderInsSort(char[] data){	
		for(int i=1;i<data.length;i++){
			char temp = 0;
			int j=i-1;
			while(j>=0){
				if(data[j]>data[j+1]){
					temp = data[j];
					data[j]=data[j+1];
					data[j+1]=temp; 
					
				}
				j--;
			}

		}
	}
	
	public static boolean hasUniqueChars3(String str){
		char[] data = str.toCharArray();
		orderInsSort(data);
		for(int i=0;i<data.length-1;i++){
			if(data[i]==data[i+1])
				return false;
		}
		return true;
	}
	
	public static boolean hasUniqueChars2(String str){
		if (str.length() > 256) return false;
		boolean[] char_set = new boolean[256];
		for(int i=0;i<str.length();i++){
			int val = str.charAt(i);
			if (char_set[val]) return false;
			char_set[val] = true;
		}
		return true;
		
	}
	

}
