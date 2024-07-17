package condition.ex;

import java.util.Scanner;

/**
 * 조건문 예시 기능용 클래스
 */
public class ConditionEx {
	
	// 필드변수 == 멤버변수 == 인스턴스변수 ( 전역 변수 비슷)
	Scanner sc = new Scanner(System.in);
	
	/**
	 * 1~10 사이의 난수
	 * 홀짝 판별
	 */
	public void method1() {
		
		int ran = (int) (Math.random() * 10 + 1 );
		
		if( ran % 2 != 1 ) {
			System.out.println("짝수 입니다.");
		} else {
			System.out.println("홀수 입니다.");
		}
		
	}
	
	/**
	 * 나이를 입력받아
	 * 13세 이하 어린이
	 * 14세 이상 19세 이하 : 청소년
	 * 20세 이상 성인
	 * 
	 * 구분하여 출력하기
	 */
	public void method2() {
		
		System.out.println("나이 입력 : ");
		int age = sc.nextInt();
		
		String result;							//The local variable result may not have been initialized
		if (age <= 13) {
			
			result = "어린이";
		} else if ( age >= 20 ) {
			
			result = "성인";
		} else {
			
			result = "청소년";
		}
		
		System.out.println(result);
		
	}
	
	
	/**
	 * 나이를 입력받아
	 * 13세 이하 어린이
	 * 14세 이상 19세 이하 : 청소년
	 * - 14~16 청소년(중)
	 * - 17~19 청소년(고)
	 * 20세 이상 성인
	 * 
	 * 0이하, 100초과 : 잘못 입력하셨습니다.
	 * 
	 * 구분하여 출력하기
	 * 
	 */
	public void method3() {
		
		System.out.println("나이를 입력해 주세요");
		int age = sc.nextInt();
		String result;
		
		switch(age) {
		
		case 1  :
		case 2  :
		case 3  :
		case 4  :
		case 5  :
		case 6  :
		case 7  :
		case 8  :
		case 9  :
		case 10 :
		case 11 :
		case 12 :
		case 13 : result = "어린이"; break;
		case 14 :
		case 15 :
		case 16 : result = "청소년(중)"; break;
		case 17 :
		case 18 :
		case 19 : result = "청소년(고)"; break;
		case 20 :
		case 21 :
		case 22 :
		case 23 :
		case 24 :
		case 25 :
		case 26 :
		case 27 :
		case 28 :
		case 29 :
		case 30 :
		case 31 :
		case 32 :
		case 33 :
		case 34 :
		case 35 :
		case 36 :
		case 37 :
		case 38 :
		case 39 :
		case 40 :
		case 41 :
		case 42 :
		case 43 :
		case 44 :
		case 45 :
		case 46 :
		case 47 :
		case 48 :
		case 49 :
		case 50 :
		case 51 :
		case 52 :
		case 53 :
		case 54 :
		case 55 :
		case 56 :
		case 57 :
		case 58 :
		case 59 :
		case 60 :
		case 61 :
		case 62 :
		case 63 :
		case 64 :
		case 65 :
		case 66 :
		case 67 :
		case 68 :
		case 69 :
		case 70 :
		case 71 :
		case 72 :
		case 73 :
		case 74 :
		case 75 :
		case 76 :
		case 77 :
		case 78 :
		case 79 :
		case 80 :
		case 81 :
		case 82 :
		case 83 :
		case 84 :
		case 85 :
		case 86 :
		case 87 :
		case 88 :
		case 89 :
		case 90 :
		case 91 :
		case 92 :
		case 93 :
		case 94 :
		case 95 :
		case 96 :
		case 97 :
		case 98 :
		case 99 :
		case 100: result = "성인"; break;
		default : result = "잘못 입력 하셨습니다."; break;
		}
		
		System.out.println(result);
	}
	
	
	/**[switch 를 이용한 메서드 호출]
	 * 
	 */
	public void displayMenu() {
		
		System.out.println("1. method1() - 난수 홀짝");
		System.out.println("2. method2() - 나이구분1");
		System.out.println("3. method3() - 나이구분2");
		System.out.println("4. method4() - 계절 찾기");
		System.out.println("5. method5() - 성적판별기");
		System.out.println("6. method6() - 성적계산기2");
		System.out.println("99. method99() - 약수 계산기");
		
		System.out.print("번호 선택 >> ");
		int num = sc.nextInt();
		
		System.out.println("-----------------------------------");
		
		switch(num) {
		
		case 1: method1(); break;	// 1 입력시 method1() 호출
		case 2: method2(); break;
		case 3: method3(); break;
		case 4: method4(); break;
		case 5: method5(); break;
		case 99: method99(); break;
		case 6: practice(); break;
		default : System.out.println("1~3사이의 숫자를 입력해 주세요."); break;
		
		}
		
		
	}
	
