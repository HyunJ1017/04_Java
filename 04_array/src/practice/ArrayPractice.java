package practice;

import java.util.Scanner;

public class ArrayPractice {

	Scanner sc = new Scanner(System.in);
	
	/**
	 * [실습문제1]
	 * 메소드 명 : public void practice1(){}
		길이가 9인 배열을 선언 및 할당하고, 1부터 9까지의 값을 반복문을 이용하여
		순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
		짝수 번째 인덱스 값의 합을 출력하세요. (0 번째 인덱스는 짝수로 취급)
		
		[실행 화면]
		1 2 3 4 5 6 7 8 9
		짝수 번째 인덱스 합 : 25
	 */
	public void practice1(){
		
		int[] arr = new int[9];
		
		for (int i = 0; i < arr.length ; i++) {
			arr[i] = i + 1 ;
		}
		
		int sum = 0;
		
		for ( int i = 0 ; i < arr.length ; i++ ) {
			System.out.print(arr[i] + " ");
			if ( i % 2 == 0 ) sum += arr[i];
		}
		System.out.println("\n짝수 번째 인덱스 합 : " + sum);
	}
	
	/**
	 * 메소드 명 : public void practice2(){}
		길이가 9인 배열을 선언 및 할당하고, 9부터 1까지의 값을 반복문을 이용하여
		순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
		홀수 번째 인덱스 값의 합을 출력하세요. (0 번째 인덱스는 짝수로 취급)
		
		[실행 화면]
		9 8 7 6 5 4 3 2 1
		홀수 번째 인덱스 합 : 20
	 */
	public void practice2() {
		
		int[] arr = new int[9];
		
		for ( int i = 0 ; i < arr.length ; i++ ) {
			arr[i] = arr.length - i ;
		}
		
		int sum = 0;
		
		for ( int i = 0 ; i < arr.length ; i++ ) {
			System.out.print(arr[i] + " ");
			if ( i % 2 == 1 ) sum += arr[i];
		}
		System.out.println("\n홀수 번째 인덱스 합 : " + sum);
	}
	
	/**
	 * 메소드 명 : public void practice3(){}
		사용자에게 입력 받은 양의 정수만큼 배열 크기를 할당하고
		1부터 입력 받은 값까지 배열에 초기화한 후 출력하세요.
		
		[실행 화면]
		양의 정수 : 5
		1 2 3 4 5
		
		[실행 화면]
		양의 정수 : 8
		1 2 3 4 5 6 7 8
	 */
	public void practice3() {
		System.out.print("양의 정수 : ");
		int num = sc.nextInt();
		
		int[] arr = new int[num];
		for (int i = 0 ; i < arr.length ; i++ ) {
			arr[i] = i + 1;
			System.out.print(arr[i] + " ");
		}
		
	}
	
	/**
	 * 메소드 명 : public void practice4(){}
		정수 5개를 입력 받아 배열을 초기화 하고
		검색할 정수를 하나 입력 받아 배열에서 같은 수가 있는 인덱스를 찾아 출력.
		배열에 같은 수가 없을 경우 “일치하는 값이 존재하지 않습니다“ 출력
		
		[실행 화면 1]
		입력 0 : 5
		입력 1 : 8
		입력 2 : 9
		입력 3 : 10
		입력 4 : 4
		검색할 값 : 8
		인덱스 : 1
	 */
	public void practice4() {
		
		int[] arr = new int[5];
		int i = 0;
		
		do {
			System.out.printf("입력 %d : ", i);
			arr[i] = sc.nextInt();
			i++;
		} while ( i < 5 );
		
		boolean flag = true;
		
		int count = 0;
		do {
			System.out.print("검색할 값 : ");
			int find = sc.nextInt();
			
			for (int y = 0 ; y < arr.length ; y++ ) {
				if( arr[y] == find ) count = y;
			}
			
			if (count != 0) {
				flag = false;
			} else {
				System.out.println("어게인");
			}
		} while (flag);
		
		System.out.println("인덱스 : " + count);
	}
	
