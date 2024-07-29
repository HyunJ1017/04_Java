package wrapper.service;

import java.util.ArrayList;
import java.util.List;

// Java에서 중요한 클래스만 모아둔 패키지
// -> String, Wrapper Class 등
// * 미작성 시 컴파일러가 자동으로 추가해주는 구문
/* import java.lang.*;*/

public class WrapperService {
	
	/* Wrapper Class
	 * 
	 * - wrap : 감싸다, 포장하다
	 * 
	 * - 기본 자료형을 객체(속성, 기능)로 감싸는 클래스
	 *   -> 기본 자료형의 객체화
	 *   
	 *   -> 왜? 컬렉션 처럼 객체만 취급하는 상황에서
	 *      기본 자료형도 취급 가능한 형태로 바꾸기 위해서
	 *   
	 * 
	 *              -->   Boxing
	 *   Unboxing  <--
	 *   
	 *   boolean   <-->   Boolean
	 *   byte      <-->   Byte
	 *   short     <-->   Short
	 *   int       <-->   Integer
	 *   long      <-->   Long
	 *   float     <-->   Float
	 *   double    <-->   Double
	 *   char      <-->   Character
	 *  				  (Class명이어서 머릿글자가 대문자로 외움)
	 *  
	 *  		(int num = 0; \n Integer i = new Integer(num);)
	 *  * Boxing, Unboxing을 자동으로 수행되도록 구현되어 있음
	 *   -> Auto Boxing, Auto Unboxing
	 *   
	 * 
	 *  + Wrapper Class를 이용해 객체화 되었을 때
	 *  추가적인 필드, 기능을 제공함
	 */
	
	public void test1() {
		
		/** int -> integer로 Boxing*/
		int num = 100;
		/* Integer wrap1 = new Integer(num); */
		//he constructor Integer(int) has been deprecated since version 9 and marked for removal
		//deprecated : 더이상 사용되지 않는
		//9버전부터 안쓴다고 함
		
		Integer wrap1 = num;
		// -> 컴파일러가 Auto Boxing을 수행하여 오류가 발생하지 않음
		//	(컴파일러가 new Integer(num1) 형태로 변환)
		
		/** integer -> int로 Unboxing */
		int num2 = wrap1.intValue();	// 정석방법
		
		int num3 = wrap1;	// (integer)
		// -> 컴파일러가 자동으로 Auto Unboxing 수행
		// (wrap1 -> wrap1.Integer()로 변환)
		
		/* int 자료형을 저장하는 List(Collection) */
//		List<int> list = new ArrayList<int>();
		// -> 제네릭에 기본자료형 작성 시 오류 발생
		
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(100);	// (int)100 -> (Integer)100
						// 		Auto Boxing
		
		list.add(300);
		
		list.add(1, 200);	// 1번 인덱스에 200을 추가, 원래 있던건 뒤로 미룸
		
		// 향상된 for문
		// 좌변 : 각 인덱스(요소) 값을 얻어와 저장할 변수
		// 우변 : 배열 또는 컬랙션
		for ( int i : list) {
			// Auto Unboxing
			System.out.println(i);
			
		}
		
		int num4 = (num2 + num3) * 20;
		
		Integer wrap4 = num4; // int -> Integer
		
		// Integer -> long
		
		// (Integer) 4000 	-> (int) 4000	// Auto Unboxing
		// (int) 4000 		-> (long) 4000	// 자동 형변환
		long long4 = wrap4;
		
		System.out.println(long4);
		
	}
	
	/**
	 * Wrapper Class가 제공하는 필드, 메서드
	 *  -> 대부분이 static으로 되어있음
	 *  -> 프로그램 실행 시 영역에 필드/메서드 생성
	 *  --> 클래스명.필드명 / 메서드명() 으로 사용 가능(Wrapper Class도 컴파일러에서 자동 제공)
	 */
	public void test2() {
		
		System.out.println("\n[ 정수형/ 실수형 공통 필드 ]\n");
		
		// 정수형/ 실수형 공통 필드
		System.out.println("byte의 용량 : "   + Byte.BYTES        + "바이트");
		System.out.println("int의 용량 : "    + Integer.BYTES     + "바이트");
		System.out.println("double의 용량 : " + Double.BYTES      + "바이트");
		
		System.out.println("byte의 용량 : "   + Byte.SIZE         + "바이트");
		System.out.println("int의 용량 : "    + Integer.SIZE      + "바이트");
		System.out.println("double의 용량 : " + Double.SIZE       + "바이트");
		
		System.out.println("int 최대값 : "    + Integer.MAX_VALUE + "바이트");
		System.out.println("int 최소값 : "    + Integer.MIN_VALUE + "바이트");
		
		System.out.println("==============================");
		System.out.println("\n[ 실수형만 사용 가능한 필드 ]\n");
		
		/*실수형만 사용 가능한 필드*/
		System.out.println(Double.POSITIVE_INFINITY);
		System.out.println(Double.NEGATIVE_INFINITY);
		System.out.println(Double.NaN);
//		System.out.println(Double.POSITIVE_INFINITY + Double.NEGATIVE_INFINITY);
		System.out.println("==============================");
		System.out.println("\n[ 논리형은 TRUE/FALE만 존재 ]\n");
		
		// 논리형은 TRUE/FALE만 존재
		System.out.println(Boolean.TRUE);
		System.out.println(Boolean.FALSE);
		
		System.out.println("==============================");
		System.out.println("\n[ Strig -> 기본자료형 변환 ]\n");
		
		// 다른언어(특히 HTML, JS)에서 전달된 값이 있을 경우
		// 보통 String 형태로 전달되어져서 오는 경우가 많다.
		// 이를 Java에서 기본 자료형으로변환하는 경우 사용!
		
		// 단, char(Character)는 존재하지 않음
		
		/* WrapperClass.parse 자료형("문자열")
		 * 
		 * parsing(파싱)	: 성질(형태) 자체를 다른것으로 변경
		 * 					  String -> int
		 * 
		 * casting(형변환)	: 값의 범위 변경
		 * 
		 */
		byte b = Byte.parseByte("1");
		short s = Short.parseShort("2");
		int i = Integer.parseInt("3");
		long l = Long.parseLong("4");
		float f = Float.parseFloat("0.5");
		double d = Double.parseDouble("6.0");
		boolean b1 = Boolean.parseBoolean("FALSE");
		
		System.out.println("변환 확인");
		
		System.out.println("==============================");
		System.out.println("\n[ 기본자료형 -> Strig 변환 ]\n");
		
		// (int) 500 => (String) "500"
		
		// 방법 1: 기본자료형 + ""(String) = String
		int num5 = 500;
		String change1 = num5 + "";	// 권장하지 않는 방법
		
		// 방법2) Wrapper Class의 ValueOf() / toString()  이용하기
		String change2 = Integer.valueOf(num5).toString();
		String change3 = Integer.toString(num5);
		

		System.out.println( change1 );
		System.out.println( change1 instanceof String );
		System.out.println( change2 );
		System.out.println( change2 instanceof String );
		System.out.println( change3 );
		System.out.println( change3 instanceof String );
		
		
		
	}
	
}
