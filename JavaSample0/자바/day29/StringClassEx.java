package day29;

/*명시적 생성과 암시적 생성의 차이
 * */

public class StringClassEx {

	public static void main(String[] args)
	{
		//암시적 생성
		String s1 = "Twinkle";	//얘도 역시 주소값이 다를텐데 왜 이건 결과가 같다고 나오는가?
		String s2 = "Twinkle";	//s1을 먼저 만들어서 객체의 주소값을 가지고 있다. 다음에 s2의 객체를 만들기 전에 암시적으로 생성하면 같은 객체가 있는지를 찾게된다.
								//s1의 객체가 이미 있으니 그 주소를 가지게 되는 것. 결국 같은 주소를 가지고 있다는 뜻.
		
		if(s1==s2)	//안에있는 내용물을 비교한게 아니라 주소를 비교한 것.
			System.out.println("s1과 s2는 같다.");
		else
			System.out.println("s1과 s2는 같지 않다");
			
		//명시적 생성
		String s3 = new String("Little Star");	//new 는 객체를 생성(힙)해서 주소값은 s3에 대입한다.
		String s4 = new String("Little Star");	//역시 다른 객체를 생성해서 주소값을 s4에 대입한다.
												//s3,s4는 서로 주소값이 다르기때문에 같지않다라고 결과가 출력되는것.
		
		
		//if(s3==s4)	//이렇게쓰면 *주소값*이 같냐고 묻는것.
		if(s3.equals(s4)) 	//얘가 뜻하는 건 s3,s4의 **내용물**을 비교하라는 것->이러면 같다라는 결과가 나온다 ->이런 API를 알려면 오라클에가서 찾아봐야함!
			System.out.println("s3과 s4는 같다.");
		else
			System.out.println("s3과 s4는 같지 않다");
	}
	
}
