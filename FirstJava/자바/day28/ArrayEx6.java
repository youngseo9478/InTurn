package day28;

public class ArrayEx6 {

	
	public static void main(String[] args)
	{
		int[] randArr = new int[10];
		for(int i=0; i<randArr.length;i++)
		{
			randArr[i] = i;
			System.out.print(randArr[i]);
		}
		System.out.println();
		
		for(int i=0; i<randArr.length; i++)
		{
			int n =(int)(Math.random()*10);
			int tmp = randArr[0];
			randArr[0]=randArr[n];	//선언할때 randArr의 크기가 10이기때문에 0~9가지의 인덱스가 있음 그러므로 난수발생*10하면 0~9중 한숫자가 나옴..
			randArr[n]=tmp;

		}
		System.out.println();
		//앞에 넣은 0123456789가 뒤죽박죽 섞이게 되는 것.
		for(int i=0; i<randArr.length; i++)
		{
			System.out.print(randArr[i]);
		}
		System.out.println();
	}
}
