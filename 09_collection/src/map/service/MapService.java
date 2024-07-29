package map.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapService {
	
	/* Map : 특정 키워드(Key)를 입력하면
	 *       해당되는 상세한 값(Value)를 얻을 수 있는 컬렉션 객체
	 * 
	 * - K:V 형식으로 구성
	 * 
	 * - K:V 한 쌍을 "Entry" 라고 부름
	 * 
	 * - Key : 키워드 역할(== 변수명)
	 * 1) 중복 X
	 *  -> 중복되는 Key 입력 시 Value를 덮어씌움
	 *  -> Key 역할의 객체는 hashCode(), equals() 오버라이딩 필수!
	 *  
	 * 2) 순서 유지 X (단, LinkedHashMap 제외)
	 * 
	 * * Key만 묶어서 보면 Set과 같은 특징을 지니고 있음!
	 *  -> Map.keySet() / Map.EntrySet() 제공
	 * 
	 * 
	 * Value : 키워드에 해당하는 상세한 값
	 * 
	 * - Key로 인해서 모든 Value가 구분됨
	 *  -> Map.get(Key) / Map.remove(Key) 형태로 사용
	 * 
	 */
	
	public void test1() {
		
		// HashMap : 대표적인 Map 상속 객체
		// - Hash단어가 붙으면 빠름
		// -> 대신 key 역할의 객체가
		//	  equals(), hashCode() 오버라이딩 필수!!
		
//			K	:	V
		Map<String, String> map = new HashMap<String, String>();
		
		
		// 1. V put( K k, V v ) : Map에 K:V 한 쌍을 추가
		// - 추가 성공시 Value가 반환됨
		// - 중복되는 키가 없으면 null
		// - 중복되는 키가 있으면 이전 value 반환
		
		System.out.println( map.put("아침", "참치 김밥") );	//null
		System.out.println( map.put("점심", "돈까스")    );	//null
		System.out.println( map.put("저녁", "삼겹살")    );	//null
		System.out.println( map.put("저녁", "소고기")    );	//삼겹살
		// key 중복: 이전 value를 내보내고 새 value로 대체
		
		System.out.println( map.toString()               );
		
		
		System.out.println("--------------------------");
		
		// 2. V get (K k ) : 해당 key에 대응되는 value를 반환
		// 단, 일치하는 키가 없으면 null 반환
		System.out.println(map.get("아침"));	// 참치김밥
		System.out.println(map.get("점심"));	//	돈까스
		System.out.println(map.get("저녁"));	// 소고기
		System.out.println(map.get("야식"));	// null
		
		// 3. int size() : map에 저장된 K:V 쌍의 개수를 반환
		System.out.println("size() : " + map.size() );
		
		System.out.println("--------------------------");
		// 4. V remove(K k) : 
		// map에서 KEY가 일치한ㄴ 쌍을 제거
		// 일치하면 key가 존재하면 Value 반환
		// 존재하지 않으면 null 반환
		System.out.println("아침제거 : " + map.remove("아침"));	//참치 김밥
		System.out.println("점심제거 : " + map.remove("점심"));	//돈까스
		System.out.println("야삭제거 : " + map.remove("야식"));	//null
		
		System.out.println(map); 	// 남은거 확인
		
		
	}
	
	
	/**
	 * Map에 저장된 모든요소 순차접근하기
	 */
	public void test2() {
		
		// K 는 String -> 문자열만 작성
		// V 는 Object -> 어떤 자료형이든 가능 
		Map<String, Object> student = new HashMap<String, Object>();
		
		// Map을 유사 DTO처럼 사용
		student.put("name", "홍길동");
		student.put("grade", 3);
		student.put("gender	", '남');
		student.put("avg", 50.4);
		
		/* 1. Map.KeySet() 이용*/
		Set<String> keys = student.keySet();
		System.out.println(keys);
		
		
		// 모아둔 key 집합에서 key 하나씩 꺼내서
		// map.get(K)를 통해 Value 하나씩 가져옴
		for ( String key : keys) {
			System.out.printf("student[%s] : %s \n", key, student.get(key) );
		}
		
		
		/* 2. Map.entrySet() 이용*/
		// => K:V쌍 형태의 객체를 모아둔 집합(SET) 반환
		
		Set<Entry<String, Object>> set = student.entrySet();
		System.out.println(set);
		
		for( Entry<String, Object> entry : set ) {
//			entry.getKey() : entry에서 key만 반환
//			entry.getValue() : entry에서 value만 반환
			System.out.printf("student[%s] : %s \n", entry.getKey(), entry.getValue() );
		}
		
	}
	
	// 서술형 쪽지시험 이것저것
	
	// 
	// 하나의 이름/ 객체가 여러 모습을 띄는것: 다형성
	
	// 공통점 추출, 유연성 확보 : 추상화
	
	// 필드에 대한 직접접근 차단 : 캡슐화
	
	// 상속 : ?ㅇㄴㅁ?ㅇ?ㄴㅁ?ㅇ?ㅁ?ㄴㅇ?ㅁ?ㄴㅇ
	
	
	
	
	
	
	

}
