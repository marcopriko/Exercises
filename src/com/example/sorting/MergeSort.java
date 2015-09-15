package com.example.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MergeSort {

	public static void main(String[] args){
		List<Integer> listToSort= new ArrayList<Integer>(Arrays.asList(5,2,4,33,-3,6,1,3));
		//mergeSort(arrayList);
		List<Integer> list1= new ArrayList<Integer>(Arrays.asList(1,3,5,7));
		List<Integer> list2= new ArrayList<Integer>(Arrays.asList(2,4,6,8));
		List<Integer> sortedList = merge(list1,list2);		
		for(int i=0;i<sortedList.size();++i)
			System.out.print(sortedList.get(i)+" ");
		System.out.println();
	}

	private static void mergeSort(List<Integer> listToSort) {
		

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
