package pkg4;

import java.util.ArrayList;
import pkg4.model.Student;

public class Test {
	public static void main(String[] args) {
		ArrayList<Student> list = null;
		list = new ArrayList<Student>();

		list.add(new Student("강건강", 84));
		list.add(new Student("남나눔", 78));
		list.add(new Student("도대담", 96));
		list.add(new Student("류라라", 867));
		
		for ( int i=0 ; i< list.size() ; i++) {
			Student s = list.get(i);
			System.out.println(s);
		}
//		System.out.println(
//				  "강건강 학생의 점수 : 84점\r\n"
//				+ "남나눔 학생의 점수 : 78점\r\n"
//				+ "도대담 학생의 점수 : 96점\r\n"
//				+ "류라라 학생의 점수 : 67점\r\n" );
	}
}

