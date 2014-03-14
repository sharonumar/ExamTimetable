package newExam;
import java.util.*;


public class Day {
	private List<Hour> hours = new ArrayList<Hour>();
	private Date date;
	private static final int startTime = 9;
	private static final int endTime = 17;

	public Day(Date date) {
		//Create the hours of a day which are available
		//to have an exam in.
		this.date = date;
		for(int i = startTime; i<= endTime; i++)
			hours.add(new Hour(i));
	}

	public String toString() {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		String print = "" + c.get(Calendar.DATE) + "/" + c.get(Calendar.MONTH) + "/"+ c.get(Calendar.YEAR) + ": ";
		
		for(Hour hour: hours) {
			print +=  hour.toString() + " ";
		}
		return print + "\n";
	}
	
	public Date getDate() {
		return date;
	}
	
	public List<Hour> getHours() {
		return hours;
	}
	
	public Hour getHour(int hour) {
		Hour next = new Hour(hour);
		for(Hour h: hours) {
			if (h.getHour() == hour) {
				next = h;
			}
		}
		return next;
	}
	
	public int getFinishTime() {
		return endTime;
	}
	
	public String getDateString() {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return  "" + c.get(Calendar.DATE) + "/" + c.get(Calendar.MONTH) + "/"+ c.get(Calendar.YEAR) + ": ";
	}

}
