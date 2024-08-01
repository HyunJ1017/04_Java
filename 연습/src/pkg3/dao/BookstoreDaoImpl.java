package pkg3.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pkg3.dto.Book;

public class BookstoreDaoImpl implements BookstoreDao {
	
	public static final String FILE_PATH = "/io_test/bookDATA.dat";
	
	Random random = new Random();
	
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;
	
	List<Book> bookList = null;
	
	//기본생성자
	public BookstoreDaoImpl() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		// 파일이 있으면 불러와서 쓰고 없으면 리스트 새로만들기
		File file = new File(FILE_PATH);
		if(file.exists()) {
			// 파일이 있으면
			try {
				ois = new ObjectInputStream( new FileInputStream(file));
				bookList = (ArrayList) ois.readObject();
//				 			노랑이 무시
			} finally {
				if(ois!=null)ois.close();
			}
		}
		else {
			// 파일이 없으면
			bookList = new ArrayList<Book>();
		}
		
	}
	
	@Override
	public boolean addBook(String name, String writer, int price) throws FileNotFoundException, IOException {
		
		// 중복되지않는 시리얼 넘버 생성하기
		String serialNumber = null;
		
		while(true) {
			String num = random.nextInt(1000000)+"";
			switch(6-num.length()) {
			case 0 : serialNumber = num; break;
			case 1 : serialNumber = "0" + num; break;
			case 2 : serialNumber = "00" + num; break;
			case 3 : serialNumber = "000" + num; break;
			case 4 : serialNumber = "0000" + num; break;
			case 5 : serialNumber = "00000" + num; break;
			}
			
			
			for(Book book : bookList) {
				if (book.getSerialNumber() == serialNumber) {
					continue;
				}
			}
			break;
		}
		
		Book book = new Book(name, writer, serialNumber, price);
		
		bookList.add(book);
		
		saveFile();
		
		return true;
	}
	
	public void saveFile() throws FileNotFoundException, IOException{
		try {
			oos = new ObjectOutputStream( new FileOutputStream(FILE_PATH));
			oos.writeObject(bookList);
		} finally {
			if(oos!=null)oos.close();
		}
	}
	
	@Override
	public List<Book> getBookList() {
		return bookList;
	}
	
	@Override
	public void removeBook(int i) throws FileNotFoundException, IOException {
		bookList.remove(i);
		saveFile();
	}

}
