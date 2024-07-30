package pkg3.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ThrowsService {
	
	Scanner sc = new Scanner(System.in);

	/* throws : 메서드 내부에서 던져진 예외를
	 * 			호출부로 다시 던지는 예외 처리구문
	 * 
	 * throw  : 생성된 예외 객체를 던져 예외 발생
	 * 			(예외 강제 발생)
	 * 
	 * 
	 * throws를 사용하는 이유
	 * 
	 * - 경고
	 * 	 -> 해당 메서드 기능을 활용하다 보면
	 * 		특정 예외가 발생할 수도 있으니 대비를 해라
	 * 
	 * - 예외 처리를 한곳에 묶어서 처리하기 위하여
	 * 	 -> 실질적으로 예외를 처리하는 try-catch 구문이
	 * 		사방에 흩어져 있을 경우
	 * 		돌려받는 최종 결과가 정상결과인지, 예외처리된 결과인지
	 * 		구분하기 힘들어짐
	 */
	
	
	public void test1() {

		// test1()에서 test2() 호출
		// -> (3) test2() 메서드에서 던져진 예외를 처리해야 함
		try {
		test2();
		} catch (Exception e) {
			// (4) test2()에서 던져진 예외를 잡아서 처리
			
			e.printStackTrace(); // 예외가 발생한 원인, 메서드 추적
		}
		
	}
	
	public void test2() throws Exception{
		// (2) throws Exception :
		// -> 메서드 내부에서 발생한 Exception 또는 자식 예외를
		//    메서드 호출한 곳으로 다시던짐
		
		// (1) 예외 강제발생
		throw new Exception();
		
	}
	
	/**
	 * test4() 호출 시 던져저 올 수 있는
	 * IOException을 대비한 코드를 작성
	 * 
	 * 대비방법 1: try-catch 작성
	 * 				-> 해당 매서드에서 예외를 처리해 없애버림
	 * 대비방법2 : throws 해당 메서드에 작성
	 *              -> 전달받은 메서드를 또 호출한곳으로 전달
	 */
	public void test3() throws IOException {
		test4(1); //전달 인자값 1 또는 2
	}
	
	/**
	 * 전달받은 num 값에 따라 IOException이 발생할 가능성이있으므로
	 * 해당 메서드를 호출하는 곳에서
	 * IOException에 대한 예외 처리 구문을 작성해야만 한다
	 * @param num
	 * @throws IOException
	 */
	public void test4(int num) throws IOException {
		// num 값에 따라 예외 발생 여부 결정
		if(num ==1) {
			throw new IOException("강제 예외 발생");
		} else {
			System.out.println("정상시행");
		}
	}
	
	
	
	public void test5() {
		
		
		int input = 0;
		do {
			System.out.println(" 예외 처리 태스트😬");
			System.out.println("1. 나누기(0으로 나누면 오류발생");
			System.out.println("2. 강제로 exception 던지기");
			System.out.println("3. 효율적인 키보드 문자열 입력코드");
			System.out.println("0. 종료");
			
			try {
				
				System.out.print("메뉴선택 : ");
				
				input = sc.nextInt();
				
				switch(input) {
				case 1 : divNum(); break;
				case 2 : forcedException(); break;
				
				case 3 : inputKeyboard(); break;
				
				case 0 : System.out.println("*** 종료 ***"); break;
				default : System.out.println("*** 잘못 입력 ***");
				}
				
			} catch (InputMismatchException e) {
				System.out.println("정수만");
				sc.nextLine();
				input = -1;
				// 첫바퀴에서 끝날까봐
				
			} catch (ArithmeticException e) {
				System.out.println("발생한 산술적 예외를 test5()에서 처리했음");
				
			} catch (Exception e) { // 다형성(업 캐스팅) 적용 가능한 가장 포괄 예외
				// IOException, Exception 2개 처리중
				System.out.println("Exception 또는 다른 예외를 처리했음");
			}
			
		} while (input != 0);
	}
	
							// 미작성시 컴파일러가 throws RuntimeException을 작성해줌
	public void divNum() /*throws ArithmeticException*/ {
		
		System.out.print("정수 입력1 : ");
		int num1 = sc.nextInt();
		System.out.print("정수 입력2 : ");
		int num2 = sc.nextInt();
		
		System.out.println("몫 : " + (num1 / num2));
		
		// num2가 0인경우
		// ArithmeticException 발생 가능성 있음
		// -> UncheckedException이어서 컴파일오류표시 안남
		
		// 그래도 발생할수 있으니까
		// 호출한곳으로 예외를 던지는 throws 사용
		
		// UncheckedException은 
		// 아무런 예외처리가 안되어 있는경우
		// 컴파일러가 자동으로 throws구문을 생성해줌
		
	}
	
	/**
	 * 강제로 Exception을 발생시켜서 던진다.
	 */
	public void forcedException() throws Exception {
		throw new Exception();
	}
	
	/**
	 * 효율적인 키보드 입력
	 * - Scanner가 아닌 다른 방법
	 * @throws IOException : 키보드 입력 시 발생할 수 있는 문제를 던짐
	 * 	 */
public void inputKeyboard() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// System.in : 키보드 입력(바이트형식의 신호로 넘어옴)
		// InputStreamReader : 읽어온 바이트를 문자로 변경하는 통로 클래스 (Object > Reader > InputStreamReader)
		// BufferedReader : 버퍼에 모여있는 내용을 한번에 읽어오는 클래스  (Object > Reader > BufferedReader)
		
		// ->  입력된 키보드 값을 문자로 변경하여 버퍼에 모은 후
		//    한 방에 읽어오는 객체를 생성함
		
		System.out.print("문자열 입력 : ");
		
		String str = br.readLine();
		
		//br.readLine() : 입력된 한줄을 통째로 읽어옴
		//   -> readLine() 메서드는 IOException을 던질 가능성이 있으므로
		//		Checked Exception 이어서 예외구문 처리를 꼭 해주어야함
		
		System.out.println("입력된 값 : " + str );
	}
	
	
	

}
