package day28;

public class ArrayEx2 {

	public static void main(String[] args)
	{
		int[] arrInt = new int[5];
		
		for(int i=0; i<=5; i++)	//에러!! 또 다른 경우는 i의 초기값을 1로 두는 경우도 있음->index는 0부터~!
		{
			arrInt[i]=i;	//마지막은 4번인것! 5번은 없는것!
		}
	}
}
