package SortingSearching;

public class Student {
	String name;
	private int javaMarks;
	private int fsMarks;
	private int CMarks;
	private int id;
	private int totalMarks;
	
	//constructor
	public Student(String name, int javaMarks, int fsMarks, int cMarks, int id) {
		this.name = name;
		this.javaMarks = javaMarks;
		this.fsMarks = fsMarks;
		this.CMarks = cMarks;
		this.totalMarks=javaMarks+fsMarks+CMarks;
		this.id = id;
	}

	//getters setters
	public int getJavaMarks() {
		return javaMarks;
	}

	public void setJavaMarks(int javaMarks) {
		this.javaMarks = javaMarks;
	}

	public int getFsMarks() {
		return fsMarks;
	}

	public void setFsMarks(int fsMarks) {
		this.fsMarks = fsMarks;
	}

	public int getCMarks() {
		return CMarks;
	}

	public void setCMarks(int cMarks) {
		CMarks = cMarks;
	}
	
	public int getMarks() {
		return totalMarks;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", javaMarks=" + javaMarks + ", fsMarks=" + fsMarks + ", CMarks=" + CMarks
				+ ", id=" + id + "]";
	}
}

