package set.dto;

import java.util.Objects;

public class Person {
	
	// 필드
	private String name;
	private int age;
	private char gender;
	
	// 기본 생성자
	public Person() {}

	// 매개 변수 생성자
	public Person(String name, int age, char gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	// getter/setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
	// toString() 오버라이딩
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}

	
	/* boolean Object.equals(Object other) => 동등비교
	 * - 현재 객체와
	 *   매개변수로 전달받은 다른 객체의
	 *   필드값이 일치하는지 확인하는 용도로
	 *   오버라이딩 해서 사용하는 Object 제공 메서드
	 */
	@Override
	public boolean equals(Object other) {
		
		// null이 전달된 경우, 조기종료
		if( other == null )              return false;
		
		// Person 타입의 객체가 아닌경우
		if( !(other instanceof Person) ) return false;
		
		// other 다운캐스팅
		Person o = (Person)other;
		
		// 이름이 같지 않으면
		if( !this.name.equals(o.name) )  return false;
		if( this.age    != o.age      )  return false;
		if( this.gender != o.gender   )  return false;
		
		return true; // 위에 if문 실행 안되면 같은 값을 지닌 객체임 
	}
	
	/* int hashCode() ==> 동일비교
	 * - 객체별 식별코드(객체를 구분하는 값(정수))를 반환하는 메서드
	 * 
	 * - 식별코드가 곂치지 않게 만들기 위해서
	 *   hash 함수를 이용함!
	 *   
	 * * hash 함수 : 값을 넣으면 동일한 크기의 값이 반환되는 함수
	 * 
	 * ex) sha-256 암호화 방식
	 *   -> 문자열을 전달하면 256바이트 길이 문자열로변환
	 */
	
	@Override
	public int hashCode() {
		// Object : Object관련 유용한 기능 제공 클래스
		
		// 필드에 저장된 값을 이용해 hashCode를 생성하기 때문에
		// 필드값이 모두 같으면 동일한 hashCode가 반환된다.
		return Objects.hash(name, age, gender);
	}

}
