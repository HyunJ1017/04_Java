package dto;

/* Object 클래스
 * 
 * - 모든 클래스(객체)의 최상위부모
 * - 모든 클래스(객체)가 공통적으로 가져야 하는 기능이 모여있음.
 * 
 * - 클래스 선언부에 아무런 상속 구문(extends)이 작성되어 있지 않으면
 *   컴파일러가 extends Object 구문을 추가해준다.
 */

/**
 * 부모 역할 클래스
 */
public class Parent extends Object {
	
	/* 부모 필드 */
	
//	 protected 접근 제한자 : 
//	 - 같은 패키지			: 객체 생성 후 사용
//			ex) 자식 클래스에서
//				parent p = new parent();	p.lastName;
				
//	 - 상속관계 자식 클래스	:
//			ex) 자식클래스에서 lastname; 작성
	protected String lastName = "홍"; // 명시적초기화
	
	private   String address  = "서울시 중구 남대문로 120";
	
	private   int    money    = 1000_000_000; // _ : 자릿수 구분, 해석안함
	
	private   String car      = "그랜저";
	
	/* 생성자 */
	// 기본 생성자
	public Parent() {
		System.out.println("부모 - 기본 생성자로 객체 생성");
	}
	
	// 매개변수 생성자 
	public Parent(String address, int money, String car) {
		this.address = address;
		this.money   = money;
		this.car     = car;
		
		System.out.println("부모 - 매개 변수 생성자로 객체 생성");
	}

	
	/* getter setter */
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}
	
	/* 현재 객체의 필드 값을 하나의 문자열로 반환하는 메서드
	 * @return String */
	public String inform() {
		return String.format("%s / %s / %d / %s", lastName, address, money, car);
	}
	
	/* TestRun2 */
	public void introduce() {
		System.out.println("저는 Parent 입니다.");
	}
	
	/**Object 클래스에서 상속받은 메서드 중
	 * toString() 오버라이딩 하기
	 * 
	 * -> Object.toString() 역할
	 *    물려받은 자식이 오버라이딩 하여 객채가 가지고 있는 필드 값을
	 *    하나의 문자열로 만드는 것임 (약속되어있음)
	 *    
	 *  -> print() 관련 구문에서
	 *  ()안에 참조 변수명만 작성해도
	 *  자동으로 toString()이 호출된다.
	 * */
	@Override
	public String toString() {
		return String.format("[Parent] %s / %s / %d / %s", lastName, address, money, car);
	}
	
	/* final 메서드 
	 * 
	 * - 오버라이딩 불가
	 *   -> 부모의 메서드가 완벽해서 더이상 오버라읻 못하게하는
	 *      마지막으로 정의된 메서드
	 * 
	 * - public final 반환형 메서드명(){}
	 */
	public final void onlyParent() {
		System.out.println("final 메서드 입니다");
	}
	
	public void settings(String address, int money, String car) {
		this.address = address;
		this.money   = money;
		this.car     = car;
		System.out.println("Parent 세팅됨");
	}
	
}