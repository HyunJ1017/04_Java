package pkg5todolist.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import pkg5todolist.dao.ToDoDAO;
import pkg5todolist.dto.ToDoList;

public class ToDoService {
	
	ToDoDAO dao = null;
	
	// 기본생성자
	public ToDoService() throws FileNotFoundException, ClassNotFoundException, IOException {
		dao = new ToDoDAO();
		
	}
	
	
	/**
	 * 제목과 내용을 전달받아 새로운 요소로 추가 및 저장
	 * @param title
	 * @param list
	 * @return 성공하면 true
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public boolean addList(String title, String list) throws FileNotFoundException, IOException {
		return dao.addList(title, list);
	}


	/**
	 * 전체리스트 반환
	 * @return todoList
	 */
	public List<ToDoList> getLisSObject() {
		return dao.getList();
	}


	/**[정보조회용]
	 * 인덱스번호를 전달받아
	 * 해당 인덱스의 ToDoList 객체 참조주소를 반환
	 * @param index
	 * @return
	 */
	public ToDoList getIndexList(int index) {
		return dao.getIndexList(index);
	}


	/**
	 * 상태수정
	 * @param index
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public boolean changeState(int index) throws FileNotFoundException, IOException {
		ToDoList list = getIndexList(index);
		if (list==null) {
			return false;
		}
		
		if(list.getState() == 0) {
			list.setState(1);
			System.out.println("'완료'로 변경되었습니다.");
		}else {
			list.setState(0);
			System.out.println("'덜됨'으로 변경되었습니다.");
		}
		dao.saveFile();
		return true;
	}


	/**인덱스 번호와, 객체 정보를 전달받아
	 * 해당 인덱스 객체의 정보를 수정 후 저장
	 * @param index
	 * @param title
	 * @param list
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public boolean updateList(int index, String title, String list) throws FileNotFoundException, IOException {
		ToDoList listOne = getIndexList(index);
		listOne.setList(list);
		listOne.setTitle(title);
		dao.saveFile();
		return true;
	}


	/**
	 * 인덱스번호를 전달받아
	 * 해당 인덱스의 요소 삭제 후 저장
	 * @param index
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public boolean deletList(int index) throws FileNotFoundException, IOException {
		List<ToDoList> lists = getLisSObject();
		lists.remove(index);
		dao.saveFile();
		return true;
	}

}
