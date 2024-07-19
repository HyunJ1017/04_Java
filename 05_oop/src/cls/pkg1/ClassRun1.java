package cls.pkg1;

public class ClassRun1 {

	public static void main(String[] args) {

		// public class인 ClassTest1을
		// import하여 객체 생성하기
		ClassTest1 t1 = new ClassTest1();	//->같은 프로젝트에서 누구든지 해당 클래스를 가져가서(import 해서) 사용할 수 있음
		t1.method();
		
		// default인 DefaultClass + 같은 패키지
		DefaultClass t2 = new DefaultClass(); //- 같은 패키지 에서만 접근 가능
    	                                      // -> 다른 패키지 클래스에서 import 불가
		t2.method();
		
	}

}
