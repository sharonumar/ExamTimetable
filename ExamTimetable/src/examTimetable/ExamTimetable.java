package examTimetable;

import java.util.*;

public class ExamTimetable {

	private List<Module> scheduledModules = new ArrayList<Module>();
	private List<Room> scheduledRooms = new ArrayList<Room>();
	private List<Day> availableTime = new ArrayList<Day>();

	public ExamTimetable() {
		
	}

	/**
	 * get all the modules which have been scheduled.
	 * 
	 * @return List<Module>
	 */
	public List<Module> getScheduledModules() {
		return scheduledModules;
	}

	/**
	 * get all rooms which have been booked.
	 * 
	 * @return List<Room>
	 */
	public List<Room> getScheduledRooms() {
		return scheduledRooms;
	}

	/**
	 * check to see if all the Exams have been booked.
	 * 
	 * @param List
	 *            <Module> modules
	 * @return Boolean
	 */
	private Boolean allBooked(List<Module> modules) {
		for (Module m : modules)
			if (m.getExam().isBooked()) {
				if (allBooked(modules)) {
					return true;
				}
			}
		return false;
	}

	/**
	 * 
	 * @param List
	 *            <Module> modules
	 * @return Boolean
	 */
	private Boolean allTimeUsed(List<Module> modules) {
		int proposedDuration = 0;
		for (Module m : modules) {
			proposedDuration += m.getExam().getDuration();
		}
		int totalDuration = 0;
		for (Room r : scheduledRooms) {
			List<Day> allDays = r.availableDays();
			for (Day d : allDays) {
				totalDuration += d.getFreeTime();
			}
		}
		if (totalDuration == proposedDuration)
			return true;
		else
			return false;
	}

	public Boolean schedule(ArrayList<Module> modules, ArrayList<Room> rooms) {
		if (allBooked(modules)) {
			return true;
		} else if (allTimeUsed(modules))
			return false;
		else {
			for (Iterator<Module> modList = modules.iterator(); modList.hasNext();) {
				Module  m = modList.next();
				Exam e = m.getExam();
				for (Iterator<Day> dayList = availableTime.iterator() ; dayList.hasNext();) {
					Day d = dayList.next();
					if(d.containsFreeSpace()) {
					List<Hours> hours = d.getAllHours();
					for (Iterator<Hours> hourList = hours.iterator(); hourList.hasNext(); ) {
						Hours h = hourList.next();
						if (!e.isBooked()) {
							if (e.hasRelatedExam()) {
								Exam rE = e.getRelatedExam();
								if (rE.isBooked()) {
									return false;
								} else {
									for (Iterator<Room> roomList = rooms.iterator(); roomList.hasNext() ;) {
										Room r = roomList.next();
										if (r.isAvailable(e.getDuration(), d, h)) {
											if (r.getCapacity() <= m
													.getStudentsEnrolled()
													.size()) {
												if (r.getType() == e
														.getRoomType()) {
													for (Iterator<Student> studentList = m
															.getStudentsEnrolled().iterator(); studentList.hasNext();) {
														Student s = studentList.next();
														if (!s.hasExam(h, d)) {
															e.setExam(
																	r,
																	d,
																	h,
																	e.getDuration());
															modList.remove();
															roomList.remove();
															d.setHourBooked(h);
															hourList.remove();
															if(!d.containsFreeSpace()) {
															dayList.remove();
															}
															scheduledModules.add(m);
															scheduledRooms.add(r);
															h.book();
															if(schedule(modules,rooms)){
															return true;
															}
														}
													}
												}
											}
										}
									}
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

}
