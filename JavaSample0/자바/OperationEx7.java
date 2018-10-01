package com.ex;

public class OperationEx7 {
	public static void main(String[] args)
	{
		int a=10;
		
		++a;
		System.out.println(a);
		a++;		//대입한 후에 a값이 12로 바뀌기때문에 출력값이 11이라고 생각하지만 그게아니라 (이것은 개념상!)
		System.out.println(a);		//여기서 출력을 요청하기때문에 출력값은 11이 아니라 12다.
		--a;
		System.out.println(a);		//여기 수행하고나면 11인데
		
		System.out.println(a++);	//여기서도 11이 먼저 대입된 후 하나 증가해서 12가 되는 것이므로 출력은 일단 11
		System.out.println(++a);	//위에서 a가 12가 되었는데 또 하나 
		
		//*****************//중요해!
		a=10;
		int b=++a;	//전치 증감연산자는 우선순위가 제일 높아서 =보다 먼저 수행된다.
		System.out.println(b);
		b= a++;	//후치 증감연산자는 우선순위가 제일 낮아진다.그래서 =을 수행한 후에 증가가 이루어진다.
		System.out.println(b);
		System.out.println(a);	//()안이 b가아니라 a로 찍어보면 이제 a가 11이아니라 1증가한 12임을 알 수 있다.
	}

}
