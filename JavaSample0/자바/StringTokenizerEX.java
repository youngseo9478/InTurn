package day29;

import java.util.StringTokenizer; //스트링토크나이저 쓰려면 있어야하는 유틸리티

public class StringTokenizerEX {

	//printToken이라는 메소드를 static으로 만들었다. 퍼블릭 클래스의 객체를 생성하지는 않았으니까 static..?
	public static void printToken(StringTokenizer st)
	{ //여기서는 StringTokenizerEx로 객체를 생성한 적이 없다->static으로 하면 1.메모리에 저장이 된다. (2.공통으로 사용될 때)
		
		//hasMoreTokens는 커서 다음 위치에 데이터가 있는지 확인하는 메소드.(API확인)
		//다음 위치에 데이터가 있으면 계속 while문 반복 없으면 나가짐
		while(st.hasMoreTokens())
		{
			String tokenStr = st.nextToken();
			System.out.println(tokenStr)
;		}
	}
	public static void main(String[] args)
	{
		StringTokenizer st1 = new StringTokenizer("Have a good day");
		StringTokenizer st2 = new StringTokenizer("2017/6/29", "/");
		StringTokenizer st4 = new StringTokenizer("2017/6/29", "/",true);
		StringTokenizer st3 = new StringTokenizer("19+28+78+45","+",true);
		
		printToken(st1);
		System.out.println("===============");
		printToken(st2);
		System.out.println("===============");
		printToken(st3);
		System.out.println("===============");
		printToken(st4);
		System.out.println("===============");
	}
}
