package list.service;

import java.util.ArrayList;
import java.util.List;

import list.dto.BookDTO;

// 기능(비즈니스 로직) 제공용 클래스
public class BookService {

	// BookDTO 객체 참조 변수만을 저장하는
	// ArayList 객체 생성
	// Generics : BookDTO 타입 제한
	private List<BookDTO> bookList = new ArrayList<BookDTO>();

	// 기본 생성자
	public BookService() {
		
		bookList.add(new BookDTO("자바 프로그래밍 입문", "박은종", 25000));
		bookList.add(new BookDTO("선재 업고 튀어 대본집 세트", "이시은", 45000));
		bookList.add(new BookDTO("THE MONEY BOOK", "토스", 19800));
		bookList.add(new BookDTO("자바의 정석", "남궁 성", 35000));
		bookList.add(new BookDTO("눈물의 여왕 대본집 세트", "박지은", 60000));
		bookList.add(new BookDTO("삼국지 전권 세트", "이문열", 300000));
		
	}
	
	
	/**
	 * bookList를 반환하는 서비스 메서드
	 * @return bookList
	 */
	public List<BookDTO> selectAll() {
		return bookList;
	}

	/**
	 * bookList에 전달받은 index가 존재하면
	 * 해당 index번째 요소(BookDTO) 반환.
	 * 없으면 null 반환
	 * @param index
	 * @return BookDTO 또는 null
	 */
	public BookDTO selectIndex(int index) {
		// *** 마지막인덱스 == 사이즈-1
		if (index < 0 || index >= bookList.size() ) return null;
		
		return bookList.get(index);
	}
	
	/**
	 * bookList 요소의 제목 중
	 * 전달받은 title이 포함된 책을 모두 반환
	 * @param title
	 * @return searchList (찾은 책이 저장된 리스트)
	 */
	public List<BookDTO> selectTitle(String title) {
		
		List<BookDTO> searchList = new ArrayList<BookDTO>();
		
		// bookList 모든 요소 순차접근
		for(BookDTO book : bookList) {
			
			// 책 제목에 title이 포함되어 있다면
			if ( book.getTitle().contains(title) ) {
				searchList.add(book);	// 찾은 책을 searchList에 추가
			}
		}
		
		return searchList;	// 검색 결과를 반환
	}


	/**
	 * name을 전달받으면 
	 * bookList에서 동일한 Writer를 찾아
	 * 해당 BookDTO들을 참조하는 searchList를 반환
	 * @param name
	 * @return searchList
	 */
	public List<BookDTO> selectWriter(String name) {
		List<BookDTO> searchList = new ArrayList<BookDTO>();
		
		for (BookDTO book : bookList) {
			
			// 글쓴이가 포함되는 책을 searchList에 추가
			if ( book.getWriter().contains(name) ) {
				searchList.add(book);
			}
		}
		return searchList;
	}


	/**
	 * 2개의 int 자료형을 전달받아
	 * 큰값 > 책의 가격 > 작은값 을 만족하는
	 *  BookDTO들을 참조하는 List를 반환
	 * @param min_cost
	 * @param max_cost
	 * @return moneyBooks
	 */
	public List<BookDTO> selectPrice(int min_cost, int max_cost) {
		
		if (min_cost > max_cost ) {
			int temp = min_cost;
			min_cost = max_cost;
			max_cost = temp;
		}
		
		List<BookDTO> moneyBooks = new ArrayList<BookDTO>();
		
		for ( BookDTO book : bookList ) {
			
			// 책의 가격이 최소 ~ 최대 사이의 범위에 있을때
			if( book.getPrice() <= max_cost && book.getPrice() >= min_cost ) {
				moneyBooks.add(book);
			}
		}
		return moneyBooks;
	}
	
	
	/**
	 * 전달받은 newbook을 bookList에 추가
	 * @param newbook
	 * @return true (List.add() 구문은 무조건 성공하기 때문에)
	 */
	public boolean addBook(BookDTO newbook) {
		return bookList.add(newbook);
	}


	/**
	 * 인덱스를 받아서 해당 인덱스 번호가 bookList에 있으면
	 * 지우고 지웠던 BookDTO의 주소를 복사해뒀다가 반납
	 * @param index
	 * @return 	null    : index 범위가 맞지 않음
	 * 			String : index 범위가 정상 범위
	 */
	public String removeBook(int index) {
		
		if (index < 0 || index >= bookList.size() ) {
			return null;
		}
		
		/* method chaining : 
		 * 메서드의 결과(반환값)을 이용해
		 * 또다른 메서드를 호출 */
		return bookList.remove(index).getTitle();
//		String book = bookList.get(index).getTitle();
//		bookList.remove(index);
//		return book;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
