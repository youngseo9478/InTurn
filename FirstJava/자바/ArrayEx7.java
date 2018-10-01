package day28;

public class ArrayEx7 {

	/*
	 * 다차원배열 a[][] -> a[행][열]
	 */

	public static void main(String[] args) {
		int[][] arrInt = new int[2][3];
		int count = 1;
		for (int i = 0; i < arrInt.length; i++) // arrInt의 length는 2 그림을 생각해보면
												// 됨. 두개의 큰 메모리안에 3개짜리 배열이 있는 그림
												// 생각!
		{
			for (int j = 0; j < arrInt[i].length; j++)// 여기의 length는 3. 예를들어
														// length[0].length라고하면
														// 두개의 큰메모리 중 한칸을 들여다봤을때
														// 3개짜리 배열의 시작을 가리킴
			{
				arrInt[i][j] = count++;
			}
		}
		for (int i = 0; i < arrInt.length; i++) {
			for (int j = 0; j < arrInt[i].length; j++) {
				System.out.println(arrInt[i][j]);
			}
		}
		//////////////////////// for(type 변수 : 배열) 인덱스값안쓰고 안에 값들만 나열할때 사용. 요즘 언어는 거의다 이렇게 사용
		
		System.out.println("================for 문 사용");

		int[] arrInt3 = { 1, 2, 3, 4, 5, 6, 7 };
		for (int temp : arrInt3) // int으로 선언하는 이유는 배열3의 하나하나의 값의 해당하는 데이터형이
									// int이기 때문
		{
			System.out.println(temp);
		}
		//////////////////////////
		System.out.println("================다차원 배열 for문 사용");
		int[][] arrInt2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } }; // 이건
																						// 4X3행렬.

		for (int[] temp1 : arrInt2) // 템프는 배열2의 기본요소하나를 받는거..{1,2,3} ,{4,5,6}
									// 이런거 하나가 들어가는거! 데이터 타입이 정수 어레이 형태!
		{
			for (int temp2 : temp1) {	//템프1에는 어레이 하나씩이 들어있으므로 이걸 이형태로 나타내면 템프1속 4개의 3개짜리배열이 각각 들어가있고 
										//이렇게 한번더 포문안에 넣어주면 3개짜리 배열의 각각의 값이 템프2로 들어가는거!******
				System.out.println(temp2);//템프2를 찍으면 개개의 값들이 쭉 나오는것
			}
		}

	}
}
