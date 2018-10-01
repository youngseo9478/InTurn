package com.ex;

public class VariableEx1 {
	public static void main(String[] args)
	{
		char c = 'a';	//문자형 변수 선언
		System.out.println(c);
		System.out.println("c : "+c); //자바에서 +는 문자열을 붗이는것. 자바에서는 변수에 입력값넣으면 이것을 문자열로 내부에서 바꾸게 됨(숫자도마찬가지)
		int b =22;	//정수형 변수 선언
		System.out.println("c:"+c+", b:"+b);

		System.out.printf("%d",  b);  //c언어에서 쓰는 형식도 가능하다
		
		char c2 = 65 ;//문자형인데 왜 숫자를 넣나? -> 65는 아스키코드로 A를 나타낸다. 
		System.out.println("c : " +c2);
		
		boolean bValue;	//논리형 변수 선언
		bValue = true;
		System.out.println(bValue);
		bValue = false;
		System.out.println(bValue);
	}

}
