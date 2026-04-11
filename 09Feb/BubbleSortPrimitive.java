package SortingSearching;

public class BubbleSortPrimitive {
	public static void bubbleSort(int [] arr) {
		for(int i=0;i<arr.length;i++) {
			boolean isSwapped=false;
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					isSwapped=true;
				}
			}
			if(!isSwapped) {
				break;
			}
		}
	}
	public static void main(String [] args) {
		int [] arr1= {5,4,3,2,1};
		bubbleSort(arr1);
		for(int i=0;i<arr1.length;i++) {
			System.out.println(arr1[i]);
		}
	}
}
