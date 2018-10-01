package graphicUI;
import java.awt.*;
public class FlowLayoutEX1 {

	public static void main(String[] args)
	{
		Frame f = new Frame("FlowLayout 테스트");
		Panel p = new Panel();
		p.setLayout(new FlowLayout(FlowLayout.CENTER)); //생략가능 패널은 플로우레이아웃이 디폴트
		
		Button b1 = new Button("버튼1");
		Button b2 = new Button("버튼2");
		Button b3 = new Button("버튼3");
		Button b4 = new Button("버튼4");
		Button b5 = new Button("버튼5");
		
		//add는 넣어주는 순서에 따라 자리가 정해진다
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);
		
		f.add(p);
		
		f.setLocation(300,300);
		f.setSize(200, 100);
		f.setVisible(true);
	}
}
