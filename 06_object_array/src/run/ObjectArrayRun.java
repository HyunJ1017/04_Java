package run;

import service.MemberService;

public class ObjectArrayRun {

	public static void main(String[] args) {
		
		// MemberService 객체 생성
		// 컴파일러가 만들어준 기본생성자
		MemberService service = new MemberService();
		
		service.method1();
	}
	
}
