package Activity1;

import java.util.ArrayList;

public class Q1 {

    public static void main(String[] args) {
        ArrayList<Integer> marks=new ArrayList<>();
        marks.add(78);
        marks.add(85);
        marks.add(92);
        marks.add(66);
        marks.add(88);

        System.out.println(marks);

        marks.add(2, 80);
        System.out.println(marks);

        Integer lowestMark = 101;
        
        for(int i:marks) {
        	if(i<lowestMark) {
        		lowestMark=i;
        	}
        }
        
        marks.remove(lowestMark);
        System.out.println(marks);
    }
}
