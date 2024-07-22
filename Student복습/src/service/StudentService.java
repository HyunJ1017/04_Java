package service;

import dto.StudentDTO;

public class StudentService {
	
	// 필드
	private StudentDTO[] students = new StudentDTO[10];
	
	// 생성자
	public StudentService() {
		
		students[0] = new StudentDTO("짱구", "240001", '남');
		students[1] = new StudentDTO("철수", "240002", '남');
		students[2] = new StudentDTO("훈이", "240003", '남');
		students[3] = new StudentDTO("유리", "240004", '여');
		students[4] = new StudentDTO("맹구", "240005", '남');
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
			std.info();
		}
	}
	

}
