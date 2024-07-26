package practice.service;

import practice.dto.PracticeDTO1;
import practice.dto.Target1;

public class PracticeService {


	
	
	/**
	 * 늑대 > 돼지 때릴때
	 * 지푸라기집 > 나무집> 별돌집 만큼
	 * 크기로 score 감소
	 * 지푸라기집 : point * 4
	 * 나무집 : point * 2
	 * 벽돌집 : point / 50
	 * 지푸라기집 : point * 4
	 * @param target1
	 * @param otherTarget
	 */
	public int targeting(Target1 target1, Target1 otherTarget) {

		int damage = 0;
		
		if (target1.getCaseof().equals("나쁜늑대")) {
			
			if(otherTarget.getCaseof().equals("지푸라기집")) {
				damage = target1.getPoint() * 4;
			}
			
			else if(otherTarget.getCaseof().equals("나무집")) {
				damage = target1.getPoint() * 2;
			}
			
			else if(otherTarget.getCaseof().equals("벽돌집")) {
				damage = target1.getPoint() / 50;
			} else {
				damage = target1.getPoint();
			}
			
		} else {
			damage = target1.getPoint() * 10;
		}
		
		
		String A = target1.getName();
		String B = otherTarget.getName();
		
		
		int before = otherTarget.getScore();
		
		
		if(before - damage < PracticeDTO1.min_score) {
			otherTarget.setScore( PracticeDTO1.min_score );
		}else {
			otherTarget.setScore(before - damage);
		}
		
		int after = otherTarget.getScore();
		
		System.out.printf("때린친구 : %s /맞은친구 %s\n %s의 집이 [%d]에서 [%d]까지 줄었습니다.\n", A, B, B, before, after);
		
		if(after == 0) {
			System.out.printf("\n맞은친구 %s가 죽었습니다\n ** GAMEOVER **", B);
			return 0;
		} return 1;
		
	}
	
	
	/**
	 * 밥주기
	 * @param pigA
	 */
	public void peedback(Target1 pigA) {
		pigA.setScore(pigA.getScore()+100);
		System.out.println(pigA.getName() + "의 집 : " + pigA.getScore());
	}
	
	
	
	
	
	/**
	 * str이 숫자로 된 문자열인지 확인 후 true/false 반환
	 * @param str
	 * @return true : 숫자o /false : 숫자x
	 */
	public boolean inNaN(String str) {
		
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
		
	}







}
