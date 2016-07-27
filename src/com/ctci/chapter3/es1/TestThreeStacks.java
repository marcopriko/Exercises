package com.ctci.chapter3.es1;

public class TestThreeStacks {

	public static void main(String[] args) {
		ThreeStacks<Integer> stacks = new ThreeStacks<>(10);
		System.out.println(stacks);
		stacks.push1(1);
		stacks.push1(2);
		stacks.push2(3);
		stacks.push2(4);
		stacks.push1(5);
		stacks.push1(6);
		stacks.push2(7);
//		stacks.push2(6);
//		stacks.push1(5);
//		stacks.push2(6);
		System.out.println(stacks);

	}

}
