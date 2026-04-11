package SortingSearching;

public class InsertionSortCompare3Marks {
	public static void insertionSort(Student [] arr) {
		for(int i=1;i<arr.length;i++) {
			Student key=arr[i];
			int j=i-1;
			while(j>=0 && (
			        arr[j].getJavaMarks() < key.getJavaMarks() ||

			        (arr[j].getJavaMarks() == key.getJavaMarks() &&
			         arr[j].getFsMarks() < key.getFsMarks()) ||

			        (arr[j].getJavaMarks() == key.getJavaMarks() &&
			         arr[j].getFsMarks() == key.getFsMarks() &&
			         arr[j].getCMarks() < key.getCMarks())
			    ) ) {
				
				arr[j+1]=arr[j];
				j--; 
			}
			arr[j+1]=key;
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
		insertionSort(arr3);
		for(int i=0;i<arr3.length;i++) {
			System.out.println(arr3[i]);
		}
	}

}