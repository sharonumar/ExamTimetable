package examTimetable;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoomTest {
	Rooms room = new Room(100, RoomType.COMPUTER_CLUSTER,2, "A100" );
	Exam exama = new Exams(2, RoomType.COMPUTER_CLUSTER);
	Exam examb = new Exams(2, RoomType.COMPUTER_CLUSTER);

	@Test
	public void test() {
		for(Day d: room.availableDays()) {
		if(room.isAvailable(2, d) ==true) {
		room.bookRoom(exama, d);
		break;
		}
		}
		for(Day d: room.availableDays()) {
			if(room.isAvailable(2, d) ==true) {
			room.bookRoom(examb, d);
			break;
			}
		}
	}

}
