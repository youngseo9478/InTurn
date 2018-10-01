package com.ex;

public class OperationEx4 { //논리연산자는 논리값을 리턴한다.

	public static void main(String[] args)
	{
		int a=22;
		int b=20;
		int c=10;
		
		boolean d  = a>b && a>c;
		System.out.println(d);
		
		d = b>c && a<c;
		System.out.println(d);
		
		d = b>c || a<c;
		System.out.println(d);
		
		d = a<b || a<c;
		System.out.println(d);
		
		System.out.println(!d);	//!는 반대값을 의미
	}
}
