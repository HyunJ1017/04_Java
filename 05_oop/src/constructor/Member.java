package constructor;

public class Member {
	
//	 field
	
	// Instence 변수 : 객체 생성 시 할당되는 변수
	private String memberId;	// 회원 id
	private String memberPw;	// 회원 pw
	private String memberName;	// 회원 name
	private int    memberAge;	// 회원 age
	
	// 인스턴스 변수의 대입되는 값이 없다면 각 자료형의 기본값으로 초기화 됩니다.
	/** ex)
	 * int     : 0
	 * double  : 0.0
	 * boolean : false
	 * 참조형  : null (현재 참조하고 있는 객체가 없음 의미)
	 */
	
	
//	 constructor
	/** - 작성규칙
	 *  1. 반환형 없음 (void, String, int ... 안씀)
	 *  2. 생성자 이름은 클래스명과 동일해야함
	 */
	
	/** 기본 생성자
	 * 매개변수가 없는 생성자를 의미 ()
	 * 
	 * *중요*
	 * - 클래스에 생성자가 "단 하나도" 없을 경우
	 *   컴파일러가 컴파일 시 기본 생성자를 추가해줌
	 *   ex) public Member() {}
	 * */ 
	public Member() {
		// this()생성자 : 다른 생성자 호출
		//주의사항 반드시 첫번째 줄에 작성!!!!!!!!!!!
		this("ID", "PW", "NAME", 100);
		
		// Member 객체가 생성될 때 println() 구문을 수행
		System.out.println("***** Member 객체 생성됨 *****");
		
//		this("ID", "PW", "NAME", 100);
	}
	
	/**매개변수 생성자
	 * - 매개변수가 존재하는 생성자
	 * - 전달받은 매개 변수를 이용해 생성되는 객체의 필드를 초기화 하는 용도로 많이 사용
	 *  */
	public Member(String memberId,
				  String memberPw,
			      String memberName,
				  int memberAge) {
		// 오버로딩 적용!!! -> 매개변수의 개수가 다름
		this.memberId   = memberId;
		this.memberPw   = memberPw;
		this.memberName = memberName;
		this.memberAge  = memberAge;
		//-> setter 4개 합친모양
	}
	
	
	// 메서드명 중복테스트
	public void method() {}
//	public void method() {}	  동일하면 중복
//	private void method() {}  접근자가 달라도 중복
//	public String method() {} 반환형이 달라도 중복
	/** 오버로딩 (Overloading)
	 * 
	 * - 하나의 클래스에 동일한 이름의 메서드를 여러 개 작성하는 기법 
	 * - 같은 이름의 메서드가 수행하는 기능은 기본적으로 같으나
	 *   전달받은 매개변수에 따라 조금씩 동작이 달라야 하는 경우
	 *   상황병로 메서드를 저으이할 수 있음 */
	public void method(int a) {} // 매개변수 갯수가 다름
//	public void method(int b) {}
	public void method(String str) {}
	public void method(int a, String str) {}
	public void method(int a, int b) {}
	public void method(String str, int a) {}
	public void method(String str, long a) {}
	/* ex) 
	 * public void sum(int a, int b) { a+b 출력}
	 * public void sum(int a, int b, intc) { a+b+c 출력}
	 * 
	 * 오버로딩 성립조건
	 * 1) 매서드에 이름이 똗같아야 한다.
	 * 2) 매개 변수의 갯수, 자료형, 자료형 순서 중 하나라도 달라야 한다.
	 * */
	
	
//	 method
	// getter
	public String getmemberId() {
		return memberId;
	}
	
	public String getmemberPw() {
		return memberPw;
	}
	
	public String getmemberName() {
		return memberName;
	}
	
	public int getmemberAge() {
		return memberAge;
	}
	
	// setter
	public void setmemberId(String memberId) {
		this.memberId = memberId;
	}
	
	public void setmemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	
	public void setmemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public void setmemberAge(int memberAge) {
		this.memberAge = memberAge;
	}
	
	/*
	 * 현재 객체가 가지고 있는 필드값 모두 출력하는 메서드
	 */
	public void inform() {
		System.out.println("\n--------------------------");
		System.out.println("memberId   : " + memberId);
		System.out.println("memberPw   : " + memberPw);
		System.out.println("memberName : " + memberName);
		System.out.println("memberAge  : " + memberAge);
		System.out.println("--------------------------\n");
	}
	
}
