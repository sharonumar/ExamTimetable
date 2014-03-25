package newExam;
import java.util.*;

public class Module implements Comparable<Module> {
	private String moduleID;
	private String subject;
	private Exam exam;
	private List<Student> studentsEnrolled = new ArrayList<Student>();
	
	public Module(String moduleID, String subject, Exam exam, List<Student> studentsEnrolled) {
		this.moduleID = moduleID;
		this.subject = subject;
		this.exam = exam;
		this.studentsEnrolled = studentsEnrolled;
	}

	public Exam getExam() {
		return exam;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public String getModuleID() {
		return moduleID;
	}
	
	public List<Student> getStudentsEnrolled() {
		return studentsEnrolled;
	}
	
	public String toString() {
		return moduleID + " " + subject;
	}
	
	@Override
	public int compareTo(Module m) {
		     //Compares Exam
		     int eno = exam.compareTo(m.exam);
		     if (eno != 0) return eno;
		     else return 0;
	}
}
