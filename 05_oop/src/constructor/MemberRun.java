package constructor;

public class MemberRun {
	
	int mem1 = 10;
	
	public static void main(String[] args) {
		
		// Member 객체 생성 1 : 생성후 setter로 값 초기화
		Member mem1 = new Member();		// 같은 패키지로 import 안해옴
//		                  ↳constructor.Member 기본 생성자
//							↳ Member 클래스에 작성되어 있음
//							(있어야하는데 없어서 컴파일러가 자동으로 만들어줌)
		
		// mem1이 참조하는 객체의 setmemberId() 메서드 호출
		mem1.setmemberId("member01");
		mem1.setmemberPw("pass01");
		mem1.setmemberName("김회원");
		mem1.setmemberAge(27);
		
		//mem1이 참조하는 객체 필드 값 출력
		mem1.inform();
		
		
		// ----------------------------------------------------------------------
		
		// Member 객체 생성 2 : 매개 변수 생성자 이용
		Member mem2 = new Member("member02", "pass02", "최회원", 22);
		//-> 객체가 만들어 지면서 동시에
		//   생성자에 의해 필드 값이 초기화 된다!!
		
		// setter 방법 5줄 -> 생성자 매개변수 1줄
		
		mem2.inform();
		
		// **매개 변수 사용자로 얻은 효과**
		// -> 코드 길이 감소 (== 재사용성 증가)
		
		//-------------------------------------------
		
		// this 생성자 확인
		Member mem3 = new Member();
		
		mem3.inform();
		
		/*
		Member member1 = new Member();
		Member member2 = new Member();
		Member member3 = new Member();
		Member member4 = new Member();
		Member member5 = new Member();
		Member member6 = new Member();
		Member member7 = new Member();
		Member member8 = new Member();
		Member member9 = new Member();
		Member member0 = new Member();
		
		Member[] member = {member1, member2, member3, member4, member5, member6, member7, member8, member9, member0};
		
		for (int i = 0 ; i < 10 ; i++) {
			member[i].setmemberId("Idtt" + i);
			System.out.println(member[i].getmemberId());
		}
		*/
		
	}

}
