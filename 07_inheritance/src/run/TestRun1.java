package run;

import dto.Child1;
import dto.Parent;

public class TestRun1 {

	public static void main(String[] args) {
		
		// 부모 객체 생성
		Parent p1 = new Parent(); // 기본 생성자
		
		Parent p2 = new Parent("서울시 강남구 역삼동", 300, "딸기카"); 
		
		System.out.println ("-----------------");
		
		// 자식 객체 생성
		Child1 c1 = new Child1();
		System.out.println ( c1.inform()       );

		// 자식이 부모 코드를 물려 받았는지 확인!
		c1.setCar          ( "수박카"          );
		c1.setAddress      ( "경기도 부천시"   );
		c1.setMoney        ( Integer.MAX_VALUE );
		System.out.println ( c1.inform()       );
		
		System.out.println ("-----------------");
		
		System.out.println ("[자식 매개변수 생성자로 객체 생성]");
		
		Child1 c2 = new Child1("맥북 m3 프로");
		System.out.println ( c2.inform() + " / " + c2.getNotebook() );
		
		System.out.println ("-----------------");
		
		System.out.println ("[protected] 확인" );
		c2.print();
		
		System.out.println ("-----------------");
		
		System.out.println ("[super] 참조변수 확인");
		
		System.out.println ( c2.childInform()  );
		
		
		
		
		
		
		
		
		
		
		
		
		
		/* trash box */
		System.out.println (                   );
		System.out.println (                   );
		System.out.println (                   );
		System.out.println (">===============<");
		System.out.println ( p1.inform()       );
		System.out.println ( p2.inform()       );
		
	}
	
}
