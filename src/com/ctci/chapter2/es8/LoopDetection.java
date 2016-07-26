package com.ctci.chapter2.es8;

import com.ctci.chapter2.LLN;

public class LoopDetection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static LLN FindBeginning(LLN head){
		LLN slow = head;
		LLN fast = head;

		while(fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				break;
		}

		if(fast==null || fast.next==null)
			return null;

		slow = head;

		while(slow!=fast){
			slow = slow.next;
			fast = fast.next;
		}
		return fast;
		
	}



}
