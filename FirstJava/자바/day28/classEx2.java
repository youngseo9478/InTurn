package day28;
/*클래스
 * 자바의 가장 핵심! 객체지향의 성질을 나타내는 부분
 * 객체지향적인 언어 : 코드의 재사용
 * 	->유지보수에 용이
 * 클래스라고 하는 것은 C언어의 구조체와 비슷하다.
 * 		->구조체는 배열과 비슷한데 배열과 다르게 **다른타입**의 연속된 데이터!
 * 		->배열의 단점 : 실생활에 필요한 데이터를 표현하기가 어려움
 * 		->구조체는 ex)나이는 정수, 키는 실수, 이름은 문자열 등 함께 표현할 수 있음
 * 
 * 클래스 = 구조체 + function 으로 일부를 설명할 수 있음
 * 즉 데이터와 어떤 행위(메소드)를 같이 가지고 있다.
 * 변수, 상수 -> 데이터 -> 멤버필드
 * 메서드(동작) -> 메서드필드
 * 
 * 객체지향적 = 사물지향적(완벽하게는 아니지만 근접하게 표현할 수 있는 것.)
 * 1.클래스를 선언하는 방법 ->설계도면을 만드는 방법
 * 2.클래스를 이용해서 오브젝트 구현 및 이용방법 ->실제로 이용할 수 있게 만드는 방법
 * 
 * Class vs 객체
 * 클래스는 그냥 설계도면이고
 * 우리가 사용하려면 물리화가 되어있어야한다.->메모리에 들어가있어야함 (특정한 주소=위치 에)
 * 객체는 클래스를 바탕으로 특정한 주소 즉 메모리에 들어가 있는 것이다.
 * 그러므로 클래스와 객체는 다른것이다.
 * 
 * 인스턴스 ->메모리가 할당되어 있을 때(객체화되어야만)만 쓸 수 있는 작업을 인스턴스화(객체화)라고 한다.
 * 
 * 스택 - 변수, 메소드
 * 힙(공유해서 사용하는 메모리 영역) - 객체  ->자바에서 이영역은 알아서 해제 해준다(garbage collection).
 * 
 * new - > 객체만들때쓰는 것.
 * 
 * */

class Mp3p		//설계도면  아래 m3가 여기에 대입되는 것이 아니다!!
{
	String maker;
	int memorySize;
	
	public void setMaker(String m)
	{
		maker = m;
	}
	
	public void setMemorySize(int ms)
	{
		memorySize = ms;
	}
	
	public void printInfo()
	{
		System.out.println("maker : "+ maker);;
		System.out.println("memorySize : "+memorySize);
	}
}

public class classEx2 {
	
	public static void main(String[] args)
	{
		Mp3p m3 = new Mp3p();	// Mp3p 클래스를 바탕으로 객체를 만들라는 뜻
		m3.setMaker("samsung");
		m3.setMemorySize(256);
		m3.printInfo();
		
		Mp3p m4 = new Mp3p();
		m4.setMaker("apple");
		m4.setMemorySize(512);
		m4.printInfo();
		
	}
	
}
