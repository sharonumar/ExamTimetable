package examTimetable;
import java.util.*;

public interface Exam {
	public int getDuration();
	public Boolean isBooked();
	public void book();
	public RoomType getRoomType();
	public void setExam(Rooms room);
	public void removeBooking();
	public Boolean hasRelatedExam();
	public Exam getRelatedExam();
	public void setDay(Day day);
	public List<Hours> examTime();
}
