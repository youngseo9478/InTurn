package day27;

public class ControllerEx9 {	//while 문 ->조건이 참일때 블럭을 수행

	public static void main(String[] args)
	{
		int i=0;
		
		while(i<10)
		{
			System.out.println(i+"번째 실행");
			i++;
		}
		
		System.out.println("실행 종료");
		
		int j = 10;
		int result = 0;
		while(true)
		{
			result+=j;
			if(result>1000)
				break;
			j++;
		}
		System.out.println("result:"+result+", j:"+j);
	}
}
