package method;

import java.util.Scanner;

// 기능 제공용 서비스
public class StudentService {

	//필드
	private Scanner sc = new Scanner(System.in); // 스캐너 객체 생성
	
	/** 메인메뉴화면*/
	public void mainMenu() {
		int input = 0;							// 입력받은 메뉴 번호를 저장할 변수
		
		// 생성된 학생 객체 주소를 저장할 참조 변수
		// (null : 참조하는 객체가 없다, 주소저장 X)
		Student std = null;
		
		do {
			
			System.out.println("\n==== 학생 1명 관리 프로그램 ====");
			
			System.out.println("1. 학생 등록"         );
			System.out.println("2. 학생 정보 확인"    );
			System.out.println("3. 학생 이름 수정"    );
			System.out.println("4. Java 공부하기"     );
			System.out.println("5. HTML 공부하기"     );
			System.out.println("0. 프로그램 종료"     );
			
			System.out.print(" 메뉴 번호 입력 : ");
			input = sc.nextInt();
			
			sc.nextLine(); // 입력버퍼에 남아있는 엔터 제거
			
			System.out.println();
			
			switch(input) {
			
			case 1 : 
				std = registStudent(); //std에 student 주소값 저장됨
				System.out.println(std.getName() + "학생 등록됨!!");
				
				break;
			
			case 2 : 
				System.out.println("[학생 정보 확인]");
				
				// static 값은 클래스 명을 붙여서 호출
				System.out.println("학교 : "+ Student.schoolName);
				
				System.out.println(std.toString());
				
				break;
			
			case 3 : 
				// 학생이름수정 메서드 호출시
				// std에 저장된 학생 객체 참조주소 전달
				// (얕은복사여서 저기서 수정하면 여기서도 수정됨) 
				updateName(std);
				
				break;
			
			case 4 :
				studyJava(std);
				
				break;
			
			case 5 : 
				studyHtml(std);
				
				break;
			
			case 0 : System.out.println("== 프로그램을 종료합니다... =="); break;
			
			default : System.out.println(" === 알맞은 메뉴 번호를 입력해 주세요 === ");
			
			}
			
		} while(input != 0); // 최소 1회 이상 반복하게 do~while 사용
		
	}
	
	
	
	/**
	 * 1. 학생등록 메서드
	 * @return 생성된 스튜던트 객체의 주소가 반환될거임
	 */
	private Student registStudent() {
		
		System.out.print("[학생 등록]"      );
		
		System.out.print("이름 : "          );
		String name = sc.nextLine()          ;
		
		System.out.print("학번 : "          );
		String studentNumber = sc.nextLine() ;
		
		System.out.print("성별(남/여) : "   );
		char gender = sc.next().charAt(0)    ;
		
		Student student = new Student(name, studentNumber, gender);
		
		// student 변수에는
		// 생성된 Student 자료형 객체를 참조하는 주소값이 담겨있다.
		// --> 주소값이 복사되어 호출한 곳으로 돌아감, 얕은복사
		return student;
	}
	
	
	/**
	 * 3. 학생 이름 수정
	 * - 굳이 반환할거 없어서 void
	 * @param std : 전달받은 Student 객체 참조주소 
	 */
	private void updateName(Student std) {
		
		System.out.println("\n[학생 이름 수정]"          );
		System.out.println("기존 이름 : " + std.getName());
		
		System.out.print("변경할 이름 입력 : "           );
		String newName = sc.nextLine();
		
		// 이름을  홍길동 -> 김철수로 변경 하시겠습니까?(y/n)
		System.out.printf("이름을 %s에서 %s로 변경 하시겠습니까(y/n)?", std.getName(), newName);
		
		//String.toUpperCase() -> 대문자로 변환
		//String.toLowerCase() -> 소문자로 변환
		char check = sc.next().toUpperCase().charAt(0);
		
		// --> char 형은 비교 가능, String은 참조변수여서 비교 X
		if(check == 'N') {
			System.out.println("== 이름 변경 취소됨 ==");
			return;
		}
		
		// 'y'가 입력되었을때
		std.setName(newName); // 새로운 이름을 세팅
		System.out.println("== 이름 변경 완료 ==");
		
	}
	
	
	/**
	 * 4. 자바공부 수행
	 * 단, 수정된 자바 역량은 최대값 100, 최솟값 0 범위 초과가 불가
	 * @param std
	 */
	public void studyJava(Student std) {
		System.out.println("[Java 공부 하기]");
		
		int before = std.getJava(); // 이전 점수 저장
		// 얕은복사로 참조받은 주소의 Java점수를 가져옴
		System.out.println("현재 Java 역량 점수 : " + std.getJava());
		
		System.out.print("증가 또는 감소한 Java 역량 점수 입력 : ");
		int score = sc.nextInt();
		
		// 기존점수에 누적
		int temp = std.getJava()+score;
		
		if ( temp > Student.MAX_VALUE ) temp = Student.MAX_VALUE;
		if ( temp < Student.MIN_VALUE ) temp = Student.MIN_VALUE;
		
		std.setJava(temp);
		
		System.out.println("== Java 역량 점수 수정 완료 ==");
		
		// 기존 변경 증감
		// 50 -> 80  (+30)
		// 50 -> 20  (-30)
		// 90 -> 100 (+30)
		// 10 - > 0  (-40)
		
		// 음수인 경우  score 문자열
		// 양수인 경우 +score 문자열
		//						   int + String = String
		String str = (score <= 0) ? score + "" : "+" + score;
		
		System.out.printf("%d -> %d (%s)/n", before, std.getJava(), str);
	}
	
	
	/**
	 * 5. HTML 입력하기
	 */
	private void studyHtml(Student std) {
		System.out.println("[HTML 공부 하기]");
		
		int before = std.getHtml();
		System.out.println("현재 HTML 역량 점수 : " + std.getHtml());
		
		System.out.print("증가 또는 감소한 HTML 역량 점수 입력 : ");
		int score = sc.nextInt();
		
		int temp = std.getHtml() + score;
		
		if ( temp > Student.MAX_VALUE ) temp = Student.MAX_VALUE;
		if ( temp < Student.MIN_VALUE ) temp = Student.MIN_VALUE;
		
		std.setHtml(temp);
		System.out.println("== HTML 역량 점수 수정 완료 ==");
		
		String str = score <= 0 ? score + "" : "+" + score;
		
		System.out.printf("%d -> %d (%s)/n", before, std.getHtml(), str);
		
	}
	
}
