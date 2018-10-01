package day27;

public class ControllerEx7 { // 제어문의 꽃 for문->반복문의 일종

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i + "번째 수행");
		}

		System.out.println("================");

		for (int i = 10; i > 0; i--) {
			System.out.println(11 - i + "번째 수행");
		}

		// 1~10까지의 합을 출력하는 프로그램
		int result = 0;

		for (int i = 0; i < 10; i++) {
			result += i; // 이건 수행시간이 긴편 한번에 끝내는 방법이 가우시안 ->n(n+1)/2
							// n이커질수록 for수행시간이 점점 커지는 반면 이 식은 한번만 하면 됨.
		}
		System.out.println("1~10까지의 합 :" + result);
	}
}
