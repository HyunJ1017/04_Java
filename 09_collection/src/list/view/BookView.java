package list.view;

import java.util.List;
import java.util.Scanner;

import list.dto.BookDTO;
import list.service.BookService;

// view : 사용자에게 보여지는 부분 (출력, 입력)

public class BookView {

	private Scanner sc = new Scanner(System.in);
	
	private BookService service = new BookService();
	
	/**
	 * 사용자에게 보여질 메인 화면
	 */
	public void mainMenu() {
		int input = 0;
		
		do {
			System.out.println("\n***** 도서 관리 프로그램 *****\n");
			
			System.out.println("1. 전체 조회"				);
			System.out.println("2. 인덱스로 조회"			);
			System.out.println("3. 책 이름으로 조회(포함)"	);
			System.out.println("4. 글쓴이 이름으로 조회"	);
			System.out.println("5. 가격으로 조회"			);
			
			System.out.println("6. 도서 추가하기"			);
			System.out.println("7. 도서 제거하기"			);
			System.out.println("8. 도서 가격 수정하기"		);
			
			System.out.println("0. 프로그램 종료");
			
			System.out.println();
			
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			sc.nextLine();	// 입력버퍼 남은 엔터 제거
			
			System.out.println();
			
			switch(input) {
			case 1 : selectAll(); 		break;
			case 2 : selectIndex(); 	break;
			case 3 : selectTitle(); 	break;
			case 4 : selectWriter(); 	break;
			case 5 : selectPrice(); 	break;
			case 6 : addBook(); 		break;
			case 7 : removeBook(); 		break;
			case 8 : updatePrice(); 	break;
			case 0 : System.out.println("***** 프로그램 종료 *****");break;
			default : System.out.println("***** 잘못 입력 하셨습니다 *****\n");
			}
			
		} while (input !=0);
	}
	
	/**
	 * 전체 조회
	 * - BookService에 있는 bookList를 얻어와
	 *   존재하는 모든 요소의 정보를 출력
	 */
	private void selectAll() {
		System.out.println("\n**** 전체조회 ****\n");
		
		List<BookDTO> bookList = service.selectAll();
		
		int index = 0;
		for (BookDTO book : bookList ) {
			//BookDTO [title=제목, writer=글쓴이, price=16000]
			System.out.println(index + ") " + book);
			index++;
		}
		
//		for(int i = 0 ; i < bookList.size(); i++) {
//			System.out.println(i + ") " + bookList.get(i));
//		}
		
	}
	
	/**
	 * 입력받은 index번째 bookDTO를 반환받아 출력
	 */
	private void selectIndex() {
		System.out.println("\n**** 인덱스조회 ****\n");

		System.out.print("조회할 책의 번호 : ");
		int index = sc.nextInt();
		
		// 전달한 index번째 요소가 존재하면 BookDTO 객체 주소
		// 없다면 null 반환
		BookDTO book = service.selectIndex(index);
		
		if(book == null) {
			System.out.println("\n**** 해당 인덱스에 책이 존재하지 않습니다 ****");
			return;
		}
		
		System.out.println("제목 : " + book.getTitle());
		System.out.println("저자 : " + book.getWriter());
		System.out.println("가격 : " + book.getPrice() + "원");
		
	}
	
