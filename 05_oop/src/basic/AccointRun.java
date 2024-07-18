package basic;

public class AccointRun {

	public static void main(String[] args) {

		// Account 객체 생성
		Account a1 = new Account();
		
//		a1.name          = "지우";
//		a1.accountNumber = "1234567890";
//		a1.balance       = 10000;
//		a1.password      = "1q2w3e4r";
//		
//		// a1의 계좌의 잔액 비밀번호 바꾸기
//		System.out.println("a1 잔액 : " + a1.balance);
//		
//		a1.balance = 0;
//		a1.password = "asdf1234";
//		System.out.println("a1 잔액 : " + a1.balance);
		
		/**
		 * 간접 접근 기능을 이용해 세팅
		 */
		a1.setName("홀길동");
		a1.setAccountNumber("12345677890");
		a1.setBalance(10000);
		a1.setPassword("1q2w3e4r");
		
		String name1			= a1.getName();
		String accountNumber1 	= a1.getAccountNumber();
		long balance1 			= a1.getBalance();
		String password1 		= a1.getPassword();
		
		System.out.printf("%s / %s / %d / %s \n", name1, accountNumber1, balance1, password1);
		
		// 입금기능
		a1.deposit(10000000000L);	// a1이 참조하는 계좌의 잔액을 100억 추가
		
		// 출금기능
		System.out.println("\n출금기능 확인");
		
		a1.withdraw("zxcasdf", 1000000); //불일치 경우
		a1.withdraw("1q2w3e4r", 12345000000006L); // 잔액부족
		a1.withdraw("1q2w3e4r", 10000007000L); // 출금성공
		a1.withdraw("1q2w3e4r", 3000);
		
	}

}
