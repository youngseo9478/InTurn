package graphicUI;
/*******List**********
 * List(6,true) ->true는 멀티플을 지원하는것
 * 그리고 저 숫자는 int row에 해당하는데 사이즈가 우선순위로 됨.
 *  그래서 6라고했어도 입력값이 7개이면 7개가 나타남
 * replaceItem은 선택된 아이템의 값을 아예 바꿔주는 것*/
import java.awt.*;

public class ListTest {

	public static void main(String[] args)
	{
		Frame f = new Frame("List - Select");
		f.setSize(300,200);
		f.setLayout(null);
		
		List selectOne = new List(0); //6개의 목록을 보여줄 수 있는 크기의 List를 만든다.
		selectOne.setLocation(20,40);
		selectOne.setSize(100,200);
		selectOne.add("student");
		selectOne.add("Teacher");
		selectOne.add("Driver");
		selectOne.add("Computer Programmer");
		selectOne.add("Sales Man");
		selectOne.add("Musician");
		selectOne.add("Director");
		selectOne.replaceItem("Programmer",2); //2번 인덱스 값을 Programmer로 바꾸는 메소드
		
		//생성자의 두번째 인자값을 true로 설정해서 List의 목록에서 여러 개를 선택할 수 있게 했다.
		List selectMany = new List(6,true);
		selectMany.setLocation(150,40);
		selectMany.setSize(100,120);
		selectMany.add("student");
		selectMany.add("Teacher");
		selectMany.add("Driver");
		selectMany.add("Computer Programmer");
		selectMany.add("Sales Man");
		selectMany.add("Musician");
		selectMany.add("Director");
				
		f.add(selectOne);
		f.add(selectMany);
		f.setVisible(true);
	}
}
