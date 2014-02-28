package examTimetable;

import java.util.*;

public class IteratorTest {
private List<String> stringList = new ArrayList<String>();

public IteratorTest() {
	String a = "Cat";
	String b= "Dog";
	String c = "Rat";
	String d= "Cow";
	String e = "Chicken";
	stringList.add(a);
	stringList.add(b);
	stringList.add(c);
	stringList.add(d);
	stringList.add(e);
}

public static void main(String [] args)
{
	IteratorTest a = new IteratorTest();
	System.out.println(a.getStringList());
	a.removeWord();
	System.out.println(a.getStringList());

	
	
	
}

public void removeWord() {
	
	for(Iterator<String> strings = stringList.iterator() ; strings.hasNext() ;) {
		String s = strings.next();
		if(s.equals("Rat")) {
			strings.remove();
		}
	}
}

public List<String> getStringList() {
	return stringList;
}

	
}
