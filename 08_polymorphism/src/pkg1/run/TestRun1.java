package pkg1.run;

import pkg1.dto.Child;
import pkg1.dto.Parent;

public class TestRun1 {
	public static void main(String[] args) {
		
		// 부모 참조 변수 = 부모객체
		// -> 양쪽 다 Parent 타입
		//  == 컴퓨터 값 처리 원칙 잘 지켜짐
		Parent p1 = new Parent();
		
		// 사용 가능한 필드/메서드 : Object, Parent
		System.out.println(p1.getLastName());
		System.out.println(p1.hashCode());
		
		
		// 자식 참조 변수 = 자식 객체
		Child c1 = new Child();
		
		// 사용 가능한 필드/메서드 : Object, Parent, Child
		System.out.println(c1.hashCode());	 // Object
		System.out.println(c1.getLastName());// Parent
		System.out.println(c1.getCar());	 // Child
		
		System.out.println("---------------------");
		
		/*  *** 다형성 - 업캐스팅(Up Casting)
		 * 
		 * - 부모 참조변수 = 자식객체;
		 * 
		 * - 상속 관계에서만 가능
		 * 
		 * - 참조하는 자식 객체가 부모 객체로 변함!!
		 */
		Parent p2 = new Child();
		
		System.out.println(p2.hashCode());	 // Object
		System.out.println(p2.getLastName());// Parent
//		System.out.println(p2.getCar());
		// Child 메서드에 접근 불가능
		
		System.out.println("---------------------");
		
		/*
		 *  *** 다운 캐스팅 (Down Casting)
		 *  
		 *   - 업 캐스팅 상태에서 (부모참조 = 자식객체)
		 *   참조변수의 자료형을 자식형태의 자료형으로 강제 형변환 하는것
		 *   
		 */
		
		Parent p3 = new Child();	// 업캐스팅된 p
		// Parent 자료형을 가진 Child자료의 p3
		
		/* P3(Parent)를 Child로 강제로 형변환 하여
		 * c3에 주소를 대입함*/
		Child c3 = (Child)p3;
//		Child c4 = (Child)p1; // 이거 안됨
		//class pkg1.dto.Parent cannot be cast to class pkg1.dto.Child (pkg1.dto.Parent and pkg1.dto.Child are in unnamed module of loader 'app')
		
		// 아래 방법처럼 필요할 때 마다 형변환 가능 하지만
		// 가독성이 떨어져
		// 보통 자식 참조변수에 대입해 사용
//		((Child)p3).setCar("수박카");
		c3.setCar("수박카");
		
		System.out.println(c3.getCar());
		System.out.println(((Child)p3).getCar());
		// -> p3는 Child 자료형, Car에다가 자료 넣을 수 있음
		
		System.out.println("---------------------");
		
		/*
		 * Object 를 이용한 업캐스팅
		 * + 객체 타입에 따른 다운캐스팅
		 */
		
		// Objact : 모든 클래스/객체의 최상위 부모
		Object[] arr = new Object[3];
		
//		Object 참조변수  = Parent/Child/Object 객체
		arr[0]           = new Parent(); // Parent -> Object로 업 캐스팅
		arr[1]			 = new Child();	 // Child  -> Object로 업 캐스팅
		arr[2]           = new Object();
		
		
		/*
		 * instanceof 연산자
		 * 
		 * [작성법]
		 * 참조변수명 instanceof 클래스명
		 * 
		 * return boolean;
		 * 
		 * ** 주의사항 **
		 * - instanceof 는 참조하고 있는 객체의
		 * 상속관계까지 파악할수 있음
		 * 
		 * Child 보고 Parent, Object냐고 하면 true라고함
		 * 
		 * Parent p = new Child // 업캐스팅
		 * 
		 * p instanceof Child
		 *  => true
		 * p instanceof Parent
		 *  => true
		 *  
		 *  ==> 주의 사항을 잘 이용하면
		 *     Parent, Child 클래스 상속 관계가 맞는지
		 *     확인하는 용도로도 사용 가능!
		 */
		
		for(Object obj : arr) {
			/* 자료형을 연달아 검사하는 경우
			 * 마지막(하위) 자식부터 검사하는게 좋음*/
			
			// 얻어온 요소가 Child 타입이면
			if(obj instanceof Child) {
				System.out.println("Child 입니다.");
			} else if (obj instanceof Parent) {
				System.out.println("Parent 입니다.");
			} else {
				System.out.println("Object 입니다.");
			}
		}
		
		System.out.println("-------------------------------");
		System.out.println("[부모 -> 자식 역순 검사 문제점]");
		
		for(Object obj : arr) {
			// 얻어온 요소가 Object  타입이면
			if(obj instanceof Object) {
				System.out.println("Object 입니다");
			}
			
			// 얻어온 요소가 Parent 타입이면
			else if(obj instanceof Parent) {
				System.out.println("Parent 입니다");
			}
			
			// 얻어온 요소가 Child 타입이면
			else {
				System.out.println("Child 입니다");
			}
		}
		
	}

}
