package SortingSearching;

public class SelectionSortTotalMarks {
	public static void selectionSort(Student [] arr) {
		for(int i=0;i<arr.length;i++) {
			int min= i;
			for(int j=i;j<arr.length;j++) {
				if(arr[min].getMarks()<arr[j].getMarks()) {
					min=j;
				}
			}
			Student temp=arr[min];
			arr[min]=arr[i];
			arr[i]=temp;
		}
	}
	public static void main(String [] args) {
		Student [] arr2= {
				new Student("A",45,30,56,2),
				new Student("B",45,30,59,3),
				new Student("C",95,91,80,1),
				new Student("D",13,15,19,4),
				new Student("E",54,30,40,5),
				new Student("F",43,45,55,6),
		};
		selectionSort(arr2);
		for(int i=0;i<arr2.length;i++) {
			System.out.println(arr2[i]);
		}
	}
}
