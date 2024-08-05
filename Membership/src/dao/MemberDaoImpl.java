package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import dto.Member;

public class MemberDaoImpl implements MemberDao {
	
	// 회원데이터가 저장될 파일 경로를 상수로 지정
	private final String FILE_PATH = "/io_test/membership.dat";
	
	// 회원목록을 저장해 둘 List 객체
	private List<Member> memberList = null;
	
	// 스트림 객체 참조 변수
	private ObjectInputStream  ois = null;
	private ObjectOutputStream oos = null;
	
	// 기본생성자
	// - 왜이렇게 주석이 많아...
	// - 회원 다수를 관리할 회원 목록(List)이 필요한데
	//   이미 파일로 저장된 회원목록이 있으면 읽어오고
	//   없으면 새로 만들기
	public MemberDaoImpl() throws FileNotFoundException , ClassNotFoundException, IOException {
		
		// membership.dat 파일이 존재하는지 검사
		File file = new File(FILE_PATH);
		if( file.exists() ) { // 존재하는경우
			try {
				// 스트림 생성
				ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
				
				// 저장된 객체를 파일에서 읽어와
				// 다운캐스팅 하여 memberList가 참조하게 함
				memberList = (ArrayList<Member>) ois.readObject();
				// 노란오류 무시
				
			} finally {
				/* try에서 발생하는 예외를
				 * throws 구문으로 처리하면
				 * catch 구문을 작성하지 않아도 된다*/
				
				if(ois!=null)ois.close();
				// 여기서 발생한 오류도 같이던짐
			}
		} 
		
		// 파일이 존재하지 않는경우
		else {
			// 새로운 ArrayList를 만들어서 참조
			memberList = new ArrayList<Member>();
		}
		
	}
	
	
	@Override
	public List<Member> getMemberList() {
		return memberList;
	}
	
	@Override
	public boolean addMember(Member member) throws IOException {
		
		// 1) 매개변수로 전달 받은 새 회원정보를
		// memberList에 추가
		memberList.add(member);
		
		// 2) memberList를 지정된 파일로 출력(저장)
		// -> 현재 메서드 말고 다른 메서드에서도 파일출력(저장)기능이
		// 자주 사용될 예정
		// --> saveFile() 메서드 만들어서 호출
		saveFile();
		
		return true;	// 예외가 발생하지 않고 정상적으로 파일에 저장됨
	}
	
	@Override
	public void saveFile() throws IOException{
		
		// memberList를 지정된 파일에 출력(저장)
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
			oos.writeObject(memberList);
		} finally {
			if (oos!=null) oos.close();	// flush() + 메모리 반환
		}
		
	}
	
	/**
	 * 식변번호(전화번호)를 입력받아
	 * 대당되는 회원의
	 * 누적금액 추가 및 등급변경
	 * @throws IOException 
	 */
	@Override
	public boolean addMoney(String targetPhone, int money) throws IOException {
		
		for(Member member : memberList) {
			if(member.getPhone().equals(targetPhone)) {
				member.setAmount(member.getAmount()+money);
				updateGrade(targetPhone);
				break;
			}
		}
		
		saveFile();
		return true;
	}
	
	/**
	 * 등급최신화
	 */
	private void updateGrade(String targetPhone) {
		for(Member member : memberList) {
			if(member.getPhone().equals(targetPhone)) {
				if(member.getAmount() < 100000) {
					member.setGrade(0);
					break;
				}else if(member.getAmount() < 1000000){
					member.setGrade(1);
					break;
				}else {
					member.setGrade(2);
				}
				break;
			}
		}
	}
	

}
