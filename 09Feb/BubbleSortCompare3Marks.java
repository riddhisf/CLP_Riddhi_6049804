package SortingSearching;

public class BubbleSortCompare3Marks {
	public static void compBubbleSort(Student [] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if (
				        arr[j].getJavaMarks() < arr[j + 1].getJavaMarks() ||

				        (arr[j].getJavaMarks() == arr[j + 1].getJavaMarks() &&
				         arr[j].getFsMarks() < arr[j + 1].getFsMarks()) ||

				        (arr[j].getJavaMarks() == arr[j + 1].getJavaMarks() &&
				         arr[j].getFsMarks() == arr[j + 1].getFsMarks() &&
				         arr[j].getCMarks() < arr[j + 1].getCMarks())
				    ) {
				        Student temp = arr[j];
				        arr[j] = arr[j + 1];
				        arr[j + 1] = temp;
				  }
			}
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
		compBubbleSort(arr3);
		for(int i=0;i<arr3.length;i++) {
			System.out.println(arr3[i]);
		}
	}

}
