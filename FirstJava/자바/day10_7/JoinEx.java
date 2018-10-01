package day10_7;

//멀티스레드
class MyRunnableTwo implements Runnable
{
	public void run()
	{
		System.out.println("run");
		first();
	}
	
	public void first()
	{
		System.out.println("first");
		second();
	}
	
	public void second()
	{
		System.out.println("second");
	}
}

public class JoinEx {
	public static void main(String[] args)
	{
		System.out.println(Thread.currentThread().getName()+" start");
		Runnable r = new MyRunnableTwo();
		Thread myThread = new Thread(r);
		myThread.start();
		
		//try이 문으로 join을 쓰지 않았다면 출력이 main start, main end, run, first, second순이었을 것
		//왜냐하면 myTread.start();하고 멀티 스레드가 runnable상태에 돌입해 있을 때 main스레드는 다음 한줄 정도는 바로 실행되기때문에
		//end가 먼저 찍히게 되는 것이다. (만약에 main에서 다음에 실행되야하는 문장이 많았다면 이와같이 작동하지 않았을 것)
		try{
			//join은 CPU를 뺏어서 자기 스레드를 모두 수행시킨 다음에 다른 스레드를 실행하게 된다.
			myThread.join();
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" end");
	}

}
