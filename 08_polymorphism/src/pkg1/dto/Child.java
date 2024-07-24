package pkg1.dto;

public class Child extends Parent {
	
	private String car;
	
	public Child() {
		super();	// 안써도 컴파일러가 자동으로 추가
	}

	public Child(String lastName, int money, String car) {
		super(lastName, money);
		this.car = car;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}
	
	
}
