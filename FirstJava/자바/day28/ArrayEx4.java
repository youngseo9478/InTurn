package day28;

public class ArrayEx4 {

	public static void main(String[] args)
	{
		int [] arrInt1 = new int[5]; 	//배열1을 5개짜리로 만들었다. arrInt1은 주소값을 갖고 있다.
		for(int i=0; i<arrInt1.length; i++)
		{
			arrInt1[i]=i;
		}
		
		int [] arrInt2 = arrInt1; 		//배열2에다가 배열1의 주소값을 넘겨준 것. ->결국 두 개는 같은 주소값을 가리키게된다. ***
		for(int i=0; i<arrInt2.length;i++)
		{
			System.out.println("arrInt2["+i+"] = "+arrInt2[i]);
		}
	}
}
