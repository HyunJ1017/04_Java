package pkg5todolist.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import pkg5todolist.dto.ToDoList;
import pkg5todolist.service.ToDoService;

/*
 * view
 * 
====== Todo List =====

1. Todo List Full View
2. Todo Detail View
3. Todo Add
4. Todo Complete
5. Todo Update
6. Todo Delete
0. EXIT
select menu number >>>

 */
public class ToDoView {
	
	ToDoService service = null;
	BufferedReader br = null;
	
	public ToDoView() {
		try {
			service = new ToDoService();
			br = new BufferedReader( new InputStreamReader(System.in));
		} catch (Exception e) {
			System.out.println("파일이 시시합니다.");
			e.printStackTrace();
		}
		
	}
	

	public void mainSelect() {
		
		int input = 0;
		
		do {
			try {
				input = choiseMenu();
				
				switch (input) {
				case 1 : viewList(); break;
				case 2 : selectIndex(); break;
				case 3 : addList(); break;
				case 4 : changeState(); break;
				case 5 : updateList(); break;
				case 6 : deletList(); break;
				case 0 : System.out.println("GOOD BYE"); break;
				}
			
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력해 주세요");
				input = -1;
			} catch (IOException e) {
				System.out.println("입력도중 오류 발생");
				e.printStackTrace();
				input = -1;
			}
		
		} while (input!=0);
	}


	private int choiseMenu() throws NumberFormatException, IOException {
		System.out.println("\n====== Todo List =====\n");
		
		System.out.println("1. Todo List Full View");
		System.out.println("2. Todo Detail View"   );
		System.out.println("3. Todo Add"           );
		System.out.println("4. Todo Complete"      );
		System.out.println("5. Todo Update"        );
		System.out.println("6. Todo Delete"        );
		System.out.println("0. EXIT\n"             );
		System.out.print  ("select menu number >>>");
		return Integer.parseInt(br.readLine());
	}
	//-------------------------------------------------
	/*[Todo List Full View]*/
	
	private void viewList() {
		System.out.println("== 리스트 리스트 ==");
		List<ToDoList> lists = service.getLisSObject();
		
		String[] ox = {"X", "O"};
		
		int count = 0;
		for(ToDoList list : lists) {
			System.out.printf("%2d >> 상태 : %s  >  %s\n", count, ox[list.getState()], list.getTitle() );
			count++;
		}
		
	}
	
	//-------------------------------------------------
	/*[Todo Detail View]*/
	/**
	 * 인덱스번호받고 조회
	 */
	private void selectIndex() throws NumberFormatException, IOException {
		System.out.println("== 리스트 자세히 리스트==");
		
		System.out.print  ("인데스 : ");
		int index = Integer.parseInt(br.readLine());
		
		ToDoList list = service.getIndexList(index);
		if(list==null) {
			System.out.println("알맞은 범위의 인덱스를 입력하여주세요.");
			return;
		}
		
		System.out.println("제목 : " + list.getTitle());
		String[] ox = {"덜됨", "완료"};
		System.out.println("완료여부 : " + ox[list.getState()]);
		System.out.println("내용 : \n" + list.getList());
		
	}
	
	
	//-------------------------------------------------
	/*[Todo Add]*/
	/**
	 * 제목, 내용 입력받아서 넘겨야함
	 * @throws IOException 
	 */
	private void addList() throws IOException {
		
		System.out.println("\n === Todo Add ===\n");
		System.out.println("새로운 리스트를 입력합니다.");
		
		System.out.print  ("제목 : ");
		String title = br.readLine();
		
		System.out.println("내용을 입력합니다.\n종료를 원할때 '!wq'를 입력하세요.");
		System.out.println("내용 : ");
		/* !wq 입력될때까지 계속 반복되야함*/
		String list = null;
		StringBuilder sb = new StringBuilder();
		while( true ) {

			String input = new String(br.readLine());
			if(input.equals("!wq")) break;
			sb.append(input);
			sb.append("\n");
		}
		list = sb.toString();
		
		boolean result = service.addList(title, list);		
		
		if(result) System.out.println("실행완료");
		
	}
	
	//-------------------------------------------------
	/*[ToDo Complete]*/
	/**
	 * 인덱스 번호를 입력받아
	 * 완료->덜됨
	 * 덜됨->완료 변환하기
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	private void changeState() throws NumberFormatException, IOException {
		System.out.println("\n === Todo Complete ===\n");
		System.out.println("리스트 상태를 변경합니다.");
		
		System.out.print  ("인덱스 : ");
		int index = Integer.parseInt(br.readLine());
		
		boolean result = service.changeState(index);
		
		if(result)System.out.println("완료되었습니다.");
		else {
			System.out.println("해당하는 인덱스가 없습니다.");
		}
		
	}
	
	//-----------------------------------------------
	/* [Todo Update] */
	/**인덱스 번호 입력받고
	 * 인덱스 있는지 검사하고
	 * 제목, 내용 입력받고
	 * sevice로 넘겨서결과받기
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	private void updateList() throws NumberFormatException, IOException {
		System.out.println("\n === Todo Update ===\n");
		System.out.println("수정할 리스트의 번호를 입력해주세요");
		
		System.out.print  ("인덱스 : ");
		int index = Integer.parseInt(br.readLine());
		
		ToDoList listcheck = service.getIndexList(index);
		if(listcheck==null) {
			System.out.println("해당하는 인덱스가 비어계십니다.");
			return;
		}
		
		System.out.print  ("제목 : ");
		String title = br.readLine();
		
		System.out.println("내용을 입력합니다.\n종료를 원할때 '!wq'를 입력하세요.");
		System.out.print  ("내용 : ");
		/* !wq 입력될때까지 계속 반복되야함*/
		String list = null;
		StringBuilder sb = new StringBuilder();
		while( true ) {

			String input = new String(br.readLine());
			if(input.equals("!wq")) break;
			sb.append(input);
			sb.append("\n");
			
		}
		list = sb.toString();
		
		boolean result = service.updateList(index ,title, list);
		
		if(result)System.out.println("실행완료");
		
	}
	
	//--------------------------------------------------------
	/*Todo Delete*/
	/**
	 * 인덱스 번호를 입력받고 번호검사 후
	 * 해당 인덱스번호 삭제
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	private void deletList() throws NumberFormatException, IOException {
		System.out.println("\n === Todo Delete ===\n");
		System.out.println("삭제할 인덱스 번호를 입력 해 주세요");
		
		System.out.print  ("인데스 : ");
		int index = Integer.parseInt(br.readLine());
		
		ToDoList listcheck = service.getIndexList(index);
		if(listcheck==null) {
			System.out.println("해당하는 인덱스가 비어계십니다.");
			return;
		}
		
		boolean result = service.deletList(index);
		
		if(result)System.out.println("삭제 완료");
		
	}
	

}