	/**
	 * 메소드 명 : public void practice5(){}
		사용자가 배열의 길이를 직접 입력하여 그 값만큼 정수형 배열을 선언 및 할당하고
		배열의 크기만큼 사용자가 직접 값을 입력하여 각각의 인덱스에 값을 초기화 하세요.
		그리고 배열 전체 값을 나열하고 각 인덱스에 저장된 값들의 합을 출력하세요.
		
		[실행 화면]
		정수 : 5
		배열 0번째 인덱스에 넣을 값 : 4
		배열 1번째 인덱스에 넣을 값 : -4
		배열 2번째 인덱스에 넣을 값 : 3
		배열 3번째 인덱스에 넣을 값 : -3
		배열 4번째 인덱스에 넣을 값 : 2
		4 -4 3 -3 2
		총 합 : 2
	 */
	public void practice5(){
		
		System.out.print("정수 : ");
		int len = sc.nextInt();
		
		int[] arr = new int[len];
		int i = 0;
		
		do {
			System.out.printf("배열 %d번째 인덱스에 넣을 값 : ", i);
			arr[i] = sc.nextInt();
			i++;
		} while ( i < arr.length );
		
		int sum = 0;
		
		for ( int y = 0 ; y < arr.length ; y++ ) {
			System.out.print(arr[y] + " ");
			sum += arr[y];
		}
		
		System.out.println("\n총 합 : " + sum);
		
	}
	
	/**
	 * 메소드 명 : public void practice6(){}
		주민등록번호를 입력 받아 char 배열에 저장한 후 출력하세요.
		단, char 배열 저장 시 성별을 나타내는 숫자 이후부터 *로 저장하세요.
		
		[실행 화면]
		주민등록번호(-포함) : 123456-1234567
		123456-1******
	 */
	public void practice6(){
		System.out.print("주민등록번호(-포함) : ");
		String num = sc.next();
		
		char[] arr = new char[num.length()];
		
		for ( int i = 0 ; i < num.length() ; i++ ) {
			if ( i < 8 ) {
				arr[i] = num.charAt(i);
			} else {
				arr[i] = '*';
			}
		}
		
		for ( char r : arr ) {
			System.out.print(r);
		}
		
	}
	
	/**
	 * 메소드 명 : public void practice7(){}
		3이상인 홀수를 입력 받아 배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 값을 넣고,
		중간 이후부터 끝까지는 1씩 감소하여 내림차순으로 값을 넣어 출력하세요.
		단, 입력한 정수가 홀수가 아니거나 3 미만일 경우 “다시 입력하세요”를 출력하고
		다시 정수를 받도록 하세요.
		
		[실행 화면]
		정수 : 4
		다시 입력하세요.
		정수 : -6
		다시 입력하세요.
		정수 : 5
		1, 2, 3, 2, 1
	 */
	public void practice7(){
		
		boolean check = true;
		int num = 0;
		
		 do {
			System.out.print("정수 : ");
			num = sc.nextInt();
			
			if ( num >= 3 && num % 2 == 1 ) {
				check = false;
			} else {
				System.out.println("다시 입력하세요");
			}
		} while (check);
		
		int[] arr = new int[num];
		
		for ( int i = 0 ; i < num ; i++) {
			if ( i < num/2 ) {
				arr[i] = i+1;
			} else {
				arr[i] = num - i;
			}
		}
		
		for (int y = 0 ; y < num ; y++ ) {
			System.out.print(arr[y]);
			if ( y != num - 1 ) System.out.print(", ");
		}
		
	}
	
	/**
	 * 메소드 명 : public void practice8(){}
		10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고,
		1~10 사이의 난수를 발생시켜 배열에 초기화한 후 출력하세요.
		
		[실행 화면]
		발생한 난수 : 9 7 6 2 5 10 7 2 9 6
	 */
	public void practice8(){
		int[] arr = new int[10];
		for ( int i = 0 ; i < arr.length ; i++) {
			arr[i] = (int)(Math.random()*10) + 1;
		}
		
		String arrlist = "";
		
		for (int i = 0 ; i < arr.length ; i++ ) {
			arrlist += " " + arr[i];
		}
		
		System.out.println("발생한 난수 :" + arrlist);
		
	}
	
