package examTimetable;
import java.util.*;

public interface Student {
	public List<Module> enrolledModules();
	public Boolean hasExam(Hours hour, Day d);
	public void addModule(Module module);
}
