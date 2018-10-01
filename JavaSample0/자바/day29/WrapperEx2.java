package day29;


//parse를 주로씀
public class WrapperEx2 {

	
	public static void main(String[] args)
	{
		int i = new Integer("100");//이게 객체 생성이 맞나요 ..? 앞에가 클래스 이름이 아니라 그냥 데이터형인데..
		int i2 = Integer.parseInt("100"); //10,11명시적인 형태 (오토박싱개념찾아보기)
		Integer i3 = Integer.valueOf("100");	//암시적인형태	//Integer클래스의 valueOf(String s)메소드를 이용해 문자열"100"을 숫자로 표현한걸 i3에 넣는데...
		//암시적인 형태의 예로는 String str = "원영서"; ->이것도 스트링 클래스를 바탕으로 str이라는 객체를만드는건데 new를 쓰지 않았음!
		//위의 형태도 이와 같이 암시적인 형태로 생성자를 생성한 것! 오른쪽의 결과는 int형으로 나오게되고 그 정수값이 i3에 대입되는 것.
		int i4 = Integer.parseInt("100",2);
		int i5 = Integer.parseInt("100",8);
		int i6 = Integer.parseInt("100",16);
		int i7 = Integer.parseInt("FF",16);
		
		int i8 = Integer.valueOf("100",2);
		int i9 = Integer.valueOf("100",8);
		int i10 = Integer.valueOf("100",16);
		int i11 = Integer.valueOf("FF",16);
		
		System.out.println(i);
		System.out.println(i2);
		System.out.println(i3);
		
		System.out.println("100(2) ->"+i4);
		System.out.println("100(8) ->"+i5);
		System.out.println("100(16)->"+i6);
		System.out.println("FF(16) ->"+i7);
		
		System.out.println("100(2) ->"+i8);
		System.out.println("100(8) ->"+i9);
		System.out.println("100(16)->"+i10);
		System.out.println("FF(16) ->"+i11);
	}
}
