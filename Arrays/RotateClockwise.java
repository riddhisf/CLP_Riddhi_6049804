package Arrays;

public class RotateClockwise {
	public static void main(String [] args) {
		int n=3;
		int m=3;
		int [][] arr=Array.input(n,m);
		
		//rotate clockwise
		
		//s1:transpose
		int [][] transpose=new int[m][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				transpose[j][i]=arr[i][j];
			}
		}
		
		//s2:flip rows
		int[][] flipped = new int[m][n];
		for (int i=0;i<m; i++) {
			for (int j=0; j<n; j++) {
				flipped[i][j] = transpose[i][n-j-1];
			}
		}
		
		Array.output(flipped, m, n);
	}

}


