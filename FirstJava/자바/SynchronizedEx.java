package day10_7;
/*synchronized
 * 는 메소드나 특정 블록에 사용할  수 있다.
 * 
 * */
class ATM implements Runnable
{
	private long depositeMoney = 10000;
	
	public void run()
	{
		synchronized (this)//지금 들어온 스레드 하나가 이 안의 문장들을 다 수행하기 전까지 다른 스레드는 runnable상태로 대기한다.
		{
			for(int i=0; i<10; i++)
			{
				try
				{
					Thread.sleep(1000);
				}catch(InterruptedException ie)
				{
					ie.printStackTrace();
				}
				if(getDepositeMoney() <=0)
				{
					break;
				}
				withDraw(1000);
			}
		}
	}
	
	public void withDraw(long howMuch)
	{
		if(getDepositeMoney() > 0)
		{
			depositeMoney -= howMuch;
			System.out.print(Thread.currentThread().getName()+" , ");
			System.out.printf("잔액 : %,d 원 %n", getDepositeMoney());
		}
		else
		{
			System.out.print(Thread.currentThread().getName()+" , ");
			System.out.println("잔액이 부족합니다.");
		}
	}
	
	public long getDepositeMoney()
	{
		return depositeMoney;
	}
}


public class SynchronizedEx {

	public static void main(String[] args)
	{
		ATM atm = new ATM();
		//atm 객체를 mother, son이 공유하여 사용하는 구조! 그래서 synchronized가 필요함
		Thread mother = new Thread(atm,"mother");
		Thread son = new Thread(atm,"son");
		mother.start();
		son.start();
		
	}
}
