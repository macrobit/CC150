package chapter1;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees.
 **/

/*
 * For a nxn matrix, there are n^2 pixels. Each pixel can be regarded as an object.
If we use a 2 dimension array to implement this matrix, the rotation works like:
	for i = 0 to n  // If there are n elements in a row, we only need to rotate n-1 row.
	tmp = A(0, 0 + i);
	A(0, 0+i) = A(n-i, 0);
	A(n-i, 0) = A(n, n-i);
	A(n, n-i) = A(0+i,n);
	A(0+i, n) = tmp;
*/
	

public class Q6 {
	//Method 1: rotate layer by layer.
	private class Pixel{
		int value;
		public Pixel(int value){
			this.value = value;
		}
	}
		
	public void setMatrix(Pixel[][] matrix, int n) {

		for(int i = 0; i < n; i++) {
			int num = 1;
			for(int j = 0; j < n; j++) {
				matrix[i][j] = new Pixel(num);
				num++;
			}
		}
	}
	
	public void printMatrix(Pixel[][] matrix) {
		int n = matrix[0].length;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.printf("%-3d", matrix[i][j].value);
			}
			System.out.printf("\n");
		}
	}
	
	public void rotate(Pixel[][] matrix) {
		int n = matrix[0].length;
//		System.out.println("The n is: " + n);
		for(int layer = 0; layer < n/2; layer++) {
			int first = layer;
			int last = n-1-layer; // last is the index of last element
			for(int i = first; i < last; i++){ // no need to rotate last one
				// offset is very important!!!
				int offset = i - first;
				
				// save top
				Pixel tmp = matrix[first][first + offset];
				
				// left -> top
				matrix[first][first + offset] = matrix[last - offset][first];
				
				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];
				
				// right -> bottom
				matrix[last][last - offset] = matrix[first + offset][last];
				
				// top -> right
				matrix[first + offset][last] = tmp;
//				System.out.println("" + matrix[0][0].value);
			}
		}
	}
	
	public static void main(String[] args) {
		int n = 5;
		Pixel[][] matrix = new Pixel[n][n];	
		
		Q6 test = new Q6();
		test.setMatrix(matrix, n);
		test.printMatrix(matrix);
		System.out.println();
		test.rotate(matrix);
		test.printMatrix(matrix);
		
	}
}
