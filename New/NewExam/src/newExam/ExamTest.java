package newExam;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class ExamTest {

	@Test
	public void test() {
		Exam a = new Exam(3);
		Exam b = new Exam(2);
		Exam c = new Exam(1, RoomType.LAB);
		
		System.out.println(a.compareTo(b));
		System.out.println(a.compareTo(c));
		System.out.println(a.compareTo(a));
		System.out.println(c.compareTo(b));
		
		List<Exam> exams = new ArrayList<Exam>();
		exams.add(a);
		exams.add(b);
		exams.add(c);
		System.out.println(exams);
		Collections.sort(exams);
		System.out.println(exams);
	}
	

}
