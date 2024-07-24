package pkg1.run;

import pkg1.dto.Car;
import pkg1.dto.Carnibal;
import pkg1.dto.Sonata;

public class Run1 {
	public static void main(String[] args) {
		
		Car c1 = new Sonata("0000");
		
		System.out.println(c1.inform());	// car.inform()은 name만 나오는데 오버라이드된 Sonata.inform() 나옴
		
		Sonata son1 = (Sonata)c1;
		System.out.println(son1.inform());	// Sonata.inform() 나옴
		
		son1.setName("Sonata");
		son1.setCarNumber("0101");
		
		System.out.println(c1.inform());
		
		((Sonata)c1).setCoast(100);
		
		System.out.println(son1.inform());
		
		System.out.println("-------------------");
		
		Car c2 = new Sonata("0102");
		Car c3 = new Carnibal("0103");
		
//		System.out.println(c2.inform());
//		System.out.println(c3.inform());
		
		Sonata son4 = new Sonata("0104");
		Carnibal cnb5 = new Carnibal("0105");
		// 자식형태라 Car 자료형에도 알아서 들어가나???
		Car c6 = new Car("0106");
		Car[] carArr = new Car[6];
		
		carArr[0] = c1;
		carArr[1] = c2;
		carArr[2] = c3;
		carArr[3] = son4;
		carArr[4] = cnb5;
		carArr[5] = c6;
		
		for (Car car : carArr) {
			System.out.println(car.inform());
		}
		
		System.out.println("-------------------");
		System.out.println("[class 확인]");
		
		int count = 0;
		for (Car car : carArr ) {
			
			System.out.print(count + "번 : ");
			count++;
			
			if ( car instanceof Sonata) {
				System.out.println("Sonata");
			}
			
			else if ( car instanceof Carnibal) {
				System.out.println("Carnibal");
			}
			
			else if ( car instanceof Car) {
				System.out.println("Car");
			}
			
			else {
				System.out.println("글러먹음");
			}
		}
		
		System.out.println(cnb5.getFuel());
//		System.out.println(carArr[4].getFuel());
		System.out.println(((Carnibal)carArr[4]).getFuel());
		// carArr[4] 자료형 Carnibal이라는데 왜 저지랄이지
		// 불러올때 캐스팅도 안했는데
		// 배열이 Car[]이어서 매서드 가져올때 다운캐스팅 필요??
		/* GPT 왈
		 * 
		 * 캐스팅을 해야 하는 이유는 Java가 컴파일 시점에 타입 검사를 하기 때문입니다.
		 * carArr은 Car 타입의 배열이므로 Car 클래스에 정의되지 않은 메서드를 직접 호출할 수 없습니다.
		 * 하지만 carArr[4]에 저장된 객체가 실제로 Carnibal 타입이라는 것을 알기 때문에
		 * 다운캐스팅을 통해 Carnibal 클래스의 메서드를 호출할 수 있습니다.
		 * */
		
		System.out.println("-------------------");
		System.out.println(" carArr[4] 확인 ");
		if( carArr[4] instanceof Carnibal) {
			System.out.println("맞음");
		} else {
			System.out.println("틀림");
		}
		System.out.println("-------------------");
		
		System.out.println(carArr[4].inform());
		System.out.println(carArr[4].getClass());
		System.out.println(carArr[5].getClass());
//		System.out.println(((Sonata)carArr[5]).getCoast());
		//class pkg1.dto.Car cannot be cast to class pkg1.dto.Sonata
		
		
	}

}
