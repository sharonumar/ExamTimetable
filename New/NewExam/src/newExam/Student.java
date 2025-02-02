package newExam;
import java.util.*;

public class Student {
	private String name;
	private String studentID;
	private List<Module> studiesModules = new ArrayList<Module>();

	public Student(String name, String studentID) {
		this.name = name;
		this.studentID = studentID;
	}
	
	public void setModules(List<Module> modules) {
		for(Module m: modules) {
			for(Student s: m.getStudentsEnrolled()) {
				if(this.equals(s)) {
					studiesModules.add(m);
				}
			}
			
		}
	}
	
	public String getName(){
		return name;
	}
	
	public String getSiD() {
		return studentID;
	}
	
	public List<Module> getStudiesModules() {
		return studiesModules;
	}
	
	@Override 
	public boolean equals(Object o) { 
		if (o == this)
			return true;
		if (!(o instanceof Student))
			return false;
		Student s = (Student )o;

		return s.name == name
				&& s.studentID  == studentID;
	}
	
	public String toString() {
		return name + " " + studentID;
	}

}
