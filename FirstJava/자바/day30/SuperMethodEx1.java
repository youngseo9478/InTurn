package day30;
/*
 * 생성자 호출은 생성하는 즉시 호출된다.

 * 
 * this() 내부참조할때 자기생성자 호출
 * super() 내부참조할때 부모생성자 호출
 * 
 * super 와 super() 
 * 슈퍼와 슈퍼메소드!
 * 
 * 
 * */

class SuperC
{
	String name;
	
	public SuperC(String name)//생성자와 메소드...
	{
		this.name = name;
	}
	
	public void printName()
	{
		System.out.println("name : "+name);
	}
}
/*이렇게하면 에러뜸 -> 부모의 superC는 이름을 받아야함.
 * 이름이 없기때문에 부모로부터 이름을 받으라고 에러가 뜨는것 */
class ChildC extends SuperC
{
	int age;
	//이게들어오면 에러가 안뜸
	public ChildC(String name, int age)
	{
		super(name); //생성자를 호출해서 슈퍼를 통해서 name을 꼭 넘겨줘야한다.
		this.age=age;//여기에 age 초기화안해주면 메인에서 값 넣고 객체 생성해서 출력해도 0이라고 뜬다.
	}
}

public class SuperMethodEx1 {
	public static void main(String [] args)
	{
		System.out.print("==========부모클래스===========");
		System.out.println();
		SuperC sc = new SuperC("김가");
		sc.printName();
		
		System.out.print("==========자식클래스===========");
		System.out.println();
		ChildC cc = new ChildC("이가", 33);
		cc.printName();
		System.out.println("age : "+cc.age);
	}
}
