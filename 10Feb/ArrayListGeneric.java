package ArrayListss;

public class ArrayListGeneric {
	public static void main(String [] args) {
		MyGenericArrayList<Students> list = new MyGenericArrayList<>();
		list.add(new Students(1,93,"A"));
		list.add(new Students(3,85,"B"));
		list.add(new Students(4,67,"C"));
		list.add(new Students(5,93,"D"));
		list.add(new Students(2,93,"F"));
		list.add(new Students(6,83,"A"));		
		list.print();
		System.out.println();
		System.out.println(list.get(0));
		System.out.println();
		//System.out.println(list.get(8));
		
		list.remove(0);
		//System.out.println(list.get(0));
		
		//System.out.println(list.search(20));
		//list.print();
		list.sort();
		list.print();
		System.out.println();
		
	}
}

class MyGenericArrayList<T>{
	private Object[] data;
	private int size;
	
	public MyGenericArrayList() {
		data= new Object[4];
		size=0;
	}
	
	public void add(T value) {
		if(size==data.length) {
			resize();
		}
		data[size++]=value;
	}
	
	private void resize() {
		Object[] newData= new Object[data.length*2];
		for(int i=0;i<data.length;i++) {
			newData[i]=data[i];
		}
		data=newData;
	}
	
	public void print() {
		for(int i=0;i<size;i++) {
			System.out.println(data[i]);
		}
	}
	
	public Object get(int index) {
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
	
	public int search(T value) {
		for(int i=0; i<data.length;i++) {
			if(data[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}
	
	private int compare(Object a, Object b) {

	    // Case 1: String 
	    if (a instanceof String && b instanceof String) {
	        String s1=(String) a;
	        String s2=(String) b;

	        int len=Math.min(s1.length(), s2.length());
	        for (int i=0; i<len; i++) {
	            if (s1.charAt(i)!=s2.charAt(i)) {
	                return s1.charAt(i)-s2.charAt(i);
	            }
	        }
	        return s1.length()-s2.length();
	    }

	    // Case 2: Numbers
	    if (a instanceof Number && b instanceof Number) {
	        double n1 = ((Number)a).doubleValue();
	        double n2 = ((Number)b).doubleValue();
	        return (int) (n1-n2);
	    }
	    
	    // Case 3: Character
	    if (a instanceof Character && b instanceof Character) {
	        char c1 = (Character) a;
	        char c2 = (Character) b;

	        return c1 - c2;
	    }
	    
	    //Case 4: Classes
	    try {
	        var method=a.getClass().getMethod(
	                "compare",
	                a.getClass(),
	                b.getClass()
	        );
	        return (int) method.invoke(null, a, b);

	    } catch (NoSuchMethodException e) {
	        throw new RuntimeException(
	                "Class does not define compare(T,T)"
	        );
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

		
	public void sort() {
	    for (int i=1; i<size; i++) {
	        Object key=data[i];
	        int j=i-1;
	        while (j>=0 && compare(data[j],key)>0) {
	            data[j+1]=data[j];
	            j--;
	        }
	        data[j+1]=key;
	    }
	}

	
}

class Students{
	int id;
	int marks;
	String name;
	public Students(int id, int marks, String name) {
		this.id = id;
		this.marks = marks;
		this.name = name;
	}
	public static int compare(Students s1, Students s2) {
		return s1.marks-s2.marks;
	}
	@Override
	public String toString() {
		return "Students [id=" + id + ", marks=" + marks + ", name=" + name + "]";
	}
}
