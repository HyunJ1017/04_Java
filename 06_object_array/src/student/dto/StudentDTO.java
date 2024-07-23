package student.dto;

public class StudentDTO {

	private String studentNumber; // 학번
	private String name;		  // 이름
	private char   gender;		  // 성별
	private int    html;
	private int    css;
	private int    js;
	private int    java;
	
	/** 생성자 */
	// -> 매개변수 생성자를 만들어서 기본생성자 필요시 따로 만들어줄 필요 있음
	public StudentDTO(String studentNumber, String name, char gender) {
		this.studentNumber = studentNumber;
		this.name          = name;
		this.gender        = gender;
	}

	
	// 점수운반용생성자
	public StudentDTO(int html, int css, int js, int java) {
		super();
		this.html = html;
		this.css = css;
		this.js = js;
		this.java = java;
	}



	/** getter / setter */
	
	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getHtml() {
		return html;
	}

	public void setHtml(int html) {
		this.html = html;
	}

	public int getCss() {
		return css;
	}

	public void setCss(int css) {
		this.css = css;
	}

	public int getJs() {
		return js;
	}

	public void setJs(int js) {
		this.js = js;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}
	
	
	/** 추가 메서드 */
	public String toString() {
		
		// 학번 / 성별 / 이름
		// HTML : 100 / CSS : 50 / JS : 70 / Java : 100
		return String.format( "%s / %c / %s\n"
			+ "HTML : %d / CSS : %d / JS : %d / Java %d", 
			studentNumber, gender, name,
			html, css, js, java);
	}
	
}
