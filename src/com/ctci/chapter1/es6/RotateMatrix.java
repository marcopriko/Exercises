package com.ctci.chapter1.es6;

public class RotateMatrix {

	public static void main(String[] args) {
		int[][] matrix = {{13,14,15,16},{9,10,11,12},{5,6,7,8},{1,2,3,4}};
		rotate(matrix);
		//myRotate(matrix);
		for(int j=0;j<matrix.length;j++){
			for(int i=0;i<matrix[j].length;i++){
				System.out.print(matrix[j][i]+"   ");
			}
			System.out.println();
		}
	}

	public static void rotate(int[][] matrix){ // Solution  O(n^2)
		if(matrix==null) 
			throw new IllegalArgumentException("Matrix is null");
		if(!isMatrixSquared(matrix))
			throw new IllegalArgumentException("Matrix is not squared");

		int size=matrix.length;

		for(int layer=0;layer<size/2;++layer){
			int minIdx=layer;
			int maxIdx=size-1-layer;

			for(int i=minIdx;i<maxIdx;++i){
				int offset=i-minIdx;

				int top = matrix[minIdx][i];

				matrix[minIdx][i]=matrix[maxIdx-offset][minIdx];

				matrix[maxIdx-offset][minIdx]=matrix[maxIdx][maxIdx-offset];

				matrix[maxIdx][maxIdx-offset] = matrix[i][maxIdx];

				matrix[i][maxIdx] = top;
			}
		}
	}








	// my bad implementation O(n^3)

	private static void myRotate(int[][] matrix){ 
		if(matrix==null) 
			throw new NullPointerException("Matrix is null");
		if(!isMatrixSquared(matrix))
			throw new IllegalArgumentException("Matrix is not squared");
		if(matrix.length%2==0){
			for(int size=2;size<=matrix.length;size+=2){
				rotateRing(matrix,size);
			}
		} else {
			for(int size=1;size<=matrix.length;size+=2){
				rotateRing(matrix,size);
			}
		}
	}

	private static void rotateRing(int[][] matrix, int size){

		if (size<1 || size>matrix.length) 
			throw new IllegalArgumentException("Invalid size");
		if (size==1) 
			return;


		int minIdx = (matrix.length/2)-(size/2);
		int maxIdx = (size%2==0) ? (matrix.length/2)+(size/2)-1 : (matrix.length/2)+(size/2);
		for(int k=1;k<=size-1;k++){
			int cellVal=matrix[minIdx][minIdx];
			int temp;
			for(int i=minIdx;i<maxIdx;i++){
				temp = cellVal;
				cellVal=matrix[minIdx][i+1];
				matrix[minIdx][i+1]=temp;			
			}
			for(int j=minIdx;j<maxIdx;j++){
				temp = cellVal;
				cellVal=matrix[j+1][maxIdx];
				matrix[j+1][maxIdx]=temp;			
			}
			for(int i=maxIdx;i>minIdx;i--){
				temp = cellVal;
				cellVal=matrix[maxIdx][i-1];
				matrix[maxIdx][i-1]=temp;			
			}
			for(int j=maxIdx;j>minIdx;j--){
				temp = cellVal;
				cellVal=matrix[j-1][minIdx];
				matrix[j-1][minIdx]=temp;			
			}
		}
	}


	private static boolean isMatrixSquared(int[][] matrix){
		int height = matrix.length;
		for(int i=0;i<height;i++){
			if(matrix[i].length!=height)
				return false;
		}
		return true;
	}


}
