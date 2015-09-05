package ctci.chapter1.es1_3;

import java.util.HashMap;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String str1="|«d»”’e’rs’’]";
		String str2="|«»s”’’er’d’]";
		System.out.println(isPermutation(str1,str2));
	}

	public static boolean isPermutation(String str1, String str2){
		if(str1==null || str2==null || str1.length()!=str2.length()){
			System.out.println("exit 1");
			return false;}
		HashMap<Character,Integer> map = new HashMap<Character, Integer>();
		Character cur = null;
		Integer cnt = null;
		for(int i=0;i<str1.length();++i){
			cur = str1.charAt(i);
			cnt = map.get(cur);
			if(cnt==null)
				map.put(cur,1);
			else
				map.put(cur,++cnt);
		}
		System.out.println(map.toString());
		for(int i=0;i<str2.length();++i){
			cur =str2.charAt(i);
			cnt =  map.get(cur);
			if(cnt==null){
				System.out.println("exit 2");
				return false;}
			if(cnt>1)
				map.put(cur, --cnt);
			else
				map.remove(cur);
		}
		System.out.println(map.toString());
		System.out.println("exit 3");
		return map.isEmpty();
	}
}
