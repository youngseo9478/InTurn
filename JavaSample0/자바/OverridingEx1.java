package day30;
/*
 * <오버라이딩>
 * 
 * */

class CellP
{
	public void sendSMS(String number, String msg)
	{
		System.out.println(number+"에게"+msg+"를 보냅니다.");
	}
}

//스마트폰에서는 메세지를 보낼 때 사진, 동영상, 파일도 보낼 수가 있음
class SmartP extends CellP
{
	String fileName;	//메소드 안에 넣으면 에러남.. 왜?
	
	//메세지만 보내는 것에서 파일도 첨부할 수 있게 기능을 추가했다. ->'재정의'
	public void sendSMS(String number, String msg)	//옆에 초록색 삼각형에 overrides day30.CellP.sendSMS 이렇게 뜸! 상속받은 클래스를 오버라이딩했다는것~
	{
		System.out.println(number+"에게"+msg+"를 보냅니다.");
		System.out.println(fileName+"파일을 첨부합니다.");
		
	}
}

public class OverridingEx1 {

	public static void main(String[] args)
	{
		SmartP sp = new SmartP();
		sp.fileName = "Java_education.txt";
		sp.sendSMS("010-7878-8989", "오늘은 즐거운 금요일입니다.");
	}
}
