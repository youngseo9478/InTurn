package day27;

public class ControllerEx3 {	//if 조건문 괄호안에 논리연산자 사용하는 방법

	public static void main(String[] args)
	{
		String name ="kim";	//변수명 앞에 String 붙이면 문자열 변수를 만들 수 있다. 쌍따옴표 사용
		int number = 75;
		
		if(number>80 && name =="kim")	//OR하면 둘 중에 하나만 맞아도 if문이 실행된다
		{
			System.out.println(name+"의 점수는"+number);
		}
		else
		{
			System.out.println(name+"의 점수는"+number+"로 탈락");
		}
	}
}
