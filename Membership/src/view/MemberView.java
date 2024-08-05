package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import dto.Member;
import service.MemberService;
import service.MemberServiceImpl;

// view : 사용자에게 보여지는 열할을 하는 클래스/객체
// - 보여줄 화면을 출력/ 필요한 데이터를 입력

public class MemberView {
	
	private MemberService service = null;
	private BufferedReader br = null;
	
	// 기본생성자
	public MemberView() {
		
		try {
			// 객체 생성중 발생한 예외를 view에 모아서 처리
			service = new MemberServiceImpl();
			
			// 키보드 입력받기 위한 스트림 생성
			br = new BufferedReader( new InputStreamReader(System.in));
			
		} catch (Exception e) {
			
			System.out.println("*** 프로그램 실행 중 오류발생 ***");
			
			e.printStackTrace();
			
			System.exit(0); // 프로그램 종료
		}
		
	}
	
	
	//-------------------------------------------------------------------------------
	/* [메인 메뉴] */
	
	public void mainMenu() {
		
		int input = 0;
		
		do {
			try {
				// 메뉴 출력 후 입련된 번호를 받환받는 구문
				input = selectMenu();
				
				// 선택된 메뉴 번호에 따라 case 선택
				switch (input) {
				case 1 : addMember(); break;
				
				case 2 : selectAll(); break;
				
				case 3 : search(); break;
				case 4 : updateAmount(); break;
				case 5 : break;
				case 6 : break;
				case 0 : System.out.println("\n==== 프로그램 종료 ===="); break;
				default : System.out.println(">> 메뉴에 작성된 번호만 입력해 주세요 <<");
				}
				
				System.out.println("=======================================");
				
			} catch (NumberFormatException e) {
				System.out.println("\n>> 숫자만 입력 해주세요 <<\n");
				input = -1;	// 첫 반복에서 종료되지 않게 값 변환
			} catch (IOException e) {
				System.out.println("\n>> 입출력 관련 예외 발생 <<\n");
				e.printStackTrace();
			} catch (Exception e) {	// 나머지 예외 처리
				e.printStackTrace();
			}
		} while (input != 0);
		
	}
	
	
	//-------------------------------------------------------------------------------
	/* [메뉴 출력/선택하는 메서드] */
	
	private int selectMenu() throws NumberFormatException, IOException {
		
		System.out.println("\n==== 회원 관리 프로그램 ====\n");
		
		System.out.println("1. 회원 가입(추가)");
		System.out.println("2. 회원 전체 조회" );
		System.out.println("3. 이름 검색"      );	// (동명이인 있으면 모두 출력) 〜(￣▽￣〜)
		System.out.println("4. 금액 누적하기"  );
		System.out.println("5. 회원정보 수정"  );
		System.out.println("6. 회원 탈퇴"      );
		System.out.println("0. 종료"           );
		
		System.out.print("메뉴 선택 : ");
		
		// 입력받은 문자열을 int형태로 변환
		int input = Integer.parseInt( br.readLine() );
		System.out.println();	// 줄바꿈
		
		return input;
		
	}
	
	//-------------------------------------------------------------------------------
	/* [1. 회원 가입(추가)하기] */
	
	/**전화번호는 중복검사시행
	 * @throws IOException 
	 * 
	 */
	private void addMember() throws IOException {
		System.out.println("\n---- 회원 추가 ----\n");
		
		System.out.print  ("이름 : ");
		String name = br.readLine();
		
		// 정상입력이 될때까지 다시입력받기
		String phone = null;
		
		while(true) {
			System.out.print  ("전화번호(-제외) : ");
			phone = br.readLine();
			
			if(phone.length()!=11) {
				System.out.println("** 다시 입력 해 주세요 **\n");
				continue;
			}
			
			break;
		}
		
		// 회원추가서비스 호출 후 결과 반환받기
		boolean result = service.addMember(name, phone);
		
		if(result) {
			// true성공
			System.out.println("** 회원이 추가되었습니다. **");
		}else {
			// false실패
			System.out.println("** 중복되는 전화번호가 존재합니다. **");
		}
	}
	
