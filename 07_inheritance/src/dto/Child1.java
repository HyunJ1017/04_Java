package dto;

/*	[상속]
 * - 정의 : 부모의 코드(필드/메서드)를 물려받아
 * 			자식이 자신의 코드인 것 처럼 사용
 * 
 * - 상속 키워드 : extends (확장하다)
 *   -> 부모 코드를 물려받은 자식의 크기가 커지기 때문에!
 *   
 * ** 주의사항 **
 * 
 * - 부모의 코드 중 생성자(Constructor)는 물려받지 못함!
 * 
 * - 부모의 private 접근 제한자 필드/메서드는 상속 받긴 하지만 직접 접근 불가!!!
 *   -> 상속 관계여도 다른 클래스(객체)로 인식 되기 때문에
 *      접근 불가
 */
public class Child1 extends Parent {
	
	// 필드
	private String notebook;
	
	/** [super() 생성자]
	 * 1.복합형 <‘극도로’, ‘대단히’, ‘보통보다 더 많은[나은]’ 등의 뜻을 나타냄>
       2.복합형 <‘상부의’, ‘위에’의 뜻을 나타냄>
     * 
     * - 현재 클래스의 상위 클래스(부모) 생성자를 호출하는 구문(크기는 자식이 더 큰데 ...?)  
     * 
     * - super()는 자식 생성자(Constructor)에만 작성할 수 있으며 (메서드에 못씀)
     *   반드시 첫 번째 줄에만 작성할 수있다.
     *   (Constructor call must be the first statement in a constructor)
	 */
	// 기본 생성자
	public Child1() {
		super();
		System.out.println("자식1 - 기본 생성자로 객체 생성");
	}

	// 매개변수 생성자
	public Child1(String notebook) {
		/* 부모 매개변수 생성자 호출하기~ */
		super("부산 해운대구", 600, "바나나카");
		this.notebook = notebook;
		System.out.println("자식1- 매개변수 생성자로 객체 생성");
	}
	
	// getter setter
	public String getNotebook() {
		return notebook;
	}
	
	public void setNotebook(String notebook) {
		this.notebook = notebook;
	}
	
	// 메서드
	/**
	 * 자식객체 + 부모객체에 있는 모든 필드값 출력
	 */
	public void print() {
		
		// 부모필드
		System.out.println(" lastName : " + lastName     ); // protected 필드 직접접근
		System.out.println("  address : " + getAddress() ); // private   필드 간접접근
		System.out.println("    money : " + getMoney()   ); // private   필드    ``
		System.out.println("      car : " + getCar()     ); // private   필드    ``
		
		// 자식 필드(여기)
		System.out.println(" notebook : " + notebook );
	}
	
	/* super 참조변수
	 * - 자식 객체 내부의 부모 객체를 참조하는 변수
	 * 
	 * - 사용시기
	 *   - > 부모의 필드/메서드임을 확실하게 명시할 때 주로 사용
	 *   - > 안써도 되긴 하는데 써도 되나봄
	 *   - > 밑에 toString() 오버라이딩한거 보러가면있음
	 * */
	/**
	 * 자식 + 부모 필드 정보를 하나의 문자열로 반환
	 * -> 성 / 주소 / 머니 / 카 / 노트북
	 * @return String
	 */
	public String childInform() {
		
		/* 길어서 탈락 */
		// return String.format("%s / %s / %d / %s / %s", lastName, getAddress(), getMoney(), getCar(), notebook);
		
		/* 코드 재활용으로 짧게 */
		return super.inform() + " / " + notebook;
	}
	
	/**오버라이딩(Overriding)
	 * Over  : 위에있다, 넘어서다
	 * Riding: (타는 것)덮어쓰기
	 * 
	 * - 부모로 부터 물려받은 메서드를
	 *   자식이 같은 이름의 메서드를 만들어서 덮어쓰기
	 *   -> 물려받은 자식에 맞게 부모의 메서드를
	 *      다시 정의해야 하는 경우 사용
	 *      
	 * ** 중요 **
	 * 
	 * @Override 어노테이션(Annotaion)
	 * 1) 해당 메서드는 오버라이팅 되었음을 명시
	 * 2) 오버라이딩된 코드가 알맞게 작성되었는지
	 *    컴파일러에게 검사하라고 지시하는
	 *    컴파일러 주석
	 *    
	 * [오버라이딩 성립 조건]
	 * 1. 접근제한자(public, protected ...)는 같거나 더 넓은 범위만 가능
	 * 2. 반환형, 매개변수, 메서드명은 모두 동일
	 * 3. 예외처리 구문(throws)은 같거나 좁은 범위
	 * (똑같이 쓰는게 제일 쉬움)
	 */
	
	@Override
	public void introduce() {
		System.out.println("저는 Parent의 자식 child1 입니다.");
	}
	
	// Parent에게 상속받은 toString을 어버라이딩(재정의)
	@Override
	public String toString() {
		
		/*Child1 에서 toString() 호출하면 Child1.toString()이 호출되서 오류남 */
		//return toString();
		return super.toString();
	}
	
	/*
	 * final 메서드 확인하기
	 */
//	@Override
	//public void onlyParent() {}
	//public final void onlyParent() {}
	public void onlyChild() {
		System.out.println("child");
		super.onlyParent();
		onlyParent();
	}
	
}
