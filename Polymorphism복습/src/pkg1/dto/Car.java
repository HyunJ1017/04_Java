package pkg1.dto;

public class Car {
	
	private String carNumber;
	private int    wheel = 4;
	private int    engine = 1;
	
	public Car(String carNumber) {
		super();
		this.carNumber = carNumber;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public int getWheel() {
		return wheel;
	}

	public void setWheel(int wheel) {
		this.wheel = wheel;
	}

	public int getEngine() {
		return engine;
	}

	public void setEngine(int engine) {
		this.engine = engine;
	}
	
	/**
	 * inform
	 * return String
	 */
	public String inform() {
		return "번호 : " + carNumber;
	}
}
