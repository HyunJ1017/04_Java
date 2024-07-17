package array.ex;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx1 {
	
	Scanner sc = new Scanner(System.in);
	
	public void method0() {
		System.out.println("1. -array 확인");
		System.out.println("2. -array 확인2");
		System.out.println("3. -array 확인3");
		System.out.println("4. -array 확인4");
		System.out.print("숫자입력");
		int num = sc.nextInt();
		switch(num) {
		case 1 : method1();break;
		case 2 : method2();break;
		case 3 : method3();break;
		case 4 : method4();break;
		}
	}
	
	/* 배열 (자료구조)
	 * 
	 * - 같은 자료형 변수를 하나의 묶음으로 다루는 것.
	 * 		-> JS에선 변수마다 다를 수 있었음
	 * 
	 * - 생성된 배열의 요소(묶여진 배열)는
	 *   인덱스 번호로 구분된다. (0,1,2,3...)
	 *   
	 * - 생성된 배열을 활용하기 위해서는
	 * 	 배열을 참조하는 "찬조형 변수"를 이용한다.
	 * 
	 * [참조형 변수]
	 * - 값X, 주소를 저장하는 변수 ex)String
	 * 
	 * - 변수 호출 시 값 반환X
	 *   -> 저장된 주소로 찾아가
	 *   	해당 위치의 배열/객체를 참조
	 *   
	 * - 기본 자료형 8개를 제외한 나머지는 모두 참조형
	 * 	-> int[] -> 숫자배열
	 */
	
	/**
	 * 배열 선언, 할당, 초기화
	 */
	public void method1() {
		
		// 배열 선언
		int[] arr; // Stack 메모리 영역에 int[] 자료형을 참조할 변수 arr 선언
		
		// 배열 할당(생성)
		arr = new int[4];
		// heap 메모리 영역에 int4칸짜리 배열을 할당 한 후
		// 생성된 배열의 주소를 arr에 대입
		
		// arr 변수를 이용해 생성될 배열을 참조할 수 있다.
		
		// 배열을 생성 하자마자 각 칸에는 어떤 값이 저당되어 있을Rk
		// 각 자료형의 기본값이 저장됨
		
		System.out.println( arr ); // 배열의 해시코드(주소)		
		// 배열 초기화
		// -> 배열 요소에 값 대입
		System.out.println( arr[0] );		
		System.out.println( arr[1] );		
		System.out.println( arr[2] );		
		System.out.println( arr[3] );
		
		// 2) index별 값 초기화
		//  -> int 배열이니 int값만 넣을 수 있음
		arr[0] = 1000;
		arr[1] = 20;
//		arr[2] = 3.14;
		arr[2] = 3;
		arr[3] = 500;
		
		for (int i = 0 ; i < arr.length ; i++) {
			System.out.printf("arr [%d]의 값 :  %d\n", i, arr[i]);		
		}
		
		//-------------------------------------------------------------
		/* Java의 배열은 크기 조절 XXXX */
//		arr[4] = 999; 	Index 4 out of bounds for length 4 at array
		
	}
	
	/**
	 * 정수 4개를 입력 받아
	 * 배열 요소에 차례대로 대입 후
	 * 저장된 값 한번에 출력하기
	 */
	public void method2() {
		
		int[] arr = new int[4];
		
		for ( int i = 0 ; i < arr.length ; i++) {
			System.out.print(i + "번째 정수 입력 : ");
			arr[i] = sc.nextInt();
		}
		
		// java.util.Arrays 클래스 : 배열의 유용한 기능을 모아둔 클래스
		String str = Arrays.toString(arr);
		System.out.println(str);
		
		// Arrays.toString(배열명)
		
		System.out.println("<<종료>>");
		
		// debug : 프로그램 수행이 정상적으로 이루어 지지 않은 경우
		// 		   원인을 파악하기 위해 추적하는 것

		/* [이클립스 디버그 모드 사용 방법]
		 * 
		 * 1) 확인하고 싶은 코드 다음 줄에 breakpoint 추가
		 * 
		 * 2) debug 모드로 실행 (벌레 아이콘 또는 F11)
		 * 
		 * 3) debug 화면으로 switch 
		 * 
		 * 4) resume (F8 키)를 눌러가며 순서대로 확인
		 * 
		 * */
		
	}
	
	/**
	 * 배열 선언과 초기화
	 * 
	 * 	[배열 선언 + 초기화]
	 *  JS>  let arr = ["aaa", "bbb", "ccc"];
	 *  java String[] arr = {"aaa", "bbb", "ccc"};
	 *  
	 */
	public void method3() {
		
		// 과목이 작성되어 있는 배열 생성
		String[] subjects = {"HTML", "CSS", "JS", "Java"};
		
		// 배열 index 범위의 난수
		int len = (int)(Math.random() * subjects.length);
		
		System.out.printf("당신이 시험볼 과목은 %s 입니다.\n", subjects[len]);
		System.out.println(Arrays.toString(subjects));
	}
	
	/**
	 * 5칸 짜리 char 배열을 만들어
	 * 각각의 배열 요소에 입력된값을 대입하고
	 * 
	 * 입력 완료 후
	 * 저장된 값을 역순으로 출력
	 */
	public void method4() {
		
		char[] arr = new char[5];
		
		for ( int i = 0 ; i < arr.length ; i++) {
			
			System.out.print( i + "번째 요소 : ");
			
			arr[i] = sc.next().charAt(0);
				// 입력된 문자열의 0번째 문자를 반환
				// char 입력방법
		}
		
		// 마지막 index 부터 0 까지 1씩 감소
		for ( int i = arr.length - 1 ; i >= 0 ; i-- ) {
			System.out.print(arr[i] + " ");
		}
		
	}
	
}
