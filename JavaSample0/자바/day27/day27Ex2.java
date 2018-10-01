package day27;

public class day27Ex2 {	//별찍기 버전2 X자별찍기
	
	public static void main(String[] args)
	{
		for(int i=0;i<=10;i++)
		{
			for(int j=0;j<=10;j++ )
			{
				if(i==j || j==10-i)
				{
					System.out.print("*");
				}
				else
					System.out.print(" ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		// 더 효율적인 알고리즘
	 	int a,b;
	 	int n=10;
	 	int k=0;
	 	int l=n;
	 	
	 	for(a=0; a<=n; a++)
	 	{
	 		for(b=0; b<=n; b++)
	 		{
	 			String str = (b==k) | (b==l) ? "*" : " ";
	 			System.out.print(str);
	 		}
	 		k++;
	 		l--;
	 		
	 		System.out.println();
	 	}
	}
}
