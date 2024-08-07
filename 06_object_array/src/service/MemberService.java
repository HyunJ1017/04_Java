package service;

import dto.MemberDTO;

/**
 * Member의 기능을 제공하는 클래스
 */
public class MemberService {
	
	// 객체 배열
	/*  - 객체를 참조하는 참조형 변수를 묶음으로 다루는 것
	 * 
	 * [작성법]
	 * 클래스명[] 변수명 = new 클래스명[크기];
	 * 
	 * ex)
	 * Academy[] arr = new Academy[3];
	 * 
	 * - new Academy[3] :
	 * 	 heap 영역에 Academy "참조형 변수" 3칸짜리 묶음 배열
	 * 
	 *   --> 각 칸이 Academy "참조형 변수"
	 *       -> 각 칸이 Academy 객체 주소를 저장해서 참조
	 */
	
	/** 객체 배열 생성/초기화/활용*/
	public void method1() {
		
		// MemberDTO 참조형 변수 3칸짜리 배열을 생성하고
		// memberArr가 참조
		MemberDTO[] memberArr = new MemberDTO[3];
		
		// memberArr가 참조하는 배열의 각 인덱스번째 칸은
		// MemberDTO "참조형 변수" 이다.
		
		// 인덱스 별로 MemberDTO 객체로 초기화
		memberArr[0] = new MemberDTO("member01", "pass01", "일번회원", 30);
		memberArr[1] = new MemberDTO("member02", "pass02", "이번회원", 22);
		memberArr[2] = new MemberDTO("member03", "pass03", "삼번회원", 33);
		
		
//		memberArr[0].inform();
//		memberArr[1].inform();
//		memberArr[2].inform();
		
		/* 객체 배열 + for문 */
		for (MemberDTO s : memberArr) {
			s.inform();
		}
		
//		for (int i = 0 ; i < memberArr.length ; i++) {
//			memberArr[i].inform();
//		}
	}

}
