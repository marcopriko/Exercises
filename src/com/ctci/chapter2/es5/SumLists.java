package com.ctci.chapter2.es5;

import com.ctci.chapter2.LLN;

public class SumLists {

	public static void main(String[] args) {
		LLN xNode = new LLN(7,null);
		xNode.appendToTail(1);
		xNode.appendToTail(6);
		LLN yNode = new LLN(5,null);
		yNode.appendToTail(9);
		yNode.appendToTail(2);
		
		xNode.print();
		yNode.print();
		LLN sum = add(xNode,yNode);
		sum.print();

	}

	
	public static LLN add(LLN xNode, LLN yNode){
		int carry = 0;
		LLN result = null;
		LLN cur = null;
		LLN xCur = xNode;
		LLN yCur = yNode;
		
		while(xCur!=null && yCur!=null){
			int digit = (xCur.data + yCur.data + carry) % 10 ;
			carry = (xCur.data + yCur.data + carry) / 10;
			LLN newNode = new LLN(digit, null);
			if(result == null){
				result = newNode;
				cur = result;
			}
			else{
				cur.next = newNode;
				cur = cur.next;
			}
			xCur = xCur.next;
			yCur = yCur.next;
		}
		
		while(xCur!=null){
			int digit = (xCur.data + carry) % 10 ;
			carry = (xCur.data + carry) / 10;
			LLN newNode = new LLN(digit, null);
			if(result == null){
				result = newNode;
				cur = result;
			}
			else{
				cur.next = newNode;
				cur = cur.next;
			}
			xCur = xCur.next;
		}
		
		while(yCur!=null){
			int digit = (yCur.data + carry) % 10;
			carry = (yCur.data + carry) / 10;
			LLN newNode = new LLN(digit, null);
			if(result == null){
				result = newNode;
				cur = result;
			}
			else{
				cur.next = newNode;
				cur = cur.next;
			}
			yCur = yCur.next;
		}
		
		if(carry!=0){
			LLN newNode = new LLN(carry, null);
			cur.next = newNode;
			cur = cur.next;
		}
		return result;
	}
	
	
	
}
