package HashMapp;

public class HashMapImplementation {
	public static void main (String[] args) {
        MyHashMap map = new MyHashMap(10);
        
        map.put("FB", 100);
        map.put("Ea", 200);
        map.put("A", 10);
        
        System.out.println(map.get("FB"));
        System.out.println(map.get("EE"));
        System.out.println(map.get("A"));
    }
}

class Node{
	String key;
	int value;
	Node next;
	
	Node(String key, int value){
		this.key=key;
		this.value=value;
		this.next=null;
	}
}

class MyHashMap{
	private Node[] table;
	private int size;
	
	public MyHashMap(int capacity) {
		table = new Node[capacity];
		size=capacity;
	}
	
	//replacement for hashcode()
	public int hash(String key) {
		int hash=0;
		for(int i=0; i<key.length(); i++) {
			hash=hash+key.charAt(i);
		}
		return hash%size;
	}
	
	public Integer get(String key) {
		int index=hash(key);
		Node current= table[index];
		while(current!=null) {
			if(current.key.equals(key)) {
				return current.value;
			}
			current=current.next;
		}
		return null;
	}
	
	 public void put(String key, int value){
        int index = hash(key);
        Node newNode = new Node(key, value);
        
        // if bucket is empty then store the data and return
        if(table[index] == null){
            table[index] = newNode;
            return;
        }
        
        Node current = table[index];
        
        // this is checking already hash is available
        while (current != null){
            
            // if key already exists > update
            if(current.key.equals(key)){
                current.value = value;
                return;
            }
            
            if(current.next == null) break;
            current = current.next;
        }
        // if you confirm there is no duplicate insert new node
        current.next = newNode;
    }
}
