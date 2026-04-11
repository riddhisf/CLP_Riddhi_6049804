package SortingSearching;

public class BubbleSortCompareMarks {
	
   public static void bubbleSort(Student2[] arr, int n) {
        if (n == 1) return;
        boolean isSwapped=false;
        for (int i = 0; i < n - 1; i++) {
            if (ifSwap(arr[i], arr[i + 1])) {
                Student2 temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                isSwapped=true;
            }
        }
        if(!isSwapped) {
        	return;
        }

        bubbleSort(arr, n - 1);
    }

    private static boolean ifSwap(Student2 s1, Student2 s2) {
        int[] m1 = s1.getMarks();
        int[] m2 = s2.getMarks();

        int len = Math.min(m1.length, m2.length);

        for (int i = 0; i < len; i++) {
            if (m1[i] < m2[i]) return true;
            if (m1[i] > m2[i]) return false;
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

        bubbleSort(arr, arr.length);

        for (Student2 s : arr) {
            System.out.println(s);
        }
    }
}



