package graphicUI;
import java.awt.*;
/*격자형태로 배치하고싶을때*/
public class GridLayoutTest {

	public static void main(String[] args)
	{
		Frame f = new Frame("GridLayoutTest");
		f.setSize(150, 150);
		f.setLayout(new GridLayout(3,2));//3행 2열 테이블을 만든다.

		f.add(new Button("1"));
		f.add(new Button("2"));
		f.add(new Button("3"));
		f.add(new Button("4"));
		f.add(new Button("5"));
		f.add(new Button("6"));
		
		f.setVisible(true);

	}
}
