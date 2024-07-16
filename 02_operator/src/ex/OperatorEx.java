package ex;

import java.util.Scanner;

/**
 *  예제 기능용 클래스
 *  */
public class OperatorEx {
	
	// OperatorRun에서 호출할 수 있는 기능을 정의 해두는 클래스
	
	// method == 객체(클래스)가지고 있는 기능(function)
	
	// test1() 메서드
	public void test1() {
		System.out.println("test1() 메서드 호출됨");
	}
	
	public void test2() {
		System.out.println("test2() 메서드 호출됨");
	}
	
	
	
	/**
	 * 입력 받은 두 정수의 산술 연산 결과 출력하기
	 * 
	 * 정수 입력 1 : 10
	 * 정수 입력 2 : 3
	 * 
	 * 10 + 3 = 13
	 * 10 - 3 = 7
	 * 10 * 3 = 30
	 * 10 / 3 = 3
	 * 10 % 3 = 1 
	 */
	
	public void method1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 1 : ");
		int num1 = sc.nextInt();	// 입력버퍼에 있는 정수를 읽어오고 enter는 남김
		
		System.out.print("정수 입력 2 : ");
		int num2 = sc.nextInt();
		
		System.out.println();
		
		// 10 + 3 = 13
		System.out.println(num1 + " + " + num2 + " = " + (num1+num2));
		// 10 - 3 = 7 , \n:개행문자(escape문자)
		System.out.printf("%d - %d = %d \n", num1, num2, num1 - num2);
		System.out.printf("%d * %d = %d \n", num1, num2, num1 * num2);
		System.out.printf("%d / %d = %d \n", num1, num2, num1 / num2);
		System.out.printf("%d %% %d = %d \n", num1, num2, num1 % num2);
		// printf 에서 %(나머지) 는 %% | /% 로 작성 해야 함
		
		
	}
	
	/**
	 * 입력받은 정수가 3의 배수가 맞는지 확인
	 */
	public void method2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 입력 : ");
		int input1 = sc.nextInt();
		
		// input1이 3의 배수가 맞으면 true, 아니면 false
		boolean isTrue = input1 % 3 == 0;
		
		System.out.printf("%d는 3의 배수인가? %b", input1, isTrue);
		
	}
	
	
	/**
	 * 첫 번째 입력받은 수가
	 * 두번째 입력받은 수의 배수가 맞는지
	 * 확인
	 * 
	 * [true인 경우]
	 * 첫번째 입력 : 20
	 * 두번째 입력 : 5
	 * 20은 5의 배수가 맞는가? true
	 * 
	 * [false인 경우]
	 * 첫번째 입력 : 17
	 * 두번째 입력 : 5
	 * 17은 5의 배수가 맞는가? false
	 */
	public void method3() {
		
		Scanner superscanner09 = new Scanner(System.in);
		
		System.out.println("정수 입력 1 : ");
		int input1 = superscanner09.nextInt();
		
		System.out.println("정수 입력 2 : ");
		int input2 = superscanner09.nextInt();
		
		boolean isFalse = input1 % input2 == 0;
		
		System.out.printf("%d는 %d의 배수가 맞는가? %b", input1, input2, isFalse);
		
	}
	
	
	/**
	 * 생성된 난수가 1에서 10 사이 짝수가 맞는지 확인
	 * 
	 * (난수 범위 1 ~ 20)
	 */
	public void method4() {
		
		int num = (int) ( Math.random() * 20 + 1 );
		
		System.out.printf("생성된 난수는요 %d 입니다. \n", num);
		
		boolean isTrue = num < 11 && num % 2 == 0 ;
		
		System.out.println("난수가 1에서 10 사이 짝수 맞아?? " + isTrue);
		
		
	}
	
	
	/**
	 * 입력 받은 수가 짝수이거나
	 * 10보다 큰 수인지 확인
	 */
	public void method5() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자 입력 : ");
		int input = sc.nextInt();
		
		boolean or = input > 10 || input % 2 != 1;
		
		System.out.printf("입력받은 %d가 짝수이거나 10보다 큰가? %b", input, or);
	}
	
	
	/**
	 * [삼항 연산자 1]
	 * 1 ~ 10 사이 난수를 발생 시켜
	 * 홀 짝 검사를 시행
	 */
	public void method6() {
		
		int ran = (int) ( Math.random() * 10 + 1 );
		
		char str = ran % 2 == 0 ? '짝' : '홀' ;
		
		System.out.printf("생성된 난수 %d은(는) %c수 입니다.", ran, str);
		
	}
	
	
	/**
	 * [삼항 연산자 2]
	 * 나이를 입력받아
	 * 13세 이하면 "어린이"
	 * 14세 이상 19세 이하 "청소년"
	 * 20세 이상 "성인"
	 * 출력하기
	 */
	public void method7() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("나이 입력 : ");
		int age = sc.nextInt();
		
		String result = age <= 13 ? "어린이" : (age >= 20 ? "성인" : "청소년");
		
		System.out.println("result : " + result);
		
	}

}
