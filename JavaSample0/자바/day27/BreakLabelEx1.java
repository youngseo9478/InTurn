package day27;

public class BreakLabelEx1 {	//break label은 여러개를 빠져나오는 것.
	
	public static void main(String[] args)
	{
		int result = 0;
		forout:	//세미콜론아니고 콜론! 브레이크하면 묶인데 한번에 나가지는것
		for(int i=0; i<10; i++)
		{
			for(int j=0; j<10;j++)
			{
				for(int k=0; k<10; k++)
				{
					result +=k;
					if(result>1000)
					{
						System.out.printf("i:%d, j:%d, k:%d\n", i,j,k);
						break forout;
					}
						
				}
			}
		}
	
	System.out.println("result:"+result);
	}
}
