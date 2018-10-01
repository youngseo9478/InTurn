package day30;
/*<Final>
 * 
 * 변수 앞에 final붙이면 마지막 수라는 의미해서 변하지 않는 수 만드는 것 -> **상수**만드는것!!
 * 메소드 앞에 final붙이면 (메소드는 재정의가 가능함 = 오버라이딩 가능) 재정의가 더이상 안됨!!
 * 클래스 앞에 final붙이면 상속 못받게 만드는 것
 * 
 * 왜쓸까? 변하게 해놓고 왜 못변하게 만드는 가?
 * 예) 출금이라는 메소드가 있는데 밑에서 오버라이딩할수 있으면 값이 변질될 수 있음 
 * 특정한 메소드는 어떤 일이 있어도 변하지 않게 해야하는 경우가 있음 . 클래스나 변수도 마찬가지 ->이런 특성이 있는 클래스 메소드 변수 등이 변할수있으면 해킹하기 딱좋아지는 것
 * 
 * */

class Parent
{
	//final int value = 10; 
	//여긴 더이상 값을 집어넣을 수 없다 상수라서! 그래서 메인에서 child 객체에 100넣으려고 하면 에러난다.
	int value;
	
	public void printValue()
	{
		System.out.println("value : "+value);
	}
	
	/*final public void printValue()
	{
		System.out.println("value : "+value);
	}
	이렇게 메소드에 final붙이면 오버라이딩이 불가능해진다.*/
}

class Child extends Parent
{
	int value2;
	public void printValue()
	{
		super.printValue();
		System.out.print("value2 : "+ value2);
	}
}

public class FinalEx1 {

	public static void main(String[] args)
	{
		Child c= new Child();
		c.value=100; //부모로부터 상속을 받았기 때문에 value에 값을 넣어줄 수 있음.부모클래스의 value앞에 final이 붙으면 여기서 값을 다시 대입할 수가 없음 ! 걔는 상수가 된거라서!!
		c.value2=200;
		c.printValue();
	}
}
