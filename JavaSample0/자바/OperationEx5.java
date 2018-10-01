package com.ex;

public class OperationEx5 {	//비트연산자
	public static void main(String[] args)
	{
		int a=7;
		int b=3;
		
		int result = a&b;
		System.out.println(result);
		
		result = a|b;
		System.out.println(result);
		
		result = a^b;	//exclusive or XOR연산은 ^
		System.out.println(result);
		
	}
}
