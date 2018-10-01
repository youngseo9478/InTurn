package day4_7;
/*
 * 1.구현을 안해도 됨 
 * 클래스는 구현한것까지 객체를 생성하는데 ..익명클래스를 만들어서 미완성의 interface를 메소드에서 마저 구현하게 되면 
 * 그 메소드 안에서만 사용되고 메소드가 끝나면 할당되었던 메모리도 같이 해제되는것. 
 * 영구적인 형태가 아니라 일시적인 형태로 사용하는 것(사용빈도가 낮은데 메모리를 아예잡고있는게아니라 쓸때만 메모리 잡고 사용이끝나면 바로 해제해주는것) 
 * 2.표현력이 풍부해짐(interface를 마저 구현하는 클래스에서의 특징을 잘 나타낼 수 있음
 * 3.가독성이 좋아짐*/
interface TestInter
{
	final int DATA = 3000;
	
	public void printData();
	
}

class AnnonyInner2{
	public void test(String str)
	{
		new TestInter(){ //몸체가 완성되면 익명 클래스로 인식된다=> 객체가 되는 것.
			public void printData()
			{
				System.out.println(str+":data="+DATA);
			}
		}.printData();
	}
}

public class AnnonymousInnerEx2 {

	public static void main(String[] args)
	{
		new AnnonyInner2().test("kim");
	}
}
