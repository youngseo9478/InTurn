package day10_7;
/*suspend는 잠시 중단하는건데
 * 교착상태에 빠질 수 있기때문에 사용하지 않음
 * 대신 만들어서 사용할 수 있다.*/


//실행결과는 계속 달라질 것임! 
class RunTimeEx implements Runnable
{
	boolean suspended = false;
	boolean stopped = false;
	
	public void run()
	{
		while(!stopped)//stop되지 않았으면 계속 수행
		{
			if(!suspended)//suspend에 걸렸으면 if안의 문장 수행X ->걸린 시간동안 빙빙 돌게 됨 ->자기가 아니면 다른스레드에게 사용권을 넘겨줘야 진짜 suspend인데 아직부족한 코드!
			{
				System.out.println(Thread.currentThread().getName()); //현재구동중인스레드의 이름
				try{
					Thread.sleep(1000); //현재구동중인 스레드를 1초간 재워두어라->suspend걸어도 1초 쉬었다가 걸리는 것 !! 이걸 해결해준 코드가 suspendEx2
				}catch(InterruptedException ie){}
			}
		}
		System.out.println(Thread.currentThread().getName()+"-stopped");
	}
	
	public void suspend() {suspended = true;}
	public void resume() {suspended = false;}
	public void stop() {stopped = true;}
}

public class SuspendEx {

	public static void main(String [] args)
	{
		RunTimeEx r1 = new RunTimeEx();
		RunTimeEx r2 = new RunTimeEx();
		RunTimeEx r3 = new RunTimeEx();
		
		//RunTimeEx의 객체를 Thread가 받게됨
		Thread th1 = new Thread(r1,"*");
		Thread th2 = new Thread(r2,"**");
		Thread th3 = new Thread(r3,"***");
		
		//총 4개의 스레드가 작동중인것 
		th1.start();
		th2.start();
		th3.start();
		
		try{
			Thread.sleep(2000); //현재구동중인 스레드를 잠재워라 ->메인일 확률이 큼
			r1.suspend(); //th1.suspend()이 아님에 주의!!
			Thread.sleep(2000);
			r2.suspend();
			Thread.sleep(3000);
			r1.resume();
			Thread.sleep(3000);
			r1.stop();
			r2.stop();
			Thread.sleep(2000);
			r3.stop();
		}catch(InterruptedException ie){}
	}
}
