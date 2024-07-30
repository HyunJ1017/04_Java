package pkg1.service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchService {
	
	Scanner sc = new Scanner(System.in);
	
	/*
	 * Exception(예외) : 코드로 해결 가능한 에러
	 * 	(if, try-catch, throws 등)
	 * 
	 * Exception Handling(예외처리)
	 * 	예외 발생시 이를 처리하는 구문(try-catch, throws)
	 * 
	 */
	
	/**
	 * 고의적으로 예외 발생시키기
	 */
	public void test1() {
		
		// NullPointerException
		// -> 참조하고 있는 객체가 없는데 객체의 필드/메서드를 호출할 때 번져지는 예외
		
//		String str = null;
//		str.split("/");
		
		// ArrayIndexOutOfBoundsException
		// - 배열의 index 범위를 초과한 경우 던져지는 예외
//		int[] arr = new int[3];
//		arr[5] = 3;
		
		
		// InputMismatchException
		// - 스캐너 입력 시
		//   next자료형() 으로 일어오는 값과
		//   입력된 값의 자료형이 일치하지 않을때
		System.out.print(" 정수 : ");
		int num = sc.nextInt();	//	콘솔 입력시 문자열 입력
		// 콘솔 입력시 문자열/실수/값의 범위가 잘못 되었을 때
		
		System.out.println(num);
		
	}

	/**
	 * try-catch를 이용한 예외처리
	 * 
	 * <pre>
	 * - try {  } : 예외가 발생할 가능성이 있는 코드를
	 * 				{ } 내부에 작성하여 시도
	 * 
	 * - catch(예외참조변수 ) { }
	 * 		try에서 던져진 예외를 ()에 작성된 참조변수로 잡아서
	 * 		처리하는 구문
	 * 
	 * <pre>
	 */
	public void test2() {
		
		try {
			// InputMismatchException 던져질 가능성이 있는 코드
			System.out.print("정수입력1 : ");
			int num1 = sc.nextInt();
			
			System.out.print("정수입력2 : ");
			int num2 = sc.nextInt();
			
			System.out.println("합계 : " + (num1 + num2));
			
		} catch (InputMismatchException e) {
			// try 에서 던져지게 될
			// InputMismatchException 객체를 잡아서 처리하는 구문
			
			System.out.println("정수만 입력해 주세요");
			
			// 발생된 예외를 처리했기 때문에
			// 어떤 이유로 어디서 무슨 예외가 발생했는지
			// 콘솔에 빨갛게 뜨는 stackTrace 구문이 출력되지 않음
			
			/* e.printStacTrace()
			 * - 예외 발생 원인, 발생된 메서드 추적결과를
			 *  콘솔에 출력하는 메서드
			 *  --> 원래 예외 발생하면 나타나는 구문
			 */
//			e.printStackTrace();
			
			/* String e.getMessage();
			 * 
			 * - 예외 원인이 작성된 message를 문자열로 반환
			 */
//			System.out.println(e.getMessage());
			
		}
		
	}
	
	public void test3() {
		try {
			System.out.print("정수입력1 : ");
			int num1 = sc.nextInt();
			
			System.out.print("정수입력2 : ");
			int num2 = sc.nextInt();
			
			System.out.println("나누기 : " + (num1 / num2));
			// ->  InputMismatchException만 처리한 경우
			//		0으로 나누었을 때 발생하는
			//		ArithmeticException(산술적예외)를 처리하지 못하여
			//		프로그램이 장제 종료되는 문제 발생
			
		} catch (InputMismatchException e) {
			System.out.println("int 범위 정수만 입력 해 주세요");
		} catch (ArithmeticException e) {
			// 앞에서 퍼리하지 못한 산술적 예외를 잡아서 시행
			System.out.println("0으로 나눌 수 없습니다.");
		}
		
		// 발생된 예외를 처리했기 때문에 수행될 수 있는 구문
		System.out.println("q(≧▽≦q)  프로그램 종료  q(≧▽≦q)");
	}
	
	/**
	 * 예외처리 + 다형성(업 캐스팅)
	 * RuntimeException : 실행중 발생하는 모든 예외의 최상위 부모 예외
			 - Unchecked Exception 
			 -> 예외처리 구문을 꼭 작성할 필요는 없는 예외
	 */
	public void test4() {
		
		try {
			System.out.print("정수입력1 : ");
			int num1 = sc.nextInt();
			
			System.out.print("정수입력2 : ");
			int num2 = sc.nextInt();
			
			System.out.println("나누기 : " + (num1 / num2));
			
		} 
		// 자식 타입 예외를 먼저 처리
		// -> 부모 타입을 나머지 예외를 처리하는(else) 형식으로 사용
		catch (InputMismatchException e) {
			
			System.out.println("int 범위 정수만 입력해 주세요");
			
		}
		catch ( RuntimeException e ) {
			// catch에 매개변수타입을 부모 타입으로 설정
			// -> 던져지는 모든 자식 타입의 예외를 잡아서 처리
			// -> 예외처리에 다형성(업캐스팅) 적용
			
			// 장점 : 여러 예외처리 구문을 작성하지 않고도 예외처리가가능
			
			// 단점 : 발생하는 예외별 처리방법을 제시할 수 없음
			 
			System.out.println("뭔지모르지만 예외 발생");
			
		} 
		
		// InputMismatchException에 컴파일에러
		// 발생이유 :  It is already handled by the catch block for RuntimeException
		//             앞에서 부모타입 참조변수를 이용해 자식타입 예외를 잡아서 처리했기
		//			   때문에 도달할 수 없는 코드가 되어버림
		// 해결방법 : 부모 처리구문보다 앞에 작성하면 해결
//		catch (InputMismatchException e) {
//			System.out.println("int 범위 정수만 입력해 주세요");
//		}
		
		// 발생된 예외를 처리했기 때문에 수행될 수 있는 구문
		System.out.println("(￣︶￣）↗　프로그램 종료  （￣︶￣）↗　");
	}
	
	/**
	 * catch문에 다형성 적용 복습+ 예외 강제 발생
	 * 
	 * - throw new 예외();
	 * 		-> 생성된 예외 객체를 던짐 == 예외 강제 발생
	 * 
	 */
	public void test5() {
		
		// Exception 클래스 : 모든 예외의 최상위 부모
		
		System.out.println("---- 던질 예외 선택 ----");
		System.out.println("case 1 : throw new Exception();");
		System.out.println("case 2 : throw new RuntimeException();");
		System.out.println("case 3 : throw new ArithmeticException();");
		
		try {
			int input = sc.nextInt();
			
			switch(input) {
			case 1 : throw new Exception();
			case 2 : throw new RuntimeException();
			case 3 : throw new ArithmeticException();
			}
		} catch (InputMismatchException e) {
			System.out.println("int 정수만 입력 해 주세요");
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException 예외처리 완료");
		} catch (RuntimeException e) {
			System.out.println("RuntimeException 예외처리 완료");
		} catch (Exception e) {
			System.out.println("Exception 예외처리 완료");
		} 
		
	}
	
	/**
	 * checked / Unchecked Exception 확인
	 * 
	 * 1) Checked Exception
	 * 	- 반드시 예외처리구문을 작성해야하는 예외
	 * 	- 예외처리구문 미작성 시 컴파일 에러 발생
	 * 
	 * 2) Unchecked Exception
	 * 	- 예외처리구문을 작성여부가 필수가 아닌 선택하는예외
	 *  - 예외처리구문을 작성하지 않아도 컴파일에러가 발생하지 않음
	 *  - 대부분 Unchecked Exception는 if문으로 해결이 가능
	 *  	(사용자, 이용자의 실수 방지)
	 */
	public void test6() {
		
		// Unchecked Exception 확인
		// -> 컴파일 에러 없음!!
		// throw new RuntimeException();
		
		
		// Checked Exception 확인
		// -> 컴파일 에러(빨간줄) 발생!!
		
		// Unhandled exception type Exception
		// -> 예외처리 안했어~
		//throw new Exception(); 
		// -> 예외 처리 코드 작성 필요
		
	}
}
