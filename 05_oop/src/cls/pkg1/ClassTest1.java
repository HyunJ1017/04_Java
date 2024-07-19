package cls.pkg1;

/* cls : class라고 적으면 시스템이 인식 못해서 줄여씀*/

/**
 * class : 객체의 속성, 기능을 정의한 문서(==설계도)
   --------------------------------------
   [class 작성법]
   
   [접근제한자(public)] class 클래스명 {
   
   // 필드(속성 == 변수)
   
   // 기능1(생성자)
   
   //기능2(메서드)
   
   }
   
   [[class 작성 시 알아야 할 것]]
   
   - class 명은 꼭 대문자로 시작   (이 후 카멜 표기법)
   
   - 접근 제한자
   
     1)  [+] public
     	- 뜻 : 모두의, 공공의
     	- 같은 프로젝트에서 어디서든 접근 가능
     	
     	- public calss :
     	  같은 프로젝트에서 누구든지 해당 클래스를
     	  가져가서(import 해서) 사용할 수 있음
     	
     2)  [~] (default)
     
     	- () == 생략을 의미 -> class 왼쪽에 아무것도 안적음
     	public class ClassTest1
     	class ClassTest1 			<- 요상태
     	
     	- 같은 패키지 에서만 접근 가능
     	 -> 다른 패키지 클래스에서 import 불가
   

 */

public class ClassTest1 {
	
	public void method() {
		System.out.println("public은 어디서든 접근 가능");
	}

}
