package graphicUI;
import java.awt.*;
import java.awt.event.*;
public class MouseMotionEventEx extends Frame implements ActionListener, MouseMotionListener, WindowListener {


	Label move = new Label("마우스 따라다니기", Label.CENTER);
	Button exit = new Button("종료");
	
	public MouseMotionEventEx()
	{
		setTitle("MouseMotionEvent TEST");
		setLayout(null);
		move.setBounds(100, 50, 150, 20);
		exit.setBounds(250,500,50,30);
		move.setBackground(Color.cyan);
		add(move);
		add(exit);
		setBounds(300,100,500,600);
		setVisible(true);
		
		exit.addActionListener(this);
		addMouseMotionListener(this); //Frame에 붙인 것
		
		addWindowListener(this); //프레임에  붙인 것
	}
	
	public static void main(String[] args)
	{
		new MouseMotionEventEx();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		System.exit(0);
	}
	
	public void mouseMoved(MouseEvent e)
	{
		Point p = e.getPoint();
		move.setLocation(p);
	}
	
	public void mouseDragged(MouseEvent e)
	{
	}

	/*WindowListener 추가로 implements해주면 구현해야하는 핸들러 메소드가 아래처럼 쭉 생성되는데
	 * 꼭 다 구현해야하는 것은 아님 중괄호 안을 비워두면 구현 안하는 것.
	 * 
	 * 근데 사용하는 것 외에도 너무 많으니까 불편하다 ->Event Adapter Class
	 * 이건 내가 필요한 것만 가져다 쓰는게 가능하다 (리스너는 인터페이스니까)
	 * public aa(){} 구현은 안하고 빈괄호만 두는 것.
	 * 필요한 아이만 오버라이딩 시켜서 쓰면 됨*/ 
	public void windowOpened(WindowEvent e) {		
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}
}

