package com.ex;

public class OperationEx3 {	//비교연산자는 true, false가 return 값임
	public static void main(String[] args)
	{
		boolean bValue;
		
		int a=10;
		int b=5;
		int c=5;
		
		bValue = a<b;
		System.out.println(bValue);

		bValue = a>b;
		System.out.println(bValue);
		
		bValue = c<=b;
		System.out.println(bValue);
		
		bValue = a>=b;
		System.out.println(bValue);
		
		bValue = a==b;
		System.out.println(bValue);
		
		bValue = a!=b;	//a,b가 서로 다르냐를 묻는 것 
		System.out.println(bValue);
	}

}
