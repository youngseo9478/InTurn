

abstract class Abs1
{
	String name;
	String firstName;
	abstract public void printName(); //몸체를 구성하지않고 세미콜론을 붙임 ->abstract를 표현해줘야함  -> 클래스 자체에도 abstract 해줘야함
}

class AbsKorImp extends Abs1	//밑에 몸체를 안쓰면 이런 에러가 뜸  The type AbsKorImp must implement the inherited abstract method Abs1.printName()
{
	
	public void printName()
	{
		System.out.println("name : "+firstName+name);//성 이름
	}
}

class AbsEngImp extends Abs1
{
	public void printName()
	{
		System.out.println("name :"+name+firstName);//이름 성
	}
}

public class AbstractKeywordEx2 {

	public static void main(String[] args)
	{
		AbsKorImp aki = new AbsKorImp();
		aki.firstName ="김";
		aki.name = "아무개";
		aki.printName();
		
		AbsEngImp aei = new AbsEngImp();
		aei.firstName ="김";
		aei.name = "아무개";
		aei.printName();
	}
}
