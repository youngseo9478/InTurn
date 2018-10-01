package day28;

public class ArrayEx3 {

	public static void main(String[] args)
	{
		
		//배열을 만드는 다양한 방법
		
		int[] arrInt = new int[10];
		int[] arrInt2 = new int[10];
		int[] arrInt3 = new int[]{100,90,80,70,60,50}; 	//이건 크기를 명시하지 않은 경우! 6개짜리 배열을 만든것
		int[] arrInt4 = {100,90,80,70,60,50};	//바로 윗줄과 같은 코드 new int 안써도 오른쪽에 저렇게 초기화 할 수 있다! 단 선언할때만!!
		
		//arrInt5={100,90,80,70,60,50};	//에러!! 선언하고서 초기화하는 경우에는 이 방법으로 할 수 없다.
			//arrInt, arrInt2 등은 그냥 값이 아니라 !!주소값!!(힙에저장됨), 참조불가능!!  **일반적인 변수는 참조가 가능하다 (=참조변수! ->스택에 저장됨)
	}
}
