package day29;
/* ***생성자***
 * () 소괄호는 메소드를 호출할때 사용
 * 클래스에 생성자 없어도 컴파일러가 알아서 생성하기도 함
 * 예) Mp3p(); ->이게 생성자였다.
 * 생성자의 목적은 딱 한가지!! : 객체초기화
 * 		new:객체생성
 * 		객체를 생성을 하고 난 후 해당하는 생성자를 호출=>객체초기화
 * <특징>  보통 메소드는 매개변수가 있음 무언가 행동한거에대한 결과를 주기위해 리턴값이라는게 존재함(안할때도있음)
 * -리턴형 타입이 없다. -> 그냥 객체를 초기화할 뿐 뭔가 결과를 내는게 아니라서...? 
 * -생성자의 이름은 클래스의 이름하고 같다.
 * 
 * 이 코드 짤때 에러났었는데 그 이유는 public  class 안에다가 Con1클래스를 정의했기때문! 그렇게 하면 
 * 메인 클래스 안에서 생서자를 호출하는 것이 불가능*/

class Con1
{
	//이게 생성자!!
	public Con1()	//클래스 이름과 같다			매개변수 있어도 가능 Con1(String str)
	{
		name = "김가";								//name=str;
		System.out.println("생 성 자 호출");
	}
	
	String name;
	
	public void printName()
	{
		System.out.println("name : "+name);
	}
}

public class ConstructorEx1 {
	
	
	public static void main(String[] args)
	{
		Con1 c1 = new Con1(); //호출되자마자 바로 객체 생성됨		Con1("최자");
		//c1.name = "lee";
		c1.printName();
	}

}