	/**
	 * 메소드 명 : public void practice9(){}
		10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고,
		1~10 사이의 난수를 발생시켜 배열에 초기화 후
		배열 전체 값과 그 값 중에서 최대값과 최소값을 출력하세요.
		
		[실행 화면]
		발생한 난수 : 5 3 2 7 4 8 6 10 9 10
		최대값 : 10
		최소값 : 2
	 */
	public void practice9(){
		int[] arr = new int[10];
		for ( int i = 0 ; i < arr.length ; i++) {
			arr[i] = (int)(Math.random()*10) + 1;
		}
		//발생한 난수 
		String arrlist = "";
		
		for (int i = 0 ; i < arr.length ; i++ ) {
			arrlist += " " + arr[i];
		}
		//최대값
		int max= 0;
		int a= 0;
		for (int i = 0 ; i < arr.length ; i++ ) {
			a = arr[i];
			max = Math.max(max, a);
		}
		//최소값
		int min= 100;
		int b= 100;
		for (int i = 0 ; i < arr.length ; i++ ) {
			b = arr[i];
			min = Math.min(min, b);
		}
		
		System.out.println("발생한 난수 :" + arrlist);
		System.out.println("최대값 : " + max);
		System.out.println("최솟값 : " + min);
		
	}
	
	/**
	 * 메소드 명 : public void practice10(){}
		10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고
		1~10 사이의 난수를 발생시켜 중복된 값이 없게 배열에 초기화한 후 출력하세요.
		
		[실행 화면]
		4 1 3 6 9 5 8 10 7 2
	 */
	public void practice10(){
		int[] arr = new int[10];
		for ( int i = 0 ; i < arr.length ; i++) {
			arr[i] = (int)(Math.random()*10) + 1;
			for ( int y = 0 ; y < i ; y++ ) {
				if( arr[i] == arr[y] ) {
					i--;
					break;
				}
			}
		}
		
		String arrlist = "";
		
		for (int i = 0 ; i < arr.length ; i++ ) {
			arrlist += arr[i] + " ";
		}
		
		System.out.println(arrlist);
	}
	
	/**
	 * 메소드 명 : public void practice11(){}
		로또 번호 자동 생성기 프로그램을 만들기.
		(중복 값 없이 오름차순으로 정렬하여 출력하세요.)
		
		[실행 화면]
		3 4 15 17 28 40
	 */
	public void practice11(){
		int[] arr = new int[6];
		for ( int i = 0 ; i < arr.length ; i++) {
			arr[i] = (int)(Math.random()*45) + 1;
			
			for ( int y = 0 ; y < i ; y++ ) {
				if( arr[i] == arr[y] ) {
					i--;
					break;
				}
			}
		}
		// 오름차순 정렬하기
		int temp = 0;
		for (int i = 0 ; i < arr.length ; i++) {
			
			for (int y = i+1 ; y < arr.length ; y++ ) {
				
				if (arr[i] > arr[y]) {
					temp = arr[i];
					arr[i] = arr[y];
					arr[y] = temp;
				}
			}
		}
		// 출력
		String arrlist = "";
		
		for (int i = 0 ; i < arr.length ; i++ ) {
			arrlist += arr[i] + " ";
		}
		
		System.out.println(arrlist);
	}
	
	/**
	 * 메소드 명 : public void practice12(){}
		문자열을 입력 받아 문자열에 어떤 문자가 들어갔는지 배열에 저장하고
		문자의 개수와 함께 출력하세요. (중복 제거)
		
		[실행 화면]
		문자열 : application
		문자열에 있는 문자 : a, p, l, i, c, t, o, n
		문자 개수 : 8
	 */
	public void practice12(){
		
		System.out.print("문자열 : ");
		String str = sc.next();
		
		char[] list = new char[str.length()];
		
		for ( int i = 0 ; i < str.length() ; i++ ) {
			list[i] = str.charAt(i);
		}
		
		String listPrint = "";
		for ( int i = 0 ; i < str.length() ; i++ ) {
			listPrint += list[i] + " ";
		}
		
		System.out.println("문자열에 있는 문자 : " + listPrint);
		System.out.println("문자 개수 : " + list.length);
	}
	
