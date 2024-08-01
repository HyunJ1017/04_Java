package pkg3.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import pkg3.dao.BookstoreDao;
import pkg3.dao.BookstoreDaoImpl;
import pkg3.dto.Book;

public class BookstoreServiceImpl implements BookstoreService {
	
	BookstoreDao dao = null;
	
	public BookstoreServiceImpl() throws FileNotFoundException, ClassNotFoundException, IOException {
		dao = new BookstoreDaoImpl();
	}

	
	@Override
	public boolean addBook(String name, String writer, int price) throws FileNotFoundException, IOException {
		
		boolean result = dao.addBook(name, writer, price);
		
		return result;
	}
	
	@Override
	public List<Book> getBookList() {
		return dao.getBookList();
	}
	
	/**
	 * 책 목록을 얻어와 시리얼 번호 검색 후 제거
	 * return "제거 완료", "해당하는 번호의 책이 없습니다"
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Override
	public String removeBook(String serialNumber) throws FileNotFoundException, IOException {
		
		List<Book> bookList = dao.getBookList();
		
		for(int i = 0; i<bookList.size() ; i++) {
			if( bookList.get(i).getSerialNumber().equals(serialNumber) ) {
				dao.removeBook(i);
				return "제거 완료";
			}
		}
		
		return "해당하는 번호의 책이 없습니다";
	}
	
	/*------------------------------------------------------------------------*/
	/**
	 * 1) 입력된 주소의 텍스트파일 3줄씩 읽어오기
	 * 2) 3줄씩 끊어서 1줄 책이름, 2줄 저자, 3줄 가격
	 * 3) 매번 추가, 저장하고 못읽어오면 바로 return
	 * 4) return할때 "몇번까지 입력했습니다" 콘솔창에 띄워주기
	 *    -> 오류 catch하면 sysout으로 띄우고 false 반납
	 * 5) 다하면?... 읽어온게 셋다 null이면 true 반납
	 */
	@Override
	public boolean addManyBook(String inputPath) {
		
		/**------------------------------------------------*/
//		FileReader fr = null;
//		BufferedReader br = null;
//		
//		try {
//			// 스트림 객체 생성
//			fr = new FileReader("/io_test/char/문자테스트.txt");
//			br = new BufferedReader(fr);
//			
//			// String br.readLine()
//			// -> 한 줄을 읽어오는데
//			//    없으면 null이 반환됨
//			// -> \n은 읽어오지 않음...
//			
//			String line = null; // 읽어올 한 줄을 저장할 변수
//			StringBuilder sb = new StringBuilder();
//			while (true) {
//				line = br.readLine();
//				
//				// 읽어온 내용이 없다면 반복 종료
//				if (line == null) break;
//				
//				sb.append(line);
//				sb.append("\n");
//			}
//			
//			System.out.println(sb.toString());
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(br!=null)br.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
		/**---------------------------------------------------------------*/
		return false;
	}
	
	
}
