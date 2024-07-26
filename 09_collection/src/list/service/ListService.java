package list.service;

import java.util.ArrayList;
import java.util.List;

/* Collection framdnt : Java에서 제공하는 자료구조를 모아둔 것
 * (Java.utill 페키지에 존재)
 * 
 * [특징]
 * 1) 크기 제한 없음
 * 2) 추가, 삭제, 수정, 검색 , 정렬 등 다양한 기능이 제공됨
 * 3)객체만 저장 가능
 *  [ 정확히는 객체참조주소 ]
 *  
 *  [List]
 *  - 자료(자료)를 순차적으로 나열한 자료 구조(배열 비슷)
 *  - Index가 존재함
 *    -> 각 데이터를 index로 구분할 수 있음
 *       -> 중복된 DATa를 저장할 수 있다
 */
public class ListService {
	
	/**
	 * 제네릭 없는 컬렉션 List 확인
	 */
	public void test1() {
		
		/* ArrayList 객체 생성 */
		// -> List 인터페이스를 상속받은 자식클래스
		// -> 가장 많이 사용하는 리스트
		
		// List : 부모 인터페이스
		//              --> 객체생성불가 / 부모참조변수 가능
		
//		List list = new ArrayList();	// 10칸(기본값)
		
		
		List list = new ArrayList(3);	// 3칸
		
		// E(Elimant) : 요소를 뜻하는 상징적인 글자
		//					(특정 자료형 X [Object타입])
		
		// boolean add(E e)
		// fltmxmdp 주어진 객체 e를 맨 끝에 추가
		list.add("아무거나");
		list.add(new Object());
		list.add(new int[4]);	// 여기까지 3번째(배열길이)
		
		// 4번째 -> 크기초과 오류발생 (x)
		//			-> 리스트 크기가 자동으로 늘어남
		list.add(123);	// int 기본자료형은 추가 불가(객체만 가능함)
						// -> Integer Wrapper class로 변환되어 저장됨
		
		System.out.println(list.toString());
		
		/* 2. void add(int index, E e) */
		// - index번째에 e를 추가 -> 중간에 삽입한다.
		
		list.add(2, "중간");
		
		System.out.println(list/*.toString*/);
		
		/* 3. int size() */
		// - 저장된 Data(객체)의 수를 반환 (length와 다름)
		System.out.println("현재 저장된 Data의 갯수 : " + list.size());	// 5 : 3개 만들고 2개 추가했으니까
		
		// (E == Object)
		/* 4. E get(int index) */
		// - index번째 요소를 반환
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		System.out.println(list.get(4));
		System.out.println("-----");
		
		// List + 일반 for문
//		for (int i = 0 ; i < 배열명.length ; i++ ) {
		for (int i = 0 ; i < list.size() ; i++ ) {	/* 배열은 빈칸 = null 이라고 출력하는데 리스트는 실제데이터 길이만 출력해줌 */

			System.out.printf("%d 번째 인덱스 요소 : %s\n", i, list.get(i) );
			// list.get(i) 는 Object를 반환해 주는데 print구문은 .toString으로 출력해줌
		}
		
		System.out.println("-----");
		
		int index0 = 0;
		
		// List + 향상된 for문
		for( Object obj : list) {
			
			String str = null;
			
			if		( obj instanceof String ) 	str = "[String]";
			
			else if ( obj instanceof int[] ) 	str = "[int[]]";
			
			else if ( obj instanceof Integer ) 	str = "[Integer]";
			
			else 								str = "[Object]";
			
			System.out.printf("%d 번째 인덱스 요소 : %s %s\n", index0, str, list.get(index0) );
		
			index0++;
		}
		
	}
	
	/**
	 * List + generics(타입제한) 확인
	 *  + List메소드 추가
	 */
	public void test2() {
		/*
		 * 제네릭(Generics, <>)
		 * 1) 컬렉션의 타입을 제한하여
		 *   한가지 자료형만 저장할 수 있게 하는 기능
		 * 2) 클래스나 메서드가 다룰 타입을 지정하는 기능
		 */
		
		// String으로 타입이 제한된 List 생성
		List<String> menuList = new ArrayList<String>();
//		String[] menuList = new String[index];
		
//		add()확인
//		menuList.add(123); // String으로 제한되서
							// 다른 자료형 추가 불가능
		menuList.add("보쌈");
		menuList.add("닭갈비");
		menuList.add("양념갈비");
		menuList.add("삼겹살");
		menuList.add("칼국수");
		menuList.add("냉면");
		
		int index0 = 0;
		// 향상된 for문
		for (String str : menuList) {
			System.out.printf("%d번째 :  %s\n", index0, str);
			index0++;
		}
		
		System.out.println("-----");
		
		/* 5. E set(int index, E e)*/
		// - 지정된 index번째 요소를
		// e(두번째 매개변수)로 수정
		// -> 매서드 반환값으로 이전 객체가 반환된다
		
		System.out.println(menuList);
		String before = menuList.set(2, "소갈비");
		System.out.println(before + "가 " + menuList.get(2) + "로 변경됨");
		System.out.println(menuList);
		
		System.out.println("-----");
		
		/* 6. boolean contains(E e) */
		// (확인기능) List 내부에 e와 같은 객체가 존재하면 true / false
		System.out.println("보쌈 : " + menuList.contains("보쌈"));
		System.out.println("막국수 : " + menuList.contains("막국수"));
		
		System.out.println("-----");
		
		/* 7. int indexof(E e)*/
		// (확인기능 + 인덱스번호 반환) 
		// List 내부에 e와 같은 객체가 존재하면 index 반환
		// 없으면 -1 반환(0번부터 시작하니까)
		System.out.println("삼겹살 : " + menuList.indexOf("삼겹살"));
		System.out.println("오겹살 : " + menuList.indexOf("오겹살"));
		
		System.out.println("-----");
		
		/* 8. E remove(int index) */
		// List에서 지정된 index번째 요소를 제거
		// -> 중간이 제거되면 뒤 요소를 앞으로 이동
		// 제거된 요소는 메서드 결과로 반환됨
		System.out.println(menuList.remove(1)+" 제거");
		System.out.println(menuList);
		
		
		
	}

}
