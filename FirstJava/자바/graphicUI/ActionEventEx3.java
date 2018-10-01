package graphicUI;

import java.awt.*;
import java.awt.event.*;

public class ActionEventEx3 extends Frame implements ActionListener{

	Label lb;
	Button[] btn = new Button[7];
	Color[] color = {Color.black, Color.blue, Color.cyan, Color.green, Color.magenta,Color.orange, Color.red};
	String[] string = {"black","blue","cyan","green","magenta","orange","red"};
	
	public ActionEventEx3(String str)
	{
		super(str);
		setLayout(new FlowLayout()); //본래 크기만큼의 사이즈만 갖도록 되어있어서 버튼사이즈를 바꾸려면 여러가지를 바꿔줘야한당..ㅎ
		for(int i =0; i<7; i++)
		{ 
			//setForgeround는 글자색을 지정해주는 메소드
			btn[i] = new Button(string[i]);
			btn[i].setForeground(color[i]);
			btn[i].addActionListener(this);
			add(btn[i]);
		}
		setSize(200,200);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Button obj = (Button)e.getSource();
		for(int i= 0; i<7; i++)
		{
			if(obj==btn[i])
			{
				//setBackground는 배경색을 지정해주는 메소드
				this.setBackground(color[i]); //여기서 this는 Frame을 말함 굳이 안써줘도 된다.
			}
		}
	}
	
	public static void main(String[] args)
	{
		new ActionEventEx3("Action 이벤트");
	}
}
