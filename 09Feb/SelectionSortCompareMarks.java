package SortingSearching;

public class SelectionSortCompareMarks {
	public static void selectionSort(Student2[] arr) {
        for (int i = 0; i < arr.length; i++) {
        	int min=i;
        	for(int j=i;j<arr.length;j++) {
	            if (ifSwap(arr[j], arr[min])) {
	            	min=j;
	            }
        	}
        	Student2 temp=arr[min];
			arr[min]=arr[i];
			arr[i]=temp;
        }
	}

    private static boolean ifSwap(Student2 s1, Student2 s2) {
        int[] m1 = s1.getMarks();
        int[] m2 = s2.getMarks();

        int len = Math.min(m1.length, m2.length);

        for (int i = 0; i < len; i++) {
            if (m1[i] > m2[i]) return true;
            if (m1[i] < m2[i]) return false;
        }
        return false;
    }

    public static void main(String[] args) {
        Student2[] arr = {
            new Student2("A", 1, new int[]{45, 30, 56, 55, 44}),
            new Student2("B", 2, new int[]{45, 30, 56, 56, 44}),
            new Student2("C", 3, new int[]{95, 91, 80, 78, 88}),
            new Student2("D", 4, new int[]{13, 15, 19, 21, 23}),
            new Student2("E", 5, new int[]{54, 30, 40, 55, 44})
        };

        selectionSort(arr);

        for (Student2 s : arr) {
            System.out.println(s);
        }
    }
}