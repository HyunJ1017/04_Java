package array.ex;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx2 {

	Scanner  sc = new Scanner(System.in);
	
	public void method0() {
		System.out.println("1. 얕은복사 확인");
		System.out.println("2. 깊은복사 확인");
		//System.out.println("3. -array 확인3");
		//System.out.println("4. -array 확인4");
		System.out.print("숫자입력");
		int num = sc.nextInt();
		switch(num) {
		case 1 : method1();break;
		case 2 : method2();break;
		//case 3 : method3();break;
		//case 4 : method4();break;
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
}