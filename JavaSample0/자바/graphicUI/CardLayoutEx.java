package graphicUI;
import java.awt.*;
import java.awt.event.*;
public class CardLayoutEx {

	public static void main(String[] args)
	{
		final Frame f = new Frame("CardLayoutTest");
		final CardLayout card = new CardLayout(10,10);
		f.setLayout(card);
		Panel card1 = new Panel();
		card1.setBackground(Color.orange);
		card1.add(new Label("Card 1"));
		Panel card2 = new Panel();
		card2.setBackground(Color.cyan);
		card2.add(new Label("Card 2"));
		Panel card3 = new Panel();
		card3.setBackground(Color.green);
		card3.add(new Label("Card 3"));
		
		f.add(card1, "1");		//Frame에 card1을 "1"이라고 이름 붙여 추가한다.
		f.add(card2, "2");
		f.add(card3, "3");
		

		class Handler extends MouseAdapter
		{ /*Handler 클래스에서 MouseAdapter를 상속받아서 핸들러 메소드를 사용할 수 있고, 
		원하는 액션을 취하도록 오버라이딩 해주고 있다.*/ 
			public void mouseClicked(MouseEvent e)
			{
				//마우스 오른쪽 눌렀을 때
				if(e.getModifiers()==e.BUTTON3_MASK)
				{
					card.previous(f); //CardLayout의 이전 Panel을 보여준다.
				}
				else
				{
					card.next(f); //CardLayout의 다음 Panel을 보여준다.
				}
			}
		}// class Handler
		
		//상속받아 오버라이딩 했으므로 핸들러 클래스를 바탕으로 객체를 생성하면 핸들러 메소드를 사용할 수 있다.
		card1.addMouseListener(new Handler());
		card2.addMouseListener(new Handler());
		card3.addMouseListener(new Handler());
		
		f.setSize(200,200);
		f.setLocation(200, 200);
		f.setVisible(true);
		card.show(f, "2"); //Frame에 추가된 Component를 이름이 "2"인 것부터 보여준다.
	}
}
