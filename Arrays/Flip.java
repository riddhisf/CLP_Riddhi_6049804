package Arrays;

public class Flip {
	public static void main(String[] args) {
		int n = 2;
		int m = 3;

		int[][] arr = Array.input(n, m);
		int[][] flipped = new int[n][m];

		// vertical flip
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				flipped[i][j] = arr[i][m-j-1];
			}
		}

		Array.output(flipped, n, m);
		
		// horizontal flip
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				flipped[i][j] = arr[n-i-1][j];
			}
		}

		Array.output(flipped, n, m);
	}
}
