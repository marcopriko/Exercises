package com.example.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MergeSort {

	public static void main(String[] args){
		/*List<Integer> listToSort = new ArrayList<Integer>();//= Arrays.asList(5,2,4,33,-3,6,1,3,-63);	
		Random random = new Random();
		
		for(int i=0;i<100;++i){
			listToSort.add(random.nextInt(400000000));
		}
		//mergeSort(arrayList);
		//List<Integer> list1= Arrays.asList(1,3,5,7);
		//List<Integer> list2= Arrays.asList(2,4,6,8);
		//List<Integer> sortedList = merge(list1,list2);	
		long start = System.nanoTime();
		List<Integer> sortedList = mergeSort(listToSort);
		System.out.println(System.nanoTime()-start);
		//List<Integer> sortedList = listToSort;
		for(int i=0;i<sortedList.size();++i)
			System.out.print(sortedList.get(i)+" ");
		System.out.println();
		*/
		
		Random random = new Random();
		Integer [] array = new Integer[400000];
		for(int i=0;i<array.length;++i){
			array[i]=random.nextInt(400000);
		}
		List<Integer> listToSort = Arrays.asList(array);	
		long start = System.currentTimeMillis();
		mergeSort(listToSort);
		System.out.println(System.currentTimeMillis()-start);
	}

	private static List<Integer> mergeSort(List<Integer> listToSort) {
		if(listToSort.size()<=1)
			return listToSort;
		int splitIndex=listToSort.size()/2;
		List<Integer> leftList = listToSort.subList(0, splitIndex);
		List<Integer> rightList = listToSort.subList(splitIndex, listToSort.size());
		return merge(mergeSort(leftList),mergeSort(rightList));

	}

	private static List<Integer> merge(List<Integer> leftList, List<Integer> rightList) {

		int i = 0;
		int j = 0;

		List<Integer> mergedList = new ArrayList<Integer>();

		while(i<leftList.size() && j<rightList.size()){
			if(leftList.get(i)<=rightList.get(j)){
				mergedList.add(leftList.get(i));
				i++;
			} else {
				mergedList.add(rightList.get(j));
				j++;			
			}
		}

		while(i<leftList.size()){
			mergedList.add(leftList.get(i));
			i++;
		}

		while(j<rightList.size()){
			mergedList.add(rightList.get(j));
			j++;
		}
		
		return mergedList;
	}

}
