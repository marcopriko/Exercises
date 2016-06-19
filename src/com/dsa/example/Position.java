package com.dsa.example;

public interface Position<E> {
	
	E getElement() throws IllegalStateException;
}
