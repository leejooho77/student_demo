package student.model;

public class Student {
	
	private static int s_id = 1;
	private int id;
	private String name;
	
	public Student() {}
	
	public Student(String name) {
		setId(s_id);
		setName(name);
		s_id++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int s_id) {
		this.id = s_id;
	}

}
