package examTimetable;

public interface Exam {
	public Exam getInstance();
	public int getDuration();
	public Boolean isBooked();
	public Boolean book();
	public RoomType getRoomType();
	public void setExam(Rooms room, int duration);
	public void removeBooking();
	public Boolean hasRelatedExam();
	public Exam getRelatedExam();
}
