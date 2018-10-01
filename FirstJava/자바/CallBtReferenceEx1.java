package day28;
/*call by reference
 * */
public class CallBtReferenceEx1 {

	public static void increaseArr(int[] arr)	//배열의 주소값을 받았음 ->값만 준게 아니라 주소를 준 것.즉 여기서 변형시키면 원본에도 영향이 간다.
	{
		for(int i=0; i<arr.length; i++)
		{
			arr[i]+=1; //주소를 받아온 것이기 때문에 여기서 변형을 시키면 dataArr(원본)이 변함.
		}
	}
	
	public static void main(String[] args)
	{
		int[] dataArr = {1,2,3,4,5,6,7,8,9};	//dataArr은 주소값임
		increaseArr(dataArr); 	//주소값을 넣은것
		
		for(int i=0; i<dataArr.length; i++)
		{
			System.out.println(dataArr[i]);	//주소값을 보낸 함수에 의해 dataArr의 값들이 1씩 증가했기때문에 2,3,4,5,6,7,8,9,10으로 찍히게 된다.
		}
	}	
}
