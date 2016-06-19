package com.ctci.chapter1.es6;

public class CompressString {

	public static void main(String[] args) {
		System.out.println(compressString1("aabcceeeeeecccaa"));
		System.out.println(countCompression("aabcceeeeeecccaa"));

	}

	public static String compressString1(String data){
		if (data == null || data.isEmpty()) return data;
		if(data.length()<=countCompression(data)) return data;
		StringBuffer buf = new StringBuffer();
		char curChar = data.charAt(0);
		int curCnt=0;
		for (Character c: data.toCharArray()){
			if(c==curChar)
				curCnt++;
			else {
				buf.append(curChar+String.valueOf(curCnt));
				curCnt=1;
				curChar=c;
			}
		}
		buf.append(curChar+String.valueOf(curCnt));
		return buf.toString();
	}
	
	public static String compressString2(String data){ // no StringBuffer
		if (data == null || data.isEmpty()) return data;
		int size = countCompression(data);
		if(data.length()<= size) return data;
		
		char[] array = new char[size];
		char curChar = data.charAt(0);
		int curCnt=0;
		int index=0;
		for (Character c: data.toCharArray()){
			if(c==curChar)
				curCnt++;
			else {
				index=setChar(array,curChar,index,curCnt);
				curCnt=1;
				curChar=c;
			}
		}
		setChar(array,curChar,index,curCnt);	
		return String.valueOf(array);
	}
	
	private static int setChar(char[] array, char c, int index, int count){
		array[index]=c;
		index++;
		
		char[] cnt = String.valueOf(count).toCharArray();
		
		for(char x: cnt){
			array[index]=x;
			index++;
		}
		return index;
	}
	
	private static int countCompression(String data){
		char curChar = data.charAt(0);
		int curCnt=0;
		int size=0;
		for (Character c: data.toCharArray()){
			if(c==curChar)
				curCnt++;
			else {
				size+=1+String.valueOf(curCnt).length();
				curCnt=1;
				curChar=c;
			}
		}
		
		size+=1+String.valueOf(curCnt).length();
		return size;
	}

}
