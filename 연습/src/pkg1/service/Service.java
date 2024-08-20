package pkg1.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
	
	
	/**
	 * 
	 */
	public String solution(String letter) {
        String answer = "";
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",
                ".---","-.-",".-..","--","-.","---",".--.","--.-",
                ".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

		String[] strArr = letter.split(" ");
		
		for(int i=0; i< strArr.length ; i++){
		  
		  for(int y=0; y<26;y++){
		      if(morse[y].equals( strArr[i]) ) 
		      {answer += (char)(y+97);
		          break;}
		  }
		}
        
        return answer;
    }
	
	/** 글자지우기
	 */
	public String solution(String my_string, String letter) {
        String answer = "";
        my_string = "abcdef";
        letter ="f";
        
//        String[] strarr = my_string.split("");
//        for(String str : strarr) {
//        	if(!str.equals(letter))answer+=str; 
//        }
        
        answer = my_string.replace(letter, "");
        //letter 를  "" 으로 바꿈
        
        
        return answer;
    }
	
	/** 배열 뒤집기
	 */
	public int[] solution(int[] num_list) {
        int[] answer = {};
        
//        int[] num_list = {1, 2, 3, 4, 5};
        
        
        int length = num_list.length;
        for(int i=0;i<length;i++) {
        	answer[i] = num_list[length-1-i] ;
        }
        
        
        return answer;
    }
	
	/**문자열 배열 strlist가 매개변수로 주어집니다.
	 *  strlist 각 원소의 길이를 담은 배열을 retrun하도록 solution 함수를 완성해주세요.
	 */
	public int[] solution(String[] strlist) {
	        
        int l = strlist.length;
        int[] answer = new int[l];
        for(int i=0; i<l ; i++){
            answer[i]=strlist[i].length();
        }
	        
	        return answer;
	    }
	
	/**정수 배열 numbers가 매개변수로 주어집니다.
	 *  numbers의 원소 중 두 개를 곱해 만들 수 있는
	 *   최댓값을 return하도록 solution 함수를 완성해주세요.
	 */
	class Solution {
	    public int solution(int[] numbers) {
	        int answer = 0;
	        int min = 0;
	        int l = numbers.length;
	        for(int i=0; i<l ; i++) {
	        	for(int y=0; y<l ; y++) {
		        	if(i!=y) {
		        		min =numbers[i] * numbers[y];
		        		if( min > answer) answer = min;
		        		
		        	}else continue;
		        }
	        }
	        
	        
	        return answer;
	    }
	}
	
	/**어떤 자연수를 제곱했을 때 나오는 정수를 제곱수라고 합니다.
	 *  정수 n이 매개변수로 주어질 때,
	 *   n이 제곱수라면 1을 아니라면 2를 return하도록 solution 함수를 완성해주세요.
	 *   ex) n=144 return=1
	 *   
	 *   제곱수 구하는 메서드
	 */
	public int solution2(int n) {
        int answer = 1;
        
        double r = Math.sqrt(n);
        if(r%1!=0) {
        	answer=2;
        }
        
        return answer;
    }
	
	/** 배열 회전시키기2
	 * 정수가 담긴 배열 numbers와 문자열 direction가 매개변수로 주어집니다.
	 *  배열 numbers의 원소를 direction방향으로 한 칸씩 회전시킨
	 *   배열을 return하도록 solution 함수를 완성해주세요.
	 *   3 ≤ numbers의 길이 ≤ 20
	 * direction은 "left" 와 "right" 둘 중 하나입니다.
	 */
	public int[] solution(int[] numbers, String direction) {
		int l =numbers.length;
        int[] answer = new int[l];
        
        if(direction.equals("left")) {
        	int a = numbers[0];
        	
        	for(int i=0; i<l-1 ; i++ ) {
        		answer[i]= numbers[i+1];
        	}
        	answer[l-1] = a;
        	
        } else {
        	
        	answer[0] = numbers[l-1];
        	
        	for(int i=1; i<l ; i++ ) {
        		answer[i]= numbers[i-1];
        	}
        }
        
        return answer;
    }
	
	/**
	 * 정수 n이 매개변수로 주어질 때,
	 *  n의 약수를 오름차순으로 담은 배열을
	 *   return하도록 solution 함수를 완성해주세요.
	 */
	public int[] solution3(int n) {
        
        int index = 1;
        for(int i=1 ; i<n ; i++) {
        	if(n%i==0) {
        		index++;
        	}
        }
        
        int[] answer =new int[index];
        
        index=0;
        for(int i=1 ; i<=n ; i++) {
        	if(n%i==0) {
        		answer[index]=i;
        		index++;
        	}
        }
        
        
        return answer;
    }
	
	
	public int solution(int num, int k) {
        int answer = 0;
        
        String str = num+"";
        String str2 = k+"";
        for(int i=0; i<str.length(); i++){
            if((str.charAt(i)+"").equals(str2)) return answer;
            answer++;
        }
        return answer=-1;
    }
	
	/**
	 * 영어 대소문자로 이루어진 문자열 my_string이 매개변수로 주어질 때,
	 * my_string을 모두 소문자로 바꾸고 알파벳 순서대로 정렬한 문자열을
	 * return 하도록 solution 함수를 완성해보세요.
	 */
	public String solution1(String my_string) {
		my_string = "heLLo";
        String answer = "";
        
        answer=my_string.toLowerCase();
        
        return answer;
    }
	
	/**
	 * 영어 대소문자로 이루어진 문자열 my_string이 매개변수로 주어질 때,
	 * my_string을 모두 소문자로 바꾸고 알파벳 순서대로 정렬한 문자열을
	 * return 하도록 solution 함수를 완성해보세요.
	 */
	public String solution2(String my_string) {
        String answer = "";
        int l = my_string.length();
        
        String[] str = my_string.toLowerCase().split("");
        for(int i=0; i<l-1; i++){
            for(int y=i+1; y<l; y++){
                if((char)str[i].charAt(0) >= (char)str[y].charAt(0)){
                    String a = str[i];
                    str[i] = str[y];
                    str[y] = a;
                }
            }
        }
        for(String a : str){
            answer += a;
        }
        return answer;
    }
	
	/**약수의 개수가 세 개 이상인 수를 합성수라고 합니다.
	 * 자연수 n이 매개변수로 주어질 때 n이하의 합성수의
	 * 개수를 return하도록 solution 함수를 완성해주세요.
	 */
	public int solution1(int n) {
        int answer = 0;
        return answer;
    }
	
	/**정수 배열 num_list와 정수 n이 매개변수로 주어집니다.
	 *  num_list를 다음 설명과 같이 2차원 배열로 바꿔
	 *  return하도록 solution 함수를 완성해주세요.
	 *  
	 *  num_list가 [1, 2, 3, 4, 5, 6, 7, 8] 로 길이가 8이고
	 *  n이 2이므로 num_list를 2 * 4 배열로 다음과 같이 변경합니다.
	 *  2차원으로 바꿀 때에는 num_list의 원소들을 앞에서부터 n개씩
	 *  나눠 2차원 배열로 변경합니다.
	 * 
	 */
	public int[][] solution(int[] num_list, int n) {
        
        int m = num_list.length/n;
        int[][] answer = new int[m][n];
        int index = 0;
        for(int x=0; x<m; x++){
            for(int y=0; y<n; y++){
                answer[x][y]=num_list[index];
                index++;
            }
        }
        
        return answer;
    }
	
	
	/**문자열 my_string이 매개변수로 주어집니다. 
	 * my_string은 소문자, 대문자, 자연수로만 구성되어있습니다. 
	 * my_string안의 자연수들의 합을 return하도록 solution 함수를 완성해주세요.
	 * "aAb1B2cC34oOp"	== 37
	 * "1a2b3c4d123Z"	== 133
	 */
	public void solution34(String my_string) {
		my_string = "aaa111";
        int answer = 0;
        
        my_string += "A";	// 끝이 자연수면 마지막 숫자가 삽입 안됨
        char[] str = my_string.toCharArray();
        
        int index = 0;
        StringBuilder numbers= new StringBuilder();
        
        while(index<str.length) {
        	int num = (int)str[index] - 48;
        	
            if(num < 10 && num >= 0){
                // 숫자인경우
                numbers.append(num+"");
            }else{
                // 숫자가 아닌경우
            	if(numbers.length() != 0) answer += Integer.parseInt(numbers.toString());
                numbers = new StringBuilder();
            }
            index++;
        }
        
        
        System.out.println(answer+"");
    }
	
	
	/**문자열 before와 after가 매개변수로 주어질 때, 
	 * before의 순서를 바꾸어 after를 만들 수 있으면 1을, 
	 * 만들 수 없으면 0을 return 하도록 solution 함수를 완성해보세요.
	 * before="olleh"; after="hello";	answer=1; "olleh"의 순서를 바꾸면 "hello"를 만들 수 있습니다.
	 * before="allpe"; after="apple";	answer=0; "allpe"의 순서를 바꿔도 "apple"을 만들 수 없습니다.
	 */
	public int solution35(String before, String after) {
		before="allpe"; after="apple";
        int answer = 1;
        
        char[] before2 = before.toCharArray();
        char[] after2 = after.toCharArray();
        
        Arrays.sort(before2);
        Arrays.sort(after2);
        
        for (int index=0; index<before.length(); index++) {
        	if((before2[index]+"").equals(after2[index]+"") ) {
        		answer = 0;
        	}
        }
        
        return answer;
    }

}
