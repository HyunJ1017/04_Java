package practice.dto;

public abstract class PracticeDTO1 {
	
	private String name;
	private int score;
	private int point;
	public static final int max_score = 100;
	public static final int min_score = 0;
	
	public PracticeDTO1() {}

	public PracticeDTO1(String name, int score, int point) {
		super();
		this.name = name;
		this.score = score;
		this.point = point;
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

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "PracticeDTO1 [name=" + name + ", score=" + score + ", point=" + point + "]";
	}
	
	/* 공통메서드 */

	public abstract boolean targetOther(Target1 otherTarget);

}
