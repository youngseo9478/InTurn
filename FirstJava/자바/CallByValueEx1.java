package day28;
/*call by value
 * 값을 보낼 때는 원본을 보내는 것이 아니라 복사본을 보내주는 것 .
 * 그러므로 그 값을 사용하는 곳에서 값이 바뀌더라도 복사본이 바뀔 뿐 원본이 바뀌는 것이 아님*/
public class CallByValueEx1 {

	public static void main(String[] args)
	{
		int value =10;
		int value2 = increaseNum(value);	//복사본을 주었을 뿐 (값)
		
		System.out.println("value : "+value); //원본에 해당하는 것은 변함없는 값을 가지고 있음  10
		System.out.println("value2 : "+value2);//복사본을 이용해 새로운 변수로인해 증가된 정수값을 받아서 대입시켰음 11
	}
	
	public static int increaseNum(int num)
	{
		++num;	//value의 주소를 받아온 것이 아니고 그냥 복사본 즉 10이라는 값만 가져온 것. 증가시켜도 원래 value를 변화시키는 것은 아니다***
		return num;	//위에서 1을 증가시킨 값을 보냄. 이 값을 받는 곳은 함수를 호출한곳으로 value2에 들어감.
	}
}
