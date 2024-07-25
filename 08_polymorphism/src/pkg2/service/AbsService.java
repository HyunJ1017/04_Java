package pkg2.service;

import pkg2.dto.Animal;
import pkg2.dto.Cat;
import pkg2.dto.Fish;

public class AbsService {
	
	/*
	 * 추상 클래스 객체생성 확인
	 */
	public void test1() {
		
		System.out.println("[추상 클래스 객체생성 확인]");
		
//		Animal a = new Animal();
		//Cannot instantiate the type Animal
		// -> Animal은 객체화 할 수 없다
		// 왜? Animal은 추상(abstract) 클래스
		
		Cat c = new Cat();
		Fish f = new Fish();
		
		/*오버라이딩한 추상메서드 호출*/
		c.move();
		c.eat();
		c.sleep();
		
		f.move();
		f.eat();
		f.sleep();
		
	}
	
	/**
	 * 추상 클래스 활용법
	 * 
	 * 선행지식 : 다형성 업캐스팅 + 동적 바인딩
	 */
	public void test2() {
		
		System.out.println("[추상 클래스 활용법]");
		
		// 추상 클래스는 객체생성은 X
		// 참조형 변수는 가능
		
		Animal a1 = new Cat(2, 10);
		Animal a2 = new Fish(2, 2);
		// -> 에러 안남 확인!!!
		
		// 추상 클래스를 이용한 객체 배열
		// -> 추상 클래스 참조변수 묶음 -> 문제없음
		Animal[] animals = new Animal[4];
		
		animals[0] = new Cat();
		animals[1] = a1;	// a1에 저장된 값 == Cat 객체 참조주소
							// Cat은 Aniaml 자식 클래스
		animals[2] = new Fish();
		animals[3] = a2;
		
		for ( Animal a : animals) {
			System.out.println(a/*.toString*/);
			
			a.sleep();
			a.move();
			a.eat();
			/* Animal.sleep move eat() :
			 *  - 추상메서드 이지만 자식 클레스에서
			 *    오버라이드 해놔서 정상으로 인식 */
			
			System.out.println("--------------------------");
		}
		
	}

}
