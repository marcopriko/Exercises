package com.ctci.chapter1.es2;

import java.util.HashMap;


public class Permutation {

	public static void main(String[] args) {
		System.out.println(checkPermutation("asfdhg","adsfhg"));


	}

	private static boolean isPerm(String str1, String str2){
		if(str1.length()!=str2.length()) return false;
		HashMap<Character,Integer> charSet = new HashMap<>();
		for (Character cur: str1.toCharArray()){
			if(charSet.containsKey(cur)){
				charSet.put(cur, charSet.get(cur)+1);
			} else {
				charSet.put(cur, 1);
			}
		}
		for (Character cur: str2.toCharArray()){
			if(charSet.containsKey(cur)){
				if(charSet.get(cur)==1){
					charSet.remove(cur);
				} else{
					charSet.put(cur, charSet.get(cur)-1);
				}

			} else
				return false;
		}

		return charSet.isEmpty();


	}
	
	public static boolean checkPermutation(String str1, String str2){

		if(str1==null || str2==null || str1.length()!=str2.length()) return false;
		
		HashMap<Character,Integer> charMap = new HashMap<>();
		
		for(Character chr: str1.toCharArray()){
			if(charMap.containsKey(chr))
			  charMap.put(chr, charMap.get(chr) + 1);
			else
			  charMap.put(chr, 1);
		}
		
		for(Character chr: str2.toCharArray()){
			if(charMap.containsKey(chr)){
				int cnt = charMap.get(chr);
				if(cnt == 1)
				  charMap.remove(chr);
				else
					charMap.put(chr, cnt -1 );
			} else {
				return false;
			}
		}
		
		return charMap.isEmpty();
	}
}
