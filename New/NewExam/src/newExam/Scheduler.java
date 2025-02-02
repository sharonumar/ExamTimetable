package newExam;
import java.util.*;

public class Scheduler {
	private List<Module> allModules = new ArrayList<Module>();
	private List<Room> allRooms = new ArrayList<Room>();
	private int totalTime;
	
	public Scheduler(List<Module> allModules, List<Room> allRooms) {
		this.allModules = allModules;
		this.allRooms = allRooms;
		for(Room r: allRooms) {
			for (Day d : r.getTimetable()){
				totalTime += d.getFinishTime() - d.getStartTime();
			}
		}
	}
	
	public int getTotalTime() {
		return totalTime;
	}
	
	//Backtrack Algorithm.
	public Boolean scheduleExam(Exam exam) {
		book(exam);
		for(Module module: allModules) {
			if(allExamsBooked(allModules)) return true;
			Exam nextExam = module.getExam();
			//Needs to have a check to see if the next Exam can be solved.
			if(timeAvailable(nextExam) && nextExam.getScheduled() == false) {
			//if(canBeScheduled(nextExam) == true){
				if(scheduleExam(nextExam)) {
					return true;
					}
			}
		}
		
		//Remove data from the exam.
		Iterator<Hour> hours = exam.getExamPeriod().iterator();
		while(hours.hasNext()) {
		Hour h = hours.next();
		h.setAvailableTrue();
		hours.remove();
		}
		exam.setScheduledFalse();
		totalTime += exam.getDuration();
		exam.setDay(null);
		exam.setStartTime(null);
		exam.setEndTime(null);
		return false;
		}
	
	public Boolean timeAvailable(Exam exam) {
		return (exam.getDuration() <= totalTime) ? true : false;
	}
	
	public Boolean allExamsBooked(List<Module> allModules) {
		int i =0;
		for(Module m: allModules) {
			if(m.getExam().getScheduled() == true) {
				i++;
			}
		}
		if(i == allModules.size()) {
			return true;
		}
		else return false;
	}
	
	public Boolean book(Exam exam) {
		 for(Room room : allRooms) {
			 if(exam.getRoomType() == null || exam.getRoomType() == room.getType()) {
				 for(Day day : room.getTimetable()) {
					 for(Hour start : day.getHours()) {
						 if(start.getAvailable() == true) {
							 if(start.getHour() + exam.getDuration() <= day.getFinishTime()) {
							 int startInt = start.getHour();
								for(int i = 0 ; i < exam.getDuration() ; i++) {
									Hour h = day.getHour(startInt);
									exam.getExamPeriod().add(h);
									startInt++;
										}
										for(Hour h: exam.getExamPeriod())
											h.setAvailableFalse();
										 exam.setStartTime(start);
										 int endHour = start.getHour() + exam.getDuration();
										 exam.setEndTime(day.getHour(endHour));
										 exam.setScheduledTrue();
										 exam.setDay(day);
										 exam.setRoom(room);
										 totalTime -= exam.getDuration();
										 return true;
							 }
						}
					}
				}
			}
		 }
	 return false;
	 }
}
