package day4_7;
/*정적내부클래스
 * static은 바로 메모리에 올라감->이미있기때문에 객체 생성할때 조금 다르다! new안써도 됨.
 * 안에 static이 있으면 그 클래스도 static이어야 한다.
 * 
 * */

//import day4_7.MemberInnerClass.Inner;

class StaticInner
{
	int a=100;
	int b=200;
	static int c = 300;
	
	static class Inner
	{
		static int d = 2000; //이 안의 static때문에 클래스도 static으로 만들어야 에러가 안남
		public void printData()
		{
			System.out.println("c: "+c);
			System.out.println("d: "+d);
			//System.out.println("a: "+a); ->instance variable이라서 여기서 사용 못한다
		}
	}
}

public class StaticInnerEx {

	public static void main(String[] args)
	{
		StaticInner.Inner inner = new StaticInner.Inner(); 
		//아까는 MemberInnerClass.Inner inner = new MemberInnerClass().new Inner(); 이렇게했는데
		//여기서는 static이라 이미 메모리에 올라가 있기때문에 new도 안쓰고 StaticInner에 ()도 안붙인다
		inner.printData();
	}
}