	/**
	 * 메소드 명 : public void practice13(){}
		사용자가 입력한 배열의 길이만큼의 String 배열을 선언 및 할당하고
		배열의 인덱스에 넣을 값 역시 사용자가 입력하여 초기화 하세요.
		단, 사용자에게 배열에 값을 더 넣을지 물어보고 몇 개를 더 입력할 건지,
		늘린 곳에 어떤 데이터를 넣을 것인지 받으세요.
		사용자가 더 이상 입력하지 않겠다고 하면 배열 전체 값을 출력하세요.
		(배열의 얕은 복사, 깊은 복사를 이용하는 문제)
	 */
	/**
	 * [실행 화면]
			배열의 크기를 입력하세요 : 3
			1번째 문자열 : 자바의 정석
			2번째 문자열 : 알고리즘
			3번째 문자열 : C프로그래밍
			더 값을 입력하시겠습니까?(Y/N) : y
			더 입력하고 싶은 개수 : 2
			4번째 문자열 : 인간관계
			5번째 문자열 : 자기계발
			더 값을 입력하시겠습니까?(Y/N) : y
			더 입력하고 싶은 개수 : 1
			6번째 문자열 : 영단어600
			더 값을 입력하시겠습니까?(Y/N) : n
			[자바의 정석, 알고리즘, C프로그래밍, 인간관계, 자기계발, 영단어600]
	 */
	public void practice13(){
		
		
		System.out.print("배열의 크기를 입력하세요 : ");
		int num = sc.nextInt();
		String[] arr = new String[num];
		
		sc.nextLine();
		for ( int i = 0 ; i < arr.length ; i++ ) {
			System.out.println(i + "번째 문자열 : ");
			arr[i] = sc.nextLine();
		}
		
		int col = num;	// 첫 배열 길이 저장
		boolean flag = true;
		
		
		/** ********************************************* */
		do {
			System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
			String answer = sc.next();
			
			char a = answer.charAt(0);
			
			if(a == 'N') {
				flag = false;
				continue;
			}
			if(a != 'Y') {
				System.out.println("다시 입력해 주세요");
				break;
			}
			
			System.out.print("더 입력하고 싶은 개수 : ");
			int num2 = sc.nextInt();				// 더하고싶은, 추가해야할 배열갯수

			String[] arr2 = new String[num + num2];	// 쌔배열
			System.arraycopy(arr, 0, arr2, 0, num); // arr2에 arr 채우기
			sc.nextLine();
			
			arr = arr2;
			for (int i = num ; i< num+num2 ; i++ ) {
				System.out.print(i + "번째 문자열 :");
				String i = sc.nextLine();
				num++;
			}
			
		} while (flag);
		/** ********************************************* */
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		// 추가입력 반복
//		boolean flag = true;
//		int num2 = 0;	// do문에서 쓸 새 배열길이
//		int count = num;	// 새 문자열 번호
//		
//		do {
//			System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
//			String answer = sc.next();
//			
//			char a = answer.charAt(0);
//			
//			if(a == 'N') {
//				flag = false;
//				continue;
//			}
//			if(a != 'Y') {
//				System.out.println("다시 입력해 주세요");
//				break;
//			}
//			
//			System.out.print("더 입력하고 싶은 개수 : ");
//			num2 = sc.nextInt();
//			
//			String[] newarr = new String[num2];
//			sc.nextLine();
//			for ( int i = 0 ; i < newarr.length ; i++ ) {
//				System.out.println(count + "번째 문자열 : ");
//				newarr[i] = sc.nextLine();
//				count++;					//문자열번호증가
//				
//			}
//			
//			
//		} while (flag);
		
	}
}
