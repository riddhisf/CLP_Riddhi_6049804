package Arrays;

public class MatrixMultiplication {
	public static void main(String [] args) {
		int n=3;
		int m=2;
		int [][] arr1=Array.input(n, m);
		
		int s=2;
		int t=4;
		int [][] arr2=Array.input(s,t);
		
		int [][] arr3= new int[n][t];
		
		//multiplication
		for (int i=0; i<n; i++) {
			for (int j=0; j<t; j++) {
				for (int k=0; k<m; k++) {
					arr3[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}
		
		Array.output(arr3, n, m);
	}

}
