import java.util.ArrayList;


public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Person> list = new ArrayList<Person>();
		
		addPerson(list);
		
		print(list);
	}
	
	public static void addPerson(ArrayList<? super Person> list)
	{
		Student std1 = new Student("Supratim", 92);
		Student std2 = new Student("Mukut",66);
		Student std3 = new Student("Vikram",87);
		Professor prof1 = new Professor("Navya", 4);
		Professor prof2 = new Professor("Viduka", 7);
		list.add(std1);
		list.add(std2);
		list.add(std3);
		list.add(prof1);
		list.add(prof2);
	}
	
	public static void print(ArrayList<?> list)
	{
		for(Object person:list)
			System.out.println(person);
	}
	
}
