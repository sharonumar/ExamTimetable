package examTimetable;
import java.util.*;

public interface Module {
public ArrayList<Student> getStudentsEnrolled();
public void bookExam(Rooms room, Exam exam);
public Exam getExam();

}
