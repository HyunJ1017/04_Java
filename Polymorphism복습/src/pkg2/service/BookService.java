package pkg2.service;

import java.util.ArrayList;
import java.util.List;

import pkg2.dto.Book;

public class BookService {
	
	List<Book> bookList = new ArrayList<Book>();
	
	Book b1 = new Book("홍길동전", "001", 100);
	
	
	
	// 기본생성자
	public BookService() {}

	/**
	 * bookList 가져가기
	 * @return
	 */
	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	
	/**
	 * 필드값 입력받고 책 추가하기
	 * @param name
	 * @param bookNum
	 * @param price
	 */
	public void addBook(String name, String bookNum, int price) {
		bookList.add(new Book(name, bookNum, price));
	}

	
	/**toString
	 * 안쓰지않을까...
	 */
	@Override
	public String toString() {
		return "BookService [bookList=" + bookList + "]";
	}

}
