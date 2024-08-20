package pkg1.run;

import pkg1.service.Service;

public class run2 {
	public static void main(String[] args) {
		
		Service service = new Service();
		
		System.out.println("실행");
		
//		service.solution34("123");
		
		int i = service.solution35(null, null);
		System.out.println(i);
	}
}
