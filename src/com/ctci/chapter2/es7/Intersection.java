package com.ctci.chapter2.es7;

import java.util.HashSet;

import com.ctci.chapter2.LLN;

public class Intersection {

	public static void main(String[] args) {
		LLN head1 = new LLN(0,null,null);
		head1.appendToTail(1);
		head1.appendToTail(2);
		head1.appendToTail(3);
		head1.appendToTail(4);
		head1.appendToTail(5);
		LLN intersect = head1.appendToTail(6);		
		head1.appendToTail(7);
		head1.appendToTail(8);
		head1.appendToTail(9);
		head1.appendToTail(10);
		head1.appendToTail(11);

		head1.print();

		LLN head2 = new LLN(20,null,null);
		head2.appendToTail(21);
		head2.appendToTail(22);

		LLN cur = head2;
		while(cur.next!=null){
			cur = cur.next;
		}
		cur.next = intersect;
		head2.print();


		System.out.println(intersection3(head1,head2).data);

	}

	public static LLN intersection(LLN node1, LLN node2){
		HashSet<LLN> set = new HashSet<>();
		while(node1!=null){
			set.add(node1);
			node1 = node1.next;
		}
		while(node2!=null){
			if(set.contains(node2))
				return node2;
			node2 = node2.next;
		}
		return null;
	}

	public static LLN intersection2(LLN head1, LLN head2){
		LLN cur1 = head1;
		while(cur1!=null){
			LLN cur2 = head2;
			while(cur2!=null){
				if(cur1==cur2)
					return cur2;
				cur2 = cur2.next;
			}
			cur1 = cur1.next;
		}
		return null;
	}

	public static LLN intersection3(LLN head1, LLN head2){
		LLN node1 = head1;
		LLN node2 = head2;

		int length1 = 0;
		int length2 = 0;
		while(node1!=null){
			length1++;
			node1 = node1.next;
		}
		while(node2!=null){
			length2++;
			node2 = node2.next;
		}
		
		LLN longest = length1 >= length2 ? head1 : head2;
		LLN shortest = length1 >= length2 ? head2 : head1;
		
		int diff = Math.abs(length1 - length2);

		while(diff!=0){
			longest = longest.next;
			diff--;
		}
		
		while(longest!=null){
			if(longest==shortest) 
				return longest;
			longest = longest.next;
			shortest = shortest.next;
		}
		return null;
		
	}
}
