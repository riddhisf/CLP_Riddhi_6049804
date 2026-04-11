package Leetcode;

import java.util.Stack;

//232. Implement Queue Using Stacks

public class ImplementQueueUsingStacks {
	class MyQueue {

	    Stack<Integer> queue;

	    public MyQueue() {
	        queue= new Stack<>();        
	    }
	    
	    public void push(int x) {
	        Stack<Integer> temp = new Stack<>();
	        while(!queue.empty()){
	            temp.push(queue.pop());
	        }
	        queue.push(x);
	        while(!temp.empty()){
	            queue.push(temp.pop());
	        }
	    }
	    
	    public int pop() {
	        return queue.pop(); 
	    }
	    
	    public int peek() {
	        return queue.peek();
	    }
	    
	    public boolean empty() {
	        return queue.empty();
	    }
	}

	/**
	 * Your MyQueue object will be instantiated and called as such:
	 * MyQueue obj = new MyQueue();
	 * obj.push(x);
	 * int param_2 = obj.pop();
	 * int param_3 = obj.peek();
	 * boolean param_4 = obj.empty();
	 */

}
