package day29;
/*생성자도 오버로딩으로 만들 수 있다는 걸 보여주는 코드
 * 생성자의 매개변수 부분이 없는 것부터해서 한가지타입, 두가지타입, 게다가 순서까지 다르게 해서 만들어 놓으면
 * 매개변수부분만 알맞게 채워주면 같은 생성자 이름으로 호출할 수 있다.*/

public class MyClass2Test {		//이건 우리가 파일 만든 클래스 public class는 주체가 되는 것으로 하나만 존재해야한다.

	public static void main(String[] args)
	{
		MyClass2 mc1 = new MyClass2();
		MyClass2 mc2 = new MyClass2("2MB");
		MyClass2 mc3 = new MyClass2("2MB",46);
		MyClass2 mc4 = new MyClass2(46,"2MB");
		
		System.out.println(mc1.getName()+", "+mc1.getAge());
		System.out.println(mc2.getName()+", "+mc2.getAge());
		System.out.println(mc3.getName()+", "+mc3.getAge());
		System.out.println(mc4.getName()+", "+mc4.getAge());
	}
}

class MyClass2	//우리가 새롭게 정의한 클래스
{
	private String name;
	private int age;
	
	public MyClass2()
	{
		name = "www.itbank.kr";
	}
	
	public MyClass2(String n)
	{
		name = n;
	}
	
	public MyClass2(String n, int a)
	{
		age = a;
		name = n;
	}
	
	public MyClass2(int a, String n)
	{
		age =a;
		name = n;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getAge()
	{
		return age;
	}
}
