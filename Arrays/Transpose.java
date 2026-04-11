package Arrays;

public class Transpose {
	public static void main(String [] args) {
		int n=2;
		int m=3;
		int[][] arr= Array.input(n, m);
		int [][] transpose=new int[m][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				transpose[j][i]=arr[i][j];
			}
		}
		
		Array.output(transpose, m, n);
	}

}
