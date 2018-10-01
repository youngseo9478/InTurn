package day3_7;
/*에러가 나서 프로그램이 종료되더라도 꼭 그전에 저 안에 있는 문장들은 처리해주는 것.
 * 예를 들면 파일은 열었으면 꼭 닫아야하는데 닫지못하고 프로그램이 죽는 상황에서 finally를 이용해서 꼭 처리를 해줄 수 있다.
 * 또는 데이터베이스에서도 유용하다.
 * 마지막에 꼭 실행해주는 부분!! */

import static java.lang.System.out;

public class FinallyEx1 {

	public static void main(String[] args) {
		int[] var = { 10, 200, 30 };
		for (int i = 0; i <= 3; i++) {
			try {
				out.println((i + 1) + "번째");
				out.println("var{" + i + "] :" + var[i]); // var[3]에서 에러가
															// 발생하기때문에 바로 catch로
															// 들어가서 아래 ~~~~는
															// 출력안되고 배열을 넘었습니다부터
															// 출력됨.그리고
															// return되기때문에
															// finally안의문장만을
															// 수행하고 for문을 이후의
															// 프로그램끝이라는 문장은 실행되지
															// 않는다.
				out.println("~~~~~~~~~~~~");
			} catch (ArrayIndexOutOfBoundsException ae) {
				out.println("배열을 넘었습니다.");
				return; // 여기서 프로그램 종료되는 것. 아래 문장도 실행 안하고! 근데 finally안의 문장은
						// 종료되더라도 그전에 꼭 실행함!
			} finally {
				out.println(":::::finally:::::");// 위에서return하고 끝내도 이문장은 출력될 것.
			}
		} // for문 끝
		out.println("프로그램 끝!"); // catch문장에서 return해버렸기때문에 이 문장은 실행되지 않음.
	}
}
