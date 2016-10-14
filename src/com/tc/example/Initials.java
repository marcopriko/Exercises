package com.tc.example;

public class Initials {

	public static void main(String[] args) {
		System.out.println(getInitials("single round match"));

	}
	
	public static String getInitials(String text){

		if(text==null)
			return null;
		String[] words = text.split("\\s+");
		
		StringBuilder buf = new StringBuilder();
		
		for (int i = 0; i < words.length; ++i){
			if(words[i].length() > 0)
			  buf.append(words[i].charAt(0));
		}
		
		return buf.toString();
	}

}
