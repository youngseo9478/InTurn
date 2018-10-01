package day29;
/*오버로딩 = 다중정의
 * 오버로딩은 모든 객체지향 언어에서 사용하므로 개념을 확실히 해두는게 좋다
 * 같은 기능을 갖는 메소드를 서로 다른 타입의 매개변수를 넣어도 실행되도록 다중으로 정의해주는 것
 * 나중에 프로젝트를 하다보면 사용되는 클래스, 매소드등이 매우 많아짐 그때마다 모든 메소드명을 기억하기는 너무 어려움 그래서 이름을 갖게하고 매개변수부분만 다르게 해주면 
 * 같은 이름으로 모든 기능을 할 수 있다.
 * 들어가는 타입에 따라, 매개변수의 개수에 따라, 그 매개변수의 순서에 따라 모두 정의하여 같은 함수 이름으로 이용할 수 있다.*/
public class OverloadingEx1 {
	
	public static void getLength(int i)
	{
		String str = String.valueOf(i);
		System.out.println(i+"의 문자열 길이 :" +str.length());
	}
	
	public static void getLength(float f)
	{
		String str = String.valueOf(f); //valueOf는 static 타입!(오버로딩되어있음) 오라클에서 확인가능
		System.out.println(f+"의 문자열 길이 :" +str.length());
	}
	
	public static void getLength(String str)
	{
		System.out.println(str+"의 문자열 길이 :" +str.length());
	}
	
	public static void getLength(int i, float f)		//두개의 매개변수를 갖는 메소드도 오버로딩으로 만들 수 있다.
	{
		String str = String.valueOf(i);
		System.out.println(i+"의 문자열 길이 :" +str.length());
		
		String str2 = String.valueOf(f);
		System.out.println(f+"의 문자열 길이 :" +str2.length());
	}
	
	public static void getLength(float f,int i)	//(정수,실수)였는지 (실수,정수)였는지 순서가 헷갈릴 수 있기때문에 순서가 반대가되도록 정의해주면 모든 경우에 사용 가능!
	{
		String str = String.valueOf(i);
		System.out.println(i+"의 문자열 길이 :" +str.length());
		
		String str2 = String.valueOf(f);
		System.out.println(f+"의 문자열 길이 :" +str2.length());		//str2.length()인거 헷갈리지 말기!
	}
	
	public static void main(String[] args)
	{
		getLength(3432.323f);
		getLength("abcdefghijk");
		getLength(1003);
		getLength(322,857.4f);
		getLength(935.5435f,1222);
	}

}
