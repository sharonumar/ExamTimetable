package newExam;
import java.util.*;

public class Room implements Comparable <Room>{
	private int rid;
	private String roomNumber;
	private RoomType type;
	private int capacity;
	//each room has it's own array of days
	//to act as a timetable for each room.
	private List<Day> timetable = new ArrayList<Day>();
	
	public Room(int id, String roomNumber, RoomType type, int capacity) {
		this.rid = id;
		this.roomNumber = roomNumber;
		this.type = type;
		this.capacity = capacity;
	}
	
	public String toString() {
		return roomNumber;
	}
	
	public void setTimetable(int examDuration, Date startDate) {
		for(int i = 0; i < examDuration; i++) {
			timetable.add(new Day(startDate));
			//increment the date.
			Calendar c = Calendar.getInstance();
			c.setTime(startDate);
			int day = c.get(Calendar.DATE);
			day++;
			c.set(Calendar.DATE, day);
			startDate = c.getTime();
		}
	}
	
	public List<Day> getTimetable() {
		return timetable;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public RoomType getType() {
		return type;
	}
	
	public String getRoomNumber() {
		return roomNumber;
	}
	
	@Override 
	public boolean equals(Object o) { 
		if (o == this)
			return true;
		if (!(o instanceof Room))
			return false;
		Room r = (Room)o;

		return r.roomNumber == roomNumber
				&& r.type  == type
					&& r.capacity == capacity;
	}
	
	@Override
	 public int compareTo(Room r) {
	     int cap = r.capacity - capacity;
	     if (cap !=0) return cap;
	     else return 0;
	 }

}
