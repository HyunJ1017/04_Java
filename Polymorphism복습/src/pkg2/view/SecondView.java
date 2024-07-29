package pkg2.view;

import java.util.List;
import java.util.Scanner;

import pkg2.dto.Book;
import pkg2.service.BookService;

public class SecondView {

	static Scanner sc2 = new Scanner(System.in);
	static BookService service = new BookService();
	
	public static void secondView() {
		int input2 = 0;
		do {
			System.out.println("1) Servic1-2에서 책 생성하기");
			System.out.println("3) Servic1-2에서 책 가격 수정");
			System.out.println("4) Servic1-2에서 책 목록확인");
			
			System.out.println("0) SecondView 나가기");
			
			System.out.print("Menu : ");
			input2 = sc2.nextInt();
			
			switch(input2) {
			case 1 : creatBook(); break;
			case 3 : update(); break;
			case 4 : selectAll(); break;
			case 0 :
			default : 
			}
			
			
			
		} while (input2 != 0);
	}
	
	/**
	 * 책 새로만들기
	 * 입력 안받고 정해진걸로 만들거임
	 */
	private static void creatBook() {
		
		System.out.println(" Servic1-2에서 책 생성하기");
		
		service.addBook("홍길동전", "001", 1230);
		
	}


	/**
	 *  Servic1에서 전체목록 확인
	 */
	private static void selectAll() {
		
		System.out.println(" Servic1-2에서 책 목록확인");
		
		for ( Book book : service.getBookList() ) {
			System.out.println(book);
		}
		
	}
	
	/**
	 * 인덱스번호로 책 가격 수정
	 */
	private static void update() {
		
		System.out.println(" Servic1-2에서 책 가격 수정");
		System.out.println(" 원래가격 100");
		System.out.println(" 수정될 가격 300");
		
		/*얕은복사*/
		List<Book> list = service.getBookList();
		
		// 가격 200원으로 수정, 반환값 없음
		list.get(0).setPrice(300);
		
		System.out.println("수정완료\n");
	}

}
