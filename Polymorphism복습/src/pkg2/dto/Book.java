package pkg2.dto;

public class Book {
	
	//필드
	private String name;
	private String Bookcode;
	private int price;
	
	//기본생성자
	public Book() {}

	//매개변수 생성자
	public Book(String name, String bookcode, int price) {
		super();
		this.name = name;
		Bookcode = bookcode;
		this.price = price;
	}

	// getter setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBookcode() {
		return Bookcode;
	}

	public void setBookcode(String bookcode) {
		Bookcode = bookcode;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	// toString Override
	@Override
	public String toString() {
		return "Book [name=" + name + ", Bookcode=" + Bookcode + ", price=" + price + "]";
	}
	

}