	/**[switch]
	 * 입력된 월의 계절 출력하기
	 */
	public void method4() {
		
		System.out.print("달을 입력하세요.");
		int month = sc.nextInt();
		
		String result;
		switch(month) {
		
		// 1) 세로쭉
		case 3  :
		case 4  :
		case 5  : result = "봄"; break;
		
		// 2) 가로쭉
		case 6 : case 7 : case 8 : result = "여름"; break;
		// 3) ,쭉
		case 9, 10, 11 : result = "가을"; break;
		
		case 12 :
		case 1  :
		case 2  : result = "겨울"; break;
		
		default : result = "잘못입력";
		
		}
		
		System.out.println(result);
		
	}
	
	
	/**
	 * [성적을 판별해 보자]
	 * 중간고사, 기말고사, 과제점수를 입력받아
	 * 중간고사 40%
	 * 기말고사 50%
	 * 과제 10%
	 * 입력시 각각 100점만점을 기준으로 입력받음
	 * 
	 * 합산된 점수에 따라 성적을 부여 할건데
	 * 95점 이상 A+
	 * 90점 이상 A
	 * 85점 이상 B+
	 * 80점 이상 B
	 * 75점 이상 C+
	 * 70점 이상 C
	 * 65점 이상 D+
	 * 60점 이상 D
	 * 나머지	 F
	 * [실행화면]
	 * 이름 : 홍길동
	 * 중간고사 점수(40%) : 100
	 * 기말고사 점수(50%) : 80
	 * 과제점수(10%) : 50
	 * 
	 * 최종점수 : 85점
	 * 성적 : B+
	 */
	public void method5() {
		
		System.out.print("이름 : ");
		sc.nextLine();
		String name = sc.nextLine();
		
		System.out.print("중간고사 점수(40%) : ");
		double midEx = sc.nextInt();
		
		System.out.print("기말고사 점수(50%) : ");
		double finalEx = sc.nextInt();
		
		System.out.print("과제 점수(10%) : ");
		double task = sc.nextInt();
		
		int score = (int)((midEx*4 + finalEx*5 + task)/10);
		System.out.println("최종점수 : " + score);
		
		String result;
		
		switch(score) {
		
		case 1  :
		case 2  :
		case 3  :
		case 4  :
		case 5  :
		case 6  :
		case 7  :
		case 8  :
		case 9  :
		case 10 :
		case 11 :
		case 12 :
		case 13 :
		case 14 :
		case 15 :
		case 16 :
		case 17 :
		case 18 :
		case 19 :
		case 20 :
		case 21 :
		case 22 :
		case 23 :
		case 24 :
		case 25 :
		case 26 :
		case 27 :
		case 28 :
		case 29 :
		case 30 :
		case 31 :
		case 32 :
		case 33 :
		case 34 :
		case 35 :
		case 36 :
		case 37 :
		case 38 :
		case 39 :
		case 40 :
		case 41 :
		case 42 :
		case 43 :
		case 44 :
		case 45 :
		case 46 :
		case 47 :
		case 48 :
		case 49 :
		case 50 :
		case 51 :
		case 52 :
		case 53 :
		case 54 :
		case 55 :
		case 56 :
		case 57 :
		case 58 :
		case 59 : result = "F"; break;
		case 60 :
		case 61 :
		case 62 :
		case 63 :
		case 64 : result = "D"; break;
		case 65 :
		case 66 :
		case 67 :
		case 68 :
		case 69 : result = "D+"; break;
		case 70 :
		case 71 :
		case 72 :
		case 73 :
		case 74 : result = "C"; break;
		case 75 :
		case 76 :
		case 77 :
		case 78 :
		case 79 : result = "C+"; break;
		case 80 :
		case 81 :
		case 82 :
		case 83 :
		case 84 : result = "B"; break;
		case 85 :
		case 86 :
		case 87 :
		case 88 :
		case 89 : result = "B+"; break;
		case 90 :
		case 91 :
		case 92 :
		case 93 :
		case 94 : result = "A"; break;
		case 95 :
		case 96 :
		case 97 :
		case 98 :
		case 99 :
		case 100:  result = "A+"; break;
		default :  result = "100점씩만 넣으세요 -_-";
		
		}
		
		/* 옳게 된 switch문
		switch( (int)sum/5 ) {
		case 20, 19 : result = "A+"; break;
		case 18 : result = "A" ;  break;
		case 17 : result = "B+"; break;
		case 16 : result = "B" ;  break;
		case 15 : result = "C+"; break;
		case 14 : result = "C" ;  break;
		case 13 : result = "D+"; break;
		case 12 : result = "D" ;  break;
		default : result = "F" ;
		}
		*/
		
		System.out.println("성적 : " + result);
		
		System.out.println("-----------------------------------");
		
		double newScore =  midEx*0.4 + finalEx/2 + task/10;
		
		String result2;
		
		if(newScore < 60) {
			result2 = "F";
		}else if(newScore < 70 ) {
			result2 = (newScore - 60 >= 5 ? "D+" : "D" );
		}else if(newScore < 80 ) {
			result2 = (newScore - 70 >= 5 ? "C+" : "C" );
		}else if(newScore < 90 ) {
			result2 = (newScore - 80 >= 5 ? "B+" : "B" );
		}else if(newScore <= 100 ) {
			result2 = (newScore - 90 >= 5 ? "A+" : "A" );
		}else result2="잘모씀";
		
		System.out.printf("double로 계산한 점수 %.1f\n학점 %s \n", newScore, result2);
		
		System.out.println("-----------------------------------");
		
		String result3;
		result3 = (midEx*0.4 + finalEx/2 + task/10) < 60 ? "F" : (
				(midEx*0.4 + finalEx/2 + task/10) < 65 ? "D" : (
						(midEx*0.4 + finalEx/2 + task/10) < 70 ? "D+" : (
								(midEx*0.4 + finalEx/2 + task/10) < 75 ? "C" :(
										(midEx*0.4 + finalEx/2 + task/10) < 80 ? "C+" : (
												(midEx*0.4 + finalEx/2 + task/10) < 85 ? "B" : (
														(midEx*0.4 + finalEx/2 + task/10) < 90 ? "B+" : (
																(midEx*0.4 + finalEx/2 + task/10) < 95 ? "A" :"A+" )))))));
		System.out.println("점수 : " + (midEx*0.4 + finalEx/2 + task/10) + " 학점 : " + result3);
		System.out.println("-----------------------------------");
		System.out.println(name + "이는 배가고파요");
		
		/* 제일 잛아보이는거
		if(sum >= 90) result = "A" + ( sum>=95 ? "+" : "" );
		else if(sum >= 80) result = "B" + ( sum>=85 ? "+" : "" );
		else if(sum >= 70) result = "C" + ( sum>=75 ? "+" : "" );
		else if(sum >= 60) result = "D" + ( sum>=65 ? "+" : "" );
		else  result = "F";
		 */
		
		/* 다른방법
		switch( (int)sum/10 ) {
		case 10, 9 : result = "A"; break;
		case 8 : result = "B"; break;
		case 7 : result = "C"; break;
		case 6 : result = "D"; break;
		default : result = "F";
		}
		
		if(sum > 60 && sum % 10 >= 5)  result += "+"; 
		 * */
	}
	
	
	/**
	 * 약수 구하기
	 */
	public void method99() {
		
		System.out.println("숫자를 입력해 주세요 : ");
		int num = sc.nextInt();
		int count = 0;
		String result = "";
		
		for ( int i = 1 ; i <= num ; i++ ) {
			if ( num % i == 0 ) {
				result += " " + i;
				count++;
			}
		}
		
		System.out.println(num + "의 약수는 총 " + count + "개, " + result + " 입니다.");
		
	}
	

