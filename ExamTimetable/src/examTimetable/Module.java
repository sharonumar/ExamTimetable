package examTimetable;
import java.util.*;

public interface Module {
public ArrayList<Student> getStudentsEnrolled();
public void bookExam(Room room, Exam exam);
public Exam getExam();

}
