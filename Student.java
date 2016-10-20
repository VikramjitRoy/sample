
public class Student extends Person {
	
	private int marks;
	
	public Student(String name, int marks)
	{
		super(name);
		this.marks=marks;
	}
	
	public void display()
	{
		System.out.println("Calling from student!!");
	}
	
	public int getMarks()
	{
		return this.marks;
	}
	
	@Override
	public String isOutstanding()
	{
		String str = "Normal";
		if(marks>80)
			str= "Student has distinction!!";
		return str;
	}
	
	@Override
	public String toString(){
		return "Student "+super.getName()+" has marks: "+this.getMarks();
	}
}
