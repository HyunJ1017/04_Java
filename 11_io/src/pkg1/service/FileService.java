package pkg1.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class FileService {
	/* File 클래스
	 * 
	 * - java.io 패키지
	 * 
	 * - 파일/디렉토리(폴더)를 관리하는 클래스
	 *   (파일/디렉토리 존재 유무 관계 없음)
	 *   
	 * - 파일 생성, 제거, 이름, 크기, 마지막 수정일, 존재여부 등의 기능 제공 
	 *   
	 * - File 클래스 메서드
	 * 
	 * boolean  mkdir()          : 디렉토리 생성
	 * boolean  mkdirs()         : 경로상의 모든 디렉토리 생성
	 * boolean  createNewFile()  : 파일 생성
	 * boolean  delete()         : 파일/디렉토리 삭제
	 * String   getName()        : 파일 이름 반환
	 * String   parent()         : 파일이 저장된 디렉토리 반환
	 * String   getPath()        : 전체 경로 반환
	 * boolean  isFile()         : 현재 File 객체가 관리하는게 파일이면 true
	 * boolean  isDirectory()    : 현재 File 객체가 관리하는게 디렉토리 true
	 * boolean  exists()         : 파일/디렉토리가 존재하면 true, 아님 false
	 * long     length()         : 파일 크기 반환
	 * long     lastModified()   : 파일 마지막 수정일 (1970.01.01 09:00 부터 현재까지 지난 시간을 ms 단위로 반환)
	 * String[] list()          : 디렉토리 내 파일 목록을 String[] 배열로 반환
	 * File[]   listFiles()     : 디렉토리 내 파일 목록을 File[] 배열로 반환 
	 */
	
	
	/* [ 개발자 상식 ]
	 * 
	 * OS : 운영체제
	 * 
	 * Windows : 폴더 == Linux/Mac : 디렉토리
	 * 
	 * 경로 표기방법(하위폴더) : 
	 * 			Windows   : \ (폰트에따라 원화 표시로도 보임)
	 * 			Linux,Mac : /
	 * 
	 * -> Java는 모든 운영체제가 호환이 되기 때문에
	 *    경로 표기 방법도 모두 호환 된다!
	 *    
	 * 최상위 경로(root) : / 또는 \
	 * 			Windows   : "C:\", "D:\" ...
	 * 			Linux,Mac : "/",  "/Users" ...
	 * */
	
	
	/**
	 * File 클래스로 객체 생성 + 폴더관리
	 */
	public void test1() {
		
		// directory == folder
		
		// C:\io_test\20240731 경로의 폴더를 관리
		File directory = new File("/io_test/20240731");
		
		String url = new String(directory.getPath());
		System.out.println(url);	// "/" => c드라이브
		
		System.out.println("폴더 존재 유무 : " + directory.exists());
		
		// 지정된 경로의 폴더가 존재하지 않는경우
		if (!directory.exists()) {
			
			// 디렉토리(폴더) 모두 생성
			directory.mkdirs();
			System.out.println("폴더가 생성되었습니다.");
		}	// 처음 실행할때만 생성되고 이후에는 이미 생성되어있어서 작동 안함
		
	}
	
	/**
	 * File 객체를 이용해서 지정된 경로에 파일 생성하기
	 */
	public void test2() {
		
		// 경로표기방법 : \ 또는 /
		
		// \는 문자열(String)에서 Escape 문자를 위한 키워드이기 때문에
		// "\" 문자열을 나타내고 싶으면 \\ 두번작성해야 한다.
		File file = new File("\\io_test\\20240731\\파일생성.txt");
		
		// 지정된 경로의 파일이 존재하지 않는다면
		if(!file.exists()) {
			
			try {// 예외가 작성할것 같은 구문을 내부에 작성 후 시도
			
				// 파일 생성이 성공한 경우 / Unhandled exception type IOException
				if ( file.createNewFile() ) {
					System.out.println(file.getName() + "파일 생성이 완료되었습니다.");
				}
			} catch (IOException e ) {
				System.out.println("파일 생성 중 예외 발생");
				e.printStackTrace();// 예외 종류, 메시지, 예외가 발생한 위치 출력
			}
		}
		
	}
	
	
	
	/**
	 * File 클래스 제공 메서드
	 */
	public void test3() {
		
		// File 객체를 생성하여
		// 현재 프로젝트 폴더를 관리
		
		// C:\workspace\04_Java\11_io
		
		File project = new File("\\workspace\\04_Java\\11_io");	// C: 안씀
		
		// File[]   listFiles()
		// : 디렉토리 내 파일 목록을 File[] 배열로 반환
		
		File[] files = project.listFiles();
		
		for (File f : files) {
			// System.out.println(f.toString());
//		\workspace\04_Java\11_io\.classpath
//		\workspace\04_Java\11_io\.project
//		\workspace\04_Java\11_io\.settings		// 폴더
//		\workspace\04_Java\11_io\bin			// 폴더
//		\workspace\04_Java\11_io\src			// 폴더
			
			// 파일명
			String filename = f.getName();
			
			// 마지막으로 수정한 날짜
			long lastModified = f.lastModified();
			
			// SimpleDateFormat : 간단히 날자 형식을 지정할 수 있는 기능제공 클래스
			// y : year (연도)
			// M : month(월)
			// d : day
			// a : am/pm
			// h : hour
			// m : minute
			// s : second
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a h:mm");
			//                                           지정된 형식
			
			// 시간을 지정된 형식으로 변환
			String date = sdf.format(lastModified);
			
			// 파일유형
			String type = null;
			if(f.isFile()) type = "파일";
			else type="폴더";
			
			String kb = null;
			if(f.isFile()) {	// 파일인 경우에만
			
				// 파일크기
				long fileSize = f.length(); // byte단위로 나옴
				
				// Byte -> KB 변경
				long size = fileSize / 1024;
				
				if(size < 1) size = 1;	// 1KB 미만은 1로 표시
				
				kb = size + "KB";
			}
			
			// 출력할 문자열
			String result = String.format("%-20s %-20s %-5s %-10s", filename, date, type, kb == null ? "" : kb);
			
			System.out.println(result);
		}
		System.out.println("12345678901234567890 12345678901234567890 12345 1234567890");
		
	}
	
}
