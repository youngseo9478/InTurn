package day30;
/*<Abstract Keyword>
 * 왜쓰는지는 아직 생각하지 말기!
 * 
 * 미완성적인 형태를 뜻함
 * 
 * 몸체가 없기때문에 설계도가 완성된게 아님 ->객체를 생성할 수 없음
 * <객체를 생성하는 방법>
 * 1.미완성인 클래스를 상속받으면 자식클래스가 미완성인 메소드도 가지고 있게됨 이거를 자식클래스에서 완성하는 것 ->객체를 만들 수 있다.
 * 		(자식클래스도 미완성인형태로 마무리될 수도 있지만 우리는 사용하려는거니까 완성되는방법을 예를 든것.)*/

abstract class Abs1
{
	String name;
	
	abstract public void printName(); //몸체를 구성하지않고 세미콜론을 붙임 ->abstract를 표현해줘야함  -> 클래스 자체에도 abstract 해줘야함
}

class AbsKorImp extends Abs1	//밑에 몸체를 안쓰면 이런 에러가 뜸  The type AbsKorImp must implement the inherited abstract method Abs1.printName()
{
	String firstName;
	
	public void printName()
	{
		System.out.println("name : "+firstName+name);
	}
}


public class AbstrctKeywordEx1 {

	public static void main(String[] args)
	{
		AbsKorImp aki = new AbsKorImp();
		aki.firstName ="김";
		aki.name = "아무개";
		aki.printName();
	}
}
