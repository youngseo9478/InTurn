package day27;

public class FunctionEx1 {	
	/*함수(method)란?
	 * 함수는 우리가 값을 주거나 안주었을 때 무언가를해서 결과를 줄수도 있고 안줄수도있는 거..
	 * 반복되는걸 한곳에 모아놓고 코드를 재활용해서 사용할 수 있는 것*/
	
	public static void main(String[] args)
	{
		System.out.println(add(10,20));
		System.out.println(add(310,30));
		System.out.println(add(102,2560));
		System.out.println(add(1043,430));
		
		printName("김가");
	}
	
	public static int add(int a, int b)	//함수의 헤드에 해당.add가 함수명.add앞에 int가 return형. 여기서 int a,b가 매개변수(=전달받은인자) 
										//a,b는 함수블럭나오면 메모리에서 지워지는 변수(=지역변수)
	{
		int result = a+b;
		return result;
	}

	public static void printName(String name)		//void는 리턴값이 없다는 것.
	{
		System.out.println("name:"+name);
	}
}
