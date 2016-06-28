package com.ctci.chapter2;

public class LLN{
	public int data;
	public LLN next, prev;

	public LLN(int d, LLN n, LLN p){
		data = d;
		setNext(n);
		setPrev(p);
	}

	public void setNext(LLN n){
		next = n;
		if(n!=null && n.prev!=this)
			n.setPrev(this);
	}

	public void setPrev(LLN p){
		prev=p;
		if(p!=null && p.next!=this)
			p.setNext(this);
	}

	public LLN appendToTail(int d){
		LLN newLast = new LLN(d,null,null);
		LLN cur=this;
		while(cur.next!=null){
			cur=cur.next;
		}
		cur.setNext(newLast);
		return newLast;
	}
	public LLN clone(){
		LLN next2 = null;
		if(this.next!=null)
			next2=next.clone();
		LLN head2 = new LLN(data, next2, null);
		return head2;
	}

	public int hashCode(){
		int h=0;
		LLN cur=this;
		while(cur!=null){
			h^=cur.data;
			h= (h << 5) | (h >>> 27);
			cur=cur.next;
		}
		return h;	
	}

	public void print(){
		LLN cur = this;
		StringBuilder buff = new StringBuilder();
		while(cur!=null){
			buff.append(" " + cur.data + " ");
			cur=cur.next;
		}
		System.out.println(buff.toString());
	}
}