	//-------------------------------------------------------------------------------
	/* [2. 전체조회하기] */
	
	/**
	 * 회원목록 전체조회
	 */
	private void selectAll() {
		System.out.println("\\n---- 회원 전체 조회 ----\\n");
		
		//회원 목록을 조회해 반환하는 서비스 호출
		List<Member> memberList = service.getMemberList(); 
		
		// 조회된 회원 목록이 없을경우
		// -> MemberDaoImpl 생성자에 의해서 memberList는 절때로 null이 될 수 없음
		/* -> 참조하는 List는 있지만 비어있는지 검사를 해야 함*/
		if(memberList.isEmpty()) {
			System.out.println("회원이 존재하지 않습니다.");
			return;
		}
		
		String[] gradeArr = {"일반", "골드", "다이아"};
		
		System.out.printf("%-6s %-12s %8s %5s\n","[이름]","[PH]","[누적금액]","[등급]");
		
		for(Member member : memberList) {
			
			System.out.printf("%-6s %-12s %8d %5s\n",	// -는 왼쪽정렬, 양수는 오른쪽정렬
					member.getName(), member.getPhone(), member.getAmount(), gradeArr[member.getGrade()]);
			
		}
	}
	
	//------------------------------------
	/* [ 3. 이름 검색하기 ] */
	
	/**
	 * 이름, 일부라도 포함하는 것 다가져와서 출력
	 * @throws IOException 
	 */
	private void search() throws IOException {
		
		System.out.println("\\n---- 회원 전체 조회 ----\\n");
		
		System.out.print  ("검색 : ");
		String searchName = br.readLine();
		
		List<Member> searchList = service.searchName(searchName);
		
		if(searchList.isEmpty()) {
			System.out.println("검색결과를 찾을 수 없습니다.");
			return;
		}
		
		String[] gradeArr = {"일반", "골드", "다이아"};
		
		System.out.printf("%-6s %-12s %8s %5s\n","[이름]","[PH]","[누적금액]","[등급]");
		
		int count = 1;
		for(Member member : searchList) {
			System.out.printf("%d) %-6s %-12s %8d %5s\n",	// -는 왼쪽정렬, 양수는 오른쪽정렬
					count, member.getName(), member.getPhone(), member.getAmount(), gradeArr[member.getGrade()]);
			count++;
		}
		
	}
	
	//--------------------------------------------------------------
	/* [ 4. 금액 입력하기 ] */
	
	/**
	 * 이름을 입력받고 일치하는 이름들을 받아와
	 * 이름목록에서 원하는 인덱스번호를 누르고
	 * dao에서 전화번호를 보내 해당 전화번호의
	 * 누적금액 추가 및 회원등급을 수정
	 * @throws IOException 
	 */
	private void updateAmount() throws IOException {
		
		System.out.println("\\n---- 금액 누적하기 ----\\n");
		
		System.out.print  ("검색 : ");
		String searchName = br.readLine();
		
		List<Member> searchList = service.searchName(searchName);
		
		if(searchList.isEmpty()) {
			System.out.println("검색결과를 찾을 수 없습니다.");
			return;
		}
		
		String[] gradeArr = {"일반", "골드", "다이아"};
		
		System.out.printf("%-6s %-12s %8s %5s\n","[이름]","[PH]","[누적금액]","[등급]");
		
		int count = 1;
		for(Member member : searchList) {
			System.out.printf("%d) %-6s %-12s %8d %5s\n",	// -는 왼쪽정렬, 양수는 오른쪽정렬
					count, member.getName(), member.getPhone(), member.getAmount(), gradeArr[member.getGrade()]);
			count++;
		}
		
		System.out.print  ("선택번호 : ");
		String index = br.readLine();
		
		String targetPhone = searchList.get(Integer.parseInt(index)-1).getPhone();
		
		System.out.print  ("누적시킬금액 : ");
		int money = Integer.parseInt(br.readLine());
		
		boolean result = service.addMoney(targetPhone, money);
		
		if(result) System.out.println("완료되었습니다.");
	}
	
	
	
	
	

}
