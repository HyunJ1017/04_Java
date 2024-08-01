package pkg4.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* 문자 기반 스트림(!=바이트기반스트림)
 * 
 * - 2byte 문자(char) 단위로 입/출력하는 스트림
 * 
 * - 문자만 작성된 파일(txt), 채팅,
 *   인터넷 요청(주소)/응답(html)
 *   
 * - Reader(입력), Writer(출력) 최상위 인터페이스
 */
public class CharService {
	
	/**
	 * 문자 기반 스트림을 이용해 출력하기 1
	 * - 기반스트림만 이용
	 */
	public void fileOutput1() {
		
		// StringBuilder : String의 불변성을 해결한 객체
		StringBuilder sb = new StringBuilder();
		
		sb.append("오늘은 8월 1일 입니다.\n");
		sb.append("아쉽게도 목요일 이네요...\n");
		sb.append("아 벌써 배고파요\n");
		sb.append("-- End --\n");
		
		String str = sb.toString();
		
		/*문자 기반 스트림 참조변수 선언*/
		FileWriter fw = null; 
		
		try {
			// 예외가 발생할것 같은 코드 작성
			
			// 해당 폴더가 없으면 만들어주기
			File folder = new File("/io_test/char");
			if( !folder.exists() ) folder.mkdirs();
			// 없는 파일은 아웃풋 스트림이 자동으로 생성
			
			/* 문자 기반 스트림 객체 선언*/
			fw = new FileWriter("/io_test/char/문자테스트.txt");
			
			// 문자열을 지정된 파일에 풀력
			// -> 전달받은 문자열을 자동으로 한 글자씩 출력
			fw.write(str);
			
			/* 스트림 밖으로 데이터를 흘려보냄 */
			fw.flush();
			
			System.out.println("** 작업 완료 **");
			
		} catch (Exception e) {
			// try에서 던져진 예외를 잡아서 처리
			// Exception 다형성 (업캐스팅) 으로 다 잡음
			e.printStackTrace();
		} finally {
			// try에서 예외 발생여부와 관계없이 무조건 수행할 코드
			
			try {
				/* close() : flush() 후 스트림 닫기 */
				if(fw!=null)fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * 문자 기반 스트림을 이용해 출력하기2
	 * - 기반 + 보조 스트림
	 * - 코드 길어지고, 출력속도가 빨라짐
	 */
	public void fileOutput2() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("문자 기반 보조스트림\n");
		sb.append("BufferedWriter를 이용해\n");
		sb.append("출력한 결과 입니다.\n");
		
		String str = sb.toString();
		
		/* 스트림 참조변수 선언 */
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			/* 스트림 객체 생성 */
			fw = new FileWriter("/io_test/char/보조스트림출력.txt");
			bw = new BufferedWriter(fw);
			
			bw.write(str);	// 보조 스트림을 이용해 출력
			
			System.out.println("** 실행 완료 **");
			
			/* bw.flush(); */
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				// 보조 스트림을 닫으면 기반 스트림도 자동으로 닫힘
				// close() 호출시 flush() 자동으로 선시행
				if(bw!=null)bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * 문자 기반 입력 스트림을 이용해
	 * /io_test/char/문자테스트.txt
	 * 파일 내용을 읽어와 콘솔에 출력
	 */
	public void fileInput1() {
		
		// 스트림 만들기
		FileReader fr = null;
		
		try {
			fr = new FileReader("/io_test/char/문자테스트.txt");
			int value = 0;
			StringBuilder sb = new StringBuilder();
			
			while(true) {
				// fr.read() : 문자 하나 읽어옴, 없으면 -1;
				value = fr.read();
				
				// 더 이상 읽어올 문자가 없을 경우
				if(value == -1) break;
				
				sb.append((char)value);
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fr!=null)fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 문자 기반 스트림을 이용해 입력받기 2
	 * - 기반 + 보조 스트림
	 */
	public void fileInput2() {
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			// 스트림 객체 생성
			fr = new FileReader("/io_test/char/문자테스트.txt");
			br = new BufferedReader(fr);
			
			// String br.readLine()
			// -> 한 줄을 읽어오는데
			//    없으면 null이 반환됨
			// -> \n은 읽어오지 않음...
			
			String line = null; // 읽어올 한 줄을 저장할 변수
			StringBuilder sb = new StringBuilder();
			while (true) {
				line = br.readLine();
				
				// 읽어온 내용이 없다면 반복 종료
				if (line == null) break;
				
				sb.append(line);
				sb.append("\n");
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(br!=null)br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
