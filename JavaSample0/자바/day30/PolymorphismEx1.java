package day30;
/*<다형성 : polymorphism>
 * 
 * 장점!!! 일반화시킬 수 있다.
 *  
 * **전제조건**
 * 1.부모(조상)클래스의 변수는 자식클래스들의 주소를 저장할 수 있다. instance들은 자식의 주소을 받을 수 있다.
 * 2.자식 주소값을 받은 instance variable은 instance variable의 클래스가 정의된 부부만 보인다.
 *  ->조상클래스가 선언한 부분까지만 볼 수 있다는 것.*/

class One
{
	int valueOne;
	
	public void printOne()
	{
		System.out.println("valueOne : "+valueOne);
	}
}

class Two extends One
{
	int valueTwo;
	
	public void printTwo()
	{
		System.out.println("valueTwo : "+valueTwo);
	}
}

class Three extends Two
{
	int valueThree;
	public void printThree()
	{
		System.out.println("valueThree : "+valueThree);
	}
}

public class PolymorphismEx1 {

	public static void main(String[] args)
	{
		/*우리가 원래 쓰던 방식!
		One one = new One();
		one.valueOne = 1;
		one.printOne();
		
		Two two = new Two();
		two.valueTwo = 2;
		two.printTwo();
		
		Three three = new Three();
		three.valueThree = 3;
		three.printThree();*/
		
		One one1 = new One();
		One one2 = new Two();
		One one3 = new Three();
		
		/*에러난다
		 * Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
		valueTwo cannot be resolved or is not a field
		The method printTwo() is undefined for the type One
		
		도식화된걸로 보면 one2가 one,two모두 가지고는 있지만 쓸수는 없다
		왜냐하면 One클래스가 정의하고있는건 valueOne과 printOne만 정의하고 있기때문에 거기까지만 보인다.
		조상클래스가 선언한 부분까지만 볼 수 있다는 것.
		
		one2.valueOne = 10;
		one2.printOne();
		one2.valueTwo=20;
		one2.printTwo();
		*/
		
		//캐스팅 *****굉장히 중요
		//캐스팅 함으로써 가려져있던 two와 three부분을 보일 수 있게 된다. ->*일반화*시키는데 용이
		Two two1 = (Two)one2;
		two1.valueOne=200;
		two1.printOne();
		two1.valueOne=300;
		two1.printOne();
		
		Three three1 = (Three)one3;
		three1.valueOne=400;
		three1.printOne();
	}
}
