package graphicUI;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

/*****Container*****
 * 프레임 안에 또 프레임을 붙이려고 할 때 사용하는 것*/
public class PanelEx1 {

	public static void main(String[] args)
	{

		Frame frame = new Frame("Panel Ex"); 
		frame.setLayout(null);
		frame.setBounds(1000, 100, 500, 500); //setSize, setLocation동시에 해주는 메소드 (x,y,width,height)
		//위치는 상대적인 것이다. 부모 프레임 기준 
		Panel panel = new Panel();
		panel.setBounds(50,50,150,150);
		panel.setBackground(Color.GREEN);
		
		Button btn = new Button("O  K");
		btn.setSize(50,20);
		panel.add(btn); //panel에다가 버튼을 추가해준 것 panel2에는 버튼 없음
		
		Panel panel2 = new Panel();
		panel2.setBounds(200, 50, 150, 250);
		panel2.setBackground(Color.YELLOW);
		
		//panel, panel2를 frame에 추가해주는 것.
		frame.add(panel); 
		frame.add(panel2);
		
		frame.setVisible(true);
	}
}
