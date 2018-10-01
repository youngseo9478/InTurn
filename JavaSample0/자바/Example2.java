package day29;
//선택정렬
public class Example2 {

	public static void main(String[] args)
	{
		int random = 0;
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			random = (int) (Math.random() * 10);
			arr[i] = random;
		}
		System.out.println("난수 발생시킨 배열");
		for (int i = 0; i < arr.length; i++) {
			//System.out.print("arr[" + i + "] = " + arr[i]);
			System.out.print(arr[i]);
		}
		System.out.println();
		System.out.println("==========");
		
		int tmp =0;
		//i의 조건식이 중요한데 에러는 안났지만 <arr.length로하면 j가 arr[10]까지 비교해버리므로 
		//i<arr.length-1**********중요
		for(int i=0; i<arr.length-1; i++)
		{
			for(int j=i+1; j<arr.length; j++)
			{
				if(arr[j]<arr[i])
				{
					tmp=arr[j];
					arr[j]=arr[i];
					arr[i]=tmp;
				}
			}
		}
		
		System.out.println("오름차순으로 정렬된 배열");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}

	}
}
