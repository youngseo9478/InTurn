package day30;
class Product
{
	int price;	//제품가격
	int bonusPoint;//적립포인트
	
	Product(int price)
	{
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
	
}

class Tv extends Product
{
	Tv()
	{//조상클래스의 생성자 Product(int price)를 호출한다.
		super(100); //Tv의 가격을 100만원으로 한다.
	}
	
	public String toString()
	{//Object클래스읭 toString()을 오버라이딩한다(재정의)
		return "Tv";
	}
}

class Computer extends Product
{
	Computer()
	{
		super(200);
	}
	
	public String toString()
	{
		return "Computer";
	}
}

class Audio extends Product
{
	Audio()
	{
		super(50);
	}
	public String toString()
	{
		return "Audio"; 
	}
}

class Buyer	//고객
{
	int money =1000;//가진돈
	int bonusPoint = 0;//보너스점수초기화
	Product[] item = new Product[10]; //구입한 제품을 저장하기 위한 배열
	int i=0;
	
	void buy(Product p) //다형성** p가 어떤형태로 들어올지 모르는데 이렇게 받으면 뭐뭐샀는지 알 수 있음
	{
		if(money<p.price)
		{
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return ;
		}
		
		money -= p.price;	//가진 돈에서 구입한 제품의 가격을 뺀다.
		bonusPoint +=p.bonusPoint;
		item[i++]=p;
		System.out.println(p+"을/를 구입하셨습니다.");
	}
	
	void summary()				// 구매한 물품에 대한 정보를 요약해서 보여준다
	{									
		int sum =0;				//구입한 물품의 가격합계
		String itemList ="";	//구입한 물품 목록
		
		//반복문을 이용해서 구입한 물품의 총 가격과 목록을 만든다.
		for(int i=0; i<item.length;i++)
		{
			if(item[i]==null) break;
			sum+=item[i].price;
			itemList += item[i]+",";
		}
		System.out.println("구입하신 물품의 총 금액은 "+sum+" 만원입니다.");
		System.out.println("구입하신 제품은 "+itemList+"입니다.");
	}
}


public class PolymorphismGeneric {

	public static void main(String[] args)
	{
		Buyer b = new Buyer();
		b.buy(new Tv());	//다형성으로 자식클래스인 Tv가 부모클래스인 Product로 받은것.
		b.buy(new Computer());	//위에 buy메소드구조를 보면 Product p = new Tv(); 형태를 갖는다는 걸 알 수 있는데 이게 바로 다형성이다.
		b.buy(new Audio());
		b.summary();
		System.out.print("=========================");
		System.out.println();
		System.out.println("현재 남은 돈은 "+b.money + "만원입니다.");
		System.out.println("현재 보너스 점수는 "+b.bonusPoint + "점입니다.");
	}
}
