package day10_7;
/*sleep은 static메소드
 * =>앞에 뭐가 왔든 현재 구동중인 스레드를 대기시킴!*/
public class ThreadAndSleep {

	public static void main(String args[])
	{
		ThreadEx12_1 th1 = new ThreadEx12_1();
		ThreadEx12_2 th2 = new ThreadEx12_2();
		
		th1.start();
		th2.start();
		
		//위에서 start시켜서 멀티스레드 상태이지만 아직 runnable상태이기 때문에 현재 구동중인 스레드는 main!
		try{
			//2초 대기하는데 th1을 대기하라는게 아니! 현재 구동중인 스레드를 대기하란 뜻!
			th1.sleep(2000);  
			//눈으로 보기에는 th1이 가장 늦게 끝날 거 같지만 사실 sleep은 main에 들어간 것이기 때문에 main이 가장 늦게 종료된다
		}catch(InterruptedException ie){}
		
		System.out.print("<<main 종료>>");
	}//main
}

class ThreadEx12_1 extends Thread
{
	public void run()
	{
		for(int i=0; i<300; i++)
		{
			System.out.print("-");
		}
		System.out.print("<<th1 종료>>");
	}//run
}

class ThreadEx12_2 extends Thread
{
	public void run()
	{
		for(int i=0; i<300; i++)
		{
			System.out.print("|");
		}
		System.out.print("<<th2 종료>>");
	}//run
}