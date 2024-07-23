package student.view;

import java.util.Scanner;

import student.dto.StudentDTO;
import student.service.StudentService;

// 콘솔창에 보여지는용
// == 클라이언트의 입력/출력을 담당하는 클래스
public class StudentView {
	
	/** 필드 */
	private Scanner sc = new Scanner(System.in);
	private StudentService service = new StudentService();
	
	
	/** 메인메뉴 출력*/
	public void mainMenu() {
		
		int input = 0;// 입력받을 메뉴번호 저장할 편수
		
		do {
			
			System.out.println("\n----- 학생 관리 프로그램 -----");
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 전체 조회");
			System.out.println("3. 학생 1명 정보 조회(인덱스)");
			System.out.println("4. 학생 이름으로 조회"); // 동명이인 X 가정
			System.out.println("5. 학생 정보 수정(인덱스)");
			System.out.println("6. 학생 1명 점수 조회(점수, 합계, 평균)");
			System.out.println("7. 평균 최고점, 최저점 학생");
			System.out.println("0. 종료");
			
			System.out.print("메뉴 선택 >> ");
			
			input = sc.nextInt();
			sc.nextLine(); // 입력버퍼에 남아있는 엔터 제거
			
			System.out.println();
			
			switch (input) {
			case 1  : addStudent();   break;
			case 2  : allStudent();   break;
			case 3  : selectIndex();  break;
			case 4  : selectName();   break;
			case 5  : updateIndex();  break;
			case 6  : selectScore();  break;
			case 7  : selectMaxMin(); break;
			case 624 : testMaxMin();   break;
			
			case 0  : System.out.println("==== 프로그램 종료 ===="  ); break;
			default : System.out.println("=== 메뉴번호 잘못 입력 ===");
			}
			
		} while ( input != 0 );
		
	}
	

	/** 학생 추가 화면
	 * 
	 * 학번, 이름, 성별을 입력 받아
	 * Student 객체로 만들어서 StudentService로 전달!
	 * -> 추가 성공시 true / 실패시 false를 반환받아
	 * 결과 출력
	 */
	private void addStudent() {
		
		System.out.println("\n----- 학생 추가 -----\n");
		
		System.out.print("학번 : ");
		String studentNumber = sc.nextLine();
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("성별(남/여) : ");
		char gender = sc.next().charAt(0);
		
		// 학생 객체를 생성하여 입력 받은 데이터를 저장(세팅)
		StudentDTO std = new StudentDTO(studentNumber, name, gender);
		
		// StudentService 객체의 addStudent() 호출 후 결과 반환받기
		boolean result = service.addStudent(std);
		
		if (result) {
			System.out.println(name + " 학생이 추가 되었습니다.");
		} else {
			System.out.println("더 이상 학생을 추가할 수 없습니다.");
		}
		
	}
	
	
	/**
	 * StudentService에 있는 students 객체 배열을 얻어와 모든 학생 정보를 출력
	 */
	private void allStudent() {
	
		System.out.println("\n----- 학생 전체 조화 -----\n");
		
		StudentDTO[] students = service.getStudents();
		
		for ( StudentDTO std : students ) {
			
			// null인경우 == 저장되신 학생이 안계시면
			// -> NullPointerException 방지
			//  -> (참조된 주소가 없는데 null을 사용하려고 할 때)
			if (std == null) return;
			
			System.out.println( std.toString() );
			System.out.println("------------------------------------");
		}
		
	}
	
	
	/** 3번
	 * 인덱스를 입력받아 Service에 전달하여
	 * 해당 인덱스번째의 학생객체 하나(StudentDTO)를 반환받아 출력
	 *  */ 
	private void selectIndex() {
		
		System.out.println("\n----- 학생 1명 조회(index) -----\n");
		System.out.print  ("조회할 인덱스 입력 : ");
		int index = sc.nextInt();
		
		// setvice 메서드 호출 후 학생 1명 정보 반환 받기
		// null || 학생객체주소
		StudentDTO std = service.selectIndex(index);
		
		if ( std == null ) {
			System.out.println("*** 해당 인덱스에 학생 객체가 존재하지 않습니다 ***");
			return;
		}
		
		System.out.println("[ " + index + " 번째 학생 정보 ]");
		System.out.println( std.toString());
	}
	
	
	/** 4번
	 * 이름을 입력받아 service의 students 배열에서
	 * 같은 이름을 가진 학생 객체를 얻어와 출력
	 * -> 이름검색
	 * */
	private void selectName() {
		
		System.out.println("\n----- 이름으로 조회 -----\n");
		System.out.print("검색할 학생 이름 : ");
		String targetName = sc.nextLine();
		
		// 입력받은 이름을 서비스로 전달하여
		// 일치하는 이름을 가진 학생객체(주소)를 반환받기
		StudentDTO std = service.selectName(targetName);
		
		if (std == null) {
			System.out.println("*** 같은 이름의 학생이 존재하지 않습니다 ***");
			return;
		}
		
		System.out.println(std.toString());
	}
	
	
	/**
	 * 인덱스 번호를 입력받아 일치하는 학생의
	 * html, css, js, java 점수 수정
	 * 
	 * 단, 입력된 인덱스가 0 미만
	 *     students 배열 마지막 인덱스 초과한 경우
	 *     "인덱스 범위가 올바르지는 않습니다."
	 *     
	 *     정상범위 인덱스 이지만 학생이 존재하지 않는 경우
	 *     "해당 인덱스에 학생 정보가 존재하지 않습니다" 출력
	 */
	private void updateIndex() {
		
		System.out.print("\n----- 학생 점수 주성 -----\n");
		
		System.out.print("수정할 학생의 인덱스 번호 입력 : ");
		int index = sc.nextInt();
		
		// 입력받은 index가 정상인지 판별
		// 1 == 범위 초과
		// 2 == 학생없음
		// 3 == 정상
		int check = service.checkIndex(index);
		
		if ( check == 1 ) {
			System.out.println("인덱스 범위가 올바르지는 않습니다.");
			return;
		}
		
		if ( check == 2 ) {
			System.out.println("해당 인덱스에 학생 정보가 존재하지 않습니다");
			return;
		}
		
		/* 학생이 존재하는 경우 */
		System.out.print("HTML, CSS, JS, Java 순서로 점수 입력 : ");
		int html = sc.nextInt();
		int css = sc.nextInt();
		int js = sc.nextInt();
		int java = sc.nextInt();
		
		// 점수만 담은 용도의 StudentDTO 객체
		StudentDTO scores = new StudentDTO(html, css, js, java);
		
		// 점수 수정 서비스 메서드 콜
		// 절대 실패할일 없음(인덱스 번호 확인 끝나서)
		service.updateScores(index, scores);
		
	}


