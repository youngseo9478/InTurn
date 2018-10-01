package day3_7;
/*enum은 상수값을 모아서 쓸 때 사용
 * 보통 자바에서는 변수에 final 붙여서 상수만들어 씀.
 * final int MAX = 100; 이런식으로!
 * 근데 상수값이 많아지면 이렇게 쓰기 불편함
 * [Access Modifier] enum [enum name]{
 * Constant1, constant2...} 이렇게 만듬
 * 
 * GUI에서는 상수가 정말 많이 쓰임
 * 가독성이 높아짐
 * 그냥 0,1,2로 하면 그게 뭐였는지 모르겠는경우가 많기때문에 이렇게 상수로 만들어 주는 것이 편하다.
 * 타입은 정수인 것!
 * */

enum mouse 
{
	LEFT_CLICK, RIGHT_CLICK, DOUBLE_CLICK	//0,1,2가 되는 것
}

enum result
{
	RESULT_OK, RESULT_CANCEL, RESULT_ERROR
}

public class EnumEx1 {

	public static void main(String[] arsg)
	{
		System.out.println(mouse.LEFT_CLICK);
		mouse e = mouse.LEFT_CLICK;
		switch(e)
		{
		case LEFT_CLICK:
			System.out.println("mouse left click");
			break;
		case RIGHT_CLICK:
			System.out.println("mouse right click");
			break;
		}
		System.out.println("LEFT_CLICK의 정수 값:"+e.ordinal());//.ordinal이 값을 나타내게 해줌
		System.out.println("DOUBLE_CLICK의 정수 값:"+mouse.DOUBLE_CLICK.ordinal());//이렇게할수도있다.
		
		mouse[] numbers = mouse.values();//한꺼번에 모아찍는 방법
		for(mouse m : numbers)
		{
			System.out.println(m.ordinal()); 
		}
	}
}
