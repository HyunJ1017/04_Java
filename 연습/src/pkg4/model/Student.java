package pkg4.model;

public class Student {
	private String name;
	private int score;
	
	public Student() {}
	
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
//		return name + " 학생의 점수 : " + score + "점";
		return String.format("%s 학생의 점수 : %3d 점", name, score);
	}
	
}
