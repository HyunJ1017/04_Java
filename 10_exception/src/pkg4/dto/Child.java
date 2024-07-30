package pkg4.dto;

import java.io.EOFException;
//import java.io.IOException;

public class Child extends Parent{

	// 부모랑 예외처리구문이 같으면 문제가 없음
//	public void method1() throws IOException {}
	
	// 부모 예외 -> 자식예외
	// 문제없음
	@Override
//	public void method1() throws IOException { }
	public void method1() throws EOFException {	}

	
	// 부모예외 -> 더 부모예외
	// 에러발생
//	@Override
//	public void method2() throws IOException { }
//	public void method2() throws Exception { }
	
	// throws 없애면?
	// 문제없음
	@Override
	public void method3() {	}
	// 오버라이딩한 코드에서 예외가 발생하지 않을수도 있음
	
}
