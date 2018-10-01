package day10_7;
/*********Tread************
 * life cycle이 있다.*/

public class SingleThreadEx1 extends Thread {

	private int[] temp;
	public SingleThreadEx1(String threadname)
	{
		super(threadname);
		temp = new int[10];
		for(int start=0; start<temp.length;start++)
		{
			temp[start] = start;
		}
	}
	
	//Thread 클래스에 있는 run()을 오버라이딩해서 이 클래스에서 실행하고 싶은 걸 정의해줌
	public void run()
	{
		for(int start : temp)
		{
			try{
				sleep(1000); //sleep(천분의1초) ->즉 여기서 1초를 잠시 쉬겠다는 뜻인데 try, catch문이 필요하다! 쉬는 동안에 CPU를 뺏길 수 있기 때문
			}catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
			//currentThread()는 현재 실행중인 Thread를 의미하고 getName()을 통해 그 Thread의 이름을 받아오는 것.
			System.out.printf("스레드 이름 : %s,",currentThread().getName());
			System.out.printf("tmp value : %d %n", start);
		}
		System.out.println("스레드 종료");
	}
	
	public static void main(String[] args)
	{
		SingleThreadEx1 st = new SingleThreadEx1("첫번째");
		st.start(); //runnable상태로 대기 했다가 스케쥴러에 의해 실행되면 run()을 수행함.
	}
}
