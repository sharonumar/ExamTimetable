package examTimetable;

public interface Exam {
	public Exam getInstance();
	public int getDuration();
	public Boolean isBooked();
	public RoomType getRoomType();
	public void setExam(Room room, Day day, Hours hour, int duration);
	public void removeBooking();
	public Boolean hasRelatedExam();
	public Exam getRelatedExam();
}
