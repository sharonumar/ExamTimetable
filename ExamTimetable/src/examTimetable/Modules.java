package examTimetable;

import java.util.*;

public class Modules implements Module {
	private String moduleID;
	private List<Student> enrolledStudents = new ArrayList<Student>();
	private Exam exam;
	
	public Modules(String moduleID, Exam exam) {
		this.moduleID = moduleID;
		this.exam = exam;
	}

	@Override
	public List<Student> getStudentsEnrolled() {
		return enrolledStudents;
	}
	
	public int numberofstudents() {
		return enrolledStudents.size();
	}
	
	public void enrollStudent(Student student) {
		enrolledStudents.add(student);
	}

	@Override
	public Exam getExam() {
		return exam;
	}

	public String toString() {
		return "Module: " + moduleID + " " + " Exam: " + exam;
	}
}