	/**
	 * 입력받은 index번째 학생의 점수, 합계, 평균 출력
	 * 
	 * 단, 정상 index인지 확인
	 * 
	 * ex) 인덱스 입력 : 0
	 * ------------------------------------
	 * 이름 : 짱ㄱ
	 * HTML(80) CSS(70) JS(50) Java(90)
	 * 합계 : 290
	 * 평균 : 72.5
	 * ------------------------------------
	 */
	public void selectScore() {
		System.out.print("\n----- 학생 점수 조회 -----\n");
		
		System.out.print("인덱스 입력 : ");
		int index = sc.nextInt();
		
		// 입력받은 index가 정상인지 판별
		// 1 == 범위 초과
		// 2 == 학생없음
		// 3 == 정상
		int check = service.checkIndex(index);
		
		if ( check == 1 ) {
			System.out.println("인덱스 범위가 올바르지는 않습니다.");
			return;
		}
		
		if ( check == 2 ) {
			System.out.println("해당 인덱스에 학생 정보가 존재하지 않습니다");
			return;
		}
		
		/* 학생이 존재하는 경우 */
		StudentDTO std = service.selectIndex(index);
		System.out.println("------------------------------------");

		System.out.println("이름 : " + std.getName());
		
		System.out.printf(" HTML(%d) CSS(%d) JS(%d) Java(%d)\n", 
				std.getHtml(), std.getCss(), std.getJava(), std.getJs() );
		
		// 합계
		int sum = std.getHtml() + std.getCss() + std.getJava() + std.getJs();
		
		// 평균
		double average = sum/4.0;
		
		System.out.println("합계 : " + sum );
		System.out.println("평균 : " + average);
		
		System.out.println("------------------------------------");
		
	}


	/**
	 * 평균 최고, 최저점 조회하기
	 * 
	 * 최고점 : 철수(85.4)
	 * 최저점 : 짱구(61.5)
	 */
	private void selectMaxMin() {
		System.out.println("\n----- 평균 최고/ 최저점 조회 -----\n");
		
		String result = service.selectMaxMin();
		
		System.out.println(result);
		
	}
	
	
	
	
	private void testMaxMin() {
		
		// 테스트 코드
		int[] arr = {50,30,10,70,40};
		
		int max = 0;
		int min = 0;
		
		for(int i = 0 ; i < arr.length ; i++) {
			if (i == 0 ) { // 맨 처음에는요
				max = arr[i];
				min = arr[i];
				continue;
			}
			
			// 최대값을 비교
			if (arr[i] > max) max = arr[i]; // max에 새로운 최대값 대입
			if (arr[i] < min) min = arr[i]; // min에 새로운 최소값 대입
			
		}
		
		System.out.println("max : " + max);
		System.out.println("min : " + min);
		
	}

}
