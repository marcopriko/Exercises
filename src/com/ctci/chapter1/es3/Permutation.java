package com.ctci.chapter1.es3;

import java.util.HashMap;


public class Permutation {

	public static void main(String[] args) {
		System.out.println(isPerm("asdfgh","hsedfa"));


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
}
