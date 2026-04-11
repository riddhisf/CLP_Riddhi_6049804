package Activity1;
import java.util.LinkedList;
import java.util.Queue;

public class Q2 {
    public static void main(String[] args) {

        Queue<String> queue=new LinkedList<>();

        queue.add("Customer1");
        queue.add("Customer2");
        queue.add("Customer3");
        queue.add("Customer4");
        queue.add("Customer5");

        System.out.println(queue);

        queue.poll(); 
        queue.poll(); 

        System.out.println(queue);
    }
}


