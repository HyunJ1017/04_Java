package pkg2.dto;

public class Cat extends Animal {
	
	//The type Cat must implement the inherited abstract method Animal.move()
	// -> 상속받은 move() 구현해야 합니다.
	//The type Cat must implement the inherited abstract method Animal.sleep()
	// ...
	
	// 고양이 만의 필드
	private int beard;	// 수염
	
	// 생성자
	public Cat() {
		super();	// 부모객체 생성 
	}
	
	public Cat(int eyes, int beard) {
		super(eyes);
		this.beard = beard;
	}

	public int getBeard() {
		return beard;
	}

	public void setBeard(int beard) {
		this.beard = beard;
	}
	
	@Override
	public String toString() {
		return "Cat : " + beard + " / " + getEyes();
	}


	/* Animal로 부터 상속받은
	 * abstract 메서드를 구련(오버라이드)하라고
	 * 오류가 발생함
	 * -> 오버리이딩 강제화
	 * */
	
	

	@Override
	public void move() {
		System.out.println("고양이 : 사뿐사뿐");
	}

	@Override
	public void sleep() {
		System.out.println("고양이 : 엎드려잠");
	}
	
	@Override
	public void eat() {
		System.out.println("고양이 : 냠냠먹음");
	}

}
