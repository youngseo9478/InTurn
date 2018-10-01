package day4_7;
/*익명내부클래스
 * 객체를 생성하려고 했을 떄 해당하는 클래스가 완벽한 형태여야함.->컴파일러에 클래스 이름으로 올라감
 * 완벽하지 않은 상태에서는 구현을 하는 시점에 객체를 생성함->컴파일러에 익명으로 올라감
 * 왜쓸까?
 * 1.abstract면 상속받아서 구현해야하는데 익명내부클래스를 이용하면 상속 안받아도 사용 가능.
 * 2.이렇게 해놓으면 객체인 멤버처럼 쓸 수 있다.
 * 
 * =>상속없이 멤버형태로 쓸 수 있다는 장점
 * */

abstract class TestAbst {
	int data = 10000;

	public abstract void printData(); // abstract method
}

public class AnnonymousInnerEx {

	TestAbst inn = new TestAbst() {
		public void printData() { //미완성된 것을 완성한다.
			System.out.println("data : " + data);
		}
	}; //세미콜론 꼭 찍어줘야한다. 원래는 new TestAbst(); 이것인데 미완성이라 여기서 중괄호로 묶어 구현 해주고 있기때문에 이게 끝나면 세미콜론으로 닫아줘야하는 것. 
	
	public static void main(String[] args)
	{
		AnnonymousInnerEx ai = new AnnonymousInnerEx();
		ai.inn.printData(); //inn이라는객체가 멤버형태로 쓰여진다.
	}
}
