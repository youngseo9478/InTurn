package day10_7;
/*
 * runnable interface는 run() 갖구 있음
 * implements 시켜서 
 * 클래스에서 run()을 구현해서 할일을 던져줌*/
public  class SingleRunnableEx implements Runnable{

	private int temp[];
	
	public SingleRunnableEx()
	{
		temp = new int[10];
		for(int start = 0; start<10; start++)
		{
			temp[start] = start;
		}
	}
	
	public void run() {
		for(int start : temp)
		{
			try{
				//현재 이  프로그램의 스레드를 멈추는 것이 아니라 현재 run을 구동중인 스레드를 멈추는 것. 
				Thread.sleep(1000);
			}catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
			System.out.printf("스레드 이름 : %s,", Thread.currentThread().getName());
			System.out.printf("temp value : %d %n",start);
		}
	}
	
	public static void main(String[] args)
	{
		//SingleRunnableEx 클래스의 객체를 생성한 다음 
		SingleRunnableEx srt = new SingleRunnableEx();
		//Thread 객체를 생성해서 SingleRunnalbleEx 객체를 던져준다.
		Thread t = new Thread(srt,"첫번째");
		t.start();
	}
}
