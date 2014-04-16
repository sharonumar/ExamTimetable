package newExam;
import java.util.*;

public class ExamTimetableInfo 
{
	//exam period durations?
	private int examDuration;
	private Date startDate;

	
	public ExamTimetableInfo(int examDuration, Date startDate) 
	{
		this.examDuration = examDuration;
		this.startDate = startDate;
	}
	
	public int getExamDuration() 
	{
		return examDuration;
	}
	
	public Date getStartDate() {
		return startDate;
	}

}
