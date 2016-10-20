
public class Person {
	
	private String name;
	
	public Person(String name)
	{
		this.name=name;
	}
	
	public void print()
	{
		System.out.println("Calling from person class");
	}
	
	public String getName()
	{
		return name;
	}
	
	public String isOutstanding()
	{
		return "Normal Person";
	}
	
}
