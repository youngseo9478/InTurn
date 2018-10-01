package day27;

public class ControllerEx8 { //구구단 

	public static void main(String[] args)
	{
		for(int i=2;i<=9;i++)
		{
			System.out.println(i+"단");
			for(int j=1;j<=9;j++)
			{
				System.out.println(i+"*"+j+"="+i*j);
			}
			System.out.println();	//단 나누기
		}
	}
}
