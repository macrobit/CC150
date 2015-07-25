package chapter1;

/*
 * If an element in an MxN matrix is 0, its entire row and column are set to 0.
*/

import java.util.Arrays;

public class Q7 {
	public void setZeros(int[][] matrix) {
		// get the number of rows and columns
		int m = matrix.length;
		int n = matrix[0].length;
		
		// create two mark arrays for row and column
		int[] x = new int[m];
		Arrays.fill(x, 1);
		int[] y = new int[n];
		Arrays.fill(y, 1);
		
		// iterate every element in the matrix
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(matrix[i][j] == 0) {
					if(x[i] != 0) x[i] = 0;
					if(y[j] != 0) y[j] = 0;					
				}			
			}
		}
		
		// change the matrix according to record
		for(int i = 0; i < m; i++) {
			if(x[i] == 0) {
				for(int j = 0; j < n; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		
		for(int j = 0; j < n; j++) {
			if(y[j] == 0) {
				for(int i = 0; i < m; i++) {
					matrix[i][j] = 0;
				}
			}
		}		
	}
	
	// method 2: O(1) space
	public void setZeros2(int[][] matrix) {
		int rows = matrix.length;
		int columns = matrix[0].length;
		boolean rowHasZero = false;
		boolean columnHasZero = false;
		
		// check whether the first column has a zero
		for(int i = 0; i < rows; i++) {
			if(matrix[i][0] == 0 && !columnHasZero) 
				columnHasZero = true;
		}
		
		// check whether the first row has a zero
		for(int j = 0; j < columns; j++) {
			if(matrix[0][j] == 0 && !rowHasZero)
				rowHasZero = true;
		}
		
		// iterate the rest of matrix. 
		// If matrix[i][j]=0, matrix[i][0] = 0 and matrix[0][j] = 0
		for(int i = 1; i < rows; i++) {
			for(int j = 1; j < columns; j++) {
				if(matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		// nullifying row i if there's zero in matrix[i][0]
		for(int i = 0; i < rows; i++) {
			if(matrix[i][0] == 0) {
				nullifyRow(matrix, i);
			}			
		}
		
		// nullifying column j if there's zero in matrix[0][j]
		for(int j = 0; j < columns; j++) {
			if(matrix[0][j] == 0) {
				nullifyColumn(matrix, j);
			}
		}
		
		// nullify the first row and column
		if(rowHasZero) {
			nullifyRow(matrix,0);
		}
		
		if(columnHasZero) {
			nullifyColumn(matrix, 0);
		}
	}
	
	// nullify method
	public void nullifyRow(int[][] matrix, int row) {
		int columns = matrix[0].length;
		for(int j = 0; j < columns; j++) {
			matrix[row][j] = 0;
		}
	}
	
	public void nullifyColumn(int[][] matrix, int column) {
		int rows = matrix.length;
		for(int i = 0; i < rows; i++) {
			matrix[i][column] = 0;
		}	
	}
	
	// the method to print out a matrix.
	public void printMatrix(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				System.out.printf("%-3d", matrix[i][j]);
			}
			System.out.printf("\n");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[][] matrix = {
				{2,1,0,3},
				{1,2,3,4},
				{1,0,2,3},
				{4,1,0,6}
		};
		
		Q7 test = new Q7();
		test.printMatrix(matrix);
		test.setZeros2(matrix);
		test.printMatrix(matrix);
			
	}
}
