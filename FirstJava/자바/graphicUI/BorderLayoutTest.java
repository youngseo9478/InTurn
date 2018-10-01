package graphicUI;
/*이미 영역이 나눠져있음 5군데로.
 * */
import java.awt.*;
public class BorderLayoutTest {

	public static void main(String[] args)
	{
		Frame f = new Frame("BorderLayoutTest");
		f.setSize(200, 200);
		//Frame은 기본적으로 보더레이아웃을 디폴트로 갖고있으므로 따로 설정하지 않아도 됨
		f.setLayout(new BorderLayout());
		Button north = new Button("North");
		Button south = new Button("South");
		Button west = new Button("West");
		Button east = new Button("East");
		Button center = new Button("Center");
		
		//Frame의 5개의 각 영역에 버튼을 하나씩 추가한다.
		f.add(north, "North"); //f.add("North",north);와 같이 쓸 수도 있다.
		f.add(south, "South");	//South의 대소문자 정확히
		f.add(west, "West");	//East 대신, BorderLayout.EAST 사용 가능
		f.add(east, "East");
		f.add(center,"Center");
		
		f.setVisible(true);
	}
}
