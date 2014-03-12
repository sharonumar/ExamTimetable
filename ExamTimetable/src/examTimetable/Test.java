package examTimetable;

import java.util.*;

public class Test {
	
	public static void main(String[] args) {
		//New Students
		Student a = new Students("Paul", "Barber");
		Student b = new Students("Emily", "Allsion");
		//New Exams
		Exam exama = new Exams(3, RoomType.COMPUTER_CLUSTER);
		Exam examb = new Exams(3, RoomType.COMPUTER_CLUSTER);
		Exam examc = new Exams(2, RoomType.COMPUTER_CLUSTER);
		Exam examd = new Exams(2, RoomType.COMPUTER_CLUSTER);
		Exam exame = new Exams(2, RoomType.COMPUTER_CLUSTER);
		//Room Creates
		Rooms rooma = new Room(100, RoomType.COMPUTER_CLUSTER, 3, "a11");
		//Add Rooms to List
		List<Rooms> allRooms = new ArrayList<Rooms>();
		allRooms.add(rooma);
		//Create Modules
		Module moda = new Modules("CSC8005", exama);
		Module modb = new Modules("CSC8001", examb);
		Module modc = new Modules("CSC8002", examc);
		Module modd = new Modules("CSC8003", examd);
		Module mode = new Modules("CSC8004", exame);
		//Add Modules to a List
		List<Module> allModules = new ArrayList<Module>();
		allModules.add(moda);
		allModules.add(modb);
		allModules.add(modc);
		allModules.add(modd);
		allModules.add(mode);

		//Enroll Students on Modules
		a.addModule(moda);
		a.addModule(modb);
		a.addModule(modc);
		a.addModule(modd);
		a.addModule(mode);
		
		b.addModule(moda);
		b.addModule(modb);
		b.addModule(modc);
		b.addModule(modd);
		b.addModule(mode);
		
		moda.enrollStudent(a);
		modb.enrollStudent(a);
		modc.enrollStudent(a);
		modd.enrollStudent(a);
		mode.enrollStudent(a);
		
		moda.enrollStudent(b);
		modb.enrollStudent(b);
		modc.enrollStudent(b);
		modd.enrollStudent(b);
		mode.enrollStudent(b);
		
		
		//Create a Timetable
		ExamTimetable timetable = new ExamTimetable(allModules, allRooms);
		System.out.println(timetable.schedule());
		System.out.println(timetable);
	}

}
