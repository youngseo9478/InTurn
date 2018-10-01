package day10_7;

public class ThreadGroupEx {

	public static void main(String args[]) throws Exception {
		ThreadGroup main = Thread.currentThread().getThreadGroup();
		ThreadGroup grp1 = new ThreadGroup("Group1");
		ThreadGroup grp2 = new ThreadGroup("Group2");

		ThreadGroup subGrp1 = new ThreadGroup(grp1, "SubGroup1");

		grp1.setMaxPriority(3); // 스레드 그룹 prt1의 최대우선순위를 3으로 변경ㅎ

		//익명내부클래스로 run을 구현하고있음
		Runnable r = new Runnable() {
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
				}
			}
		}; //세미콜론 잊지말기!!

		Thread th1 = new Thread(grp1, r, "th1");
		Thread th2 = new Thread(subGrp1, r, "th2");
		Thread th3 = new Thread(grp2, r, "th3");

		th1.start();
		th2.start();
		th3.start();

		System.out.println(">>List of ThreadGroup : " + main.getName() + ", Action ThreadGroup : "
				+ main.activeGroupCount() + ", Active Thread : " + main.activeCount());

		main.list();
	}
}
