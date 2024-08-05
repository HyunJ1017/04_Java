package pkg5todolist.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import pkg5todolist.dto.ToDoList;

public class ToDoDAO {
	
	public static final String FILE_PATH = "/workspace/04_Java/data/ToDoList.dat";
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;
	
	List<ToDoList> todoList = null;
	
	// 기본생성자
	public ToDoDAO() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		File f = new File(FILE_PATH);
		if (f.exists()) {
			try {
				ois = new ObjectInputStream( new FileInputStream(FILE_PATH));
				todoList = (List<ToDoList>) ois.readObject();
			} finally {
				if(ois!=null)ois.close();
			}
			
		}
		else {
			todoList = new ArrayList<ToDoList>();
		}
	}

	/**
	 * 추가시켜주는 친구
	 * @param title
	 * @param list
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public boolean addList(String title, String list) throws FileNotFoundException, IOException {
		
		ToDoList newlist = new ToDoList(title, 0, list);
		todoList.add(newlist);
		saveFile();
		return true;
	}

	/**
	 * 저장시켜주는친구
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void saveFile() throws FileNotFoundException, IOException {
		try {
			oos = new ObjectOutputStream( new FileOutputStream(FILE_PATH));
			oos.writeObject(todoList);
			oos.flush();
		} finally {
			if(oos!=null)oos.close();
		}
		
	}

	/**
	 * 리스트반환해주는친구
	 * @return todoList
	 */
	public List<ToDoList> getList() {
		return todoList;
	}

	
	/**
	 * 아낌없이주는리스트
	 * @param index
	 * @return
	 */
	public ToDoList getIndexList(int index) {
		if(index<0 || index >todoList.size() ) {
			System.out.println("인덱스 범위를 초과하였습니다.");
			return null;
		}
		return todoList.get(index);
	}

	
	
	
	
	

}
