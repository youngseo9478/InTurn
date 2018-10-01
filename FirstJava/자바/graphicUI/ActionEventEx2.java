package graphicUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ActionEventC2 extends Frame //implements ActionListener
{
	Label outputLabel = new Label();
	Button leftBtn = new Button("<=Button");
	Button rightBtn = new Button("Button=>");
	
	
	/********3.리스러를 멤버로 만듬(어나니머스)************/
	//액션리스너를 멤버로 만들어 놓았음 (어나니머스는 이렇게 해도 됨)->여기서 마저 구현하는 것
	ActionListener actionHandler = new ActionListener(){
		//리스너에 의해서 호출되는 핸들러
		public void actionPerformed(ActionEvent e) //여기서 오버라이딩
		{//e는 리스너가 수집한 정보를 핸들러에게 던져준 것들이 들어있음
			Button eventBtn = (Button)e.getSource(); //getSource()가 오브젝트타입을 리턴하기때문에 캐스팅 필요
			if(eventBtn ==leftBtn)
			{
				outputLabel.setText("<=Button click");
			}
			else
			{
				outputLabel.setText("=>Button click");
			}
		}
	};
	
	public ActionEventC2(String title){
		super(title); //타이틀 생성
		Panel p =new Panel();
		p.add(leftBtn);
		p.add(rightBtn);
		outputLabel.setBackground(Color.ORANGE);
		//버튼이올라가있는패널을 north에 올린다.
		add(p, "North");
		add(outputLabel, "South");
		
	
		leftBtn.addActionListener(actionHandler);
		rightBtn.addActionListener(actionHandler);
		/*핸들러메소드를 갖고이쓴 객체를 this로 넘겨줬다. ->핸들러메소드가 내부에 있다는 뜻
		 * this는 내부참조할때 자기가 있는 객체의 주소값을 갖고있음 그러니까 그 객체안에 이걸 수행할 메소드가 있어야
		 * 사용할 수 있는 방법! 지금 클래스를 implements ActionListener (인터페이스)하면 
		 * actionPerformed() (abstract 메소드)를 구현할 수 있다. 
		 * 소유안하고 있으면 빨간줄 뜸 ->아래서 actionPerformed()를 구현하고 있다. */
		
		setBounds(100,100,300,200);
		setVisible(true);
	}
}

public class ActionEventEx2 {

	public static void main(String[] args)
	{
		new ActionEventC2("ActionEventTest1");
	}
}
