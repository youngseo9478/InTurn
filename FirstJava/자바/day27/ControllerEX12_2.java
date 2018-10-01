package day27;

public class ControllerEX12_2 {//3.6.9게임 보완한거
	
	public static void main(String[] args)
	{
		for(int i=1;i<=100;i++)
		{
			System.out.print(i);	//짝을 같은 단락에 표현하기 위해서 역시 print로 출력!
			int tmp = i;
			
			do{
				if((tmp%10)%3==0 && tmp%10!=0)
					System.out.print(" 짝!"); //println이 아니라 print써서 단락을 바꾸지 않음
			}while((tmp/=10)!=0);	//33.36과같이 짝 두번쳐야하는 것 거르는 조건! 33/10은 3이기때문에 이걸 다시 do while써서 짝!
			System.out.println();
		}
	}

}
