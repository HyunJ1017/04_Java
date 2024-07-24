package pkg1.dto;

public class Carnibal extends Car {

	private String name = "승합차";
	private String fuel = "Diesel";
	private String kind = "승합";
	private int boarding = 9;
	private int coast;
	private int maxSpeed;
	private int efficiency;
	

	public Carnibal(String carNumber) {
		super(carNumber);
	}


	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getFuel() {
		return fuel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public int getBoarding() {
		return boarding;
	}

	public void setBoarding(int boarding) {
		this.boarding = boarding;
	}

	public int getCoast() {
		return coast;
	}

	public void setCoast(int coast) {
		this.coast = coast;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getEfficiency() {
		return efficiency;
	}

	public void setEfficiency(int efficiency) {
		this.efficiency = efficiency;
	}
	
	/**
	 * inform overriding
	 */
	@Override
	public String inform() {
		return super.inform() + " / name : " + name + "\n가격 : " + coast + " / 차종 : " + kind;
	}
}
