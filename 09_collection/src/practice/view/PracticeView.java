package practice.view;

import java.util.Scanner;

import practice.dto.Target1;
import practice.service.PracticeService;

public class PracticeView {
	
	Scanner sc = new Scanner(System.in);
	PracticeService service = new PracticeService();
	
	Target1 pigA  = new Target1("첫째돼지", 100, 5, "지푸라기집");
	Target1 pigB  = new Target1("둘째돼지", 100, 5, "나무집");
	Target1 pigC  = new Target1("셋째돼지", 100, 5, "벽돌집");
	Target1 wolfA = new Target1("늑대", 100, 50, "나쁜늑대");
	
	public void mainView() {
		
		int input = 0;
		
		do {
			System.out.println("\n*** 메뉴 ***");
			System.out.println("1~3. 늑대 >> 1.첫째돼지 2.둘째돼지 3.셋째돼지 ");
			System.out.println("4~6. 4.첫째돼지 5.둘째돼지 6.셋째돼지 >> 늑대");
			System.out.println("7. 첫째돼지 밥주기");
			System.out.println("8. 둘째돼지 밥주기");
			System.out.println("9. 셋째돼지 밥주기");
			
			System.out.print("메뉴 선택 >> ");
			String str = sc.nextLine();
			
			// str이 숫자로 된 문자열인지 확인 후 true/false 반환
			boolean result = service.inNaN(str);
			
			if (!result) {
				System.out.println("*** 잘못 입력 하셨습니다 ***");
				input =99;
				continue;
			}
			
			input = Integer.parseInt(str);
			
			switch(input) {
			case 1 : input = service.targeting(wolfA, pigA); break;
			case 2 : input = service.targeting(wolfA, pigB); break;
			case 3 : input = service.targeting(wolfA, pigC); break;
			case 4 : input = service.targeting(pigA, wolfA); break;
			case 5 : input = service.targeting(pigB, wolfA); break;
			case 6 : input = service.targeting(pigC, wolfA); break;
			case 7 : service.peedback(pigA); break;
			case 8 : service.peedback(pigB); break;
			case 9 : service.peedback(pigC); break;
			case 0 : System.out.println("*** 프로그램을 종료합니다 ***"); break;
			default : System.out.println("*** 잘못 입력 하셨습니다 ***");
			}
			
			
			
		} while (input != 0);
		
	}

}