	/**
	 * 입력받은 책 제목이 포함된 모든 책 출력하기
	 * 단, 없으면 "조회결과가 없습니다" 출력
	 */
	private void selectTitle() {
		System.out.println("\n**** 책 이름으로 조회(포함) ****\n");
		
		System.out.print("검색할 책 제목 입력 : ");
		String title = sc.nextLine();
		
		List<BookDTO> searchList = service.selectTitle(title);
		
		// 만약 검색 결과가 없을경우
//		if ( searchList.size() == 0 )
		if ( searchList.isEmpty() ) { /* 둘중 기억나는거 쓰면 됨 */
			System.out.println("\n**** 조회결과가 없습니다 ****");
			return;
		}
		
		for(BookDTO book : searchList ) {
			System.out.println(book);
		}
		
	}
	
	
	/**
	 * 입력된 글쓴이 이름이 같은 책을 모두 조회하여 출력하기
	 * 단, 없으면 "조회결과가 없습니다" 출력
	 */
	private void selectWriter() {
		System.out.println("\n**** 글쓴이 이름으로 조회 ****\n");
		
		System.out.print("검색할 글쓴이 입력 : ");
		String writer = sc.nextLine();
		
		List<BookDTO> searchList = service.selectWriter(writer);
		
		if ( searchList.isEmpty() ) {
			System.out.println("**** 조회결과가 없습니다 ****");
			return;
		}
		
		int index = 1;
		for ( BookDTO book : searchList ) {
			System.out.printf("%d) [%s] 저자 : [%s], 가격 : %d원\n", index, book.getTitle(), book.getWriter(), book.getPrice());
			index++;
		}
		
	}
	
	
	/**
	 * 검색할 가격의 범위(최소 값, 최대 값)을 입력받아
	 * 가격 범위 내의 모든 책을 조회하여 출력
	 * 단, 없으면 "조회결과가 없습니다" 출력
	 */
	private void selectPrice() {
		System.out.println("\n**** 가격으로 조회 ****\n");
		
		System.out.print("희망하는 최소가격 : ");
		int min_cost = sc.nextInt();
		
		System.out.print("희망하는 최대가격 : ");
		int max_cost = sc.nextInt();
		
		List<BookDTO> moneyBooks = service.selectPrice(min_cost, max_cost);
		
		if ( moneyBooks.isEmpty() ) {
			System.out.println("**** 조회결과가 없습니다 ****");
			return;
		}
		
		int index = 1;
		for ( BookDTO book : moneyBooks ) {
			System.out.printf("%d) [%s] 가격 : %d원\n", index, book.getTitle(), book.getPrice());
			index++;
		}
	}
	
	
	/**
	 * 제목, 글쓰니, 가격을 입력 받아
	 * BookService의 bookList에 추가하기
	 */
	private void addBook() {
		System.out.println("\n**** 도서 추가하기 ****\n");
		
		System.out.print("새로만들 책의 제목, 작가, 가격 : ");
		String newTitle = sc.nextLine();
		System.out.print("작가, 가격 : ");
		String newWriter = sc.nextLine();
		System.out.print("가격 : ");
		int newPrice = sc.nextInt();
		
		// 입력받은 정보를 묶어서 Service로 전달할 수 있도록
		// BookDTO 객체를 생성
		BookDTO newbook = new BookDTO(newTitle, newWriter, newPrice);
		
		boolean result = service.addBook(newbook);
		
		if (result) System.out.println("랜드마크 건설");
		else System.out.println("***추가중 문제발생***");
		
	}
	
	
	/**
	 * 인덱스 번호를 입력받아
	 * 1) 일치하는 인덱스가 있으면
	 *    bookList에서 제거 후
	 *    "[책 제목] 책이 목록에서 제거되었습니다." 출력하기
	 * 2) 일치하는 인덱스가 없으면
	 *    "해당 인덱스에 존재하는 책이 없습니다." 출력
	 */
	private void removeBook() {
		System.out.println("\n**** 도서 제거하기 ****\n");
		
		System.out.print("제거할 인덱스 번호 : ");
		int index = sc.nextInt();
		
		String result = service.removeBook(index);
		
		if ( result == null ) {
			System.out.println("해당 인덱스에 존재하는 책이 없습니다.");
			return;
		}
		
		System.out.printf("[%s] 책이 목록에서 제거 되었습니다.", result);
		
	}
	
	
	/**
	 * 인덱스 번호와 가격을 입력받아
	 * 1)해당 인덱스에 책이 존재하지 않으면
	 *   "해당 인덱스에 책이 존재하지 않습니다" 출력 후 종료
	 * 2)해당 인덱스 번호 책의 가격을 수정한 후
	 *   "[책이름] 의 가격이 [before]에서 [affter]로 바뀌었습니다." 출력하기
	 */
	private void updatePrice() {
		System.out.println("\n**** 도서 가격 수정하기 ****\n");
		
		System.out.print("가격을 변경할 책의 인덱스 번호 : ");
		int index = sc.nextInt();
		
		// 인덱스가 일치하는 요소의 BookDTO(참조주소)를 반환받기
		/* 얕은복사 */
		// ex) index = 0;
		//	   bookList.get(0)에 저장된 주소와
		//     아래 book에 저장된 주소가 "같음"
		BookDTO book = service.selectIndex(index);
		
		// 인덱스 오류검사
		if ( book == null) {
			System.out.println("\n**** 해당 인덱스에 책이 존재하지 않습니다 ****");
			return;
		}
		
		// 변경 전 가격, 수정 전 가격을 임시변수에 훔쳐서 복사해두기
		int before = book.getPrice();
		
		// 책이 존재하면 가격 입력받기
		System.out.printf("원래가격 : %d원\n변경할 가격 : ", before);
		int newPrice = sc.nextInt();
		
		
		// 가격 변경하기, 반환값은 당연히 없음
		book.setPrice(newPrice);
		
		System.out.printf("[%s] 의 가격이 [%d원]에서 [%d원]으로 바뀌었습니다.",
				book.getTitle(), before , newPrice );
	}
	
}
