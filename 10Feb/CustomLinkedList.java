package LinkedListss;

public class CustomLinkedList {
	

}

class Node{
	int data;
	Node next;
	
	Node(int data){
		this.data= data;
		this.next=null;
	}
}

class LinkedList{
	private Node head;
	private int size;
	
	public LinkedList() {
		head=null;
		size=0;
	}
	
	public void add(int data) {
		Node newNode= new Node(data);
		
		if(head==null) {
			head= newNode;
		}
		else {
			Node curr=head;
			while(curr.next!=null) {
				curr=curr.next;
			}
			curr.next=newNode;
		}
	}
	
	public void remove(int index) {
		checkIndex(index);
		if(index==0) {
			head=head.next;
		}
		else {
			Node curr=head;
			for(int i=0;i<index-1;i++) {
				curr=curr.next;
			}
			curr.next=curr.next.next;
		}
		size--;
	}
	
	private void checkIndex(int index) {
		if(index<0 && index>=size) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	
}