package service;

import java.util.Random;
import java.util.Scanner;

import dto.StudentDTO;

public class StudentService {
	
	// 필드
	private StudentDTO[] students = new StudentDTO[10];
	private Random random = new Random();
	private Scanner sc = new Scanner(System.in);
	
	// 생성자
	public StudentService() {
		
		students[0] = new StudentDTO("짱구", "240001", '남');
		students[1] = new StudentDTO("철수", "240002", '남');
		students[2] = new StudentDTO("훈이", "240003", '남');
		students[3] = new StudentDTO("유리", "240004", '여');
		students[4] = new StudentDTO("맹구", "240005", '남');
		
		for (StudentDTO std : students ) {
			if ( std != null ) {
				std.setLan(random.nextInt(101));
				std.setEng(random.nextInt(101));
				std.setMat(random.nextInt(101));
				std.setSoc(random.nextInt(101));
				std.setSic(random.nextInt(101));
			}
		}
	}

	/**
	 * 이름, 학번, 성별을 입력받고 
	 * 새 배열에 넣을 수 있으면 true / 없으면 false 반환
	 * @param name
	 * @param studentNumber
	 * @param gender
	 * @return
	 */
	public Boolean addStudent(String name, String studentNumber, char gender) {
		
		StudentDTO std = new StudentDTO(name, studentNumber, gender);
		
		for ( int i = 0 ; i < students.length ; i++) {
			
			if ( students[i] == null ) {
				students[i] = std;
				return true;
			}
		}
		
		return false;
	}
	
	/** 전체정보출력 */
	public void allStudent() {
		
		for (StudentDTO std : students ) {
			if (std == null) return;
			System.out.println(std.info());
		}
	}
	
	/**
	 * 인덱스로 학생 검색
	 * @param index
	 * @return String Infomation
	 */
	public String selectService(int index) {
		
		if (index < 0 || index >= students.length ) return "검색할 수 없는 번호입니다.";
		if (students[index] == null ) return "검색할 수 없는 번호입니다.";
		
		return students[index].info();
		
	}

	/**
	 * 이름으로 학생 검색
	 * return StudentDTO
	 */
	public StudentDTO surchName(String surchName) {
		StudentDTO result = null;
		
		for (StudentDTO std : students) {
			if(std.getName().equals(surchName)) {
				result = std;
				break;
			} else {
				return null;
			}
		}
		return result;
	}
	
	/** 학생 정보 검색
	 *  StudentDTO => String*/
	public String searchINfo(StudentDTO std) {
		String infomation = "";
		
		if (std == null) {
			infomation = "학생을 찾을 수 없습니다.";
		} else {
			infomation = std.info();
		}
		
		return infomation;
	}

	/** 정보수정*/
	public void update(int changeNum, String selectWord) {
		
		// 비교길이 구하기
		int length = 0;
		for (int i = 0 ; i < students.length ; i++) {
			if(students[i] == null) {
				length = i;
				break;
				}
		}
		
		int index = -1;
		for ( int i = 0 ; i < length ; i++) {	// 학번검색
			if (students[i].getStudentNumber().equals(selectWord)) {
				index = i;
				break;
			} 
		}
		
		
		for ( int i = 0 ; i < length ; i++ ) { 				// 이름검색
			if ( students[i].getName().equals(selectWord) ) {
				index = i;
				break;
			}
		}
		
		
		
		if (index == -1) {	// 학번검색오류
			System.out.println("\n***학생 식별자 입력이 잘못되었습니다.***");
			return;
		}
		
		
		/** 점수입력받기 */
		int newScore = -1;
		switch(changeNum) {
			case 4,5,6,7,8 :
				sc.nextLine();
				System.out.print("수정할 점수 : ");
				String inputScore = sc.nextLine();
				if(!isNaN(inputScore)) {
					System.out.println("***>정수를 입력해 주세세요***\n");
					return;
				}
				newScore = Integer.parseInt(inputScore);
				
				if(newScore > 100) newScore = 100;
				if(newScore <   0) newScore =   0;
				break;
		}
		
		boolean flag = false;
		
		switch(changeNum) {
		
			case 1 : 
				
				System.out.print("수정할 이름 : ");
				String name = sc.nextLine();
				
				students[index].setName(name);
				
				flag = true;
				break;
				
			case 2 : 
				
				System.out.print("수정할 학번 : ");
				String studentNumber = sc.nextLine();
				
				students[index].setStudentNumber(studentNumber);
				
				flag = true;
				break;
				
			case 3 : 
				
				System.out.print("수정할 성별 : ");
				char gender = sc.next().charAt(0);
				
				students[index].setGender(gender);
				
				flag = true;
				break;
				
			case 4 : 
				
				students[index].setLan(newScore);
				
				flag = true;
				break;
				
			case 5 : 
				
				students[index].setEng(newScore);
				
				flag = true;
				break;
				
			case 6 : 
				
				students[index].setMat(newScore);
				
				flag = true;
				break;
				
			case 7 : 
				
				students[index].setSoc(newScore);
				
				flag = true;
				break;
				
			case 8 : 
				
				students[index].setSic(newScore);
				
				flag = true;
				break;
				
			
			default : System.out.println(">>>>>ALERT<<<<<");
		}
		
		if(flag) {
			System.out.println("\n***변경이 완료되었습니다***");
		} else {
			System.out.println("\n***정보를 변경할 수 없습니다***");
		}
		
		
	}
	

	/** 6. 학생 1명 점수 조회(점수, 합계, 평균) */
	public double avg(StudentDTO std) {
		int lan = std.getLan();
		int eng = std.getEng();
		int mat = std.getMat();
		int soc = std.getSoc();
		int sic = std.getSic();
		
		double average = (lan + eng + mat + soc + sic)/5.0;
		
		return average;
	}

	/** 7. 평균 최고점, 최저점 학생 */
	public void bestScore() {
		
		// 최고점
		double a = avg(students[0]);
		double b = 0.0;
		int maxIndex = 0;
		for (int i = 1 ; i < students.length ; i++) {
			if (students[i] == null) break;
			b = avg(students[i]);
			if (a < b) {
				a = b; 	// 큰 수를 계속 비교
				maxIndex = i;
			}
		}
		
		System.out.println("최고점 학생 : " + students[maxIndex].getName() );
		System.out.println("최고점 평균 : " + avg( students[maxIndex] ) );
		
		// 최저점
		double c = avg(students[0]);
		double d = 0.0;
		int minIndex = 0;
		for (int i = 1 ; i < students.length ; i++) {
			if (students[i] == null) break;
			d = avg(students[i]);
			if (c > d) {
				c = d;	// 더 작은 수를 계속 비교
				minIndex = i;
			}
		}
		
		System.out.println("최저점 학생 : " + students[minIndex].getName() );
		System.out.println("최저점 평균 : " + avg( students[minIndex] ) );
		
	}
	
	/** */
	public boolean isNaN(String num) {
		try {
			Integer.parseInt(num);
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}

}
