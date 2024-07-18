package basic;

// 같은 패키지 클래스는 import 안해도 됨

public class BasicRun {
	
	public static void main(String[] args) {
		
		// 국민 객체 생성
		// == 국민(Nation) 클래스에 작성된 내용대로
		// Heap 메모리 영역에 할당(생성)하는것
		Nation n1 = new Nation(); // 새 국민 생성!!!
		n1.name = "홍길동";
		n1.age = 20;
		n1.gender = '남';
		
		//메서드 실행
		n1.intoduce();
		
		// 국민 객체 생성
		Nation n2 = new Nation();
		n2.name = "신짱구";
		n2.age = 5;
		n2.gender = '남';
		
		
		//메서드 실행
		n1.납세의의무();
		n2.납세의의무();
		
		
	}

}
