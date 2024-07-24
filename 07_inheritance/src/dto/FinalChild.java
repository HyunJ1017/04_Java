package dto;

// final class 상속 불가 확인
public class FinalChild /*extends FinalParent*/
	extends Parent/*, Child1*/ {
	
	//The type FinalChild cannot subclass the final class FinalParent
	// 다중상속 안됨
}
