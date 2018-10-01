package day3_7;
/*try catch문 여러번 사용하는 방법*/

public class ExceptionEx2 {

	public static void main(String[] args) {
		// String strNum = "10";
		// String strNum = "a"; //Exception in thread "main"
		// java.lang.NumberFormatException: For input string: "a"
		String strNum = "0";
		int result = 0;
		try {// strNum에 문자가들어왔을때 예외처리 부분
			int num = Integer.parseInt(strNum);// 문자열을 정수로 바꿔서 받는
			result = 100 / num;
		}/*catch(Exception e){//다형성에서 조상은 자식의 변수를 저장할 수 있음. exception은 상위클래스이기때문에 Number...,Arith..등을 다끌어안고 처리 하게 됨
		// 상위클래스의 예외처리만 하게되는 것.
			//세분화해서 예외처리를 할 때는 하위클래스부터 넣어주어야 하고 그냥 통째로 처리하고싶을 때 위처럼 상위클래스로 사용해줘야함.  
			System.out.println("모든 exception 처리");
		} */catch (NumberFormatException ne) {//catch의 소괄호 안에 있는 것이 에러가 발생되었을때 생생되는 객체 이름
			System.out.println("입력하신 값은 정수가 아닙니다. 다시 입력해 주세요");
		} catch (ArithmeticException ae) { //multi catch
			System.out.println("숫자는 0으로 나눌 수 없습니다.");
		}
		System.out.println("result : " + result);
	}
}
