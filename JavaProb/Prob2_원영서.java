package day3;

public class Prob2 {
	public static void main(String[] args) {

		/*
		 * 다음은 대문자를 소문자로 변경하는 코드입니다. 변수 ch에 저장된 문자가 대문자 인 경우에만 소문자로 변경하는 코드를 완성
		 * 합니다.
		 */
		char ch = 'P';
		char lowerCase = (ch >= 'A' && ch <= 'Z') ? (char) (ch + 32) : ch;
		System.out.print("ch:" + ch);
		System.out.println(" to lowerCase :" + lowerCase);

		int num = -90;
		String result = (num>0)?"양수":(num<0?"음수":"0");
		System.out.println(result);
	}
}
