package day4_7;

public class MemberInnerClass {

	int a = 10;
	private int b = 100;
	static int c =200;
	
	class Inner{//Inner class definition
		public void printData(){
			System.out.println("int a : "+a);
			System.out.println("private b: "+b);
			System.out.println("static int c : "+c);
		}
	}
	
	public static void main(String[] args)
	{
		//MemberInner outer = new MemberInner(); ->이렇게 생성하면 안에 Inner클래스는 빼고 객체가 생성된다.
		//MemberInner.Inner inner = outer.new Inner();->먼저 멤버의 객체가 생성한 후 생성된 객체 outer를 이용해서 Inner의 객체를 만들 수 있다.
		//이렇게 하면 두번 거쳐야 하므로 번거로워서 아래와 같이 한번에 쓰는 방법을 주로 사용한다.
		MemberInnerClass.Inner inner = new MemberInnerClass().new Inner();
		inner.printData();
	}
}
