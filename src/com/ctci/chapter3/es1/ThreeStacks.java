package com.ctci.chapter3.es1;


public class ThreeStacks<T>{

	T[] array;
	int capacity;
	int idx1 = 0;
	int idx2 = 1;
	int idx3 = 2;

	int size1 = 0;
	int size2 = 0;
	int size3 = 0;

	public ThreeStacks(int capacity){
		array = (T[]) new Object[capacity];
		this.capacity = capacity;
	}

	public void push1(T item){
		makeRoom(idx1);
		idx2 = (idx2 + 1) % capacity;
		idx3 = (idx3 + 1) % capacity;
		array[(idx1 + 1) % capacity] = item;
		idx1 = (idx1 + 1) % capacity;
		size1++;
	}

	public void push2(T item){
		makeRoom(idx2);
		idx3 = (idx3 + 1) % capacity;
		array[(idx2 + 1) % capacity] = item;
		idx2 = (idx2 + 1) % capacity;
		size2++;
	}

	private void makeRoom(int index){
		if(size1+size2+size3 >= capacity) throw new IllegalStateException();
		T temp = null;
		T buf  = array[index];
		for(int i = (index + 1)%capacity; i == idx3; i=((i+1) % capacity)){
			temp = array[(index + 1)%capacity];
			array[(index + 1)%capacity] = buf;
			buf = temp;
		} 
	}

	public String toString(){
		StringBuilder buf = new StringBuilder();
		for(int i = 0; i < array.length; i++){		
			buf.append((array[i] != null ? array[i].toString() : "null") +"\t");
		}
		return buf.toString();
	}

}