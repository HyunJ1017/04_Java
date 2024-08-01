package pkg2.run;

import pkg2.service.ObjectService;

public class ObjectRun {
	public static void main(String[] args) {
		
		ObjectService service = new ObjectService();
//		int input = 0;
//		do {}while();
//		service.createMember(); // 처음하니까 아무것도 없다고 오류남
		// 아깐 됬잔아 ㅜㅜ
		// List 비어있으면 아무것도 안됨..;
		// member를 밖에서 선언해두고 NullPointException뜨면 밑에서 새로 List&파일 만들어서 해결???
		
//		service.newFile();
		
		service.readFile();
		
	}

}
