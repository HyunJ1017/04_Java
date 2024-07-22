package method;

// 실행용 클래스
public class StudentRun {

	public static void main(String[] args) {
		
		// service 객체를 만들어서 heap 공간에 저장
		StudentService service = new StudentService();
		
		service.mainMenu();
		
	}
}
