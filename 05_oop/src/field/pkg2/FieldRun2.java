package field.pkg2;

import field.pkg1.FieldTest1;

public class FieldRun2 extends FieldTest1 {

	public static void main(String[] args) {
		
		
		// 다른 패키지에 FieldTest1 객체를 생성
		FieldTest1 ft = new FieldTest1();           // public  클래스 접근 O
		
		System.out.println(ft.publicValue);     	// public  필드 직접 접근 가능
		
		// 문제발생(상속관계X)
//		System.out.println(ft.protectedValue);	    protected  필드 직접 접근 불가, 다른패키지X
		
//		System.out.println(ft.defaltValue);	        defalt  필드 직접 접근 불가, 다른패키지X
		
//		System.out.println(ft.privateValue);        private 필드 직접 접근 불가
		
		ft.method(); // 메서드를 이용한 간접접근 -> private, defalt 접근 가능

	}
	
	
	public void method() {
		
		// 상속관계이기 때문에 protected 직접 접근 가능
		System.out.println(protectedValue);
	}

}
