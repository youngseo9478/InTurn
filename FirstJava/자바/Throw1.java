package day3_7;

/*throw는 강제로 exception을 발생시키는 명령어*/
public class Throw1 {
	public static void main(String[] args) {
		try {
			throw new NumberFormatException();
			// 강제로 예외발생시키는 것 throws를 사용해도 이부분이 생략된것.
		} catch (NumberFormatException ne) {
			System.out.println("^^");
		}
	}
}
