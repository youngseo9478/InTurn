package day3_7;

class UserException extends Exception {
	int port;

	public UserException(String msg) {
		super(msg); // UserException의 조상인 Exception에게 에러발생시킨 객체를 보내는 것..?
	}

	public UserException(String msg, int port) // 오버로딩해준 것.(다중정의)
	{
		super(msg);
		this.port = port;
	}

	public int getPort() {
		return port; // 포트 넘버를 넘겨주는 메소드
	}
}

public class UserException1 {
	public void testException(String str) throws UserException // 예외가 발생되었을때 얘를
																// 호출한 메소드에게 에러를
																// 내던지는 것.
	{
		if (str.length() >= 1) {
			System.out.println("전달받은 문자열 : " + str);
		} else {
			throw new UserException("전달받은 입력 값이 없습니다.", 8989); // throw는 예외를
																// 발생시키는 것이고 처음엔
																// try catch문을
																// 찾는데 없으면
																// throws찾음
		}
	}

	public static void main(String[] args) {
		UserException1 ue = new UserException1(); // 내가 만든 클래스 객체를 만든 것 끝에 1!
		try {
			ue.testException(""); //여기서 에러가 나는게 아니고 testException에서 에러가 발생한걸
									// 여기서 처리하는 것. 원래는 예외가 발생한곳에서 예외처리를 해야하는데 그
									// 부분에서 try catch가 없었기때문에 throws이용해 책임전가한것
		} catch (UserException e) {
			System.out.println(e.getMessage()); // UserException의 상위클래스인
												// Exception이 갖고 있는 메소드
			System.out.println(e.getPort());
		}

	}
}
