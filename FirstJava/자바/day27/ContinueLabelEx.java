package day27;

public class ContinueLabelEx { 	//continue 는 
	
	public static void main(String[] args)
	{
		out:
		for(int i=2; i<10; i++)
		{
			for(int j=1; j<10; j++)
			{
				if(j==5)
				{
					//break;		//->(1~9)*4만 실행됨 (반복문을 멈추는거니까 j의 for문이 종료되고 나머지 수행한 후에 i로 가지는것.
					//break out; //->out레이블을 통째로 나가진다.
					//continue;	//->j의증감식으로 가짐 j==5만 빼고 수행되어짐.
					continue out;	//->i의 증감식으로 가짐. break와 결과가 비슷 무슨차이일까? 줄바꿈이 안일어남
				}
				System.out.println(i+"*"+j+"="+i*j);
			}
			System.out.println();
		}
	}

}
