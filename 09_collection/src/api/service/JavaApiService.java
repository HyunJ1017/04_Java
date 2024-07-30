package api.service;

import java.util.Arrays;
import java.util.Scanner;

import api.dto.TestDTO;

public class JavaApiService {
	
	// String = 123 + ""; => 이거 하면 별로인 이유 배울거임
	// => 메모리 효율이 안좋음
	/*
	 * String
	 * - jaca.lang 패키지에서 제공
	 * - 문자열을 저장하고 다루는 용도의 클래스
	 * 
	 * [String 객체를 생성하는 2가지 방법]
	 * 
	 * 1) String s1 = "Hello";	// 리터럴 표기법을 이용한 방법
	 *  -> Heap 영역 내부에 Constant(상수) Pool에 String 객체 생성
	 * 
	 * 2) String s1 = new String("Hello");	// new 연산자 이용한 방법
	 *  -> Heap 영역에 String 객체 생성
	 * 
	 * 
	 * [String의 불변성(immutable)]
	 * - String은 기본적으로 값이 변하는것이 불가능(상수 Constant)
	 * 
	 * 	ex) String str = "abc"	//abc		/참조주소 : 0x100
	 * 		str += "def";		//abcdef	/참조주소 : 0x300
	 * 
	 * 		-> 참조하는 객체의 주소가 달라진다!!!
	 * 		-> 다른 객체가 된다
	 * 
	 */

	/**
	 * [String 불변성 확인]
	 * 
	 * - String 클래스에서 값을 저장하는 value필드가 final로 선언되어있음
	 *   -> 상수 == 변경불가
	 *   -> 값을 변경하면 새 객체를 만든 후 반환해줌
	 * 
	 * - System.identyHashCode(참조변수)
	 *  	-> 객체의 주소 값을 이용해서 생성된 해시코드
	 *  		= 임시주소 (Java는 자료 저장된 주소 못보게 되어있음)
	 * 	 		(HashCode : 객체를 식별하기 위한 각자의 코드)
	 *  
	 *  - 같은 객체에 저장된 값이 변했다면 주소값은 일정해야만 한다!!
	 *    
	 *  - 참조하고 있던 객체가 변했다면 주소값은 변하게 된다.
	 */
	public void test1() {
		
		TestDTO t = new TestDTO();
		
		// TestSTO 객체의 주소를 이용해서 만든 해시코드 확인
		System.out.println("TestDTO : " + System.identityHashCode(t));
		
		// TestDTO 객체의 필드 값을 변경
		t.setNum(200);
		t.setStr("apple");
		
		System.out.println("변경 후 TestDTO : " + System.identityHashCode(t));
		// 객체의 필드값을 변경한 후에도 객체가 바뀌지 않은것을 확인
		
		System.out.println("----------------------------------\n");
		
		// String 객체 생성(리터럴 표기법 이용 방법)
		String s = "Hello";
		System.out.println("String s : " + System.identityHashCode(s));
		
		// s가 참조하는 객체 값을 변경
		s += "World"; 
		System.out.println("누적 String s : " + System.identityHashCode(s));
		s = "World"; 
		System.out.println("변경 String s : " + System.identityHashCode(s));
		
	}
	
