package pkg3.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import pkg3.dto.Book;

public interface BookstoreService {

	/**
	 * 	책이름, 글쓴이, 가격 전달받고
	 * 시리얼넘버는 중복되지 않는 랜덤으로 정해주기
	 * @param name
	 * @param writer
	 * @param price
	 * @return
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	boolean addBook(String name, String writer, int price) throws FileNotFoundException, IOException;

	List<Book> getBookList();


	String searchBook(String serialNumber) throws FileNotFoundException, IOException;

	String removeBook(String serialNumber) throws FileNotFoundException, IOException;

	boolean addManyBook(String inputPath);



}
