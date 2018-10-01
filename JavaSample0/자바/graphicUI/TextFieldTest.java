package graphicUI;
import java.awt.*;
public class TextFieldTest {

	public static void main(String[] args)
	{
		Frame f = new Frame("Login");
		f.setSize(400,400);
		f.setLayout(new FlowLayout()); //LayoutManager를 FlowLayout으로 한다.
		
		Label lid = new Label("ID : ", Label.RIGHT); //정렬을 오른쪽으로
		Label lpwd = new Label("Password : ",Label.RIGHT);
		
		TextField id = new TextField(10); //약 10개의 글자르 입력할 수 있는 TextField 생성
		TextField pwd = new TextField(10);
		pwd.setEchoChar('*');//입력값대신 '*'가 보이도록 한다.
		
		//TextArea(String text, int rows, int columns, int scrollbars)
		TextArea comments = new TextArea("하고 싶은 말을 적으세요.",10,50,TextArea.SCROLLBARS_VERTICAL_ONLY);
		//TextArea에서 스크롤바는  디폴트인데 수직/수평 중 하나만 하고싶거나 둘다 안하고 싶을때는 상수값을 줘서 설정해줄 수 있다.
		f.add(lid);
		f.add(id);
		f.add(lpwd);
		f.add(pwd);
		f.add(comments);
		f.setVisible(true);
	}
}
