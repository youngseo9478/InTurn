package graphicUI;

/**********Canvas************/
/* paint()->그림을그릴수있도록해줌->프레임에도 있는 메소드로 화면에 뿌려지기 직전에 수행되는 메소드
 * update()->
 * drawString() 문자를 그리는 것
 * drawOval() 원그리는것
 * setColor() 색
 * fillOval() 위의색으로 채운 원
 * drawLine() 선그리는
 * fillRoundRect(a,b,c,d,e,f) (a,b)포인트에 (c,d)크기의 사각형그리고 (e.f)위치에서 원을 그린다 ->모서리가둥근사각형
 * polygon 배열 두개 써서 다각형 그리는 것 
 * fillArc
*/
import java.awt.*;//awt까지만 가져오는것이지 하위까지는 가져오지 않음 
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GraphicsEx1 extends Frame {

	public static void main(String[] args) {
		new GraphicsEx1("GraphicsEx1");
	}

	//옆에 초록색 삼각형 표시는 오버라이딩을 의미 Frame도 원래 paint()갖고있는데 다시 정의한 것 
	//원래 Visible()찍기 직전에 paint()실행되서 그림그려짐
	public void paint(Graphics g) {
		g.setFont(new Font("Serif", Font.PLAIN, 15));
		g.drawString("Graphics를 이용해서 그림을 그립니다.", 10, 50);

		g.drawOval(50, 100, 50, 50);
		
		g.setColor(Color.blue); //색을 한번 정해주면 새로 정의되기전까지는 같은 색으로 그림을 그린다.
		g.fillOval(100, 100, 50, 50);

		g.setColor(Color.red);
		g.drawLine(100, 100, 150, 150);
		g.fillRoundRect(200, 100, 120, 80, 30, 30);
		
		g.setColor(Color.orange);
		g.fillPolygon(new int[] { 50, 100, 150, 200 }, new int[] { 250, 200, 200, 250 }, 4);
		
		g.setColor(Color.cyan);
		g.fillArc(250, 200, 100, 100, 0, 120);
	}

	// 프레임의 X버튼눌러도 꺼지지 않았던거 꺼지게하는 것 =>이벤트처리 나중에 배울것
	public GraphicsEx1(String title) {
		super(title);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		setBounds(100,100,400,300);
		setVisible(true);
	}
}