	/**
	 * Constant Pool 확인
	 * 
	 * - "" String 리터럴표기법을 이용해서 생성된 Strig 객체가
	 * 	 저장되는 Heap 내부 영역
	 * 
	 * - 동일한 문자열을 생성하게 되는경우
	 *   객체가 새롭게 생성되지 않고 기존 주소가 반환된다. (재활용)
	 */
	public void test2() {
		
		String s1 = "Hello";	// 2055281021 (상수풀 생성)
		
		System.out.println("s1 : " + System.identityHashCode(s1));
		
		// 같은 값을 지닌 Strinf 생성
		String s2 = "Hello";	// 2055281021 (상수풀 객체 재활용)
//		String s2 = s1; => 이게 주소 복사하는 얕은복사
		System.out.println("s2 : " + System.identityHashCode(s2));
		
		// 같은 값을 지닌 String을 new 연산자를 이용해 생성
		String s3 = new String("Hello");	// 1804094807 (Heap 새로 생성)
		System.out.println("s3 : " + System.identityHashCode(s3));
		
		System.out.println("----------------------------------\n");
		
		// s1, s2는 같은 객체를 참조한다.
		// == s1, s2에 저장된 주소값이 같음
		// -> equals()를 사용하지 않아도 비교 가능
		System.out.println("s1 == s2 : " + (s1 == s2) );	// true
		
		// s1, s3는 저장된 값은 같아도 서로 다른 객체를 참조하고 있음
		// == s1, s3의 주소값이 다르기 때문에
		//    비교연산 시 무조건 false
		
		// -> 그래서 문자열 비교는 equals()로 하는게 속편함
		System.out.println("s1 == s3 : " + (s1 == s3) );	// false
		System.out.println("s1.equals( s3 ) : " + s1.equals(s3) );	// true
		
//		s3 = "World"; 
//		System.out.println("변경 String s3 : " + System.identityHashCode(s3));
//		s3 += "World"; 
//		System.out.println("누적 String s3 : " + System.identityHashCode(s3));
		
	}
	
	/**
	 * StringBuilder / StringBuffer 클래스
	 * - String의 불변성 문제를 해결한 클래스
	 *  -> 가변성(mutable)
	 * 
	 * - 기본 16글자 저장할 크기로 생성
	 *   저장되는 문자열의 길이에 따라 크기가 증가/감소
	 *   -> 마음대로 문자열 수정, 삭제 가능!
	 *   -> 수정, 삭제를 해도 추가적인 객체 생성이 없어 효율 좋음!
	 *   
	 *  
	 * - StringBuilder : Thread Safe 미제공 (비동기, 추천)
	 * - StringBuffer  : Thread Safe   제공 (동기)
	 */
	public void test3() {
		
		// 둘다 사용가능한 메서드가 똑같아서 하나만 연습
		// StringBuilder 객체 생성
		StringBuilder sb = new StringBuilder();
		
		// StringBuilder는 내부 필드에 문자열을 추가하여 누적하는 방식
		
//		문자열 추가 전 주소
		System.out.println("sb : " + System.identityHashCode(sb));
		
		// 1) append("문자열") : 문자열을 뒤쪽에 추가
		sb.append("Hello");
		System.out.println("sb : " + System.identityHashCode(sb) + ", " + sb);
		sb.append(" World");
		sb.append("\n");
		sb.append("점심");
		sb.append(" 시간");
		sb.append(" 언제되지");
		
		// -> 객체의 필드값만 변하고 있음. (가변성 확인)
		System.out.println("sb : " + System.identityHashCode(sb) + ", " + sb);
		
		// 2) toString() : 필드값을 문자열로 반환
		System.out.println(sb.toString());
		System.out.println(sb           );
		
	}
	
	/**
	 * String 관련 매서드
	 */
	public void test4() {
		
		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		
		System.out.println("[아무 단어/문장 5번 입력하기]");
		
		for (int i=0; i<5 ; i++ ) {
			// 입력받은 값을 StringBuilder에 누적
			// 리터럴 표기법으로 만들었으면 새 객체 6번 만들었을거임
			// 메모리낭비 -> 탄소배출증가 -> 환경오염
			System.out.print(i + " : ");
			sb.append( sc.nextLine() );
		}
		
		System.out.println("---------------");
//		System.out.println(sb.toString());
		// \n 는 안먹음
		
		// Stringbulder에 누적된 문자열을 String 형태로 반환
		String input = sb.toString();
		
		// 1) String[] 문자열.split("구분자")
		//  - 문자열을 "구분자"를 기준으로 나누어
		//    String[] 형태로 반환
		
		String[] arr = input.split("");
		
		System.out.println( Arrays.toString(arr) );
		
		// 2) String String.join("구분자", 배열)
		// - String 배열을 하나의 문자열로 변환
		// - 각 요소 사이에 "구분자"추가
		
		String result = String.join("", arr);
		
		System.out.println(result);
		
		// 3) String 문자열.replace("대상문자열", "바꿀문자열")
		// - 문자열 변경
		
		String str = "Test";
		String str2 = str.replace("es", "arge");
		
		System.out.println(str2);
		
		sc.close();
		
	}

}
