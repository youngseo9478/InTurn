package day3_7;

/*예외처리
 * exception = 오류
 * error는 굉장히 큰 문제발생한것.프로그램이 컨트롤할 수 있는 부분이 아님 -> 배제
 * 
 * exception : 이러한 일들이 발생했을 때 대처할 방법을 나타내는 것
 * 1.일반적 exception : 코더의 잘못보다 외부환경에 의해 잘못되어진 것.
 * 	대표적인 예) 해당 파일에서 값 가져오랬는데 파일이 없는 경우->프로그램 죽음
 * 2.실행시 exception : 코더들이 잘못하는 것
 * 
 * 예외처리를 해줌으로써 프로그램에 대한 신뢰성을 유지시켜준다.
 * 에러가 났다고 프로그램을 종료시켜버리는 것이 아니라 때에 따라 알맞은 대처를 한다.
 * -> try{}catch{} 사용
 * *try catch 주의사항
 * try문장안에는 exception일어날 부분만 넣어야 한다.*/
import static java.lang.System.out;

public class ExceptionEx1 {

	public static void main(String[] args) {
		int[] var = { 10, 200, 30 };
		for (int i = 0; i <= 3; i++) {
			try {//예외처리를 안하면 프린트 값은 찍지만 마지막 문장인 프로그램 끝은 찍히지 않고 var[3]에 값을 넣으려는 순간 에러가 뜨면서 종료된다.
				//예외처리를 하면 에러에 대처한 후에 마지막 문장까지 수행하게 된다.
				out.println((i+1)+"번째");
				out.println("var[" + i + "] : " + var[i]); //여기서 에러 발생하면 exception이 잡아서 아래 ~~~ 도 실행 안하고 try밖의 문장만 실행한다.
				out.println("~~~~~~~~~~~~~~~~~~");
			} catch (ArrayIndexOutOfBoundsException ae) {
				out.println("Array Overflow");
			}
		} // for문 끝
		out.println("프로그램 끝!");
	}
}
