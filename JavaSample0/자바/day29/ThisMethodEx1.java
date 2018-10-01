package day29;



public class ThisMethodEx1 {

	String name;
	int age;
	String address;
	
	//생서자를 오버로딩 시킬 것임
	
	public ThisMethodEx1()
	{
		name = "noname";
		age =10;
		address = "noaddress";
	}
	
	/*public ThisMethodEx1(String name)
	{
		this.name= name;
		age = 10;
		address = "noaddress"
	}  위에 코드와 중복이 너무 많음 줄여주면 아래처럼!*/
	
	
	public ThisMethodEx1(String name)
	{
		this(name,10,"noaddress");	//코드의 중복을 없애주는데 용이하다
	}
	
	public ThisMethodEx1(String name, int age)
	{
		this(name, age,"noaddress");
	}
	
	public ThisMethodEx1(String name, int age, String address)		//여기다가는 this(name, age,adress); 이렇게만 쓰면 안됨
	{																//뭘하라는건지 알 수 없기때문에 다음과 같이 풀어서 써줘야 한다.
		
		this.name= name;
		this.age= age;
		this.address= address;
	}
	
	public void printData()
	{
		System.out.println("name :"+name+", age :"+age+", address :"+address);
	}
	
	
	public static void main(String[] args)
	{
		ThisMethodEx1 t1 = new ThisMethodEx1();
		ThisMethodEx1 t2 = new ThisMethodEx1("kim");
		ThisMethodEx1 t3 = new ThisMethodEx1("lee", 22);
		ThisMethodEx1 t4 = new ThisMethodEx1("choi",33,"seoul");
		
		t1.printData();
		t2.printData();
		t3.printData();
		t4.printData();
		
	}
}
