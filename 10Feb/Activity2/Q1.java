package Activity2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Q1 {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(12);
        numbers.add(7);
        numbers.add(5);
        numbers.add(18);
        numbers.add(3);
        numbers.add(25);
        numbers.add(10);
        numbers.add(9);
        numbers.add(21);
        numbers.add(6);

        System.out.println(numbers);

        Iterator<Integer> itr=numbers.iterator();
        while (itr.hasNext()) {
            int num=itr.next();
            if (num % 2 == 0) {
                itr.remove();
            }
        }

        System.out.println(numbers);

        Integer max = 0;
        for(int i:numbers) {
        	if(i>max) {
        		max=i;
        	}
        }

        Integer min = 100000000;
        for(int i:numbers) {
        	if(i>min) {
        		min=i;
        	}
        }

        Collections.sort(numbers, Collections.reverseOrder());

        System.out.println("Maximum Element: " + max);
        System.out.println("Minimum Element: " + min);
        System.out.println("Sorted in Descending Order: " + numbers);
    }
}
