package day18.prob;

import java.util.ArrayList;
import java.util.List;

public class StackTest {
	public static void main(String[] args) {
		MyStack stack = new MyStack(10);
		if (stack.isEmpty()) {
			System.out.println("스택이 비어있습니다.");
		}

		for (int i = 1; i <= 10; i++) {
			stack.push(i);
		}

		if (stack.isFull()) {
			System.out.println("스택이 가득 찼습니다.");
		}

		System.out.println("최상위 숫자 : " + stack.top());
		System.out.println("최상위에서 꺼낸 숫자 : " + stack.pop());
		System.out.println("최상위에서 꺼낸 숫자 : " + stack.pop());
		System.out.println("");
		System.out.println("== 스택 리스트 ==");
		for (int i = 1; i <= 10; i++) {
			int num = stack.pop();
			if (num != -1)
				System.out.println(num);
		}
	}
}

class MyStack {
	private int size = 0;
	List<Integer> stack = new ArrayList<Integer>(size);
	int count = 0;

	public MyStack() {
		setSize(10);
	}

	public MyStack(int size) {
		if (size > 0) {
			setSize(size);
		} else {
			setSize(10);
		}
	}

//	Stack
	public void push(int i) {
//		if (count < getSize()) {
//			num[count] = i;
//			count++;
//		} else {
//			isFull();
//		}
		stack.add(i);
		count++;
	}

	public int top() {
		return stack.get(count-1);
	}

	public int pop() {
		if (isEmpty()) {
			return -1;
		} else {
			int topnum = stack.get(count-1);
			stack.remove(count-1);
			count--;
			return topnum;
		}
	}

	public boolean isFull() {
		if (stack.size()==count) {
			return true;
		}
		return false;
	}

	public boolean isEmpty() {
		if (stack.size()==0) {
			return true;
		}
		return false;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
