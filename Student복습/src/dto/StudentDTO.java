package dto;

public class StudentDTO {
	
	// 필드
	private String name;
	private String studentNumber;
	private char   gender;
	private int    lan;
	private int    eng;
	private int    mat;
	private int    soc;
	private int    sic;
	
	// 생성자
	public StudentDTO(String name, String studentNumber, char gender) {
		this.name = name;
		this.studentNumber = studentNumber;
		this.gender = gender;
	}

	//메서드
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getLan() {
		return lan;
	}

	public void setLan(int lan) {
		this.lan = lan;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getSoc() {
		return soc;
	}

	public void setSoc(int soc) {
		this.soc = soc;
	}

	public int getSic() {
		return sic;
	}

	public void setSic(int sic) {
		this.sic = sic;
	}
	

	/** 확인용 */
	public void info() {
		System.out.printf("이름 : %s / 학번 : %s / 성별 : %c / 국 : %d / 영 : %d / 수 : %d / 사 : %d / 과 : %d\n", name, studentNumber, gender, lan, eng, mat, soc, sic);
	}
	
}
