package pkg3.run;

import pkg3.dto.PHJCalculator;

public class CalculatorRun {
	public static void main(String[] args) {
		
		// 인터페이스도 추상클래스 처럼
		// - 객체 생성 X
		// - 부모 타입 참조 변수로 사용  O
		//   -> 다형성 업캐스팅 + 동적 바인딩
		PHJCalculator c = new PHJCalculator();
		
		System.out.println( c.plus(30000, 12000) );
		System.out.println( c.minus(1200, 456) );
		System.out.println( c.multi(23, 123));
		System.out.println( c.div(45, 7));
		System.out.println( c.mod(500, 123));
		System.out.println( c.pow(5, 2));
		System.out.println( c.arrOfCircle(15));
		System.out.println( c.toBinary(524921265));
		System.out.println( c.toHexadecimal(524921265));
	}

}
