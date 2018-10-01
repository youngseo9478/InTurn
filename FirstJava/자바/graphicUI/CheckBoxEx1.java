package graphicUI;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;

/*********Check Box***********
 * 체크박스 여러개를 그룹으로 묶으면 
 * 그 그룹내의 속성 중 한가지만을 선택할 수 있는라디오버튼으로 바뀐다.
 * (Label은 단순하게 이름 넣는 것 
 * 정렬기능이 있어서 사용하면 됨)*/

public class CheckBoxEx1 {

	public static void main(String[] args)
	{
		Frame f = new Frame("Questions");
		//위치는 선정안해주면 (0,0)에서 생성됨
		f.setSize(250,250); //현재는 프레임 레이아웃이라서 크기에 따라서 항목의 정렬이 결정된다.->나중에 할것
		
		//Frame의 LayoutManager를 FlowLayout으로 설정한다.
		f.setLayout(new FlowLayout());
		
		//그룹을 만들지는 않았기 때문에 여러개 선택이 가능하다
		Label q1 = new Label("1. 당신의 관심 분야는?(여러개 선택가능)");
		//체크박스 여러개 생성중
		Checkbox news = new Checkbox("new",true); //true는 체크된상태로 둔다는 것. default 는 false->아무것도 체크되어있지않는 상태
		Checkbox sports = new Checkbox("sports");
		Checkbox movie = new Checkbox("movie");
		Checkbox music = new Checkbox("music");
		
		f.add(q1); //f프레임에 항목을 추가하는 것.
		f.add(news);
		f.add(sports);
		f.add(movie);
		f.add(music);
		
		//그룹을 만들어주면 체크박스에서 라디오버튼으로 바뀌게되고 그 그룹안에 속한 버튼중에 하나만 체크할 수 있다.
		Label q2 = new Label("2.얼마나 자주 극장에 가십니까?");
		CheckboxGroup group = new CheckboxGroup();
		Checkbox movie1 = new Checkbox("한 달에 한 번 갑니다.",group,true);
		Checkbox movie2 = new Checkbox("일주일에 한 번 갑니다.",group,false);
		Checkbox movie3 = new Checkbox("일주일에 두 번 갑니다.",group,false);
		
		f.add(q2); //그냥 메세지나 이름같은걸 프레임에 나타내주는게 Label이 하는 일
		f.add(movie1);
		f.add(movie2);
		f.add(movie3);
		
		Label q3 = new Label("3.하루에 얼마나 컴퓨터를 사용하십니까?");
		CheckboxGroup group2 = new CheckboxGroup();
		Checkbox com1 = new Checkbox("5시간 이하",group2,true);
		Checkbox com2 = new Checkbox("10시간 이하",group2,false); 
		//^위에서 라디오버튼은 한가지만 선택할 수 있기때문에 여기에도 또 true를 하면 5시간 이하에서 체크가 풀린다.->나중에지정한게우선순위높음
		Checkbox com3 = new Checkbox("15시간 이하",group2,false);
		
		f.add(q3);
		f.add(com1);
		f.add(com2);
		f.add(com3);
		
		f.setVisible(true);
	}
}
