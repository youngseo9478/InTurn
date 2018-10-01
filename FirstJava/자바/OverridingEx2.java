package day30;
/*오버로딩은 사용할 매소드를 여러가지로 정의해서 다양한 매개변수를 받을 수 있게 해놓은 것이고
 * 오버라이딩은 무모로부터 상속받은 클래스에 기능을 추가하고싶을 때 재정의를 해놓은 것이다.
 * 
 * <오버라이딩>
 * 부모클래스가 지금 내가 하려던 기능을 완전히 지원을 못해줌 
 * 그러면 부모는 하던거 하고 내가 필요한거를 추가해서 사용하는것.*/

class Point2D
{
	int xPoint;
	int yPoint;
	
	public Point2D() //생성한적 없는데 선언과 동시에 호출이 바로 이루어져서 실행해보면 이 문구가 찍히게 됨
	{
		System.out.println("point2D 생성자"); 
	}
	
	public Point2D(int xPoint, int yPoint)
	{	
		this.xPoint = xPoint;
		this.yPoint = yPoint;
	}
	
	public void printPoint()
	{
		System.out.println("xPoint : "+ xPoint);
		System.out.println("yPoint : "+ yPoint);
	}
}

class Point3D extends Point2D //2D를 상속받았기때문에 x,y값은 가지고 있다.
{
	int zPoint;		//print3DPoint 라고 하면 나중에 헷갈릴수가있음 그래서 이름을 동일하게!
	
	public Point3D() //생성한적 없는데 선언과 동시에 호출이 바로 이루어져서 실행해보면 이 문구가 찍히게 됨
	{
		System.out.println("Point3D 생성자");
	}
	
	public Point3D(int xPoint, int yPoint, int zPoint)	//위와 다르게 매개변수가 있는 형태. 매개변수가 int형 3개니까 밑에서 객체 생성할때도 정수 3개 넣어줳야함!
	{
		//super.printPoint(); 이게 아니라!!
		super(xPoint,yPoint); //부모클래스의 주소값을 가지니까 거기서 x,y의 값을 거기에다 받는거..?
		this.zPoint =zPoint;
	}
	
	public void printPoint() //이름은 같은데 z좌표가 추가됨  ->매개변수가 없는게 똑같아야함 (헤더가똑같아야함)  ->오버로딩에서는 매개변수의 타입,개수,순서의 차이가 있어야했던거과 다름!!
	{
		//System.out.println("xPoint : "+ xPoint);
		//System.out.println("yPoint : "+ yPoint);
		//이렇게 중복되서 쓰면 귀찮으니까 ->너의 기능에다가 새로운 기능만 입힐게~ 하는 것.
		super.printPoint();		//->내부참조 할 때 부모의 주소를 가리키는 것. ->이것도 아예 빼면 z값만 찍게됨
		System.out.println("zPoint : "+ zPoint);
	}
}

public class OverridingEx2 {

	public static void main(String [] args)
	{
		/*객체생성을 두개 해준것! 하나는 매개변수 있는 형태 하나는 매개변수 없는 형태 ->오버로딩!! 객체를 생성할때 다양한 상태로 초기화하기위해서이다.
		 * 1.객체이름은 서로 다르게 지정해 주어야 한다.
		 * 2. 출력도 두번 (객체명을 다르게 표현해서) */
		Point3D p3 = new Point3D(); 
		Point3D p3d = new Point3D(50,50,50); //객체 생성! 여기서 아까 위에 3개의 정수형 매개변수 받으니까 여기에 정수값 3개 넣어주는 것.
		System.out.print("==========매개변수 없는 것===========");
		System.out.println();
		p3.xPoint =100;	//부모클래스로부터 상속받은 x값에다가 100을 넣은것
		p3.yPoint=200;	//부모클래스로부터 상속받은 y값에다가 200을 넣은것
		p3.zPoint=300;	//자식클래스의 z값에다가 300을 넣은것
		p3.printPoint();
		System.out.print("==========매개변수를 지정해준 것===========");
		System.out.println();
		p3d.printPoint();
		
	}
}
