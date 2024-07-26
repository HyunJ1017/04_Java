package list.run;

import list.view.BookView;

public class BookRun {
	public static void main(String[] args) {
		
		// 변수 : 메모리에 값을 저장하는 공산
		//  -> 변수에 저장하면 계속 호출 가능(재사용가능)
		
		// 객체를 1회성으로 사용하는 방법
		new BookView().mainMenu();
		
		
		// 포함된 문자열 확인하는법
		// String.contains("검색어") : 포함이면 true, 없으면 false
//		System.out.println("선재 업고 튀어".contains("선재"));	// true
//		System.out.println("선재 업고 튀어".contains("MONEY"));	// false
//		System.out.println("선재 업고 튀어".contains("업고"));	// true
		
	}

}
