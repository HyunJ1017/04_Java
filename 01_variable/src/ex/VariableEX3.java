package ex;

public class VariableEX3 {
	
	public static void main(String[] srgs) {
		
		/* 강제 형변환
		 * 
		 * 1. 값의 범위가 큰 자료형 -> 작은 자료형으로 변환하는것
		 *  (데이터 손실을 고여해야 함)
		 *  
		 * 2. 의도적으로 자료형을 변환할 때
		 * 
		 * [작성법] 
		 * 
		 * (자료형) 변수명||값
		 * 
		 * - 변수명/ 값이 지정된 자료형을 변환
		 * */
		
		System.out.println("[강제 형변환 데이터손실 확인 1]");
		
		int num1 = 290;
		byte result1a = (byte)num1;	// byte 강제 형변환
		byte result1b = (byte)290;	// byte 강제 형변환
		
		System.out.println("num1 : " + num1);
		System.out.println("resut1a : " + result1a);
		System.out.println("resut1b : " + result1b);
		
		System.out.println("--------------------------------");
		System.out.println("[강제 형변환 데이터손실 확인 2]");
		
		// 실수를 정수로 강제 형변환
		// -> 소수점 버림  -> 실수를 정수로 변환
		// -> 정수 부분만 확인(손실 활용)
		
		double num2 = 123.456789;
		int result2 = (int)num2;	// int 강제 형변환
		System.out.println("num2 : " + num2 );
		System.out.println("result2 : " + result2 );
		System.out.println("num2의 소수 부분만 확인하기");
		System.out.println(num2 - (int)num2);
		// -> 0.45678900000000056 (2진수 소수 표현 시 문제점)

		/* 난수 + 강제형변환 */
		// 난수 : 0.0 <= Math.random() <1.0
		// 자료형 : double
		
		// 1~ 10 사이 난수(정수)
		// -> 강제 형변환을 이용해 소수점 제거
		int randomNumber = (int)(Math.random()*10+1);
		System.out.println( "randomNumber : " + randomNumber );
		
		System.out.println("--------------------------------");
		
		System.out.println("[의도적으로 강제 형변환]");
		
		System.out.println( 123 );
		System.out.println( (double)123 );
		
		System.out.println("--------------------------------");
		
		System.out.println("[문자(char) <-> 유니코드(int)]");
		
		System.out.println("A의 번호 : " + (int)'A'); //65
		System.out.println("a의 번호 : " + (int)'a'); //97
		
		System.out.println("박 번호 : " + (int)'박');	// 48149
		System.out.println("현 번호 : " + (int)'현');	// 54788
		System.out.println("준 번호 : " + (int)'준');	// 51456
		
		System.out.println("ㄱ 번호 : " + (int)'ㄱ');	// 12593
		
		System.out.println("ㄱ의 다음순서 : " + (char)( 'ㄱ' + 1 ) ); // ㄲ
		System.out.println("ㄱ의 다음*2순서 : " + (char)( 'ㄱ' + 2) ); // ㄳ
		System.out.println("ㄱ의 다음*3순서 : " + (char)( 'ㄱ' + 3) ); // ㄴ
		
		System.out.println("--------------------------------");
		System.out.println("[오버 플로우]");
		
		// 오버 플로우 (Overflow)
		// - 연산결과가 자료형의 값의 범위를 초과한 경우
		
		// int 자료형 최대범위 초과
		int max = Integer.MAX_VALUE;
		System.out.println("max : " + max);			// 2147483647
		System.out.println("max + 1 : " + (max+1));	//-2147483648
		
		System.out.println("--------------------------------");
		System.out.println("[상수]");
		
		/* [상수]
		 * - 한번 값을 대입하면 바꿀 수 없는 변수
		 * 
		 * [작성법]
		 * final 자료형 변수명 = 값;
		 * 
		 * -> 변수명은 대문자 + _ 형식으로 작성
		 * */
		
		final double PI = 3.141592;
		
		final int NATIONAL_CODE = 82;
		
//		NATIONAL_CODE = 81;	// 오류 발생(값 대입 불가)
		
		System.out.println(PI);
		System.out.println(NATIONAL_CODE);
		
	}

}
