package student.run;

import student.view.StudentView;

// Data Transfer Object
// -> 객체를 이용해서 여러 값을 묶어
//    한번에 전달하는 용도
public class StudentRun {

	public static void main(String[] args) {
		
		// StudentView 객체 생성
		StudentView view = new StudentView();
		view.mainMenu();
	}
	
}
