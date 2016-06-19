package com.ctci.chapter1.es5;

public class OneEditAway {

	public static void main(String[] args) {
		System.out.println(oneEditAway("pale","bale"));

	}
	
	public static boolean oneEditAway(String str1, String str2){

		if(str1==null || str2==null || str1.equals(str2)|| Math.abs(str1.length()-str2.length())>1)
			return false;
		
		if(str1.length()==str2.length()){
			boolean foundDiff = false;
			for(int i=0;i<str1.length();i++){
				if(str2.charAt(i)!=str1.charAt(i)){
					if (foundDiff)
						return false;
					foundDiff = true;
				}
			}
			return true;
		} else {
			String longest = str1.length()> str2.length() ? str1 : str2;
			String shortest = str1.length()> str2.length() ? str2 : str1;
			
			int index1 = 0, index2 = 0;
			
			while (index1<longest.length() && index2<shortest.length()){
				if(longest.charAt(index1)!=shortest.charAt(index2)){
					if(index1!=index2)
						return false;
					index1++;
				} else {
					index1++;
					index2++;
				}
			}
			return true;
		}
	}

}
