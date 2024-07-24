package pkg1.dto;

/*
[접근제한자] interface 인터페이스명 {
	//상수도 멤버로 포함할 수 있음
	public static final 자료형 변수명 = 초기값;
	
	//추상 메소드만 선언 가능
	[public abstract] 반환자료형 메소드명([자료형 매개변수]);
	//public abstract가 생략되기 때문에
	//오버라이딩 시 반드시 public 표기해야 함

}
*/
public interface Interface {
	
	public static final String corpName = "Name";
	
	public abstract String seekName();

}
