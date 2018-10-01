package com.ex;

public class OperationEx6 {	//shift 연산자 (내가 잘 못하는 거) 시프트하고 빈공간은 0으로 채우는 것. 결국 2의배수 곱하기 나누기랑 같다
	
	public static void main(String[] args)
	{
		int d =1;
		
		int e= d<<3;	//1곱하기 2^3한거랑 같은값! 보통은 한바이트 기준이다(더크게하는 방법도 있다)
		System.out.println(e);
		
		d=4;
		e=d>>1;	//4를 2^1로 나눠준 값! 4/2는 2
		System.out.println(e);
		
	}
}
