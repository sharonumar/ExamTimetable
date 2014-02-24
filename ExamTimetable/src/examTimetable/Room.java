package examTimetable;
import java.util.*;

public interface Room {

	public Room getRoom();
	public int getCapacity();
	public Boolean isAvailable(int length, Day day, Hours hour);
	public void bookRoom(Exam exam);
	public RoomType getType();
	public int timeAvailable(Day day);
	public List<Day> availableDays();
}
