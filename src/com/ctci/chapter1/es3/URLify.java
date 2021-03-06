package com.ctci.chapter1.es3;

public class URLify {

	public static void main(String[] args) {
		char [] chrArr = new String("Mr John Smith             ").toCharArray();
		replaceSpaces(chrArr, 13);
		String strString = String.valueOf(chrArr);
		System.out.println(strString);

	}

	public static String replaceSpaces1(String data, int trueLength){ // O(n^2)
		if (trueLength==0) return data;
		StringBuilder buf = new StringBuilder();
		char[] str=data.toCharArray();
		for(int i=0;i<trueLength;i++){
			if(str[i]!=' '){
				buf.append(str[i]);
			}
			else{
				buf.append("%20");
			}
		}
		return buf.toString();
	}

	public static String replaceSpaces2(String data, int trueLength){ // bad implementaton O(n^2)
		if (trueLength==0) return "";
		char[] str=data.toCharArray();
		for(int i=0;i<trueLength;i++){
			if(str[i]==' '){
				for(int j=str.length-3;j>i;j--){
					str[j+2]=str[j];
				}
				str[i]='%';
				str[i+1]='2';
				str[i+2]='0';
				i+=2;
				trueLength+=2;
			}

		}
		return String.copyValueOf(str, 0, trueLength);
	}

	public static String replaceSpaces3(String data, int trueLength){ // Solution O(n)
		if (trueLength==0) return "";
		char[] str=data.toCharArray();
		int spaceCnt = 0;
		int newLength;
		for(int i=0;i<trueLength;i++){
			if(str[i]==' '){
				spaceCnt++;
			}
		}
		newLength=trueLength+2*spaceCnt;
		str[newLength] = '\0';
		int j = newLength;
		for(int i=trueLength-1;i>=0;i--){
			if(str[i]==' '){
				str[j-1]='0';
				str[j-2]='2';
				str[j-3]='%';
				j-=3;
			} else {
				str[j-1]=str[i];
				j--;
			}
		}
		return String.copyValueOf(str,0,newLength);
	}

	public static void replaceSpaces(char [] str, int trueLength){
		if(str==null || str.length == 0 || trueLength == 0) return;
		int spacesCnt = 0, index;
		for (int i=0; i<trueLength; i++){
			if(str[i] == ' ')
				spacesCnt++;
		}

		index = trueLength + 2*spacesCnt;
		//str[index] = '\0';
		for(int i=trueLength-1; i>=0; i--){
			if(str[i] == ' '){
				str[index-1]='0';
				str[index-2]='2';
				str[index-3]='%';
				index-=3;
			} else {
				str[index-1]=str[i];
				index--;
			}
		}
	}
}
