package pkg3.dto;

import lombok.Getter;	// 모든 필드의 getter 자동생성
import lombok.Setter;	// 모든 필드의 setter 자동생성
import lombok.NoArgsConstructor;	// 전달인자가 없는 생성자 == 기본생성자

import java.io.Serializable;

import lombok.AllArgsConstructor;	// 모든 필드에 대한      매개변수생성자
import lombok.ToString;	// toString 오버라이딩

// Lombok 라이브러리
// - 자바 애플리케이션 개발 시
//	 자주 사용하는 구문을 자동으로 생성하도록 만든 라이브러리

// - @(어노테이션)을 작성하면
//	 컴파일단계에서 자동으로 코드가 추가됨


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member implements Serializable {
	
	// // serialVersionUID : 직렬화 식별번호
	// -> 직렬화/ 역직렬화 시 같은 객체가 맞는지 비교할 때 사용하는 번호
	//    따로 작성 안하면 JVM이 랜덤값 지정
	
	// 직렬화를 위해 Serializable 인터페이스 상속
	// ( 들어가보면 암무것도 없음 )
	// -> 스트림 이용시 객체가 직렬화 되어짐
	// --> 마커 인터페이스(무슨역할/대상임을 명시)

	private String id;
	private String pw;
	private String name;
	private int age;
	
}
