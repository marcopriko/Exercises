package com.ctci.chapter2.es6;

import java.util.Stack;

import com.ctci.chapter2.LLN;

public class Palindrome {

	public static void main(String[] args) {
		LLN list = new LLN(0,null,null);
		list.appendToTail(1);
		list.appendToTail(2);
		list.appendToTail(3);
		list.appendToTail(4);
		list.appendToTail(5);
		list.appendToTail(5);
		list.appendToTail(4);
		list.appendToTail(3);
		list.appendToTail(2);
		list.appendToTail(1);
		list.appendToTail(0);

		list.print();

		System.out.println(isPalindrome3(list));

	}

	public static boolean isPalindrome(LLN head){
		LLN reversed = reverseAndClone(head);
		reversed.print();
		return isEqual(head, reversed);
	}

	private static LLN reverseAndClone(LLN node){
		LLN newNode = null;
		LLN nextNode = null;
		while(node!=null){
			newNode = new LLN(node.data, null);
			newNode.next = nextNode;
			nextNode = newNode;
			node = node.next;
		}
		return newNode;
	}

	private static boolean isEqual(LLN node1, LLN node2){
		while(node1!=null && node2!=null){
			if(node1.data!=node2.data)
				return false;
			node1 = node1.next;
			node2 = node2.next;
		}
		if(node1!=node2)
			return false;
		return true;
	}

	public static boolean isPalindrome2(LLN head){
		LLN slow = head;
		LLN fast = head;
		Stack<Integer> stack = new Stack<>();

		while(fast!=null && fast.next!=null){
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}

		if(fast!=null)
			slow = slow.next;

		while(slow!=null){
			if(slow.data!=stack.pop())
				return false;
			slow = slow.next;
		}
		return true;
	}


	public static boolean isPalindrome3(LLN head){
		int length = lengthOfList(head);
		Result p = isPalindromeRecurse(head, length);
		return p.result;
	}

	private static Result isPalindromeRecurse(LLN head, int length){
		if(head==null || length <=0){
			return new Result(head, true);
		} else if (length == 1){
			return new Result(head.next, true);
		}

		Result res = isPalindromeRecurse(head.next, length - 2);

		if(!res.result || res.node == null)
			return res;

		res.result = (head.data == res.node.data);

		res.node = res.node.next;
		return res;
	}

	private static int lengthOfList(LLN node){
		int length = 0;
		while(node!=null){
			length++;
			node = node.next;
		}
		return length;
	}

	private static class Result{
		public boolean result;
		public LLN node;
		public Result(LLN node, boolean result){
			this.node = node;
			this.result = result;
		}
	}

}


