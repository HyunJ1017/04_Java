package loop.ex;

import java.util.Scanner;

public class LoopEx2 {
	
	Scanner sc = new Scanner(System.in);
	
	public void method0() {
		System.out.println("1.  method1  실행  - 다음모양출력");
		System.out.println("2.  method2  실행  - 다음모양출력2");
		System.out.println("3.  method3  실행  - 다음모양출력3");
		System.out.println("4.  method4  실행  - 다음모양출력4");
		System.out.println("5.  method5  실행  - 다음모양출력5");
		System.out.println("6.  method6  실행  - 다음모양출력6");
		System.out.println("7.  method7  실행  - do-while");
		System.out.println("8.  method7  실행  - 모든 수의 합");
		System.out.print("실행시킬 함수 : ");
		int num = sc.nextInt();
		switch(num) {
		case 1 : method1(); break;
		case 2 : method2(); break;
		case 3 : method3(); break;
		case 4 : method4(); break;
		case 5 : method5(); break;
		case 6 : method6(); break;
		case 7 : method7(); break;
		case 8 : method8(); break;
		}
	}
	
	/**다음 모양 출력하기
	 * 1234
	 * 1234
	 * 1234
	 */
	public void method1() {
		for (int i = 1 ; i < 4 ; i++ ) {
			
			for ( int y = 1 ; y < 5 ; y++ ) {
				System.out.print(y);
			}
			
			System.out.println(); // 한 행이 끝나면 줄바꿈
		}
	}
	
	/**다음 모양 출력하기
	 * 54321
	 * 54321
	 * 54321
	 * 54321
	 */
	public void method2() {
		for (int i = 2147483645 ; i > 0 ; i++ ) {
			
			for ( int y = 5 ; y > 0 ; y-- ) {
				System.out.print(y);
			}
			
			System.out.println(); // 한 행이 끝나면 줄바꿈
		}
	}
	
	/**
	 * 행 열 정방향(0) 역방향(1)
	 * 행 입력 : 3
	 * 열 입력 : 6
	 * 정방향(1)/역방향(-1) : -1
	 * 
	 * 654321
	 * 654321
	 * 654321
	 */
	public void method3() {
		System.out.println("행 / 열 / 방향(-1or1)");
		int row = sc.nextInt();
		int col = sc.nextInt();
		int direction = sc.nextInt();
		
		System.out.println("---------------");
		for ( int i = 1 ; i <= row ; i++) {
			if( direction == 1 ) {
				for ( int y = 1 ; y <= col ; y++ ) {
					System.out.print(y);
				}
			} else {
				for ( int y = col ; y >= 1 ; y-- ) {
					System.out.print(y);
				}
			}
				System.out.println(); 
		}
		System.out.println("---------------");
		int way = direction;
		if (direction != 1) way = 0;
		
		switch(way) {
		case 1 :
			for ( int i = 1 ; i <= row ; i++) {
				for ( int y = 1 ; y <= col ; y++ ) {
						System.out.print(y);
				}
				System.out.println();
			};
			break;
		case 0  :
			for ( int i = 1 ; i <= row ; i++) {
				for ( int y = col ; y >= 1 ; y-- ) {
						System.out.print(y);
				}
				System.out.println();
			};
			break;
		}
		System.out.println("---------------");
		for ( int i = 0 ; i < row ; i++) {
			for (int y = 0 ; y < col ; y++ ) {
				if(direction ==1) {
					System.out.print(y + 1);
				}else {
					System.out.print(col - y);
				}
			}
			System.out.println();
		}
		System.out.println("---------------");
		/**
		 * 강사님 풀이방법
		 */

		// 정방향 초기화
		int start = 1;
		int end = col;
		
		if(direction == -1) { // 역방향
			start = col;
			end = 1;
		}
		
		for(int x = 1 ; x <= row ; x++) {
			
			// direction으로 열 값을 조정
			for(int y = start ;  ; y += direction) { 
				if(direction == 1 && y <= end) {
					System.out.print(y);
					continue;
				}
				
				if(direction == -1 && y >= end) {
					System.out.print(y);
					continue;
				}
				
				break;
			}
			
			System.out.println(); // 줄바꿈
		}
		System.out.println("---------------");
		
		
	}
	
	/** 다음 모양 출력 하기
	 * 
	 * (0,0) (0,1) (0,2)
	 * (1,0) (1,1) (1,2)
	 * (2,0) (2,1) (2,2)
	 */
	public void method4() {
		System.out.println("행 / 열");
		int row = sc.nextInt();
		int col = sc.nextInt();
		
		for ( int i = 0 ; i < row ; i++ ) {
			for ( int y = 0 ; y < col ; y++ ) {
				System.out.printf("(%d,%d) ", i, y);
			}
			System.out.println();
		}
	}
	
	/** 다음 모양 출력 하기
	 * 
	 * (0,0) 
	 * (1,0) (1,1) 
	 * (2,0) (2,1) (2,2)
	 */	
	public void method5() {
		System.out.print("숫자입력 : ");
		int row = sc.nextInt();
		
		for ( int i = 1 ; i <= row ; i++ ) {
			for ( int y = 1 ; y < row ; y++ ) {
				System.out.print("      ");
			}
			for ( int y = 0 ; y < i ; y++ ) {
				System.out.printf("(%d,%d) ", i, y);
			}
			System.out.println();
		}
	}

	/** 다음 모양 출력 하기
	 * 
	 * (0,0) (0,1) (0,2)
	 * (1,0) (1,1) 
	 * (2,0) 
	 */	
	public void method6() {
		System.out.print("숫자입력 : ");
		int row = sc.nextInt();
		
		for ( int i = 0 ; i < row ; i++ ) {
			for ( int y = 0 ; y < row - i ; y++ ) {
				System.out.printf("(%d,%d) ", i, y);
			}
			System.out.println();
		}
	}
	
	
	/** [do ~ while]
	 * - 최소 1회 이상 반복하는 while문
	 */
	public void method7() {
		
		int num = 10;
		int count = 1;
		
		do {
			System.out.println("반복출력구문" + count);
			count++;
			num++;
		} while( num < 10 );
		
		System.out.println("complete");
		
	}
	
	/**
	 * 0이 입력 될 때까지 누적
	 */
	public void method8() {
		
		int input = 0;
		int sum = 0;
		
		do {
			System.out.println("숫자 입력 : ");
			input = sc.nextInt();
			sum += input;
		} while(input != 0);
		
		System.out.println("SUM : " + sum);
	}

}
