package day10_7;
//멀티스레드는 동시에 여러개의 스레드가 수행되고있는것이라는걸 명심하기! 
//스케쥴러에 의해서 run순서가 정해지기때문에 계속 결과가 달라짐 sleep해놓은 시간과 wait notify되는 순간과
//또 그사이에 sleep되엉ㅆ는 아이가 꺠는 타이밍 등등에 따라 결과가 달라짐 
//시간차에 의해서 보이는게 달라지는 것 뿐 각각의 스레드는 자신의 sleep시간에 맞춰서 행동하고있는 중!
//wait되었다가 notify되는 순간 다시 수행됨....


/**************Wait와 Notify메소드 사용하는 방법***************
 * 멀티스레드이면서 임계영역을 공통으로 사용할 경우에는 중복적으로 값이 삽입/삭제
 * 되거나 혹은 꼬이는 문제가 빈번하게 발생한다.
 * 이를 방지하게위해서 synchronized를 사용해서 Lock을 걸어주게되는데
 * 하나의 스레드가 모든 문장을 수행할때까지 잡고있는 경우 원하는 값을 얻지 못하게 
 * 되는 경우가 많다. 그래서 wait와 notify를 이용해서 적절한 때에 적절한
 * 코드가 수행되도록 만들어 줄 수 있다.*/

/**************************************
 * 음식데이터를 문자열 타입의 배열리스트로 받을 것이다.*
 * ************************************/
import java.util.ArrayList;



/********************************
 * <Customer1 : 고객>
 * Table : 음식을 올려놓는 용도
 * food : 테이블에 올리려는게 어떤 음식인지
 ********************************/
class Customer1 implements Runnable {
	private Table table;
	private String food;

	Customer1(Table table, String food) {
		this.table = table;  
		this.food  = food;
	}

	/***스레드가 어떤 행동을 할 지 정의해주는 메소드***/
	public void run() {
		while(true) { //먹는 간격에 0.1초 간격을 주고 재워놓기때문에 한번먹고 cook이올수도있고 다른 고객이 먹을 수도 있는 것...시간차에따라 완전히다른결과
			try { Thread.sleep(100);} catch(InterruptedException e) {}
			/*현재 구동중인 스레드의 이름을 name에 대입*/
			String name = Thread.currentThread().getName();
			
			/*테이블 객체의 remove메소드를 이용하여 지정된 food를 먹어 없앰*/
			table.remove(food);
			System.out.println(name + " ate a " + food);
		} // while
	}
}


/********************************
 * <Cook : 요리사>
 * Table : 음식을 올려놓는 용도
 * food : 테이블에 올리려는게 어떤 음식인지
 ********************************/
class Cook implements Runnable {
	private Table table;
	
	Cook(Table table) {	this.table = table; }

	public void run() {
		while(true) {
			int idx = (int)(Math.random()*table.dishNum());
			table.add(table.dishNames[idx]);
			try { Thread.sleep(10);} catch(InterruptedException e) {}
		} // while
	}
}



/********************************
 * <Table : 손님께 음식을 올리는 곳>
 * Table : 음식을 올려놓는 용도
 * food : 테이블에 올리려는게 어떤 음식인지
 ********************************/
class Table {
	String[] dishNames = { "donut","donut","burger" }; // donut의 확률을 높인다.
	final int MAX_FOOD = 6;
	private ArrayList<String> dishes = new ArrayList<>();

	public synchronized void add(String dish) {
		while(dishes.size() >= MAX_FOOD) {
				String name = Thread.currentThread().getName();
				System.out.println(name+" is waiting.");
				try {
					wait(); // COOK쓰레드를 기다리게 한다.
					Thread.sleep(500);
				} catch(InterruptedException e) {}	
		}
		dishes.add(dish);
		notify();  // 기다리고 있는 CUST를 깨우기 위함.
		System.out.println("Dishes:" + dishes.toString());
	}

	public void remove(String dishName) {

		synchronized(this) {	
			String name = Thread.currentThread().getName();

			while(dishes.size()==0) {
					System.out.println(name+" is waiting.");
					try {
						wait(); // CUST쓰레드를 기다리게 한다.
						Thread.sleep(500);
					} catch(InterruptedException e) {}	
			}

			
			while(true) {
				for(int i=0; i<dishes.size();i++) {
					if(dishName.equals(dishes.get(i))) {
						dishes.remove(i);
						notify(); // 잠자고 있는 COOK을 깨우기 위함 
						return;
					}
				} // for문의 끝

				try {
					System.out.println(name+" is waiting.");
					wait(); // 원하는 음식이 없는 CUST쓰레드를 기다리게 한다.
					Thread.sleep(500);
				} catch(InterruptedException e) {}	
			} // while(true)
		} // synchronized
	}

	public int dishNum() { return dishNames.length; }
}

class ThreadWaitEx3 {
	public static void main(String[] args) throws Exception {
		Table table = new Table();

		new Thread(new Cook(table), "COOK1").start();
		new Thread(new Customer1(table, "donut"),  "CUST1").start();
		new Thread(new Customer1(table, "burger"), "CUST2").start();
	
		Thread.sleep(10000); //총 프로그램이 돌아가는 시간을 10초로 둔것
		System.exit(0);
	}
}
