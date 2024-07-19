package field.pkg3;

/** [[static]]
 *  
 *  - 뜻 : 정적인 (움직임이없다)
 *  
 *  - static이 붙은 필드/메서드는
 *    * 프로그램 실행 시 모두 static 영역에 할당되고
 *    종료 시 사라지게 됨 (== 종료할때까지 존재)
 *     -> 프로그램 실행 중에는 절대 없어지지 않음 == 정적
 *     <-> 동적 : 객체가 생겼다 사라졌다 함(heap에 저장됨)
 *     
 *  - static의 특징 : 공유
 *    
 *    - static 필드 / 메서드
 *    * 프로그램 실행 시 *
 *    클래스명.필드명 / 클래스명.메서드명() 이름으로
 *    static영역에 할당(생성) 되어지고
 *    
 *    어디서든 클래스명.필드명 / 클래스명.메서드명() 으로
 *    호출 가능한 상태가 됨
 */

public class Korean { // 필드
	
	// static 변수 (== 클래스 변서)
	// -> 어디서든 접근 가능하게 public 작성
	public static /*final*/ int nationalCode = 82; // 국가코드
	
	// instance 변수
	// - > 만들어진 인스턴스(객체)만 사용 가능한 변수
	// - > 캡슐화 원칙에 의해서 private 설정
	private String name;	// 이름
	private String id;		// 주민번호
	

	
	
	// private 필드 간접접근방법 (getter/setter)
	
	// name 의 getter
	public String getName() {	// 돌려주는 name이 String
		return name;
	}
	
	
	// id 의 getter
	public String getId() {		// 돌려주는 id가 String
		return id;
	}
	
	// name 의 setter
	public void setName(String name) {		// 돌려주는게 없을 때는 void
		this.name = name;
	}

	// id 의 setter
	public void setId(String id) {
		this.id = id;
	}
	
// 필드 끝
}
