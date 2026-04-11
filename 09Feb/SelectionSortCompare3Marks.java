package SortingSearching;

public class SelectionSortCompare3Marks {
	public static void selectionSort(Student [] arr) {
		for(int i=0;i<arr.length;i++) {
			int min= i;
			for(int j=i;j<arr.length;j++) {
				if(
						arr[j].getJavaMarks() > arr[min].getJavaMarks() ||

				        (arr[j].getJavaMarks() == arr[min].getJavaMarks() &&
				         arr[j].getFsMarks() > arr[min].getFsMarks()) ||

				        (arr[j].getJavaMarks() == arr[min].getJavaMarks() &&
				         arr[j].getFsMarks() == arr[min].getFsMarks() &&
				         arr[j].getCMarks() > arr[min].getCMarks())
				  ) {
					min=j;
				}
			}
			Student temp=arr[min];
			arr[min]=arr[i];
			arr[i]=temp;
		}
	}
	
	public static void main(String [] args) {
		Student [] arr3= {
				new Student("A",45,30,56,2),
				new Student("B",45,30,59,3),
				new Student("C",95,91,80,1),
				new Student("D",13,15,19,4),
				new Student("E",54,30,40,5),
				new Student("F",43,45,55,6),
		};
		selectionSort(arr3);
		for(int i=0;i<arr3.length;i++) {
			System.out.println(arr3[i]);
		}
	}


}
