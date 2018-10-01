package graphicUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ActionEventC extends Frame implements ActionListener
{
	Label outputLabel = new Label();
	Button leftBtn = new Button("<=Button");
	Button rightBtn = new Button("Button=>");

	
	public ActionEventC(String title){
		super(title); //타이틀 생성
		Panel p =new Panel();
		p.add(leftBtn);
		p.add(rightBtn);
		outputLabel.setBackground(Color.ORANGE);
		//버튼이올라가있는패널을 north에 올린다.
		add(p, "North");
		add(outputLabel, "South");
		
		/*리스너는 이벤트가 발생이되어지는걸 확인하고 , 이벤트발생했을때생기는 데이터, 정보를 수집한 후 핸들러를 부른다.
		핸들러메소드를 갖고있는 객체를 원한다.
		핸들러메소드는 전부다 인터페이스로 되어있음 그래서 이 인터페이스를 구현하고 있는 객체를 소괄호안에 넣어주어야 한다.*/
		
		
		/*/*****1. 이벤트처리하는 첫번째 방법(어나니머스인터페이스(주로사용하는방법))->가독성이좋다(바로 어떤메소드로어떻게수행되는지 볼 수 있으니까)**
		 * 이게 사용되어지는 순간 객체가 생성됨 .ActionListener 객체가 갖고있는 핸들러의 주소를 갖고있음
		 * 2번방법을 사용하기위해 implements를 해놓아서 얘는 결국 핸들러메소드 객체를 두개갖고있는건데 쓰는건 새로생성한 객체를 이용하게 됨
		leftBtn.addActionListener(new ActionListener(){ //미구현된것을 여기서 오버라이딩
			public void actionPerformed(ActionEvent e){
				outputLabel.setText("<=Button click");
			}
		}); */ 
		
		
		/****2. this를 이용한 방법(내부참조) ->implements해서 내부에 메소드를 구현하는 방법***
		 * 여기서 객체는 내부참조한 것이기때문에 자기의 객체 주소를 갖고있음
		 * ->>>가독성이 떨어짐 ->>>다같이 작업할때주로 사용
		leftBtn.addActionListener(this);
		rightBtn.addActionListener(this);
		/*핸들러메소드를 갖고이쓴 객체를 this로 넘겨줬다. ->핸들러메소드가 내부에 있다는 뜻
		 * this는 내부참조할때 자기가 있는 객체의 주소값을 갖고있음 그러니까 그 객체안에 이걸 수행할 메소드가 있어야
		 * 사용할 수 있는 방법! 지금 클래스를 implements ActionListener (인터페이스)하면 
		 * actionPerformed() (abstract 메소드)를 구현할 수 있다. 
		 * 소유안하고 있으면 빨간줄 뜸 ->아래서 actionPerformed()를 구현하고 있다. */
		
		
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
		
		leftBtn.addActionListener(actionHandler);
		rightBtn.addActionListener(actionHandler);
		
		setBounds(100,100,300,200);
		setVisible(true);
	}
	
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
}

public class ActionEventEx {

	public static void main(String[] args)
	{
		new ActionEventC("ActionEventTest1");
	}
}
