package day10_7;
/*앞의 Suspend도 완전히 문제가 없는 코드가 아님
 * 객체지향적으로 바꿔줄 수 있다.
 * */
class SuspendEx2_2 implements Runnable
{
	boolean suspended = false;
	boolean stopped = false;
	
	Thread th;
	
	SuspendEx2_2(String name)
	{
		th = new Thread(this, name); //Thread(Runnable r, String name)
		//여기서 this는 Runnable의 run()을 가리켜 수행할 수 있도록 하기위해 사용한 것.
	}
	
	public void run()
	{
		String name = th.getName();
		
		while(!stopped)
		{
			if(!suspended)
			{
				System.out.println(name);
				try{
					Thread.sleep(1000);
				}catch(InterruptedException ie){
					System.out.println(name+" - interrupted");
				}
			}else{
				Thread.yield();
			}
		}
		System.out.println(name+" - stopped");
	}
	
	public void suspend()
	{
		suspended = true;
		th.interrupt(); //isInterrupted상태가 true가 된다
		System.out.println(th.getName()+" - interrupt() by suspend()");
	}
	
	public void resume()
	{
		suspended = false;
	}
	
	public void stop()
	{
		stopped = true;
		th.interrupt();
		System.out.println(th.getName()+" - interrupt() by stop()");
	}
	
	public void start()
	{
		th.start();
	}
}

public class SuspendEx2
{
	public static void main(String[] args)
	{
		SuspendEx2_2 th1 = new SuspendEx2_2("*");
		SuspendEx2_2 th2 = new SuspendEx2_2("**");
		SuspendEx2_2 th3 = new SuspendEx2_2("***");
	
		th1.start();
		th2.start();
		th3.start();
		
		try{
			Thread.sleep(2000);
			th1.suspend();
			Thread.sleep(2000);
			th2.suspend();
			Thread.sleep(3000);
			th1.resume();
			Thread.sleep(3000);
			th1.stop();
			th2.stop();
			Thread.sleep(2000);
			th3.stop();
		}catch(InterruptedException ie){}
	}
}