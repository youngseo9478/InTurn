package prob;

import java.util.ArrayList;
import java.util.List;

public class StackTest {
	public static void main(String[] args) {
		Data data = new Data(5);
		Pop1 pop1 = new Pop1(data);
		Push1 push1 = new Push1(data);
		Thread pop = new Thread(pop1, "pop");
		Thread push = new Thread(push1, "push");

		pop.start();
		push.start();
		
		//쓰레드를 이용한 push와 함게 어떻게 동작시켜도 문제 없음(synchronized)
		for (int i = 6; i <= 12; i++) {
			data.push(i);
		}

	}
}

class Data {
	private int size = 0;
	List<Integer> stack = new ArrayList<Integer>(size);
	int top = 0;

	public Data() {
		setSize(10);
	}

	public Data(int i) {
		setSize(i > 0 ? i : 10);
	}

	public synchronized void push(int i) {
		//(리스트는 리사이징이 가능)처음 정한 사이즈 이상은 push하지 않도록 하기 위함
		if (top < size) {
			stack.add(i);
			System.out.println("push : " + i);
			top++;
		} else{
			isFull();
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void pop() {
		if (!isEmpty()) { //비어있지 않다면 계속 pop가능
			System.out.println("pop : " + stack.get(top - 1));
			stack.remove(top - 1);
			top--;
		} else {
			System.out.println("stack is empty!");
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int top() {
		return stack.get(top - 1);
	}

	public boolean isFull() {
		if (top == size) {
			System.out.println("stack is Full!");
			return true;
		} else {
			return false;
		}
	}

	public boolean isEmpty() {
		if (top == 0) {
			return true;
		} else {
			return false;
		}
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}

class Pop1 implements Runnable {
	Data data;

	Pop1() {
	}

	Pop1(Data data) {
		this.data = data;
	}

	@Override
	public void run() {
		for (int i = 1; i <= data.getSize(); i++) {

			data.pop();
		}

	}
}

class Push1 implements Runnable {
	Data data;

	Push1() {
	}

	Push1(Data data) {
		this.data = data;
	}

	@Override
	public void run() {
		for (int j = 1; j <= data.getSize(); j++) {
			data.push(j);
		}
	}
}