package newExam;

public class Exam {
	private Day day;
	private Hour startTime;
	private Hour endTime;
	private Room room;
	private Boolean scheduled;
	private int duration;
	
 Exam(int duration) {
		//When creating an exam all fields should be empty
		//if should have no state, then we should populate
		//its state once it has been assigned to a slot in the timetable.
		//thus to begin, the time table is not scheduled.
	 	scheduled = false;
	 	//duration should be measurred in whole hours. eg. 1, 2 or 3.
	 	this.duration = duration;
	}
 
 public Day getDay() {
	 return day;
 }
 
 public Hour getStartTime() {
	 return startTime;
 }
 
 public Hour getEndTime() {
	 return endTime;
 }
 
 public Room getRoom() {
	 return room;
 }

 public Boolean getScheduled() {
	 return scheduled;
 }
 
 public int getDuration() {
	 return duration;
 }
 
 public void setDay(Day day) {
	 this.day = day;
 }
 
 public void setStartTime(Hour startTime) {
	 this.startTime = startTime;
 }
 
 public void setEndTime(Hour endTime) {
	 this.endTime = endTime;
 }
 
 public void setRoom(Room room) {
	 this.room = room;
 }
 
 public void setScheduledTrue() {
	 scheduled = true;
 }
 
 public void setScheduledFalse() {
	 scheduled = false;
 }
 
 public void removeHours() {
	 if(startTime != null && day != null) {
	 for(int i = startTime.getHour() ; i < (startTime.getHour() + duration) ; i++) {
		 Hour h = day.getHour(i);
		 h.setAvailableTrue();
	 }
	 startTime.setAvailableTrue();
	 }
 }
 
 public Exam returnBlank() {
	 return new Exam(this.getDuration());
 }
	
 public String toString() {
	 return day.getDateString() + " " + startTime + " " +  endTime;
 }

}
