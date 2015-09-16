package com.example.sorting;

import java.util.List;
import java.util.Random;

public class InsertionSort {	


	public static void main(String[] args){
		/*int[] array={5,2,4,33,-3,6,1,3};
		insertionSort2(array);
		for(int i=0;i<array.length;++i)
			System.out.print(array[i]+" ");
		System.out.println();*/
		Random random = new Random();
		int [] array = new int[400000];
		for(int i=0;i<array.length;++i){
			array[i]=random.nextInt(400000);
		}
		long start = System.currentTimeMillis();
		insertionSort2(array);
		System.out.println(System.currentTimeMillis()-start);

	}
	
	public static void insertionSort2(int[] arr){
		for(int j=1;j<arr.length;++j){
			int key=arr[j];
			int i=j-1;
			while(i>=0 && arr[i]>key){
				arr[i+1]=arr[i];
				--i;
			}
			arr[i+1]=key;
		}
	}
	
	
	public static void insertionSort(int[] arr){
		for(int j=1; j<arr.length;++j){
			for(int i=j-1;i>=0;--i){
				if(arr[i]>arr[i+1]){
					int tmp=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=tmp;
				}
			}
		}
	}
	 
}
