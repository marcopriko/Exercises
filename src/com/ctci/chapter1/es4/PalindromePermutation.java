package com.ctci.chapter1.es4;

import java.util.HashMap;

public class PalindromePermutation {

	public static void main(String[] args) {
		System.out.println(isPalindromePerm("Casswssa c"));

	}

	public static boolean isPalindromePerm(String str){
		if(str==null || str.length()<2 ) return false;
		
		HashMap<Character,Integer> charMap = new HashMap<>();
		
		for(Character chr: str.toCharArray()){
			if(chr == ' ') continue;
			char chrLC = Character.toLowerCase(chr);
			if(charMap.containsKey(chrLC))
				charMap.put(chrLC, charMap.get(chrLC) + 1);
			else
				charMap.put(chrLC, 1);
		}
		
		int numOfOddCharCnt=0;
		
		for(Integer cnt: charMap.values()){
			if (cnt%2!=0)
			  numOfOddCharCnt++;
			if(numOfOddCharCnt>1)
				return false;
		}
		
		return true;
	}
	
	
}
