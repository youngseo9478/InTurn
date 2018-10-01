package day10_7;

import javax.swing.JOptionPane;

public class InterruptedEx {

	public static void main(String[] args) throws Exception
	{
		ThreadEx13 th1 = new ThreadEx13();
		th1.start();
		
		String input = JOptionPane.showInputDialog("아무값이나 입력하세요 ");
		System.out.println("입력하신 값은 "+input+"입니다.");
		th1.interrupt(); //interrupt()호출하면 interrupted상태가 true가 된다.
		System.out.println("isInterrupted():"+th1.isInterrupted()); //true
	}
}

class ThreadEx13 extends Thread
{
	public void run()
	{
		int i = 10;
		
		while(i!=0 && !isInterrupted()) //0이아니고,interrupted상태가 아닐때 수행한단 것
		{
			System.out.println(i--);
			/*for(long x=0; x<2500000000L;x++); //시간지연*/
			try
			{
				Thread.sleep(1000);
			}catch(InterruptedException ie){ 
				//interrupted 상태라면(true라면) catch에서 잡히고 {}안의 문장을 수행하게되는데 
				//{}을 수행하고나면 다시 interrupted 상태가 해제되어서 계속 카운트다운이 진행된다.
				//그래서 제대로 인터럽트를 처리하려면 다시 인터럽트를 걸어주어서 true값을 넣어주면 종료하게 된다.
				
				//System.out.println("Interrupted 발생");
				interrupt();
			}
		}
		System.out.println("카운트가 종료되었습니다.");
	}
}
