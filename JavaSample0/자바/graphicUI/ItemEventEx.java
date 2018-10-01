package graphicUI;
import java.awt.*;
import java.awt.event.*;
/*익명내부클래스 이용한 것과 this이용한 것 비교해볼 수 있는 코드*/

public class ItemEventEx extends Frame implements ItemListener, ActionListener{

	Panel p1 = new Panel();
	Panel p2 = new Panel();
	TextArea ta = new TextArea(5,20);
	Button exit = new Button("종료");
	Checkbox cb1 = new Checkbox("축구",false);
	Checkbox cb2 = new Checkbox("농구",false);
	Checkbox cb3 = new Checkbox("야구",false);
	Checkbox cb4 = new Checkbox("배구",false);
	
	public ItemEventEx()
	{
		super("ItemEvent 테스트");
		p1.add(cb1);
		p1.add(cb2);
		p1.add(cb3);
		p1.add(cb4);
		
		p2.add(exit);
		
		add("North",p1);
		add("South",p2);
		add("Center",ta);
		setBounds(300,300,300,300);
		setVisible(true);
		exit.addActionListener(this); //addActionListener를 implements해서 이 클래스에 다시 메소드를 오버라이딩
		
		cb1.addItemListener(new ItemListener(){ //익명내부클래스 이용한 이벤트 처리
			public void itemStateChanged(ItemEvent e)
			{
				System.out.println(e.getStateChange());
				System.out.println(ItemEvent.SELECTED);
				System.out.println(ItemEvent.DESELECTED);
				if(e.getStateChange() == ItemEvent.SELECTED)
				{
					ta.append(e.getItem()+"을 선택하셨습니다...\n\n");
				}
				else if(e.getStateChange()==ItemEvent.DESELECTED)
				{
					ta.append(e.getItem()+"을 취소하셨습니다...\n\n");
				}
			}
		});
		
		//this이용한 이벤트 처리(내부에 메소드 오버라이딩)
		cb2.addItemListener(this);
		cb3.addItemListener(this);
		cb4.addItemListener(this);
	}
	
	public static void main(String[] args)
	{
		new ItemEventEx();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		System.exit(0);
	}
	
	public void itemStateChanged(ItemEvent e)
	{
		System.out.println(e.getStateChange());
		System.out.println(ItemEvent.SELECTED);
		System.out.println(ItemEvent.DESELECTED);
		if(e.getStateChange() == ItemEvent.SELECTED)
		{
			ta.append(e.getItem()+"을 선택\n\n");
		}
		else if(e.getStateChange() == ItemEvent.DESELECTED)
		{
			ta.append(e.getItem()+"을 취소\n\n");
		}
	}
}
