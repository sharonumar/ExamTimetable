package examTimetable;

public interface Hours {
	 public Boolean isBooked();
	 public void unreseve();
	 public void book();
	 public int getStartTime(Hours hour);

}
