package field.pkg3;

public class StaticTestRun {

	public static void main(String[] args) {
		
		// Korea 객체 2개 생성
		Korean k1 = new Korean();
		
		k1.setName("홍길동");
		k1.setId("123456-1234567");
		
		Korean k2 = new Korean();
		k2.setName("박영희");
		k2.setId("234567-2345678");
		
		//--------------------------------
		
		System.out.println("생성된 객체의 필드값 확인");
		System.out.printf("k1 : %d / %s / %s\n", k1.nationalCode, k1.getName(), k1.getId());
		System.out.printf("k2 : %d / %s / %s\n", k2.nationalCode, k2.getName(), k2.getId());
		
		//--------------------------------

		System.out.println("\n\n[static 변수 값 변경 확인]");
		
		// static은 값을 공유중이기 때문에
		// 한번만 바꿔도 공유하는 모든 객체의 값이 적용됨
		k1.nationalCode = 10;
//		k2.nationalCode = 10; 불필요한 코드
		
		System.out.printf("k1 : %d / %s / %s\n", k1.nationalCode, k1.getName(), k1.getId());
		System.out.printf("k2 : %d / %s / %s\n", k2.nationalCode, k2.getName(), k2.getId());
		
		//--------------------------------
//		nationalCode 에 노란색 경고줄 뜨는이유
//		The static field Korean.nationalCode should be accessed in a static way

//		static 영역에 써있는 방식으로 접근하는게 좋음.(class명.필드명)		
//		k1.nationalCode => Korean.nationalCode
		System.out.println("\n\n");
		System.out.println("static에 선언된 이름으로 사용하기");
		System.out.println("Korean.nationalCode : " + Korean.nationalCode);
		
		System.out.println("값 변경");
		
		Korean.nationalCode =1;
		System.out.println("The new Korean.nationalCode : " + Korean.nationalCode);
		
		System.out.printf("k1 : %d / %s / %s\n", k1.nationalCode, k1.getName(), k1.getId());
		System.out.printf("k2 : %d / %s / %s\n", k2.nationalCode, k2.getName(), k2.getId());
		
		
		/************************************************************/
		
		// final 변수명 : 상수
		
		// static 변수 : 공유하는 변수
		// static final 변수 == final static 변수
		//    			       : 공유 가능한 상수
		
		// -> 용도 : 전체적으로 쓰면서 변하면 안되는 값
		// 				Math.PI (원주율)
		//				Integer.MAX_VALUE (int 최대값)
		//				Integer.MIN_VALUE (int 최솟값)
		
		System.out.println(Math.PI);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		
		
	}
}
