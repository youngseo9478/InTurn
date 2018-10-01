package day27;

import java.util.Scanner;

public class ControllerEx11 { // do while문! 조건식을 확인하기전에 무조건 한번은 수행되는 것. 선처리 후비교

	public static void main(String[] args) {
		int i = 5;
		do {
			System.out.println("무조건 한 번은 실행합니다.");
		} while (i > 6); // 문장의 끝이기 때문에 세미콜론

		int answer = 0;
		answer = (int) (Math.random() * 100) + 1; // Math.random()은 난수를 발생시킴 범위는 (0~0.999...)
													// 여기다 *100하면 (0~99.99...)
													// 여기에 (int)하면 (0~99)값을 만듬
													// 여기다 +1하면 (1~100)난수발생시키는코드!!
		Scanner sc = new Scanner(System.in);
		int input = 0;
		do {
			System.out.println("1~100사이 정수를 입력하세요 > ");
			input = sc.nextInt();
			if (input > answer)
				System.out.println("더 작은 수를 입력하세요");
			else if (input < answer)
				System.out.println("더 큰 수를 입력하세요");

		} while (input != answer); // ****답이 맍지 않으면 계속하라는 뜻 -->즉 정답이면 stop*****

		System.out.println("정답을 맞추셨습니다~~짝짝짝");
	}

}
