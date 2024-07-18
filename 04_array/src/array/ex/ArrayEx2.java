package array.ex;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx2 {

	Scanner  sc = new Scanner(System.in);
	
	public void method0() {
		System.out.println("1. 얕은복사 확인");
		System.out.println("2. 깊은복사 확인");
		System.out.println("3. for문 향상 확인");
		System.out.println("4. for문 향상 확인2");
		System.out.println("5. 2차원배열 확인");
		System.out.println("99. 배열복사 확인");
		System.out.print("숫자입력");
		int num = sc.nextInt();
		switch(num) {
		case 1 : method1();break;
		case 2 : method2();break;
		case 3 : method3();break;
		case 4 : method4();break;
		case 5 : method5();break;
		case 99 : method99();break;
		}
	}
	
	
	/**
	 * 얕은 복사
	 * - 참조형 복사가 가지고 있는 주소만 복사하는것.
	 * - 서로 다른 변수가 같은 배열/ 객체를 참조하기 때문에 같은값을 공유!
	 */
	public void method1() {
		
		// 원본 배열
		int[] arr = {10, 20, 30, 40, 50};
		
		// 얕은 복사한 배열
		int[] copyArr = arr;
		
		System.out.println("[변경전]");
		System.out.println("arr     : " + Arrays.toString(arr    ) );
		System.out.println("copyArr : " + Arrays.toString(copyArr) );
		
		copyArr[3] = 4444;
		copyArr[4] = 5555;
		
		System.out.println("[변경후]");
		System.out.println("arr     : " + Arrays.toString(arr    ) );
		System.out.println("copyArr : " + Arrays.toString(copyArr) );
		// 복사한 배열을 수정햇지만 원본도 같이 수정됨
		// -> 주소만 복사한 얕은복사는 같은 배열값을 공유한다.
	
	}
	
	/**
	 * 깊은복사
	 * - 원본 배열/객체가 가지고 있는 값을 똑같이
	 *   복사한 배열/객체를 만드는 것(복제의 개념)
	 * - 새로운 배열이나 객체가 만들어지는 것으로
	 *   원본과는 독립되어 있음
	 */
	public void method2() {
		
		// 원본 배열
		int[] arr = {10, 20, 30, 40, 50};
		
		// 깊은복사 1 : for문 이용
		int[] copyArr = new int[arr.length];	//	원본 크기 새 배열 생성 {0,0,0,0,0}
		
		// 원본 배열요소의 값을 불러와 같은 인덱스의 복사할 배열요소에 대입
		for ( int i = 0 ; i < arr.length ; i++ ) {
			copyArr[i] = arr[i];
		}
		
		// 깊은복사 2 : System.arraycopy() 이용
		//		원본 배열명, 원본 복사 시작 인덱스,
		// 		복사 배열명, 복사 배열의 삽입 시작 인덱스, 
		//		복사 길이
		int[] copyArr2 = new int[arr.length];
		System.arraycopy(arr, 0, copyArr2, 0, arr.length);
		
		
		System.out.println("[변경전]");
		System.out.println("arr     : " + Arrays.toString(arr     ) );
		System.out.println("copyArr : " + Arrays.toString(copyArr ) );
		System.out.println("copyArr2: " + Arrays.toString(copyArr2) );
		
		// 원본, 복사1, 복사2의 0번 인덱스 값을 변경
		arr[0] = 11111;
		copyArr[0] = 22222;
		copyArr2[0] = 33333;
		
		System.out.println("[변경후]");
		System.out.println("arr     : " + Arrays.toString(arr     ) );
		System.out.println("copyArr : " + Arrays.toString(copyArr ) );
		System.out.println("copyArr2: " + Arrays.toString(copyArr2) );
		
	}
	
	//----------------------------------------
	/* [향상된 for문 (forEach) ]
	 * 
	 * - 0번 인덱스 부터 마지막 인덱스까지 1씩 증가하며
	 *   iterable 성격을 띄는 객체의 요소를 
	 *   하나씩 순서대로 반환하는 for문
	 * 
	 *   * iterable : 반복 가능한
	 *     ex) 배열, List, Set, Map 등
	 *     
	 *     
	 *  [작성법]
	 *  
	 *  for(배열 요소 자료형의 변수 : 배열명){
	 *  	
	 *  }
	 *  
	 *  ex)
	 *  int[] arr = new int[3];
	 *  
	 *  for(int num : arr){
	 *  	// num은 
	 *  	// for문이 반복 될 때마다
	 *  	// arr[0], arr[1], arr[2] 인덱스 값이
	 *  	// 순차 적으로 대입됨
	 *  }
	 */
	
	public void method3() {
		
		int[] arr = {10,20,30,40,50};
		
		//향상된 for문
		for (int num : arr ) {
			System.out.println(num);
		}
		//일반 for문
		System.out.println("--------");
		for (int i = 0 ; i < arr.length ; i++) {
			System.out.println(arr[i]);
		}
		
	}
	
	/**
	 * 향상된 for문을 이용한
	 * 배열 요소 순차 접근(== 반복접근)
	 */
	public void method4() {
		
		char[] arr = { 'a', 'b', 'c', '홍', '길', '동'};
		
		// 향상된 for문
		for ( char ch : arr ) {
			System.out.printf("%c의 유니코드 : %d \n", ch, (int)ch);
		}
	}
	
	/**
	 2차원 배열
	 
	 - 1차원 배열 : 변수를 묶음으로 다루는 것
	 - 2차원 배열 : 1차원 배열을 묶음으로 다루는 것
	 	-> 1차원 배열을 참조하는 참조형 변수의 묶음
	 
	 [작성법]

	 자료형[][] 배열명 = new 자료형[row크기][column크기];
	 */
	public void method5() {
		
		// 2차원 배열 선언 / 할당
		int[][] arr = new int[2][3];
		arr[0][0] = 10;
		arr[0][1] = 20;
		arr[0][2] = 30;
		
		arr[1][0] = 40;
		arr[1][1] = 50;
		arr[1][2] = 60;
		
		System.out.println(arr[0]); //I@6d03e736
		System.out.println(arr[1]); //I@568db2f2
		System.out.println(arr[0] instanceof int[]); //true
		
		System.out.println("--------");
		
		// for문으로 모든 요소 출력하기1 (일반 for문)
		// arr.length
		// - arr이 참조하고 있는 1차원 배열 참조변수의 묶음의 길이
//		for ( int row = 0 ; row < arr.length ; row++) {
//			
//			for(int col = 0; col < arr[row].length ; col++) {
//				System.out.print(arr[row][col] + " ");
//			}
//			System.out.println(" : arr[" + row + "]");
//		}
		
		System.out.println("--------");
		// for문으로 모든 요소 출력하기1 (향상 for문)
		
		for ( int[] row : arr ) { // 행을 하나씩 순차 접근
			for ( int col : row) { // 각 행의 열을 하나씩 순차접근
				System.out.print(col + " ");
			}
			System.out.println();
		}
	}
	
	public void method99() {
		int[] arr1 = {1,2,3,4};
		int[] arr2 = {5,6};
		// 깊은복사 2 : System.arraycopy() 이용
				 //		원본 배열명, 원본 복사 시작 인덱스,
				 // 		복사 배열명, 복사 배열의 삽입 시작 인덱스, 
				 //		복사 길이
		
		System.arraycopy(arr2, 0, arr1, 4, arr2.length);
		
		for (int col : arr1) {
			System.out.print(col);
		}
	}
	
}