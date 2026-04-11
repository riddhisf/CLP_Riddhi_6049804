package SortingSearching;

public class BubbleSortTotalMarks {
	public static void bubbleSort(Student [] arr) {
		for(int i=0;i<arr.length;i++) {
			boolean isSwapped=false;
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j].getMarks()<arr[j+1].getMarks()) {
					Student temp=arr[j];
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
		Student [] arr2= {
				new Student("A",45,30,56,2),
				new Student("B",45,30,59,3),
				new Student("C",95,91,80,1),
				new Student("D",13,15,19,4),
				new Student("E",54,30,40,5),
				new Student("F",43,45,55,6),
		};
		bubbleSort(arr2);
		for(int i=0;i<arr2.length;i++) {
			System.out.println(arr2[i]);
		}
	}
}
