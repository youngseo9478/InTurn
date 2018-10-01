package graphicUI;
import java.awt.*;
import java.awt.event.*;
public class KeyEventEx extends Frame implements KeyListener {

	TextArea ta = new TextArea();
	public KeyEventEx()
	{
		super("KeyEvent TEST");
		add(ta);
		setBounds(300,300,300,300);
		setVisible(true);
		ta.addKeyListener(this);
	}
	public void keyReleased(KeyEvent e)
	{
		ta.append(e.getKeyChar()+"를 놓았습니다.\n");
	}
	public void keyTyped(KeyEvent e)
	{
		ta.append(e.getKeyChar()+"가 입력되었습니다.\n");
	}
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode()==e.VK_DOWN)
		{
			ta.append("Down Key\n");
		}
		if(e.getKeyCode()==e.VK_UP)
		{
			ta.append("Up Key\n");
		}
		if(e.getKeyCode()==e.VK_LEFT)
		{
			ta.append("Left Key\n");
		}
		if(e.getKeyCode()==e.VK_RIGHT)
		{
			ta.append("Right Key\n");
		}
		if(e.getKeyCode()==e.VK_ENTER)
		{
			ta.append("Enter Key\nlabel");
		}
	}
	public static void main(String[] args)
	{
		new KeyEventEx();
	}
}
