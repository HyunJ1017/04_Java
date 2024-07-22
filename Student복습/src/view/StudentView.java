package view;

import java.util.Scanner;

import service.StudentService;

public class StudentView {

	private Scanner sc = new Scanner(System.in);
	private StudentService service = new StudentService();
	
	
	/**
	 * main method
	 */
	public void studentView() {
		
		int input = 0;
		
		do {
			System.out.println("\n<<학생들 관리하는 프로그램>>"         );
			System.out.println("1. 추가 학생 입력"                      );
			System.out.println("2. 학생 전체 조회"                      );
			System.out.println("3. 학생 1명 정보 조회(인덱스)"          );
			System.out.println("4. 학색 검색(이름)"                     );
			System.out.println("5. 학생 정보 수정(인덱스)"              );
			System.out.println("6. 학생 1명 점수 조회(점수, 합계, 평균)");
			System.out.println("7. 평균 최고점, 최저점 학생"            );
			System.out.println("0. 종료"                                );
			
			System.out.println("메뉴번호 입력 : ");
			input = sc.nextInt();
			
			sc.nextLine(); // 입력 초기화
			
			switch (input) {
			
			case 1  : addStudent();           break;
			case 2  : allStudent();           break;
			case 3  : selectStudent();        break;
			case 4  : nameSurch();            break;
			case 5  : updateStudent();        break;
			case 6  : scoreStudent();         break;
			case 7  : bestAll();              break;
			case 0  : System.out.println("\n== 프로그램을 종료합니다 =="); break;
			default : System.out.println("\n== 잘못 입력 하셨습니다 ==\n");
			
			}
			
		} while ( input != 0 );
		
	}
	
	/** 1. 학생 추가 입력 */
	
	public void addStudent() {
		System.out.println("\n=====학생 추가 입력=====\n");
		
		System.out.print("학생 이름 : ");
		String name = sc.nextLine();
		
		System.out.print("학생 학번 : ");
		String studentNumber = sc.nextLine();
		
		System.out.print("학생 성별 : ");
		char gender = sc.next().charAt(0);
		
		Boolean check = service.addStudent(name, studentNumber, gender);
		
		String result = "";
		if (check) {
			result = "학생 [" + name + "]의 입력이 완료되었습니다.";
		} else {
			result = "입력할 수 없습니다.";
		}
		System.out.println(result);
	}
	
	
	
	/** 2. 학생 전체 조회 */
	public void allStudent() {
		System.out.println("\n=====학생 전체 조회=====\n");
		
		service.allStudent();
	}
	
	/** 3. 학생 1명 정보 조회(인덱스) */
	public void selectStudent() {
		System.out.println("\n=====학생 1명 정보 조회=====\n");
		
		System.out.print("조회할 번호 입력 : ");
		int index = sc.nextInt();
		
		System.out.println(service.selectService(index));
		
	}
	
	/** 4. 학생 검색(이름) */
	public void nameSurch() {
		System.out.println("\n=====학생 이름 검색=====\n");
		
		System.out.print("이름을 입력 : ");
		String surchName = sc.nextLine();
		
		System.out.println( service.surchName(surchName).info() );
	}
	
	/** 5. 학생 정보 수정(인덱스) */
	public void updateStudent() {
		
		System.out.println("\n=====학생 정보 수정=====\n");
		System.out.println("변경할 학생의 학번 입력 : ");
		String selectNumber = sc.nextLine();
				
		System.out.println("\n=====수정할 정보=====\n");
		System.out.println("1. 학생 이름 수정");
		System.out.println("2. 학생 학번 수정");
		System.out.println("3. 학생 성별 수정");
		System.out.println("4. 학생 학점 수정");
		System.out.print("수정할 정보를 입력 하세요 : ");
		int choice = sc.nextInt();
		sc.nextLine();
		
		int changeNum = 0;
		
		switch (choice) {
			case 1 : changeNum=1; service.update(changeNum, selectNumber); break;
			case 2 : changeNum=2; service.update(changeNum, selectNumber); break;
			case 3 : changeNum=3; service.update(changeNum, selectNumber); break;
			case 4 : updateScore(changeNum, selectNumber); break;
			default : System.out.println("번호를 잘못 입력 하셨씁니다."); return;
		}
		
	}
	
	/** 5-2 */
	public void updateScore(int changeNum, String selectNumber) {
		
		System.out.println("\n=====학생 학점 수정=====\n");
		System.out.println("1. 국어");
		System.out.println("2. 영어");
		System.out.println("3. 수학");
		System.out.println("4. 사회");
		System.out.println("5. 과학");
		System.out.println("수정할 과목 입력 : ");
		int subNum = sc.nextInt();
		sc.nextLine();
		switch (subNum) {
			case 1 : changeNum=4; service.update(changeNum, selectNumber); break;
			case 2 : changeNum=5; service.update(changeNum, selectNumber); break;
			case 3 : changeNum=6; service.update(changeNum, selectNumber); break;
			case 4 : changeNum=7; service.update(changeNum, selectNumber); break;
			case 5 : changeNum=8; service.update(changeNum, selectNumber); break;
			default : System.out.println("번호를 잘못 입력 하셨씁니다."); return;
		}
	}
	
	/** 6. 학생 1명 점수 조회(점수, 합계, 평균) */
	public void scoreStudent() {
		System.out.println("\n=====학생 이름 검색=====\n");
		
		System.out.print("이름을 입력 : ");
		String surchName = sc.nextLine();
		
		System.out.println("점수 : " + service.surchName(surchName).score());
		System.out.println("합계 : " + (int)service.avg( service.surchName(surchName) ) * 5 );
		System.out.println("평균 : " + service.avg( service.surchName(surchName) ));
		
		
	}
	
	/** 7. 평균 최고점, 최저점 학생 */
	public void bestAll() {
		service.bestScore();
	}
	
}
