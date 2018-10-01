package day4_7;
/*로컬 내부 클래스
 * 클래스의 메소드 안에 클래스를 생성해서 사용하는 것.
 * 
 * 그냥 메소드처럼 쓰지 왜 굳이 클래스를 또 넣어서쓰는지?
 * ->이점이 굉장히 많음(뒤에서 설명)
 * 
 * 
 * (주의)같은 패키지에는 같은 이름의 클래스 이름이 들어가면 안됨! 
 * 메인은 파일이름으로 된 클래스에서 찾는다. 
 * */
class LocalInner
{
	int a=100;
	
	public void innerTest(int number)
	{
		int b =200;
		
		class Inner
		{
			public void printData()
			{
				System.out.println("a:"+a);
				System.out.println("b:"+b);
				System.out.println("number:"+number);
			}
		}
		Inner i = new Inner();
		i.printData();
	}
}

public class LocalInnerEx {
	
	public static void main(String[] args)
	{
		LocalInner li = new LocalInner();
		li.innerTest(3000);
	}

}
