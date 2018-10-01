package graphicUI;
/*********GUI**********
 * 그 중에서 Frame (가장많이쓰이는클래스)*/
import java.awt.Frame;
class InheritFrame extends Frame //Frame 상속
{
	public InheritFrame(String str)
	{
		//super는 내부참조할 때 부모생성자를 호출하는 것.
		super(str); //str(타이틀)을 Frame한테 넘겨주는 것
		
		setSize(300,300);
		setLocation(500,500); //위치지정
		setVisible(true);
	}
}
public class FrameEx1 {

	public static void main(String[] args)
	{
		Frame f = new Frame("First Frame");//"First Frame"은 타이틀명 
		f.setSize(400,200); //setSize(width, height) ->단위는 픽셀  400X200픽셀
		f.setVisible(true); //구현한걸 볼 때
		
		new InheritFrame("InheritFrame"); //여기서 객체를 생성해줘야 InheritFrame도 생성이 되는 것.
	}
}
