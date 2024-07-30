package pkg1.service;

import java.util.Random;

public class Service {
	
	Random random = new Random();
	
	/**
	 * 369게임
	 */
	public void test1() {
		
		int order = 78951234;
		int answer = 0;
		
		String number = order + "";
		
//		String c = number.charAt(1) + "";
		
		int length = number.length();
		
		for (int i = 0 ; i < length ; i++) {
			int n = Integer.parseInt(number.charAt(i) + "");
			if(n%3==0)answer++;
//			System.out.println(n);
		}
//		System.out.println(answer);
		System.out.println(answer);
		
	}
	
	/**
	 * 답지에서 본거
	 */
	public void test1_1() {
		
		int order = random.nextInt(100000);
		System.out.println(order);
		int answer = 0;
		
		while(order != 0) {
			
			if(order%10 == 3 || order%10 == 6 ||order%10 == 9 ) {
			answer++;
			}
			
			order/=10;
		}
		
		System.out.println(answer);
		
	}
	
	public void solution(int age) {
        String answer = "";
        String numbers = new String("");
        numbers += age;
        String[] arr = numbers.split("");
        
        for(String str : arr) {
        	int i = Integer.parseInt(str);
        	
        	switch(i) {
        	case 0 : answer += "a"; break;
        	case 1 : answer += "b"; break;
        	case 2 : answer += "c"; break;
        	case 3 : answer += "d"; break;
        	case 4 : answer += "e"; break;
        	case 5 : answer += "f"; break;
        	case 6 : answer += "g"; break;
        	case 7 : answer += "h"; break;
        	case 8 : answer += "i"; break;
        	case 9 : answer += "j"; break;
        	}
        	
        }
        System.out.println(answer);
    }
	
	/**
	 * 외과의사 머쓱이는 응급실에 온 환자의 응급도를 기준으로
	 *  진료 순서를 정하려고 합니다. 정수 배열 emergency가 
	 *  매개변수로 주어질 때 응급도가 높은 순서대로 진료 순서를 
	 *  정한 배열을 return하도록 solution 함수를 완성해주세요.
	 * @param emergency
	 * @return
	 */
	public void test2(int[] emergency) {
		int[] answer = new int[emergency.length];
        
		for (int i = 0; i<emergency.length ; i++) {
			int count = 1;
			for(int number : emergency) {
				if(emergency[i]<number) {
					count++;
				}
			}
			answer[i]=count;
		}
        
        
        
        for(int a : answer) {
        	System.out.print(a+", ");
        }
    }

	public void test3() {
		char c = '0';
		c=65;
		System.out.println(c);
	}

}
