package com.ex;

public class VariableEx3 { //float는 부동소수점. 소수점이하자리까지표현하는것

	public static void main(String[] args)
	{
		//float fValue = 3232.3232; //자바는 부동소수점 쓰면 더블로 인식함 그래서 에러나는것.
		double dValue =3232.3232; //이렇게하면 에러안남
		float fValue = 3232.3232f; //뒤에 f를 넣어주어야 float값으로 바껴서 에러가 안남
		System.out.println("fValue="+fValue);
		
		double dValue2 = 54545.5454545454; //큰값넣어도 ok
		System.out.println("dValue2="+dValue2);
	}
}
