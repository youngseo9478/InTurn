package graphicUI;
/*
 * add랑 다르게 insert는 원하는 index값을 주면 그자리에 추가가된다.
 * select는 처음에 선택되어있는 항목을 지정해줄 수 있다. index로도 가능하고 값으로도 가능하다
 * setAlignment 이용해서 위치 변동시켜줄 수 있다.*/
import java.awt.*;
public class ChoicTest {

	public static void main(String[] args)
	{
		Frame f = new Frame("Choice - Select"); //문자열의 내용으로 프레임의 이름이 정해짐
		f.setSize(300,300);
		f.setLayout(null);
		
		Choice day = new Choice(); //Choice객체생성한 다음
		day.add("SUN"); day.add("MON"); day.add("WED"); day.add("THU"); day.add("FRI"); day.add("SAT");
		//day.add("TUE"); 이렇게하면 제일 나중에 추가되는데
		day.insert("TUE",2); //insert() 이렇게하면 인덱스 2에 추가되는것 (세번째)
		day.select("FRI"); //이렇게해주면 문자열 값에 따라 어떤걸 초기 선택상태로 둘지 지정해주는 것이고
		//day.select(2);이렇게하면 인덱스에따라 어떤걸 초기 선택상태로 둘지 지정하는 것
		
		day.setSize(100,50);
		day.setLocation(100,70);
		
		Label label = new Label("안녕하세요");
		label.setBounds(50, 250, 150, 40);
		label.setBackground(Color.CYAN);
		label.setAlignment(Label.CENTER); //레이블("안녕하세요")의 위치를 지정해주는 것
		f.add(label);
		
		f.add(day);
		f.setVisible(true);
		
	}
}
