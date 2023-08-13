package studentPD;

public class Student {
	private String name;
	private int id;
	
	public Student() {
		setName(null);
		setId(0);
	}
	
	public Student(String name, int id) {
		this.setName(name);
		this.setId(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public String toString() {
		return "Name: " + name + ", ID: " + id;
		
	}
}
