package com.ctci.chapter1.es8;

public class SetZerosMatrix {

	public static void main(String[] args) {
		int[][] matrix = {{13,14,15,16},{9,10,11,12},{5,6,7,8},{1,2,3,4}};
		setZeros(matrix);
		for(int j=0;j<matrix.length;j++){
			for(int i=0;i<matrix[j].length;i++){
				System.out.print(matrix[j][i]+"   ");
			}
			System.out.println();
		}
	}

	private static void setZeros(int[][] matrix) {
		if(!isMatrixRect(matrix)) 
			throw new IllegalArgumentException("Matrix is not rectangular");
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[] rows = new boolean[m];
		boolean[] cols = new boolean[n];
		for(int j=0;j<m;++j){
			for(int i=0;i<n;++i){
				if(matrix[j][i]==0){
					rows[j]=true;
					cols[i]=true;
				}
			}	
		}
		for(int i=0;i<n;++i){
			if(cols[i]){
				for(int j=0;j<m;++j){
					matrix[j][i]=0;
				}
			}
		}
		for(int j=0;j<m;++j){
			if(rows[j]){
				for(int i=0;i<n;++i){
					matrix[j][i]=0;
				}
			}
		}

	}

	private static boolean isMatrixRect(int[][] matrix){
		int n = matrix[0].length;
		for(int i=1;i<matrix.length;i++){
			if(matrix[i].length!=n)
				return false;
		}
		return true;
	}
}
