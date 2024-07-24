package dto;

public class Child3 extends Parent {

	private String notebook;
	
	@Override
	public String toString() {
		return " [child3] " + super.toString();
	}
	
	
	public void settings(String address, int money, String car, String notebook) {
		super.settings(address, money, car);
		setNotebook(notebook);
		System.out.println("Child3 세팅됨");
	}


	public String getNotebook() {
		return notebook;
	}


	public void setNotebook(String notebook) {
		this.notebook = notebook;
	}
	
}
