package com.dsa.examples;

public interface Position<E> {
	
	E getElement() throws IllegalStateException;
}
