package day27;

public class ControllerEx1 { //if 조건문
	public static void main(String[] args)
	{
		int value = 80;
		if(value>70)
		{
			System.out.println("value의 값이 70보다 크다.");
		}
		
		if(value>90)	//괄호안에있는 조건문이 참이면 if괄호안을 수행하고 거짓이면 나가진다.
		{
			System.out.println("value의 값이 90보다 크다.");
		}
		
		else System.out.println("value의 값이 90보다 작다.");	//이경우에는 참 거짓밖에 없기때문에 else은 생략해도 똑같은 결과
		
		
	}
}
