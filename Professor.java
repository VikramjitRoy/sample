
public class Professor extends Person {

	public int getBooks() {
		return books;
	}

	public void setBooks(int books) {
		this.books = books;
	}
	private int books;

	public Professor(String name, int books) {
		super(name);
		this.books = books;
	}
	
	public void show()
	{
		System.out.println("Calling from professor!!");
	}
	
	@Override
	public String isOutstanding(){
		String str="Normal";
		if(books>5){
			str="Prof is awesome!!";
		}
		return str;
	}
	@Override
	public String toString(){
		return "Professor "+super.getName()+" has a number of "+this.getBooks()+" published books";
	}
}
