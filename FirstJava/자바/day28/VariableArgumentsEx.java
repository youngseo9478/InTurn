package day28;

public class VariableArgumentsEx {

	/*public static int add(int num1, int num2)
	int result = 0;
	return result;*/ //static 붙여서 선언없이 바로 쓰려고!//이렇게하면 여러개는 같이 못더함
	public static int add(int ...num)
	{
		int result=0;
		for(int i=0; i<num.length;i++)	//매개변수의 개수가 무엇이든 배열로서 받아서 크기를 알 수 있음 이걸 for문 돌리면 모든 값을 더할 수 있게됨.
		{
			result += num[i];
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		System.out.println(add(1,2));
		System.out.println(add(1,2,3));	//에러남 ->The method add(int, int) in the type VariableArgumentsEx is not applicable for the arguments (int, int, int, int, int, int, int)
		System.out.println(add(1,2,3,4));
		System.out.println(add(1,2,3,4,5));
		System.out.println(add(1,2,3,4,5,6));	//여기에서 들어오는 가변적인 매개변수를 받기위해 for문장으로 그 크기만큼 돌림!
		System.out.println(add(1,2,3,4,5,6,7));		
	}
}
