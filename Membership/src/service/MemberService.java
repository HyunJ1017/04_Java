package service;

import java.io.IOException;
import java.util.List;

import dto.Member;

// Service : 기능(비지니스로직)을 제공하는 클래스/객체
// - 프로그램의 핵심 기능 작성
public interface MemberService {
	
	// 인터페이스의 메서드
	// - public abstract method
	// - defailt method
	
	/**
	 * 전달받은 이름, 전화번호를 이용해서 회원을 추가
	 * 단, 목록에 있는 회원 중 같은 번호의 회원이 존재하면
	 * false 반환/ 없으면 가입 후 true 반환
	 * @param name
	 * @param phone
	 * @return
	 * @throws IOException 
	 */
	public abstract boolean addMember(String name, String phone) throws IOException;

	/**
	 * 전체 회원 목록 조회
	 * @return memberList
	 */
	public abstract List<Member> getMemberList();

	public abstract List<Member> searchName(String searchName);

	public abstract boolean addMoney(String targetPhone, int money) throws IOException;
	
	
	
	
	
	
	
	
	

}
