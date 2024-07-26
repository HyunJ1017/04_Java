package practice.dto;

import practice.service.PracticeService;

public class Target1 extends PracticeDTO1 {
	
	PracticeService service = new PracticeService();

	
	private String caseof;

	public Target1(String name, int score, int point, String caseof) {
		super(name, score, point);
		this.caseof = caseof;
	}
	
	public String getCaseof() {
		return caseof;
	}

	public void setCaseof(String caseof) {
		this.caseof = caseof;
	}

	
	

	@Override
	public boolean targetOther(Target1 otherTarget) {
		
		service.targeting(this, otherTarget);
		
		return true;
	}

}
