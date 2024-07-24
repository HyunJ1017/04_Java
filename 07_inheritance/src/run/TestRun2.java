package run;

import dto.Child1;
import dto.Child3;
import dto.Parent;

public class TestRun2 {
	public static void main(String[] args) {
		
		// 부모객체 생성
		Parent p1 = new Parent();
		p1.introduce();
		
		System.out.println ("\n-------------\n");
		
		// 자식샛체 생성
		Child1 c1 = new Child1(); // 내부에 Parent 객체 생성
		c1.introduce();
		
		System.out.println ("\n-------------\n");
		System.out.println ("[Object.toString() 오버라이딩 확인]");
		
		System.out.println ( p1.toString() );
		System.out.println ( p1 );	// 참조 변수명만 작성해도
									// -> toString() 자동 호출
		
		System.out.println ("\n-------------\n");
		System.out.println ("[Parent.toString() 오버라이딩 확인]");
		
		c1.setNotebook("LG Gram");
		System.out.println ( c1 + " / " + c1.getNotebook() );
		
		System.out.println ("\n-------------\n");
		System.out.println ("[final 메서드 확인]");
		c1.onlyChild();
		
		System.out.println ("\n-------------\n");
		System.out.println ("[메서드 super 확인]");
		
		Child3 c3 = new Child3();
		c3.settings("서울 아무데나", 670, "젤리카", "종이책");
		
		System.out.println(c3.inform() + " / " + c3.getNotebook());
		
	}
}
