package pkg2.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* [Stream(스트림)]
 * - 데이터가 이동하는 통로
 * - 기본적으로 단반향
 * 
 * [Byte 기반 스트림]
 * - 1byte 단위로 데이터를 입/출력하는 스트림
 * 
 * - 최상위 인터페이스 : InputStream / OutputStream
 * 
 * - 입/출력 할 수 있는 데이터
 *   문자열, 이미지, 영상, 오디오, pdf등 모든 데이터 파일
 * 	 (단, 문자열이 깨질 가능성이 있고,
 * 	 좁은 통로를 이용하다 보니 상대가 속도적으로 느림
 * 
 * *************************************************   *
 * Stream(통로) 객체는 Java 프로그램이 종료가 되어도   *
 * 연결된 외부 파일/프로그램과 지속적으로 연결되어져   *
 * 있어서 자동으로 사라지지 않는다.                    *
 * -> 직접 닫아서 없애주는 close() 구문을 필수로 수행! *
 * *************************************************** *
 */
public class ByteService {
	
	
	/**
	 * 지정된 경로의 폴더에
	 * 파일생성 + 내용출력(바이트기반 스트림 사용)
	 */
	public void fileByteOutput(){
		
		//FileOutputStream 참조변수 선언
		// trym finally 둘다 모두 사용
		FileOutputStream fos = null;
		
		//  예외처리 필수!
		try {
			String folderPath = "/io_test/byte";
			String fileName = "바이트기반테스트.txt";
			
			// 폴더 유무 확인
			File forder = new File (folderPath);
			
			if (!forder.exists()) { // 폴더가 존재하지 않으면
				forder.mkdirs();	// 폴더 생성
			}
			
			// 풀력할 파일과 연결되 출력용 스트림 객체 생성
			// 출력하려는 파일이 존재하지 않으면 자동생성
			fos = new FileOutputStream(folderPath + "/" + fileName);
					// /io_test/byte/바이트기반테스트.txt
			
			
			// 만들어진 txt 파일에 들어가 내용 작성
			
			// StringBuilder : String 불변성 문제를 해결한 객체
//							-> 메모리효율 good
			StringBuilder sb = new StringBuilder();
			
			sb.append("Hellow World!!\n");
			sb.append("1234567890\n");
			sb.append("!@#$%^&*()\n");
			sb.append("안녕하세요\n");
			sb.append("😊😚😊☺🙄🤩😊😚😊☺🙄\n");
			
			// StringBuilder에 저장된 내용을 String 으로 변환
			String content = sb.toString();
			
			/* 연결된 외부 파일로 내용을 출력 */
			
			/* 방법1) 1byte씩 끊어서 출력하기 */
			
			// for문 수행 전에 미리 반복할 횟수를 얻어옴
			// 안이러면 반복할때마다 content.length() 수행함
			// int length = content.length();
			
//			for ( int i=0, length=content.length() ; i<length ; i++) {
//				char ch = content.charAt(i); // i번째 문자 반환
//				fos.write(ch);	// 출력스트림으로 출력하기
//								// -> 이전 출력내용 뒤에 이어쓰기
//			}
				
				// 2바이트 문자(char)를
				// 1바이트 스트림으로 출력하니까 문자가 깨짐!!!
				// (= 데이터 손실)
			
			/* 방법2) String 을 byte로 먼저 변환한 후 출력 */
			// -> 미리 byte로 변환하면 손실되는 데이터가 없어서
			// 한글도 깨지지 않고 출력된다
			
			// String -> byte
			byte[] bytes = content.getBytes();
			
			fos.write(bytes);
			fos.write(56);
			
			System.out.println("**파일 출력 완료**");
			
			
		}catch(IOException e) {
			e.printStackTrace();
			// 예외 종류, 메시지, 발생위치 출력
		}finally {
			
			// try에서 예외 발생여부와 관계없이
			// 연결된 FileOutStream 객체를 닫아서
			// 메모리 반환을 하겠다.
			try {
				
				// NullPointerException 방지
				if(fos!=null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 버퍼를 이용한 "바르고 효율적인"파일출력
	 * - FileOutputStream     (기반 스트림)
	 * - BufferedOutputStream (보조스트림)
	 */
	public void bufferedFileByteOutput() {
		
		/* 버퍼(buffer)란?
		 * - 데이터가 모아져있는 메모리상의 임시 공간
		 * == 장바구니 처럼 생각
		 * -> 한번에 많은 양의 데이터를 이동 시켜
		 *    시간 효율이 좋음
		 * */
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			// 기반 스트림 생성
			fos = new FileOutputStream("/io_test/byte/버퍼_바이트.txt");
			
			// 보조 스트림 생성
			bos = new BufferedOutputStream(fos);
			// -> 기반 스트림을 매개변수 전달하면 연결된다.
			
			// """ """ : 내부에 작성된 문자열 그대로 저장 == <pre></pre>
			String content = """

특히 양민혁에 대해 매체는 "양민혁은 국내에서 높은 평가를 받고 있다"라며 "강원이 공식 발표한 이적설에 따르면 토트넘이 K리그에서 프리미어리그로 직행하는 양민혁에게 역대 최고 이적료를 지불한 것에서도 그 사실이 드러난다"라고 주장했다.

김병지 대표이사는 지난 28일 구단 유튜브 라이브를 통해 "이적료는 정확하게 밝힐 수 없지만 역대 K리그에서 유럽으로 직행한 선수 중 가장 이적료가 높다"라고 말해 화제를 모았다.

기존 K리그에서 유럽으로 직행한 선수들 중 가장 높은 이적료를 기록한 사례는 이청용(울산HD)이다. 2009년 당시 FC서울 소속이었던 이청용은 그해 여름에 프리미어리그 클럽이었던 볼턴 원더러스로 이적하면서 서울에 약 50억원의 이적료를 안긴 바 있다.
양민혁에게 큰 기대를 걸고 있는 매체는 "우리는 양민혁이 토트넘 선수들과 맞붙는 모습을 보는 걸 고대하고 있다"라며 양민혁의 화려한 쇼케이스가 펼쳐질 수 있기를 바랐다.

사진=토트넘 SNS, 엑스포츠뉴스DB
""";
			
			// 보조 스트림을 통해 출력
			// -> content를 byte[]로 변환해서 출력
			// -> 출력 시 버퍼를 사용해서 한번에 출력! 
			bos.write( content.getBytes() );
			
			System.out.println("** 출력 완료 **");
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			// 사용 완료된 스트림 객체 닫기
			try {
				
				/**보조스트림만 닫으면
				 * 연결된 기반 스트림도 같이 닫히게 된다. */
				if( bos != null ) bos.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 바이트 기반 파일 입력1
	 */
	public void fileByteInput1() {
		
		FileInputStream fis = null;
		
		try {
			// 파일 입력 스트림 객체 생성
			fis = new FileInputStream("\\io_test\\byte\\읽어올파일.txt");
			
			// 방법 1)
			// 파일 내부 문자열을 1byte씩 끊어서 읽어오기
			
			int value = 0;	// 읽어온 1byte를 저장할 변수
			
			StringBuilder sb = new StringBuilder(); // 읽어온 값을 누적 저장할 객체 생성
			
			while(true) { // 무한반복
				
				// fis.read()
				// - 다음 바이트 데이터를 반환
				// - 읽어올 내용이 없으면 -1 반환
				value = fis.read();
				
				if (value==-1) break;
				
				// 읽어온 데이터를 char로 면환하여 sb에 누적
				sb.append( (char)value );
			}
			
			// 읽어온 값 콘솔에 출력
			System.out.println( sb.toString() );
			
		} catch ( IOException e ) {
			e.printStackTrace();
		} finally {
			// 스트림 객체 닫기(메모리반환)
			try {
				if( fis!=null ) fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	/**
	 * 바이트 기반 파일 입력2
	 */
	public void fileByteInput2() {
		
		FileInputStream fis = null;
		
		try {
			
			fis = new FileInputStream("\\io_test\\byte\\읽어올파일.txt");
			
			// 방법 2)
			// byte[] fis.readAllBytes()
			//  -> 연결된 파일의 내용을 모두 Byte로 변환 후
			//     하나씩 읽어와 byte[]에 저장하여 반환
			//  -> byte[]을 이용해서 String 객체를 만들 수 있는데
			//	   이 때 바이트로 쪼개진 데이터가 정상적으로
			//     깨지지 않고 정상형태를 유지
			
			byte[] bytes = fis.readAllBytes();
			String content = new String(bytes);
			System.out.println(content);
			
			
		} catch ( IOException e ) {
			e.printStackTrace();
		} finally {
			// 스트림 객체 닫기(메모리반환)
			try {
				if( fis!=null ) fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	/**
	 * 버퍼를 이용해 효율적으로 파일 읽어오기
	 */
	public void befferedFileByteInput() {
		
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		
		try {
			// 기반스트림 생성
			fis = new FileInputStream("/io_test/byte/읽어올파일.txt");
			
			// 보조스트림 생성
			bis = new BufferedInputStream(fis);
			
			// 보조스트림을 이용해서
			// 파일내용 -> byte로 변호나해 한번에 읽어옴
			// -> byte[]에 저장한 후 반환
			byte[] bytes = bis.readAllBytes();
			
			// byte[]을 String 변환 후 출력
			String content = new String(bytes);
			System.out.println(content);
			
			
		} catch ( Exception e ) {	// IOException 업 캐스팅
			e.printStackTrace();
		} finally {
			try {
				if(bis!=null)bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
				
	}
	
	
	//--------------------------------------------------------------------------------
	
	/**
	 * [파일복사]
	 * 
	 * <pre>
	 *  복사할 파일의 경로를 입력하여
	 *  
	 *  해당 파일이 존재하지 않으면
	 *  -> "파일이 존재하지 않습니다." 콘솔에 출력
	 *  
	 *  존재하면
	 *  -> 같은 경로에 "파일명_copy" 이름으로 파일생성
	 *  
	 *  [실행화면]
	 *  파일 경로 입력 : /io_test/byte/노래가사.txt
	 *  복사 완료 : /io_test/byte/노래가사_copy.txt
	 * </pre>
	 */
	public void fileCopy() {
		
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		// 키보드 입력 받을 스트림 준비
		BufferedReader br = null;
		
		try {
			/* 경로 입력받기 --------------------------------------------*/
			// 키보드 입력을 받기 위한 스트림 객체 생성
			br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("파일 경로 입력 : ");
			String target = br.readLine();	// 키보드 입력 한 줄 받기
			
			/* 파일 읽어오기 --------------------------------------------*/
			// 입력받은 경로의 파일과 연결되어 읽어올 스트림 생성
			fis = new FileInputStream(target);
			// -> 경로에 파일이 없으면
			// FileNotFoundException 던지고 try문 종료
			
			bis = new BufferedInputStream(fis);
			
			// 입력용 스트림을 이용해서 파일 내용 읽어오기
			// byte[] 형식으로 반환받을거임
			byte[] bytes = bis.readAllBytes();
			
			/* 파일 카피하기 --------------------------------------------*/
			
			// 출력할 파일 경로에 "_copy" 붙이기
			StringBuilder sb = new StringBuilder();
			sb.append(target);	// 대상 경로를 sb에 추가
			
			// int String.indexOf("찾을 문자열")
			// - 찾을 값이 String(문자열) 몇변째 인덱스에 존재하는지
			//   찾아서 반환, 없으면 -1 반환
			// int String.lastIndexOf("찾을 문자열")
			// - 뒤에서부터 우선적으로 검색하여
			// (숫자는 앞에서부터 정상적으로 센 숫자)
			
			// "노래가사.txt"에서 확장자 구분하는 . 찾기
			int insertPoint = target.lastIndexOf(".");	// 4
			
			// 문자열 중간에 "_copy" 삽입
			sb.insert(insertPoint, "_copy");
			
			String copy = sb.toString();
			
			/* 파일 출력하기 --------------------------------------------*/
			
			fos = new FileOutputStream(copy);
			bos = new BufferedOutputStream(fos);
			
			// 읽어온 내용 bytes를 bos를 이용해서 출력
			bos.write(bytes);
			
			System.out.println("복사 완료");
			
			
		} catch ( FileNotFoundException e ) {
			System.out.println("** 입력한 경로에 파일이 존재하지 않습니다.**");
		} catch ( Exception e ) {
			e.printStackTrace();
		} finally {
			// 스트림 닫기
			try {
				if(bis!=null)bis.close();
				if(bos!=null)bos.close();
				if(br !=null)br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}
	
	
	
	
	
	
}
