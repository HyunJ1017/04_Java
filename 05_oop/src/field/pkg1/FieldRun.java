package field.pkg1;

public class FieldRun {
	
	public static void main(String[] args) {
		
		// FieldTest1 객체를 생성
		FieldTest1 ft = new FieldTest1();
		
		System.out.println(ft.publicValue);	        // public  필드 직접 접근 가능

		System.out.println(ft.protectedValue);	    // protected  필드 직접 접근 가능, 같은패키지o
		
		System.out.println(ft.defaltValue);     	// defalt  필드 직접 접근 가능, 같은패키지o
		
//		System.out.println(ft.privateValue);        private 필드 직접 접근 불가
		
		ft.method(); // 메서드를 이용한 간접접근 -> private 접근 가능
		
	}

}
