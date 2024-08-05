package pkg3.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import pkg3.dto.Book;
import pkg3.service.BookstoreService;
import pkg3.service.BookstoreServiceImpl;

public class BookstoreView {
	
	BookstoreService service = null;
	
	BufferedReader br = null;
	
	public BookstoreView() {
		
		try {
			service = new BookstoreServiceImpl();
			br = new BufferedReader( new InputStreamReader(System.in));
		} catch (Exception e) {
			System.out.println("프로그램오류발생");
			System.exit(0);
		}
	}

	//----------------------------------------------------------------------
	public void mainWindow() {
		
		int input = 0;
		do {
			
			System.out.println("=====================================");
			
			try {
				input = mainView();
				
				switch(input) {
				case 1 : addBook(); break;
				case 2 : selectAll(); break;
				case 3 : removeBook(); break;
				case 4 : bookManyMany(); break;
				case 0 : System.out.println(">> 프로그램 종료<< ");
				}
				
				
				
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력 해 주세요");
				input = -1;
			} catch (IOException e) {
				System.out.println("입력과정에서 오류 발생");
			}
			
		} while (input!=0);
		
	}
	

	//----------------------------------------------------------------------
	public int mainView() throws NumberFormatException, IOException {
		System.out.println("\n==== 책장정리하기 ====\n");
		
		System.out.println("1. 책 추가"         );
		System.out.println("2. 책 전체 확인"    );
		System.out.println("3. 책 삭제하기"     );
		System.out.println("4. 책 많이 추가하기");
		
		
		System.out.println("0. 프로그램 종료"   );
		
		System.out.print("메뉴 입력 >> ");
		int input = Integer.parseInt(br.readLine());
		
		return input;
	}
	
	//----------------------------------------------------------------------
	/*1. 책추가*/
	/**
	 * 책이름, 쓴이, 가격 입력받고
	 * 시리얼넘버는 중복되지 않는 랜덤으로 정해주기
	 * @throws IOException
	 */
	private void addBook() throws IOException {
		System.out.println("** 책 추가 하기 **");
		
		System.out.print("책이름 : ");
		String name = br.readLine();
		
		System.out.print("작가 : ");
		String writer = br.readLine();
		
		int price =0;
		while (true) {
			System.out.print("가격 : ");
			try {
				price = Integer.parseInt(br.readLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력해 주세요");
			}
		}
		
		boolean result = service.addBook(name, writer, price);
		
		if(result) System.out.println("추가 완료");
		
	}
	
	//-------------------------------------------------------------------
	/*책 전부 보기*/
	private void selectAll() {
		System.out.println("** 책 전체 조회 **");
		
		List<Book> bookList = service.getBookList();
		
		for(Book book : bookList) {
			System.out.printf("[%s] 저자: %s %d원, S/N %s\n", book.getName(), book.getWriter(), book.getPrice(), book.getSerialNumber());
		}
	}
	
	//-------------------------------------------------------------------
	/*책 삭제인가*/
	
	/**
	 * S/N 입력 받아서 일치하는책 목록에서 지우기
	 * @throws IOException 
	 */
	private void removeBook() throws IOException {
		System.out.println("** 책은 휴지통에 **");
		
		System.out.print("삭제할 책의 시리얼 번호를 입력 하세요\nS/N : ");
		String serialNumber = br.readLine();
		
		String search = service.searchBook(serialNumber);
		
		System.out.printf("[%s] 을 정말로 삭제 합니까? (Y/N)", search);
		String answer = br.readLine();
		
		if(answer.equals("Y")) {
		String result2 = service.removeBook(serialNumber);
		System.out.println(result2);
		}else {
			System.out.println("취소되었습니다.");
		}
		
	}
	
	//-------------------------------------------------------------------
	/*책 많이추가 하기*/
	
	/**
	 * 추가하기 귀찮으니까
	 * 텍스트파일 한줄한줄에
	 * 제목,저자,가격 받아서
	 * 한꺼번에 추가하고
	 * 오류나면 아몰라
	 * @throws IOException 
	 */
	private void bookManyMany() throws IOException {
		System.out.println("** 책 많이 입력하기 **");
		System.out.print("추가할 목록이 적힌 텍스트파일\n"
						+ "(경로 + 파일이름.txt)\n"
						+ "입력 : ");
		String inputPath = br.readLine();
		
		boolean result = service.addManyBook(inputPath);
		
		if(result) System.out.println("작업완료");
	}
	
	
	

}
