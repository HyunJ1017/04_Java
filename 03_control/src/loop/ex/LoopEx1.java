package loop.ex;

import java.util.Scanner;

public class LoopEx1 {
	
	Scanner sc = new Scanner(System.in);
	
	public void method0() {
		System.out.println("1.  method1  실행  - 1~10출력");
		System.out.println("2.  method2  실행  - 점프출력");
		System.out.println("3.  method3  실행  - 몰랑출력");
		System.out.println("4.  method4  실행  - 배수출력");
		System.out.println("5.  method5  실행  - n 단출력");
		System.out.println("6.  method6  실행  - n x m단출력");
		System.out.println("99. method99 실행  - m x M x d단출력");
		System.out.println("7.  method7  실행  - 출력");
		System.out.println("8.  method8  실행  - 구구단v2출력");
		System.out.print("실행시킬 함수 : ");
		int num = sc.nextInt();
		switch(num) {
		case 1 : method1(); break;
		case 2 : method2(); break;
		case 3 : method3(); break;
		case 4 : method4(); break;
		case 5 : method5(); break;
		case 6 : method6(); break;
		case 99 : method99(); break;
		case 7 : method7(); break;
		case 8 : method8(); break;
		}
	}
	
	
	/**
	 * 1qnxj 10까지 출력하기
	 */
	public void method1() {
		
		// Java는 초기 변수식 선언 시 let -> int
		for( int i = 0 ; i < 10 ; i++) {
			System.out.println(i+1);
		}
		
	}

	
	/**
	 * 첫번째 입력받은 수 부터
	 *  두번째 입력받은 수 이하까지 
	 *   세번째 입력반은 수 만큼 증가하며 출력하기
	 */
	public void method2() {
		
		System.out.print("시작 끝 증가값 :");
		int start = sc.nextInt();
		int end	  = sc.nextInt();
		int value = sc.nextInt();
		
		for ( int i = start ; i <= end ; i += value ) {
			System.out.println(i);
		}
	}
	
	/**
	 * 두 수를 입력받아
	 * 작은수부터 큰수 이하까지 1씩 증가하며 반복
	 */
	public void method3() {
		System.out.print("숫자 2개 입력 : ");
		
		int a= sc.nextInt();
		int b= sc.nextInt();
		
		int start;
		int end;
		if ( a > b ) {
			end   = a;
			start = b;
		} else {
			start = a;
			end   = b;
		}
		
		for ( int i = start ; i <= end ; i++ ) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		/**
		 * 강사님 풀이 시작
		 */
		if(a < b) { // a가 작은 경우
			for(int i = a ; i <= b; i++) {
				System.out.print(i+" ");
			}
			
		}else { // b가 작거나 같은 경우
			for(int i = b ; i <= a; i++) {
				System.out.print(i+" ");
			}
		}
		
		System.out.println();
		/**
		 *  추가 변수를 이용해서 시작
		 */
		
		int star = a;
		int en   = b;
		
		if ( a > b ) { // 시작이 끝 보다 큰경우
			star = b; en = a;
		}
		
		for ( int i = star ; i <= en ; i++ ) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		/**
		 *  a에 무조건 작은값, b에는 큰값 저장하게 만들기
		 */
		if ( a> b ) {
			int temp = a; // a 값 임시보관
			a = b;
			b = temp;
		}
		
		for ( int i = a ; i <= b ; i++ ) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		/**
		 * 자바에서 제공하는 기능(메서드) 이용하기
		 */
		int min = Math.min(a,b);
		int max = Math.max(a,b);
		
		for ( int i = min ; i <= max ; i++ ) {
			System.out.print(i + " ");
		}
		
		System.out.println();
	}
	
	
	/**
	 *  1부터 100 사이의 정수중
	 *  입력받은 배수의 합과 개수 sum cout
	 */
	public void method4() {
		
		System.out.print("숫자 입력 : ");
		int num = sc.nextInt();
		String num2 ="";
		int sum = 0;
		int count = 0;
		
		for ( int i = 1 ; i <= 100 ; i++ ) {
			if( i % num == 0 ) {
				num2 = num2 + i + " ";
				sum += i;
				count ++;
			}
		}
		
		System.out.printf("입력정수 : %d\n갯수 : %d\n총합 : %d\n종류 : %s\n", num, count, sum, num2);
	}
	
	/**
	 * 구구단 n단 출력하기
	 */
	public void method5() {
		
		System.out.println("숫자 입력 : ");
		int num = sc.nextInt();
		
		System.out.println("[ " + num + "단 실행 ]");
		for ( int i = 1 ; i < 10 ; i++ ) {
			System.out.println(num + " x " + i + " = " + (num*i));
		}
		
	}
	
	/**
	 * 입력받은 단 출력하기
	 * 단, 입력받은 단이 2~9 사이 숫자가 아니면
	 * "잘못입력하셨습니다 " 출력
	 */
	public void method6() {
		System.out.println("숫자 입력 2개 : ");
		int dan = sc.nextInt();
		int num = sc.nextInt();
		
		if( dan > 9 || dan <2) {
			System.out.println("잘못 입력 하셨습니다");
			return;
		}
		
		for ( int i = 1 ; i <= num ; i++ ) {
			System.out.println(dan + " x " + i + " = " + (dan*i));
		}
		
	}
	
	/**
	 * n단출력
	 */
	public void method99() {
		
		System.out.println("숫자입력(단 단 줄)");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int num = sc.nextInt();
		
		int mindan = Math.min(a,b);
		int maxdan = Math.max(a,b);
		
		for( int dan = mindan ; dan <= maxdan ; dan++) {
			
			System.out.println("[ " + dan + "단 ]");
			
			for ( int i = 1 ; i <= num ; i++ ) {
				System.out.println(dan + " x " + i + " = " + (dan*i));
			}
			
			System.out.println(">--------<");
			
		}
	}
	
	/** while : 조건식이 true일 경우 반복수행
	 * 			break 키실 방법 넣어드려야함
	 * 
	 */
	public void method7() {
		
		int num = 0;
		while ( num <= 10 ) {
			System.out.print(num + " ");
			num++;
		}
	}
	
	/**
	 * 구구단 출력하기 ver2
	 * 입력받은 단 출력하기
	 * 단, 입력받은 단이 2~9 사이 숫자가 아니면
	 * "잘못입력하셨습니다 " 출력 후
	 * 다시 단 입력받기
	 */
	public void method8() {
		
		int dan;
		int num;
		
		while(true) { // 무한반복
			System.out.println("숫자 입력 2개 : ");
			dan = sc.nextInt();
			num = sc.nextInt();
			
			if( dan <= 9 && dan >= 2) { // 2~9사이(정상입력)
				break; // 가까운 반복문 정지
			}
			
			System.out.println("잘못 입력 하셨습니다");
		}
		
		for ( int i = 1 ; i <= num ; i++ ) {
			System.out.println(dan + " x " + i + " = " + (dan*i));
		}
		
	}
	
}

/**
 * for(초기식;조건식;증감식)
 * 	 = 지정된 횟수 만큼 반복
 *  while(조건식)
 *    = 조건식이 false가 될 때까지 반복
 *       == 몇 회인지 모르겠지만 일단 끝날 때 까지 반복
 */
