package newExam;
import java.util.*;

public class Scheduler {
	private List<Module> allModules = new ArrayList<Module>();
	private List<Room> allRooms = new ArrayList<Room>();
	
	public Scheduler(List<Module> allModules, List<Room> allRooms) {
		this.allModules = allModules;
		this.allRooms = allRooms;
	}
	
	//Backtrack Algorithm.
	public Boolean scheduleExam(Exam exam) {
		book(exam);
		for(Module module: allModules) {
			Exam nextExam = module.getExam();
			//Needs to have a check to see if the next Exam can be solved.
			if(canBeScheduled(nextExam) == true){
				if(scheduleExam(nextExam)) {
					return true;
					}
				}
		}
		//Remove data from the exam.
		Room roomNew = new Room(exam.getRoom().getRoomNumber(), exam.getRoom().getType(), 
												exam.getRoom().getCapacity());
		exam.setRoom(roomNew);
		for(Room r : allRooms) {
			if(r.equals(roomNew)) {
				r = roomNew;
			}
		}
		//Day examDay = new Day(exam.getDay().getDate());
		//exam.setDay(examDay);
		exam = exam.returnBlank();
		return false;
		}
	
	 public Boolean canBeScheduled(Exam exam) {
		 if(exam.getScheduled() == true) {
			 return false;
		 }
		 for(Room room : allRooms) {
			 if(exam.getRoomType() == null || exam.getRoomType() == room.getType()) {
				 for(Day day : room.getTimetable()) {
					 for(Hour start : day.getHours()) {
						 Hour startTemp = new Hour(start.getHour());
						 if(startTemp.getAvailable() == true) {
							 startTemp.setAvailableFalse();
							 for(Hour end : day.getHours()) {
								 Hour endTemp = new Hour(end.getHour());
								 if(endTemp.getAvailable() == true) {
									 if(endTemp.getHour() - startTemp.getHour() == exam.getDuration()) {
										 return true;
									 }
								endTemp.setAvailableFalse();
							}
						}
					}
				}
		 	}
		}
	}
	 return false;
	 }
	 
	
	public Boolean book(Exam exam) {
		for(Room room : allRooms) {
			if(exam.getRoomType() == null || exam.getRoomType() == room.getType()) {
			 for(Day day : room.getTimetable()) {
				for(Hour start : day.getHours()) {
					if(start.getAvailable() == true) {
						start.setAvailableFalse();
						exam.setStartTime(start);
						for(Hour end : day.getHours()) {
							if(end.getAvailable() == true) {
								if(end.getHour() - start.getHour() == exam.getDuration()) {
									if(day.getFinishTime() == end.getHour()) {
										end.setAvailableFalse();
									}
									exam.setEndTime(end);
									exam.setScheduledTrue();
									exam.setDay(day);
									exam.setRoom(room);
									return true;
								}
							end.setAvailableFalse();
						}
					}
				}
			}
		 }
		}
	}
		return false;
}


}
