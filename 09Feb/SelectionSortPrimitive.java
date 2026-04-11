package SortingSearching;

public class SelectionSortPrimitive {
	
	public static void selectionSort(int [] arr) {
		for(int i=0;i<arr.length;i++) {
			int min= i;
			for(int j=i;j<arr.length;j++) {
				if(arr[min]>arr[j]) {
					min=j;
				}
			}
			int temp=arr[min];
			arr[min]=arr[i];
			arr[i]=temp;
		}
	}
	public static void main(String [] args) {
		int [] arr1= {5,4,3,2,1};
		selectionSort(arr1);
		for(int i=0;i<arr1.length;i++) {
			System.out.println(arr1[i]);
		}
	}

}
