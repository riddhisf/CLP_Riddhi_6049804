package SortingSearching;

import java.util.Arrays;

public class Student2 {
	String name;
	int id;
	int [] marks;
	public Student2(String name, int id, int[] marks) {
		super();
		this.name = name;
		this.id = id;
		this.marks = marks;
	}
	public int[] getMarks() {
		return marks;
	}
	public void setMarks(int[] marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student2 [name=" + name + ", id=" + id + ", marks=" + Arrays.toString(marks) + "]";
	}
}
