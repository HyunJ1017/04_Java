package pkg2.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import pkg2.dto.Member;

public class ObjectService {
	
	
	public void createMember() {
		BufferedReader br = null;
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
		
			br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("id : ");
			String id = br.readLine();
			System.out.print("pw : ");
			String pw = br.readLine();
			System.out.print("name : ");
			String name = br.readLine();
			System.out.print("age : ");
			String ageString = br.readLine();
			
			int age = Integer.parseInt(ageString);
			
			Member member = new Member(id, pw, name, age);
			
			/*없으면 만들기*/
			String folderPath = "/io_test/test1";
			File f = new File(folderPath);
			
			if ( !f.exists() ) f.mkdirs();
			
			
			/*가져오기*/
			
			fis = new FileInputStream(folderPath + "/Member.dat");
			ois = new ObjectInputStream(fis);
			
			@SuppressWarnings("unchecked")
			List<Member> members = (List<Member>)ois.readObject();
			
			/*추가하기*/
			members.add(member);
			
			/*덮어쓰기*/
			fos = new FileOutputStream(folderPath + "/Member.dat");
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(members);
			
			System.out.println("작업이 잘 된것 같습니다.");
			
		} catch (ClassNotFoundException e) {
			System.out.println("** 불러오는 파일의 클래스에서 오류 발생 **");
			e.addSuppressed(e);
		} catch ( NumberFormatException e) {
			System.out.println("** 숫자입력과정에서 오류 발생 **");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("** 입력과정에서 오류 발생 **");
			e.printStackTrace();
		} catch (Exception e ) {
			System.out.println("** 오류 발생 **");
			e.printStackTrace();
		}
		finally {
			try {
				if(br!=null)br.close();
				if(oos!=null)oos.close();
				if(ois!=null)ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 작업할 데이터파일 만들기
	 */
	public void newFile() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			
			String folderPath = "/io_test/test1";
			File f = new File(folderPath);
			
			if ( !f.exists() ) f.mkdirs();
			
			File dataFile = new File(folderPath + "/Member.dat");
			
			if ( !dataFile.exists() ) {
				dataFile.createNewFile();
				fos = new FileOutputStream(folderPath + "/Member.dat");
				oos = new ObjectOutputStream(fos);
				oos.writeObject(null);
			}
			/*이거 맞나...?*/
			
			
			
			
		} catch (Exception e) {
			System.out.println("** 오류 발생 **");
		} finally {
			try {
				if(oos!=null)oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 읽어오면 List<Member>
	 * 하나하나 꺼내서 toString > println
	 */
	public void readFile() {
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream("/io_test/test1/Member.dat");
			ois = new ObjectInputStream(fis);
			
			@SuppressWarnings("unchecked")
			List<Member> members =(List<Member>)ois.readObject();
			
			for (Member obj : members ) {
				System.out.println( obj.toString() );
			}
			
		} catch ( IOException e ) {
			System.out.println("** 파일 불러오기 오류 **");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("** 오류발생 **");
			e.printStackTrace();
		} finally {
			try {
				if(ois!=null)ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
