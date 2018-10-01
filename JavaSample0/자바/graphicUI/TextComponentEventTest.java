package graphicUI;
import java.awt.*;
import java.awt.event.*;

public class TextComponentEventTest extends Frame {

	TextField tf = new TextField();
	TextArea ta = new TextArea();
	
	TextComponentEventTest(String title)
	{
		super(title);
		tf = new TextField();
		ta = new TextArea();
		add(ta, "Center");
		add(tf, "South");
		
		tf.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ta.append(tf.getText()+"\n"); //textArea에 이 문구를 나타내겠다(append)
				tf.setText("");
				tf.requestFocus();
			}
		});
		ta.setEditable(false);
		setSize(300,200);
		setVisible(true);
		tf.requestFocus();
	}
	
	public static void main(String[] args)
	{
		TextComponentEventTest mainwin = new TextComponentEventTest("TextComponentEvent테스트");
	}
}
