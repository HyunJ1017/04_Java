package ex;

public class VariableEX2 {
	
	public static void main(String[] args) {
		
		
		/* ▶컴퓨터 값 처리 원칙
		 * 
		 * - 같은 자료형 끼리만 연산이 가능하고
		 * 	 결과도 같은 자료형만 만환된다.
		 * 
		 * ▶형변환(Casting)
		 * 
		 *  - 데이터의 자료형을 변환
		 *  
		 * ▶자동 형변환
		 *   
		 *  - 값의 번위가 서로 다른 값들의 연산 시
		 *    컴파일러가 자동으로 범위가 작은값을
		 *    큰 값의 자료형으로 변환시켜 주는 것
		 * 
		 * */
		
		System.out.println("[자동 형변환 예시]");
		// 다른 자료형 끼리 연산
		int num1a = 12;
		double num1b = 3.5;
		double result = num1a + num1b;
		System.out.println(result);
		// 같은 자료형끼리 연산
		// (컴퓨터 값처리 원칙과 연관성이 깊은)
		int num2a = 3;
		int num2b = 2;
		double result2 = num2a / num2b;
		System.out.println(num2a/num2b);	// 3 / 2 = 1.5 > 1
		System.out.println(result2);		// 3 / 2 = 1.5 > 1 > 1.0
		// 여러 자료형의 연산
		int num3a = 777;
		long num3b = 10000000000L;
		
		double result3 = num3a + num3b;
		System.out.println(result3);		//1.0000000777E10
									//부동소수점 : E10 = * 10^10
		
		System.out.println("----------------------------");
		
		/* [자동 형변환이 되지 않는 경우]
		 * 
		 * 값의 범위가 더 큰 자료형을
		 * 값의 범위가 더 작은 변수에 대입 불가
		 * 
		 * -> 억지로 대입하려면 "강제형변환"을 이용
		 * */
		
//		int a = 100;
//		double b = 23.4;
//		int result = a + b;	// a+b = 100.0 + 23.4
							//     = 123.4(double)
		
	}

}
