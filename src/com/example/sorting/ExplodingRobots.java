package com.example.sorting;

/* Problem statement:
 * https://community.topcoder.com/stat?c=problem_statement&pm=14137
 */

public class ExplodingRobots {

	public static void main(String[] args) {
		System.out.println(canExplode(1, 0,2,0,"L"));
		System.out.println(canExplode(1, 0,2,0,"U"));
		System.out.println(canExplode(1, 0,2,0,"UL"));
		System.out.println(canExplode(3, 3,5,5,"LURLL"));
		System.out.println(canExplode(10, 5,-9,-10,"LULULULLLUULRULULULULULULLULULLULD"));
		System.out.println(canExplode(3, 3, 10, 10, "UUUUUUUUUULLLLLLLLLLRRRRRRRRRRDDDDDDDDDDUUUUUUUUUU"));
	}

	public static String canExplode(int x1, int y1, int x2, int y2, String instructions){
		if (instructions == null) return "Safe";
		int left=0,right=0,up=0,down=0;
		for(char c: instructions.toCharArray()){
			switch(c){
			case 'L': left++;break;
			case 'R': right++;break;
			case 'U': up++;break;
			case 'D': down++;break;
			}
		}



		if (x2>=x1 && y2>=y1){
			if (x1+right>=x2-left && y1+up>=y2-down)
				return "Explosion";
		}

		if (x2>=x1 && y2<=y1){
			if (x1+right>=x2-left && y1-down<=y2+up)
				return "Explosion";
		}

		if (x2<=x1 && y2<=y1){
			if (x1-left<=x2+right && y1-down<=y2+up)
				return "Explosion";
		}

		if (x2<=x1 && y2>=y1){
			if (x1-left<=x2+right && y1+up>=y2-down)
				return "Explosion";
		}
		return "Safe";
	}


	//	private static Rectangle maxPosRect(int x, int y, String instructions){
	//
	//		int numOfUs = 0,numOfLs= 0,numOfRs= 0,numOfDs= 0;
	//
	//		if (instructions == null) return null;
	//
	//		char[] instr = instructions.toCharArray();
	//		for (int i=0; i< instr.length;++i){
	//			switch(instr[i]){
	//			case 'U': numOfUs++;
	//			break;
	//			case 'L': numOfLs++;
	//			break;
	//			case 'R': numOfRs++;
	//			break;
	//			case 'D': numOfDs++;
	//			break;
	//			default:  return null;
	//			}
	//		}
	//		return new Rectangle(x-numOfLs-1,y+numOfUs-1,numOfLs+numOfRs+2,numOfUs+numOfDs+2);
	//		//System.out.println("numOfUs = "+numOfUs+" numOfLs = "+numOfLs+" numOfRs = "+numOfRs+" numOfDs = "+numOfDs);
	//
	//	}

}
