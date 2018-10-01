package day30;
/*abstract보다 더 추상적
 * interface(결합)
 * 상수랑 추상메소드만 가질 수 있다.
 * 몸체가 클래스에 의해 특정지어진다.
 * <특징>
 * 1.단일상속의 단점을 보완해줌
 * 2.다형성을 지원해줌 전혀 다른 클래스를 묶어서 사용할 수 있다.
 * <활용>
 * 1.기능에 대한 구현
 * 예)마우스가 있는데 바탕화면에서 우클릭, 아이콘에대고 우클릭, 웹브라우저에 우클릭 ->다 다른 결과 나옴  이게 인터페이스
 * 클릭이라는건 상수값으로 넣을 수 있고, 바탕화면클래스, 웹브라우저 클래스 등 사용되는 클래스에 따라 다르게 기능을 구현해야한다.
 * 구현부는 해당 클래스에 맡기는 것. 인터패이스는 클래스에 맞게끔 기능을 구현하는 것 이것은 상속이랑은 다르게 여러개를 같이 쓸 수 있다.
 * 
 * 2.연결에 의한 다형성유지 새로운 클래스들끼리 연결해주고싶을때
 * */
interface InterTest
{
	static final int A = 100;	//어차피 상수밖에 못가져서 final빼도 됨.
	abstract int getA();	//abstract 빼도 됨.
}
public class InterfaceEx1 implements InterTest 
{
	public int getA(){	//여기서 getA()를 구현해주는 것(기능구현)
		return A;
	}
	
	public static void main(String[] args)
	{
		InterfaceEx1 it1 = new InterfaceEx1();
		System.out.println("getA():"+it1.getA());
	}
	
}
