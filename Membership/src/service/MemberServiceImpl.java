package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import dao.MemberDao;
import dao.MemberDaoImpl;
import dto.Member;

/* 왜 Service, Dao 인터페이스를 만들어서 구현했을까?
 * - 인터페이스를 상속받아 구현하면
 *   모든 자식 클래스가 똑같은 기능을 가지게 되어
 *   비슷하게 생김
 *   
 *   -> 언제든지 서로 다른 자식 클래스로 대체 가능!!
 *    ==> 유지보수성 증가
 */

// MemberService를 상속받아 구현
public class MemberServiceImpl implements MemberService {
	
	// dao 객체 부모 참조 변수 선언
	private MemberDao dao = null;
	
	// 기본 생성자
	// MemberServiceImpl 객체 생성 시
	// MemberDaoImpl 객체도 생성
	public MemberServiceImpl() throws FileNotFoundException, 
									  ClassNotFoundException, 
									  IOException {
		dao = new MemberDaoImpl();
	}
	
	
	@Override
	public boolean addMember(String name, String phone) throws IOException {
		
		// 1) 회원 목록을 얻어와 휴대폰 번호 중복검사 시행
		List<Member> memberList = dao.getMemberList();
		
		for (Member member : memberList) {
			// 휴대폰 번호가 같은 경우
			if(phone.equals(member.getPhone())) {
			return false;
			}
		}
		
		// 2) 중복이 아닌경우 입력받은 정보를 이용해 맴버객체를 생성하고 DAO에 전달하여 파일에 저장
		Member member = new Member(name, phone, 0, Member.COMMON);
//													-> 0이라고 써도 되지만 가독성 증가
		
		// DAO 메서드 호출 후 결과 반환받기
		boolean result = dao.addMember(member);
		
		
		// result로 되돌아온 true를 반환하기
		return result;
	}
	
	// DAO에서 조회한 memberList를 그래도 반환
	// (해당 서비스 메서드는 따로 처리할 조건/기능이 없어서
	//  중간에서 전달만 해주는 역할이 됨)
	@Override
	public List<Member> getMemberList() {
		return dao.getMemberList();
	}
	
}
