package day10_7;

/*메인스레드랑 서브스레드랑 동등함
 * 메인스레드가 죽어도 서브스레드가 할일이 남아있으면 계속 수행함
 * 메인이 끝나면 서브스레드도 죽게할때는 Demon 사용 
 * 부가적인기능의 스레드를 사용해서 만들겠다->메인스레드 끝나면 자동으로 꺼지게*/
public class DemonThreadEx implements Runnable {

	static boolean autoSave = false;

	public static void main(String args[]) {
		Thread t = new Thread(new DemonThreadEx());
		t.setDaemon(true); //메인스레드가 끝나면 서브스레드도 끝내는 것.
		t.start(); // t, main 스레드 두개가 동시에 돌고 있게됨

		for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
			}
			System.out.println(i);

			if (i == 5) {
				autoSave = true;
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}//main
	
	public void run()
	{
		while(true)
		{
			try{
				Thread.sleep(3*1000); //3초마다
			}catch(InterruptedException ie){}
			
			if(autoSave)
			{
				autoSave();
			}
		}
	}//run
	
	public void autoSave()
	{
		System.out.println("작업파일이 자동저장되었습니다.");
	}
}
