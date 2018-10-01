package day10_7;
/*CPU에 대한 접근성과 사용시간에 대해서 우선순위를 주는 것*/

class SuperThreadPriority extends Thread
{
	public SuperThreadPriority(String threadName)
	{
		super(threadName);
	}
	
	public void run()
	{
		for(int i=0; i<100; i++)
		{
			try{
				sleep(500);
			}catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
			System.out.printf("스레드 이름 : %s %n", Thread.currentThread().getName());
		}
	}
}

public class PriorityChangeEx extends SuperThreadPriority{

	public PriorityChangeEx(String threadName)
	{
		super(threadName);
	}
	
	public static void main(String arg[])
	{
		//여기서는 100번쯤 찍어서 둘의 차이가 크게 나타나지 않지만 횟수가 많이 커지면 출력해서 찍었을때 두번째 스레드가 더 많이 사용됨을 확인해볼 수 있다.
		Thread t1 = new SuperThreadPriority("첫번째 스레드");
		t1.setPriority(1); //이렇게 숫자로 넣어도 되고 멤버변수(상수)로 넣어도 되고
		t1.start();
		
		Thread t2 = new SuperThreadPriority("두번째 스레드");
		t2.setPriority(Thread.MAX_PRIORITY);
		t2.start();
	}
}
