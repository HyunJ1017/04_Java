package cls.pkg2;

import cls.pkg1.ClassTest1;
//import cls.pkg1.DefaultClass;

public class ClassRun2 {

	public static void main(String[] args) {

		// public class + 다른패키지
		// ClassTest1 객체 생성하기
		ClassTest1 t1 = new ClassTest1();	//->같은 프로젝트에서 누구든지 해당 클래스를 가져가서(import 해서) 사용할 수 있음
		t1.method();
		
		
		// default인 DefaultClass + 다른 패키지
//		DefaultClass t2 = new DefaultClass(); //- 같은 패키지 에서만 접근 가능
    	                                      // -> 다른 패키지 클래스에서 import 불가
		//DefaultClass cannot be resolved to a type
//		t2.method();
		
	}

}
