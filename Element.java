
public class Element<T> {

	private T t;
	
	public T get() {
		return t;
	}
	
	public void set(T t) {
		this.t = t;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Element<Integer> integerElement = new Element<Integer>();
		Element<String> stringElement = new Element<String>();
		
		integerElement.set(new Integer(100));
		stringElement.set(new String("Hello World"));
		
		System.out.println("Integer value:"+integerElement.get());
		System.out.println("String value:"+stringElement.get());
	}

}
