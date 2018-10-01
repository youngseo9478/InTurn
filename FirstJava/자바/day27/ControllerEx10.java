package day27;

public class ControllerEx10 {	//while 이용한 구구단

	public static void main(String[] args)
	{
		int i=2;
		while(i<10)
		{
			System.out.println(i+"단");
			int j=1;	//j가 여기서 초기화되어야하는 이유는 다시 1이 되어야 3,4,...,9단을 계산하기때문
			while(j<10)
			{
				System.out.println(i+"*"+j+"="+i*j);
				j++;
			}
			i++;
			System.out.println();
		}
	}
}
