package day10_7;

import javax.swing.JOptionPane;

//입력을 하든 말든 카운트 다운을하고 싶어서 멀티스레드를 이용한 것
class CountThread extends Thread {
	public void run() {
		for (int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadEx1 {

	public static void main(String[] args) {
		CountThread cthread = new CountThread();
		cthread.start();
		String input = JOptionPane.showInputDialog("input string");
		System.out.println("inputed str : " + input);
	}
}
