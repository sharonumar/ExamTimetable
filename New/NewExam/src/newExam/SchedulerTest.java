package newExam;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.Test;

public class SchedulerTest {

	@Test
	public void test() throws SQLException {
	
		
//		Exam bioExam = new Exam(2); 
//		Exam journoExam = new Exam(2);
//		Exam medExam = new Exam(3);
//		Exam teachExam = new Exam(1);
//		Exam foodExam = new Exam(1);
//		Exam woodExam = new Exam(2);
//		Exam engExam = new Exam(2);
//		Exam graphExam = new Exam(3);
		

		DBConnection conn = new DBConnection();
		ArrayList<Module> modules = conn.loadModules();
		//To test for students who have an exam at this time
		//will need to generate new student lists.
		
//		Module bio = new Module("BIO555", "Biology", bioExam, studiesHistory);
//		Module journo = new Module("JOURN999", "Journalism", journoExam, studiesSport);
//		Module medicine = new Module("MED887", "Medicine", medExam, studiesEnglish);
//		Module teach = new Module("TEACH666", "Teach", teachExam, studiesScience);
//		Module food = new Module("FOOD999", "Food", foodExam, studiesMath);
//		Module wood = new Module("WOO111", "Wood", woodExam, studiesMusic);
//		Module engine = new Module("ENDIN1", "Engineering", engExam, studiesGeo);
//		Module graphics = new Module("Graph22", "Graphics", graphExam, studiesIT);
//		
		
		
		
//		allModules.add(bio);
//		allModules.add(journo);
//		allModules.add(medicine);
//		allModules.add(teach);
//		allModules.add(food);
//		allModules.add(wood);
//		allModules.add(engine);
//		allModules.add(graphics);
		
		
		
		System.out.println(modules);
		
		Collections.sort(modules);
		
		System.out.println(modules);
		
		
		ExamTimetableInfo info = conn.loadExamPeriod();
		
		System.out.println("number of examination days: "+info.getExamDuration());
		
		//set the timetable for the room, given the information from the examScheduler.
		
		ArrayList<Room> rooms = conn.loadRooms();
		for(Room r: rooms)
		{
			r.setTimetable(info.getExamDuration(),  info.getStartDate());
		}
		System.out.println(rooms);		
		Collections.sort(rooms);
		System.out.println(rooms);
		
		
		
		
		/*
		 * ALL DATA IS NOW ENTERED...
		 * 
		 * Scheduling the exams!
		 */
		Scheduler schedule = new Scheduler(modules, rooms);
		System.out.println(schedule.getTotalTime());
		try{
				//run schedule
				schedule.scheduleExam(modules.get(0).getExam());
		}
		catch (StackOverflowError e) {
			System.out.println();
			System.out.println("!!ERROR!!");
			System.out.println(e);
			System.out.println("!!ERROR!!");
			System.out.println();
		}
		for(Module m : modules) {
			try{
			System.out.println(m + ": " + m.getExam() + "\n");
			}
			catch (NullPointerException e) {
				System.out.println(modules + " exam wasn't scheduled. \n");
			}
		}
		System.out.println(schedule.getTotalTime());
		conn.saveExams(modules);
		}
}
