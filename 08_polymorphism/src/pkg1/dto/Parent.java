package pkg1.dto;

public class Parent {

	
	private String lastName = "김";
	private int    money    = 50_000;
	
	public Parent () {
		super(); // 부모(Object) 생성자 호출, Object 인 경우에는 안써도 됨, extends Object랑 같음
	}

	public Parent(String lastName, int money) {
		super();
		this.lastName = lastName;
		this.money = money;
	}



	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	//toString() 오버라이드
	@Override
	public String toString() {
		return "Parent : " + lastName + " / " + money;
	}
	
}
