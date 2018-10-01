package day10_7;
/*awt와 swing의 차이는 앞에 J가 붙는거..
 * 
 * progressBar(0,1000) 0~1000까지 진행상황나타내는 것
 * setValue(0)->진행상황을 0부터 나타내겠단 뜻*
 * setEnabled() ->버튼 한번 눌렀으면 비활성화 시키는 것 ->한번눌렀으면 다시 안눌리게 -> 끝나면 다시 활성화!
 * pack()사이즈를 딱맞춰서 넣으라는 뜻*/

import java.awt.event.*;
import javax.swing.*;
public class MultiThreadProgressEx extends JPanel implements ActionListener 
{
	private JProgressBar progressBar1, progressBar2;
	private JButton startButton;
	public MultiThreadProgressEx()
	{
		startButton = new JButton("Start");
		startButton.addActionListener(this);
		
		progressBar1 = new JProgressBar(0,1000);
		progressBar2 = new JProgressBar(0,1000);
		
		progressBar1.setValue(0);
		progressBar1.setStringPainted(true);
		
		progressBar2.setValue(0);
		progressBar2.setStringPainted(true);

		JPanel panel = new JPanel();
		panel.add(startButton);
		panel.add(progressBar1);
		panel.add(progressBar2);
		
		add(panel);
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	}
	
	//MultiThreadProgressEx에다가 ActionListener를 implements했으니까 여기서 구현을 완벽하게 해줘야 하는 것
	public void actionPerformed(ActionEvent evt)
	{
		//한번 버튼 눌렀으면 진행상황 끝날 때까지 버튼 비활성화(false)
		startButton.setEnabled(false);
		
		ProgressBarThread p1 = new ProgressBarThread(progressBar1, startButton);
		ProgressBarThread p2 = new ProgressBarThread(progressBar2, startButton);
		
		p1.start();
		p2.start();
	}
	
	public static void main(String[] args)
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("MultiThreadProgressEx");
		
		//닫기버튼누르면 닫히게
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//MultiThreadProgressEx에 구현해놓은 버튼과 패널등을 객체를 생성해서 만들고 frame에 넣어줌
		MultiThreadProgressEx pbd = new MultiThreadProgressEx();
		frame.add(pbd);
		frame.pack();
		frame.setVisible(true);
	}
}

class ProgressBarThread extends Thread
{
	private JProgressBar jpb;
	private JButton jb;
	
	public ProgressBarThread(JProgressBar jpb, JButton jb)
	{
		this.jpb = jpb;
		this.jb = jb;
	}
	
	//스레드를 상속받아 오버라이딩!
	public void run()
	{
		int current = 0;
		while(current <= 1000)
		{
			current += Math.random()*100; //0~99까지
			jpb.setValue(current);
			try{
				sleep(100);
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
		}
		//끝났으면 버튼 다시 활성화
		jb.setEnabled(true); 
	}
}
