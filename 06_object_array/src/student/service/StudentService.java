package student.service;

import java.util.Random;

import student.dto.StudentDTO;

// 기능(비지니스 로직) 제공용 클래스
public class StudentService {
	
	// StudentDTO 참조변수 5개 들을 참조하는 students 생성
	private StudentDTO[] students = new StudentDTO[5];

	/** 기본 생성자*/
	public StudentService() {
		
		// 학생 객체배열 (students)에 샘플학생 3명 추가
		
		students[0] = new StudentDTO("24001", "짱구", '남');
		students[1] = new StudentDTO("24002", "유리", '여');
		students[2] = new StudentDTO("24003", "맹구", '남');
		
		// students[3] / [4] == null
		
		// 0 ~ 100사이 난수
		// 1) Math.floor(Math.random()) * 101
		// 2) Random random = new Fandom();
		//    random.nextInt(101); == 0~100
		
		Random random = new Random();
		
		for (StudentDTO std : students ) {
			
			// 현재 접근하는 객체가 참조하는 객체가 없다면 반복을 종료
			if ( std == null ) break;
			
			std.setHtml( random.nextInt(101) ); // 0이상 100미만
			std.setCss ( random.nextInt(101) );
			std.setJs  ( random.nextInt(101) );
			std.setJava( random.nextInt(101) );
			
		}
		
	}
	
	
	/**
	 * 학생 객체배열 students중 비어있는 인덱스에
	 * 전달받은 학생객체(std) 추가
	 * @param std : 입력받은 값을 저장한 학생 객체 주소
	 * @return : ture : 추가 성공 / false : 추가실패
	 * - 실패조건 : students 배열이 꽉 차있는데 추가 학생이 전달된 경우
	 */
	public boolean addStudent(StudentDTO std) {
		
//		0번 인덱스부터
//		순서대로 비어있는(null) 요소를 착아
//		전달받은 std를 대입
		
		for ( int i = 0 ; i < students.length ; i++ ) {
			
			if ( students[i] == null ) { // 비어있는 요소가 있을경우
				students[i] = std;       // 그 요소에 std 주소를 얕은복사
				return true;             // true를 반환하고 반복 종료
			}
			
		}
		
		// 비어잇는 null인 요소가 없을경우 여기까지 진행되서 false를 반환
		return false;
	}
	
	
	/** private 요소에 대한 getter만 호다닥 가져갈거임 */
	public StudentDTO[] getStudents() {
		return students;
	}


	/**
	 * 학생 1명의 정보 조회
	 * @param index
	 * @return 조회된 학생 객체 주소 || null
	 */
	public StudentDTO selectIndex(int index) {
		
		// 전달 받은 index 범위가 students의 인덱스 범위 밖인 경우
		if ( index < 0 || index >= students.length ) {
			return null;
		}
			
		return students[index];
	}


	/**
	 * 전달받은 이름과 일치하는 학생객체를 반환
	 * @param targetName
	 * @return null || 일치하는 학생 객체(주소)
	 */
	public StudentDTO selectName(String targetName) {
		
		for ( StudentDTO std : students ) {
			
			// 저장된 학생이 없을경우
			// --> 뒤에도 없을것!!! -> 그냥 여기서 검색 종료
			if (std == null ) return null;
			
			// == : 기본자료형 비교
			// a.equals(b) : 참조형 (객체) 비교
			if ( std.getName().equals(targetName)) {
				return std;
			}
				
		}
		return null;
	}

	/**
	 * 전달받은 index 가 students 범위 내인지
	 *  + 정상범위라면 해당 index가 학생 객체를 참조하는지 확인
	 * @param index
	 * @return
	 * 	// 입력받은 index가 정상인지 판별
		// 1 == 범위 초과
		// 2 == 학생없음
		// 3 == 정상
	 */
	public int checkIndex(int index) {
		if ( index < 0 || index >= students.length ) return 1;
		if ( students[index] == null ) return 2;
		return 3;
	}


	/**
	 * 전달받은 [index]번째 학생의 점수 수정
	 * @param index
	 * @param scores
	 */
	public void updateScores(int index, StudentDTO scores) {
		
		// students[index]의 주소를 s에 얕은복사
		StudentDTO s = students[index];
		
		s.setHtml( scores.getHtml() );
		s.setCss ( scores.getCss()  );
		s.setJava( scores.getJava() );
		s.setJs  ( scores.getJs()   );
		
	}

	/**
	 * 평균 최고/최저 구하기
	 * 
	 * @return
	 * 최고점 : 철수(85.4)
	 * 최저점 : 짱구(61.5)
	 */
	public String selectMaxMin() {
		int length = 0;
		for (int i = 0; i < students.length ; i++) {
			if ( students[i] == null ) break;
			length++;
		}
		
		String maxName = "";
		String minName = "";
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < length ; i++) {
			
			/* 강사님 풀이
			 * if(students[i] == null) break; 쓰고 향상된for문씀
			 *  */
			
			int temp = students[i].getHtml()+
			students[i].getCss()+
			students[i].getJs()+
			students[i].getJava();
			
			// 체대값
			if (max < temp) {
				max = temp;
				maxName = students[i].getName();
			}
			// 채소값
			if (min > temp) {
				min = temp;
				minName = students[i].getName();
			}
			
		}
		
		double maxAverage = max/4.0;
		double minAverage = min/4.0;
		
		String result = String.format("최고점 : %s(%.1f)\n최저점 : %s(%.1f)\n", 
				maxName, maxAverage, minName, minAverage);
		
		return result;
	}
	
	
}
