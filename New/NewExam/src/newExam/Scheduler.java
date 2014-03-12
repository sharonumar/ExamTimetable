package newExam;
import java.util.*;

public class Scheduler {
	private List<Module> allModules = new ArrayList<Module>();
	private List<Day> allDays = new ArrayList<Day>();
	
	public Scheduler(List<Module> allModules, List<Day> allDays) {
		this.allModules = allModules;
		this.allDays = allDays;
	}
	
	//Backtrack Algorithm.
	public Boolean scheduleExam(Exam exam) {
		book(exam);
		for(Module module: allModules) {
			Exam nextExam = module.getExam();
			//Needs to have a check to see if the next Exam can be solved.
			if(nextExam.getScheduled() == false) {
				Exam testExam = nextExam;
			if(canBeScheduled(testExam) == true){
				if(scheduleExam(nextExam)) {
					return true;
					}
				}
			}
			}
		exam.removeHours();
		exam = exam.returnBlank();
		return false;
	}
	
	 public Boolean canBeScheduled(Exam exam) {
		 for(Day day : allDays) {
				for(Hour start : day.getHours()) {
					if(start.getAvailable() == true) {
						start.setAvailableFalse();
						exam.setStartTime(start);
						exam.setDay(day);
						for(Hour end : day.getHours()) {
							if(end.getAvailable() == true) {
								if(end.getHour() - start.getHour() == exam.getDuration()) {
									exam.removeHours();
									exam = exam.returnBlank();
									start.setAvailableTrue();
									end.setAvailableTrue();		
									return true;
								}
							end.setAvailableFalse();
						}
						}
					}
				}
		 }
		 
		 return false;
	 }
	 
	
	public Boolean book(Exam exam) {
		if(exam.getScheduled() != true) {
			for(Day day : allDays) {
				for(Hour start : day.getHours()) {
					if(start.getAvailable() == true) {
						start.setAvailableFalse();
						exam.setStartTime(start);
						exam.setDay(day);
						for(Hour end : day.getHours()) {
							if(end.getAvailable() == true) {
								if(end.getHour() - start.getHour() == exam.getDuration()) {
									exam.setEndTime(end);
									exam.setScheduledTrue();
									return true;
								}
							end.setAvailableFalse();
						}
					}
				}
			}
		}
	}
		return false;
}


}
