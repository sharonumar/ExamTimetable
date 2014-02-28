package examTimetable;
import java.util.*;

public interface Rooms {

	public int getCapacity();
	public Boolean isAvailable(int length, Day day);
	public void bookRoom(Exam exam);
	public void book();
	public RoomType getType();
	public int timeAvailable(Day day);
	public List<Day> availableDays();
}