	/** [연습 문제]
	 * 국어, 영어, 수학, 사탐, 과탐 점수를 입력 받아
	 * 40점 미만 과목이 있으면 FAIL
	 * 평균이 60점 미만인 경우도 FAIL
	 * 모든 과목 40점 이상, 평균 60점 이상인 경우 PASS
	 * 
	 * [출력 예시]
	 * 점수 입력(국 영 수 사 과) : 100 50 60 70 80
	 * 
	 * 
	 * 1) 40점 미만 과목이 존재하는 경우
	 * FAIL [40점 미만 과목 : 국어 영어]
	 * 
	 * 
	 * 2) 평균 60점 미만인 경우
	 * FAIL [점수 : 50.4 (평균 미달)]
	 * 
	 * 
	 * 3) PASS인 경우
	 * PASS [점수 : 83.4 / 100]
	 */
	public void practice() {
		System.out.print("점수 입력(국 영 수 사 과) : ");
		
		int kor = sc.nextInt(); // 국 nextInt()는 
		int eng = sc.nextInt(); // 영 단어 사이에 스페이스 입력하면은
		int mat = sc.nextInt(); // 수 엔터처럼 다음 입력사항으로
		int soc = sc.nextInt(); // 사 인식해서 처리 해줌
 		int sci = sc.nextInt(); // 과
 		
// 		System.out.println(kor);
// 		System.out.println(eng);
// 		System.out.println(mat);
// 		System.out.println(soc);
// 		System.out.println(sci);
 		
 		String stupid = "";
 		
 		
 		if ( kor < 40 ) stupid += "국어";
 		if ( eng < 40 ) stupid += "영어";
 		if ( mat < 40 ) stupid += "수학";
 		if ( soc < 40 ) stupid += "사회";
 		if ( sci < 40 ) stupid += "과학";
 		
//		강사님풀이
// 		boolean flag = false;
// 		String str = "";
// 		
// 		if ( kor < 40 ){ flag = true; str+= "국어 ";}
// 		if ( eng < 40 ){ flag = true; str+= "영어 ";}
// 		if ( mat < 40 ){ flag = true; str+= "수학 ";}
// 		if ( soc < 40 ){ flag = true; str+= "사회 ";}
// 		if ( sci < 40 ){ flag = true; str+= "과학 ";}
// 		
// 		if (flag) {	// flag가 논리형 변수, 'flag' == 'flag==true'
// 					// flag가 한번만 true여도 if문 실행
// 					// String변수 == "값" 이러면 별로임
// 			System.out.printf("FAIL  [40점 미만 과목 : %s]", str);
// 			return;
// 		}`
 		
 		// 평균값을 double로 계산하기 위해 (double) 강제형변환 하거나
 		// 5를 5.0으로 double로 계산해주면 자동형변환으로 double로 계산된 값이 나옴
 		double average = (kor + eng + mat + soc + sci) / 5.0;
 		
 		if( stupid != "" ) 
 			System.out.println("FAIL [40점 미만 과목 : " + stupid + "]");
 		
 		
 		// average = double, 60 = int
 		// 60 -> 60.0 해주면 60을 60.0으로 자동형변환 해주는 연산시간 줄일 수 있음
 		if(average >= 60) {
 			System.out.print("PASS [점수 : " + average + " / 100]");
		} else {
			System.out.print("FAIL [점수 : " + average + " (평균 미달)]");
		}
 		
	}
	
}
