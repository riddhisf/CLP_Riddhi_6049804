package Heapss;

import java.util.*;

public class MinHeapUsingPriorityQueue {
		public static void main(String args[]) {
			PriorityQueue<Integer> pq= new PriorityQueue<>();
			pq.offer(2);
			pq.offer(1);
			pq.offer(3);
			pq.offer(5);
			pq.offer(7);
			pq.offer(-1);
			pq.offer(4);
			pq.offer(24);
			pq.offer(-8);
			pq.offer(12);

			
			while(pq.peek()!=null) {
				System.out.print(pq.poll()+" ");
			}
			
		
		}
			
}