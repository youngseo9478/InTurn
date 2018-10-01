package com.ex;

public class OperationEx8 { //조건연산자
	public static void main(String[] args)
	{
		int a =5;
		int b=3;
		
		char c =a>b? 't':'f';	//삼항조건식 a가b보다 커서 참이므로 't'문장을 변수 c에다 넣어주게됨
		System.out.println(c);		//하지만 삼항조건식은 가독성이 떨어지기때문에 팀프로젝트에서는 좋지 않다...(남발금지..)
		
		c = a<b? 't': 'f'; 
		System.out.println(c);
	}
}
