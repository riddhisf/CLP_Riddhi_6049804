package Arrays;
import java.util.*;

public class Array{
	static Scanner sc= new Scanner(System.in);
	
	//input
	public static int[][] input(int n,int m) {
		int [][] arr1= new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr1[i][j]=sc.nextInt();
			}
		}
		return arr1;
	}
	
	//output
	public static void output(int[][] arr,int n,int m) {

		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
