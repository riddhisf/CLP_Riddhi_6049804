package ArrayListss;

public class CustomArrayList {
	public static void main(String [] args) {
		MyArrayList list = new MyArrayList();
		list.add(10);
		list.add(20);
		list.add(50);
		list.add(40);
		list.add(30);
		list.add(60);
		
		//list.print();
		//System.out.println(list.get(0));
		//System.out.println(list.get(8));
		
		//list.remove(0);
		//System.out.println(list.get(0));
		
		//System.out.println(list.search(20));
		
		list.sort();
		list.print();
		
	}
}

class MyArrayList{
	private int[] data;
	private int size;
	
	public MyArrayList() {
		data= new int[4];
		size=0;
	}
	
	public void add(int value) {
		if(size==data.length) {
			resize();
		}
		
		data[size++]=value;
	}
	
	private void resize() {
		int[] newData= new int[data.length*2];
		for(int i=0;i<data.length;i++) {
			newData[i]=data[i];
		}
		data=newData;
	}
	
	public void print() {
		for(int i=0;i<data.length;i++) {
			System.out.println(data[i]);
		}
	}
	
	public int get(int index) {
		if(index<0||index>=size) {
			throw new IndexOutOfBoundsException();
		}
		return data[index];
	}
	
	public void remove(int index) {
		if(index<0||index>=size) {
			throw new IndexOutOfBoundsException();
		}
		for(int i=index;i<data.length-1;i++) {
			data[i]=data[i+1];
		}
		size--;
	}
	
	public int search(int value) {
		for(int i=0; i<data.length;i++) {
			if(data[i]==value) {
				return i;
			}
		}
		return -1;
	}
	
	public void sort() {
		for(int i=0;i<size;i++) {
			int j=i-1;
			int key=data[i];
			while(j>=0 && data[j]>key) {
				data[j+1]=data[j];
				j-=1;
			}
			data[j+1]=key;
		}
	}
}
