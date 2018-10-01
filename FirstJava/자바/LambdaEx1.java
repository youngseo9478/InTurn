package day11_7;

interface MyFunction
{
	void run(); //public abstract void run();
}

public class LambdaEx1 {

	static void execute(MyFunction f)
	{//매개변수의 타입이 MyFunction인 메서드
		f.run();
	}
	
	static MyFunction getMyFunction()
	{//반환 타입이 MyFunction인 메서드
		MyFunction f = () -> System.out.println("f3.run()");
		return f;
	}
	
	public static void main(String[] args)
	{
		//람다식으로 MyFunction의 run()을 구현
		MyFunction f1 = () -> System.out.println("f1.run()");
		
		//익명클래스로 run()을 구현 =>이걸 람다식을 이용하면 위에처럼 줄일 수 있음을 비교해서 보여주는 것
		MyFunction f2 = new MyFunction() {
			public void run()
			{
				System.out.println("f2.run()");
			}
		};
		
		MyFunction f3 = getMyFunction();
		
		f1.run();
		f2.run();
		f3.run();
		
		execute(f1); 
		//f1객체도 결국 MyFunction클래스의 객체이므로 같은 메소드를 수행하게됨
		execute( ()->System.out.println("run()"));
		/*아무것도 써주지 않아도 MyFunction클래스는 인터페이스로 구현이 덜된 상태인데 
		 * 그 객체를 매개변수로 받는 execute를 수행하면 당연하게 그 객체의 run()으로 
		 * 가서 수행을 하게됨 => run()을 프린트하는게 run()메소드의 일인것!*/
	}
}
