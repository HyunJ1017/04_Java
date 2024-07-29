package pkg2.view;

import java.util.List;
import java.util.Scanner;

import pkg2.dto.Book;
import pkg2.service.BookService;

public class BookView {

	Scanner sc = new Scanner(System.in);
	BookService service = new BookService();
	
	
	public void mainview() {

		int input = 0;
		
		do {
			/*
			 * 1)
			 * 기본생성자에 목록을 만들어두면 method를 부를때마다 초기화됨? 그렇겠지 ㅅㅂ
			 * 
			 * view 2곳에서 각각 같은서비스 불러다가 수정하면???	(일단 같은페키지)
			 * => view 2에서 수정하고 view 1에서 확인		(다 static으로 만들으라고함)
			 * => 공유안됨
			 * 
			 * 2)
			 * 기본생성자 밖에 만들어두면?
			 * 
			 * 필드에다가 만들어두고 진행
			 * => 만들어지지도 않음 -_-;;
			 * 
			 * 3)
			 * 1-2에서 만들고 1에서 확인하기
			 * => 1-2에서는 계속 확인 되는데
			 *    1에서는 그림자도안보임
			 * 
			 * ==> Service, View : 각자 자기데이터만 따로봄
			 * 
			 * 
			 *  
			 * */
			System.out.println("\n1) Servic1에서 전체목록 확인");
			System.out.println("2) Servic1에서 책 가격 수정");
			System.out.println("3) Servic1-2에서 책 가격 수정");	//(일단 같은페키지)
			System.out.println("4) Servic1-2에서 책 목록확인 수정");//(일단 같은페키지)
			System.out.println("4) Servic1-3에서 책 목록확인 수정");
			System.out.println("4) Servic1-3에서 책 목록확인 수정");
			System.out.print("Menu : ");
			input = sc.nextInt();
			
			switch(input) {
			case 1 : selectAll(); break;
			case 2 : update(); break;
			case 3, 4 : SecondView.secondView(); break;
			case 0 : System.out.println("System out"); break;
			default : System.out.println("Try Again");
			}
			
			
		}while(input != 0);
		
	}


	/**
	 *  Servic1에서 전체목록 확인
	 */
	private void selectAll() {
		
		System.out.println(" Servic1에서 전체목록 확인");
		
		for ( Book book : service.getBookList() ) {
			System.out.println(book);
		}
		
	}
	
	/**
	 * 인덱스번호로 책 가격 수정
	 */
	private void update() {
		
		System.out.println(" Servic1에서 책 가격 수정");
		System.out.println(" 원래가격 100");
		System.out.println(" 수정될 가격 200");
		
		/*얕은복사*/
		List<Book> list = service.getBookList();
		
		// 가격 200원으로 수정, 반환값 없음
		list.get(0).setPrice(200);
		
		System.out.println("수정완료\n");
	}
	
	

}
