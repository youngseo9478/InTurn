package com.ex;

public class VariableEx2 {		// 정수형 변수 byte, short, int, long 연습

	public static void main(String[] args)
	{
		byte bValue = 122; //1byte
		System.out.println("bValue="+bValue);
		
		/*bValue = 128;
		System.out.println("bValue="+bValue);*/  //이거는 에러남 1바이트는 -128~127까지만 가능! 범위를 벗어난것임 short으로는 가능
		
		short sValue = 128; //2byte
		System.out.println("sValue="+sValue);
		
		//sValue = 40000;	이거도 불가능 short는 2바이트니까
		
		int iValue =40000;  //4byte
		System.out.println("iValue="+iValue);
		
		//iValue=50000L; 여기서 대문자 L은 롱을 뜻함 iValue가 int형인데 롱으로 표현하라고하니까 에러 
		
		long lValue = 50000L;  //8byte
		System.out.println("lValue="+lValue);
		
		short a = 10;
		short b = 20;
		//short c= a + b; //값이 벗어나지 않았는데 에러가 뜸.. 사칙연산을 하면 int형으로 바뀜 int로 바뀐건 short에 들어가지지않음!! 주의!
		
		short c = (short)(a+b); //이렇게 하면 short형으로 표현하는거로 바껴서 가능 ->그치만 보통은 그냥 int형으로 선언하는게 좋음
	}
}
