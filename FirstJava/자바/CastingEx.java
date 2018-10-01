package com.ex;

public class CastingEx {
	public static void main(String[] args)
	{
		int aValue = 10;
		float fValue = 3.3f;
		int result = (int)(aValue + fValue); //원래는 13.3인데 int형으로 표현해야해서 .3손실됨
		System.out.println(result);
		
		short s1=5;
		short s2=7;
		short s3=(short)(s1+s2);	//사칙연산거치면 값이 int형으로 바뀌니까 short형에 담을 수 없어서 앞에(short)형이라고 casting해주는것!
		System.out.println(s3);
	}

}
